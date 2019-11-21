package com.pc.webstore.dao;

import com.pc.webstore.dto.Address;
import com.pc.webstore.dto.Cart;
import com.pc.webstore.dto.User;
import java.util.List;

/**
 *
 * @author Przemek
 */
public interface UserDAO {
    
    boolean addUser(User user);
    User getUserByEmail(String email);
    boolean addAddress(Address address);
    boolean updateCart(Cart cart);
    
    Address getBillingAddress(User user);
    List<Address> listShippingAddresses(User user);
}
