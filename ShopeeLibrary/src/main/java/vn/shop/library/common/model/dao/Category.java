package vn.shop.library.common.model.dao;

import java.io.Serializable;

/**
 * Created by lttung on 3/29/2019.
 */
public class Category implements Serializable{
    /**
     *
     * */
    private static final long serialVersionUID = 1L;
//    private Integer categoryID;
    private String categoryCode;
    private String categoryName;
    private String catDescription;
    private String catPicture;



    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

//    public Integer getCategoryID() {
//        return categoryID;
//    }
//
//    public void setCategoryID(Integer categoryID) {
//        this.categoryID = categoryID;
//    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getCatPicture() {
        return catPicture;
    }

    public void setCatPicture(String catPicture) {
        this.catPicture = catPicture;
    }

}
