package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.OrderDetail;
import vn.shop.library.common.model.dao.OrderUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderUserMapper implements RowMapper<OrderUser> {

    @Override
    public OrderUser mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        OrderUser result = new OrderUser();
        try {

            result.setOrderCode(resultSet.getString(ConstantUtil.orderCode));
            result.setOrderDate(resultSet.getString(ConstantUtil.orderDate));
            result.setQuantity(resultSet.getInt(ConstantUtil.quantity));
            result.setUserEmail(resultSet.getString(ConstantUtil.userEmail));

        }catch (Exception e) {

        }
        return result;
    }
}
