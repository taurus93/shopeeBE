package vn.shop.dao;

import vn.shop.library.common.model.dao.OrderProduct;

import java.util.List;

public interface OrderProductDao {
    int insertOrderProduct(OrderProduct orderProduct);

    List<OrderProduct> getOrderProduct(String userEmail);

    List<OrderProduct> getOrderProductByFacture(String factureCode);

//    List<OrderProduct> getOrderProductByOrderID(int orderID);

    List<OrderProduct> getAllOrderProduct();

    int updateOrderProduct(OrderProduct orderProduct);

    int deleteOrderProduct(String orderProductCode);
}
