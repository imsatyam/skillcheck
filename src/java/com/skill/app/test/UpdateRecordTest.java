/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skill.app.test;

import com.skill.app.model.Examination;
import com.skill.app.model.Question;
import com.skill.app.model.Result;
import com.skill.app.model.Role;
import com.skill.app.model.User;
import com.skill.app.service.ExaminationService;
import com.skill.app.service.ExaminationServiceImpl;
import com.skill.app.service.QuestionService;
import com.skill.app.service.QuestionServiceImpl;
import com.skill.app.service.ResultService;
import com.skill.app.service.ResultServiceImpl;
import com.skill.app.service.RoleService;
import com.skill.app.service.RoleServiceImpl;
import com.skill.app.service.UserService;
import com.skill.app.service.UserServiceImpl;
import java.util.Date;

/**
 *
 * @author Shubham Shandilya
 */
public class UpdateRecordTest {

    public static void main(String[] args){
        
        //Insert Role
        System.out.println("*** 1. Updating Role ***");
        Role role = new Role(1, "Administrator");
        RoleService roleService = new RoleServiceImpl();
        roleService.saveOrUpdateRole(role);
        System.out.println("*** 1. Done ***");
        
        //Insert User
        System.out.println("*** 2. Updating User ***");
        User user = new User(1, "satyam","Satyam1", "Shandilya1", "Hyderabad1", "83748751371", "satyam.tu1@gmail.com1", "satyam1", true, role);
        UserService userService = new UserServiceImpl();
        userService.saveOrUpdateUser(user);
        System.out.println("*** 2. Done ***");
        
        //Insert examination
        System.out.println("*** 3. Updating Examination ***");
        Examination examination = new Examination(1, "Test Exam1", 200, 50, 2, 50, 1, 60, new Date(), user);
        ExaminationService eService = new ExaminationServiceImpl();
        eService.saveOrUpdateExamination(examination);
        System.out.println("*** 3. Done ***");
        
        //Insert Question
        System.out.println("*** 4. Updating Question ***");
        Question question = new Question(1, "Question 11", "A1", "B1", "C1", "D1", "B", examination);
        QuestionService qService = new QuestionServiceImpl();
        qService.saveOrUpdateQuestion(question);
        System.out.println("*** 4. Done ***");
        
        //Insert Result
        System.out.println("*** 5. Updating Result ***");
        Result result = new Result(1, 30, 20, 40, 0, new Date(), user, examination);
        ResultService rService = new ResultServiceImpl();
        rService.saveOrUpdateResult(result);
        System.out.println("*** 5. Done ***");
    }
}
