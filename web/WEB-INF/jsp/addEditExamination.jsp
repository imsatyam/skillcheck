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
                        <div class="pageHeading">
                            <c:if test="${whichAction ==  1}">
                                Add Examination
                            </c:if>
                            <c:if test="${whichAction ==  2}">
                                Edit Examination
                            </c:if>
                        </div>
                        <!-- Welcome content Div Starts -->
                        <div class="width-100pct border-1px min-height-200 bgColor">
                            <form id="manageExaminationForm" name="manageExaminationForm" method="post" action="manageExamination.htm">
                                <input type="hidden" name="operation" id="operation" value="">
                                <c:if test="${whichAction ==  1}">
                                    <input type="hidden" name="examinationId" id="examinationId" value="0">
                                    <input type="hidden" name="editScenario" id="editScenario" value="0">

                                    <table class="table-1-3 width-100pct formTable">
                                        <tbody>
                                            <tr>
                                                <td class="width-30pct">
                                                    Name<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="examinationName" id="examinationName" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter Name">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="examinationNameMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Total Questions<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="numberOfQuestions" onkeypress="hideCustom(this)" onblur="validateRequiredNumber(this)" id="numberOfQuestions" title="Please enter Total Questions">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="numberOfQuestionsMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Maximum Marks<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="maximumMarks" title="Please enter Maximum Marks" onkeypress="hideCustom(this)" onblur="validateRequiredNumber(this)" id="maximumMarks">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="maximumMarksMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Passing Marks<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="passingMarks" title="Please enter Passing Marks" onkeypress="hideCustom(this)" onblur="validateRequiredNumber(this)" id="passingMarks"> 
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="passingMarksMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Negative Marks<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" title="Please enter Negative Marks" onkeypress="hideCustom(this)" onblur="validateRequiredNumber(this)" name="negativeMarks" id="negativeMarks"> 
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="negativeMarksMsg"></div>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td class="width-30pct">
                                                    Time Limit (In Minutes)<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" title="Please enter Time Limit" onkeypress="hideCustom(this)" onblur="validateRequiredNumber(this)" name="timeInMinutes" id="timeInMinutes">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="timeInMinutesMsg"></div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </c:if>
                                <c:if test="${whichAction ==  2}">
                                    <input type="hidden" name="examinationId" id="examinationId" value="${exam.examinationId}">
                                    <input type="hidden" name="editScenario" id="editScenario" value="1">
                                    <table class="table-1-3 width-100pct formTable">
                                        <tbody>
                                            <tr>
                                                <td class="width-30pct">
                                                    Name<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="examinationName" id="examinationName" title="Please enter Name" value="${exam.examinationName}">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="examinationNameMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Total Questions<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="numberOfQuestions" id="numberOfQuestions" title="Please enter Total Questions" value="${exam.numberOfQuestions}">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="numberOfQuestionsMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Maximum Marks<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="maximumMarks" id="maximumMarks" title="Please enter Maximum Marks" value="${exam.maximumMarks}">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="maximumMarksMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Passing Marks<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="passingMarks" id="passingMarks" title="Please enter Passing Marks" value="${exam.passingMarks}"> 
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="passingMarksMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Negative Marks<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="negativeMarks" id="negativeMarks" title="Please enter Negative Marks" value="${exam.negativeMarks}"> 
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="negativeMarksMsg"></div>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td class="width-30pct">
                                                    Time Limit (In Minutes)<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="timeInMinutes" id="timeInMinutes" title="Please enter Time Limit" value="${exam.timeInMinutes}">
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="timeInMinutesMsg"></div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </c:if>

                            </form>
                            <table class="width-100pct">
                                <tr>
                                    <td class="align-center">
                                        <input type="button" value="Next" id="addUpdateExamBtn" onclick="doOperation(3)"> &nbsp; &nbsp;
                                        <input type="button" value="Cancel" id="cancelExamBtn" onclick="doOperation(8)">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">
                                        <div id="msgForExam"></div>
                                    </td>
                                </tr>
                            </table>
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


