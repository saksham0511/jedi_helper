package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private int professorId;
    private boolean isAvailable;
    private List<Student> studentList;

    public Course() {

    }

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professorId = -1; //-1 is for no professor is allocated
        this.isAvailable = true;
        this.studentList = new ArrayList<Student>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


}
