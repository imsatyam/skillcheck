/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.vo;

/**
 * This class holds the logic to return success or error message for any
 * operation
 *
 * @author Shubham Shandilya
 */
public class OperationStatus {

    private int status;             //Status 0 means success, 1 means error
    private String statusMessage;   //Corresponding status message comes here.

    /**
     * Constructor for success scenario
     *
     * @param statusMessage
     */
    public OperationStatus(String statusMessage) {
        this.status = 0;
        this.statusMessage = statusMessage;
    }

    /**
     * Constructor with ability to set it as error
     *
     * @param status
     * @param statusMessage
     */
    public OperationStatus(int status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }

    /**
     * Get status
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set status
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get message
     *
     * @return statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * set message
     *
     * @param statusMessage
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
