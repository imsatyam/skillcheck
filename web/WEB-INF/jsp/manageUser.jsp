<%-- 
    Document   : manageUser
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
        <script type="text/javascript" src="scripts/manageUser.js"></script>

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
                                <a class="menuLink" href="manageExamination.htm">Manage Examinations</a>
                            </div>
                            <div id="manageUser" class="menuItem">
                                <span class="selected">Manage User</span>
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
                                        All Users
                                    </td>
                                </tr>
                            </table>
                            <div id="examTableDiv">
                                <table class="table-1-3  width-100pct" border="1">
                                    <tr>
                                        <td class="columnHeader width-20pct">Username</td>
                                        <td class="columnHeader width-20pct">First Name</td>
                                        <td class="columnHeader width-20pct">Last Name</td>
                                        <td class="columnHeader width-30pct">Email</td>
                                        <td class="columnHeader width-5pct">Active</td>
                                        <td class="columnHeader width-5pct">&nbsp;</td>
                                    </tr>
                                <c:if test="${empty users}">
                                    <tr>
                                        <td colspan="4">
                                            No data to display.
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${not empty users}">
                                    <c:forEach var="user" items="${users}">
                                        <tr>
                                            <td>${user.userName}</td>
                                            <td>${user.firstName}</td>
                                            <td>${user.lastName}</td>
                                            <td>${user.email}</td>
                                            <td class="align-center">
                                                <c:if test="${user.active == true}">
                                                    Y
                                                </c:if>    
                                                <c:if test="${user.active != true}">
                                                    N
                                                </c:if>
                                            </td>
                                            <td class="align-center">
                                                <a class="textLink" href="javascript:doDelete(${user.userId});">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                        <form id="manageUserForm" method="post" action="manageUser.htm">
                                            <input type="hidden" name="operation" id="operation"/>
                                            <input type="hidden" name="userId" id="userId"/>
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


