package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.shop.dao.service.ReceiverService;
import vn.shop.dao.service.UserSevice;
import vn.shop.library.common.model.dao.Receiver;
import vn.shop.library.common.model.dao.User;

import javax.ws.rs.GET;
import java.util.List;

/**
 * Created by lttung on 5/29/2019.
 */
@RestController
@RequestMapping(path = "/ShopeeDao/receiver")
@CrossOrigin(origins = "*")
public class RecevierController {

    @Autowired
    private ReceiverService receiverService;

    @GET
    @RequestMapping(path = "/getAllReceiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Receiver> getAllReceiver() {
        return receiverService.getAllReceiver();
    }

}
