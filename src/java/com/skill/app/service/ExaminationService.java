/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.exception.ApplicationException;
import com.skill.app.model.Examination;
import com.skill.app.model.User;
import java.util.List;

/**
 * This class will declare methods for ExaminationDAO access and related 
 * business logic.
 *
 * @author Shubham Shandilya
 */
public interface ExaminationService {

    /**
     * This method returns the examination details of any examination given its
     * id
     *
     * @param examinationId
     * @return examination
     * @throws ApplicationException
     */
    public Examination getExamination(int examinationId) throws ApplicationException;

    /**
     * This method returns the examination details of any examination given its
     * name
     *
     * @param examinationName
     * @return
     * @throws ApplicationException
     */
    public Examination getExamination(String examinationName) throws ApplicationException;

    /**
     * This method returns the examination details of any examination created by
     * a user
     *
     * @param user
     * @return examination object
     * @throws ApplicationException
     */
    public List<Examination> getExamination(User user) throws ApplicationException;
    
    /**
     * This method returns a list of all the examinations
     *
     * @return list of examinations
     * @throws ApplicationException
     */
    public List<Examination> getAllExaminations() throws ApplicationException;

    /**
     * This method saves or updates examination details
     *
     * @param examination
     * @throws ApplicationException
     */
    public void saveOrUpdateExamination(Examination examination) throws ApplicationException;

    /**
     * This method deletes an examination
     *
     * @param examination
     * @throws ApplicationException
     */
    public void deleteExamination(Examination examination) throws ApplicationException;
    
    /**
     * This method deletes the examinations by their id
     * 
     * @param examinationIds
     * @throws ApplicationException
     */
    public void deleteExamination(int[] examinationIds) throws ApplicationException;

}
