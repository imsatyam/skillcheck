/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.controller;

import com.skill.app.constant.ApplicationConstants;
import com.skill.app.exception.ApplicationException;
import com.skill.app.exception.InvalidInputException;
import com.skill.app.exception.InvalidLoginException;
import com.skill.app.model.User;
import com.skill.app.service.UserService;
import com.skill.app.service.UserServiceImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet handles login requests
 *
 * @author Shubham Shandilya
 */
public class LoginServlet extends HttpServlet {

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

        boolean isLoginSuccesfull = false;
        String errorMessage = ApplicationConstants.EMPTY;
        String nextPage = "home.htm";

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            //First validate the input for null 
            validateInputs(userName, password);

            //If validation is successful, then validate the user
            UserService userService = new UserServiceImpl();
            User loggedInUser = userService.validateUser(userName, password);

            //If user is validated, successful login. Put the user in session
            HttpSession session = request.getSession();
            session.setAttribute(ApplicationConstants.LOGGED_IN_USER, loggedInUser);

            isLoginSuccesfull = true;

        } catch (InvalidInputException iie) {
            errorMessage = iie.getMessage();
        } catch (InvalidLoginException ile) {
            errorMessage = ile.getMessage();
        } catch (ApplicationException ae) {
            errorMessage = ae.getMessage();
        }

        if (!isLoginSuccesfull) {
            request.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher(nextPage);
            rd.forward(request, response);
        } else {
            nextPage = "userHome.htm";
            response.sendRedirect("loadPage.htm?page=" + nextPage); 
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

    private void validateInputs(String username, String password) throws InvalidInputException {

        if (username == null || username.trim().equals(ApplicationConstants.EMPTY)) {
            throw new InvalidInputException("Invalid login. Username is null.");
        }
        if (password == null || password.trim().equals(ApplicationConstants.EMPTY)) {
            throw new InvalidInputException("Invalid login. Password is null.");
        }
    }
}
