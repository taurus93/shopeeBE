package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements RowMapper<Payment> {
    @Override
    public Payment mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Payment result = new Payment();
        try {

            result.setPaymentCode(resultSet.getString(ConstantUtil.paymentCode));
            result.setPaymentType(resultSet.getString(ConstantUtil.paymentType));

        }catch (Exception e) {

        }
        return result;
    }
}
