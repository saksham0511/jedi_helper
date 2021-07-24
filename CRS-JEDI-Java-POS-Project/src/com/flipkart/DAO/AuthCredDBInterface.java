package com.flipkart.DAO;

import com.flipkart.bean.Student;

public interface AuthCredDBInterface {

    public boolean authenticateUserDB(int userId, String password, Enum role);

    public int registerStudentDB(Student student);
}
