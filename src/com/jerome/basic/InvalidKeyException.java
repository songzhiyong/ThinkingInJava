package com.jerome.basic;
public class InvalidKeyException extends Exception {
 
    private static final long serialVersionUID = 1L;
 
    public InvalidKeyException(String message) {
        super(message);
    }
 
}