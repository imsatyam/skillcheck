/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.Result;
import com.skill.app.model.User;
import java.util.List;

/**
 * This class declares methods for the database operations on SC_RESULT table
 *
 * @author Shubham Shandilya
 */
public interface ResultDAO {

    //table
    public static final String RESULT_TABLE = "SC_RESULT";
    
    //Columns
    public static final String RESULT_ID = "RESULT_ID";
    public static final String EXAMINATION_ID = "EXAMINATION_ID";
    public static final String USER_ID = "USER_ID";
    public static final String NUMBER_CORRECT = "NUMBER_CORRECT";
    public static final String NUMBER_INCORRECT = "NUMBER_INCORRECT";
    public static final String MARKS_OBTAINED = "MARKS_OBTAINED";
    public static final String IS_PASS = "IS_PASS";
    public static final String EXAMINATION_DATE = "EXAMINATION_DATE";
    
    /**
     * This method returns a result given its result id
     *
     * @param resultId
     * @return result
     */
    public Result getResult(int resultId) throws DatabaseException;

    /**
     * This method returns the results of a user who appeared for a given exam
     *
     * @param examination
     * @param user
     * @return list of results
     */
    public List<Result> getResult(Examination examination, User user) throws DatabaseException;

    /**
     * This method returns a list of results for given examination
     *
     * @param examination
     * @return list of results
     */
    public List<Result> getResult(Examination examination) throws DatabaseException;

    /**
     * This method returns a list of results of all the examinations taken by a
     * user
     *
     * @param user
     * @return list of result
     */
    public List<Result> getResult(User user) throws DatabaseException;

    /**
     * This method saves or updates a result
     *
     * @param result
     */
    public void saveOrUpdateResult(Result result) throws DatabaseException;

    /**
     * This method deletes a result
     *
     * @param result
     */
    public void deleteResult(Result result) throws DatabaseException;

}
