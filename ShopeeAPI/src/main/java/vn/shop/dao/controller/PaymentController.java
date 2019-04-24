package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.shop.dao.service.CategoryService;
import vn.shop.dao.service.PaymentService;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Payment;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping(path = "/ShopeeDao/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

//    @POST
//    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUser(@RequestBody User user) {
//        return clientSevice.getUser(user.getUserName(), user.getPassword());
//    }

    @GET
    @RequestMapping(path = "/getAllPayment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }


    @POST
    @RequestMapping(path = "/insertPayment", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertPayment(@RequestBody Payment payment) {
        return paymentService.insertPayment(payment);
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
