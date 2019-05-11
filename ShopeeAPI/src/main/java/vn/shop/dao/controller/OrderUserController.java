package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.shop.dao.service.OrderUserService;
import vn.shop.dao.service.OrderUserService;
import vn.shop.library.common.model.dao.OrderUser;
import vn.shop.library.common.model.dao.OrderUser;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping(path = "/ShopeeDao/orderUser")
@CrossOrigin(origins = "*")
public class OrderUserController {

    @Autowired
    private OrderUserService orderUserService;

//    @POST
//    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUser(@RequestBody User user) {
//        return clientSevice.getUser(user.getUserName(), user.getPassword());
//    }

    @POST
    @RequestMapping(path = "/insertOrderUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertOrderUser(@RequestBody OrderUser orderUser) {
        return orderUserService.insertOrderUser(orderUser);
    }


    @GET
    @RequestMapping(path = "/getOrderUserByUserEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderUser> getOrderUserByUserEmail(@RequestParam String userEmail) {
        return orderUserService.getOrderUserByUserEmail(userEmail);
    }
    //
    @GET
    @RequestMapping(path = "/getAllOrderUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderUser> getAllOrderUser() {
        return orderUserService.getAllOrderUser();
    }

    @POST
    @RequestMapping(path = "/updateOrderUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateOrderUser(@RequestBody OrderUser orderUser) {
        return orderUserService.updateOrderUser(orderUser);
    }
    @GET
    @RequestMapping(path = "/deleteOrderUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteOrderUser(@RequestParam(name = "orderUserCode") String orderUserCode) {
        return orderUserService.deleteOrderUser(orderUserCode);
    }
//
//    @PUT
//    @RequestMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public int updateUser(@RequestBody User user) {
//        return clientSevice.updateUser(user);
//    }
    
}
