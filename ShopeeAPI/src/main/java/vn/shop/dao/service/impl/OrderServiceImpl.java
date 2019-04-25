package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.OrderDao;
import vn.shop.dao.ProductDao;
import vn.shop.dao.service.OrderService;
import vn.shop.library.common.model.dao.Order;
import vn.shop.library.common.model.dao.Product;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    public Order insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }
    @Override
    public List<Order> getOrder(int orderID) {
        return orderDao.getOrder(orderID);
    }
    @Override
    public List<Order> getAllOrderByUser(String userEmail) {
        return orderDao.getAllOrderByUser(userEmail);
    }
    @Override
    public List<Order> deleteOrder(String orderCode) {
        return orderDao.deleteOrder(orderCode);
    }
}
