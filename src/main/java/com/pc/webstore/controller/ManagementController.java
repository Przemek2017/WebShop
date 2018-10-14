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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        mav.addObject("formTitle", "Add new Product");
        mav.addObject("userClickManageProducts", true);

        Product managedProduct = new Product();
        managedProduct.setSupplierId(1);
        managedProduct.setActive(true);
        mav.addObject("managedProduct", managedProduct);

        if (operation != null) {
            if (operation.equals("managedProduct")) {
                mav.addObject("successMessage", "Product submitted successfully!");
            } else if (operation.equals("managedCategory")){
                mav.addObject("successMessage", "Category submitted successfully!");
            }
        }
        LOGGER.info("ManagementController /managedProduct =>");

        return mav;
    }

    @RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("title", "Manage Products");
        mav.addObject("formTitle", "Edit Product");
        mav.addObject("userClickManageProducts", true);

        Product managedProduct = productDAO.get(id);
        mav.addObject("managedProduct", managedProduct);

        LOGGER.info("ManagementController /editProduct =>");

        return mav;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addNewProduct(@Valid @ModelAttribute("managedProduct") Product managedProduct,
            BindingResult bindingResult, Model model, HttpServletRequest request) {

        LOGGER.info(managedProduct.toString());
        
        if (managedProduct.getId() == 0) {
            new ProductValidator().validate(managedProduct, bindingResult);
        } else {
            if (!managedProduct.getFile().getOriginalFilename().equals("")) {
                new ProductValidator().validate(managedProduct, bindingResult);
            }
        }

        // errors checked
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClickManageProducts", true);

            return "page";
        }
        // if id = 0 create new product
        if (managedProduct.getId() == 0) {
            productDAO.add(managedProduct);
        } else {
            // if id != 0 update product
            productDAO.update(managedProduct);
        }

        if (!managedProduct.getFile().getOriginalFilename().equals("")) {
            FileUploadUtility.getFile(request, managedProduct.getFile(), managedProduct.getCode());
        }
        return "redirect:/manage/products?operation=managedProduct";
    }

    @RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
    @ResponseBody
    public String handleRequestForActivation(@PathVariable int id) {
        // fetch product from database by id
        Product product = productDAO.get(id);
        boolean isActive = product.isActive();

        product.setActive(!isActive);
        // updating the product
        productDAO.update(product);
        return (isActive)
                ? "You have successfully deactivated the product with id " + product.getId()
                : "You have successfully activated the product with id " + product.getId();
    }
    
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String handleCategorySubmission(@ModelAttribute Category category){
        // Add new Category
        categoryDAO.add(category);
        return "redirect:/manage/products?operation=managedCategory";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDAO.categories();
    }
    
    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }
}
