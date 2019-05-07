package vn.shop.library.common.model.dao;

import java.io.Serializable;

public class Payment implements Serializable{
    /**
     *
     * */
    private static final long serialVersionUID = 1L;
    private String paymentCode;
//    private Integer paymentID;
    private String paymentType;

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

//    public Integer getPaymentID() {
//        return paymentID;
//    }
//
//    public void setPaymentID(Integer paymentID) {
//        this.paymentID = paymentID;
//    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

}
