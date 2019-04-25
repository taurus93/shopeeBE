package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.FactureDao;
import vn.shop.dao.jdbc.FactureMapper;
import vn.shop.library.common.model.dao.Facture;

import java.util.ArrayList;
import java.util.List;

@Repository("factureDao")
public class FactureDaoImpl implements FactureDao{

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FactureDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertFacture(Facture facture) {
        logger.info("Begin insert Facture");
        String sql = "INSERT INTO facture(orderCode) value(?)";
        try {

            return jdbcTemplate.update(sql, new Object[]{facture.getOrderCode()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<Facture> getFacture(int factureID) {

        logger.info("Begin get list Facture");

        String sql = "SELECT * FROM facture WHERE factureID = ?";

        List<Facture> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{factureID}, new FactureMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list Facture, result: Success" + result);
        return ret;
    }

    @Override
    public List<Facture> getFactureByOrderID(int orderID) {

        logger.info("Begin get list Facture");

        String sql = "SELECT * FROM facture WHERE orderCode = ?";

        List<Facture> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{orderID}, new FactureMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list Facture, result: Success" + result);
        return ret;
    }

    @Override
    public List<Facture> getAllFacture() {

        logger.info("Begin get all Facture");

        String sql = "SELECT * FROM Facture";

        List<Facture> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new FactureMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all Facture, result: SUCCESS" + ret);

        return ret;
    }

    @Override
    public int updateFacture(Facture facture) {
        logger.info("Begin updateFactureMappingSSO");

        String sql = "UPDATE facture SET orderDetailID_FK = ? WHERE factureID = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{facture.getFactureID(), facture.getOrderCode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End updateFactureMappingSSO, FAIL");
        return 0;
    }
    
}
