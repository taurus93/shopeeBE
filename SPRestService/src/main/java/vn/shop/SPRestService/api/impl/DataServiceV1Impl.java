package vn.shop.SPRestService.api.impl;

import org.springframework.stereotype.Service;
import vn.shop.SPRestService.api.DataServiceV1;
import vn.shop.library.common.model.dao.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lttung on 1/2/2019.
 */
@Service("dataServiceV1")
public class DataServiceV1Impl extends ServiceCommons implements DataServiceV1 {

    @Override
    public String getAllUser() {
//        String urlCompute = PropertiesReader.getValue(ConfigEnum.DS_COMPUTE_URL);
        String result = "";
        result = getDataToService("http://localhost:8007/ShopeeDao/client/getAllClient");
        try {

        }catch (Exception e) {
//            LOGGER
        }
        return result;
    };
    @Override
    public String getAllCategory() {
//        String urlCompute = PropertiesReader.getValue(ConfigEnum.DS_COMPUTE_URL);
        String result = "";
        result = getDataToService("http://localhost:8007/ShopeeDao/category/getAllCategory");
        try {

        }catch (Exception e) {
//            LOGGER
        }
        return result;
    };
    @Override
    public String insertCategory(Category category) {
//        String urlCompute = PropertiesReader.getValue(ConfigEnum.DS_COMPUTE_URL);
        String result = "";
        result = postDataToService("http://localhost:8007/ShopeeDao/category/insertCategory", category);
        try {

        }catch (Exception e) {
//            LOGGER
        }
        return result;
    };
}
