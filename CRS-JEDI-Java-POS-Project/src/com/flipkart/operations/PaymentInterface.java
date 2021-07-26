package com.flipkart.operations;
/**
 * @author JEDI-06
 * Interface for Payment Operations
 *
 */
public interface PaymentInterface {

    /**
     * This method is used to get the total payment amount
     * @param studId
     * @return amount
     */
    public int getPayment(int studId);

    /**
     * This method is used to check the payment status
     * @param paymentId
     */
    public void getStatus(int paymentId);

}
