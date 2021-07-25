package com.flipkart.operations;

import com.flipkart.bean.Course;

import java.util.HashMap;

public interface GradeCardInterface {

    public HashMap<Course, String> viewGrades(int studId);
    public boolean updateReportCard(int studId, int courseId, String grade);
}
