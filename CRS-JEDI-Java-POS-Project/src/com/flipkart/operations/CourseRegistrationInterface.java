package com.flipkart.operations;
import com.flipkart.bean.Course;

public interface CourseRegistrationInterface {

    public int addCourse(int courseId,int studId);
    public boolean removeCourse(int courseId,int studId);
    public Course[] registeredCourse(int userId);
    public int makePayment(int courseId);
    public int numOfRegisteredCourses(int studId);
}
