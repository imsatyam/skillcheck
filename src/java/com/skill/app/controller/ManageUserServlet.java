/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skill.app.controller;

import com.skill.app.constant.ApplicationConstants;
import com.skill.app.exception.ApplicationException;
import com.skill.app.model.User;
import com.skill.app.service.UserService;
import com.skill.app.service.UserServiceImpl;
import com.skill.app.vo.OperationStatus;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shubham Shandilya
 */
public class ManageUserServlet extends BaseServlet {
    private static final Logger LOG = Logger.getLogger(ManageUserServlet.class.getName());

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
        //Default page is login page
        String nextPage = "home.htm";

        try {
            //First thing to check is - whether user is logged in or not. If not, make him login
            HttpSession session = request.getSession();
            if (session.getAttribute(ApplicationConstants.LOGGED_IN_USER) != null) {
                
                String operation = request.getParameter("operation");
                if (null == operation || operation.equals(ApplicationConstants.EMPTY)) {
                    operation = ApplicationConstants.ZERO;
                }
                UserService uService = new UserServiceImpl();
                
                switch (Integer.parseInt(operation)) {

                    case 1: //Delete
                        int userId = Integer.parseInt(request.getParameter("userId"));
                        User user = new User(userId);
                        uService.setUserInactive(user);
                        break;
                }
                
                //Get all the users
                List<User> users = uService.getAllUsers();
                if(users != null && !users.isEmpty()){
                    request.setAttribute("users", users);
                }
                nextPage = "/WEB-INF/jsp/manageUser.jsp";
            }
       } catch (ApplicationException ae) {
            LOG.log(Level.SEVERE, "An error occurred: ", ae);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.MANAGE_EXAM_STATUS, status);
        } catch (NumberFormatException nfe) {
            LOG.log(Level.SEVERE, "An error occurred: ", nfe);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.MANAGE_EXAM_STATUS, status);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "An error occurred: ", e);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.MANAGE_EXAM_STATUS, status);
        }
        setResponseHeader(response);
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response); 
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
