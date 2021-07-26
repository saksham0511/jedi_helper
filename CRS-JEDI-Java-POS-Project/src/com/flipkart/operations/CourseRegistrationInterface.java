package com.flipkart.operations;
import com.flipkart.bean.Course;

/**
 * @author JEDI-06
 * Interface for Course Registration Operations
 *
 */

public interface CourseRegistrationInterface {

    /**
     * This method is used to add a course in the Student's course list
     * @param courseId
     * @param studId
     * @return
     */
    public int addCourse(int courseId,int studId);

    /**
     * This method is used to remove a course from the Student's course list
     * @param courseId
     * @param studId
     * @return
     */
    public boolean removeCourse(int courseId,int studId);

    /**
     * This method is used to view all the courses in which a student is registered
     * @param userId
     * @return
     */
    public Course[] registeredCourse(int userId);

    /**
     * This method is used to make payment for a course
     * @param courseId
     * @return
     */
    public int makePayment(int courseId);

    /**
     * This method is used to get a count of courses in which a student is registered
     * @param studId
     * @return
     */
    public int numOfRegisteredCourses(int studId);
}
