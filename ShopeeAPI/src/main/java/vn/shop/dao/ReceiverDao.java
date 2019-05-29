package vn.shop.dao;

import org.json.JSONObject;
import vn.shop.library.common.model.dao.Facture;
import vn.shop.library.common.model.dao.Receiver;

import java.util.List;

/**
 * Created by lttung on 5/29/2019.
 */
public interface ReceiverDao {

//    int insertFacture(JSONObject jsonObject);

//    List<Facture> getFacture(int factureID);

//    List<Facture> getFactureByUserEmail(String userEmail);

    List<Receiver> getAllReceiver();

//    int updateFacture(Facture facture);
}
