/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.exception.ApplicationException;
import com.skill.app.model.Examination;
import com.skill.app.model.Result;
import com.skill.app.model.User;
import java.util.List;

/**
 * This class declares methods for ResultDAO and related business logic.
 *
 * @author Shubham Shandilya
 */
public interface ResultService {

    /**
     * This method returns a result given its result id
     *
     * @param resultId
     * @return result
     */
    public Result getResult(int resultId) throws ApplicationException;

    /**
     * This method returns the results of a user who appeared for a given exam
     *
     * @param examination
     * @param user
     * @return list of results
     */
    public List<Result> getResult(Examination examination, User user) throws ApplicationException;

    /**
     * This method returns a list of results for given examination
     *
     * @param examination
     * @return list of results
     */
    public List<Result> getResult(Examination examination) throws ApplicationException;

    /**
     * This method returns a list of results of all the examinations taken by a
     * user
     *
     * @param user
     * @return list of result
     */
    public List<Result> getResult(User user) throws ApplicationException;

    /**
     * This method saves or updates a result
     *
     * @param result
     */
    public void saveOrUpdateResult(Result result) throws ApplicationException;

    /**
     * This method deletes a result
     *
     * @param result
     */
    public void deleteResult(Result result) throws ApplicationException;

}
