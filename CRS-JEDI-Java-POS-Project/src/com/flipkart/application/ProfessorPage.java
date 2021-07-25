package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.operations.CourseCatalogInterface;
import com.flipkart.operations.CourseCatalogOperations;
import com.flipkart.operations.ProfessorInterface;
import com.flipkart.operations.ProfessorOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
select course to teach
view enrolled students
add grades
view courses
 */
public class ProfessorPage {
    static String space = "                                             ";
    static String space2 = "                                   ";
    ProfessorInterface professorOperations;
    CourseCatalogInterface courseCatalogOperations;
    public void activity(int profId) throws SQLException {

        professorOperations = new ProfessorOperations();
        courseCatalogOperations = new CourseCatalogOperations();
        System.out.println(space + "select an option from below\n");
        System.out.println("" +
                space + "1.Select Course to Teach\n" +
                space + "2.View Enrolled Students\n" +
                space + "3.View Catalog\n" +
                space + "4.Add Grades\n"
            );
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                teachCourse(profId);
                break;

            case 2:
                viewEnrolledStudents(profId);
                break;

            case 3:
                viewCatalog(profId);
                break;

            case 4:
                addGrades(profId);
                break;

            default:
                System.out.println("Invalid Action");
                break;
        }
    }

    private void teachCourse(int profId){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(space + "enter course ID to teach");
            int courseIdToTeach = sc.nextInt();
            boolean status = false;
            status = professorOperations.teachCourse(profId, courseIdToTeach);
            if (status == false) {
                System.out.println(space + "Course is not alloted");
            } else {
                System.out.println(space + "Course allotment is successful");
            }
        }
        catch(Exception e){
            System.out.println(space + "Could not add a course to teach, exception occurred :" + e.getMessage());
        }
    }

    private void viewEnrolledStudents(int profId){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(space + "Enter course ID to view enrolled students");
            int courseIdToViewStudents = sc.nextInt();
            List<Student> studentList = new ArrayList<>();
            studentList = professorOperations.getEnrolledStudents(courseIdToViewStudents);
            System.out.println(space + "Student ID" + space2 + "Student Name");
            for (Student student : studentList) {
                System.out.println(space + student.getUserId() + space + student.getName());
            }
        }
        catch(Exception e){
            System.out.println(space +"Could not view enrolled students list, exception occurred with message : " + e.getMessage());
            }
    }

    private void viewCatalog(int profId){
        try {
            List<Course> courseList = new ArrayList<>();
            courseList = courseCatalogOperations.viewCatalog();
            System.out.println(space + "Course ID" + space2 + "Course Name" + space2 + "Professor ID");
            for (Course course : courseList) {
                System.out.println(space + course.getCourseId() + space + course.getCourseName() + space + course.getProfessorId());
            }
        }
        catch(Exception e){
            System.out.println(space + "SQL Exception occurred with message" + e.getMessage());
        }
    }

    private void addGrades(int profId){
        Scanner sc = new Scanner(System.in);
        System.out.println(space + "enter student ID to add grade");
        int studentId = sc.nextInt();
        System.out.println(space + "enter course ID to add grade");
        int courseIdToAddGrade = sc.nextInt();
        System.out.println(space + "enter grade");
        String grade = sc.next();
        boolean gradeStatus = false;
        try{
            gradeStatus = professorOperations.addGrades(studentId, courseIdToAddGrade, grade);
            if (gradeStatus == false) {
                System.out.println(space + "Grade not added");
            } else {
                System.out.println(space + "Grade added succesfully");
            }
        }
        catch(GradeNotAddedException e){
            System.out.println(space + "Grades not added of the Student with ID : " + e.getMessage());
        }
    }

}
