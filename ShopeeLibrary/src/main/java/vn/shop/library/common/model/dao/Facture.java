package vn.shop.library.common.model.dao;

public class Facture {
    /**
     *
     * */
    private static final long serialVersionUID = 1L;
//    private Integer factureID;
    private String orderCode;
    private String userEmail;
    private String productName;
    private int quantity;
    private Float totalPrice;
    private int status;

//    public Integer getFactureID() {
//        return factureID;
//    }
//
//    public void setFactureID(Integer factureID) {
//        this.factureID = factureID;
//    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }


}
