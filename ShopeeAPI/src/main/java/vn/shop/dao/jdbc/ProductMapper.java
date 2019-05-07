package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Product;

import javax.ws.rs.Produces;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lttung on 4/22/2019.
 */
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Product result = new Product();
        try {

            result.setProductCode(resultSet.getString(ConstantUtil.productCode));
            result.setProductName(resultSet.getString(ConstantUtil.productName));
            result.setProductPrice(resultSet.getFloat(ConstantUtil.productPrice));
            result.setProductPicture(resultSet.getString(ConstantUtil.productPicture));
            result.setProductDescription(resultSet.getString(ConstantUtil.productDescription));
            result.setCategoryID_FK(resultSet.getInt(ConstantUtil.categoryID_FK));

        }catch (Exception e) {

        }
        return result;
    }
}
