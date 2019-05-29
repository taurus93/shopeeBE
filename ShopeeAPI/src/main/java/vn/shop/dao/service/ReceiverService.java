package vn.shop.dao.service;

import vn.shop.library.common.model.dao.Receiver;
import vn.shop.library.common.model.dao.User;

import java.util.List;

/**
 * Created by lttung on 5/29/2019.
 */
public interface ReceiverService {
    /**
     * Returns all Receiver
     *
     * @return
     * <code>
     * List Receiver
     * </code>
     */
    List<Receiver> getAllReceiver();
}
