package com.flipkart.operations;


import com.flipkart.DAO.AdminDB;
import com.flipkart.DAO.AdminDBInterface;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.ArrayList;
import java.util.List;

public class AdminOperations implements AdminInterface {

    AdminDBInterface adminDBInterface;

    @Override
    public boolean approveStudent() throws ApprovalFailedException {
        try {
            adminDBInterface = new AdminDB();
            return adminDBInterface.approveStudentDB();

        }
        catch (Exception ob){
            throw ob;
        }

    }

    @Override
    public boolean removeProfessor(int profId) throws ProfessorRemovalFailedException {
        try {
            adminDBInterface = new AdminDB();
            return adminDBInterface.removeProfessorDB(profId);
        }
        catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public int addProfessor(String name, String email, String address,String Password) throws ProfessorAlreadyExistException {
        try {
            adminDBInterface = new AdminDB();
            return adminDBInterface.addProfessorDB(name, email, address, Password);
        }
        catch (Exception ex){
                ex.getMessage();
        }
        return 0;
    }

    @Override
    public int addNewCourse(String courseName) throws CourseAlreadyExistException {
        try {
            adminDBInterface = new AdminDB();
        return adminDBInterface.addNewCourseDB(courseName);
        }
        catch (Exception ex){
            throw ex;
        }


    }

    @Override
    public boolean removeCourse(int courseId) throws CourseRemovalFailedException {
        try {
            adminDBInterface = new AdminDB();
            return adminDBInterface.removeCourseDB(courseId);
        }
        catch(Exception ex){
            throw ex;
        }
    }


    public boolean isApproved(int studentId){
        adminDBInterface = new AdminDB();
        return adminDBInterface.isApprovedDB(studentId);
    }
}
