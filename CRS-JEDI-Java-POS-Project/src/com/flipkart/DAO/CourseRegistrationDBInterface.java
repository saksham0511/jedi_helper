package com.flipkart.DAO;

import com.flipkart.bean.Course;

public interface CourseRegistrationDBInterface {

    public int addCourseDB(int courseId);
    public boolean removeCourseDB(int courseId);
    public Course[] registeredCourseDB(int userId);
    public int makePaymentDB(int courseId);
}
