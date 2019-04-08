package vn.shop.library.common.util;

/**
 * Created by lttung on 12/12/2018.
 */
public enum ConfigEnum {
    ABC("abc");

    private String tempEnum;

    private ConfigEnum(String var) {
        this.tempEnum = var;
    }

    /*
    * Get value of tempEnum
    *
    * @return the tempEnum
    */

    public String getTempEnum() {
        return tempEnum;
    }
}
