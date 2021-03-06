package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.shop.dao.service.CategoryService;
import vn.shop.dao.service.ProductService;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Product;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

/**
 * Created by lttung on 4/23/2019.
 */
@RestController
@RequestMapping(path = "/ShopeeDao/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @POST
//    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUser(@RequestBody User user) {
//        return clientSevice.getUser(user.getUserName(), user.getPassword());
//    }

    @GET
    @RequestMapping(path = "/getAllProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }


    @POST
    @RequestMapping(path = "/insertProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public String insertUser(@RequestBody Product product) {
        return productService.insertProduct(product);
    }
//
    @GET
    @RequestMapping(path = "/getProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getUserByUserName(@RequestParam(name = "productCode") String productCode) {
        return productService.getProduct(productCode);
    }
    @GET
    @RequestMapping(path = "/getAllProductByFacture", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProductByFacture(@RequestParam(name = "factureCode") String factureCode) {
        return productService.getAllProductByFacture(factureCode);
    }
    @GET
    @RequestMapping(path = "/getProductByCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductByCategory(@RequestParam(name = "categoryCode") String categoryCode) {
        return productService.getProductByCategory(categoryCode);
    }

    @GET
    @RequestMapping(path = "/deleteProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteProduct(@RequestParam(name = "productCode") String productCode) {
        return productService.deleteProduct(productCode);
    }
//
    @POST
    @RequestMapping(path = "/updateProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
