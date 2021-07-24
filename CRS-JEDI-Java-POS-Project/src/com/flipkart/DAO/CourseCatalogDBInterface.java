package com.flipkart.DAO;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogDBInterface {

    public int addCoursesDB(int courseId, String courseName);

    public boolean removeCourseDB(int courseId);

    //Course Array to Array List
    public List<Course> viewCatalogDB();

}
