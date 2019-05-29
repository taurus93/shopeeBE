package vn.shop.dao.jdbc;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import vn.shop.dao.ProductDao;
import vn.shop.dao.impl.ProductDaoImpl;
import vn.shop.library.common.model.dao.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by lttung on 5/29/2019.
 */
public class CallableGetProduct implements Callable<List<Product>>{

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CallableGetProduct.class);
    @Autowired
    private ProductDao productDao;

    private String productCode;

    public CallableGetProduct(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public List<Product> call() throws Exception {
        Map<String, String> mapResult = new HashMap<>();
        List<Product> listProduct = new ArrayList<>();
        try {
            listProduct = productDao.getProduct(this.productCode);
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return listProduct;
    }

}
