package com.flipkart.DAO;

import com.flipkart.bean.Course;

import java.util.List;

public interface StudentDBInterface {
    public List<Course> getRegisteredCoursesDB();
    public boolean dropCourseDB(int courseId);
    public int addCourseDB(int courseId);
    public int payfeesDB(int studentId);
}
