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
}
