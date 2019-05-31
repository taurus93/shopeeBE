package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.ReceiverDao;
import vn.shop.dao.jdbc.ReceiverMapper;
import vn.shop.dao.jdbc.UserMapper;
import vn.shop.library.common.model.dao.Facture;
import vn.shop.library.common.model.dao.Receiver;
import vn.shop.library.common.model.dao.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lttung on 5/29/2019.
 */
@Repository("receiverDao")
public class ReceiverDaoImpl implements ReceiverDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ReceiverDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FactureDaoImpl factureDao;

    @Override
    public int insertReceiver(Receiver receiver) {

        logger.info("Begin insert");
        String sql = "INSERT INTO receiver(receiverCode, name, phoneNumber, city, county, wards, street, userEmail, receiverDefault) value(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            return jdbcTemplate.update(sql, new Object[]{receiver.getReceiverCode(), receiver.getName(), receiver.getPhoneNumber(),
                    receiver.getCity(), receiver.getCounty(), receiver.getWards(), receiver.getStreet(), receiver.getUserEmail(), receiver.getReceiverDefault()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<Receiver> getAllReceiverByUser(String userEmail) {

        logger.info("Begin get all");

        String sql = "SELECT * FROM receiver WHERE (userEmail = ? AND receiverCode != '1')";

        List<Receiver> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{userEmail}, new ReceiverMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all user, result: SUCCESS" + ret);

        return ret;
    }

    @Override
    public List<Receiver> getAllReceiverByFacture(String factureCode) {

        logger.info("Begin get all");

        List<Facture> facture = factureDao.getFacture(factureCode);

        String receiverCode = facture.get(0).getReceiverCode();

        String sql = "SELECT * FROM receiver WHERE receiverCode = ?";

        List<Receiver> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{receiverCode}, new ReceiverMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all user, result: SUCCESS" + ret);

        return ret;
    }

    @Override
    public List<Receiver> getAllReceiver() {

        logger.info("Begin get all");

        String sql = "SELECT * FROM receiver";

        List<Receiver> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new ReceiverMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all user, result: SUCCESS" + ret);

        return ret;
    }

    @Override
    public int selectReceiver(Receiver receiver) {

        logger.info("Begin");

        String sql = "UPDATE receiver SET receiverDefault = 'false' WHERE userEmail = ?";

        try {

            jdbcTemplate.update(sql, new Object[]{receiver.getUserEmail()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        String sql1 = "UPDATE receiver SET receiverDefault = 'true' WHERE receiverCode = ?";

        try {

            return jdbcTemplate.update(sql1, new Object[]{receiver.getReceiverCode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End, FAIL");
        return 0;
    }


    @Override
    public int deleteReceiver(String receiverCode) {
        logger.info("Begin");

        String sql = "DELETE FROM receiver WHERE receiverCode = ?";

        try {
            return jdbcTemplate.update(sql, new Object[]{receiverCode});
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return 0;
    }
}
