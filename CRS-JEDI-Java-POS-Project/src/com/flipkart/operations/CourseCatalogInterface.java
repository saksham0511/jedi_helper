package com.flipkart.operations;
import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogInterface {

    public int addCourses(int courseId, String courseName);

    public boolean removeCourse(int courseId);

    //Course Array to Array List
    public List<Course> viewCatalog();




}
