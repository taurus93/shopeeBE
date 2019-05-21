package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.OrderProduct;
import vn.shop.library.common.model.dao.OrderUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProductMapper implements RowMapper<OrderProduct> {

    @Override
    public OrderProduct mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        OrderProduct result = new OrderProduct();
        try {

            result.setOrderCode(resultSet.getString(ConstantUtil.orderCode));
            result.setProductCode(resultSet.getString(ConstantUtil.productCode));
            result.setFactureCode(resultSet.getString(ConstantUtil.factureCode));
            result.setTotalPrice(resultSet.getFloat(ConstantUtil.totalPrice));
            result.setOrderDate(resultSet.getString(ConstantUtil.orderDate));
            result.setQuantity(resultSet.getInt(ConstantUtil.quantity));
            result.setUserEmail(resultSet.getString(ConstantUtil.userEmail));
            result.setProductPicture(resultSet.getString(ConstantUtil.productPicture));
            result.setProductName(resultSet.getString(ConstantUtil.productName));
            result.setProductDescription(resultSet.getString(ConstantUtil.productDescription));
            result.setStatus(resultSet.getInt(ConstantUtil.status));
            result.setPaymentCode(resultSet.getString(ConstantUtil.paymentCode));

        }catch (Exception e) {

        }
        return result;
    }
}
