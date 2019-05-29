package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.ReceiverDao;
import vn.shop.dao.jdbc.ReceiverMapper;
import vn.shop.dao.jdbc.UserMapper;
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
}
