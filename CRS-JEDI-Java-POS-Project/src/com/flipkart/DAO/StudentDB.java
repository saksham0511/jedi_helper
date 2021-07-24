package com.flipkart.DAO;

import com.flipkart.bean.Course;

import java.util.List;

public class StudentDB implements StudentDBInterface{
    @Override
    public List<Course> getRegisteredCoursesDB() {
        return null;
    }

    @Override
    public boolean dropCourseDB(int courseId) {
        return false;
    }

    @Override
    public int addCourseDB(int courseId) {
        return 0;
    }

    @Override
    public int payfeesDB(int studentId) {
        return 0;
    }
}
