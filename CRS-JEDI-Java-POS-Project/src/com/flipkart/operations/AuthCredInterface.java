package com.flipkart.operations;

import com.flipkart.bean.Student;

public interface AuthCredInterface {

    public boolean authenticateUser(int userId, String password, Enum role);

    public int registerStudent(Student student);

}