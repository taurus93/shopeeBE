package vn.shop.dao.jdbc;


import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lttung on 12/12/2018.
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        User result = new User();
        try {

            result.setUserID(resultSet.getInt(ConstantUtil.USER_ID));
            result.setUserName(resultSet.getString(ConstantUtil.USER_NAME));
            result.setPassword(resultSet.getString(ConstantUtil.PASSWORD));
            result.setClientID_FK(resultSet.getInt(ConstantUtil.ClientID_FK));

        }catch (Exception e) {

        }
        return result;
    }

}
