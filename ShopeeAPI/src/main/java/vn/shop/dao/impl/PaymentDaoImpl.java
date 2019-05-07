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
        String sql = "INSERT INTO payment(paymentCode, paymentType) value(?, ?)";
        try {

            return jdbcTemplate.update(sql, new Object[]{payment.getPaymentCode(), payment.getPaymentType()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<Payment> getPayment(int paymentCode) {

        logger.info("Begin get Payment");

        String sql = "SELECT * FROM payment WHERE paymentCode = ?";

        List<Payment> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{paymentCode}, new PaymentMapper());

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

    @Override
    public int updatePayment(Payment payment) {
        logger.info("Begin update");

        String sql = "UPDATE payment SET paymentType = ? WHERE paymentCode = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{payment.getPaymentType(), payment.getPaymentCode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End update, FAIL");
        return 0;
    }
    @Override
    public int deletePayment(String paymentCode) {
        logger.info("Begin");

        String sql = "DELETE FROM payment WHERE paymentCode = ?";

        try {
            return jdbcTemplate.update(sql, new Object[]{paymentCode});
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return 0;
    }
}
