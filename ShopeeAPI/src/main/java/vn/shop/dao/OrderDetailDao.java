package vn.shop.dao;

import vn.shop.library.common.model.dao.OrderDetail;

import java.util.List;

/**
 * Created by lttung on 12/17/2018.
 */
public interface OrderDetailDao {
    OrderDetail insertOrder(OrderDetail orderDetail);

    List<OrderDetail> getOrder(int orderDetailsID);

    List<OrderDetail> getAllOrder();

    List<OrderDetail> getAllOrderByUser(String userEmail);

    List<OrderDetail> deleteOrder(String orderCode);
//    int updateOrder(OrderDetail order);
}
