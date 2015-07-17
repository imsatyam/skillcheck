/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.Question;
import com.skill.app.utility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements QuestionDAO for Oracle database
 * 
 * @author Shubham Shandilya
 */
public class QuestionDAOImpl implements QuestionDAO {

    private static final Logger LOG = Logger.getLogger(QuestionDAOImpl.class.getName());

    private static final String INSERT_STMT = "INSERT INTO SC_QUESTION(QUESTION_ID, QUESTION, OPTION_A, OPTION_B, OPTION_C, "
            + "OPTION_D, CORRECT_ANSWER, EXAMINATION_ID) VALUES (SC_QUESTION_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_STMT = "UPDATE SC_QUESTION SET QUESTION = ?, OPTION_A = ?, OPTION_B = ?, "
            + "OPTION_C = ?, OPTION_D = ?, CORRECT_ANSWER = ?, EXAMINATION_ID = ? WHERE QUESTION_ID = ?";

    private static final String DELETE_STMT = "DELETE SC_QUESTION WHERE QUESTION_ID = ?";
    
    private static final String SELECT_BY_ID = "SELECT Q.QUESTION_ID QUESTION_ID, Q.QUESTION QUESTION, Q.OPTION_A OPTION_A, Q.OPTION_B OPTION_B, "
            + "Q.OPTION_C OPTION_C, Q.OPTION_D OPTION_D, Q.CORRECT_ANSWER CORRECT_ANSWER, Q.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME "
            + "FROM SC_QUESTION Q, SC_EXAMINATION E WHERE E.EXAMINATION_ID = Q.EXAMINATION_ID AND Q.QUESTION_ID = ?";

    private static final String SELECT_BY_EXAM = "SELECT Q.QUESTION_ID QUESTION_ID, Q.QUESTION QUESTION, Q.OPTION_A OPTION_A, Q.OPTION_B OPTION_B, "
            + "Q.OPTION_C OPTION_C, Q.OPTION_D OPTION_D, Q.CORRECT_ANSWER CORRECT_ANSWER, Q.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME "
            + "FROM SC_QUESTION Q, SC_EXAMINATION E WHERE E.EXAMINATION_ID = Q.EXAMINATION_ID AND Q.EXAMINATION_ID = ? ORDER BY Q.QUESTION_ID";
    
    private static final String SELECT_ALL = "SELECT Q.QUESTION_ID QUESTION_ID, Q.QUESTION QUESTION, Q.OPTION_A OPTION_A, Q.OPTION_B OPTION_B, "
            + "Q.OPTION_C OPTION_C, Q.OPTION_D OPTION_D, Q.CORRECT_ANSWER CORRECT_ANSWER, Q.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME "
            + "FROM SC_QUESTION Q, SC_EXAMINATION E WHERE E.EXAMINATION_ID = Q.EXAMINATION_ID ORDER BY E.EXAMINATION_NAME, Q.QUESTION_ID";
    
    @Override
    public Question getQuestion(int questionId) throws DatabaseException {
        List<Question> questionList = null;
        Question question = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, questionId);
            rs = statement.executeQuery();
            
            questionList = createQuestionObject(rs, true);
            
            if(questionList != null && !questionList.isEmpty()){
                question = questionList.get(0);
            }
            
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        }
        finally{
            DBUtility.close(rs);
            DBUtility.close(statement);
            DBUtility.close(connection);
        }
        
        return question;
    }

    @Override
    public List<Question> getAllQuestions() throws DatabaseException {
        List<Question> questionList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_ALL);
            rs = statement.executeQuery();
            
            questionList = createQuestionObject(rs, true);
            
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        }
        finally{
            DBUtility.close(rs);
            DBUtility.close(statement);
            DBUtility.close(connection);
        }
        
        return questionList;
    }

    @Override
    public List<Question> getAllQuestions(Examination examination) throws DatabaseException {
        List<Question> questionList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_EXAM);
            statement.setInt(1, examination.getExaminationId());
            rs = statement.executeQuery();
            
            questionList = createQuestionObject(rs, true);
            
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        }
        finally{
            DBUtility.close(rs);
            DBUtility.close(statement);
            DBUtility.close(connection);
        }
        
        return questionList;
    }

    @Override
    public void saveOrUpdateQuestion(Question question) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtility.getConnection();

            //If question id = 0, then we are trying to save a new record, else update
            if (question.getQuestionId() > 0) {
                statement = connection.prepareStatement(UPDATE_STMT);
                statement.setString(1, question.getQuestion());
                statement.setString(2, question.getOptionA());
                statement.setString(3, question.getOptionB());
                statement.setString(4, question.getOptionC());
                statement.setString(5, question.getOptionD());
                statement.setString(6, question.getCorrectAnswer());
                statement.setInt(7, question.getExamination().getExaminationId());
                statement.setInt(8, question.getQuestionId());
            } else {
                statement = connection.prepareStatement(INSERT_STMT);
                statement.setString(1, question.getQuestion());
                statement.setString(2, question.getOptionA());
                statement.setString(3, question.getOptionB());
                statement.setString(4, question.getOptionC());
                statement.setString(5, question.getOptionD());
                statement.setString(6, question.getCorrectAnswer());
                statement.setInt(7, question.getExamination().getExaminationId());
            }
            statement.executeUpdate();

        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } finally {
            DBUtility.close(statement);
            DBUtility.close(connection);
        }
    }

    @Override
    public void deleteQuestion(Question question) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(DELETE_STMT);
            statement.setInt(1, question.getQuestionId());
            statement.execute();

        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } finally {
            DBUtility.close(statement);
            DBUtility.close(connection);
        }
    }
    
    @Override
    public void deleteQuestion(int[] questionIds) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            
            StringBuffer sb = new StringBuffer();
            sb.append("DELETE SC_QUESTION Q WHERE Q.QUESTION_ID IN ( ");
            for(int index = 0; index < questionIds.length; index++){
                sb.append(questionIds[index]);
                if(index < questionIds.length - 1){
                    sb.append(", ");
                }
            }            
            sb.append(")");
            
            statement = connection.prepareStatement(sb.toString());
            statement.execute();
            
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex);
        }
        finally{
            DBUtility.close(statement);
            DBUtility.close(connection);
        }
    }

    private List<Question> createQuestionObject(ResultSet rs, boolean isFetchUsingJoin) throws SQLException {
        List<Question> questionList = null;

        if (rs != null) {

            //Initialize the list
            questionList = new LinkedList<Question>();

            while (rs.next()) {

                //First get the result
                int questionId = rs.getInt(QUESTION_ID);
                String question = rs.getString(QUESTION);
                String optionA = rs.getString(OPTION_A);
                String optionB = rs.getString(OPTION_B);
                String optionC = rs.getString(OPTION_C);
                String optionD = rs.getString(OPTION_D);
                String correctAnswer = rs.getString(CORRECT_ANSWER);
                int examinationId = rs.getInt(EXAMINATION_ID);
                
                String exmainationName = null;
                Examination examination = null;
                
                if(isFetchUsingJoin){
                    exmainationName = rs.getString(ExaminationDAO.EXAMINATION_NAME);
                    examination = new Examination(examinationId, exmainationName);
                }else{
                    examination = new Examination(examinationId);
                }

                //Create Question object
                Question questionObj = new Question(questionId, question, optionA, optionB, optionC, optionD, correctAnswer, examination);

                //Add the question to the list
                questionList.add(questionObj);

            }
        }

        return questionList;
    }
}
