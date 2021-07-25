package com.flipkart.DAO;

import com.flipkart.bean.Student;
import com.flipkart.constant.Role;

import java.sql.*;

public class AuthCredDB implements AuthCredDBInterface{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/crsproject";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement pdstmt = null;
    Statement stmt = null;
    public AuthCredDB(){
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
    public boolean authenticateUserDB(int userId, String password, Enum role) {
        try {
            String sql = "";
            if("STUDENT".equals(role.toString())){
                sql = "select count(*) from student where studentId=? and password=?;";


            }
            else if("PROFESSOR".equals(role.toString())){
                sql = "select count(*) from professor where professorId=? and password=?;";
            }

            pdstmt = conn.prepareStatement(sql);
            pdstmt.setInt(1, userId);
            pdstmt.setString(2, password);
            ResultSet rs = pdstmt.executeQuery();

            int id = 0;
            if (rs != null) {
                rs.last();
                id = rs.getRow();
            }
            int count  = rs.getInt(id);

            if(count == 1){

                return true;
            }

        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    @Override
    public int registerStudentDB(Student student) {
        try {
            pdstmt = conn.prepareStatement("insert into student values (default,?,?,?,?,?,?)");
            pdstmt.setString(1, student.getName());
            pdstmt.setString(2, student.getEmail());
            pdstmt.setString(3, student.getPassword());
            pdstmt.setString(4, student.getAddress());
            pdstmt.setString(5, "F");
            pdstmt.setString(6,"F");

            int rs = pdstmt.executeUpdate();
            return rs;

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return 0;
    }
}
