<%-- 
    Document   : home
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
        <link href="styles/home.css" rel="stylesheet"/>
        
        <!-- Add javascript -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/home.js"></script>
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
                                <span class="selected">Home</span>
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
                        <!-- Left hand side column Starts-->
                        <div class="leftColumn">
                            <!-- Image animation div starts -->
                            <div id="imageSpace">
                                <img class="titleImage" src="images/firstImage.jpg" alt="Welcome"/>
                            </div>
                            <!-- Image animation div ends -->
                            <!-- Welcome content Div Starts -->
                            <div id="description">
                                <h3>Welcome to Skill Check</h3>
                                <p class="justify">
                                    
                                </p>
                            </div>
                            <!-- Welcome Content div ends -->                        
                        </div>
                        <!-- Left hand side column ends-->
                        <!-- Right hand side column Starts-->
                        <div class="rightColumn">
                            <!-- Login Div starts -->
                            <div id="row1">
                                <h3>Sign In</h3>
                                <form id="loginForm" method="post" action="login.htm">
                                    <div id="errorText" class="error">
                                        <c:if test="${not empty errorMessage}">
                                            ${errorMessage}
                                        </c:if>
                                    </div>
                                    <input type="text" name="username" id="username" value="User Name" onfocus="hideLegend(this)" onblur="showLegend(this)" onkeyup="hideError()"/>
                                    <input type="password" name="password" id="password" value="Password" onfocus="hideLegend(this)" onblur="showLegend(this)" onkeyup="hideError()"/>
                                    
                                    <div id="loginButtonOption">
                                        <div id="registerLink">
                                            <a class="link" href="forgotPassword.htm">Forgot Password?</a><br>
                                            New user? &nbsp;<a class="link" href="register.htm">Register</a>
                                        </div>
                                        <div id="loginButton">
                                            <input type="button" id="loginBtn" value="Sign In" onclick="doLogin()"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                                                        
                            <!-- Login Div ends -->

                            <!-- Latest updates starts -->
                            <div id="row2">
                                <h3>Latest Updates</h3>
                            </div>
                            <!-- Latest updates ends -->

                        </div>
                        <!-- Right hand side column ends-->
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
