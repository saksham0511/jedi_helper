package com.flipkart.application;

import com.flipkart.exception.*;

import java.util.Scanner;

public class CRSApplicationMain {
    static String frameTop = "\n--------------------------------------------WELCOME TO COURSE REGISTRATION SYSTEM-------------------------------------------------------";
    static String frameBottom = "----------------------------------------------------------------------------------------------------------------------------------------";
    static String space = "                                             ";
    static String option = space + "Option : ";
    public static void helper() throws CourseRemovalFailedException, ProfessorAlreadyExistException, CourseAlreadyExistException, ApprovalFailedException, ProfessorRemovalFailedException {
        System.out.println(frameTop);
        System.out.println(space + "login / signup");
        System.out.print(option);
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch(choice){
            case "login" : LoginAndSignupPage.login();
                break;
            case "signup" : LoginAndSignupPage.signUp();
                break;
            default : System.out.println("Invalid");
                break;
        }
    }
    public static void main(String[] args) throws CourseRemovalFailedException, ProfessorAlreadyExistException, CourseAlreadyExistException, ApprovalFailedException, ProfessorRemovalFailedException {
        helper();
    }
}
