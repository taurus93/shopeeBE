package vn.shop.SPRestService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.shop.SPRestService.api.DataServiceV1;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lttung on 1/2/2019.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(path = "/loginService")
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private DataServiceV1 dataServiceV1;

    @GET
    @RequestMapping(value = "/getAllUser")
    public String getAllUser() {
        String result = "";
        try {
            result = dataServiceV1.getAllUser();
        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

}
