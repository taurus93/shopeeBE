package vn.shop.dao.service;

import vn.shop.library.common.model.dao.Client;

import java.util.List;

/**
 * Created by lttung on 12/12/2018.
 */
public interface ClientSevice {
    /**
     * Returns boolean
     *
     * @param  client
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
//    int insertClient(Client client);

    /**
     * Returns an Client
     *
     * @param  emailAddress
     * @return
     * <code>
     * List Client
     * </code>
     */
//    List<Client> getClient(String emailAddress);

    /**
     * Returns an Client
     *
     * @return
     * <code>
     * List Client
     * </code>
     */
    List<Client> getAllClient();

    /**
     * Returns an Client
     *
     * @param  clientName
     * @return
     * <code>
     * List Client
     * </code>
     */
//    List<Client> getClientByClientName(String clientName);

    /**
     * Returns boolean
     *
     * @param  client
     * @return
     * <code> 0 : unsuccess</code>
     * <code> 1 : success</code>
     */
//    int updateClient(Client client);
}
