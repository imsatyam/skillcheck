/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.exception.ApplicationException;
import com.skill.app.model.Examination;
import com.skill.app.model.Question;
import java.util.List;

/**
 * This interface declares methods used for QuestionDAO and related business 
 * logic.
 *
 * @author Shubham Shandilya
 */
public interface QuestionService {

    /**
     * This method returns the details of a question given its id
     *
     * @param questionId
     * @return question
     * @throws ApplicationException
     */
    public Question getQuestion(int questionId) throws ApplicationException;

    /**
     * This method returns all the questions
     *
     * @return list of questions
     * @throws ApplicationException
     */
    public List<Question> getAllQuestions() throws ApplicationException;

    /**
     * This method returns a list of questions for any examination
     *
     * @param examination
     * @return List of questions
     * @throws ApplicationException
     */
    public List<Question> getAllQuestions(Examination examination) throws ApplicationException;

    /**
     * This method saves or updates the question details
     *
     * @param question
     * @throws ApplicationException
     */
    public void saveOrUpdateQuestion(Question question) throws ApplicationException;

    /**
     * This method deletes the question
     *
     * @param question
     * @throws ApplicationException
     */
    public void deleteQuestion(Question question) throws ApplicationException;
    
    /**
     * This method deletes question based on question id
     *
     * @param questionIds
     * @throws ApplicationException
     */
    public void deleteQuestion(int[] questionIds) throws ApplicationException;
}
