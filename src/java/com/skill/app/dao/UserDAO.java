/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.exception.InvalidLoginException;
import com.skill.app.model.Role;
import com.skill.app.model.User;
import java.util.List;

/**
 * This interface provides the declaration of methods used for database
 * operations on SC_USER table
 *
 * @author Shubham Shandilya
 */
public interface UserDAO {

    //Table
    public static final String USER_TABLE = "SC_USER";
    
    //Columns
    public static final String USER_ID = "USER_ID";
    public static final String USER_NAME = "USER_NAME";
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String ADDRESS = "ADDRESS";
    public static final String CONTACT = "CONTACT";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String ACTIVE = "ACTIVE";
    public static final String ROLE_ID = "ROLE_ID";
    
    /**
     * This method validates the user login.
     *
     * @param userName
     * @param password
     * @return user
     * @throws InvalidLoginException
     * @throws DatabaseException
     */
    public User validateUser(String userName, String password) throws InvalidLoginException, DatabaseException;

    /**
     * This method retrieves details of a user using his user id.
     *
     * @param userId
     * @return user
     * @throws DatabaseException
     */
    public User getUser(int userId) throws DatabaseException;

    /**
     * This method retrieves details of a user using his user name.
     *
     * @param userName
     * @return user
     * @throws DatabaseException
     */
    public User getUser(String userName) throws DatabaseException;

    /**
     * This method returns a list of all the users
     *
     * @return list of users
     * @throws DatabaseException
     */
    public List<User> getAllUsers() throws DatabaseException;

    /**
     * This method returns a list of users of a given role.
     *
     * @param role
     * @return list of users
     * @throws DatabaseException
     */
    public List<User> getUsersBasedOnRole(Role role) throws DatabaseException;

    /**
     * This method holds the logic to save or update the user details
     *
     * @param user
     * @throws DatabaseException
     */
    public void saveOrUpdateUser(User user) throws DatabaseException;

    /**
     * This method sets a user inactive. It is similar to delete.
     *
     * @param user
     * @throws DatabaseException
     */
    public void setUserInactive(User user) throws DatabaseException;
}
