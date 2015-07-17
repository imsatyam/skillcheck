<%-- 
    Document   : aboutUs
    Author     : Shubham Shandilya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Skill Check - Online Examination System</title>
        <meta charset="UTF-8">
        
        <!-- Include layout style -->
        <link href="styles/layout.css" rel="stylesheet"/>
        
        <!-- Include page specific css -->
        <link href="styles/aboutUs.css" rel="stylesheet"/>
        
        <!-- Add javascript -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        
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
                                <a class="menuLink" href="homr.htm">Home</a>
                            </div>
                            <div class="menuItem">
                                <span class="selected">About Us</span>
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
                        <div class="pageHeading">About Us</div>
                         <p class="justify">
                            We are the leaders in providing quality online examination for recruitment as well as for practice. 
                         </p>
                         <div id="imageDiv">
                             <img class="fullImage" src="images/firstImage.jpg" alt="About Us"/>
                         </div>
                         <h3>Our Vision</h3>
                         <p class="justify">
                             Vision here
                         </p>
                         <h3>Our Mission</h3>
                         <p class="justify">
                             Mission here
                         </p>
                         
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

