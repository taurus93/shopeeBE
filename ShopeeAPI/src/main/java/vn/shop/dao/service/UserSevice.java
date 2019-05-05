package vn.shop.dao.service;

import vn.shop.library.common.model.dao.User;

import java.util.List;

/**
 * Created by lttung on 12/12/2018.
 */
public interface UserSevice {
    /**
     * Returns an User
     *
     * @param  userName
     * @param  password
     * @return
     * <code>
     * List User
     * </code>
     */
    List<User> getUser(String userName, String password);

    /**
     * Returns an User
     *
     * @return
     * <code>
     * List User
     * </code>
     */
    List<User> getAllUser();

    /**
     * Returns an User
     *
     * @param  userEmail
     * @return
     * <code>
     * List User
     * </code>
     */
    List<User> getUserByUserName(String userEmail);

    /**
     * Returns an User
     *
     * @param  user
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int insertUser(User user);

    /**
     * Returns an User
     *
     * @param  user
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    int updateUser(User user);

    /**
     * Returns an User
     *
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
    List<User> authenticate(String userEmail, String password);

    int deleteUser(String userEmail);
}
