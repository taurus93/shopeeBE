package vn.shop.dao.service;

import vn.shop.library.common.model.dao.Facture;

import java.util.List;

public interface FactureService {

    /**
     * Returns boolean
     *
     * @param  facture
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
     int insertFacture(Facture facture);

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
    List<Facture> getFactureByOrderID(int orderID);

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
