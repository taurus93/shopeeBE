package vn.shop.dao;

import vn.shop.library.common.model.dao.Category;

import java.util.List;

/**
 * Created by lttung on 3/29/2019.
 */
public interface CategoryDao {
    String insertCategory(Category Category);

    List<Category> getCategory(int categoryID);

    List<Category> getAllCategory();

    int updateCategory(Category Category);
}
