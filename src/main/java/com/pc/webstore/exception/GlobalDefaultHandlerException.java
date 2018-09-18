package com.pc.webstore.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author Przemek
 */
@ControllerAdvice
public class GlobalDefaultHandlerException {
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView noHandlerFoundException(){
        ModelAndView mav = new ModelAndView("error");
        
        mav.addObject("errorTitle", "The page is not constructed");
        mav.addObject("errorDescription", "The page you are looking for is not available now");
        mav.addObject("title", "404 Error Page");
        return mav;
    }
        
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerProductNotFoundException(){
        ModelAndView mav = new ModelAndView("error");
        
        mav.addObject("errorTitle", "Product is not available!");
        mav.addObject("errorDescription", "The product you are looking for is not available now.");
        mav.addObject("title", "Product unavailable!");
        return mav;
    }
        
    @ExceptionHandler(CategoryNotFoundException.class)
    public ModelAndView handlerCategoryNotFoundException(){
        ModelAndView mav = new ModelAndView("error");
        
        mav.addObject("errorTitle", "Category is not available!");
        mav.addObject("errorDescription", "The category you are looking for is not available now.");
        mav.addObject("title", "Category unavailable!");
        return mav;
    }
        
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception e){
        ModelAndView mav = new ModelAndView("error");
        
        mav.addObject("errorTitle", "Contact Your Administrator");
        mav.addObject("errorDescription", e.toString() + "\n" + e.getMessage());
        mav.addObject("title", "Error Page");
        return mav;
    }
}
