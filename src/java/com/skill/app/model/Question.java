/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.model;

import com.skill.app.constant.ApplicationConstants;

/**
 * This class holds the information of the question
 *
 * @author Shubham Shandilya
 */
public class Question {

    private int questionId = 0;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
    private Examination examination;

    /**
     * Default constructor
     */
    public Question() {
    }

    /**
     * Minimal Constructor
     *
     * @param questionId
     */
    public Question(int questionId) {
        this.questionId = questionId;
    }

    /**
     * Full constructor
     *
     * @param questionId
     * @param question
     * @param optionA
     * @param optionB
     * @param optionC
     * @param optionD
     * @param correctAnswer
     * @param examination
     */
    public Question(int questionId, String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer, Examination examination) {
        this.questionId = questionId;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.examination = examination;
    }

    /**
     * This method returns the question id
     *
     * @return questionId
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * This method sets the question id
     *
     * @param questionId
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * This method returns the question text
     *
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method sets the question text
     *
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * This method returns the first answer option
     *
     * @return optionA
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * This method sets the first answer option
     *
     * @param optionA
     */
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    /**
     * This method returns the second answer option
     *
     * @return optionB
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * This method sets the second answer option
     *
     * @param optionB
     */
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    /**
     * This method returns the third answer option
     *
     * @return optionC
     */
    public String getOptionC() {
        return optionC;
    }

    /**
     * This method sets the third answer option
     *
     * @param optionC
     */
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    /**
     * This method returns the fourth answer option
     *
     * @return optionD
     */
    public String getOptionD() {
        return optionD;
    }

    /**
     * This method sets the fourth answer option
     *
     * @param optionD
     */
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    /**
     * This method returns the correct answer of the question
     *
     * @return correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * This method sets the correct answer of the question
     *
     * @param correctAnswer
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * This method returns the exam with which this question is associated
     *
     * @return
     */
    public Examination getExamination() {
        return examination;
    }

    /**
     * This method sets the exam with which this question is associated
     *
     * @param examination
     */
    public void setExamination(Examination examination) {
        this.examination = examination;
    }
    
    public String getOption(String option){
        String optionValue = ApplicationConstants.EMPTY;
        if(option.equalsIgnoreCase("A")){
            optionValue = this.optionA;
        }
        else if(option.equalsIgnoreCase("B")){
            optionValue = this.optionB;
        }
        else if(option.equalsIgnoreCase("C")){
            optionValue = this.optionC;
        }
        else if(option.equalsIgnoreCase("D")){
            optionValue = this.optionD;
        }
        return optionValue;
    }

    
    @Override
    public String toString() {
        return "Question{" + "questionId=" + questionId + ", question=" + question + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", correctAnswer=" + correctAnswer + ", examination=" + examination + '}';
    }

}
