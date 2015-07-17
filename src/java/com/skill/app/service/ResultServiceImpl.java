/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.dao.ResultDAO;
import com.skill.app.dao.ResultDAOImpl;
import com.skill.app.exception.ApplicationException;
import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.Result;
import com.skill.app.model.User;
import java.util.List;

/**
 * This class implements ResultService
 *
 * @author Shubham Shandilya
 */
public class ResultServiceImpl implements ResultService {

    @Override
    public Result getResult(int resultId) throws ApplicationException {
        Result result = null;
        try{
            ResultDAO resultDAO = new ResultDAOImpl();
            result = resultDAO.getResult(resultId);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return result;
    }

    @Override
    public List<Result> getResult(Examination examination, User user) throws ApplicationException {
        List<Result> results = null;
        try{
            ResultDAO resultDAO = new ResultDAOImpl();
            results = resultDAO.getResult(examination, user);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return results;
    }

    @Override
    public List<Result> getResult(Examination examination) throws ApplicationException {
        List<Result> results = null;
        try{
            ResultDAO resultDAO = new ResultDAOImpl();
            results = resultDAO.getResult(examination);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return results;
    }

    @Override
    public List<Result> getResult(User user) throws ApplicationException {
        List<Result> results = null;
        try{
            ResultDAO resultDAO = new ResultDAOImpl();
            results = resultDAO.getResult(user);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return results;
    }

    @Override
    public void saveOrUpdateResult(Result result) throws ApplicationException {
        try{
            ResultDAO resultDAO = new ResultDAOImpl();
            resultDAO.saveOrUpdateResult(result);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

    @Override
    public void deleteResult(Result result) throws ApplicationException {
        try{
            ResultDAO resultDAO = new ResultDAOImpl();
            resultDAO.deleteResult(result);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

}
