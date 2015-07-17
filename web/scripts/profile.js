/* 
 * javascript for profile page
 */

function hideCustom(element){
    var elementId = element.id + "Msg";
    hideCustomError(elementId);
    hideCustomMessage(elementId);
}

function validateRequired(element){
    if(element.value !== null && element.value.trim() !== ""){
        return true;
    }else{
        var elementId = element.id + "Msg";
        writeCustomError(elementId, element.title);
        return false;
    }
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

function isInvalidNumber(value){
    value = "" + value;
    var isInvalid = false;
    var valArr = value.split("");
    if(valArr !== null && valArr.length > 0){
        for(var index = 0; index < valArr.length; index++){
            var val = "" + valArr[index];
            val = "" + parseInt(val);
            if(parseInt(val) === undefined || val === "NaN" || parseInt(val) === null){
                isInvalid = true;
                break;
            }
        }
    }
    return isInvalid;
}

function validateEmail(element){
    return true;
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
    document.getElementById("profileForm").reset();
    writeCustomMessage("msgDiv", "Profile information restored successfully!");
}

function doUpdate(){
    if(doValidation()){
        document.getElementById("operation").value = 2;
        document.getElementById("profileForm").submit();
    }
}

function doValidation(){
    var isValidSubmission = true;
    var inputElements = document.getElementsByTagName("input");
    if(inputElements !== null && inputElements.length > 0){
        for(var index = 0; index < inputElements.length; index++){
            
            if(inputElements[index].name === "mobile" && !validateContact(inputElements[index])){
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