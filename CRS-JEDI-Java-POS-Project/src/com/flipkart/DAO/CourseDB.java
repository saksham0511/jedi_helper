package com.flipkart.DAO;

import com.flipkart.bean.User;

public class CourseDB implements CourseDBInterface{
    @Override
    public boolean addStudentDB(int studId) {
        return false;
    }

    @Override
    public boolean removeStudentDB(int studId) {
        return false;
    }

    @Override
    public User[] getListOfStudentsDB() {
        return new User[0];
    }

    @Override
    public int addProfessorDB(int profId) {
        return 0;
    }

    @Override
    public boolean isCourseAvailableDB(int courseId) {
        return false;
    }

    @Override
    public boolean addToCatalogDB() {
        return false;
    }

    @Override
    public boolean removeFromCatalogDB() {
        return false;
    }
}
