package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.FactureDao;
import vn.shop.dao.jdbc.FactureMapper;
import vn.shop.dao.jdbc.OrderProductMapper;
import vn.shop.library.common.model.dao.Facture;
import vn.shop.library.common.model.dao.OrderProduct;

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

//        get order product
        String sql = "SELECT * FROM orderproduct WHERE factureCode = ?";

        List<OrderProduct> ret = new ArrayList<>();
        try {

            ret = jdbcTemplate.query(sql, new Object[]{facture.getFactureCode()}, new OrderProductMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        String productName = ret.get(0).getProductName();
        int quantity = ret.get(0).getQuantity();
        int status = 2;
        Float totalPrice = ret.get(0).getTotalPrice();

//        insert facture
        String sql1 = "INSERT INTO facture(factureCode, userEmail, productName, quantity, totalPrice, status) value(?, ?, ?, ?, ?, ?)";
        try {

            jdbcTemplate.update(sql1, new Object[]{facture.getFactureCode(), facture.getUserEmail(),
            productName, quantity, totalPrice, status});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        // update order product
        String sql3 = "UPDATE orderproduct SET status = ? where orderCode = ?";

        try {

            jdbcTemplate.update(sql3, new Object[]{status, ret.get(0).getOrderCode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 1;
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
    public List<Facture> getFactureByUserEmail(String userEmail) {

        logger.info("Begin get list Facture");

        String sql = "SELECT * FROM facture WHERE userEmail = ?";

        List<Facture> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{userEmail}, new FactureMapper());

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

        String sql = "UPDATE facture SET userEmail = ?, productName = ?, quantity = ?, totalPrice = ?, status = ? WHERE factureCode = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{facture.getUserEmail(), facture.getProductName(),
                    facture.getQuantity(), facture.getStatus(), facture.getFactureCode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End updateFactureMappingSSO, FAIL");
        return 0;
    }
    
}
