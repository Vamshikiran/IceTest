package com.ice;

import com.ice.util.IceUtil;

/**
 * Created by vamshikirangullapelly on 07/11/2018.
 */
public class InterestPayment {
    private static int PAYMENT_DAY_TOLERANCE = 5;
    private Payment currentPayment;

    public InterestPayment(Payment currentPayment) {
        this.currentPayment = currentPayment;







    }

    /**
     * Update the payment if the new payment is within 5 days of the current payment.
     *
     * @param payment The new payment
     * @return True if the payment was updated, false otherwise.
     */
    public boolean updatePayment(Payment payment) {
        if (payment.getDayNumber() - currentPayment.getDayNumber() <= PAYMENT_DAY_TOLERANCE) {
            this.currentPayment = payment;
            return true;
        }
        return false;
    }

    /**
     * Following method is the bug fixed version of the above updatePayment method
     *
     * @param payment
     * @return
     */
    public boolean updatePaymentFixedBug(Payment payment) {

        if (currentPayment.getDayNumber() - payment.getDayNumber() <= IceUtil.daysToMilliSeconds(PAYMENT_DAY_TOLERANCE)) {
            this.currentPayment = payment;
            return true;
        }
        return false;
    }


}