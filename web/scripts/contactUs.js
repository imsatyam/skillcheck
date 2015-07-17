/* 
 * Contact us related js
 */

function doQuerySubmit(){
    if(doValidate()){
        getElementById("contactForm").reset();
        getElementById("queryForm").className = "setHide";
        getElementById("queryConfirmSection").className = "setVisible";
    }else{
        alert("Please enter all the mandatory fields.");
    }
}

function doQueryClear(){
    getElementById("contactForm").reset();
}

function doValidate(){
    var userName = getElementById("name").value;
    var email = getElementById("email").value;
    var query = getElementById("query").value;
    if(userName.trim() !== "" && email.trim() !== "" && query.trim() !== ""){
        return true;
    }else{
        return false;
    }
}