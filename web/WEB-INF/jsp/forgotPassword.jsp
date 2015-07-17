<%-- 
    Document   : forgotPassword
    Created on : Oct 9, 2014, 5:22:14 PM
    Author     : Shubham Shandilya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Skill Check - Online Examination System</title>
        <meta charset="UTF-8">
        
        <!-- Include layout style -->
        <link href="styles/layout.css" rel="stylesheet"/>
        
        <!-- Include page specific css -->
        <link href="styles/forgotPassword.css" rel="stylesheet"/>
        
        <!-- Add javascript -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/forgotPassword.js"></script>
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
                    <!-- Div for social icons starts -->
                     <div id="social">
                         <div id="socialLinks">
                            <a class="socialLink" href="http://www.linkedIn.com/SkillCheck"><img src="images/linkedin.png" alt="LinkedIn"/></a>
                            <a class="socialLink" href="http://www.twitter.com/SkillCheck"><img src="images/twitter.png" alt="Twitter"/></a>
                            <a class="socialLink" href="http://www.facebook.com/SkillCheck"><img src="images/facebook.png" alt="Facebook"/></a>
                         </div>
                    </div>
                    <!-- Div for social icons Ends -->
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
                            <div class="menuItem">
                                <a class="menuLink" href="home.htm">Home</a>
                            </div>
                            <div class="menuItem">
                                <a class="menuLink" href="about.htm">About Us</a>
                            </div>
                            <div class="menuItem">
                                <a class="menuLink" href="clients.htm">Clients</a>
                            </div>
                            <div class="menuItem">
                                <a class="menuLink" href="contactUs.htm">Contact Us</a>
                            </div>
                        </div>
                    </div>
                    <!-- Div for Menu ends -->
                    <!-- Rest of the body content Starts -->
                    <div id="mainContent">
                        <div class="pageHeading">Forgot your password? Nothing to worry about.</div>
                        <p class="justify">
                            Looks like you have a problem with your password. There is nothing to worry about. Just enter your username and the password will be sent to your registered email address.
                        </p>
                        <div id="passwordRecoverySection">
                            <form action="forgotPassword.htm" method="post" id="forgotPasswordForm">
                                <input type="hidden" id="operation" name="operation"/>
                                <input type="text" id="usernameInput" name="username" onfocus="hideLegend(this)" onblur="showLegend(this)" onkeypress="clearMessages()"/>
                                <div id="buttonSection">
                                    <input type="button" id="forgotPasswordBtn" value="Send Password" onclick="processForgotPassword()"/>
                                </div><br><br><br>
                            </form>
                            <div id="messageSection"> 
                                <c:if test="${not empty forgotPasswordStatus}">
                                    <c:if test="${forgotPasswordStatus.status == 1}">
                                        <div class="error"><c:out value="${forgotPasswordStatus.statusMessage}"></c:out></div>
                                    </c:if>
                                    <c:if test="${forgotPasswordStatus.status == 0}">
                                        <div class="message"><c:out value="${forgotPasswordStatus.statusMessage}"></c:out></div>
                                    </c:if>
                                </c:if>
                            </div>
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

