package com.flipkart.operations;

import com.flipkart.bean.User;

public class CourseOperations implements CourseInterface{
    @Override
    public boolean addStudent(int studId) {
        return false;
    }

    @Override
    public boolean removeStudent(int studId) {
        return false;
    }

    @Override
    public User[] getListOfStudents() {
        return new User[0];
    }

    @Override
    public int addProfessor(int profId) {
        return 0;
    }

    @Override
    public boolean isCourseAvailable(int courseId) {
        return false;
    }

    @Override
    public boolean addToCatalog() {
        return false;
    }

    @Override
    public boolean removeFromCatalog() {
        return false;
    }
}
