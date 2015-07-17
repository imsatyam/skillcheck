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
import java.util.List;

/**
 *
 * @author Shubham Shandilya
 */
public class FetchRecordsTest {

    public static void main(String[] args){
        
        //Fetch Role
        System.out.println("*** 1. Role ***");
        RoleService roleService = new RoleServiceImpl();
        
        System.out.println("*** 1.1 Role by id ***");
        Role role  = roleService.getRole(1);
        System.out.println(role.toString());
        System.out.println("*** 1.2 Role All ***");
        List<Role> roles = roleService.getAllRoles();
        for(Role r : roles){
            System.out.println(r.toString());
        }
        System.out.println("*** 1. Done ***\n");
        
        //Fetch User
        System.out.println("*** 2. Updating User ***");
        UserService userService = new UserServiceImpl();
        System.out.println("*** 2.1 Validate User ***");
        User user  = userService.validateUser("satyam1", "satyam1");
        System.out.println(user.toString());
        System.out.println("*** 2.2 Fetch by id ***");
        user  = userService.getUser(1);
        System.out.println(user.toString());
        System.out.println("*** 2.3 Fetch by name ***");
        user  = userService.getUser("shubham");
        System.out.println(user.toString());
        System.out.println("*** 2.4 Fetch by role ***");
        List<User> users  = userService.getUsersBasedOnRole(new Role(1));
        for(User r : users){
            System.out.println(r.toString());
        }
        System.out.println("*** 2.5 Fetch All ***");
        users  = userService.getAllUsers();
        for(User r : users){
            System.out.println(r.toString());
        }
        System.out.println("*** 2. Done ***");
        
        //Fetch examination
        System.out.println("*** 3. Fetch Examination ***");
        ExaminationService eService = new ExaminationServiceImpl();
        System.out.println("*** 3.1 Fetch by id ***");
        Examination exam  = eService.getExamination(1);
        System.out.println(exam.toString());
        System.out.println("*** 3.2 Fetch by name ***");
        exam  = eService.getExamination("Test Exam1");
        System.out.println(exam.toString());
        System.out.println("*** 3.3 Fetch by user ***");
        List<Examination> exams  = eService.getExamination(new User(1, "satyam"));
        for(Examination r : exams){
            System.out.println(r.toString());
        }
        System.out.println("*** 3.4 Fetch All ***");
        exams  = eService.getAllExaminations();
        for(Examination r : exams){
            System.out.println(r.toString());
        }
        System.out.println("*** 3. Done ***");
        
        //Fetch Question
        System.out.println("*** 4. Fetch Question ***");
        QuestionService qService = new QuestionServiceImpl();
        System.out.println("*** 4.1 Fetch by id ***");
        Question question  = qService.getQuestion(1);
        System.out.println(question.toString());
        System.out.println("*** 4.3 Fetch by Exam ***");
        List<Question> qstns  = qService.getAllQuestions(new Examination(1));
        for(Question r : qstns){
            System.out.println(r.toString());
        }
        System.out.println("*** 4.4 Fetch All ***");
        qstns  = qService.getAllQuestions();
        for(Question r : qstns){
            System.out.println(r.toString());
        }
        System.out.println("*** 4. Done ***");
        
        //Fetch Result
        System.out.println("*** 5. Fetch Result ***");
        ResultService rService = new ResultServiceImpl();
        System.out.println("*** 5.1 Fetch by Exam and order ***");
        Result result  = rService.getResult(1);
        System.out.println(result.toString());
        System.out.println("*** 5.2 Fetch by Exam ***");
        List<Result> results  = rService.getResult(new Examination(1));
        for(Result r : results){
            System.out.println(r.toString());
        }
        System.out.println("*** 5.3 Fetch by Exam User ***");
        results  = rService.getResult(new Examination(2), new User(2, "shubham"));
        for(Result r : results){
            System.out.println(r.toString());
        }
        System.out.println("*** 5.4 Fetch by User ***");
        results  = rService.getResult(new User(1, "satyam"));
        for(Result r : results){
            System.out.println(r.toString());
        }
        System.out.println("*** 5. Done ***");
    }
}
