package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.ClientDao;
import vn.shop.dao.service.ClientSevice;
import vn.shop.library.common.model.dao.Client;

import java.util.List;

/**
 * Created by lttung on 1/2/2019.
 */
@Service("clientService")
public class ClientServiceImpl implements ClientSevice{

    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> getAllClient() {
        return clientDao.getAllClient();
    }

}
