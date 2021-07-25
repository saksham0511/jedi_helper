package com.flipkart.operations;

import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.List;

public interface AdminInterface {
    public boolean approveStudent() throws ApprovalFailedException;

    public boolean removeProfessor(int profId) throws ProfessorRemovalFailedException;

    public int addProfessor(String name, String email, String address, String Password) throws ProfessorAlreadyExistException;

    public int addNewCourse(String courseName,int fees) throws CourseAlreadyExistException;

    public boolean removeCourse(int courseId) throws CourseRemovalFailedException;

    public List<Student> unApprovedStudent();

    public boolean isApproved(int userId);



}
