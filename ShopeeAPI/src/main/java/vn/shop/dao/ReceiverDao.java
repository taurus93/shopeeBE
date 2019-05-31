package vn.shop.dao;

import org.json.JSONObject;
import vn.shop.library.common.model.dao.Facture;
import vn.shop.library.common.model.dao.Receiver;

import java.util.List;

/**
 * Created by lttung on 5/29/2019.
 */
public interface ReceiverDao {

    int insertReceiver(Receiver receiver);

//    List<Facture> getFacture(int factureID);

    List<Receiver> getAllReceiverByUser(String userEmail);

    List<Receiver> getAllReceiverByFacture(String factureCode);

    List<Receiver> getAllReceiver();

    int selectReceiver(Receiver receiver);

    int deleteReceiver(String receiverCode);

//    int updateFacture(Facture facture);
}
