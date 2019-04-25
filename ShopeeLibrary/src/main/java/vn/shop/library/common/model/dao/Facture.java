package vn.shop.library.common.model.dao;

public class Facture {
    /**
     *
     * */
    private static final long serialVersionUID = 1L;
    private Integer factureID;
    private Integer orderCode;

    public Integer getFactureID() {
        return factureID;
    }

    public void setFactureID(Integer factureID) {
        this.factureID = factureID;
    }


    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }


}
