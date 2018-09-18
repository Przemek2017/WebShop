package com.pc.webstore.exception;

import java.io.Serializable;

/**
 *
 * @author Przemek
 */
public class CategoryNotFoundException extends Exception implements Serializable {

    private String message;

    public CategoryNotFoundException() {
        this("Product is not available!");
    }

    public CategoryNotFoundException(String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }

    public String getMessage() {
        return message;
    }

}
