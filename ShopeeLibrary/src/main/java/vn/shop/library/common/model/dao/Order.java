package vn.shop.library.common.model.dao;

import java.io.Serializable;

public class Order implements Serializable {
    /**
     *
     * */
    private static final long serialVersionUID = 1L;
    private Integer orderDetailsID;
    private String orderDate;
    private Integer quantity;
    private Float totalPrice;
    private Integer productID_FK;
    private String userEmail_FK;
    private Integer paymentID_FK;

    public Integer getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(Integer orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getProductID_FK() {
        return productID_FK;
    }

    public void setProductID_FK(Integer productID_FK) {
        this.productID_FK = productID_FK;
    }

    public String getUserEmail_FK() {
        return userEmail_FK;
    }

    public void setUserEmail_FK(String userEmail_FK) {
        this.userEmail_FK = userEmail_FK;
    }

    public Integer getPaymentID_FK() {
        return paymentID_FK;
    }

    public void setPaymentID_FK(Integer paymentID_FK) {
        this.paymentID_FK = paymentID_FK;
    }

}