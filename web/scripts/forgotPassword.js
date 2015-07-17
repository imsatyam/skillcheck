/* 
 * js for forgotpassword screen
 */

window.onload = function(){
    getElementById("usernameInput").value = "User Name";
};

function showLegend(element){
    var elementContent = element.value;
    if(elementContent === null || elementContent === undefined || elementContent.trim() === ""){
        if(element.id === "usernameInput"){
            element.value = "User Name";
        }
    }
}
function hideLegend(element){
    if(element.value === null || element.value === "User Name" || element.value === "Password"){
        element.value = "";
    }
}

function processForgotPassword(){
    var userName = getElementById("usernameInput").value;
    if(userName === null || userName === undefined || userName.trim() === "" || userName.trim() === "User Name"){
        writeError("Please enter username.")
    }else{
        document.getElementById("operation").value = 2;
        document.getElementById("forgotPasswordForm").submit();
    }
}

function clearMessages(){
    hideError();
    hideMessage();
}