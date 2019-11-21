package com.pc.webshop.test;

import com.pc.webstore.dao.UserDAO;
import com.pc.webstore.dto.Address;
import com.pc.webstore.dto.Cart;
import com.pc.webstore.dto.User;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class UserTestCase {
    private static AnnotationConfigApplicationContext context;
    private static UserDAO userDAO;
    private User user = null;
    private Cart cart = null;
    private Address address = null;
    
    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("com.pc.webstore");
        context.refresh();
        userDAO = (UserDAO) context.getBean("userDao");
        
    }
    
//    @Test
//    public void testAdd_1(){
//        user = new User();
//        user.setFirstName("Julia");
//        user.setLastName("C");
//        user.setEmail("julia@test.pl");
//        user.setPassword("123123");
//        user.setContactNumber(null);
//        user.setRole("USER");
//        
//        assertEquals("Failed to add user!", true, userDAO.addUser(user));
//        
//        address = new Address();
//        address.setAddressLineOne("Kossaka");
//        address.setAddresLineTwo("111");
//        address.setCity("Bytom");
//        address.setCountry("Poland");
//        address.setPostCode("12-345");
//        address.setBilling(true);
//        
//        address.setUserId(user.getId());
//        
//        assertEquals("Failed to add address", true, userDAO.addAddress(address));
//        
//        if (user.getRole().equals("USER")){
//            cart = new Cart();
//            cart.setUser(user);
//            
//            assertEquals("Failed to add cart", true, userDAO.updateCart(cart));
//            
//            address = new Address();
//            address.setAddressLineOne("Kossaka");
//            address.setAddresLineTwo("111");
//            address.setCity("Bytom");
//            address.setCountry("Poland");
//            address.setPostCode("12-345");
//            address.setShipping(true);
//            
//            // link it with the user 
//            address.setUserId(user.getId());
//            
//            assertEquals("Failed add shipping address", true, userDAO.addAddress(address));
//        }
//    }
    
//    @Test
//    public void testAdd_2(){
//        user = new User();
//        user.setFirstName("Julia");
//        user.setLastName("Cia");
//        user.setEmail("julia@test.pl");
//        user.setPassword("123123");
//        user.setContactNumber(null);
//        user.setRole("USER");
//        
//        if(user.getRole().equals("USER")){
//            cart = new Cart();
//            cart.setUser(user);
//            user.setCart(cart);
//        }
//            assertEquals("Failed to add user!", true, userDAO.addUser(user));
//    }
    
//    @Test
//    public void testUpdateCart(){
//        user = userDAO.getUserByEmail("julia@test.pl");
//        cart = user.getCart();
//        
//        cart.setCartLines(4);
//        cart.setGrandTotal(1550);
//        
//        assertEquals("Failed to update cart", true, userDAO.updateCart(cart));
//    }
    
//    @Test
//    public void addAddressTest(){
//        // add user
//        user = new User();
//        user.setFirstName("Julia");
//        user.setLastName("C");
//        user.setEmail("julia@test.pl");
//        user.setPassword("123123");
//        user.setContactNumber(null);
//        user.setRole("USER");
//        
//        assertEquals("Failed to add user", true, userDAO.addUser(user));
//        
//        // add address
//        address = new Address();
//        address.setAddressLineOne("Kossaka");
//        address.setAddresLineTwo("111");
//        address.setCity("Bytom");
//        address.setCountry("Poland");
//        address.setPostCode("12-345");
//        address.setBilling(true);
//        address.setUser(user);
//        
//        assertEquals("Failed to add address", true, userDAO.addAddress(address));
//        
//        address = new Address();
//        address.setAddressLineOne("Kossaka");
//        address.setAddresLineTwo("123");
//        address.setCity("Bytom");
//        address.setCountry("Poland");
//        address.setPostCode("12-345");
//        address.setShipping(true);
//
//        address.setUser(user);
//
//        assertEquals("Failed add shipping address", true, userDAO.addAddress(address));
//    }
    
//    @Test
//    public void addAddressTest(){
//        
//        user = userDAO.getUserByEmail("pc@mail.com");
//        
//        address = new Address();
//        address.setAddressLineOne("Zwycięstwa");
//        address.setAddresLineTwo("321");
//        address.setCity("Warszawa");
//        address.setCountry("Poland");
//        address.setPostCode("12-345");
//        address.setBilling(true);
//        address.setUser(user);
//        
//        assertEquals("Failed to add address", true, userDAO.addAddress(address));
//    }
    
    @Test
    public void getAddresses(){
        
        user = userDAO.getUserByEmail("pc@mail.com");
        
        assertEquals("Failed to fetch the list of addresses", 1, userDAO.listShippingAddresses(user).size());
        
        assertEquals("Failed to fetch the billing address", "Warszawa", userDAO.getBillingAddress(user).getCity());
    }
}
