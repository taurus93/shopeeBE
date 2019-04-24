package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.ClientDao;
import vn.shop.dao.OrderDao;
import vn.shop.dao.jdbc.OrderMapper;
import vn.shop.dao.jdbc.ProductMapper;
import vn.shop.library.common.model.dao.Order;
import vn.shop.library.common.model.dao.Order;
import vn.shop.library.common.model.dao.Product;

import java.util.ArrayList;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertOrder(Order order) {
        logger.info("Begin insert");

        String sql = "SELECT * FROM product WHERE productID = ?";

        List<Product> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{order.getProductID_FK()}, new ProductMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        Float totalPrice = ret.get(0).getProductPrice() * order.getQuantity();

        String sql1 = "INSERT INTO orderdetails(orderDate, quantity, totalPrice, productID_FK, userEmail_FK, paymentID_FK) value(?, ?, ?, ?, ?, ?)";
        try {

            return jdbcTemplate.update(sql1, new Object[]{order.getOrderDate(), order.getQuantity(),
                    totalPrice, order.getProductID_FK(), order.getUserEmail_FK(), order.getPaymentID_FK()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<Order> getOrder(int orderDetailsID) {

        logger.info("Begin get Order");

        String sql = "SELECT * FROM orderdetails WHERE orderDetailsID = ?";

        List<Order> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{orderDetailsID}, new OrderMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list user, result: Success" + result);
        return ret;
    }

    @Override
    public List<Order> getAllOrder() {

        logger.info("Begin get all Order");

        String sql = "SELECT * FROM orderdetails";

        List<Order> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new OrderMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all Order, result: SUCCESS " + ret);

        return ret;
    }

//    @Override
//    public int updateOrder(Order order) {
//        logger.info("Begin update Order");
//
//        String sql = "UPDATE orderdetails SET firstName = ?, lastName = ?, phoneNumber = ?" +
//                ", street = ?, suburb = ?, city = ?" +
//                ", state = ?, postcode = ? WHERE emailAddress = ?";
//
//        try {
//
//            return jdbcTemplate.update(sql, new Object[]{Order.getFirstName(), Order.getLastName(), Order.getPhoneNumber(), Order.getStreet(),
//                    Order.getSuburb(), Order.getCity(), Order.getState(), Order.getPostcode()});
//        } catch (Exception e) {
//            logger.info(e.getMessage(), e);
//        }
//
//        logger.info("End update Order, FAIL");
//        return 0;
//    }
}
