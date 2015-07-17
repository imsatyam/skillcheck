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
import com.skill.app.utility.RandomPasswordGenerator;
import com.skill.app.vo.OperationStatus;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shubham Shandilya
 */
public class ForgotPasswordServlet extends BaseServlet {
    private static final Logger LOG = Logger.getLogger(ForgotPasswordServlet.class.getName());
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nextPage = "/WEB-INF/jsp/forgotPassword.jsp";
        
        try{
            String operation = request.getParameter(ApplicationConstants.OPERATION);
            if(operation != null && !operation.equals(ApplicationConstants.EMPTY)){
                nextPage = doOperation(request, operation);
            }
        }catch (ApplicationException e) {
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
    
    private String doOperation(HttpServletRequest request, String operation) throws ApplicationException, NumberFormatException{
        String nextPage = "/WEB-INF/jsp/forgotPassword.jsp";
       
        switch (Integer.parseInt(operation)) {
            case ApplicationConstants.UPDATE_OPERATION:
                
                String username = request.getParameter("username");
                if(username != null && !username.equals(ApplicationConstants.EMPTY)){
                    
                    //Get user object from the database
                    UserService userService = new UserServiceImpl();
                    User user = userService.getUser(username);
                    if(user != null){
                        
                        //Generate a random password
                        String password = RandomPasswordGenerator.generatePassword(6, 8, 3, 2, 1);
                        
                        //update user object in database
                        user.setPassword(password);
                        
                        //Save the details
                        userService.saveOrUpdateUser(user);
                        
                        OperationStatus status = new OperationStatus(ApplicationConstants.FGT_PWD_SUCCESS_MSG);
                        request.setAttribute(ApplicationConstants.FGT_PWD_STATUS, status);
                    }else{
                        OperationStatus status = new OperationStatus(1, ApplicationConstants.NO_SUCH_USER);
                        request.setAttribute(ApplicationConstants.FGT_PWD_STATUS, status);
                    }
                    
                }
                
                break;
                
            case ApplicationConstants.CANCEL_OPERATION:
                nextPage = "home.htm";
                break;                
        }
        
        return nextPage;
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
