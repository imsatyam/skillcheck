/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.model;

import com.skill.app.utility.ApplicationUtility;
import java.util.Date;

/**
 * Examination class holds the examination details
 *
 * @author Shubham Shandilya
 */
public class Examination {

    private int examinationId = 0;
    private String examinationName;
    private int maximumMarks;
    private int numberOfQuestions;
    private int marksPerQuestion;
    private int passingMarks;
    private int negativeMarks;
    private int timeInMinutes;
    private Date createdDate;
    private User createdBy;

    private String createdDateString;

    /**
     * Default Constructor
     */
    public Examination() {
    }

    /**
     * Minimal Constructor
     *
     * @param examinationId
     */
    public Examination(int examinationId) {
        this.examinationId = examinationId;
    }

    /**
     * constructor
     *
     * @param examinationId
     * @param examinationName
     */
    public Examination(int examinationId, String examinationName) {
        this.examinationId = examinationId;
        this.examinationName = examinationName;
    }

    /**
     * Full Constructor
     *
     * @param examinationId
     * @param examinationName
     * @param maximumMarks
     * @param numberOfQuestions
     * @param marksPerQuestion
     * @param passingMarks
     * @param negativeMarks
     * @param timeInMinutes
     * @param createdDate
     * @param createdBy
     */
    public Examination(int examinationId, String examinationName, int maximumMarks, int numberOfQuestions, int marksPerQuestion, int passingMarks, int negativeMarks, int timeInMinutes, Date createdDate, User createdBy) {
        this.examinationId = examinationId;
        this.examinationName = examinationName;
        this.maximumMarks = maximumMarks;
        this.numberOfQuestions = numberOfQuestions;
        this.marksPerQuestion = marksPerQuestion;
        this.passingMarks = passingMarks;
        this.negativeMarks = negativeMarks;
        this.timeInMinutes = timeInMinutes;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        
        if(this.createdDate != null){
            this.createdDateString = ApplicationUtility.dateToString(createdDate);
        }        
    }

    /**
     * This method returns the examination id
     *
     * @return examinationId
     */
    public int getExaminationId() {
        return examinationId;
    }

    /**
     * This method sets the value of examination id
     *
     * @param examinationId
     */
    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    /**
     * This method returns the examination name
     *
     * @return exxaminationName
     */
    public String getExaminationName() {
        return examinationName;
    }

    /**
     * This method sets the value of the examination name
     *
     * @param examinationName
     */
    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    /**
     * This method returns the maximum marks of the examination
     *
     * @return maximumMarks
     */
    public int getMaximumMarks() {
        return maximumMarks;
    }

    /**
     * This method sets the maximum marks of the examination
     *
     * @param maximumMarks
     */
    public void setMaximumMarks(int maximumMarks) {
        this.maximumMarks = maximumMarks;
    }

    /**
     * This method returns the maximum number of questions in the examination
     *
     * @return numberOfQuestions
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * This method sets the maximum number of questions
     *
     * @param numberOfQuestions
     */
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    /**
     * This method returns the marks for each question
     *
     * @return marksPerQuestion
     */
    public int getMarksPerQuestion() {
        return marksPerQuestion;
    }

    /**
     * This method sets the marks per question
     *
     * @param marksPerQuestion
     */
    public void setMarksPerQuestion(int marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    /**
     * This method returns the passing marks for the examination
     *
     * @return passingMarks
     */
    public int getPassingMarks() {
        return passingMarks;
    }

    /**
     * This method sets the passing marks for the examination
     *
     * @param passingMarks
     */
    public void setPassingMarks(int passingMarks) {
        this.passingMarks = passingMarks;
    }

    /**
     * This method returns the negative marks or each incorrect answer
     *
     * @return negativeMarks
     */
    public int getNegativeMarks() {
        return negativeMarks;
    }

    /**
     * This method sets the negative marks for each incorrect answer
     *
     * @param negativeMarks
     */
    public void setNegativeMarks(int negativeMarks) {
        this.negativeMarks = negativeMarks;
    }

    /**
     * This method returns the duration of examination in minutes
     *
     * @return timeInMinutes
     */
    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    /**
     * This method sets the duration of the examination
     *
     * @param timeInMinutes
     */
    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    /**
     * This method returns the date on which examination was created
     *
     * @return createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method sets the date when exam was created
     *
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        if(this.createdDate != null){
            this.createdDateString = ApplicationUtility.dateToString(createdDate);
        }
    }

    /**
     * This method returns the user who created this examination
     *
     * @return
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * This method returns created date in string format
     *
     * @return
     */
    public String getCreatedDateString() {
        return createdDateString;
    }

    /**
     * This method sets date string
     *
     * @param createdDateString
     */
    public void setCreatedDateString(String createdDateString) {
        this.createdDateString = createdDateString;
    }

    /**
     * This method sets the user details of the person who is creating the exam
     *
     * @param createdBy
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Examination{" + "examinationId=" + examinationId + ", examinationName=" + examinationName + ", maximumMarks=" + maximumMarks + ", numberOfQuestions=" + numberOfQuestions + ", marksPerQuestion=" + marksPerQuestion + ", passingMarks=" + passingMarks + ", negativeMarks=" + negativeMarks + ", timeInMinutes=" + timeInMinutes + ", createdDate=" + createdDate + ", createdBy=" + createdBy + '}';
    }

}
