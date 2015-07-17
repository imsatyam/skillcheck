/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.model;

/**
 * User class holds the necessary information of all the users of the system.
 *
 * @author Shubham Shandilya
 */
public class User {

    private int userId = 0;
    private String userName;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    private String email;
    private String password;
    private boolean active;
    private Role role;

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Basic Constructor
     * 
     * @param userId
     */
    public User(int userId) {
        this.userId = userId;
    }
    
    /**
     * Minimal Constructor
     *
     * @param userId
     * @param userName
     */
    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    /**
     * Constructor can be used while creating the User
     *
     * @param userName
     * @param firstName
     * @param lastName
     * @param address
     * @param contact
     * @param email
     * @param password
     * @param active
     * @param role
     */
    public User(String userName, String firstName, String lastName, String address, String contact, String email, String password, boolean active, Role role) {
        this.userId = 0;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    /**
     * Full Constructor
     *
     * @param userId
     * @param userName
     * @param firstName
     * @param lastName
     * @param address
     * @param contact
     * @param email
     * @param password
     * @param active
     * @param role
     */
    public User(int userId, String userName, String firstName, String lastName, String address, String contact, String email, String password, boolean active, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    /**
     * This method returns the numeric user id.
     *
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * This method is used to set the user id in the system
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * This method returns the username of any user
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method is used to set the user name of a user
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method returns the first name of the user
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method sets the first name of a user
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method returns the last name of the user
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method is used to set the value of last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method returns the address of the user
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method sets the address of the user
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method returns the contact number of the user
     *
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method is used to set the contact number of the user
     *
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * This method returns the email of the user
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the email id of the user
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method is used to get the password of the user
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to set the password of the user
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns true if the user is active and false otherwise
     *
     * @return active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * This method sets the state of the user - Active or Inactive
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * This method returns the role of the user. i.e Admin, Student or Examiner
     *
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * This method sets the role of the user
     *
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", contact=" + contact + ", email=" + email + ", password=" + password + ", active=" + active + ", role=" + role + '}';
    }

}
