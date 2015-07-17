<%-- 
    Document   : registration
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
        <link href="styles/register.css" rel="stylesheet"/>
        
        <!-- Add javascript -->
        <script type="text/javascript" src="scripts/skillCheck.js"></script>
        <script type="text/javascript" src="scripts/register.js"></script>
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
                        <div class="pageHeading">New User Registration</div>
                        <p class="justify">
                            To explore the exciting challenge of a variety of online examinations on various subjects please register.
                        </p>
                        <c:if test="${empty regStatus || regStatus.status == 1}">
                            <div id="formSection" class="setVisible bgColor">
                                <div id="notificationSection">
                                    <div id="notification">
                                        <span class="superscriptLike">*</span> marked fields are mandatory.
                                    </div>
                                </div>
                                <div id="messageSection">
                                    <c:if test="${not empty regStatus}">
                                        <div class="error"><c:out value="${regStatus.statusMessage}"></c:out></div>
                                    </c:if> 
                                </div>
                                <form name="registerForm" id="registerForm" method="post" action="register.htm">
                                    <!-- Hidden variable to track operation -->
                                    <input type="hidden" name="operation" id="operation" value=""/>
                                    <table class="table-1-3 register">
                                        <tbody>
                                            <tr>
                                                <td class="width-30pct">
                                                    Username<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="username" id="username" onkeypress="hideCustom(this)" onblur="validateUsername(this)" title="Please enter Username."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="usernameMsg"></div>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="width-30pct">
                                                    Password<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="password" name="password" id="password" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter Password."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="passwordMsg"></div>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="width-30pct">
                                                    Confirm Password<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="password" name="confirmPassword" id="confirmPassword" onkeypress="hideCustom(this)" onblur="validateConfirmPassword(this)" title="Please confirm your Password."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="confirmPasswordMsg"></div>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="width-30pct">
                                                    First Name<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="firstName" id="firstName" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter first name."/>
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
                                                    <input type="text" name="lastName" id="lastName" title="Please enter last name."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="lastNameMsg"></div>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="width-30pct">
                                                    Address<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="address" id="address" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter address."/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="addressMsg"></div>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="width-30pct">
                                                    Email<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <input type="text" name="email" id="email" onkeypress="hideCustom(this)" onblur="validateRequired(this)" title="Please enter email."/>
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
                                                    <input type="text" name="mobile" id="mobile" title="Please enter contact." onkeypress="hideCustom(this)" onblur="validateContact(this)"/>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="mobileMsg"></div>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="width-30pct">
                                                    Role<span class="superscriptLike">*</span>
                                                </td>
                                                <td class="width-40pct">
                                                    <select id="role" name="role" title="Please select role." onchange="hideCustom(this)" onblur="validateRequired(this)">
                                                        <option value="">- Select Role -</option>
                                                        <c:forEach var="role" items="${roles}">
                                                            <option value="<c:out value='${role.roleId}'></c:out>"><c:out value="${role.role}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td class="width-30pct ">
                                                    <div id="roleMsg"></div>
                                                </td>
                                             </tr>
                                             <tr>
                                                 <td colspan="3">
                                                    &nbsp;
                                                </td>
                                             </tr>
                                             <tr>
                                                 <td colspan="3" class="align-center">
                                                     <input type="button" value="Register" id="register" onclick="doRegistration()"> &nbsp; &nbsp;
                                                     <input type="button" value="Cancel" id="cancel" onclick="doCancel()">
                                                </td>
                                             </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </c:if>
                        <c:if test="${not empty regStatus && regStatus.status == 0}">                                
                            <div id="registrationConfirmation" class="setVisible">
                                <div id="confirmationContent">
                                    <div class="inlineHead">
                                        Registration Done!
                                    </div>
                                    <p class="justify">
                                        Welcome to SkillCheck. A confirmation email has been sent to your registered email address <u><c:out value="${regEmail}"></c:out></u><br/>
                                        Please login to SkillCheck using your credentials.
                                    </p>
                                </div>
                            </div>
                        </c:if>
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

