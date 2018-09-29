package com.pc.webstore.controller;

import com.pc.webstore.dao.CategoryDAO;
import com.pc.webstore.dao.ProductDAO;
import com.pc.webstore.dto.Category;
import com.pc.webstore.dto.Product;
import com.pc.webstore.util.FileUploadUtility;
import com.pc.webstore.validator.ProductValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Przemek
 */
@Controller
@RequestMapping(value = "/manage")
public class ManagementController {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showManagedProducts(@RequestParam(name = "operation", required = false) String operation) {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("title", "Manage Products");
        mav.addObject("userClickManageProducts", true);

        Product newProduct = new Product();
        newProduct.setSupplierId(1);
        newProduct.setActive(true);
        mav.addObject("newProduct", newProduct);

        if (operation != null) {
            if (operation.equals("newProduct")) {
                mav.addObject("successMessage", "Product added successfully!");
            }
        }
        LOGGER.info("ManagementController /manageProducts =>");

        return mav;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addNewProduct(@Valid @ModelAttribute("newProduct") Product newProduct, 
            BindingResult bindingResult, Model model, HttpServletRequest request) {
        
        LOGGER.info(newProduct.toString());
        new ProductValidator().validate(newProduct, bindingResult);
        
        // errors checked
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClickManageProducts", true);
            
            return "page";
        }
        productDAO.add(newProduct);
        
        if(!newProduct.getFile().getOriginalFilename().equals("")){
            FileUploadUtility.getFile(request, newProduct.getFile(), newProduct.getCode());
        }
        return "redirect:/manage/products?operation=newProduct";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDAO.categories();
    }
}
