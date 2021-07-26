package com.flipkart.DAO;

import com.flipkart.constant.BankEnum;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentModeEnum;
import com.flipkart.constant.SQlQueriesConstants;
import com.flipkart.operations.AdminOperations;
import com.flipkart.utils.DBUtil;
import org.apache.log4j.Logger;

import java.sql.*;

public class NotificationDB implements NotificationDBInterface {
    private static final Logger logger = Logger.getLogger(String.valueOf(AdminOperations.class));
    Connection conn = null;
    PreparedStatement pdstmt = null;
    PreparedStatement pdstmtPayment = null;
    PreparedStatement isFee = null;
    public NotificationDB(){
        conn = DBUtil.getConnection();
    }

    @Override
    public int sendNotification(NotificationType type, int studentId, PaymentModeEnum modeOfPayment, BankEnum bankEnum, int amount) {
        try {
            pdstmt = conn.prepareStatement(SQlQueriesConstants.SEND_NOTIFICATION);
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
            logger.error(ex.getMessage());
        }
        return 0;
    }

    @Override
    public boolean studentApprovalDB(int studId) {
        try {
            isFee = conn.prepareStatement(SQlQueriesConstants.UPDATE_PAYMENT_STATUS);
            isFee.setString(1, "T");
            int status = isFee.executeUpdate();
            if (status != 0)
                return true;
        } catch (SQLException ex){
            logger.error(ex.getMessage());
        }
        return false;
    }

    /**
     * This method is used to make payment
     * @param studentId
     * @param amount
     * @param modeOfPayment
     * @param bankEnum
     * @return Payment Id
     */
    private int addPayment(int studentId, int amount, PaymentModeEnum modeOfPayment, BankEnum bankEnum) {
        try {
            int min = 100000;
            int max = 900000;
            int paymentId = (int)Math.floor(Math.random()*(max-min+1)+min);
            pdstmtPayment = conn.prepareStatement(SQlQueriesConstants.MAKE_PAYMENT);
            pdstmtPayment.setInt(1,paymentId);
            pdstmtPayment.setInt(2,studentId);
            pdstmtPayment.setString(3,bankEnum.toString());
            pdstmtPayment.setString(4,modeOfPayment.toString());
            pdstmtPayment.setInt(5,amount);
            int check = pdstmtPayment.executeUpdate();
            if (check!=0){
                isFee = conn.prepareStatement(SQlQueriesConstants.UPDATE_PAYMENT_STATUS);
                isFee.setString(1,"T");
                isFee.setInt(2,studentId);
                int status = isFee.executeUpdate();
                if (status!=0)
                    return paymentId;
            }
        } catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return 0;
    }

}
