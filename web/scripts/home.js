/* 
 * This file has the login related validations
 */

window.load = function(){
    getElementById("username").value = "User Name";
    getElementById("password").value = "Password";
};

//functions to show and hide legends - User Name and Password in login form.
function showLegend(element){
    var elementContent = element.value;
    if(elementContent === null || elementContent === undefined || elementContent.trim() === ""){
        if(element.id === "username"){
            element.value = "User Name";
        }else if(element.id === "password"){
            element.value = "password";
        }
    }
}
function hideLegend(element){
    if(element.value === null || element.value === "User Name" || element.value === "Password"){
        element.value = "";
    }
}

//Validate the login form before submission
function validateLoginForm(userName, password){
    var isUserNameEmpty = false;
    var isPasswordEmpty = false;
    var errorMessage = "";
    
    if(userName === null || userName === undefined || userName.trim() === "" || userName.trim() === "User Name"){
        isUserNameEmpty = true;
    }
    
    if(password === null || password === undefined || password.trim() === "" || password.trim() === "Password"){
        isPasswordEmpty = true;
    }
    
    if(isPasswordEmpty && isUserNameEmpty){
        errorMessage = "Please enter details.";
    }else if(isUserNameEmpty){
        errorMessage = "Please enter username";
    }else if(isPasswordEmpty){
        errorMessage = "Please enter password";
    }
    
    if(errorMessage !== ""){
        writeError(errorMessage);
        return false;
    }else{
        return true;
    }
    
}

//function to perform login operation
function doLogin(){
    
    //Get username and password
    var userName = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    
    //First perform validation of the form
    var isValidSubmit = validateLoginForm(userName, password);
    if(isValidSubmit){
        
        //get the form element, and submit it
        document.getElementById("loginForm").submit();
    }    
}


