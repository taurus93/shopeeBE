package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.shop.dao.service.UserSevice;
import vn.shop.library.common.model.dao.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import java.util.*;


/**
 * Created by lttung on 12/12/2018.
 */
@RestController
@RequestMapping(path = "/ShopeeDao/user")
public class UserController {

    @Autowired
    private UserSevice userSevice;

    @POST
    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser(@RequestBody User user) {
        return userSevice.getUser(user.getUserName(), user.getPassword());
    }

    @GET
    @RequestMapping(path = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser() {
        return userSevice.getAllUser();
    }

    @POST
    @RequestMapping(path = "/insertUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertUser(@RequestBody User user) {
        return userSevice.insertUser(user);
    }

    @GET
    @RequestMapping(path = "/getUserByUserName", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUserByUserName(@RequestParam(name = "userName") String userName) {
        return userSevice.getUserByUserName(userName);
    }

    @PUT
    @RequestMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateUser(@RequestBody User user) {
        return userSevice.updateUser(user);
    }
}
