/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skill.app.vo;

/**
 *
 * @author Shubham Shandilya
 */
public class IncorrectAnswer {
    
    private int questionId;
    private int uiQuestionId;
    private String question;
    private String incorrectOption;
    private String incorrectAnswer;
    private String correctOption;
    private String correctAnswer;

    public IncorrectAnswer() {
    }

    public IncorrectAnswer(int questionId, int uiQuestionId, String question, String incorrectOption, String incorrectAnswer, String correctOption, String correctAnswer) {
        this.questionId = questionId;
        this.uiQuestionId = uiQuestionId;
        this.question = question;
        this.incorrectOption = incorrectOption;
        this.incorrectAnswer = incorrectAnswer;
        this.correctOption = correctOption;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getUiQuestionId() {
        return uiQuestionId;
    }

    public void setUiQuestionId(int uiQuestionId) {
        this.uiQuestionId = uiQuestionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getIncorrectOption() {
        return incorrectOption;
    }

    public void setIncorrectOption(String incorrectOption) {
        this.incorrectOption = incorrectOption;
    }

    public String getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public void setIncorrectAnswer(String incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    
    
    
}
