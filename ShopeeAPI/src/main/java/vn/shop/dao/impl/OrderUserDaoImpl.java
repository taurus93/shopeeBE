package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.OrderUserDao;
import vn.shop.dao.jdbc.OrderProductMapper;
import vn.shop.dao.jdbc.OrderUserMapper;
import vn.shop.library.common.model.dao.OrderProduct;
import vn.shop.library.common.model.dao.OrderUser;

import java.util.ArrayList;
import java.util.List;

@Repository("orderUserDao")
public class OrderUserDaoImpl implements OrderUserDao {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(OrderUserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertOrderUser(OrderUser orderUser) {
        logger.info("Begin insert");
        String sql = "INSERT INTO OrderUser(orderCode, orderDate, quantity, userEmail) value(?, ?, ?, ?)";
        try {

            return jdbcTemplate.update(sql, new Object[]{orderUser.getOrderCode(), orderUser.getOrderDate(), orderUser.getQuantity(), orderUser.getUserEmail()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<OrderUser> getOrderUserByUserEmail(String userEmail) {

        logger.info("Begin get OrderUser");

        String sql = "SELECT * FROM orderuser WHERE userEmail = ?";

        List<OrderUser> ret = new ArrayList<>();

        for(int i=0; i<ret.size(); i++) {
            String orderCodeTmp = ret.get(i).getOrderCode();
            String sql1 = "SELECT * FROM orderproduct WHERE orderCode = ?";

            List<OrderProduct> ret1 = new ArrayList<>();
            try {

                ret1 =  jdbcTemplate.query(sql1, new Object[]{orderCodeTmp}, new OrderProductMapper());

            } catch (Exception e) {
                logger.info(e.getMessage(), e);
            }
        }
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{userEmail}, new OrderUserMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get, result: Success" + result);
        return ret;
    }

    @Override
    public List<OrderUser> getAllOrderUser() {

        logger.info("Begin get all OrderUser");

        String sql = "SELECT * FROM OrderUser";

        List<OrderUser> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new OrderUserMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all OrderUser, result: SUCCESS " + ret);

        return ret;
    }

    @Override
    public int updateOrderUser(OrderUser orderUser) {
        logger.info("Begin update");

        String sql = "UPDATE orderuser SET orderCode = ?, orderDate = ?, quantity = ?, userEmail = ? WHERE orderDate = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{orderUser.getOrderCode(), orderUser.getOrderDate(), orderUser.getQuantity(), orderUser.getUserEmail()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End update, FAIL");
        return 0;
    }

    @Override
    public int deleteOrderUser(String orderUserCode) {
        logger.info("Begin");

        String sql = "DELETE FROM orderuser WHERE orderUserCode = ?";

        try {
            return jdbcTemplate.update(sql, new Object[]{orderUserCode});
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return 0;
    }
}
