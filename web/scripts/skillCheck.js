//Error related functions
function hideError(){
    document.getElementById("errorText").innerHTML = "";
    document.getElementById("errorText").className = "clearError";
}

//function to write error message
function writeError(errorMessage){
    document.getElementById("errorText").innerHTML = errorMessage + "<br/>";
    document.getElementById("errorText").className = "error";
}

function hideCustomError(elementId){
    document.getElementById(elementId).innerHTML = "";
    document.getElementById(elementId).className = "clearError";
}

//function to write error message
function writeCustomError(elementId, errorMessage){
    document.getElementById(elementId).innerHTML = errorMessage + "<br/>";
    document.getElementById(elementId).className = "error";
}

//function to write error message
function writeMessage(message){
    document.getElementById("messageSection").innerHTML = message + "<br/>";
    document.getElementById("messageSection").className = "message";
}

//function to write error message
function hideMessage(){
    document.getElementById("messageSection").innerHTML = "";
    document.getElementById("messageSection").className = "noMessage";
}

//function to write error message
function writeCustomMessage(elementId, message){
    document.getElementById(elementId).innerHTML = message + "<br/>";
    document.getElementById(elementId).className = "message";
}

//function to write error message
function hideCustomMessage(elementId){
    document.getElementById(elementId).innerHTML = "";
    document.getElementById(elementId).className = "noMessage";
}

//function to get an element by Id
function getElementById(id){
    return document.getElementById(id);
}

function doLogout(){
    document.getElementById("logoutForm").submit();
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

function validateRequired(element){
    if(element.value !== null && element.value.trim() !== ""){
        return true;
    }else{
        var elementId = element.id + "Msg";
        writeCustomError(elementId, element.title);
        return false;
    }
}

function validateRequiredNumber(element){
    if(element.value !== null && element.value.trim() !== ""){
        if(isInvalidNumber(element.value)){
            var elementId = element.id + "Msg";
            writeCustomError(elementId, "Only positive integers allowed.");
            return false;
        }
        return true;
    }else{
        var elementId = element.id + "Msg";
        writeCustomError(elementId, element.title);
        return false;
    }
}

function hideCustom(element){
    var elementId = element.id + "Msg";
    hideCustomError(elementId);
    hideCustomMessage(elementId);
}