package vn.shop.dao.service;

import vn.shop.library.common.model.dao.OrderUser;

import java.util.List;

public interface OrderUserService {

    /**
     *
     * @return
     * <code>
     * List OrderUser
     * </code>
     */
    int insertOrderUser(OrderUser orderUser);
    /**
     * Returns an OrderUser
     *
     * @return
     * <code>
     * List OrderUser
     * </code>
     */
    List<OrderUser> getAllOrderUser();

    /**
     * Returns an OrderUser
     *
     * @param  userEmail
     * @return
     * <code>
     * List OrderUser
     * </code>
     */
    List<OrderUser> getOrderUserByUserEmail(String userEmail);

    /**
     * Returns an OrderUser
     *
     * @param  OrderUser
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int updateOrderUser(OrderUser OrderUser);

    /**
     * Returns an OrderUser
     *
     * @param  OrderUserCode
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int deleteOrderUser(String OrderUserCode);
    
}
