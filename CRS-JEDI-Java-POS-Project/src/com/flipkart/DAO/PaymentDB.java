package com.flipkart.DAO;

import com.flipkart.constant.SQlQueriesConstants;
import com.flipkart.exception.CourseAlreadyExistException;

import java.sql.*;

public class PaymentDB implements PaymentDBInterface{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CRSProject";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement pdstmt = null;
    Statement stmt = null;
    public PaymentDB(){
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
    public int getPaymentDB(int studId) {
        try {
            pdstmt = conn.prepareStatement(SQlQueriesConstants.CALCULATE_TOTAL_AMOUNT);
            pdstmt.setInt(1,studId);
            ResultSet rs = pdstmt.executeQuery();
            int amount=0;
            if (rs.next()){
                amount = rs.getInt(1);
            }
            return amount;

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return 0;
    }

    @Override
    public void getStatusDB(int paymentId) {

    }
}
