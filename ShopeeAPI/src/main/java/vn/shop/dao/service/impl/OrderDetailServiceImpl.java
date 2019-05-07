package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.OrderDetailDao;
import vn.shop.dao.service.OrderDetailService;
import vn.shop.library.common.model.dao.OrderDetail;

import java.util.List;

@Service("orderService")
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetail> getAllOrder() {
        return orderDetailDao.getAllOrder();
    }

    @Override
    public OrderDetail insertOrder(OrderDetail orderDetail) {
        return orderDetailDao.insertOrder(orderDetail);
    }
    @Override
    public List<OrderDetail> getOrder(int orderID) {
        return orderDetailDao.getOrder(orderID);
    }
    @Override
    public List<OrderDetail> getAllOrderByUser(String userEmail) {
        return orderDetailDao.getAllOrderByUser(userEmail);
    }
    @Override
    public List<OrderDetail> deleteOrder(String orderCode) {
        return orderDetailDao.deleteOrder(orderCode);
    }
}
