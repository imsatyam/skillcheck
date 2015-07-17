/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.User;
import java.util.List;

/**
 * This class will declare methods for database operations on SC_EXAMINATION
 * table.
 *
 * @author Shubham Shandilya
 */
public interface ExaminationDAO {

    //Table
    public static final String EXAMINATION_TABLE = "SC_EXAMINATION";
    
    //Columns
    public static final String EXAMINATION_ID = "EXAMINATION_ID";
    public static final String EXAMINATION_NAME = "EXAMINATION_NAME";
    public static final String MAXIMUM_MARKS = "MAXIMUM_MARKS";
    public static final String NUMBER_OF_QUESTIONS = "NUMBER_OF_QUESTIONS";
    public static final String MARKS_PER_QUESTION = "MARKS_PER_QUESTION";
    public static final String PASSING_MARKS = "PASSING_MARKS";
    public static final String NEGATIVE_MARKS = "NEGATIVE_MARKS";
    public static final String TIME_IN_MINUTES = "TIME_IN_MINUTES";
    public static final String CREATED_BY = "CREATED_BY";
    public static final String CREATED_DATE = "CREATED_DATE";
    
    
    /**
     * This method returns the examination details of any examination given its
     * id
     *
     * @param examinationId
     * @return examination
     * @throws DatabaseException
     */
    public Examination getExamination(int examinationId) throws DatabaseException;

    /**
     * This method returns the examination details of any examination given its
     * name
     *
     * @param examinationName
     * @return
     * @throws DatabaseException
     */
    public Examination getExamination(String examinationName) throws DatabaseException;
    
    /**
     * This method returns the examination details of any examination created by
     * a user
     *
     * @param user
     * @return
     * @throws DatabaseException
     */
    public List<Examination> getExamination(User user) throws DatabaseException;

    /**
     * This method returns a list of all the examinations
     *
     * @return list of examinations
     * @throws DatabaseException
     */
    public List<Examination> getAllExaminations() throws DatabaseException;

    /**
     * This method saves or updates examination details
     *
     * @param examination
     * @throws DatabaseException
     */
    public void saveOrUpdateExamination(Examination examination) throws DatabaseException;

    /**
     * This method deletes an examination
     *
     * @param examination
     * @throws DatabaseException
     */
    public void deleteExamination(Examination examination) throws DatabaseException;

    /**
     * This method deletes multiple examinations based on its id
     * 
     * @param examinationIds
     * @throws DatabaseException
     */
    public void deleteExamination(int[] examinationIds) throws DatabaseException;
}
