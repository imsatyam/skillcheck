<%-- 
    Document   : userHome
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
        <link href="styles/userHome.css" rel="stylesheet"/>

        <!-- Include script -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/main.js"></script>
        <script type="text/javascript" src="scripts/userHome.js"></script>

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
                        <span id="userName">
                            <c:out value="${loggedInUser.userName}"></c:out>
                            </span>
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
                                    <span class="selected">Home</span>
                                </div>
                                <div id="profile" class="menuItem">
                                    <a class="menuLink" href="profile.htm">Profile</a>
                                </div>
                            <c:set var="admin" value="1"></c:set>
                            <c:set var="examiner" value="2"></c:set>
                            <c:set var="examinee" value="3"></c:set>
                            <c:if test="${loggedInUser.role.roleId==admin}">  
                                <div id="manageExamination" class="menuItem">
                                    <a class="menuLink" href="manageExamination.htm">Manage Examinations</a>
                                </div>
                                <div id="administration" class="menuItem">
                                    <a class="menuLink" href="manageUser.htm">Manage User</a>
                                </div>
                            </c:if>  
                            <c:if test="${loggedInUser.role.roleId==examiner}">  
                                <div id="manageExamination" class="menuItem">
                                    <a class="menuLink" href="manageExamination.htm">Manage Examinations</a>
                                </div>
                            </c:if>
                            <c:if test="${loggedInUser.role.roleId==examinee}">  
                                <div id="examination" class="menuItem">
                                    <a class="menuLink" href="examination.htm">Examinations</a>
                                </div>
                            </c:if> 
                        </div>
                    </div>
                    <!-- Div for Menu ends -->
                    <!-- Rest of the body content Starts -->
                    <div id="mainContent">

                        <!-- Welcome content Div Starts -->
                        <div id="description">

                            <div id="details">
                                <div id="userImage">
                                    <img id="profilePicture" src="" alt=""/>
                                </div>
                                <div id="userDetails">
                                    <div id="nameSection">
                                        <h3>
                                            <span id="nameOfUser">
                                                <c:out value="${loggedInUser.firstName}"></c:out>&nbsp;<c:out value="${loggedInUser.lastName}"></c:out>
                                                </span>
                                            </h3>
                                        </div>
                                        <div class="userDetailsRow">
                                            <div>
                                                <span id="userEmail">
                                                <c:out value="${loggedInUser.email}"></c:out>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="userDetailsRow">
                                            <div>
                                                <span id="userContact">
                                                <c:out value="${loggedInUser.contact}"></c:out>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Welcome Content div ends -->
                        <br/>
                        <c:if test="${loggedInUser.role.roleId==examinee}"> 
                            <table class="width-100pct">
                                <tr class="tableHeader">
                                    <td class="tableHeaderDetail">
                                        Previous Results
                                    </td>
                                </tr>
                            </table>
                            <table class="table-1-3  width-100pct" border="1">
                                <tr>
                                    <td class="columnHeader width-55pct">Examination Name</td>
                                    <td class="columnHeader width-15pct">Date</td>
                                    <td class="columnHeader width-15pct">Marks Obtained</td>
                                    <td class="columnHeader width-15pct">Pass/Fail</td>
                                </tr>
                                <c:if test="${empty results}">
                                    <tr>
                                        <td colspan="4">No data to display.</td>
                                    </tr>
                                </c:if>
                                <c:if test="${not empty results}">
                                    <c:forEach var="result" items="${results}">
                                        <tr>
                                            <td>${result.examination.examinationName}</td>
                                            <td class="align-center">${result.examinationTakenDate}</td>
                                            <td class="align-center">${result.marksObtained}</td>
                                            <td class="align-center">
                                                <c:if test="${result.isPass == 1}">
                                                    <font color="green"><b>Pass</b></font>
                                                </c:if>    
                                                <c:if test="${result.isPass != 1}">
                                                    <font color="#800517"><b>Fail</b></font>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </table>
                        </c:if>
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



