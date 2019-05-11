package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.CategoryDao;
import vn.shop.dao.ProductDao;
import vn.shop.dao.service.ProductService;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Product;

import java.util.List;

/**
 * Created by lttung on 4/23/2019.
 */
@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public String insertProduct(Product product) {
        return productDao.insertProduct(product);
    }
    @Override
    public List<Product> getProduct(String productCode) {
        return productDao.getProduct(productCode);
    }
    @Override
    public List<Product> getProductByCategory(String categoryCode) {
        return productDao.getProductByCategory(categoryCode);
    }
    @Override
    public int deleteProduct(String productCode) {
        return productDao.deleteProduct(productCode);
    }
    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }
}
