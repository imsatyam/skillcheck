/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.controller;

import com.skill.app.constant.ApplicationConstants;
import com.skill.app.exception.ApplicationException;
import com.skill.app.model.Role;
import com.skill.app.model.User;
import com.skill.app.service.RoleService;
import com.skill.app.service.RoleServiceImpl;
import com.skill.app.service.UserService;
import com.skill.app.service.UserServiceImpl;
import com.skill.app.vo.OperationStatus;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shubham Shandilya
 */
public class RegistrationServlet extends BaseServlet {

    private static final Logger LOG = Logger.getLogger(RegistrationServlet.class.getName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nextPage = "/WEB-INF/jsp/register.jsp";
        
        try {

            //Get the dropdown of Roles
            getRoleDropDown(request);

            //If it is save operation then, do registration
            String operation = request.getParameter(ApplicationConstants.OPERATION);
            if(operation != null && !operation.equals(ApplicationConstants.EMPTY)){
                nextPage = doRegistration(request, operation);
            }

        } catch (ApplicationException e) {
            LOG.log(Level.SEVERE, "An error occurred: ", e);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.REG_STATUS, status);
        } catch (NumberFormatException e) {
            LOG.log(Level.SEVERE, "An error occurred: ", e);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.REG_STATUS, status);
        }catch (Exception e) {
            LOG.log(Level.SEVERE, "An error occurred: ", e);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.REG_STATUS, status);
        }
        setResponseHeader(response);
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);

    }

    private String doRegistration(HttpServletRequest request, String operation) throws ApplicationException, NumberFormatException {
        
        String nextPage = "/WEB-INF/jsp/register.jsp";

        switch (Integer.parseInt(operation)) {
            case ApplicationConstants.INSERT_OPERATION:

                //Read inputs
                String username = request.getParameter("username");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String address = request.getParameter("address");
                String contact = request.getParameter("mobile");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String roleId = request.getParameter("role");

                //Create Role object
                Role role = new Role(Integer.parseInt(roleId));

                //Create User object
                User user = new User(username, firstName, lastName, address, contact, email, password, true, role);

                //Register User
                UserService userService = new UserServiceImpl();
                userService.saveOrUpdateUser(user);

                //Get response object
                OperationStatus status = new OperationStatus(ApplicationConstants.REG_SUCCESS_MSG);
                request.setAttribute(ApplicationConstants.REG_STATUS, status);
                request.setAttribute(ApplicationConstants.REG_EMAIL, user.getEmail());

                break;
                
            case ApplicationConstants.CANCEL_OPERATION:
                nextPage = "home.htm";
                break;
        }
        return nextPage;
    }

    private void getRoleDropDown(HttpServletRequest request) throws ApplicationException {
        RoleService role = new RoleServiceImpl();
        List<Role> roles = role.getAllRoles();
        request.setAttribute(ApplicationConstants.ROLES, roles);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
