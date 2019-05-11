package vn.shop.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.shop.dao.service.FactureService;
import vn.shop.library.common.model.dao.Facture;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping(path = "/ShopeeDao/facture")
@CrossOrigin(origins = "*")
public class FactureController {

    @Autowired
    private FactureService factureService;

//    @POST
//    @RequestMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getUser(@RequestBody User user) {
//        return clientSevice.getUser(user.getUserName(), user.getPassword());
//    }

    @GET
    @RequestMapping(path = "/getAllFacture", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Facture> getAllFacture() {
        return factureService.getAllFacture();
    }


    @POST
    @RequestMapping(path = "/insertFacture", produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertFacture(@RequestBody Facture facture) {
        return factureService.insertFacture(facture);
    }

    @GET
    @RequestMapping(path = "/getFactureByUserEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Facture> getFactureByUserEmail(@RequestParam(name = "userEmail") String userEmail) {
        return factureService.getFactureByUserEmail(userEmail);
    }
//
//    @PUT
//    @RequestMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    public int updateUser(@RequestBody User user) {
//        return clientSevice.updateUser(user);
//    }
    
}
