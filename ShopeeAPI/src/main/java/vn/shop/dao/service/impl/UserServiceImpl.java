package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.UserDao;
import vn.shop.dao.impl.GoogleMail;
import vn.shop.dao.service.UserSevice;
import vn.shop.library.common.model.dao.Receiver;
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
    public int insertUser(User user, Receiver receiver) {
        return userDao.insertUser(user, receiver);
    }
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
    @Override
    public List<User> authenticate(String userEmail, String password) {
        return userDao.authenticate(userEmail, password);
    }
    @Override
    public int deleteUser(String userEmail) {
        return userDao.deleteUser(userEmail);
    }
    @Override
    public int resetPass(String userEmail) {
        try {
            new GoogleMail().Send("lethanhtunglc51@gmail.com", "tunglc@51", userEmail, "", "Your new pass word", "123456");
        }catch (Exception e) {
            e.printStackTrace();
        }
        User user = userDao.getUserByUserName(userEmail).get(0);
        user.setPassword("123456");
        return userDao.updateUser(user);
    }

}
