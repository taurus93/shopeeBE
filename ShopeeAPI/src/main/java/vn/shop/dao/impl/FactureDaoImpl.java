package vn.shop.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
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
    public int insertFacture(JSONObject jsonObject) {
        logger.info("Begin insert Facture");

        JSONArray ret = jsonObject.getJSONArray("orderList");
        Facture facture = new Facture();
        try {
            facture = new ObjectMapper().readValue(jsonObject.get("facture").toString(), Facture.class);
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int quantity = facture.getQuantity();
        String status = "choThanhToan";
        Float totalPrice = facture.getTotalPrice();

//        insert facture
        String sql1 = "INSERT INTO facture(factureCode, userEmail, quantity, totalPrice, status, receiverCode) value(?, ?, ?, ?, ?, ?)";
        try {

            jdbcTemplate.update(sql1, new Object[]{facture.getFactureCode(), facture.getUserEmail(),
                    quantity, totalPrice, status, facture.getUserEmail()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        // update order product
        String sql3 = "UPDATE orderproduct SET status = ?, factureCode = ? where orderCode = ?";

        try {
            for(int i=0; i<ret.length(); i++) {
                OrderProduct orderProduct = new OrderProduct();
                try {
                    orderProduct = new ObjectMapper().readValue(ret.get(i).toString(), OrderProduct.class);
                    jdbcTemplate.update(sql3, new Object[]{2, facture.getFactureCode(), orderProduct.getOrderCode()});
                }catch (Exception e) {
                    logger.info(e.getMessage(), e);
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 1;
    }

    @Override
    public List<Facture> getFacture(String factureCode) {

        logger.info("Begin get list Facture");

        String sql = "SELECT * FROM facture WHERE factureCode = ?";

        List<Facture> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{factureCode}, new FactureMapper());

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

            return jdbcTemplate.update(sql, new Object[]{facture.getUserEmail(),
                    facture.getQuantity(), facture.getStatus(), facture.getFactureCode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End updateFactureMappingSSO, FAIL");
        return 0;
    }
    
}
