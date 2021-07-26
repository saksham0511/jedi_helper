package com.flipkart.DAO;

import com.flipkart.bean.User;

/**
 * @author JEDI-06
 * Interface for Course dao Operations
 *
 */

public interface CourseDBInterface {
    /**
     * This method is used to register a student to a course
     * @param studId
     * @return
     */
    public boolean addStudentDB(int studId);

    /**
     * This method is used to remove a student from a particular course
     * @param studId
     * @return
     */
    public boolean removeStudentDB(int studId);

    /**
     * This method is used to view all registered students for a particular course
     * @return List of students
     */
    public User[] getListOfStudentsDB();

    /**
     * This method is used to add Professor to a particular course
     * @param profId
     * @return
     */
    public int addProfessorDB(int profId);

    /**
     * This method is used to check if course is available or not
     * @param courseId
     * @return
     */
    public boolean isCourseAvailableDB(int courseId);

    /**
     * This method is used to add a course to the course catalog
     * @return
     */
    public boolean addToCatalogDB();

    /**
     * This method is used to remove a course from the course catalog
     * @return
     */
    public boolean removeFromCatalogDB();
}
