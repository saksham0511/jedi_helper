package com.flipkart.DAO;

import com.flipkart.bean.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseCatalogDB implements CourseCatalogDBInterface{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/crsproject";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement pdstmt = null;
    Statement stmt = null;

    public CourseCatalogDB(){
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
    public int addCoursesDB(int courseId, String courseName) {
        return 0;
    }

    @Override
    public boolean removeCourseDB(int courseId) {
        return false;
    }

    @Override
    public List<Course> viewCatalogDB() {
        List<Course> courseList = new ArrayList<>();
        try {
            String sqlQuery = "select * from course";
            pdstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pdstmt.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCourseId(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setProfessorId(rs.getInt(3));
                courseList.add(course);
            }
            return courseList;
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        return courseList;



    }
}
