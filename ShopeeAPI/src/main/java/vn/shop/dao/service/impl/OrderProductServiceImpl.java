package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.OrderProductDao;
import vn.shop.dao.OrderProductDao;
import vn.shop.dao.service.OrderProductService;
import vn.shop.dao.service.OrderProductService;
import vn.shop.library.common.model.dao.OrderProduct;

import java.util.List;

@Service("orderProductService")
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    public int insertOrderProduct(OrderProduct orderProduct) {
        return orderProductDao.insertOrderProduct(orderProduct);
    }

    @Override
    public List<OrderProduct> getOrderProduct(String userEmail) {
        return orderProductDao.getOrderProduct(userEmail);
    }

    @Override
    public List<OrderProduct> getAllOrderProduct() {
        return orderProductDao.getAllOrderProduct();
    }

    @Override
    public int updateOrderProduct(OrderProduct orderProduct) {
        return orderProductDao.updateOrderProduct(orderProduct);
    }

    @Override
    public int deleteOrderProduct(String orderProductCode) {
        return orderProductDao.deleteOrderProduct(orderProductCode);
    }
}
