package com.pc.webstore.daoimpl;

import com.pc.webstore.dao.CategoryDAO;
import com.pc.webstore.dto.Category;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Przemek
 */
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> categories() {
        String select = "FROM Category WHERE is_active = :is_active";
        Query query = sessionFactory.getCurrentSession().createQuery(select);
        query.setParameter("is_active", 1);
        return query.getResultList();
    }

    @Override
    public Category get(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public boolean add(Category category) {
        try {
            sessionFactory.getCurrentSession().persist(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category category) {
        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Category category) {
        category.setActive(false);
        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
