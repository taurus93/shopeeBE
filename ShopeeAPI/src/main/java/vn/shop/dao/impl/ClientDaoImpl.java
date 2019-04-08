package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.ClientDao;
import vn.shop.dao.jdbc.ClientMapper;
import vn.shop.library.common.model.dao.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lttung on 12/12/2018.
 */
@Repository("clientDao")
public class ClientDaoImpl implements ClientDao{

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertClient(Client client) {
        logger.info("Begin insert user");
        String sql = "INSERT INTO user(firstName, lastName, phoneNumber, emailAddress, street, suburb, city, state, postcode) value(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            return jdbcTemplate.update(sql, new Object[]{client.getFirstName(), client.getLastName(), client.getLastName(),
            client.getEmailAddress(), client.getStreet(), client.getSuburb(), client.getCity(), client.getState(), client.getPostcode()});

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return 0;
    }

    @Override
    public List<Client> getClient(String emailAddress) {

        logger.info("Begin get client by email");

        String sql = "SELECT * FROM client WHERE emailAddress = ?";

        List<Client> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{emailAddress}, new ClientMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list user, result: Success" + result);
        return ret;
    }

    @Override
    public List<Client> getAllClient() {

        logger.info("Begin get all client");

        String sql = "SELECT * FROM client";

        List<Client> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new ClientMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all client, result: SUCCESS " + ret);

        return ret;
    }

    @Override
    public List<Client> getClientByClientName(String firstName) {
        logger.info("Begin getUser by user by client's name");

        String sql = "SELECT * FROM client where clientName = ?";

        List<Client> ret = new ArrayList<>();

        try {

            ret = jdbcTemplate.query(sql, new Object[]{firstName}, new ClientMapper());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End getUser by user by client's name, result: "+result);
        return ret;
    }

    @Override
    public int updateClient(Client client) {
        logger.info("Begin update client");

        String sql = "UPDATE client SET firstName = ?, lastName = ?, phoneNumber = ?" +
                ", street = ?, suburb = ?, city = ?" +
                ", state = ?, postcode = ? WHERE emailAddress = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{client.getFirstName(), client.getLastName(), client.getPhoneNumber(), client.getStreet(),
            client.getSuburb(), client.getCity(), client.getState(), client.getPostcode()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End update client, FAIL");
        return 0;
    }
}
