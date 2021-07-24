package com.flipkart.bean;

import com.flipkart.constant.Role;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User{
    private List<Course> teachCourses ;

    public List<Course> getTeachCourses() {
        return teachCourses;
    }

    public void setTeachCourses(List<Course> teachCourses) {
        this.teachCourses = teachCourses;
    }

    public Professor(int professorId, String name, String password,String  email, String address) {
        super(Role.PROFESSOR,name, password, email, address);
        teachCourses = new ArrayList<Course>();

    }
}
