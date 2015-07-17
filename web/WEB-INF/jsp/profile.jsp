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
        <link href="styles/profile.css" rel="stylesheet"/>

        <!-- Include script -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/main.js"></script>
        <script type="text/javascript" src="scripts/profile.js"></script>

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
                                    <a class="menuLink" href="userHome.htm">Home</a>
                                </div>
                                <div id="profile" class="menuItem">
                                    <span class="selected">Profile</span>
                                </div>
                                <c:set var="admin" value="1"></c:set>
                                <c:set var="examiner" value="2"></c:set>
                                <c:set var="examinee" value="3"></c:set>
                                <c:if test="${loggedInUser.role.roleId==admin}">  
                                    <div id="administration" class="menuItem">
                                        <a class="menuLink" href="administration.htm">Administration</a>
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
                        <div class="pageHeading">Manage Profile</div>
                        <p class="justify">
                            Please keep your profile updated.
                        </p>
                        <div id="formSection" class="setVisible bgColor">
                            <div id="notificationSection">
                                <div id="notification">
                                    <span class="superscriptLike">*</span> marked fields are mandatory.
                                </div>
                            </div>
                            <form name="profileForm" id="profileForm" action="profile.htm" method="post">
                                <!-- Let us use a hidden variable to know what operation is being performed  -->
                                <input type="hidden" name="operation" id="operation" value=""/>
                                <table class="table-1-3 register">
                                    <tbody>
                                        <tr>
                                            <td class="width-30pct">
                                                First Name<span class="superscriptLike">*</span>
                                            </td>
                                            <td class="width-40pct">
                                                <input type="text" name="firstName" id="firstName" value="<c:out value='${loggedInUser.firstName}'></c:out>" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter first name."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="firstNameMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Last Name
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="lastName" value="<c:out value='${loggedInUser.lastName}'></c:out>" id="lastName" title="Please enter last name."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="lastNameMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Email<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="email" id="email" value="<c:out value='${loggedInUser.email}'></c:out>" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter email."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="emailMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="width-30pct">
                                                    Contact<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="mobile" id="mobile" value="<c:out value='${loggedInUser.contact}'></c:out>" title="Please enter contact." onkeypress="hideCustom(this)" onblur="validateContact(this)"/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="mobileMsg"></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="3">
                                                    &nbsp;
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="3" class="align-center">
                                                    <input type="button" value="Update" id="update" onclick="doUpdate()"> &nbsp; &nbsp;
                                                    <input type="button" value="Cancel" id="cancel" onclick="doCancel()">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="3" class="align-center">
                                                    <div id="msgDiv">
                                                    <c:if test="${not empty profileUpdateStatus}">
                                                        <c:if test="${profileUpdateStatus.status == 1}">
                                                            <div class="error"><c:out value="${profileUpdateStatus.statusMessage}"></c:out></div>
                                                        </c:if>
                                                        <c:if test="${profileUpdateStatus.status == 0}">
                                                            <div class="message"><c:out value="${profileUpdateStatus.statusMessage}"></c:out></div>
                                                        </c:if>
                                                    </c:if>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>

                    </div>
                    <!-- Main content ends -->
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
