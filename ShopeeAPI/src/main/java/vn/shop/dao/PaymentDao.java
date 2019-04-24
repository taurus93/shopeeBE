package vn.shop.dao;

import vn.shop.library.common.model.dao.Payment;

import java.util.List;

/**
 * Created by lttung on 4/22/2019.
 */
public interface PaymentDao {
    int insertPayment(Payment payment);

    List<Payment> getPayment(int paymentID);

    List<Payment> getAllPayment();

//    int updateOrder(Order order);
}
