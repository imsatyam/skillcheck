/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.controller;

import com.skill.app.constant.ApplicationConstants;
import com.skill.app.exception.ApplicationException;
import com.skill.app.model.Examination;
import com.skill.app.model.Question;
import com.skill.app.model.Result;
import com.skill.app.model.User;
import com.skill.app.service.ExaminationService;
import com.skill.app.service.ExaminationServiceImpl;
import com.skill.app.service.QuestionService;
import com.skill.app.service.QuestionServiceImpl;
import com.skill.app.service.ResultService;
import com.skill.app.service.ResultServiceImpl;
import com.skill.app.vo.IncorrectAnswer;
import com.skill.app.vo.OperationStatus;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
public class ExaminationServlet extends BaseServlet {

    private static final Logger LOG = Logger.getLogger(ExaminationServlet.class.getName());

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

                //Get User
                User user = (User) session.getAttribute(ApplicationConstants.LOGGED_IN_USER);
                Examination exam = null;
                Question question = null;
                OperationStatus status = null;
                List<Examination> examinations = null;
                List<Question> questions = null;

                //If user has logged in then, default page is examination page
                nextPage = "/WEB-INF/jsp/examinations.jsp";
                String operation = request.getParameter("operation");
                if (null == operation || operation.equals(ApplicationConstants.EMPTY)) {
                    operation = ApplicationConstants.ZERO;
                }

                //Get service class objects
                ExaminationService service = new ExaminationServiceImpl();
                QuestionService qService = new QuestionServiceImpl();

                switch (Integer.parseInt(operation)) {

                    case 0:
                        //Load page with a list of all the Examinations created by this user
                        examinations = service.getAllExaminations();
                        request.setAttribute("examinationList", examinations);
                        break;

                    case 1: //Exam Detail
                        nextPage = "/WEB-INF/jsp/examinationDetail.jsp";
                        exam = getExaminationByExamId(request, service);
                        request.setAttribute("exam", exam);
                        break;

                    case 2: //launch questions page
                        nextPage = "/WEB-INF/jsp/examinationQuestions.jsp";
                        exam = getExaminationByExamId(request, service);
                        questions = qService.getAllQuestions(exam);
                        request.setAttribute("exam", exam);
                        request.setAttribute("examQuestions", questions);
                        break;

                    case 3: //Next page launch from addEditExamination page - it opens question page
                        examinations = service.getAllExaminations();
                        request.setAttribute("examinationList", examinations);
                        break;

                    case 4: //Submission made - display result
                        nextPage = "/WEB-INF/jsp/examinationResult.jsp";
                        request.setAttribute("whichAction", 4);
                        exam = getExaminationByExamId(request, service);
                        questions = qService.getAllQuestions(exam);

                        //get a map - questionId => Question Object
                        Map<Integer, Question> questionMap = null;
                        if (questions != null && !questions.isEmpty()) {
                            questionMap = new LinkedHashMap<Integer, Question>();
                            for (Question ques : questions) {
                                questionMap.put(ques.getQuestionId(), ques);
                            }
                        }

                        int incorrectCount = 0;
                        int correctCount = 0;
                        IncorrectAnswer incorrectAnswer = null;
                        List<IncorrectAnswer> incorrectAnswers = null;

                        //Get the user submitted details
                        Enumeration<String> paramNames = request.getParameterNames();
                        while (paramNames.hasMoreElements()) {
                            String paramName = paramNames.nextElement();
                            if (paramName.startsWith("scqa_")) {

                                String paramValue = request.getParameter(paramName);

                                String[] paramNameArr = paramName.split("_");
                                Integer questionId = new Integer(paramNameArr[1]);
                                int uiQuestionId = Integer.parseInt(paramNameArr[2]);

                                //Match answer correctness
                                Question qstn = questionMap.get(questionId);
                                if (qstn.getCorrectAnswer().equalsIgnoreCase(paramValue)) {
                                    correctCount++;
                                } else {
                                    incorrectCount++;
                                    incorrectAnswer = new IncorrectAnswer(questionId, uiQuestionId, qstn.getQuestion(),
                                            paramValue, qstn.getOption(paramValue), qstn.getCorrectAnswer(), qstn.getOption(qstn.getCorrectAnswer()));
                                    if (incorrectAnswers == null) {
                                        incorrectAnswers = new LinkedList<IncorrectAnswer>();
                                    }
                                    incorrectAnswers.add(incorrectAnswer);
                                }
                            }
                        }

                        int negativeMarksTotal = exam.getNegativeMarks() * incorrectCount;
                        int marksObtained = (exam.getMarksPerQuestion() * correctCount) - negativeMarksTotal;
                        int isPass = 1;
                        if (marksObtained < exam.getPassingMarks()) {
                            isPass = 0;
                        }

                        //Prepare Result object
                        Result result = new Result(0, correctCount, incorrectCount, marksObtained, isPass, new Date(), user, exam);

                        ResultService rService = new ResultServiceImpl();
                        rService.saveOrUpdateResult(result);
                        request.setAttribute("result", result);
                        if(incorrectAnswers != null && !incorrectAnswers.isEmpty()){
                            request.setAttribute("incorrectAnswers", incorrectAnswers);
                        }

                        break;

                }

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

    private Examination getExaminationByExamId(HttpServletRequest request, ExaminationService service) throws ApplicationException, NumberFormatException {
        Examination exam;
        String examinationId = request.getParameter("examinationId");
        exam = service.getExamination(Integer.parseInt(examinationId));
        return exam;
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
