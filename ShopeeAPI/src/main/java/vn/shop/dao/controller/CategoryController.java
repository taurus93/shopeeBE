package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.shop.dao.service.CategoryService;
import vn.shop.dao.service.ClientSevice;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Client;
import vn.shop.library.common.model.dao.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

/**
 * Created by lttung on 3/29/2019.
 */
@RestController
@RequestMapping(path = "/ShopeeDao/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @POST
//    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUser(@RequestBody User user) {
//        return clientSevice.getUser(user.getUserName(), user.getPassword());
//    }

    @GET
    @RequestMapping(path = "/getAllCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }


    @POST
    @RequestMapping(path = "/insertCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertUser(@RequestBody Category category) {
        return categoryService.insertCategory(category);
    }
//
//    @GET
//    @RequestMapping(path = "/getUserByUserName", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUserByUserName(@RequestParam(name = "userName") String userName) {
//        return clientSevice.getUserByUserName(userName);
//    }
//
//    @PUT
//    @RequestMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public int updateUser(@RequestBody User user) {
//        return clientSevice.updateUser(user);
//    }
}
