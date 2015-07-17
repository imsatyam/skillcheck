/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.model;

/**
 * Role class holds the information about the roles available in the system.
 *
 * @author Shubham Shandilya
 */
public class Role {

    private int roleId = 0;
    private String role;

    /**
     * Default Constructor
     */
    public Role() {
    }

    /**
     * Minimal constructor
     *
     * @param roleId
     */
    public Role(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Full Constructor
     *
     * @param roleId
     * @param role
     */
    public Role(int roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    /**
     * This method returns the role id
     *
     * @return roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * This method is used to set the role id
     *
     *
     * @param roleId - an id for the role - It is corresponding to Primary Key
     * in the table
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * This method returns the name of the role
     *
     * @return roleName
     */
    public String getRole() {
        return role;
    }

    /**
     * This method is used to set the role name
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", role=" + role + '}';
    }

}
