package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @POST
    @RequestMapping(path = "/insertCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertCategory(@RequestBody Category category) {
        return categoryService.insertCategory(category);
    }

    @GET
    @RequestMapping(path = "/getAllCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GET
    @RequestMapping(path = "/deleteCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteCategory(@RequestParam(name = "categoryCode") String categoryCode) {
        return categoryService.deleteCategory(categoryCode);
    }
//
    @POST
    @RequestMapping(path = "/updateCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }
}
