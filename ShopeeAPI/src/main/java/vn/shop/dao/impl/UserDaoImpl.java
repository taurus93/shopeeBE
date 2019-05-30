package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.UserDao;
import vn.shop.dao.controller.RecevierController;
import vn.shop.dao.jdbc.UserMapper;
import vn.shop.library.common.model.dao.Receiver;
import vn.shop.library.common.model.dao.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lttung on 12/12/2018.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RecevierController recevierController;

    @Override
    public int insertUser(User user, Receiver receiver) {
        logger.info("Begin insert user");
        String sql = "INSERT INTO user(userName, phoneNumber, userEmail, password, profile, street, county, city, postcode, wards) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        try {

            result = jdbcTemplate.update(sql, new Object[]{user.getUserName(), user.getPhoneNumber(), user.getUserEmail(), user.getPassword(),
                    user.getProfile(), user.getStreet(), user.getCounty(), user.getCity(), user.getPostcode(), user.getWards()});
            recevierController.insertReceiver(receiver);

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<User> getUser(String userEmail, String password) {

        logger.info("Begin get list user");

        String sql = "SELECT * FROM user WHERE userEmail = ? AND password = ?";

        List<User> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{userEmail, password}, new UserMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list user, result: Success" + result);
        return ret;
    }

    @Override
    public List<User> getAllUser() {

        logger.info("Begin get all user");

        String sql = "SELECT * FROM user";

        List<User> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new UserMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all user, result: SUCCESS" + ret);

        return ret;
    }

    @Override
    public List<User> getUserByUserName(String userEmail) {
        logger.info("Begin getUser by user Email");

        String sql = "SELECT * FROM user where userEmail = ?";

        List<User> ret = new ArrayList<>();

        try {

            ret = jdbcTemplate.query(sql, new Object[]{userEmail}, new UserMapper());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End getUser by user by user's name, result: "+result);
        return ret;
    }

    @Override
    public int updateUser(User user) {
        logger.info("Begin updateUserMappingSSO");

        String sql = "UPDATE user SET userName = ?, phoneNumber = ?, password = ?, profile = ?," +
                "street = ?, county = ?, city = ?, postcode = ?, wards = ? WHERE userEmail = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{user.getUserName(), user.getPhoneNumber(), user.getPassword(),
                    user.getProfile(), user.getStreet(), user.getCounty(), user.getCity(), user.getPostcode(), user.getWards(), user.getUserEmail()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End updateUserMappingSSO, FAIL");
        return 0;
    }

    @Override
    public List<User> authenticate(String userEmail, String password) {
        logger.info("Begin");

        String sql = "SELECT * FROM user where userEmail = ?";

        List<User> ret = new ArrayList<>();

        try {

            ret = jdbcTemplate.query(sql, new Object[]{userEmail}, new UserMapper());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        if(ret.get(0).getPassword().equals(password)) {
            return ret;
        }else {
            logger.info("End updateUserMappingSSO, FAIL");
            return null;
        }
    }

    @Override
    public int deleteUser(String userEmail) {
        logger.info("Begin");

        String sql = "DELETE FROM user WHERE userEmail = ?";

        try {
            return jdbcTemplate.update(sql, new Object[]{userEmail});
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return 0;
    }
}
