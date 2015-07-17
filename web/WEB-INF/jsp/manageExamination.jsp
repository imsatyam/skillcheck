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

                        <!-- Welcome content Div Starts -->
                        <div id="description">

                            <!-- Display Exam List along with a menu to add, edit and delete -->   
                            <div id="toolbarDiv">
                                <table>
                                    <tr>
                                        <td>
                                            <a href="javascript:doOperation(1);"><img class="menuImage" title="Add Examination" src="images/add.png" alt="Add"/></a>
                                        </td>
                                        <td>
                                            <a href="javascript:doOperation(2);"><img class="menuImage" title="Edit Examination" src="images/edit.png" alt="Edit"/></a>
                                        </td>
                                        <td>
                                            <a href="javascript:doOperation(6);"><img class="menuImage" title="Delete Examination" src="images/delete.png" alt="Delete"/></a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
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
                            <div class="normalDiv">
                                <table class="width-100pct">
                                    <tr class="tableHeader">
                                        <td class="tableHeaderDetail">
                                            Examination
                                        </td>
                                    </tr>
                                </table>
                                <table class="table-1-3  width-100pct" border="1" id="examTable">
                                    <tr>
                                        <td class="columnHeader width-5pct">&nbsp;</td>
                                        <td class="columnHeader width-20pct">Name</td>
                                        <td class="columnHeader width-10pct">Questions</td>
                                        <td class="columnHeader width-15pct">Maximum Marks</td>
                                        <td class="columnHeader width-10pct">Negative Marks</td>
                                        <td class="columnHeader width-10pct">Passing Marks</td>
                                        <td class="columnHeader width-10pct">Time<br>(Minutes)</td>
                                        <td class="columnHeader width-15pct">Created On</td>
                                    </tr>
                                    <c:if test="${not empty exams}">
                                        <c:forEach var="exam" items="${exams}">
                                            <td><input type="checkbox" name="examCheckbox" value="${exam.examinationId}"></td>
                                            <td>${exam.examinationName}</td>
                                            <td>${exam.numberOfQuestions}</td>
                                            <td>${exam.maximumMarks}</td>
                                            <td>${exam.negativeMarks}</td>
                                            <td>${exam.passingMarks}</td>
                                            <td>${exam.timeInMinutes}</td>
                                            <td>${exam.createdDateString}</td>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${empty exams}">
                                        <tr>
                                            <td colspan="8">No data to display.</td>
                                        </tr>
                                    </c:if>
                                </table>    
                            </div>
                            <form id="manageExaminationForm" method="post" action="manageExamination.htm">
                                <input type="hidden" name="operation" id="operation" value="">
                                <input type="hidden" name="examinationId" id="examinationId" value="">
                            </form>
                            
                        </div>
                        <!-- Welcome Content div ends -->
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


