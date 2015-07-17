/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skill.app.dao;

import com.skill.app.exception.DatabaseException;
import com.skill.app.model.Role;
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
 * Implementation of RoleDAO for oracle database
 * @author Shubham Shandilya
 */
public class RoleDAOImpl implements RoleDAO{
    private static final Logger LOG = Logger.getLogger(RoleDAOImpl.class.getName());

    private static final String SELECT_STMT = "SELECT ROLE_ID, ROLE FROM SC_ROLE ORDER BY ROLE";
    private static final String SELECT_STMT_ID = "SELECT ROLE_ID, ROLE FROM SC_ROLE WHERE ROLE_ID = ? ORDER BY ROLE";
    private static final String INSERT_STMT = "INSERT INTO SC_ROLE(ROLE_ID, ROLE) VALUES (SC_ROLE_SEQ.NEXTVAL, ?)";
    private static final String UPDATE_STMT = "UPDATE SC_ROLE SET ROLE=? WHERE ROLE_ID = ?";
    private static final String DELETE_STMT = "DELETE SC_ROLE WHERE ROLE_ID = ?";
    
    @Override
    public Role getRole(int roleId) throws DatabaseException {
        
        Role role = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_STMT_ID);
            statement.setInt(1, roleId);
            rs = statement.executeQuery();
            
            List<Role> roleList = createRoleObject(rs);
            if(roleList != null && !roleList.isEmpty()){
                role = roleList.get(0);
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
        
        return role;
    }

    @Override
    public List<Role> getAllRoles() throws DatabaseException {
        
        List<Role> roleList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(SELECT_STMT);
            rs = statement.executeQuery();
            
            roleList = createRoleObject(rs);
            
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
        
        return roleList;
    }

    @Override
    public void saveOrUpdateRole(Role role) throws DatabaseException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            
            //If role id = 0, then we are trying to save a new record, else update
            if(role.getRoleId() > 0){
                statement = connection.prepareStatement(UPDATE_STMT);
                statement.setString(1, role.getRole());
                statement.setInt(2, role.getRoleId());
            }else{
                statement = connection.prepareStatement(INSERT_STMT);
                statement.setString(1, role.getRole());                
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
    public void deleteRole(Role role) throws DatabaseException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DBUtility.getConnection();
            statement = connection.prepareStatement(DELETE_STMT);
            statement.setInt(1, role.getRoleId());
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
    
    private List<Role> createRoleObject(ResultSet rs) throws SQLException{
        
        List<Role> roleList = null;
        
        if(rs != null){
            
            //Initialize the list
            roleList = new LinkedList<Role>();
            
            while(rs.next()){
                
                //First get the result
                int roleId = rs.getInt(ROLE_ID);
                String roleName = rs.getString(ROLE);
                
                //Now create role object
                Role role = new Role(roleId, roleName);
                
                //Add the role to the list
                roleList.add(role);
                
            }
        }
        
        return roleList;
    }
    
}
