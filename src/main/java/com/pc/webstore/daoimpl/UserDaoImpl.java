package com.pc.webstore.daoimpl;

import com.pc.webstore.dao.UserDAO;
import com.pc.webstore.dto.Address;
import com.pc.webstore.dto.Cart;
import com.pc.webstore.dto.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Przemek
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {
        try {
        sessionFactory.getCurrentSession().persist(user);
        return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAddress(Address address) {
        try {
        sessionFactory.getCurrentSession().persist(address);
        return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCart(Cart cart) {
        try {
        sessionFactory.getCurrentSession().update(cart);
        return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String select = "FROM user_detail WHERE email = :email";
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(select, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Address getBillingAddress(User user) {
        String select = "FROM Address WHERE user = :user AND billing = :billing";
        try {
        return sessionFactory.getCurrentSession()
                .createQuery(select, Address.class)
                .setParameter("user", user)
                .setParameter("billing", 1)
                .getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
        return null;
        }
    }

    @Override
    public List<Address> listShippingAddresses(User user) {
        String select = "FROM Address WHERE user = :user AND shipping = :shipping";
        try {
        return sessionFactory.getCurrentSession()
                .createQuery(select, Address.class)
                .setParameter("user", user)
                .setParameter("shipping", true)
                .getResultList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
