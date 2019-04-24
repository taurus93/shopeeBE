package vn.shop.library.common.model.dao;

import java.io.Serializable;

/**
 * Created by lttung on 12/12/2018.
 */

public class User implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer userID;
    private String userName;
    private String userEmail;
    private String password;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
