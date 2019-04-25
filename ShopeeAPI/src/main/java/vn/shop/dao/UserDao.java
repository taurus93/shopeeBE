package vn.shop.dao;

import vn.shop.library.common.model.dao.User;

import java.util.List;

/**
 * Created by lttung on 12/12/2018.
 */
public interface UserDao {

    int insertUser(User user);

    List<User> getUser(String userName, String password);

    List<User> getAllUser();

    List<User> getUserByUserName(String userName);

    int updateUser(User user);

    List<User> authenticate(String userEmail, String password);
}
