package com.flipkart.DAO;

import com.flipkart.bean.Student;
import com.flipkart.exception.*;

public interface AdminDBInterface {

    public boolean approveStudentDB() throws ApprovalFailedException;

    public boolean removeProfessorDB(int profId) throws ProfessorRemovalFailedException;

    public int addProfessorDB(String name, String email, String address, String Password) throws ProfessorAlreadyExistException;

    public int addNewCourseDB(String courseName) throws CourseAlreadyExistException;

    public boolean removeCourseDB(int courseId) throws CourseRemovalFailedException;


    public boolean isApprovedDB(int userId);
}
