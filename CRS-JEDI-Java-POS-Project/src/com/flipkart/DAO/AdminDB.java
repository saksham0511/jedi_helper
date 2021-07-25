package com.flipkart.DAO;

import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDB implements AdminDBInterface {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/crsproject";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement pdstmt = null;
    Statement stmt = null;
    public AdminDB(){
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
    public boolean approveStudentDB() throws ApprovalFailedException {
        try {
            stmt = conn.createStatement();
            String sqlQuery = "Select count(*) from student where isapproved='F'";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            int id = 0;
            if (rs != null) {
                rs.last();
                id = rs.getRow();
            }

            int count =  rs.getInt(id);
            if(count > 0) {
                String sqlQuery1 = "Update student set isapproved='T'";
                int rs1 = stmt.executeUpdate(sqlQuery1);
                stmt.close();
                return true;
            }
            else{
                throw new ApprovalFailedException("No Student is for approval");

            }


        } catch (SQLException ex) {
            ex.getMessage();
        }catch(ApprovalFailedException ex){
            throw ex;
        }
        return false;
    }

    @Override
    public boolean removeProfessorDB(int profId) throws ProfessorRemovalFailedException {
        try {
            String sql = "DELETE FROM professor WHERE professorid=?";
            pdstmt = conn.prepareStatement(sql);

            pdstmt.setInt(1,profId);
            int rs = pdstmt.executeUpdate();
            if(rs == 1){
                return true;
            }
            if(rs == 0){
                throw  new ProfessorRemovalFailedException("Professor not removed, check if it exist");
            }

        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        catch(ProfessorRemovalFailedException ex){
            throw ex;
        }
        return false;
    }

    @Override
    public int addProfessorDB(String name, String email, String address,String Password) throws ProfessorAlreadyExistException {
        try {
            pdstmt = conn.prepareStatement("insert into professor values (default,?,?,?,?)");
            pdstmt.setString(1, name);
            pdstmt.setString(2, email);
            pdstmt.setString(3, address);
            pdstmt.setString(4, Password);

            int rs = pdstmt.executeUpdate();
            if(rs == 0){
                throw new ProfessorAlreadyExistException("Professor not added, check if professor already exists");
            }
            return rs;

        } catch (SQLException ex) {
            ex.getMessage();
        }catch(ProfessorAlreadyExistException ex){
            throw ex;
        }
        return 0;
    }

    @Override
    public int addNewCourseDB( String courseName,int fees) throws CourseAlreadyExistException {
        try {
            pdstmt = conn.prepareStatement("insert into course values (default,?,?,?)");
            pdstmt.setString(1, courseName);
            pdstmt.setInt(2,-1);
            pdstmt.setInt(3,fees);

            int rs = pdstmt.executeUpdate();
            if(rs == 0){
                throw  new CourseAlreadyExistException("Course not added, check if it already exists");
            }
            return rs;

        } catch (SQLException ex) {
            ex.getMessage();
        }catch (CourseAlreadyExistException ex){
            throw ex;
        }
        return 0;

    }

    @Override
    public boolean removeCourseDB(int courseId) throws CourseRemovalFailedException {
        try {
            String sql = "DELETE FROM course WHERE courseID=?";
            pdstmt = conn.prepareStatement(sql);

            pdstmt.setInt(1,courseId);
            int rs = pdstmt.executeUpdate();
            if(rs == 1){
                return true;
            }
            if(rs == 0){
                throw  new CourseRemovalFailedException("Course not removed, check if it exist");
            }

        }
        catch (SQLException ex) {
            ex.getMessage();
        }catch(CourseRemovalFailedException ex){
            throw  ex;
        }
        return false;
    }

    @Override
    public List<Student> unApprovedStudent() {
        try {
            String sql = "select StudentId,StudentName,StudentEmail,StudentAddress from student where isApproved=?";
            pdstmt = conn.prepareStatement(sql);

            pdstmt.setString(1,"F");
            ResultSet rs = pdstmt.executeQuery();
            List<Student> studentList = new ArrayList<>();
            while (rs.next()){
                int studentId = rs.getInt(1);
                String studentName = rs.getString(2);
                String studentEmail = rs.getString(3);
                String studentAddress = rs.getString(4);
                Student student = new Student();
                student.setUserId(studentId);
                student.setName(studentName);
                student.setEmail(studentEmail);
                student.setAddress(studentAddress);
                studentList.add(student);
            }
            return studentList;
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }


    @Override
    public boolean isApprovedDB(int studentId) {

        try {
            String sql = "select isapproved from student where studentid=?";
            pdstmt = conn.prepareStatement(sql);

            pdstmt.setInt(1,studentId);
            ResultSet rs = pdstmt.executeQuery();
            int id = 0;
            if (rs != null) {
                rs.last();
                id = rs.getRow();
            }

            String isApproved =  rs.getString(id);
            if(isApproved.equals("T")){
                return true;
            }
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

}

