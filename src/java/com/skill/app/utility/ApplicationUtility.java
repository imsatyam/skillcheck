/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.utility;

import com.skill.app.constant.ApplicationConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class holds the utility methods for the application
 *
 * @author Shubham Shandilya
 */
public class ApplicationUtility {

    /**
     * This method converts java.util.Date into String
     * 
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        String dateString = null;
        if(null != date){
            SimpleDateFormat dateFormat = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
            dateString = dateFormat.format(date);
        }
        return dateString;
    }
    
    /**
     *
     * This method converts formatted string into Date object
     * 
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateString) throws ParseException{
        Date date = null;
        if(null != dateString && !dateString.equals(ApplicationConstants.EMPTY)){
            SimpleDateFormat dateFormat = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);  
            date = dateFormat.parse(dateString);
        }
        return date;
    }
    
    /**
     * This method converts sql date to util date
     * 
     * @param sqlDate
     * @return
     */
    public static Date sqlToUtilDate(java.sql.Date sqlDate){
        Date date = null;
        if(null != sqlDate){
            date = new Date(sqlDate.getTime());
        } 
        return date;
    }
    
    
}
