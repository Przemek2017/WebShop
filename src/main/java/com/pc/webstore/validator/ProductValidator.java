package com.pc.webstore.validator;

import com.pc.webstore.dto.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Przemek
 */
public class ProductValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        
        if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")){
            errors.rejectValue("file", null, "Please select an image file to upload!");
            return;
        }
        
        if (!(product.getFile().getContentType().equals("image/jpeg")|| 
              product.getFile().getContentType().equals("image/png")|| 
              product.getFile().getContentType().equals("image/gif"))){
            
            errors.rejectValue("file", null, "Please select only image file to upload!");
            return;
        }
    }
    
}
