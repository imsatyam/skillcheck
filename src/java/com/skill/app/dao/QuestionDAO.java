/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.Question;
import java.util.List;

/**
 * This interface declares methods used for database operations on SC_QUESTION
 * table.
 *
 * @author Shubham Shandilya
 */
public interface QuestionDAO {

    //Table
    public static final String QUESTION_TABLE = "SC_QUESTION";
    
    //Columns
    public static final String QUESTION_ID = "QUESTION_ID";
    public static final String QUESTION = "QUESTION";
    public static final String OPTION_A = "OPTION_A";
    public static final String OPTION_B = "OPTION_B";
    public static final String OPTION_C = "OPTION_C";
    public static final String OPTION_D = "OPTION_D";
    public static final String CORRECT_ANSWER = "CORRECT_ANSWER";
    public static final String EXAMINATION_ID = "EXAMINATION_ID";
    
    /**
     * This method returns the details of a question given its id
     *
     * @param questionId
     * @return question
     * @throws DatabaseException
     */
    public Question getQuestion(int questionId) throws DatabaseException;

    /**
     * This method returns all the questions
     *
     * @return list of questions
     * @throws DatabaseException
     */
    public List<Question> getAllQuestions() throws DatabaseException;

    /**
     * This method returns a list of questions for any examination
     *
     * @param examination
     * @return List of questions
     * @throws DatabaseException
     */
    public List<Question> getAllQuestions(Examination examination) throws DatabaseException;
    
    
    /**
     * This method saves or updates the question details
     *
     * @param question
     * @throws DatabaseException
     */
    public void saveOrUpdateQuestion(Question question) throws DatabaseException;

    /**
     * This method deletes the question
     *
     * @param question
     * @throws DatabaseException
     */
    public void deleteQuestion(Question question) throws DatabaseException;
    
    /**
     * This method deletes question based on question id
     *
     * @param questionIds
     * @throws DatabaseException
     */
    public void deleteQuestion(int[] questionIds) throws DatabaseException;
}
