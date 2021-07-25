package com.flipkart.DAO;

import com.flipkart.bean.Course;

public interface CourseRegistrationDBInterface {

    public int addCourseDB(int courseId,int studId);
    public boolean removeCourseDB(int courseId,int studId);
    public Course[] registeredCourseDB(int userId);
    public int makePaymentDB(int courseId);
    public int numOfRegisteredCourses(int studId);
}
