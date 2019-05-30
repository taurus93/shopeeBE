package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shop.dao.ReceiverDao;
import vn.shop.dao.UserDao;
import vn.shop.dao.service.ReceiverService;
import vn.shop.library.common.model.dao.Receiver;
import vn.shop.library.common.model.dao.User;

import java.util.List;

/**
 * Created by lttung on 5/29/2019.
 */
@Service("receiverService")
public class ReceiverServiceImpl implements ReceiverService{

    @Autowired
    private ReceiverDao receiverDao;

    @Override
    public int insertReceiver(Receiver receiver){ return receiverDao.insertReceiver(receiver); }

    @Override
    public List<Receiver> getAllReceiverByUser(String userEmail){ return receiverDao.getAllReceiverByUser(userEmail); }

    @Override
    public List<Receiver> getAllReceiver(){ return receiverDao.getAllReceiver(); }

    @Override
    public int deleteReceiver(String receiverCode){ return receiverDao.deleteReceiver(receiverCode); }

    @Override
    public int selectReceiver(Receiver receiver){ return receiverDao.selectReceiver(receiver); }

}
