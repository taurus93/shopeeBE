package vn.shop.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.shop.dao.CategoryDao;
import vn.shop.dao.jdbc.CategoryMapper;
import vn.shop.dao.jdbc.ClientMapper;
import vn.shop.library.common.model.dao.Category;
import vn.shop.library.common.model.dao.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lttung on 3/29/2019.
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertCategory(Category category) {
        logger.info("Begin insert category");
        String sql = "INSERT INTO category(categoryCode, categoryName, catDescription, catPicture) value(?, ?, ?, ?)";
        try {

            return String.valueOf(jdbcTemplate.update(sql, new Object[]{category.getCategoryCode(), category.getCategoryName(), category.getCatDescription(), category.getCatPicture()}));

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End insert, result: Success");
        return "0";
    }

    @Override
    public List<Category> getCategory(String categoryCode) {

        logger.info("Begin get category by category id");

        String sql = "SELECT * FROM category WHERE categoryCode = ?";

        List<Category> ret = new ArrayList<>();
        try {

            ret =  jdbcTemplate.query(sql, new Object[]{categoryCode}, new CategoryMapper());

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        int result = (ret == null ? 0 : ret.size());
        logger.info("End get list category, result: Success" + result);
        return ret;
    }

    @Override
    public List<Category> getAllCategory() {

        logger.info("Begin get all category");

        String sql = "SELECT * FROM category";

        List<Category> ret = new ArrayList<>();

        try {
            ret = jdbcTemplate.query(sql, new Object[]{}, new CategoryMapper());
        }catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("END get all category, result: SUCCESS " + ret);

        return ret;
    }

    @Override
    public int updateCategory(Category category) {
        logger.info("Begin update category");

        String sql = "UPDATE category SET categoryName = ?, catDescription = ?, catPicture = ? WHERE categoryID = ?";

        try {

            return jdbcTemplate.update(sql, new Object[]{category.getCategoryName(), category.getCatDescription(), category.getCatPicture()});
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        logger.info("End update category, FAIL");
        return 0;
    }

}
