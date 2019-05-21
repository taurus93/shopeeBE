package vn.shop.library.common.model.dao;

public class Facture {
    /**
     *
     * */
    private static final long serialVersionUID = 1L;
    //    private Integer factureID;
    private String factureCode;
    private String userEmail;
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

    public String getFactureCode() {
        return factureCode;
    }

    public void setFactureCode(String factureCode) {
        this.factureCode = factureCode;
    }



}
