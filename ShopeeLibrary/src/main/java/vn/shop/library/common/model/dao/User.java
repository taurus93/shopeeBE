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
//    private Integer userID;
    private String userName;
    private String userEmail;
    private String password;
    private String profile;
    private String street;
    private String suburb;
    private String city;
//    private String state;
    private String postcode;

//    public Integer getUserID() {
//        return userID;
//    }

//    public void setUserID(Integer userID) {
//        this.userID = userID;
//    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

}
