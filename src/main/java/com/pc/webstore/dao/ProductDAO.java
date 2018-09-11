package com.pc.webstore.dao;

import com.pc.webstore.dto.Product;
import java.util.List;

/**
 *
 * @author Przemek
 */
public interface ProductDAO {
    
    Product get(int productId);
    List<Product> products();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(Product product);
    
    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategory(int categoryId);
    List<Product> getLatestActiveProducts(int count);
}
