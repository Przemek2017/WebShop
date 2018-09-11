package com.pc.webshop.test;

import com.pc.webstore.dao.ProductDAO;
import com.pc.webstore.dto.Product;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class ProductTestCase {
    
    private static AnnotationConfigApplicationContext context;
    private static ProductDAO productDAO;
    private Product product;
    
    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("com.pc.webstore");
        context.refresh();
        productDAO = (ProductDAO) context.getBean("productDao");
    }
    
//    @Test
//    public void TestCRUD(){
//        // Add Product
//        product = new Product();
//        product.setName("Nokia 3310");
//        product.setBrand("nokia");
//        product.setDescription("Classic phone");
//        product.setUnitPrice(5000);
//        product.setQuantity(10);
//        product.setActive(true);
//        product.setCategoryId(1);
//        product.setSupplierId(2);
//        product.setPurchases(0);
//        product.setViews(0);
//        assertEquals("Successfully added a product to table", true, productDAO.add(product));
//        
//        // Update
//        product = productDAO.get(6);
//        product.setDescription("Classic phone with best game! -> SNAKE");
//        assertEquals("Successfully updated products", true, productDAO.update(product));
//        
//        // Delete -> soft delete, setting active = false
//        assertEquals("Successfully deleted product with id=6", true, productDAO.delete(product));
//        
//        // List
//        assertEquals("Successfully selected all products", 6, productDAO.products().size());
//    }
    
//    @Test
//    public void listActiveProductsTest(){
//        assertEquals("Successfully selected all active products", 5, 
//                productDAO.listActiveProducts().size());
//    }    
//    
//    @Test
//    public void listActiveProductsByCategoryTest(){
//        assertEquals("Successfully selected all active products from Laptop category", 2, 
//                productDAO.listActiveProductsByCategory(3).size());
//        assertEquals("Successfully selected all active products from Mobile category", 3, 
//                productDAO.listActiveProductsByCategory(1).size());
//    }
//    
//    @Test
//    public void getLatestActiveProductsTest(){
//        assertEquals("Successfully selected latest active products", 5, 
//                productDAO.getLatestActiveProducts(5).size());
//    }
}
