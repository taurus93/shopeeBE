package vn.shop.dao;

import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Product;

import java.util.List;

/**
 * Created by lttung on 4/22/2019.
 */
public interface ProductDao {

    String insertProduct(Product product);

    List<Product> getProduct(String productCode);

    List<Product> getProductByCategory(String categoryCode);

    List<Product> getAllProduct();

    int updateProduct(Product product);

    int deleteProduct(String productCode);

}
