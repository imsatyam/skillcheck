/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.exception.ApplicationException;
import com.skill.app.model.Role;
import java.util.List;

/**
 * This interface contains the declaration of methods used to access RoleDAO 
 * and other business logic
 *
 * @author Shubham Shandilya
 */
public interface RoleService {

    /**
     * This method gets the role
     *
     * @param roleId
     * @return role
     * @throws ApplicationException
     */
    public Role getRole(int roleId) throws ApplicationException;

    /**
     * This method returns a list of all the roles available
     *
     * @return list of roles
     * @throws ApplicationException
     */
    public List<Role> getAllRoles() throws ApplicationException;

    /**
     * This method saves or updates a role object
     *
     * @param role
     * @throws ApplicationException
     */
    public void saveOrUpdateRole(Role role) throws ApplicationException;

    /**
     * This method deletes a role
     *
     * @param role
     * @throws ApplicationException
     */
    public void deleteRole(Role role) throws ApplicationException;

}
