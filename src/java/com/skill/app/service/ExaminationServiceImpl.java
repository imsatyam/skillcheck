/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.dao.ExaminationDAO;
import com.skill.app.dao.ExaminationDAOImpl;
import com.skill.app.exception.ApplicationException;
import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.User;
import java.util.List;

/**
 * This class implements ExaminationService to access DAO layer
 *
 * @author Shubham Shandilya
 */
public class ExaminationServiceImpl implements ExaminationService{

    @Override
    public Examination getExamination(int examinationId) throws ApplicationException {
        Examination examination = null;
        try{
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            examination = examinationDAO.getExamination(examinationId);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return examination;
    }

    @Override
    public Examination getExamination(String examinationName) throws ApplicationException {
        Examination examination = null;
        try{
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            examination = examinationDAO.getExamination(examinationName);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return examination;
    }

    @Override
    public List<Examination> getExamination(User user) throws ApplicationException {
        List<Examination> examinations = null;
        try{
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            examinations = examinationDAO.getExamination(user);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return examinations;
    }

    @Override
    public List<Examination> getAllExaminations() throws ApplicationException {
        List<Examination> examinations = null;
        try{
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            examinations = examinationDAO.getAllExaminations();
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return examinations;
    }

    @Override
    public void saveOrUpdateExamination(Examination examination) throws ApplicationException {
        try{
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            examinationDAO.saveOrUpdateExamination(examination);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

    @Override
    public void deleteExamination(Examination examination) throws ApplicationException {
        try{
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            examinationDAO.deleteExamination(examination);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

    @Override
    public void deleteExamination(int[] examinationIds) throws ApplicationException {
        try{
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            examinationDAO.deleteExamination(examinationIds);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

}
