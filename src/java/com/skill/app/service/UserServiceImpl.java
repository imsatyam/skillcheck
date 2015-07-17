/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.dao.UserDAO;
import com.skill.app.dao.UserDAOImpl;
import com.skill.app.exception.ApplicationException;
import com.skill.app.exception.DatabaseException;
import com.skill.app.exception.InvalidLoginException;
import com.skill.app.model.Role;
import com.skill.app.model.User;
import java.util.List;

/**
 * This class implements UserService interface to connect with DAO layer
 *
 * @author Shubham Shandilya
 */
public class UserServiceImpl implements UserService{

    @Override
    public User validateUser(String userName, String password) throws InvalidLoginException, ApplicationException {
        User user = null;
        try{
            UserDAO userDAO = new UserDAOImpl();
            user = userDAO.validateUser(userName, password);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }catch(InvalidLoginException de){
            throw de;
        }
        return user;
    }

    @Override
    public User getUser(int userId) throws ApplicationException {
        User user = null;
        try{
            UserDAO userDAO = new UserDAOImpl();
            user = userDAO.getUser(userId);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return user;
    }

    @Override
    public User getUser(String userName) throws ApplicationException {
        User user = null;
        try{
            UserDAO userDAO = new UserDAOImpl();
            user = userDAO.getUser(userName);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws ApplicationException {
        List<User> users = null;
        try{
            UserDAO userDAO = new UserDAOImpl();
            users = userDAO.getAllUsers();
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return users;
    }

    @Override
    public List<User> getUsersBasedOnRole(Role role) throws ApplicationException {
        List<User> users = null;
        try{
            UserDAO userDAO = new UserDAOImpl();
            users = userDAO.getUsersBasedOnRole(role);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return users;
    }

    @Override
    public void saveOrUpdateUser(User user) throws ApplicationException {
        try{
            UserDAO userDAO = new UserDAOImpl();
            userDAO.saveOrUpdateUser(user);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

    @Override
    public void setUserInactive(User user) throws ApplicationException {
        try{
            UserDAO userDAO = new UserDAOImpl();
            userDAO.setUserInactive(user);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

}
