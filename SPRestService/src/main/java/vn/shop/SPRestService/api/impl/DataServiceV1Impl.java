package vn.shop.SPRestService.api.impl;

import org.springframework.stereotype.Service;
import vn.shop.SPRestService.api.DataServiceV1;

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
}
