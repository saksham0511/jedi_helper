package com.flipkart.DAO;

import com.flipkart.constant.BankEnum;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentModeEnum;

import java.sql.*;

public class NotificationDB implements NotificationDBInterface {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/crsproject";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement pdstmt = null;
    PreparedStatement pdstmtPayment = null;
    PreparedStatement isFee = null;
    public NotificationDB(){
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
    public int sendNotification(NotificationType type, int studentId, PaymentModeEnum modeOfPayment, BankEnum bankEnum, int amount) {
        try {
            String sql = "insert into notification values (default,?,?)";
            pdstmt = conn.prepareStatement(sql);
            pdstmt.setString(1,type.toString());
            int id = 0;
            if (type==NotificationType.PAYMENT){
                id = addPayment(studentId,amount,modeOfPayment,bankEnum);
                if (id == 0)
                    return 0;
                pdstmt.setInt(2,id);
            }else {
                pdstmt.setInt(2,-1);
            }
            int check = pdstmt.executeUpdate();
            if (check!=0){
                return id;
            }

        } catch (SQLException ex) {
            System.out.println("EXCEPTION:" + ex.getMessage());
            ex.getMessage();
        }
        return 0;
    }

    @Override
    public boolean studentApprovalDB(int studId) {
        try {
            String query = "update student set isFeePaid='T' where StudentId = ?";
            isFee = conn.prepareStatement(query);
            isFee.setString(1, "T");
            int status = isFee.executeUpdate();
            if (status != 0)
                return true;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    private int addPayment(int studentId, int amount, PaymentModeEnum modeOfPayment, BankEnum bankEnum) {
        try {
            String sql = "insert into payment values(?,?,?,?,?);";
            int min = 100000;
            int max = 900000;
            int paymentId = (int)Math.floor(Math.random()*(max-min+1)+min);
            pdstmtPayment = conn.prepareStatement(sql);
            pdstmtPayment.setInt(1,paymentId);
            pdstmtPayment.setInt(2,studentId);
            pdstmtPayment.setString(3,bankEnum.toString());
            pdstmtPayment.setString(4,modeOfPayment.toString());
            pdstmtPayment.setInt(5,amount);
            int check = pdstmtPayment.executeUpdate();
            if (check!=0){
                String query = "update student set isFeePaid=? where StudentId = ?";
                isFee = conn.prepareStatement(query);
                isFee.setString(1,"T");
                isFee.setInt(2,studentId);
                int status = isFee.executeUpdate();
                if (status!=0)
                    return paymentId;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

}
