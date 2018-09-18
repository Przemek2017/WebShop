package com.pc.webstore.exception;

import java.io.Serializable;

/**
 *
 * @author Przemek
 */
public class ProductNotFoundException extends Exception implements Serializable {

    private String message;

    public ProductNotFoundException() {
        this("Product is not available!");
    }

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }

    public String getMessage() {
        return message;
    }

}
