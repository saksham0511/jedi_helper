package com.flipkart.DAO;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.ApprovalFailedException;
import com.flipkart.exception.IncorrectDetailsException;
import com.flipkart.exception.ProfessorAlreadyExistException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDB implements ProfessorDBInterface {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/crsproject";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement pdstmt = null;
    Statement stmt = null;

    public ProfessorDB(){
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
    public boolean teachCourseDB(int profId, int courseId){
        try {
            String sqlQuery = "update course set professorid = ? where courseid = ?";
            pdstmt = conn.prepareStatement(sqlQuery);
            pdstmt.setInt(1, profId);
            pdstmt.setInt(2, courseId);
            int rs = pdstmt.executeUpdate();
            if (rs == 0) {
                return false;
            }
            return true;
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        return false;
        }


    @Override
    public List<Student> getEnrolledStudentsDB(int courseId) {
        List<Student> studentList = new ArrayList<>();
        String demo = new String("demo");

        try {
            String sqlQuery = "select * from GradeCard where CourseID = ?";
            pdstmt = conn.prepareStatement(sqlQuery);
            pdstmt.setInt(1, courseId);
            ResultSet rs = pdstmt.executeQuery();
            while(rs.next()){
                Student student = new Student(demo, demo, demo, demo);
                student.setUserId(rs.getInt(2));
                studentList.add(student);
            }
            return studentList;
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        return studentList;
    }

    @Override
    public boolean addGradesDB(int studId, int courseId, String grade) {
        try {
            String sqlQuery = "update gradecard set Grade = ? where CourseId = ? and StudentId = ?";
            pdstmt = conn.prepareStatement(sqlQuery);
            pdstmt.setString(1, grade);
            pdstmt.setInt(2, courseId);
            pdstmt.setInt(3, studId);
            int rs = pdstmt.executeUpdate();
            if (rs == 0) {
                return false;
            }
            return true;
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        return false;
    }

}
