package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.OrderProductDao;
import vn.shop.dao.OrderProductDao;
import vn.shop.dao.jdbc.OrderProductMapper;
import vn.shop.dao.jdbc.ProductMapper;
import vn.shop.library.common.model.dao.OrderProduct;
import vn.shop.library.common.model.dao.Product;

import java.util.ArrayList;
import java.util.List;

@Repository("orderProductDao")
public class OrderProductDaoImpl implements OrderProductDao {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(OrderProductDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertOrderProduct(OrderProduct orderProduct) {
        logger.info("Begin insert");

//        get product
        String sql = "SELECT * FROM product WHERE productCode = ?";

        List<Product> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{orderProduct.getProductCode()}, new ProductMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

//        insert order detail
        Float totalPrice = ret.get(0).getProductPrice() * orderProduct.getQuantity();
        String productPicture = ret.get(0).getProductPicture();
        String productName = ret.get(0).getProductName();
        String productDescription = ret.get(0).getProductDescription();
        String sql1 = "INSERT INTO orderproduct(orderCode, productCode, totalPrice, orderDate, quantity, " +
                "userEmail, productPicture, productName, productDescription, status) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            return jdbcTemplate.update(sql1, new Object[]{orderProduct.getOrderCode(), orderProduct.getProductCode(), totalPrice,
                    orderProduct.getOrderDate(), orderProduct.getQuantity(),
                    orderProduct.getUserEmail(), productPicture, productName, productDescription, orderProduct.getStatus()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<OrderProduct> getOrderProduct(String userEmail) {

        logger.info("Begin get OrderProduct");

        String sql = "SELECT * FROM orderproduct WHERE userEmail = ?";

        List<OrderProduct> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{userEmail}, new OrderProductMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get, result: Success" + result);
        return ret;
    }

    @Override
    public List<OrderProduct> getAllOrderProduct() {

        logger.info("Begin get all OrderProduct");

        String sql = "SELECT * FROM orderproduct";

        List<OrderProduct> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new OrderProductMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all OrderProduct, result: SUCCESS " + ret);

        return ret;
    }

    @Override
    public int updateOrderProduct(OrderProduct orderProduct) {
        logger.info("Begin update");

        String sql = "UPDATE orderproduct SET orderCode = ?, productCode = ?, totalPrice = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{orderProduct.getOrderCode(), orderProduct.getProductCode(), orderProduct.getTotalPrice()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End update, FAIL");
        return 0;
    }

    @Override
    public int deleteOrderProduct(String orderCode) {
        logger.info("Begin");

        String sql = "DELETE FROM orderproduct WHERE orderCode = ?";

        try {
            return jdbcTemplate.update(sql, new Object[]{orderCode});
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return 0;
    }
}
