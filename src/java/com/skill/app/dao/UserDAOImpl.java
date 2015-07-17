/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skill.app.dao;

import com.skill.app.constant.ApplicationConstants;
import com.skill.app.exception.DatabaseException;
import com.skill.app.exception.InvalidLoginException;
import com.skill.app.model.Role;
import com.skill.app.model.User;
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
 * Implementation of UserDAO for oracle database
 * @author Shubham Shandilya
 */
public class UserDAOImpl implements UserDAO{
    
    private static final Logger LOG = Logger.getLogger(UserDAOImpl.class.getName());
    
    private static final String INSERT_STMT = "INSERT INTO SC_USER(USER_ID, USER_NAME, FIRST_NAME, LAST_NAME, ADDRESS, CONTACT, EMAIL, PASSWORD, ACTIVE, ROLE_ID) "
            + "VALUES (SC_USER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String UPDATE_STMT = "UPDATE SC_USER SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, CONTACT = ?, EMAIL = ?, PASSWORD = ?, ACTIVE = ?, "
            + "ROLE_ID = ? WHERE USER_ID = ?";
    
    private static final String DELETE_STMT = "UPDATE SC_USER SET ACTIVE = 0 WHERE USER_ID = ?";
    
    private static final String VALIDATE_STMT = "SELECT U.USER_ID USER_ID, U.USER_NAME USER_NAME, U.FIRST_NAME FIRST_NAME, "
            + "U.LAST_NAME LAST_NAME, U.ADDRESS ADDRESS, U.CONTACT CONTACT, U.EMAIL EMAIL, U.PASSWORD PASSWORD, U.ACTIVE ACTIVE, "
            + "R.ROLE_ID ROLE_ID, R.ROLE ROLE FROM SC_USER U, SC_ROLE R WHERE UPPER(U.USER_NAME) = ? AND U.PASSWORD = ? AND U.ROLE_ID = R.ROLE_ID";
    
    private static final String SELECT_STMT_BY_ID = "SELECT U.USER_ID USER_ID, U.USER_NAME USER_NAME, U.FIRST_NAME FIRST_NAME, "
            + "U.LAST_NAME LAST_NAME, U.ADDRESS ADDRESS, U.CONTACT CONTACT, U.EMAIL EMAIL, U.PASSWORD PASSWORD, U.ACTIVE ACTIVE, "
            + "R.ROLE_ID ROLE_ID, R.ROLE ROLE FROM SC_USER U, SC_ROLE R WHERE U.USER_ID = ? AND U.ROLE_ID = R.ROLE_ID ORDER BY USER_NAME";
    
    private static final String SELECT_STMT_BY_ROLE = "SELECT U.USER_ID USER_ID, U.USER_NAME USER_NAME, U.FIRST_NAME FIRST_NAME, "
            + "U.LAST_NAME LAST_NAME, U.ADDRESS ADDRESS, U.CONTACT CONTACT, U.EMAIL EMAIL, U.PASSWORD PASSWORD, U.ACTIVE ACTIVE, "
            + "R.ROLE_ID ROLE_ID, R.ROLE ROLE FROM SC_USER U, SC_ROLE R WHERE U.ROLE_ID = ? AND U.ROLE_ID = R.ROLE_ID ORDER BY USER_NAME";
    
    private static final String SELECT_STMT_BY_USERNAME = "SELECT U.USER_ID USER_ID, U.USER_NAME USER_NAME, U.FIRST_NAME FIRST_NAME, "
            + "U.LAST_NAME LAST_NAME, U.ADDRESS ADDRESS, U.CONTACT CONTACT, U.EMAIL EMAIL, U.PASSWORD PASSWORD, U.ACTIVE ACTIVE, "
            + "R.ROLE_ID ROLE_ID, R.ROLE ROLE FROM SC_USER U, SC_ROLE R WHERE UPPER(U.USER_NAME) = ? AND U.ROLE_ID = R.ROLE_ID ORDER BY USER_NAME";
    
    private static final String SELECT_STMT_ALL = "SELECT U.USER_ID USER_ID, U.USER_NAME USER_NAME, U.FIRST_NAME FIRST_NAME, "
            + "U.LAST_NAME LAST_NAME, U.ADDRESS ADDRESS, U.CONTACT CONTACT, U.EMAIL EMAIL, U.PASSWORD PASSWORD, U.ACTIVE ACTIVE, "
            + "R.ROLE_ID ROLE_ID, R.ROLE ROLE FROM SC_USER U, SC_ROLE R WHERE U.ROLE_ID = R.ROLE_ID ORDER BY USER_NAME";
    
    @Override
    public User validateUser(String userName, String password) throws InvalidLoginException, DatabaseException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(VALIDATE_STMT);
            statement.setString(1, userName.toUpperCase());
            statement.setString(2, password);
            rs = statement.executeQuery();
            
            List<User> userList = createUserObject(rs);
            if(userList != null && !userList.isEmpty()){
                user = userList.get(0);
            }else{
                LOG.log(Level.WARNING, "A user tried to login unsuccessfully. Username {0}", userName);
                throw new InvalidLoginException(ApplicationConstants.INVALID_LOGIN);
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
        return user;
    }

    @Override
    public User getUser(int userId) throws DatabaseException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_STMT_BY_ID);
            statement.setInt(1, userId);
            rs = statement.executeQuery();
            
            List<User> userList = createUserObject(rs);
            if(userList != null && !userList.isEmpty()){
                user = userList.get(0);
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
        return user;
    }

    @Override
    public User getUser(String userName) throws DatabaseException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_STMT_BY_USERNAME);
            statement.setString(1, userName.toUpperCase());
            rs = statement.executeQuery();
            
            List<User> userList = createUserObject(rs);
            if(userList != null && !userList.isEmpty()){
                user = userList.get(0);
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
        return user;
    }

    @Override
    public List<User> getAllUsers() throws DatabaseException {
        List<User> userList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_STMT_ALL);
            rs = statement.executeQuery();
            
            userList = createUserObject(rs);
                        
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
        return userList;
    }

    @Override
    public List<User> getUsersBasedOnRole(Role role) throws DatabaseException {
        List<User> userList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_STMT_BY_ROLE);
            statement.setInt(1, role.getRoleId());
            rs = statement.executeQuery();
            
            userList = createUserObject(rs);
                        
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
        return userList;
    }

    @Override
    public void saveOrUpdateUser(User user) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            
            //If role id = 0, then we are trying to save a new record, else update
            if(user.getUserId()> 0){
                statement = connection.prepareStatement(UPDATE_STMT);
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getAddress());
                statement.setString(4, user.getContact());
                statement.setString(5, user.getEmail());
                statement.setString(6, user.getPassword());
                statement.setInt(7, user.isActive() ? 1 : 0);
                statement.setInt(8, user.getRole().getRoleId());
                statement.setInt(9, user.getUserId());
            }else{
                statement = connection.prepareStatement(INSERT_STMT);
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getFirstName());
                statement.setString(3, user.getLastName());
                statement.setString(4, user.getAddress());
                statement.setString(5, user.getContact());
                statement.setString(6, user.getEmail());
                statement.setString(7, user.getPassword());
                statement.setInt(8, user.isActive() ? 1 : 0);
                statement.setInt(9, user.getRole().getRoleId());                
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
    public void setUserInactive(User user) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(DELETE_STMT);
            statement.setInt(1, user.getUserId());            
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
    
    private List<User> createUserObject(ResultSet rs) throws SQLException{
        List<User> userList = null;
        if(rs != null){
            userList = new LinkedList<User>();
            while(rs.next()){
                int userId = rs.getInt(USER_ID);
                String userName = rs.getString(USER_NAME);
                String firstName = rs.getString(FIRST_NAME);
                String lastName = rs.getString(LAST_NAME);
                String address = rs.getString(ADDRESS);
                String contact = rs.getString(CONTACT);
                String email = rs.getString(EMAIL);
                String password = rs.getString(PASSWORD);
                int active = rs.getInt(ACTIVE);
                int roleId = rs.getInt(ROLE_ID);
                String roleName = rs.getString(RoleDAO.ROLE);
                
                //Create Role Object
                Role role = new Role(roleId, roleName);
                
                //Check if user is active
                boolean isActive = 1 == active;
                
                //Create User Object
                User user = new User(userId, userName, firstName, lastName, address, contact, email, password, isActive, role);
                
                //Add user to the list
                userList.add(user);
            }
        }
        return userList;
    }
    
}
