package vn.shop.dao;

import org.json.JSONObject;
import vn.shop.library.common.model.dao.Facture;
import vn.shop.library.common.model.dao.Facture;

import java.util.List;

/**
 * Created by lttung on 12/17/2018.
 */
public interface FactureDao {
    int insertFacture(JSONObject jsonObject);

    List<Facture> getFacture(String factureID);

    List<Facture> getFactureByUserEmail(String userEmail);

    List<Facture> getAllFacture();

    int updateFacture(Facture facture);
}
