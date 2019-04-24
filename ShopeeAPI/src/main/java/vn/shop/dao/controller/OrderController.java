package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.shop.dao.service.OrderService;
import vn.shop.dao.service.OrderService;
import vn.shop.library.common.model.dao.Order;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

public class OrderController {

    @Autowired
    private OrderService orderService;

//    @POST
//    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUser(@RequestBody User user) {
//        return clientSevice.getUser(user.getUserName(), user.getPassword());
//    }

    @GET
    @RequestMapping(path = "/getAllOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }


    @POST
    @RequestMapping(path = "/insertOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertUser(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }
    //
    @GET
    @RequestMapping(path = "/getOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getUserByUserName(@RequestParam(name = "orderCode") int orderCode) {
        return orderService.getOrder(orderCode);
    }
//
//    @PUT
//    @RequestMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public int updateUser(@RequestBody User user) {
//        return clientSevice.updateUser(user);
//    }
}
