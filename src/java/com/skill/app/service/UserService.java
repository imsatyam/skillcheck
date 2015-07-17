/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.exception.ApplicationException;
import com.skill.app.exception.InvalidLoginException;
import com.skill.app.model.Role;
import com.skill.app.model.User;
import java.util.List;

/**
 * This interface provides the declaration of methods to access UserDAO and 
 * related Business logic.
 *
 * @author Shubham Shandilya
 */
public interface UserService {

    /**
     * This method validates the user login.
     *
     * @param userName
     * @param password
     * @return user
     * @throws InvalidLoginException
     * @throws ApplicationException
     */
    public User validateUser(String userName, String password) throws InvalidLoginException, ApplicationException;

    /**
     * This method retrieves details of a user using his user id.
     *
     * @param userId
     * @return user
     * @throws ApplicationException
     */
    public User getUser(int userId) throws ApplicationException;

    /**
     * This method retrieves details of a user using his user name.
     *
     * @param userName
     * @return user
     * @throws ApplicationException
     */
    public User getUser(String userName) throws ApplicationException;

    /**
     * This method returns a list of all the users
     *
     * @return list of users
     * @throws ApplicationException
     */
    public List<User> getAllUsers() throws ApplicationException;

    /**
     * This method returns a list of users of a given role.
     *
     * @param role
     * @return list of users
     * @throws ApplicationException
     */
    public List<User> getUsersBasedOnRole(Role role) throws ApplicationException;

    /**
     * This method holds the logic to save or update the user details
     *
     * @param user
     * @throws ApplicationException
     */
    public void saveOrUpdateUser(User user) throws ApplicationException;

    /**
     * This method sets a user inactive. It is similar to delete.
     *
     * @param user
     * @throws ApplicationException
     */
    public void setUserInactive(User user) throws ApplicationException;
}
