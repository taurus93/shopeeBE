package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.PaymentDao;
import vn.shop.dao.jdbc.PaymentMapper;
import vn.shop.library.common.model.dao.Payment;

import java.util.ArrayList;
import java.util.List;

@Repository("paymentDao")
public class PaymentDaoImpl implements PaymentDao{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PaymentDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertPayment(Payment payment) {
        logger.info("Begin insert");
        String sql = "INSERT INTO payment(paymentID, paymentType) value(?, ?)";
        try {

            return jdbcTemplate.update(sql, new Object[]{payment.getPaymentID(), payment.getPaymentType()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<Payment> getPayment(int paymentID) {

        logger.info("Begin get Payment");

        String sql = "SELECT * FROM payment WHERE paymentID = ?";

        List<Payment> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{paymentID}, new PaymentMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get, result: Success" + result);
        return ret;
    }

    @Override
    public List<Payment> getAllPayment() {

        logger.info("Begin get all Payment");

        String sql = "SELECT * FROM payment";

        List<Payment> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new PaymentMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all Payment, result: SUCCESS " + ret);

        return ret;
    }

//    @Override
//    public int updatePayment(Payment Payment) {
//        logger.info("Begin update Payment");
//
//        String sql = "UPDATE Paymentdetails SET firstName = ?, lastName = ?, phoneNumber = ?" +
//                ", street = ?, suburb = ?, city = ?" +
//                ", state = ?, postcode = ? WHERE emailAddress = ?";
//
//        try {
//
//            return jdbcTemplate.update(sql, new Object[]{Payment.getFirstName(), Payment.getLastName(), Payment.getPhoneNumber(), Payment.getStreet(),
//                    Payment.getSuburb(), Payment.getCity(), Payment.getState(), Payment.getPostcode()});
//        } catch (Exception e) {
//            logger.info(e.getMessage(), e);
//        }
//
//        logger.info("End update Payment, FAIL");
//        return 0;
//    }
}
