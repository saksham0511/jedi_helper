package com.flipkart.operations;

import com.flipkart.constant.BankEnum;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentModeEnum;

public interface NotificationInterface {

    public int sendNotification(NotificationType type, int studentId, PaymentModeEnum modeOfPayment, BankEnum bankEnum, int amount);
    public boolean studentApproval(int studId);
}
