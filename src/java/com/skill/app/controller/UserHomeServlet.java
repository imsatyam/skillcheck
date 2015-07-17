/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.controller;

import com.skill.app.constant.ApplicationConstants;
import com.skill.app.dao.RoleDAO;
import com.skill.app.model.Result;
import com.skill.app.model.User;
import com.skill.app.service.ResultService;
import com.skill.app.service.ResultServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet launches the home page of the user
 *
 * @author Shubham Shandilya
 */
public class UserHomeServlet extends BaseServlet {

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
        
        //First thing to check is - whether user is logged in or not. If not, make him login
        HttpSession session = request.getSession();
        if(session.getAttribute(ApplicationConstants.LOGGED_IN_USER) != null){
            //If user has logged in then, default page is userHome
            nextPage = "/WEB-INF/jsp/userHome.jsp";
            
            User user = (User)session.getAttribute(ApplicationConstants.LOGGED_IN_USER);
            
            //If user is an examinee, then show him his older results as well
            if(user.getRole().getRoleId() == RoleDAO.ROLE_EXAMINEE){
                ResultService rs = new ResultServiceImpl();
                List<Result> results = rs.getResult(user);
                if(results != null && !results.isEmpty()){
                    request.setAttribute("results", results);
                }
            }
            
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
