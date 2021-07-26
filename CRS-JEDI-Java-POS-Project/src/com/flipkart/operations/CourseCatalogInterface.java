package com.flipkart.operations;
import com.flipkart.bean.Course;

import java.util.List;

/**
 * @author JEDI-06
 * Interface for Course Catalog Operations
 *
 */
public interface CourseCatalogInterface {

    /**
     * This method is used to add a course in the course catalog
     * @param courseId
     * @param courseName
     * @return
     */
    public int addCourses(int courseId, String courseName);

    /**
     * This method is used to remove a  course from the course catalog
     * @param courseId
     * @return Status of Course removal
     */
    public boolean removeCourse(int courseId);

    /**
     * This method is used to view all courses in the course catalog
     * @return List of courses
     */
    public List<Course> viewCatalog();




}
