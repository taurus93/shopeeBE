package vn.shop.dao.service;

import vn.shop.library.common.model.dao.Order;

import java.util.List;

public interface OrderService {
    /**
     * Returns an Order
     *
     * @return
     * <code>
     * List User
     * </code>
     */
    List<Order> getAllOrder();

    /**
     * Returns an User
     *
     * @param  OrderCode
     * @return
     * <code>
     * List Order
     * </code>
     */
    List<Order> getOrder(int OrderCode);

    /**
     * Returns an User
     *
     * @param  order
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int insertOrder(Order order);

    /**
     * Returns an Order
     *
     * @param  Order
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
//    int updateOrder(Order Order);
}
