package com.flipkart.operations;
import com.flipkart.bean.Course;


public interface StudentInterface {
    public Course[] getRegisteredCourses();
    public boolean dropCourse(int courseId);
    public int addCourse(int courseId);
    public int payfees();
}
