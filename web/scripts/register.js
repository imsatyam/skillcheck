/* 
 * javascript for registration page
 */

function validateUserPresence(element){
    var isValid = true;
//    if(element.value !== null && element.value.trim() !== ""){
//        var elementId = element.id + "Msg";
//        if(users.indexOf(element.value) !== -1){
//            writeCustomError(elementId, "Username already taken.");
//            isValid = false; 
//        }else{
//            writeCustomMessage(elementId, "Username available.");
//            isValid = true;
//        }
//    }
    return isValid;
}

function validatePasswordConfirmation(element){
   var isValid = true;
   if(element.value !== null && element.value.trim() !== ""){
        var pwd = document.getElementById("password").value;
        var elementId = element.id + "Msg";
        if(element.value !== pwd){
            writeCustomError(elementId, "Password confirmation failed.");
            isValid = false;
        }else{
            writeCustomMessage(elementId, "Password confirmed.");
            isValid = true;
        }
    } 
    return isValid;
}

function validateContactNumber(element){
    var isValid = true;
    if(element.value !== null && element.value.trim() !== ""){
        var elementId = element.id + "Msg";
        if(isInvalidNumber(element.value)){
            writeCustomError(elementId, "Only integers allowed.");
            isValid = false;
        }
    } 
    return isValid;
}

function validateEmail(element){
    return true;
}

function validateUsername(element){
    var isValid = validateRequired(element);
    if(isValid){
        isValid = validateUserPresence(element);
    }
    return isValid;
}

function validateConfirmPassword(element){
    var isValid = validateRequired(element);
    if(isValid){
        isValid = validatePasswordConfirmation(element);
    }
    return isValid;
}

function validateEmail(element){
    var isValid = validateRequired(element);
    if(isValid){
        isValid = validateEmail(element);
    }
    return isValid;
}

function validateContact(element){
    var isValid = validateRequired(element);
    if(isValid){
        isValid = validateContactNumber(element);
    }
    return isValid;
}

function doCancel(){
    document.getElementById("registerForm").reset();
    document.getElementById("operation").value = 5;
    document.getElementById("registerForm").submit();
}

function doRegistration(){
    if(doValidation()){
        document.getElementById("operation").value = 1;
        document.getElementById("registerForm").submit();
    }
}

function doValidation(){
    var isValidSubmission = true;
    var inputElements = document.getElementsByTagName("input");
    if(inputElements !== null && inputElements.length > 0){
        for(var index = 0; index < inputElements.length; index++){
            if(inputElements[index].name === "username" && !validateUsername(inputElements[index])){
                isValidSubmission = false;
                break;
            }
            else if(inputElements[index].name === "confirmPassword" && !validateConfirmPassword(inputElements[index])){
                isValidSubmission = false;
                break;
            }
            else if(inputElements[index].name === "mobile" && !validateContact(inputElements[index])){
                isValidSubmission = false;
                break;
            }
            else{
                if(inputElements[index].name !== "lastName" && inputElements[index].name !== "operation"){
                    if(!validateRequired(inputElements[index])){
                        isValidSubmission = false;
                        break;
                    }
                }
                
            }
        }
    }
    return isValidSubmission;
}