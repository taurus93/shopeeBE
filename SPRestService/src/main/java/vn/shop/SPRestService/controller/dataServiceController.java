package vn.shop.SPRestService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.shop.SPRestService.api.DataServiceV1;
import vn.shop.library.common.model.dao.Category;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@EnableAutoConfiguration
@RequestMapping(path = "/dataService")
@CrossOrigin(origins = "*")
@Produces(MediaType.APPLICATION_JSON)
public class dataServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private DataServiceV1 dataServiceV1;

    @GET
    @RequestMapping(value = "/getAllCategory")
    public String getAllUser() {
        String result = "";
        try {
            result = dataServiceV1.getAllCategory();
        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    @POST
    @RequestMapping(value = "/insertCategory")
    public String insertCategory(@RequestBody Category category) {
        String result = "";
        try {
            result = dataServiceV1.insertCategory(category);
        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

}
