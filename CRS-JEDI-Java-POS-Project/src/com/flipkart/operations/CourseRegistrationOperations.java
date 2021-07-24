package com.flipkart.operations;

import com.flipkart.bean.Course;

public class CourseRegistrationOperations implements  CourseRegistrationInterface{
    @Override
    public int addCourse(int courseId) {
        return 0;
    }

    @Override
    public boolean removeCourse(int courseId) {
        return false;
    }

    @Override
    public Course[] registeredCourse(int userId) {
        return new Course[0];
    }

    @Override
    public int makePayment(int courseId) {
        return 0;
    }
}
