/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Role;
import java.util.List;

/**
 * This interface contains the declaration of methods used for database
 * operations on SC_ROLE table
 *
 * @author Shubham Shandilya
 */
public interface RoleDAO {

    /**
     * Let us assume that the role id for Administrator is going to be 1.
     */
    public static final int ROLE_ADMIN = 1;

    /**
     * Let us assume that the role id for Examiner is going to be 2.
     */
    public static final int ROLE_EXAMINER = 2;

    /**
     * Let us assume that the role id for Examinee is going to be 3.
     */
    public static final int ROLE_EXAMINEE = 3;

    //Table 
    public static final String ROLE_TABLE = "SC_ROLE";
    
    //Columns
    public static final String ROLE_ID = "ROLE_ID";
    public static final String ROLE = "ROLE";
    
    /**
     * This method gets the role
     *
     * @param roleId
     * @return role
     * @throws DatabaseException
     */
    public Role getRole(int roleId) throws DatabaseException;

    /**
     * This method returns a list of all the roles available
     *
     * @return list of roles
     * @throws DatabaseException
     */
    public List<Role> getAllRoles() throws DatabaseException;

    /**
     * This method saves or updates a role object
     *
     * @param role
     * @throws DatabaseException
     */
    public void saveOrUpdateRole(Role role) throws DatabaseException;

    /**
     * This method deletes a role
     *
     * @param role
     * @throws DatabaseException
     */
    public void deleteRole(Role role) throws DatabaseException;

}
