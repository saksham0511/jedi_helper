package com.flipkart.operations;

import com.flipkart.constant.BankEnum;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentModeEnum;

/**
 * @author JEDI-06
 * Interface for Notification Operations
 *
 */

public interface NotificationInterface {

    /**
     * This method is used to send payment notification to student
     * @param type
     * @param studentId
     * @param modeOfPayment
     * @param bankEnum
     * @param amount
     * @return
     */
    public int sendNotification(NotificationType type, int studentId, PaymentModeEnum modeOfPayment, BankEnum bankEnum, int amount);

    /**
     * This method is used to check if student has paid the fee or not
     * @param studId
     * @return
     */
    public boolean studentApproval(int studId);
}
