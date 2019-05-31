package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.shop.dao.service.ReceiverService;
import vn.shop.dao.service.UserSevice;
import vn.shop.library.common.model.dao.Receiver;
import vn.shop.library.common.model.dao.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @POST
    @RequestMapping(path = "/insertReceiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertReceiver(@RequestBody Receiver receiver) {
        return receiverService.insertReceiver(receiver);
    }

    @GET
    @RequestMapping(path = "/getAllReceiverByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Receiver> getAllReceiverByUser(@RequestParam String userEmail) {
        return receiverService.getAllReceiverByUser(userEmail);
    }


    @GET
    @RequestMapping(path = "/getAllReceiverByFacture", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Receiver> getAllReceiverByFacture(@RequestParam String factureCode) {
        return receiverService.getAllReceiverByFacture(factureCode);
    }

    @GET
    @RequestMapping(path = "/getAllReceiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Receiver> getAllReceiver() {
        return receiverService.getAllReceiver();
    }

    @GET
    @RequestMapping(path = "/deleteReceiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteReceiver(@RequestParam String receiverCode) {
        return receiverService.deleteReceiver(receiverCode);
    }

    @POST
    @RequestMapping(path = "/selectReceiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public int selectReceiver(@RequestBody Receiver receiver) {
        return receiverService.selectReceiver(receiver);
    }

}
