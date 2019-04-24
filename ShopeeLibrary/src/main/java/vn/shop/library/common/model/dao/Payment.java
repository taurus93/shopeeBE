package vn.shop.library.common.model.dao;

import java.io.Serializable;

public class Payment implements Serializable{
    /**
     *
     * */
    private static final long serialVersionUID = 1L;
    private Integer paymentID;
    private String paymentType;

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

}
