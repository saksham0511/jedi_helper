package com.flipkart.DAO;

import com.flipkart.bean.Course;

public class CourseRegistrationDB implements CourseRegistrationDBInterface{
    @Override
    public int addCourseDB(int courseId) {
        return 0;
    }

    @Override
    public boolean removeCourseDB(int courseId) {
        return false;
    }

    @Override
    public Course[] registeredCourseDB(int userId) {
        return new Course[0];
    }

    @Override
    public int makePaymentDB(int courseId) {
        return 0;
    }
}
