package com.flipkart.DAO;

import com.flipkart.bean.Course;
import com.flipkart.constant.SQlQueriesConstants;

import java.sql.*;

public class CourseRegistrationDB implements CourseRegistrationDBInterface{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CRSProject";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement pdstmt = null;
    PreparedStatement pdstmtForCourse = null;
    PreparedStatement pdstmtAlready = null;
    public CourseRegistrationDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(SQLException se){

            se.printStackTrace();
        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public int addCourseDB(int courseId,int studentId) {
        try {
            pdstmtForCourse = conn.prepareStatement(SQlQueriesConstants.GET_COURSE_COUNT);
            pdstmtForCourse.setInt(1,courseId);
            ResultSet resultSet = pdstmtForCourse.executeQuery();
            int id = 0;
            if (resultSet == null){
                System.out.println("Result Set NULL");
                return 0;
            }
            int check = -9;
            if(resultSet.next()) {
                check = resultSet.getInt(1);
            }
            if(check !=0 ) {
                pdstmt = conn.prepareStatement(SQlQueriesConstants.ADD_COURSE_FOR_STUDENT);
                pdstmt.setInt(1, courseId);
                pdstmt.setInt(2, studentId);
                pdstmt.setString(3, "X");

                int rs = pdstmt.executeUpdate();
                if (rs == 0) {

                    System.out.println("Course Not Added");
                }
                return rs;
            }

        } catch (SQLException ex) {
            System.out.println("EXCEPTION:"+ex.getMessage());
            ex.getMessage();
        }
        return 0;
    }

    @Override
    public boolean removeCourseDB(int courseId,int studId) {
        try {
            pdstmt = conn.prepareStatement(SQlQueriesConstants.REMOVE_COURSE_FOR_STUDENT);

            pdstmt.setInt(1,courseId);
            pdstmt.setInt(2,studId);
            int rs = pdstmt.executeUpdate();
            if(rs == 1){
                return true;
            }
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    @Override
    public Course[] registeredCourseDB(int userId) {
        return new Course[0];
    }

    @Override
    public int makePaymentDB(int courseId) {
        return 0;
    }

    @Override
    public int numOfRegisteredCourses(int studId) {
        try {
            pdstmt = conn.prepareStatement(SQlQueriesConstants.COUNT_OF_REGISTERED_COURSES_OF_STUDENT);
            pdstmt.setInt(1, studId);
            ResultSet rs = pdstmt.executeQuery();
            int id = 0;
            if (rs != null) {
                rs.last();
                id = rs.getRow();
            }

            int numOfCourse =  rs.getInt(id);
            return numOfCourse;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return 0;
    }
}
