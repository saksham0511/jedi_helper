package com.flipkart.DAO;

import com.flipkart.bean.Course;
import com.flipkart.constant.SQlQueriesConstants;
import com.flipkart.exception.CourseRemovalFailedException;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDB implements StudentDBInterface{
    Connection conn = null;
    PreparedStatement pdstmt = null;

    public StudentDB(){
        conn = DBUtil.getConnection();
    }
    @Override
    public List<Course> getRegisteredCoursesDB(int studId) {
        try {
            pdstmt = conn.prepareStatement(SQlQueriesConstants.GET_STUDENT_COURSES);
            pdstmt.setInt(1,studId);
            List<Course> courseList = new ArrayList<>();
            ResultSet rs = pdstmt.executeQuery();
            while (rs.next()){
                int courseId = rs.getInt(1);
                String courseName = rs.getString(2);
                Course course = new Course(courseId,courseName);
                courseList.add(course);
            }
            return courseList;
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }


    @Override
    public boolean isFeefeespaidDB(int studentId) {
        try {
            pdstmt = conn.prepareStatement(SQlQueriesConstants.CHECK_PAYMENT_STATUS_FOR_STUDENT);
            pdstmt.setInt(1,studentId);
            ResultSet rs = pdstmt.executeQuery();
            if (rs.next()){
                String isFee = rs.getString(1);
                if (isFee.equals("T")){
                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        return false;
    }
}
