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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet launches the home page of the application
 *
 * @author Shubham Shandilya
 */
public class ProfileServlet extends BaseServlet {
    private static final Logger LOG = Logger.getLogger(ProfileServlet.class.getName());

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
        
        try{
            //First thing to check is - whether user is logged in or not. If not, make him login
            HttpSession session = request.getSession();
            if(session.getAttribute(ApplicationConstants.LOGGED_IN_USER) != null){
                //If user has logged in then, default page is userHome
                nextPage = "/WEB-INF/jsp/profile.jsp";
                doOperations(request, session);

            }
        }catch(ApplicationException ae){
            LOG.log(Level.SEVERE, "An error occurred: ", ae);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.PROFILE_UPDATE_STATUS, status);
        }catch(NumberFormatException nfe){
            LOG.log(Level.SEVERE, "An error occurred: ", nfe);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.PROFILE_UPDATE_STATUS, status);
        }catch(Exception e){
            LOG.log(Level.SEVERE, "An error occurred: ", e);
            OperationStatus status = new OperationStatus(1, ApplicationConstants.OP_FAILURE_MSG);
            request.setAttribute(ApplicationConstants.PROFILE_UPDATE_STATUS, status);
        }
        setResponseHeader(response);
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);

    }

    /*
    * This method performs operations on profile page.    
    */
    private void doOperations(HttpServletRequest request, HttpSession session) throws ApplicationException, NumberFormatException {
        //Need to see if this is any operation to be done and not just page load
        String operation = request.getParameter(ApplicationConstants.OPERATION);
        if(operation != null && !operation.equals(ApplicationConstants.EMPTY)){
            switch(Integer.parseInt(operation)){
                
                case ApplicationConstants.UPDATE_OPERATION:
                    
                    //Read inputs
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String contact = request.getParameter("mobile");
                    String email = request.getParameter("email");
                    
                    //User object is already present in the session. Let us update the info in it and save in database
                    User user = (User)session.getAttribute(ApplicationConstants.LOGGED_IN_USER);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setContact(contact);
                    user.setEmail(email);
                    
                    //Save the user details in database
                    UserService userService = new UserServiceImpl();
                    userService.saveOrUpdateUser(user);
                    
                    //As the user details have changed, update the same in the session
                    session.setAttribute(ApplicationConstants.LOGGED_IN_USER, user);
                    
                    //Set success message in request scope
                    OperationStatus status = new OperationStatus(ApplicationConstants.PROFILE_UPDATE_SUCCESS);
                    request.setAttribute(ApplicationConstants.PROFILE_UPDATE_STATUS, status);
                    
                    break;
            }
        }
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
