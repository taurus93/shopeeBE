package vn.shop.dao.service;

import org.json.JSONObject;
import vn.shop.library.common.model.dao.Facture;

import java.util.List;

public interface FactureService {

    /**
     * Returns boolean
     *
     * @param  jsonObject
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
     int insertFacture(JSONObject jsonObject);

    /**
     * Returns an Facture
     *
     * @param  factureID
     * @return
     * <code>
     * List Facture
     * </code>
     */
    List<Facture> getFacture(int factureID);

    /**
     * Returns an Facture
     *
     * @return
     * <code>
     * List Facture
     * </code>
     */
    List<Facture> getFactureByUserEmail(String userEmail);

    /**
     * Returns an Facture
     *
     * @return
     * <code>
     * List Facture
     * </code>
     */
    List<Facture> getAllFacture();

    /**
     * Returns boolean
     *
     * @param  facture
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
//    int updateFacture(Facture facture);
    
}
