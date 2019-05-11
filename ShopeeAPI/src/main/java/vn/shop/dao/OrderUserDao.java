package vn.shop.dao;

import vn.shop.library.common.model.dao.OrderUser;

import java.util.List;

public interface OrderUserDao {
    int insertOrderUser(OrderUser orderUser);

    List<OrderUser> getOrderUserByUserEmail(String userEmail);

//    List<OrderUser> getOrderUserByOrderID(int orderID);

    List<OrderUser> getAllOrderUser();

    int updateOrderUser(OrderUser OrderUser);

    int deleteOrderUser(String orderUserCode);
}
