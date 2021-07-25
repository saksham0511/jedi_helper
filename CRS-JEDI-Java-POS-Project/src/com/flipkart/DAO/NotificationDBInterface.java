package com.flipkart.DAO;

import com.flipkart.constant.*;

import java.sql.SQLException;

public interface NotificationDBInterface {
    public int sendNotification(NotificationType type, int studentId, PaymentModeEnum modeOfPayment, BankEnum bankEnum, int amount);
    public boolean studentApprovalDB(int studId) ;
}
