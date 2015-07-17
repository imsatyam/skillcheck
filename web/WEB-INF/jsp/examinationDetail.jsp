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
                                <c:if test="${not empty exam}">
                                    <table class="width-100pct">
                                        <tr class="tableHeader">
                                            <td class="tableHeaderDetail">
                                                Details of the Examination
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="width-100pct table-1-3" border="1">
                                        <tr>
                                            <td class="align-left width-30pct">
                                                Examination
                                            </td>
                                            <td class="align-left">
                                                ${exam.examinationName}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="align-left width-30pct">
                                                Maximum Marks
                                            </td>
                                            <td class="align-left">
                                                ${exam.maximumMarks}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="align-left width-30pct">
                                                Number of Questions
                                            </td>
                                            <td class="align-left">
                                                ${exam.numberOfQuestions}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="align-left width-30pct">
                                                Time (In Minutes)
                                            </td>
                                            <td class="align-left">
                                                ${exam.timeInMinutes}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="align-left width-30pct">
                                                Passing Marks
                                            </td>
                                            <td class="align-left">
                                                ${exam.passingMarks}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="align-left width-30pct">
                                                Negative Marks
                                            </td>
                                            <td class="align-left">
                                                ${exam.negativeMarks}
                                            </td>
                                        </tr>

                                    </table>
                                    <table class="width-60pct align-center">
                                        <tr>
                                            <td class="align-center">
                                                <input type="button" value="Begin" id="beginExamBtn" onclick="doOperation(2)"> &nbsp; &nbsp;
                                                <input type="button" value="Cancel" id="cancelExamBtn" onclick="doOperation(3)">
                                            </td>
                                        </tr>
                                    </table>
                                    <form id="examinationForm" name="examinationForm" method="get" action="examination.htm">
                                        <input type="hidden" name="operation" id="operation" value=""/>
                                        <input type="hidden" name="examinationId" value="${exam.examinationId}"/>
                                    </form>        
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


