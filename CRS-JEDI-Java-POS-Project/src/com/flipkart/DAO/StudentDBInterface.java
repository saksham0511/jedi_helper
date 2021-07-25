package com.flipkart.DAO;

import com.flipkart.bean.Course;

import java.util.List;

public interface StudentDBInterface {
    public List<Course> getRegisteredCoursesDB(int studId);
    public boolean isFeefeespaidDB(int studentId);
}
