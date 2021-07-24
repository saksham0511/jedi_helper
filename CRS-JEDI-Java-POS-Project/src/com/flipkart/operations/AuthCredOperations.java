package com.flipkart.operations;

import com.flipkart.DAO.AuthCredDB;
import com.flipkart.DAO.AuthCredDBInterface;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class AuthCredOperations implements AuthCredInterface {
    AuthCredDBInterface authCredDBInterface;

    @Override
    public boolean authenticateUser(int userId, String password , Enum role) {
        authCredDBInterface = new AuthCredDB();
        return authCredDBInterface.authenticateUserDB(userId, password, role);
    }

    @Override
    public int registerStudent(Student student) {
        authCredDBInterface = new AuthCredDB();
        return authCredDBInterface.registerStudentDB(student);
    }
}
