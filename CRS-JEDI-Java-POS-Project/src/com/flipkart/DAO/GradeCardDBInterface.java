package com.flipkart.DAO;

import com.flipkart.bean.Course;

import java.util.HashMap;

public interface GradeCardDBInterface {
    public HashMap<Course, String> viewGradesDB(int studId);
    public boolean updateReportCardDB(int studId, int courseId, String grade);
}
