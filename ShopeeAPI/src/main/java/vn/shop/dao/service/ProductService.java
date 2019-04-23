package vn.shop.dao.service;

import vn.shop.library.common.model.dao.Product;
import vn.shop.library.common.model.dao.User;

import java.util.List;

/**
 * Created by lttung on 4/23/2019.
 */
public interface ProductService {

    /**
     * Returns an Product
     *
     * @return
     * <code>
     * List User
     * </code>
     */
    List<Product> getAllProduct();

    /**
     * Returns an User
     *
     * @param  productCode
     * @return
     * <code>
     * List Product
     * </code>
     */
//    List<Product> getProduct(String productCode);

    /**
     * Returns an User
     *
     * @param  product
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    String insertProduct(Product product);

    /**
     * Returns an Product
     *
     * @param  product
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
//    int updateProduct(Product product);
}
