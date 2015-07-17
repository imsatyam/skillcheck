/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.exception;

/**
 * This exception is thrown if the user provides invalid login credentials
 *
 * @author Shubham Shandilya
 */
public class InvalidInputException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message = null;

    /**
     * Constructor
     *
     * @param message
     */
    public InvalidInputException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * Constructor
     *
     * @param cause
     */
    public InvalidInputException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}
