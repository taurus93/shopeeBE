package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.shop.dao.service.OrderDetailService;
import vn.shop.library.common.model.dao.OrderDetail;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping(path = "/ShopeeDao/orderDetail")
@CrossOrigin(origins = "*")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderService;

//    @POST
//    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUser(@RequestBody User user) {
//        return clientSevice.getUser(user.getUserName(), user.getPassword());
//    }

    @GET
    @RequestMapping(path = "/getAllOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetail> getAllOrder() {
        return orderService.getAllOrder();
    }


    @POST
    @RequestMapping(path = "/insertOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDetail insertUser(@RequestBody OrderDetail orderDetail) {
        return orderService.insertOrder(orderDetail);
    }
    //
    @GET
    @RequestMapping(path = "/getOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetail> getUserByUserName(@RequestParam(name = "orderCode") int orderCode) {
        return orderService.getOrder(orderCode);
    }
    @GET
    @RequestMapping(path = "/getAllOrderByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetail> getAllOrderByUser(@RequestParam(name = "userEmail") String userEmail) {
        return orderService.getAllOrderByUser(userEmail);
    }
    @GET
    @RequestMapping(path = "/deleteOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetail> deleteOrder(@RequestParam(name = "orderCode") String orderCode) {
        return orderService.deleteOrder(orderCode);
    }
//
//    @PUT
//    @RequestMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public int updateUser(@RequestBody User user) {
//        return clientSevice.updateUser(user);
//    }
}
