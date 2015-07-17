<%-- 
    Document   : manageExamination
    Created on : Oct 10, 2014, 9:48:39 AM
    Author     : Shubham Shandilya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Skill Check</title>
        <meta charset="UTF-8">

        <!-- Include layout style -->
        <link href="styles/layout.css" rel="stylesheet"/>

        <!-- Include page specific css -->
        <link href="styles/manageExamination.css" rel="stylesheet"/>

        <!-- Include script -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/main.js"></script>
        <script type="text/javascript" src="scripts/manageExamination.js"></script>

    </head>
    <body>
        <!-- Wrapper div for body starts -->
        <div id="bodyWrapper">
            <!-- Header section Starts -->
            <div id="header">
                <!-- Whole footer content will be in this container div -->
                <div class="container">
                    <!-- Div for logo and punch line starts -->
                    <div id="logo">
                        Skill Check
                    </div>
                    <!-- Div for logo and punch line Ends -->
                    <!-- Div for login details starts -->
                    <div id="userLoginDetail">
                        <span id="userName"><c:out value="${loggedInUser.userName}"></c:out></span>
                        &nbsp;&nbsp;&nbsp;
                        <a class="logOutLink" href="logout.htm" >Logout</a>
                    </div>
                    <!-- Div for login details Ends -->
                </div>
                <!-- Container div for header ends here --> 
            </div>
            <!-- Header section Ends -->
            <br>

            <!-- Body content section Starts -->
            <div>
                <!-- Whole body content will be in this container div -->
                <div class="container">
                    <!-- Div for Menu Starts -->
                    <div id="menu">
                        <div id="menuList">
                            <div id="home" class="menuItem">
                                <a class="menuLink" href="userHome.htm">Home</a>
                            </div>
                            <div id="profile" class="menuItem">
                                <a class="menuLink" href="profile.htm">Profile</a>
                            </div>
                            <div id="manageExamination" class="menuItem">
                                <span class="selected">Manage Examinations</span>
                            </div>
                            <c:if test="${loggedInUser.role.roleId == 1}">  
                                <div id="administration" class="menuItem">
                                    <a class="menuLink" href="manageUser.htm">Manage User</a>
                                </div>
                            </c:if> 
                        </div>
                    </div>
                    <!-- Div for Menu ends -->
                    <!-- Rest of the body content Starts -->
                    <div id="mainContent">
                        <div id="msgDiv">
                            <c:if test="${not empty manageExamStatus}">
                                <c:if test="${manageExamStatus.status == 1}">
                                    <div class="error"><c:out value="${manageExamStatus.statusMessage}"></c:out></div>
                                </c:if>
                                <c:if test="${manageExamStatus.status == 0}">
                                    <div class="message"><c:out value="${manageExamStatus.statusMessage}"></c:out></div>
                                </c:if>
                            </c:if>
                        </div>
                        <!-- Welcome content Div Starts -->
                        <div id="questionsDiv" class="divSection">
                            <table class="table-1-3 width-100pct">
                                <tr class="tableHeader">
                                    <td class="tableHeaderDetail">
                                        Questions
                                    </td>
                                </tr>
                            </table>
                            <c:if test="${not empty doneCancelMsg}">
                                <c:set var="divDisplay" value="block"></c:set>
                                <c:if test="${whichAction == 9}">
                                    <c:set var="divDisplay" value="none"></c:set>
                                </c:if>
                                <div id="topButtonSection" style="display: ${divDisplay}">
                                    <div class="message">${doneCancelMsg}</div>
                                    <div>
                                        <table>
                                            <tr>
                                                <td>
                                                    <input type="button" value="Done" id="doneBtn" style="width:80px" onclick="doOperation(7)"> &nbsp; &nbsp;
                                                    <c:if test="${editScenario == 0}">
                                                        <input type="button" value="Cancel" id="cancelBtn" style="width:80px" onclick="doOperation(8)">
                                                    </c:if>

                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </c:if>
                            <div id="addSection" style="display:${displayForm}">
                                <div class="formSection bgColor">
                                    <form id="manageExaminationForm" name="manageExaminationForm" method="post">
                                        
                                        <input type="hidden" name="editScenario" id="editScenario" value="${editScenario}">
                                        <c:if test="${whichAction != 9}">
                                            <input type="hidden" name="questionId" id="questionId">
                                            <table class="table-1-3 width-100pct formTable">
                                                <tbody>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Question<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <textarea name="question" rows="3" onkeypress="hideCustom(this)" onblur="validateRequired(this)" id="question" title="Please enter question."></textarea>
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="questionMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (A)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionA" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter option A" id="optionA">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionAMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (B)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionB" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter option B" id="optionB">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionBMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (C)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionC" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter option C" id="optionC">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionCMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (D)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionD" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter option D" id="optionD">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionDMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Correct Answer<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <select id="correctAnswer" name="correctAnswer" onchange="hideCustom(this)" onblur="validateRequired(this)">
                                                                <option value="A">A</option>
                                                                <option value="B">B</option>
                                                                <option value="C">C</option>
                                                                <option value="D">D</option>
                                                            </select>
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="correctAnswerMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3" class="align-center">
                                                            <input type="hidden" name="examinationId" id="examinationId" value="${examId}">
                                                            <input type="hidden" name="operation" id="operation" value="${whichAction}">
                                                            <input type="button" value="Insert Question" id="addUpdateQuestionBtn" onclick="doOperation(4)">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3" class="align-center">
                                                            <div id="msgForQuestions"></div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${whichAction == 9}">
                                            <input type="hidden" name="questionId" id="questionId" value="${ques.questionId}">
                                            <table class="table-1-3 width-100pct formTable">
                                                <tbody>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Question<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <textarea name="question" rows="3" onkeypress="hideCustom(this)" onblur="validateRequired(this)" id="question"  title="Please enter question.">${ques.question}</textarea>
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="questionMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (A)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionA" onkeypress="hideCustom(this)" onblur="validateRequired(this)"  value="${ques.optionA}" title="Please enter option A" id="optionA">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionAMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (B)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionB" onkeypress="hideCustom(this)" onblur="validateRequired(this)" value="${ques.optionB}" title="Please enter option B" id="optionB">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionBMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (C)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionC" onkeypress="hideCustom(this)" onblur="validateRequired(this)"  value="${ques.optionC}" title="Please enter option C" id="optionC">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionCMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Option (D)<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <input type="text" name="optionD" onkeypress="hideCustom(this)" onblur="validateRequired(this)"  value="${ques.optionD}" title="Please enter option D" id="optionD">
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="optionDMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="width-30pct">
                                                            Correct Answer<span class="superscriptLike">*</span>
                                                        </td>
                                                        <td class="width-40pct">
                                                            <select id="correctAnswer" name="correctAnswer" onchange="hideCustom(this)"  value="${ques.correctAnswer}" onblur="validateRequired(this)">
                                                                <option value="A">A</option>
                                                                <option value="B">B</option>
                                                                <option value="C">C</option>
                                                                <option value="D">D</option>
                                                            </select>
                                                        </td>
                                                        <td class="width-30pct ">
                                                            <div id="correctAnswerMsg"></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3" class="align-center">
                                                            <input type="hidden" name="examinationId" id="examinationId" value="${examId}">
                                                            <input type="hidden" name="operation" id="operation" value="${whichAction}">
                                                            <input type="button" value="Update Question" id="addUpdateQuestionBtn" onclick="doOperation(4)">
                                                            <input type="button" value="Cancel" id="cancelQuestionBtn" onclick="doOperation(10)">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3" class="align-center">
                                                            <div id="msgForQuestions"></div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        
                                    </form>
                                </div>
                                <br/>
                            </div>
                            
                            <div id="toolbarDiv">
                                <table>
                                    <tr>
                                        <td>
                                            <a href="javascript:doOperation(9);"><img class="menuImage" title="Edit Question" src="images/edit.png" alt="Edit"/></a>
                                        </td>
                                        <td>
                                            <a href="javascript:doOperation(5);"><img class="menuImage" title="Delete Question" src="images/delete.png" alt="Delete"/></a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <table class="table-1-3  width-100pct" border="1" id="examTable">
                                <tr>
                                    <td class="columnHeader width-5pct">&nbsp;</td>
                                    <td class="columnHeader width-25pct">Question</td>
                                    <td class="columnHeader width-15pct">Option A</td>
                                    <td class="columnHeader width-15pct">Option B</td>
                                    <td class="columnHeader width-15pct">Option C</td>
                                    <td class="columnHeader width-15pct">Option D</td>
                                    <td class="columnHeader width-10pct">Answer</td>
                                </tr>
                                <c:if test="${not empty questions}">
                                    <c:forEach var="question" items="${questions}">
                                        <tr>
                                            <td><input type="checkbox" name="questionCheckbox" value="${question.questionId}"></td>
                                            <td>${question.question}</td>
                                            <td>${question.optionA}</td>
                                            <td>${question.optionB}</td>
                                            <td>${question.optionC}</td>
                                            <td>${question.optionD}</td>
                                            <td>${question.correctAnswer}</td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty questions}">
                                    <tr>
                                        <td colspan="8">No data to display.</td>
                                    </tr>
                                </c:if>
                            </table>
                        </div>
                        
                    </div>
                </div>
                <!-- Rest of the body content ends -->

            </div>
            <!-- Container div for body ends here -->
        </div>
        <!-- Body content section Ends -->

        <!-- Footer section Starts -->
        <div id="footer">
            <!-- Whole footer content will be in this container div -->
            <div class="container">
                <p id="copyright">&copy;2014. All Rights Reserved.</p>
            </div>
            <!-- Container div for footer ends here -->
        </div>
        <!-- Footer section Ends -->
    </div>
    <!-- Wrapper div ends here -->
</body>
</html>


