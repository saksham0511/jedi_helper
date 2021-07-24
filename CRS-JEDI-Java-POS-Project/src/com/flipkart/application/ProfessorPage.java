package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
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
    ProfessorInterface professorOperations;
    CourseCatalogInterface courseCatalogOperations;
    public void activity(int profId) throws SQLException {
        professorOperations = new ProfessorOperations();
        courseCatalogOperations = new CourseCatalogOperations();

        System.out.println("select an option from below\n");
        System.out.println("" +
                "1.Select Course to Teach\n" +
                "2.View Enrolled Students\n" +
                "3.View Catalog\n" +
                "4.Add Grades\n"
            );
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                System.out.println("enter course ID to teach");
                int courseIdToTeach = sc.nextInt();
                boolean status = false;
                status = professorOperations.teachCourse(profId, courseIdToTeach);
                if(status == false){
                    System.out.println("Course is not alloted");
                }
                else{
                    System.out.println("Course allotment is successful");
                }
                break;
            case 2: System.out.println("enter course ID to view enrolled students");
                    int courseIdToViewStudents = sc.nextInt();
                    List<Student> studentList = new ArrayList<>();
                    studentList = professorOperations.getEnrolledStudents(courseIdToViewStudents);
                    for(Student student : studentList){
                        System.out.println(student.getUserId());
                    }
                    break;
            case 3:
                List<Course> courseList = new ArrayList<>();
                courseList = courseCatalogOperations.viewCatalog();
                for (Course course : courseList){
                    System.out.println(course.getCourseId() + " " + course.getCourseName() + " " + course.getProfessorId());
                }
                break;
            case 4:
                System.out.println("enter student ID to add grade");
                int studentId = sc.nextInt();
                System.out.println("enter course ID to add grade");
                int courseIdToAddGrade = sc.nextInt();
                System.out.println("enter grade");
                String grade = sc.next();
                boolean gradeStatus = false;
                gradeStatus = professorOperations.addGrades( studentId,courseIdToAddGrade, grade);
                if(gradeStatus == false){
                    System.out.println("Grade not added");
                }
                else{
                    System.out.println("Grade added succesfully");
                }
                break;
            default : System.out.println("Invalid Action");
                break;
        }

        }
}
