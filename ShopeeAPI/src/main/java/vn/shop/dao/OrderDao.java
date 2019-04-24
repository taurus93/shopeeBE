package vn.shop.dao;

import vn.shop.library.common.model.dao.Client;
import vn.shop.library.common.model.dao.Order;

import java.util.List;

public interface OrderDao {
    int insertOrder(Order order);

    List<Order> getOrder(int orderDetailsID);

    List<Order> getAllOrder();

//    int updateOrder(Order order);
}
