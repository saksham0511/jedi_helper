package com.flipkart.operations;

import com.flipkart.DAO.CourseCatalogDB;
import com.flipkart.DAO.CourseCatalogDBInterface;
import com.flipkart.bean.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseCatalogOperations implements CourseCatalogInterface{
    static List<Course> courseCatalog = new ArrayList<Course>();
    @Override
    public int addCourses(int courseId, String courseName) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        courseCatalog.add(course);
        return courseId;
    }

    @Override
    public boolean removeCourse(int courseId) {
        for(Course course : courseCatalog){
            if(course.getCourseId() == courseId){
                courseCatalog.remove(course);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Course> viewCatalog() {
        List courseList = new ArrayList<>();
        CourseCatalogDBInterface courseCatalogDB = new CourseCatalogDB();
        courseList = courseCatalogDB.viewCatalogDB();
        return courseList;
    }
}
