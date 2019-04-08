package vn.shop.dao;

import vn.shop.library.common.model.dao.Client;
import vn.shop.library.common.model.dao.User;

import java.util.List;

/**
 * Created by lttung on 12/17/2018.
 */
public interface ClientDao {

    int insertClient(Client client);

    List<Client> getClient(String emailAddress);

    List<Client> getAllClient();

    List<Client> getClientByClientName(String firstName);

    int updateClient(Client client);
}
