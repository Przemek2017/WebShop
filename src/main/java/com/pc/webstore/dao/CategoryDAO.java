package com.pc.webstore.dao;

import com.pc.webstore.dto.Category;
import java.util.List;

/**
 *
 * @author Przemek
 */
public interface CategoryDAO {

    Category get(int id);
    boolean add(Category category);
    boolean update(Category category);
    boolean delete(Category category);
    List<Category> categories();
}
