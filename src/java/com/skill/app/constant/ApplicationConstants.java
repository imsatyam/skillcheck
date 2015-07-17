/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.constant;

/**
 * This class holds the constants used in the application
 *
 * @author Shubham Shandilya
 */
public class ApplicationConstants {

    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String ZERO = "0";
    
    public static final String LOGGED_IN_USER = "loggedInUser";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String INVALID_LOGIN = "Invalid login.";
    
    public static final String OPERATION = "operation";
    public static final int INSERT_OPERATION = 1;
    public static final int UPDATE_OPERATION = 2;
    public static final int DELETE_OPERATION = 3;
    public static final int FETCH_OPERATION = 4;
    public static final int CANCEL_OPERATION = 5;
    
    public static final String PROFILE_UPDATE_STATUS = "profileUpdateStatus";
    public static final String PROFILE_UPDATE_SUCCESS = "Profile updated successfully!";
    
    public static final String MANAGE_EXAM_STATUS = "manageExamStatus";
    public static final String MANAGE_EXAM_DELIMITER = ";;;";
    public static final String MANAGE_EXAM_DEL_E_SUCC = "Examination(s) deleted successfully!";
    public static final String MANAGE_EXAM_DEL_Q_SUCC = "Question(s) deleted successfully!";
    public static final String MANAGE_EXAM_CR_E_SUCC = "Examination created successfully!";
    
    public static final String ROLES = "roles";
    public static final String REG_STATUS = "regStatus";
    public static final String REG_EMAIL = "regEmail";
    public static final String REG_SUCCESS_MSG = "Registration successful!";
    
    public static final String FGT_PWD_STATUS = "forgotPasswordStatus";
    public static final String FGT_PWD_SUCCESS_MSG = "Password has been sent to registered email address.";
    
    public static final String NO_SUCH_USER = "Invalid user. Please enter correct username.";
    
    public static final String OP_FAILURE_MSG = "An error occurred. Please check the logs.";
    
}
