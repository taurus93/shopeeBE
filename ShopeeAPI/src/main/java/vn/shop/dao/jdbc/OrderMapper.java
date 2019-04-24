package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Order result = new Order();
        try {

            result.setOrderDetailsID(resultSet.getInt(ConstantUtil.orderDetailsID));
            result.setOrderDate(resultSet.getString(ConstantUtil.orderDate));
            result.setQuantity(resultSet.getInt(ConstantUtil.quantity));
            result.setTotalPrice(resultSet.getFloat(ConstantUtil.totalPrice));
            result.setProductID_FK(resultSet.getInt(ConstantUtil.productID_FK));
            result.setUserEmail_FK(resultSet.getString(ConstantUtil.userEmail_FK));
            result.setPaymentID_FK(resultSet.getInt(ConstantUtil.paymentID_FK));

        }catch (Exception e) {

        }
        return result;
    }
}
