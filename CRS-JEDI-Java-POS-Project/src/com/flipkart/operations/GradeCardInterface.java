package com.flipkart.operations;

public interface GradeCardInterface {

    public void viewGrades(int studId);
    public boolean updateReportCard(int studId, int courseId, String grade);
}
