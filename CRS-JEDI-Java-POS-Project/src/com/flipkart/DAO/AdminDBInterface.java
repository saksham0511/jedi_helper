package com.flipkart.DAO;

import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.List;

public interface AdminDBInterface {

    public boolean approveStudentDB() throws ApprovalFailedException;

    public boolean removeProfessorDB(int profId) throws ProfessorRemovalFailedException;

    public int addProfessorDB(String name, String email, String address, String Password) throws ProfessorAlreadyExistException;

    public int addNewCourseDB(String courseName,int fees) throws CourseAlreadyExistException;

    public boolean removeCourseDB(int courseId) throws CourseRemovalFailedException;

    public List<Student> unApprovedStudent();

    public boolean isApprovedDB(int userId);
}
