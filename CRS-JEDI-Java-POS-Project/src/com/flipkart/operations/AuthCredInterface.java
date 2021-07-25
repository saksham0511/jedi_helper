package com.flipkart.operations;

import com.flipkart.bean.Student;
import com.flipkart.exception.AuthorizationException;

public interface AuthCredInterface {

    public boolean authenticateUser(int userId, String password, Enum role) throws AuthorizationException;

    public int registerStudent(Student student);

}