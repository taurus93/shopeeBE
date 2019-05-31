package vn.shop.dao;

import vn.shop.library.common.model.dao.Category;

import java.util.List;

/**
 * Created by lttung on 3/29/2019.
 */
public interface CategoryDao {
    int insertCategory(Category Category);

    List<Category> getCategory(String categoryCode);

    List<Category> getAllCategory();

    int updateCategory(Category Category);

    int deleteCategory(String categoryCode);
}
