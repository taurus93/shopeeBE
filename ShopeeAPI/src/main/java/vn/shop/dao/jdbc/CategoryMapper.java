package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lttung on 3/29/2019.
 */
public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Category result = new Category();
        try {

            result.setCategoryID(resultSet.getInt(ConstantUtil.CATEGORY_ID));
            result.setCategoryName(resultSet.getString(ConstantUtil.CATEGORY_NAME));
            result.setCatDescription(resultSet.getString(ConstantUtil.CAT_DESCRIPTION));
            result.setCatPicture(resultSet.getString(ConstantUtil.CAT_PICTURE));

        }catch (Exception e) {

        }
        return result;
    }

}
