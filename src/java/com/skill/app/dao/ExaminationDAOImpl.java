/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.User;
import com.skill.app.utility.ApplicationUtility;
import com.skill.app.utility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements ExaminationDAO for Oracle Database
 * @author Shubham Shandilya
 */
public class ExaminationDAOImpl implements ExaminationDAO{
    private static final Logger LOG = Logger.getLogger(ExaminationDAOImpl.class.getName());

    private static final String INSERT_STMT = "INSERT INTO SC_EXAMINATION(EXAMINATION_ID, EXAMINATION_NAME, MAXIMUM_MARKS, NUMBER_OF_QUESTIONS, MARKS_PER_QUESTION, PASSING_MARKS, "
            + "NEGATIVE_MARKS, TIME_IN_MINUTES, CREATED_BY, CREATED_DATE) VALUES (SC_EXAMINATION_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
    
    private static final String UPDATE_STMT = "UPDATE SC_EXAMINATION SET EXAMINATION_NAME = ?, MAXIMUM_MARKS = ?, NUMBER_OF_QUESTIONS = ?, MARKS_PER_QUESTION = ?, "
            + "PASSING_MARKS = ?, NEGATIVE_MARKS = ?, TIME_IN_MINUTES = ? WHERE EXAMINATION_ID = ?";
            
    private static final String DELETE_STMT = "DELETE SC_EXAMINATION WHERE EXAMINATION_ID = ?";
    
    private static final String SELECT_ALL = "SELECT E.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, E.MAXIMUM_MARKS MAXIMUM_MARKS, E.NUMBER_OF_QUESTIONS NUMBER_OF_QUESTIONS, E.MARKS_PER_QUESTION MARKS_PER_QUESTION, E.PASSING_MARKS PASSING_MARKS, "
            + "E.NEGATIVE_MARKS NEGATIVE_MARKS, E.TIME_IN_MINUTES TIME_IN_MINUTES, U.USER_ID USER_ID, U.USER_NAME USER_NAME, E.CREATED_DATE CREATED_DATE FROM SC_EXAMINATION E, SC_USER U WHERE U.USER_ID = E.CREATED_BY ORDER BY E.EXAMINATION_NAME";
    
    private static final String SELECT_BY_ID = "SELECT E.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, E.MAXIMUM_MARKS MAXIMUM_MARKS, E.NUMBER_OF_QUESTIONS NUMBER_OF_QUESTIONS, E.MARKS_PER_QUESTION MARKS_PER_QUESTION, E.PASSING_MARKS PASSING_MARKS, "
            + "E.NEGATIVE_MARKS NEGATIVE_MARKS, E.TIME_IN_MINUTES TIME_IN_MINUTES, U.USER_ID USER_ID, U.USER_NAME USER_NAME, E.CREATED_DATE CREATED_DATE FROM SC_EXAMINATION E, SC_USER U WHERE U.USER_ID = E.CREATED_BY AND E.EXAMINATION_ID = ?";
    
    private static final String SELECT_BY_NAME = "SELECT E.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, E.MAXIMUM_MARKS MAXIMUM_MARKS, E.NUMBER_OF_QUESTIONS NUMBER_OF_QUESTIONS, E.MARKS_PER_QUESTION MARKS_PER_QUESTION, E.PASSING_MARKS PASSING_MARKS, "
            + "E.NEGATIVE_MARKS NEGATIVE_MARKS, E.TIME_IN_MINUTES TIME_IN_MINUTES, U.USER_ID USER_ID, U.USER_NAME USER_NAME, E.CREATED_DATE CREATED_DATE FROM SC_EXAMINATION E, SC_USER U WHERE U.USER_ID = E.CREATED_BY AND E.EXAMINATION_NAME = ? ORDER BY E.EXAMINATION_NAME";
    
    private static final String SELECT_BY_USER = "SELECT E.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, E.MAXIMUM_MARKS MAXIMUM_MARKS, E.NUMBER_OF_QUESTIONS NUMBER_OF_QUESTIONS, E.MARKS_PER_QUESTION MARKS_PER_QUESTION, E.PASSING_MARKS PASSING_MARKS, "
            + "E.NEGATIVE_MARKS NEGATIVE_MARKS, E.TIME_IN_MINUTES TIME_IN_MINUTES, U.USER_ID USER_ID, U.USER_NAME USER_NAME, E.CREATED_DATE CREATED_DATE FROM SC_EXAMINATION E, SC_USER U WHERE U.USER_ID = E.CREATED_BY AND E.CREATED_BY = ? ORDER BY E.EXAMINATION_NAME";
    
    
    @Override
    public Examination getExamination(int examinationId) throws DatabaseException {
        List<Examination> examList = null;
        Examination exam = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, examinationId);
            rs = statement.executeQuery();
            
            examList = createExamObject(rs);
            
            if(examList != null && !examList.isEmpty()){
                exam = examList.get(0);
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
        
        return exam;
    }

    @Override
    public Examination getExamination(String examinationName) throws DatabaseException {
        List<Examination> examList = null;
        Examination exam = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_NAME);
            statement.setString(1, examinationName);
            rs = statement.executeQuery();
            
            examList = createExamObject(rs);
            
            if(examList != null && !examList.isEmpty()){
                exam = examList.get(0);
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
        
        return exam;
    }

    @Override
    public List<Examination> getAllExaminations() throws DatabaseException {
        
        List<Examination> examList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_ALL);
            rs = statement.executeQuery();
            
            examList = createExamObject(rs);
            
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
        
        return examList;
       
    }
        
    @Override
    public List<Examination> getExamination(User user) throws DatabaseException {
        List<Examination> examList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_USER);
            statement.setInt(1, user.getUserId());
            rs = statement.executeQuery();
            
            examList = createExamObject(rs);
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
        
        return examList;
    }

    @Override
    public void saveOrUpdateExamination(Examination examination) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            
            //If examination id = 0, then we are trying to save a new record, else update
            if(examination.getExaminationId()> 0){
                statement = connection.prepareStatement(UPDATE_STMT);
                statement.setString(1, examination.getExaminationName());
                statement.setInt(2, examination.getMaximumMarks());
                statement.setInt(3, examination.getNumberOfQuestions());
                statement.setInt(4, examination.getMarksPerQuestion());
                statement.setInt(5, examination.getPassingMarks());
                statement.setInt(6, examination.getNegativeMarks());
                statement.setInt(7, examination.getTimeInMinutes());
                statement.setInt(8, examination.getExaminationId());
            }else{
                statement = connection.prepareStatement(INSERT_STMT);
                statement.setString(1, examination.getExaminationName());
                statement.setInt(2, examination.getMaximumMarks());
                statement.setInt(3, examination.getNumberOfQuestions());
                statement.setInt(4, examination.getMarksPerQuestion());
                statement.setInt(5, examination.getPassingMarks());
                statement.setInt(6, examination.getNegativeMarks());
                statement.setInt(7, examination.getTimeInMinutes());
                statement.setInt(8, examination.getCreatedBy().getUserId());
            }
            
            statement.executeUpdate();
            
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

    @Override
    public void deleteExamination(Examination examination) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(DELETE_STMT);
            statement.setInt(1, examination.getExaminationId());
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
    
    @Override
    public void deleteExamination(int[] examinationIds) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            
            StringBuffer sb = new StringBuffer();
            sb.append("DELETE SC_EXAMINATION E WHERE E.EXAMINATION_ID IN ( ");
            for(int index = 0; index < examinationIds.length; index++){
                sb.append(examinationIds[index]);
                if(index < examinationIds.length - 1){
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
    
    private List<Examination> createExamObject(ResultSet rs) throws SQLException{
        List<Examination> examList = null;
        
        if(rs != null){
            
            //Initialize the list
            examList = new LinkedList<Examination>();

            while(rs.next()){
                
                //First get the result
                int examinationId = rs.getInt(EXAMINATION_ID);
                String examinationName = rs.getString(EXAMINATION_NAME);
                int maximumMarks = rs.getInt(MAXIMUM_MARKS);
                
                int totalQuestions = rs.getInt(NUMBER_OF_QUESTIONS);
                int marksPerQuestion = rs.getInt(MARKS_PER_QUESTION);
                int passingMarks = rs.getInt(PASSING_MARKS);
                int negativeMarks = rs.getInt(NEGATIVE_MARKS);
                int timeAllowed = rs.getInt(TIME_IN_MINUTES);
                int userId = rs.getInt(UserDAO.USER_ID);
                String userName = rs.getString(UserDAO.USER_NAME);
                java.sql.Date createdDate = rs.getDate(CREATED_DATE);
                
                //Convert sql date to util date
                Date createdDateOfExam = ApplicationUtility.sqlToUtilDate(createdDate);
                
                //Create createdBy 
                User createdBy = new User(userId, userName);
                
                //Create Examination object
                Examination examination = new Examination(examinationId, examinationName, maximumMarks, totalQuestions, marksPerQuestion, passingMarks, 
                        negativeMarks, timeAllowed, createdDateOfExam, createdBy);
                
                //Add the examination to the list
                examList.add(examination);
                
            }
        }
        
        return examList;
    }
}
