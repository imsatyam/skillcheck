/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.exception;

/**
 * This class represents the application exception thrown by the service layer
 *
 * @author Shubham Shandilya
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message = null;

    /**
     * Constructor
     *
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * Constructor
     *
     * @param cause
     */
    public ApplicationException(Throwable cause) {
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
