/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.service;

import com.skill.app.dao.RoleDAO;
import com.skill.app.dao.RoleDAOImpl;
import com.skill.app.exception.ApplicationException;
import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Role;
import java.util.List;

/**
 * This class implements RoleService to connect to RoleDAO
 *
 * @author Shubham Shandilya
 */
public class RoleServiceImpl implements RoleService{

    @Override
    public Role getRole(int roleId) throws ApplicationException {
       Role role = null;
        try{
            RoleDAO roleDAO = new RoleDAOImpl();
            role = roleDAO.getRole(roleId);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return role;
    }

    @Override
    public List<Role> getAllRoles() throws ApplicationException {
        List<Role> roleList = null;
        try{
            RoleDAO roleDAO = new RoleDAOImpl();
            roleList = roleDAO.getAllRoles();
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
        return roleList;
    }

    @Override
    public void saveOrUpdateRole(Role role) throws ApplicationException {
        try{
            RoleDAO roleDAO = new RoleDAOImpl();
            roleDAO.saveOrUpdateRole(role);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }

    @Override
    public void deleteRole(Role role) throws ApplicationException {
        try{
            RoleDAO roleDAO = new RoleDAOImpl();
            roleDAO.deleteRole(role);
        }catch(DatabaseException de){
            throw new ApplicationException(de);
        }
    }
    
}
