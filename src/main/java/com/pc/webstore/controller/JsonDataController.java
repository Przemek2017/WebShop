package com.pc.webstore.controller;

import com.pc.webstore.dao.ProductDAO;
import com.pc.webstore.dto.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Przemek
 */
@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = {"/all/products"})
    @ResponseBody
    public List<Product> getAllActiveProducts() {
        return productDAO.listActiveProducts();
    }

    @RequestMapping(value = {"/category/{id}/products"})
    @ResponseBody
    public List<Product> getProductsByCategoryId(@PathVariable int id) {
        return productDAO.listActiveProductsByCategory(id);
    }
}
