package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.OrderDao;
import vn.shop.dao.PaymentDao;
import vn.shop.dao.service.PaymentService;
import vn.shop.library.common.model.dao.Order;
import vn.shop.library.common.model.dao.Payment;

import java.util.List;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public List<Payment> getAllPayment() {
        return paymentDao.getAllPayment();
    }

    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }
    @Override
    public List<Payment> getPayment(int paymentID) {
        return paymentDao.getPayment(paymentID);
    }
}
