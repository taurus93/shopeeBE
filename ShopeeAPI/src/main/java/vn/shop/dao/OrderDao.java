package vn.shop.dao;

import vn.shop.library.common.model.dao.Client;
import vn.shop.library.common.model.dao.Order;

import java.util.List;

/**
 * Created by lttung on 12/17/2018.
 */
public interface OrderDao {
    int insertOrder(Order order);

    List<Order> getOrder(int orderDetailsID);

    List<Order> getAllOrder();

//    int updateOrder(Order order);
}
