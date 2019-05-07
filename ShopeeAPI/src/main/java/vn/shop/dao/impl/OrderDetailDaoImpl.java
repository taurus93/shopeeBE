package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.OrderDetailDao;
import vn.shop.dao.jdbc.OrderDetailMapper;
import vn.shop.dao.jdbc.ProductMapper;
import vn.shop.library.common.model.dao.OrderDetail;
import vn.shop.library.common.model.dao.Product;

import java.util.ArrayList;
import java.util.List;

@Repository("orderDao")
public class OrderDetailDaoImpl implements OrderDetailDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(OrderDetailDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public OrderDetail insertOrder(OrderDetail orderDetail) {
        logger.info("Begin insert");

        String sql = "SELECT * FROM product WHERE productID = ?";

        List<Product> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{orderDetail.getProductID_FK()}, new ProductMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        Float totalPrice = ret.get(0).getProductPrice() * orderDetail.getQuantity();

        String sql1 = "INSERT INTO orderdetails(orderCode, orderDate, quantity, productDescription, productID_FK, userEmail_FK, paymentID_FK) value(?, ?, ?, ?, ?, ?, ?)";
        try {

            jdbcTemplate.update(sql1, new Object[]{orderDetail.getOrderDetailCode(), orderDetail.getOrderDate(), orderDetail.getQuantity(),
                    totalPrice, orderDetail.getProductID_FK(), orderDetail.getUserEmail_FK(), orderDetail.getPaymentID_FK()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return orderDetail;
    }

    @Override
    public List<OrderDetail> getOrder(int orderDetailsID) {

        logger.info("Begin get OrderDetail");

        String sql = "SELECT * FROM orderdetails WHERE orderDetailsID = ?";

        List<OrderDetail> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{orderDetailsID}, new OrderDetailMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list user, result: Success" + result);
        return ret;
    }

    @Override
    public List<OrderDetail> getAllOrder() {

        logger.info("Begin get all OrderDetail");

        String sql = "SELECT * FROM orderdetails";

        List<OrderDetail> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new OrderDetailMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all OrderDetail, result: SUCCESS " + ret);

        return ret;
    }

    @Override
    public List<OrderDetail> getAllOrderByUser(String userEmail) {

        logger.info("Begin get all OrderDetail");

        String sql = "SELECT * FROM orderdetails WHERE userEmail_FK = ?";
        String sql1 = "SELECT * FROM product WHERE productID = ?";

        List<OrderDetail> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{userEmail}, new OrderDetailMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        for(int i=0; i<ret.size(); i++) {
            List<Product> retTmp = new ArrayList<>();

            try {
                retTmp = jdbcTemplate.query(sql1, new Object[]{ret.get(i).getProductID_FK()}, new ProductMapper());
                ret.get(i).setProductName(retTmp.get(0).getProductName());
                ret.get(i).setProductPicture(retTmp.get(0).getProductPicture());
                ret.get(i).setProductDescription(retTmp.get(0).getProductDescription());
            }catch (Exception e) {
                logger.info(e.getMessage(), e);
            }
        }

        logger.info("END get all OrderDetail, result: SUCCESS " + ret);

        return ret;
    }
    @Override
    public List<OrderDetail> deleteOrder(String orderCode) {

        logger.info("Begin get all OrderDetail");

        String sql = "DELETE FROM orderdetails WHERE orderCode = ?";

        List<OrderDetail> ret = new ArrayList<>();

        try {
            jdbcTemplate.update(sql, new Object[]{orderCode});
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return ret;
    }

//    @Override
//    public int updateOrder(OrderDetail order) {
//        logger.info("Begin update OrderDetail");
//
//        String sql = "UPDATE orderdetails SET firstName = ?, lastName = ?, phoneNumber = ?" +
//                ", street = ?, suburb = ?, city = ?" +
//                ", state = ?, postcode = ? WHERE emailAddress = ?";
//
//        try {
//
//            return jdbcTemplate.update(sql, new Object[]{OrderDetail.getFirstName(), OrderDetail.getLastName(), OrderDetail.getPhoneNumber(), OrderDetail.getStreet(),
//                    OrderDetail.getSuburb(), OrderDetail.getCity(), OrderDetail.getState(), OrderDetail.getPostcode()});
//        } catch (Exception e) {
//            logger.info(e.getMessage(), e);
//        }
//
//        logger.info("End update OrderDetail, FAIL");
//        return 0;
//    }
}
