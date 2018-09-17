package com.pc.webstore.controller;

import com.pc.webstore.dao.CategoryDAO;
import com.pc.webstore.dao.ProductDAO;
import com.pc.webstore.dto.Category;
import com.pc.webstore.dto.Product;
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
        return mav;
    }

    @RequestMapping(value = {"/products"})
    public ModelAndView products() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickProducts", true);
        mav.addObject("title", "Products");
        return mav;
    }

    @RequestMapping(value = {"/about"})
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickAbout", true);
        mav.addObject("title", "About us");
        return mav;
    }

    @RequestMapping(value = {"/contact"})
    public ModelAndView contact() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickContact", true);
        mav.addObject("title", "Contact us");
        return mav;
    }

    @RequestMapping(value = {"show/all/products"})
    public ModelAndView showAllProducts() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickAllProducts", true);
        mav.addObject("title", "All Products");
        // list of categories
        mav.addObject("categories", categoryDAO.categories());
        return mav;
    }

    @RequestMapping(value = {"show/category/{id}/products"})
    public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
        Category category = null;
        category = categoryDAO.get(id);

        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickCategoryProducts", true);
        mav.addObject("title", category.getName());
        // single category object
        mav.addObject("category", category);
        // list of categories
        mav.addObject("categories", categoryDAO.categories());
        return mav;
    }

    @RequestMapping(value = {"show/{id}/product"})
    public ModelAndView showSingleProduct(@PathVariable("id") int id) {
        Product product = productDAO.get(id);
        
        product.setViews(product.getViews() + 1);
        productDAO.update(product);
        
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("product", product);
        mav.addObject("title", product.getName());
        mav.addObject("userClickShowSingleProduct", true);

        return mav;
    }
}
