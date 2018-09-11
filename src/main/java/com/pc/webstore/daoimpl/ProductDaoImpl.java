package com.pc.webstore.daoimpl;

import com.pc.webstore.dao.ProductDAO;
import com.pc.webstore.dto.Product;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Przemek
 */
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product get(int productId) {
        return sessionFactory
                .getCurrentSession()
                .get(Product.class, Integer.valueOf(productId));
    }

    @Override
    public List<Product> products() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Product", Product.class)
                .getResultList();
    }

    @Override
    public boolean add(Product product) {
        try {
            sessionFactory.getCurrentSession().persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        try {
            sessionFactory.getCurrentSession().update(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Product product) {
        product.setActive(false);
        try {
            return this.update(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> listActiveProducts() {
        String select = "FROM Product WHERE active = :active";
        return sessionFactory.getCurrentSession()
                .createQuery(select, Product.class)
                .setParameter("active", true)
                .getResultList();
    }

    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        String select = "FROM Product WHERE active = :active AND categoryId = :categoryId";
        return sessionFactory.getCurrentSession()
                .createQuery(select, Product.class)
                .setParameter("active", true)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        String select = "FROM Product WHERE active = :active ORDER BY id";
        return sessionFactory.getCurrentSession()
                .createQuery(select, Product.class)
                .setParameter("active", true)
                .setFirstResult(0)
                .setMaxResults(count)
                .getResultList();
    }

}
