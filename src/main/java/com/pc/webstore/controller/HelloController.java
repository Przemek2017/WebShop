package com.pc.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Przemek
 */
@Controller
public class HelloController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("greeting", "WELCOME in my page!");
        return mav;
    }

}
