package com.flipkart.application;

/*
add course
remove course
add professor
remove professor
approve student
approve grades
 */


import com.flipkart.exception.*;
import com.flipkart.operations.AdminInterface;
import com.flipkart.operations.AdminOperations;
import com.flipkart.operations.CourseCatalogInterface;
import com.flipkart.operations.CourseCatalogOperations;

import java.util.Scanner;

public class AdminPage {
    CourseCatalogInterface courseCatalogOperations;
    AdminInterface adminOperations;
    static String frameTop = "\n--------------------------------------------WELCOME TO COURSE REGISTRATION SYSTEM-------------------------------------------------------";
    static String frameBottom = "----------------------------------------------------------------------------------------------------------------------------------------";
    static String space = "                                             ";
    static String option = space + "Option : ";
    static String exit = "--------------------------------------------------------------EXIT----------------------------------------------------------------------";
    public void activity() throws ProfessorAlreadyExistException, CourseAlreadyExistException, CourseRemovalFailedException, ApprovalFailedException, ProfessorRemovalFailedException {

        courseCatalogOperations = new CourseCatalogOperations();
        adminOperations = new AdminOperations();
        while (true) {
            System.out.println(frameTop);
            System.out.println(space + "select an option from below\n");
            System.out.println(space +
                    "1.Add course\n" +
                    space + "2.Remove course\n" +
                    space + "3.Approve Student\n" +
                    space + "4.Add Professor\n" +
                    space + "5.Remove Professor\n");
            Scanner sc = new Scanner(System.in);
            System.out.print(option);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.print(space + "Enter course name to add : ");
                        String addCourseName = sc.next();
                        int id = -1;
                        id = adminOperations.addNewCourse(addCourseName);
                        if (id == 1) {
                            System.out.println(space + "Course added successfully");
                        }

                    }
                    catch(CourseAlreadyExistException ex){
                        System.out.println(space + ex.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.print(space + "Enter course ID to remove : ");
                        int removeCourseID = sc.nextInt();
                        boolean removeStatus = false;
                        removeStatus = adminOperations.removeCourse(removeCourseID);
                        if (removeStatus == true) {
                            System.out.println(space + "course removed successfully");
                        }

                    }
                    catch(CourseRemovalFailedException ex){
                        System.out.println(space + ex.getMessage());
                    }
                    break;
                case 3: //Approve student
                    try {
                        boolean status = false;
                        status = adminOperations.approveStudent();
                        if (status == true) {
                            System.out.println(space + "Student approval successful");
                        }

                    }
                    catch (ApprovalFailedException ex){
                        System.out.println(space + ex.getMessage());

                    }
                    break;

                case 4:
                    try {
                        System.out.print(space + "Enter Professor name : ");
                        String professorName = sc.next();
                        System.out.print(space + "Enter Professor email address : ");
                        String email = sc.next();
                        System.out.print(space + "Enter Professor address : ");
                        String address = sc.next();
                        String password = "password";
                        int profId = adminOperations.addProfessor(professorName, email, address, password);
                        if (profId == 1) {
                            System.out.println(space + "Professor added successfully");
                        }

                    }
                    catch(ProfessorAlreadyExistException ex){
                        System.out.println(space + ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.print(space + "Enter professor ID to remove");
                        int profID = sc.nextInt();
                        boolean profRemoveStatus = false;
                        profRemoveStatus = adminOperations.removeProfessor(profID);
                        if (profRemoveStatus == true) {
                            System.out.println(space + "Professor removed successfully");
                        }
                    }
                    catch(ProfessorRemovalFailedException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println(space + "Invalid Action");
                    break;

            }
            System.out.print(space + "Do you want to continue as Admin(Y/N) : ");
            String Continue = sc.next();
            if (Continue.equals("N")) {
                System.out.println(exit);
                break;
            }
        }
        System.out.println(frameBottom);
    }


}
