package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.shop.dao.service.OrderProductService;
import vn.shop.dao.service.OrderProductService;
import vn.shop.library.common.model.dao.OrderProduct;
import vn.shop.library.common.model.dao.OrderProduct;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping(path = "/ShopeeDao/orderProduct")
@CrossOrigin(origins = "*")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @POST
    @RequestMapping(path = "/insertOrderProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertOrderProduct(@RequestBody OrderProduct orderProduct) {
        return orderProductService.insertOrderProduct(orderProduct);
    }


    @GET
    @RequestMapping(path = "/getOrderProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderProduct> getOrderProduct(@RequestParam(name = "userEmail") String userEmail) {
        return orderProductService.getOrderProduct(userEmail);
    }


    @GET
    @RequestMapping(path = "/getOrderProductByFacture", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderProduct> getOrderProductByFacture(@RequestParam(name = "factureCode") String factureCode) {
        return orderProductService.getOrderProductByFacture(factureCode);
    }
    //
    @GET
    @RequestMapping(path = "/getAllOrderProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderProduct> getAllOrderProduct() {
        return orderProductService.getAllOrderProduct();
    }

    @POST
    @RequestMapping(path = "/updateOrderProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateOrderProduct(@RequestBody OrderProduct orderProduct) {
        return orderProductService.updateOrderProduct(orderProduct);
    }
    @GET
    @RequestMapping(path = "/deleteOrderProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteOrderProduct(@RequestParam(name = "orderProductCode") String orderProductCode) {
        return orderProductService.deleteOrderProduct(orderProductCode);
    }
}
