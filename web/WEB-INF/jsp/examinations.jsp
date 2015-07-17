<%-- 
    Document   : examination
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
                            <table class="width-100pct">
                                <tr class="tableHeader">
                                    <td class="tableHeaderDetail">
                                        Available Examinations
                                    </td>
                                </tr>
                            </table>
                            <div id="examTableDiv">
                                <table class="table-1-3  width-100pct" border="1" id="examTable">
                                    <tr>
                                        <td class="columnHeader width-55pct">Examination Name</td>
                                        <td class="columnHeader width-15pct">Maximum Marks</td>
                                        <td class="columnHeader width-15pct">Total Questions</td>
                                        <td class="columnHeader width-15pct">&nbsp;</td>
                                    </tr>
                                <c:if test="${empty examinationList}">
                                    <tr>
                                        <td colspan="4">
                                            No data to display.
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${not empty examinationList}">
                                    <c:forEach var="exam" items="${examinationList}">
                                        <tr>
                                            <td>${exam.examinationName}</td>
                                            <td>${exam.maximumMarks}</td>
                                            <td>${exam.numberOfQuestions}</td>
                                            <td class="align-center">
                                                <a class="textLink" href="javascript:doLaunch(${exam.examinationId});">Launch</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                        <form id="examinationForm" method="get" action="examination.htm">
                                            <input type="hidden" name="operation" id="operation"/>
                                            <input type="hidden" name="examinationId" id="examinationId"/>
                                        </form>
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


