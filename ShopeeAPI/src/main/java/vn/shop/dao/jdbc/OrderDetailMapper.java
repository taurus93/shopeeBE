package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailMapper implements RowMapper<OrderDetail> {

    @Override
    public OrderDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        OrderDetail result = new OrderDetail();
        try {

            result.setOrderDetailsID(resultSet.getInt(ConstantUtil.orderDetailsID));
            result.setOrderDetailCode(resultSet.getString(ConstantUtil.orderDetailCode));
            result.setOrderDate(resultSet.getString(ConstantUtil.orderDate));
            result.setQuantity(resultSet.getInt(ConstantUtil.quantity));
            result.setTotalPrice(resultSet.getFloat(ConstantUtil.totalPrice));
            result.setProductID_FK(resultSet.getInt(ConstantUtil.productID_FK));
            result.setUserEmail_FK(resultSet.getString(ConstantUtil.userEmail_FK));
            result.setPaymentID_FK(resultSet.getInt(ConstantUtil.paymentID_FK));
            result.setProductName(resultSet.getString(ConstantUtil.productName));
            result.setProductPicture(resultSet.getString(ConstantUtil.productPicture));

        }catch (Exception e) {

        }
        return result;
    }
}
