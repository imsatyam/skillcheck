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
public class InsertRecordsTest {

    public static void main(String[] args){
        
        //Insert Role
        System.out.println("*** 1. Inserting Role ***");
        Role role = new Role();
        role.setRole("Examiner1");
        RoleService roleService = new RoleServiceImpl();
        roleService.saveOrUpdateRole(role);
        System.out.println("*** 1. Done ***");
        
        //Insert User
        System.out.println("*** 2. Inserting User ***");
        role.setRoleId(1);
        User user = new User("shubham","Shubham", "Shandilya", "Hyderabad", "8374875137", "satyam.tu1@gmail.com", "satyam", true, role);
        UserService userService = new UserServiceImpl();
        userService.saveOrUpdateUser(user);
        System.out.println("*** 2. Done ***");
        
        //Insert examination
        System.out.println("*** 3. Inserting Examination ***");
        user.setUserId(1);
        Examination examination = new Examination(0, "Test Exam 2", 100, 25, 4, 50, 0, 60, new Date(), user);
        ExaminationService eService = new ExaminationServiceImpl();
        eService.saveOrUpdateExamination(examination);
        System.out.println("*** 3. Done ***");
        
        //Insert Question
        System.out.println("*** 4. Inserting Question ***");
        examination.setExaminationId(1);
        Question question = new Question(0, "Question 2", "A", "B", "C", "D", "A", examination);
        QuestionService qService = new QuestionServiceImpl();
        qService.saveOrUpdateQuestion(question);
        System.out.println("*** 4. Done ***");
        
        //Insert Result
        System.out.println("*** 5. Inserting Result ***");
        Result result = new Result(0, 20, 5, 80, 1, new Date(), user, examination);
        ResultService rService = new ResultServiceImpl();
        rService.saveOrUpdateResult(result);
        System.out.println("*** 5. Done ***");
    }
}
