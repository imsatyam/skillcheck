/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.dao.QuestionDAO;
import com.skill.app.dao.QuestionDAOImpl;
import com.skill.app.exception.ApplicationException;
import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.Question;
import java.util.List;

/**
 * This class implements QuestionService
 *
 * @author Shubham Shandilya
 */
public class QuestionServiceImpl implements QuestionService{

    @Override
    public Question getQuestion(int questionId) throws ApplicationException {
        Question question = null;
        try{
            QuestionDAO questionDAO = new QuestionDAOImpl();
            question = questionDAO.getQuestion(questionId);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return question;
    }

    @Override
    public List<Question> getAllQuestions() throws ApplicationException {
        List<Question> questions = null;
        try{
            QuestionDAO questionDAO = new QuestionDAOImpl();
            questions = questionDAO.getAllQuestions();
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return questions;
    }

    @Override
    public List<Question> getAllQuestions(Examination examination) throws ApplicationException {
        List<Question> questions = null;
        try{
            QuestionDAO questionDAO = new QuestionDAOImpl();
            questions = questionDAO.getAllQuestions(examination);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return questions;
    }

    @Override
    public void saveOrUpdateQuestion(Question question) throws ApplicationException {
        try{
            QuestionDAO questionDAO = new QuestionDAOImpl();
            questionDAO.saveOrUpdateQuestion(question);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

    @Override
    public void deleteQuestion(Question question) throws ApplicationException {
        try{
            QuestionDAO questionDAO = new QuestionDAOImpl();
            questionDAO.deleteQuestion(question);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

    @Override
    public void deleteQuestion(int[] questionIds) throws ApplicationException {
        try{
            QuestionDAO questionDAO = new QuestionDAOImpl();
            questionDAO.deleteQuestion(questionIds);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

}
