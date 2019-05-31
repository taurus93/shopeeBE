package vn.shop.dao.service;

import com.sun.org.apache.regexp.internal.RE;
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
    int insertReceiver(Receiver receiver);
    /**
     * Returns all Receiver
     *
     * @return
     * <code>
     * List Receiver
     * </code>
     */
    List<Receiver> getAllReceiverByUser(String userEmail);
    /**
     * Returns all Receiver
     *
     * @return
     * <code>
     * List Receiver
     * </code>
     */
    List<Receiver> getAllReceiverByFacture(String factureCode);
    /**
     * Returns all Receiver
     *
     * @return
     * <code>
     * List Receiver
     * </code>
     */
    List<Receiver> getAllReceiver();
    /**
     * Returns
     *
     * @return
     * <code>
     * List Receiver
     * </code>
     */
    int deleteReceiver(String receiverCode);
    /**
     * Returns
     *
     * @return
     * <code>
     * List Receiver
     * </code>
     */
    int selectReceiver(Receiver receiver);
}
