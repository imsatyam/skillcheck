/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Examination;
import com.skill.app.model.Result;
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
 * This class implements ResultDAO for oracle database
 *
 * @author Shubham Shandilya
 */
public class ResultDAOImpl implements ResultDAO {

    private static final Logger LOG = Logger.getLogger(ResultDAOImpl.class.getName());

    private static final String INSERT_STMT = "INSERT INTO SC_RESULT(RESULT_ID, EXAMINATION_ID, USER_ID, NUMBER_CORRECT, NUMBER_INCORRECT, MARKS_OBTAINED, IS_PASS, EXAMINATION_DATE) "
            + "VALUES (SC_RESULT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";

    private static final String DELETE_STMT = "DELETE SC_RESULT WHERE RESULT_ID = ?";
    
    private static final String SELECT_BY_ID = "SELECT R.RESULT_ID RESULT_ID, R.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, R.USER_ID USER_ID, U.USER_NAME USER_NAME, "
            + "R.NUMBER_CORRECT NUMBER_CORRECT, R.NUMBER_INCORRECT NUMBER_INCORRECT, R.MARKS_OBTAINED MARKS_OBTAINED, R.IS_PASS IS_PASS, R.EXAMINATION_DATE EXAMINATION_DATE "
            + "FROM SC_RESULT R, SC_EXAMINATION E, SC_USER U WHERE R.EXAMINATION_ID = E.EXAMINATION_ID AND R.USER_ID = U.USER_ID AND R.RESULT_ID = ?";

    private static final String SELECT_BY_EXAM = "SELECT R.RESULT_ID RESULT_ID, R.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, R.USER_ID USER_ID, U.USER_NAME USER_NAME, "
            + "R.NUMBER_CORRECT NUMBER_CORRECT, R.NUMBER_INCORRECT NUMBER_INCORRECT, R.MARKS_OBTAINED MARKS_OBTAINED, R.IS_PASS IS_PASS, R.EXAMINATION_DATE EXAMINATION_DATE "
            + "FROM SC_RESULT R, SC_EXAMINATION E, SC_USER U WHERE R.EXAMINATION_ID = E.EXAMINATION_ID AND R.USER_ID = U.USER_ID AND R.EXAMINATION_ID = ? ORDER BY R.EXAMINATION_DATE DESC";
    
    private static final String SELECT_BY_USER = "SELECT R.RESULT_ID RESULT_ID, R.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, R.USER_ID USER_ID, U.USER_NAME USER_NAME, "
            + "R.NUMBER_CORRECT NUMBER_CORRECT, R.NUMBER_INCORRECT NUMBER_INCORRECT, R.MARKS_OBTAINED MARKS_OBTAINED, R.IS_PASS IS_PASS, R.EXAMINATION_DATE EXAMINATION_DATE "
            + "FROM SC_RESULT R, SC_EXAMINATION E, SC_USER U WHERE R.EXAMINATION_ID = E.EXAMINATION_ID AND R.USER_ID = U.USER_ID AND R.USER_ID = ? ORDER BY R.EXAMINATION_DATE DESC";
    
    private static final String SELECT_BY_EXAM_USER = "SELECT R.RESULT_ID RESULT_ID, R.EXAMINATION_ID EXAMINATION_ID, E.EXAMINATION_NAME EXAMINATION_NAME, R.USER_ID USER_ID, U.USER_NAME USER_NAME, "
            + "R.NUMBER_CORRECT NUMBER_CORRECT, R.NUMBER_INCORRECT NUMBER_INCORRECT, R.MARKS_OBTAINED MARKS_OBTAINED, R.IS_PASS IS_PASS, R.EXAMINATION_DATE EXAMINATION_DATE "
            + "FROM SC_RESULT R, SC_EXAMINATION E, SC_USER U WHERE R.EXAMINATION_ID = E.EXAMINATION_ID AND R.USER_ID = U.USER_ID AND R.EXAMINATION_ID = ? AND R.USER_ID = ? ORDER BY R.EXAMINATION_DATE DESC";
    
    @Override
    public Result getResult(int resultId) throws DatabaseException {
        List<Result> resultList = null;
        Result result = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, resultId);
            rs = statement.executeQuery();
            
            resultList = createResultObject(rs);
            
            if(resultList != null && !resultList.isEmpty()){
                result = resultList.get(0);
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
        
        return result;
    }

    @Override
    public List<Result> getResult(Examination examination, User user) throws DatabaseException {
        List<Result> resultList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_EXAM_USER);
            statement.setInt(1, examination.getExaminationId());
            statement.setInt(2, user.getUserId());
            rs = statement.executeQuery();
            
            resultList = createResultObject(rs);
        
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
        
        return resultList;
    }

    @Override
    public List<Result> getResult(Examination examination) throws DatabaseException {
        List<Result> resultList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_EXAM);
            statement.setInt(1, examination.getExaminationId());
            rs = statement.executeQuery();
            
            resultList = createResultObject(rs);
        
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
        
        return resultList;
    }

    @Override
    public List<Result> getResult(User user) throws DatabaseException {
        List<Result> resultList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_BY_USER);
            statement.setInt(1, user.getUserId());
            rs = statement.executeQuery();
            
            resultList = createResultObject(rs);
        
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
        
        return resultList;
    }

    @Override
    public void saveOrUpdateResult(Result result) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtility.getConnection();

            //If result id = 0, then we are trying to save a new record, else update
            if (result.getResultId() == 0) {
                statement = connection.prepareStatement(INSERT_STMT);
                statement.setInt(1, result.getExamination().getExaminationId());
                statement.setInt(2, result.getUser().getUserId());
                statement.setInt(3, result.getNumberCorrect());
                statement.setInt(4, result.getNumberIncorrect());
                statement.setInt(5, result.getMarksObtained());
                statement.setInt(6, result.getIsPass());
                statement.executeUpdate();
            }
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
    public void deleteResult(Result result) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(DELETE_STMT);
            statement.setInt(1, result.getResultId());
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

    private List<Result> createResultObject(ResultSet rs) throws SQLException {
        List<Result> resultList = null;

        if (rs != null) {

            //Initialize the list
            resultList = new LinkedList<Result>();

            while (rs.next()) {

                //First get the result
                int resultId = rs.getInt(RESULT_ID);

                int examinationId = rs.getInt(EXAMINATION_ID);
                String examinationName = rs.getString(ExaminationDAO.EXAMINATION_NAME);

                int userId = rs.getInt(UserDAO.USER_ID);
                String userName = rs.getString(UserDAO.USER_NAME);

                int numberCorrect = rs.getInt(NUMBER_CORRECT);
                int numberIncorrect = rs.getInt(NUMBER_INCORRECT);
                int marksObtained = rs.getInt(MARKS_OBTAINED);
                int isPass = rs.getInt(IS_PASS);
                java.sql.Date examDate = rs.getDate(EXAMINATION_DATE);

                //Convert sql date to util date
                Date examinationDate = ApplicationUtility.sqlToUtilDate(examDate);

                //Create User and Examination
                User user = new User(userId, userName);
                Examination examination = new Examination(examinationId, examinationName);

                //Create Result object
                Result result = new Result(resultId, numberCorrect, numberIncorrect, marksObtained, isPass, examinationDate, user, examination);

                //Add the examination to the list
                resultList.add(result);

            }
        }

        return resultList;
    }
}
