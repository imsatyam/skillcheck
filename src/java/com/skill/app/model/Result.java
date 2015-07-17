/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.model;

import com.skill.app.utility.ApplicationUtility;
import java.util.Date;

/**
 * This class holds the result of a user for an examination
 *
 * @author Shubham Shandilya
 */
public class Result {

    private int resultId = 0;
    private int numberCorrect;
    private int numberIncorrect;
    private int marksObtained;
    private int isPass;
    private Date examinationDate;
    private User user;
    private Examination examination;
    
    private String examinationTakenDate;

    /**
     * Default Constructor
     */
    public Result() {
    }

    /**
     * Minimal Constructor
     *
     * @param resultId
     */
    public Result(int resultId) {
        this.resultId = resultId;
    }

    /**
     * Full Constructor
     *
     * @param resultId
     * @param numberCorrect
     * @param numberIncorrect
     * @param marksObtained
     * @param isPass
     * @param examinationDate
     * @param user
     * @param examination
     */
    public Result(int resultId, int numberCorrect, int numberIncorrect, int marksObtained, int isPass, Date examinationDate, User user, Examination examination) {
        this.resultId = resultId;
        this.numberCorrect = numberCorrect;
        this.numberIncorrect = numberIncorrect;
        this.marksObtained = marksObtained;
        this.isPass = isPass;
        this.examinationDate = examinationDate;
        this.user = user;
        this.examination = examination;
        if(this.examinationDate != null){
            this.examinationTakenDate = ApplicationUtility.dateToString(examinationDate);
        } 
    }

    /**
     * This method returns the result id
     *
     * @return resultId
     */
    public int getResultId() {
        return resultId;
    }

    /**
     * This method sets the result id
     *
     * @param resultId
     */
    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    /**
     * This method returns the number of correct answers
     *
     * @return numberCorrect
     */
    public int getNumberCorrect() {
        return numberCorrect;
    }

    /**
     * This method sets the number of correct answers
     *
     * @param numberCorrect
     */
    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    /**
     * This method returns the number of incorrect answers
     *
     * @return numberIncorrect
     */
    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    /**
     * This method sets the number of incorrect answers
     *
     * @param numberIncorrect
     */
    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    /**
     * This method returns the marks obtained by the candidate
     *
     * @return
     */
    public int getMarksObtained() {
        return marksObtained;
    }

    /**
     * This method sets the marks obtained by the candidate
     *
     * @param marksObtained
     */
    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    /**
     * This method returns if the user is pass or fail
     *
     * @return true if user is pass and false otherwise
     */
    public int getIsPass() {
        return isPass;
    }

    /**
     * This method sets if the user is pass or fail
     *
     * @param isPass
     */
    public void setIsPass(int isPass) {
        this.isPass = isPass;
    }

    /**
     * This method returns the date when user appeared for exam
     *
     * @return examinationDate
     */
    public Date getExaminationDate() {
        return examinationDate;
    }

    /**
     * This method sets the examination date
     *
     * @param examinationDate
     */
    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
        if(this.examinationDate != null){
            this.examinationTakenDate = ApplicationUtility.dateToString(examinationDate);
        }
    }

    /**
     * This method returns the user who appeared for the exam
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * This method sets the user details of the appearing candidate
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method returns the examination for which this result is generated
     *
     * @return examination
     */
    public Examination getExamination() {
        return examination;
    }

    /**
     * This method sets the examination
     *
     * @param examination
     */
    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public String getExaminationTakenDate() {
        return examinationTakenDate;
    }

    public void setExaminationTakenDate(String examinationTakenDate) {
        this.examinationTakenDate = examinationTakenDate;
    }
    
    

    @Override
    public String toString() {
        return "Result{" + "resultId=" + resultId + ", numberCorrect=" + numberCorrect + ", numberIncorrect=" + numberIncorrect + ", marksObtained=" + marksObtained + ", isPass=" + isPass + ", examinationDate=" + examinationDate + ", user=" + user + ", examination=" + examination + '}';
    }

}
