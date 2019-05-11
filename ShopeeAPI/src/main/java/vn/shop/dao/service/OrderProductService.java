package vn.shop.dao.service;

import vn.shop.library.common.model.dao.OrderProduct;

import java.util.List;

public interface OrderProductService {

    /**
     *
     * @return
     * <code>
     * List OrderProduct
     * </code>
     */
    int insertOrderProduct(OrderProduct orderProduct);
    /**
     * Returns an OrderProduct
     *
     * @return
     * <code>
     * List OrderProduct
     * </code>
     */
    List<OrderProduct> getOrderProduct(String userEmail);

    /**
     * Returns an OrderProduct
     *
     * @param
     * @return
     * <code>
     * List OrderProduct
     * </code>
     */
    List<OrderProduct> getAllOrderProduct();

    /**
     * Returns an OrderProduct
     *
     * @param  orderProduct
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int updateOrderProduct(OrderProduct orderProduct);

    /**
     * Returns an OrderProduct
     *
     * @param  orderProductCode
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int deleteOrderProduct(String orderProductCode);
    
}
