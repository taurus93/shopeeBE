package vn.shop.dao.service;

import vn.shop.library.common.model.dao.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    /**
     * Returns an OrderDetail
     *
     * @return
     * <code>
     * List User
     * </code>
     */
    List<OrderDetail> getAllOrder();

    /**
     * Returns an User
     *
     * @param  OrderCode
     * @return
     * <code>
     * List OrderDetail
     * </code>
     */
    List<OrderDetail> getOrder(int OrderCode);

    /**
     * Returns an User
     *
     * @param  orderDetail
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    OrderDetail insertOrder(OrderDetail orderDetail);

    /**
     * Returns an OrderDetail
     *
     * @param  OrderDetail
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
//    int updateOrder(OrderDetail OrderDetail);
    /**
     * Returns an OrderDetail
     *
     * @param  userEmail
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    List<OrderDetail> getAllOrderByUser(String userEmail);

    List<OrderDetail> deleteOrder(String orderCode);
}
