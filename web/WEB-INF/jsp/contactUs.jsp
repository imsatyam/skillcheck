<%-- 
    Document   : contactUs
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
        <link href="styles/contactUs.css" rel="stylesheet"/>
        
        <!-- Add javascript -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/contactUs.js"></script>
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
                                <span class="selected">Contact Us</span>
                            </div>
                        </div>
                    </div>
                    <!-- Div for Menu ends -->
                    <!-- Rest of the body content Starts -->
                    <div id="mainContent">
                        <div class="pageHeading">Contact Us</div>
                         <p class="justify">
                            We are easily reachable. You can contact us using phone, on web, at social networking websites and our office nearest to your location.
                        </p>
                        <div class="width-100pct border-1px min-height-200 bgColor">
                            <div class="margin-10 setVisible" id="queryForm">
                                <div class="inlineHead">Any Query?</div>
                                <form id="contactForm" name="contactForm" method="post" action="contactUs.htm">
                                    <table id="formTable">
                                        <tbody class="border-1px">
                                            <tr>
                                                <td class="width-10pct">Name<span class="superscriptLike">*</span></td>
                                                <td class="width-30pct"><input type="text" name="name" id="name"/></td>
                                                <td class="width-20pct">&nbsp;</td>
                                                <td class="width-10pct">Email<span class="superscriptLike">*</span></td>
                                                <td class="width-30pct"><input type="text" name="email" id="email"/></td>
                                            </tr>
                                            <tr>
                                                <td class="width-20pct">Query<span class="superscriptLike">*</span></td>
                                                <td colspan="4">
                                                    <textarea rows="3" id="query" name="query">

                                                    </textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="5">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td colspan="5" class="align-center">
                                                    <input type="button" value="Submit Query" onclick="doQuerySubmit()"/> &nbsp;&nbsp;
                                                    <input type="button" value="Clear" onclick="doQueryClear()"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                            <div id="queryConfirmSection" class="setHide">
                                <div id="queryConfirm">
                                    <span class="inlineHead">Query Submitted Successfully!</span>
                                    <p class="justify">
                                        One of our representative will reach you shortly.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="width-100pct border-1px min-height-200 margin-top-20">
                            <div id="locations">
                                <h3>India offices</h3>
                                <table class="width-100pct">
                                    <tbody>
                                        <tr>
                                            <td class="width-25pct">
                                                ABC Complex<br>Gurgaon<br>Delhi NCR<br>Phone: +91 11 2345678    
                                            </td>
                                            <td class="width-25pct">
                                                Meenakshi Tech Tower<br>Hyderabad<br>Andhra Pradesh<br>Phone: +91 40 2345678    
                                            </td>
                                            <td class="width-25pct">
                                                YMX Building<br>Bangalore<br>Karnataka<br>Phone: +91 33 2345678    
                                            </td>
                                            <td class="width-25pct">
                                                XYZ Palace<br>Chennai<br>Tamil Nadu<br>Phone: +91 44 2345678    
                                            </td>
                                        </tr>
                                    </tbody>
                                </table><br/><br/>
                                <h3>World offices</h3>
                                <table>
                                    <tbody>
                                        <tr>
                                            <td class="width-30pct">
                                               Santa Clara<br>California<br>United States of America<br>Phone +1 12222333919
                                            </td>
                                            <td class="width-30pct">
                                               &nbsp;
                                            </td>
                                            <td class="width-40pct">
                                               &nbsp;
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
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

