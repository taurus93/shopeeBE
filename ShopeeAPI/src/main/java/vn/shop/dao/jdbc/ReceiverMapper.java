package vn.shop.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import vn.shop.dao.util.ConstantUtil;
import vn.shop.library.common.model.dao.Receiver;
import vn.shop.library.common.model.dao.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lttung on 5/29/2019.
 */
public class ReceiverMapper implements RowMapper<Receiver> {

    @Override
    public Receiver mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Receiver result = new Receiver();
        try {

            result.setReceiverCode(resultSet.getString(ConstantUtil.receiverCode));
            result.setName(resultSet.getString(ConstantUtil.name));
            result.setPhoneNumber(resultSet.getString(ConstantUtil.phoneNumber));
            result.setCity(resultSet.getString(ConstantUtil.city));
            result.setCounty(resultSet.getString(ConstantUtil.county));
            result.setWards(resultSet.getString(ConstantUtil.wards));
            result.setStreet(resultSet.getString(ConstantUtil.street));
            result.setUserEmail(resultSet.getString(ConstantUtil.userEmail));
            result.setReceiverDefault(resultSet.getString(ConstantUtil.receiverDefault));

        }catch (Exception e) {

        }
        return result;
    }

}
