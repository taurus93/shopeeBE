package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.ProductDao;
import vn.shop.dao.jdbc.CategoryMapper;
import vn.shop.dao.jdbc.ProductMapper;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lttung on 4/23/2019.
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertProduct(Product product) {
        logger.info("Begin insert");
        String sql = "INSERT INTO product(productCode, productName, productPrice, productPicture, productDescription, categoryCode) value(?, ?, ?, ?, ?, ?)";
        try {

            return String.valueOf(jdbcTemplate.update(sql, new Object[]{product.getProductCode(), product.getProductName(), product.getProductPrice(),
                    product.getProductPicture(), product.getProductDescription(), product.getCategoryCode()}));

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return "0";
    }

    @Override
    public List<Product> getProduct(String productCode) {

        logger.info("Begin get");

        String sql = "SELECT * FROM product WHERE productCode = ?";

        List<Product> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{productCode}, new ProductMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list category, result: Success" + result);
        return ret;
    }

    @Override
    public List<Product> getProductByCategory(String categoryCode) {

        logger.info("Begin get");

        String sql = "SELECT * FROM product WHERE categoryCode = ?";

        List<Product> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{categoryCode}, new ProductMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list category, result: Success" + result);
        return ret;
    }

    @Override
    public List<Product> getAllProduct() {

        logger.info("Begin get");

        String sql = "SELECT * FROM product";

        List<Product> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new ProductMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all, result: SUCCESS " + ret);

        return ret;
    }

    @Override
    public int updateProduct(Product product) {
        logger.info("Begin update");

        String sql = "UPDATE product SET productName = ?, productPrice = ?, productPicture = ?, productDescription = ?, categoryCode = ? WHERE productCode = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{product.getProductName(), product.getProductPrice(), product.getProductPicture(),
                    product.getProductDescription(), product.getCategoryCode(), product.getProductCode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End update, FAIL");
        return 0;
    }
    @Override
    public int deleteProduct(String productCode) {
        logger.info("Begin");

        String sql = "DELETE FROM product WHERE productCode = ?";

        try {
            return jdbcTemplate.update(sql, new Object[]{productCode});
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return 0;
    }
}
