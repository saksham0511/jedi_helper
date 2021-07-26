package com.flipkart.operations;

import com.flipkart.bean.Course;

import java.util.HashMap;

/**
 * @author JEDI-06
 * Interface for Grade Card Operations
 *
 */

public interface GradeCardInterface {

    /**
     * This method is used by student to view grade card
     * @param studId
     * @return Key-value pair of course and grade
     */
    public HashMap<Course, String> viewGrades(int studId);

    /**
     * This method is used to update grades of a student
     * @param studId
     * @param courseId
     * @param grade
     * @return
     */
    public boolean updateReportCard(int studId, int courseId, String grade);
}
