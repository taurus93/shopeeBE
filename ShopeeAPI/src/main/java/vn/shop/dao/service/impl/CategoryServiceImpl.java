package vn.shop.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.shop.dao.CategoryDao;
import vn.shop.dao.ClientDao;
import vn.shop.dao.service.CategoryService;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Client;

import java.util.List;

/**
 * Created by lttung on 3/29/2019.
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
