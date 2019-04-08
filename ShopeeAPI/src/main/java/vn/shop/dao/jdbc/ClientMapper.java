package vn.shop.dao.jdbc;


import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.Client;
import vn.shop.library.common.model.dao.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lttung on 12/12/2018.
 */
public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Client result = new Client();
        try {

            result.setClientID(resultSet.getInt(ConstantUtil.CLIENT_ID));
            result.setFirstName(resultSet.getString(ConstantUtil.FIRST_NAME));
            result.setLastName(resultSet.getString(ConstantUtil.LAST_NAME));
            result.setPhoneNumber(resultSet.getString(ConstantUtil.PHONE_NUMBER));
            result.setEmailAddress(resultSet.getString(ConstantUtil.EMAIL_ADDRESS));
            result.setStreet(resultSet.getString(ConstantUtil.STREET));
            result.setSuburb(resultSet.getString(ConstantUtil.SUBURB));
            result.setCity(resultSet.getString(ConstantUtil.CITY));
            result.setState(resultSet.getString(ConstantUtil.STATE));
            result.setPostcode(resultSet.getString(ConstantUtil.POSTCODE));

        }catch (Exception e) {

        }
        return result;
    }

}
