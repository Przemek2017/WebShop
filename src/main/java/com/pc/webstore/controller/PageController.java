package com.pc.webstore.controller;

import com.pc.webstore.dao.CategoryDAO;
import com.pc.webstore.dao.ProductDAO;
import com.pc.webstore.dto.Category;
import com.pc.webstore.dto.Product;
import com.pc.webstore.exception.CategoryNotFoundException;
import com.pc.webstore.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Przemek
 */
@Controller
public class PageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);
    
    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickHome", true);
        mav.addObject("title", "Home");
        mav.addObject("categories", categoryDAO.categories());
        
        LOGGER.info("PageController \"/\", \"/home\", \"/index\" =>");
        return mav;
    }

    @RequestMapping(value = {"/products"})
    public ModelAndView products() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickProducts", true);
        mav.addObject("title", "Products");
        
        LOGGER.info("PageController /products =>");
        return mav;
    }

    @RequestMapping(value = {"/about"})
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickAbout", true);
        mav.addObject("title", "About us");
        
        LOGGER.info("PageController /about =>");
        return mav;
    }

    @RequestMapping(value = {"/contact"})
    public ModelAndView contact() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickContact", true);
        mav.addObject("title", "Contact us");
        
        LOGGER.info("PageController /contact =>");
        return mav;
    }

    @RequestMapping(value = {"show/all/products"})
    public ModelAndView showAllProducts() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickAllProducts", true);
        mav.addObject("title", "All Products");
        // list of categories
        mav.addObject("categories", categoryDAO.categories());
        
        LOGGER.info("PageController show/all/products =>");
        return mav;
    }

    @RequestMapping(value = {"show/category/{id}/products"})
    public ModelAndView showCategoryProducts(@PathVariable("id") int id) throws CategoryNotFoundException{
        Category category = null;
        category = categoryDAO.get(id);

        if (category == null) throw new CategoryNotFoundException();
        
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickCategoryProducts", true);
        mav.addObject("title", category.getName());
        // single category object
        mav.addObject("category", category);
        // list of categories
        mav.addObject("categories", categoryDAO.categories());
        
        LOGGER.info("PageController show/category/{id}/products =>");
        return mav;
    }

    @RequestMapping(value = {"show/{id}/product"})
    public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException{
        Product product = productDAO.get(id);
        
        if (product == null) throw new ProductNotFoundException();
        
        product.setViews(product.getViews() + 1);
        productDAO.update(product);
        
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("product", product);
        mav.addObject("title", product.getName());
        mav.addObject("userClickShowSingleProduct", true);
        
        LOGGER.info("PageController show/{id}/product =>");
        return mav;
    }
    
    @RequestMapping(value = {"test"})
    public ModelAndView showTest() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClicktest", true);
        mav.addObject("title", "TEST");
        // list of categories
        mav.addObject("categories", categoryDAO.categories());
        
        LOGGER.info("PageController test =>");
        return mav;
    }
}
