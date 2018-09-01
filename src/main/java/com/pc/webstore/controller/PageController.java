package com.pc.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Przemek
 */
@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("userClickHome", true);
        mav.addObject("title", "Home");
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
}
