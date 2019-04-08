package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.UserDao;
import vn.shop.dao.service.UserSevice;
import vn.shop.library.common.model.dao.User;

import java.util.List;

/**
 * Created by lttung on 12/12/2018.
 */
@Service("userService")
public class UserServiceImpl implements UserSevice {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUser(String userName, String password) {
        return userDao.getUser(userName, password);
    }
    @Override
    public List<User> getAllUser(){ return userDao.getAllUser(); }
    @Override
    public List<User> getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
