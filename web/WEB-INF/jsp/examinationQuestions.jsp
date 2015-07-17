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
                        <form method="post" id="examinationForm" action="examination.htm">
                            <!-- Rest of the body content Starts -->
                            <div id="mainContent">

                                <input type="hidden" name="operation" id="operation" value=""/>
                                <div id="tableDiv" class="setVisible">

                                <c:if test="${not empty exam}">
                                    <table class="width-100pct align-center">
                                        <tr class="tableHeader">
                                            <td class="tableHeaderDetail">
                                                ${exam.examinationName}
                                            </td>
                                        </tr>
                                    </table>
                                    <input type="hidden" name="examinationId" value="${exam.examinationId}"/>
                                </c:if>

                                <c:if test="${not empty examQuestions}">
                                    <c:forEach var="question" items="${examQuestions}" varStatus="status">
                                        <c:set var="qaRad" value="scqa_${question.questionId}_${status.count}"></c:set>
                                            <table class="width-100pct" style="padding-top: 3px;">
                                                <tr>
                                                    <td>
                                                    ${status.count}.&nbsp;${question.question} 
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="radio" name="${qaRad}" value="A">&nbsp;${question.optionA} 
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="radio" name="${qaRad}" value="B">&nbsp;${question.optionB}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="radio" name="${qaRad}" value="C">&nbsp;${question.optionC}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="radio" name="${qaRad}" value="D">&nbsp;${question.optionD}
                                                </td>
                                            </tr>
                                        </table>
                                        <hr/>
                                    </c:forEach>
                                </c:if>    

                                <table class="width-100pct">
                                    <tr>
                                        <td class="align-center">
                                            <input type="button" value="Submit" id="beginExamBtn" onclick="doOperation(4)">
                                        </td>
                                    </tr>
                                </table>
                            </div>

                        </div>
                        <!-- Rest of the body content ends -->
                    </form>


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


