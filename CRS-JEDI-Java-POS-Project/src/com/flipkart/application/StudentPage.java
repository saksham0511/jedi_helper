package com.flipkart.application;

/*register for course
Add course
Drop course
view grade card
pay fees
 */


import com.flipkart.operations.*;

import java.util.Scanner;

public class StudentPage {
    static String frameTop = "\n--------------------------------------------WELCOME TO COURSE REGISTRATION SYSTEM-------------------------------------------------------";
    static String frameBottom = "----------------------------------------------------------------------------------------------------------------------------------------";
    static String space = "                                             ";
    static String option = space + "Option : ";
    static String exit = "--------------------------------------------------------------EXIT----------------------------------------------------------------------";
    StudentInterface studentOperations;
    CourseInterface courseOperations;
    CourseRegistrationInterface courseRegistrationOperations;
    GradeCardInterface gradeCardOperations;
    CourseCatalogInterface courseCatalogOperations;
    public void activity(int studId){

        studentOperations = new StudentOperations();
        courseOperations = new CourseOperations();
        courseRegistrationOperations = new CourseRegistrationOperations();
        gradeCardOperations = new GradeCardOperations();
        courseCatalogOperations = new CourseCatalogOperations();
        System.out.println(frameTop);
        while(true) {
            System.out.println(space + "select an option from below\n");
            System.out.println(space +
                    "1.Add course\n" +
                    space + "2.Drop course\n" +
                    space + "3.Register Course\n" +
                    space + "4.View Grades\n" +
                    space + "5.Pay Fees\n" +
                    space + "6. View Catalog\n");
            Scanner sc = new Scanner(System.in);
            System.out.print(option);

            int choice = sc.nextInt();
            System.out.println(frameBottom);

            System.out.println(frameTop);
            switch (choice) {
                case 1:
                    System.out.print(space + "enter course ID to add : ");
                    int addCourseId = sc.nextInt();
                    int status = -1;
                    if (courseOperations.isCourseAvailable(addCourseId)) {
                        status = studentOperations.addCourse(addCourseId);
                    }
                    if (status == -1) {
                        System.out.println(space + "Course not added");
                    } else {
                        System.out.println(space + "Course added successfully");
                    }
                    break;
                case 2:
                    System.out.print(space + "enter course ID to drop : ");
                    int dropCourseId = sc.nextInt();
                    boolean dropStatus = false;
                    dropStatus = studentOperations.dropCourse(dropCourseId);
                    if (!dropStatus) {
                        System.out.println(space + "Course not dropped");
                    } else {
                        System.out.println(space + "Course dropped succesfully");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    System.out.print(space + "enter student ID to view grades : ");
                    int studentId = sc.nextInt();
                    gradeCardOperations.viewGrades(studentId);
                    break;
                case 5:
                    break;
                case 6:
                    courseCatalogOperations.viewCatalog();
                    break;
                default:
                    System.out.println(space + "Invalid Action");
                    break;
            }
            System.out.print(space + "Do you want to continue as student(Y/N) : ");
            String Continue = sc.next();
            if (Continue.equals("N")) {
                System.out.println(exit);
                break;
            }
            System.out.println(frameBottom);
        }
    };
}
