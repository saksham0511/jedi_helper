package com.flipkart.DAO;

public interface GradeCardDBInterface {
    public void viewGradesDB(int studId);
    public boolean updateReportCardDB(int studId, int courseId, String grade);
}
