package vn.shop.SPRestService.api;

import vn.shop.library.common.model.dao.Category;

import java.util.List;

/**
 * Created by lttung on 1/2/2019.
 */
public interface DataServiceV1 {

    /**
     * user
     * @return
     * */
    String getAllUser();

    String getAllCategory();

    String insertCategory(Category category);
}
