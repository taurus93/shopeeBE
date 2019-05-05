package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
@CrossOrigin(origins = "*")
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
    @RequestMapping(path = "/getUserByUserEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUserByUserName(@RequestParam(name = "userEmail") String userEmail) {
        return userSevice.getUserByUserName(userEmail);
    }

    @PUT
    @RequestMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateUser(@RequestBody User user) {
        return userSevice.updateUser(user);
    }

    @GET
    @RequestMapping(path = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> authenticate(@RequestParam(name = "userEmail") String userEmail, @RequestParam(name = "password") String password) {
        return userSevice.authenticate(userEmail, password);
    }

    @GET
    @RequestMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteUser(@RequestParam(name = "userEmail") String userEmail) {
        return userSevice.deleteUser(userEmail);
    }
}
