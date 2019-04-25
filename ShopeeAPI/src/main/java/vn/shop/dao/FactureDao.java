package vn.shop.dao;

import vn.shop.library.common.model.dao.Facture;
import vn.shop.library.common.model.dao.Facture;

import java.util.List;

/**
 * Created by lttung on 12/17/2018.
 */
public interface FactureDao {
    int insertFacture(Facture facture);

    List<Facture> getFacture(int factureID);

    List<Facture> getFactureByOrderID(int orderID);

    List<Facture> getAllFacture();

    int updateFacture(Facture facture);
}
