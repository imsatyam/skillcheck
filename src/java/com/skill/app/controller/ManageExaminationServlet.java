/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.controller;

import com.skill.app.constant.ApplicationConstants;
import com.skill.app.dao.RoleDAO;
import com.skill.app.exception.ApplicationException;
import com.skill.app.model.Examination;
import com.skill.app.model.Question;
import com.skill.app.model.User;
import com.skill.app.service.ExaminationService;
import com.skill.app.service.ExaminationServiceImpl;
import com.skill.app.service.QuestionService;
import com.skill.app.service.QuestionServiceImpl;
import com.skill.app.vo.OperationStatus;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet controls the management of an examination
 *
 * @author Shubham Shandilya
 */
public class ManageExaminationServlet extends BaseServlet {

    private static final Logger LOG = Logger.getLogger(ManageExaminationServlet.class.getName());

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

                //If user has logged in then, default page is examination page
                nextPage = "/WEB-INF/jsp/manageExamination.jsp";
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
                        List<Examination> examinations = null;
                        if(user.getRole().getRoleId() == RoleDAO.ROLE_ADMIN){
                            examinations = service.getAllExaminations();
                        }else{
                            examinations = service.getExamination(user);
                        }
                        request.setAttribute("exams", examinations);
                        break;

                    case 1: //Create examination Page launch
                        request.setAttribute("whichAction", 1);
                        nextPage = "/WEB-INF/jsp/addEditExamination.jsp";
                        break;

                    case 2: //Edit Examination Page launch
                        nextPage = "/WEB-INF/jsp/addEditExamination.jsp";
                        request.setAttribute("whichAction", 2);
                        exam = getExaminationByExamId(request, service);
                        request.setAttribute("exam", exam);
                        break;

                    case 3: //Next page launch from addEditExamination page - it opens question page
                        nextPage = "/WEB-INF/jsp/addEditQuestion.jsp";
                        request.setAttribute("whichAction", 3);
                        exam = readAndSaveExaminationObject(request, service, user);
                        request.setAttribute("examId", exam.getExaminationId());
                        //retrieve the questionList for this exam
                        getQuestions(qService, exam, request);
                        break;

                    case 4: //This is when a question is to be saved and then reloaded
                        nextPage = "/WEB-INF/jsp/addEditQuestion.jsp";
                        request.setAttribute("whichAction", 4);
                        exam = getExaminationByExamId(request, service);

                        //save the question
                        readAndSaveQuestionObject(request, qService, user, exam);

                        request.setAttribute("examId", exam.getExaminationId());
                        getQuestions(qService, exam, request);
                        break;

                    case 5: //This is when a question is to be deleted
                        nextPage = "/WEB-INF/jsp/addEditQuestion.jsp";
                        request.setAttribute("whichAction", 5);
                        String questionId = request.getParameter("questionId");
                        if(questionId != null && !questionId.equals(ApplicationConstants.EMPTY) && !questionId.equals(ApplicationConstants.ZERO)){
                            String [] questions = questionId.split(ApplicationConstants.MANAGE_EXAM_DELIMITER);
                            int[] qIds = new int[questions.length];
                            for(int index = 0; index < questions.length; index++){
                                qIds[index] = Integer.parseInt(questions[index]);
                            }
                            qService.deleteQuestion(qIds);
                        }
                        exam = getExaminationByExamId(request, service);
                        request.setAttribute("examId", exam.getExaminationId());
                        getQuestions(qService, exam, request);
                        status = new OperationStatus(0, ApplicationConstants.MANAGE_EXAM_DEL_Q_SUCC);
                        request.setAttribute(ApplicationConstants.MANAGE_EXAM_STATUS, status);
                        break;

                    case 6: //Cancel Action is performed on the examination while it was getting created
                        nextPage = "/WEB-INF/jsp/manageExamination.jsp";
                        String examinationId = request.getParameter("examinationId");
                        if(examinationId != null && !examinationId.equals(ApplicationConstants.EMPTY) && !examinationId.equals(ApplicationConstants.ZERO)){
                            String [] exams = examinationId.split(ApplicationConstants.MANAGE_EXAM_DELIMITER);
                            int[] examIds = new int[exams.length];
                            for(int index = 0; index < exams.length; index++){
                                examIds[index] = Integer.parseInt(exams[index]);
                            }
                            service.deleteExamination(examIds);
                        }
                        
                        List<Examination> allExaminations = service.getExamination(user);
                        request.setAttribute("exams", allExaminations);
                        status = new OperationStatus(0, ApplicationConstants.MANAGE_EXAM_DEL_E_SUCC);
                        request.setAttribute(ApplicationConstants.MANAGE_EXAM_STATUS, status);
                        break;
                        
                    case 7: //Done button is clicked
                        nextPage = "/WEB-INF/jsp/manageExamination.jsp";
                        List<Examination> exams = service.getExamination(user);
                        request.setAttribute("exams", exams);
                        status = new OperationStatus(0, ApplicationConstants.MANAGE_EXAM_CR_E_SUCC);
                        request.setAttribute(ApplicationConstants.MANAGE_EXAM_STATUS, status);
                        break;
                    case 8:
                        break;
                        
                    case 9:
                        nextPage = "/WEB-INF/jsp/addEditQuestion.jsp";
                        request.setAttribute("whichAction", 9);
                        String qId = request.getParameter("questionId");
                        exam = getExaminationByExamId(request, service);
                        Question ques = qService.getQuestion(Integer.parseInt(qId));
                        request.setAttribute("examId", exam.getExaminationId());
                        request.setAttribute("ques", ques);
                        getQuestions(qService, exam, request);
                        request.setAttribute("displayForm", "block");
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

    private void getQuestions(QuestionService qService, Examination exam, HttpServletRequest request) throws ApplicationException {
        String editScenario = request.getParameter("editScenario");
        if(editScenario != null && !editScenario.equals(ApplicationConstants.EMPTY) && !editScenario.equals(ApplicationConstants.ZERO)){
            request.setAttribute("editScenario", 1);
        }else{
            request.setAttribute("editScenario", 0);
        }
        boolean isHideAddSection = false;
        List<Question> questions = qService.getAllQuestions(exam);
        if (questions != null && !questions.isEmpty()) {
            request.setAttribute("questions", questions);
            if (questions.size() == exam.getNumberOfQuestions()) {
                isHideAddSection = true;
                if(editScenario != null && !editScenario.equals(ApplicationConstants.EMPTY) && !editScenario.equals(ApplicationConstants.ZERO)){
                    request.setAttribute("doneCancelMsg", "Please click on done to save the details.");
                }else{
                    request.setAttribute("doneCancelMsg", "Please click on done or cancel to save or reset details.");
                }                
            }
        }

        if (isHideAddSection) {
            request.setAttribute("displayForm", "none");
        } else {
            request.setAttribute("displayForm", "block");
        }
    }

    private Examination readAndSaveExaminationObject(HttpServletRequest request, ExaminationService eService, User user) {
        Examination examination;
        //Read Inputs
        String examinationId = request.getParameter("examinationId");
        if (null == examinationId || examinationId.equals(ApplicationConstants.EMPTY)) {
            examinationId = ApplicationConstants.ZERO;
        }

        String examinationName = request.getParameter("examinationName");
        int numberOfQuestions = Integer.parseInt(request.getParameter("numberOfQuestions"));
        int maximumMarks = Integer.parseInt(request.getParameter("maximumMarks"));
        int passingMarks = Integer.parseInt(request.getParameter("passingMarks"));
        int negativeMarks = Integer.parseInt(request.getParameter("negativeMarks"));
        int timeInMinutes = Integer.parseInt(request.getParameter("timeInMinutes"));

        int marksPerQuestion = maximumMarks / numberOfQuestions;
        boolean isInsert = false;

        if (Integer.parseInt(examinationId) != 0) {
            examination = new Examination(Integer.parseInt(examinationId), examinationName, maximumMarks, numberOfQuestions, marksPerQuestion, passingMarks, negativeMarks, timeInMinutes, new Date(), user);
        } else {
            examination = new Examination(0, examinationName, maximumMarks, numberOfQuestions, marksPerQuestion, passingMarks, negativeMarks, timeInMinutes, new Date(), user);
            isInsert = true;
        }

        eService.saveOrUpdateExamination(examination);

        if (isInsert) {
            examination = eService.getExamination(examinationName);
        }

        return examination;
    }

    private void readAndSaveQuestionObject(HttpServletRequest request, QuestionService qService, User user, Examination examination) {
        Question questionObj;
        //Read Inputs
        String questionId = request.getParameter("questionId");
        if (null == questionId || questionId.equals(ApplicationConstants.EMPTY)) {
            questionId = ApplicationConstants.ZERO;
        }

        String question = request.getParameter("question");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String correctAnswer = request.getParameter("correctAnswer");

        boolean isInsert = false;

        if (Integer.parseInt(questionId) != 0) {
            questionObj = new Question(Integer.parseInt(questionId), question, optionA, optionB, optionC, optionD, correctAnswer, examination);
        } else {
            questionObj = new Question(0, question, optionA, optionB, optionC, optionD, correctAnswer, examination);
            isInsert = true;
        }

        qService.saveOrUpdateQuestion(questionObj);

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
