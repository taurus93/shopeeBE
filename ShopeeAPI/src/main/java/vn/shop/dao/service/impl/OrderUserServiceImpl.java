package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import vn.shop.dao.OrderUserDao;
import vn.shop.dao.OrderUserDao;
import vn.shop.dao.service.OrderUserService;
import vn.shop.library.common.model.dao.OrderUser;

import java.util.List;

@Service("orderUserService")
public class OrderUserServiceImpl implements OrderUserService {
    @Autowired
    private OrderUserDao orderUserDao;

    @Override
    public int insertOrderUser(OrderUser orderUser) {
        return orderUserDao.insertOrderUser(orderUser);
    }

    @Override
    public List<OrderUser> getOrderUserByUserEmail(String userEmail) {
        return orderUserDao.getOrderUserByUserEmail(userEmail);
    }

    @Override
    public List<OrderUser> getAllOrderUser() {
        return orderUserDao.getAllOrderUser();
    }

    @Override
    public int updateOrderUser(OrderUser orderUser) {
        return orderUserDao.updateOrderUser(orderUser);
    }

    @Override
    public int deleteOrderUser(String orderUserCode) {
        return orderUserDao.deleteOrderUser(orderUserCode);
    }
}
