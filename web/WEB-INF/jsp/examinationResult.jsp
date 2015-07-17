<%-- 
    Document   : examinationDetail
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
        <link href="styles/examination.css" rel="stylesheet"/>

        <!-- Add javascript -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/main.js"></script>
        <script type="text/javascript" src="scripts/examination.js"></script>

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
                            <div id="examination" class="menuItem">
                                <span class="selected">Examination</span>
                            </div>
                        </div>
                    </div>
                    <!-- Div for Menu ends -->
                    <!-- Rest of the body content Starts -->
                    <div id="mainContent">

                        <div id="tableDiv" class="setVisible">
                            <div id="examTableDiv">
                            <c:if test="${not empty result}">
                                <table class="width-100pct">
                                    <tr class="tableHeader">
                                        <td class="tableHeaderDetail">
                                            Result
                                        </td>
                                    </tr>
                                </table>
                                <table class="width-100pct table-1-3" border="1">
                                    <tr>
                                        <td class="align-left width-30pct">
                                            Examination
                                        </td>
                                        <td class="align-left">
                                            ${result.examination.examinationName}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="align-left width-30pct">
                                            Correct Answers
                                        </td>
                                        <td class="align-left">
                                            ${result.numberCorrect}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="align-left width-30pct">
                                            Incorrect Answers
                                        </td>
                                        <td class="align-left">
                                            ${result.numberIncorrect}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="align-left width-30pct">
                                            Marks Obtained
                                        </td>
                                        <td class="align-left">
                                            ${result.marksObtained}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="align-left width-30pct">
                                            Pass/Fail
                                        </td>
                                        <td class="align-left">
                                            <c:if test="${result.isPass == 1}">
                                                <font color="green"><b>Pass</b></font>
                                            </c:if>    
                                            <c:if test="${result.isPass != 1}">
                                                <font color="#800517"><b>Fail</b></font>
                                            </c:if>
                                        </td>
                                    </tr>
                                </table>
                            </c:if>
                                
                            <c:if test="${not empty incorrectAnswers}">
                                <table class="width-100pct">
                                    <tr class="tableHeader">
                                        <td class="tableHeaderDetail">
                                            Incorrect Answers
                                        </td>
                                    </tr>
                                </table>
                                <c:forEach var="incorrect" items="${incorrectAnswers}">
                                    <table class="width-100pct">
                                        <tr>
                                            <td>
                                                ${incorrect.uiQuestionId}. ${incorrect.question}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <font color="#800517"><b>Incorrect: </b></font> (${incorrect.incorrectOption})&nbsp;&nbsp;${incorrect.incorrectAnswer}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <font color="green"><b>Correct: </b></font>&nbsp;&nbsp;(${incorrect.correctOption})&nbsp;&nbsp;${incorrect.correctAnswer}
                                            </td>
                                        </tr>
                                    </table>
                                </c:forEach>
                            </c:if>
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


