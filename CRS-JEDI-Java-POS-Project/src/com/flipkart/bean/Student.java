package com.flipkart.bean;

import com.flipkart.constant.Role;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    public Student(){

    }
    private boolean isApproved;
    private List<Course> enrolledCourses;

    public boolean isApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean approved) {
        isApproved = approved;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Student( String name, String password,  String email, String address){
        super( Role.STUDENT,name, password, email, address);
        this.isApproved = false;
        enrolledCourses = new ArrayList<>();
    }


}
