package com.flipkart.DAO;

import com.flipkart.constant.SQlQueriesConstants;
import com.flipkart.exception.CourseAlreadyExistException;
import com.flipkart.operations.AdminOperations;
import com.flipkart.utils.DBUtil;
import org.apache.log4j.Logger;

import java.sql.*;

public class PaymentDB implements PaymentDBInterface{
    private static final Logger logger = Logger.getLogger(String.valueOf(AdminOperations.class));
    Connection conn = null;
    PreparedStatement pdstmt = null;
    Statement stmt = null;
    public PaymentDB(){
        conn = DBUtil.getConnection();

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
            logger.error(ex.getMessage());
        }
        return 0;
    }

    @Override
    public void getStatusDB(int paymentId) {

    }
}
