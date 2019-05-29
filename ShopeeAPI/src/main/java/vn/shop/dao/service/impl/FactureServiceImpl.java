package vn.shop.dao.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.FactureDao;
import vn.shop.dao.service.FactureService;
import vn.shop.library.common.model.dao.Facture;

import java.util.List;

@Service("factureService")
public class FactureServiceImpl implements FactureService{

    @Autowired
    private FactureDao factureDao;

    @Override
    public List<Facture> getAllFacture() {
        return factureDao.getAllFacture();
    }

    @Override
    public List<Facture> getFacture(String factureCode) {
        return factureDao.getFacture(factureCode);
    }
    @Override
    public List<Facture> getFactureByUserEmail(String userEmail) {
        return factureDao.getFactureByUserEmail(userEmail);
    }
    @Override
    public int insertFacture(JSONObject jsonObject) {
        return factureDao.insertFacture(jsonObject);
    }
}
