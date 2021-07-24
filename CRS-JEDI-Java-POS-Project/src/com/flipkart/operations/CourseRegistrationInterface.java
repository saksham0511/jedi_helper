package com.flipkart.operations;
import com.flipkart.bean.Course;

public interface CourseRegistrationInterface {

    public int addCourse(int courseId);
    public boolean removeCourse(int courseId);
    public Course[] registeredCourse(int userId);
    public int makePayment(int courseId);

}
