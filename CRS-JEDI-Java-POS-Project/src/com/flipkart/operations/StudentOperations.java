package com.flipkart.operations;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public class StudentOperations implements StudentInterface{
    @Override
    public Course[] getRegisteredCourses() {
        return new Course[0];
    }

    @Override
    public boolean dropCourse(int courseId) {
        return false;
    }

    @Override
    public int addCourse(int courseId) {
        return 0;
    }

    @Override
    public int payfees() {
        return 0;
    }
}
