package vn.shop.dao.service;

import vn.shop.library.common.model.dao.Payment;

import java.util.List;

public interface PaymentService {
    /**
     * Returns an Payment
     *
     * @return
     * <code>
     * List Payment
     * </code>
     */
    List<Payment> getAllPayment();

    /**
     * Returns an Payment
     *
     * @param  paymentID
     * @return
     * <code>
     * List Payment
     * </code>
     */
    List<Payment> getPayment(int paymentID);

    /**
     * Returns an Payment
     *
     * @param  payment
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int insertPayment(Payment payment);

    /**
     * Returns an Payment
     *
     * @param  payment
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int updatePayment(Payment payment);

    /**
     * Returns an Payment
     *
     * @param  paymentCode
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int deletePayment(String paymentCode);
}
