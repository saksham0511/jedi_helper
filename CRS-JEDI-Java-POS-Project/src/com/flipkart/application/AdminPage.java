package com.flipkart.application;


import com.flipkart.bean.Student;
import com.flipkart.constant.BankEnum;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentModeEnum;
import com.flipkart.exception.*;
import com.flipkart.operations.*;

import java.util.List;
import java.util.Scanner;

public class AdminPage {
    CourseCatalogInterface courseCatalogOperations;
    AdminInterface adminOperations;
    static String frameTop = "\n--------------------------------------------WELCOME TO COURSE REGISTRATION SYSTEM-------------------------------------------------------";
    static String frameBottom = "----------------------------------------------------------------------------------------------------------------------------------------";
    static String space = "                                             ";
    static String option = space + "Option : ";
    static String exit = "--------------------------------------------------------------EXIT----------------------------------------------------------------------";

    /**
     * This method is used to select from Admin operations
     * @throws ProfessorAlreadyExistException
     * @throws CourseAlreadyExistException
     * @throws CourseRemovalFailedException
     * @throws ApprovalFailedException
     * @throws ProfessorRemovalFailedException
     */

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
                    space + "5.Remove Professor\n" +
                     space+ "6.View Unapproved Students\n"+
                    space+"7.Approve Student Fees\n");
            Scanner sc = new Scanner(System.in);
            System.out.print(option);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.print(space + "Enter course name to add : ");
                        String addCourseName = sc.next();
                        System.out.print(space+"Enter Course Fees: ");
                        int fees = sc.nextInt();
                        int id = -1;
                        id = adminOperations.addNewCourse(addCourseName,fees);
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
                case 3:
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
                        System.out.print(space + "Enter professor ID to remove : ");
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
                case 6:
                    unapprovedStudent();
                    break;
                case 7:
                    approveStudentFees();
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

    /**
     * Method to display list of unapproved students
     */
    private void unapprovedStudent(){
        AdminInterface adminInterface = new AdminOperations();
        List<Student> studentList = adminInterface.unApprovedStudent();
        System.out.println(space+"UnApproved Student");
        System.out.println(space+"-----------------------------------------------------");
        System.out.println(space+"Student ID"+"        "+"Student Name"+"        "+"Student Email"+"        "+"Student Address");
        for (Student student: studentList){
            System.out.print(space+student.getUserId()+"        ");
            System.out.print(student.getName()+"        ");
            System.out.print(student.getEmail()+"        ");
            System.out.println(student.getAddress());
        }
    }

    /**
     * This method is used to approve fee payment of student
     */
    private void approveStudentFees(){
        System.out.print(space+"Enter Student ID:");
        Scanner sc = new Scanner(System.in);
        int studentId = sc.nextInt();
        CourseRegistrationInterface courseRegistrationInterface = new CourseRegistrationOperations();
        int check = courseRegistrationInterface.numOfRegisteredCourses(studentId);
        if (check==0){
            System.out.println(space+"Student Registration is Pending");
            return;
        }
        StudentInterface studentInterface = new StudentOperations();
        boolean checkFeePaid = studentInterface.isFeefeespaidDB(studentId);
        if (checkFeePaid){
            System.out.println(space+"Student Fees is Already Paid");
            return;
        }
        PaymentInterface paymentInterface = new PaymentOperations();
        int amount = paymentInterface.getPayment(studentId);
        NotificationInterface notificationInterface = new NotificationOperations();
        int status = notificationInterface.sendNotification(NotificationType.PAYMENT,studentId, PaymentModeEnum.OFFLINE, BankEnum.CASH,amount);
        if (status!=0){
            System.out.println(space+"Student Approval Successful");
            System.out.println(space+"Reference ID:"+status);
        }
        else {
            System.out.println(space+"Student Approval Unsuccessful. Try Again!");
        }
    }
}
