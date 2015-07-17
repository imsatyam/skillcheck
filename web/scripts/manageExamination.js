/* 
 * javascript file for user home page operations
 */

function doOperation(value){
    if(value === 1){
        document.getElementById("operation").value = 1;
        document.getElementById("examinationId").value = 0;
        doFormSubmit();
    }
    if(value === 2){
        doExaminationEdit(value);
    }
    if(value === 3){
        doExamSaveAndDisplayQuestion(value);
    }
    if(value === 4){
        doQuestionSaveAndDisplayQuestion(value);
    }
    if(value === 5){
        doQuestionDelete(value);
    }
    if(value === 6){
        doExaminationDelete(value);
    }
    if(value === 7){
        doExaminationSave(value);
    }
    if(value === 8){
        doExaminationCancel();
    }
    if(value === 9){
        doQuestionEdit(value);
    }
    if(value === 10){
        doCancelQuestionEdit();
    }
}

function doCancelQuestionEdit(){
    document.getElementById("manageExaminationForm").reset();
    document.getElementById("addSection").style.display = "none";    
    if(document.getElementById("topButtonSection")){
        document.getElementById("topButtonSection").style.display = "block";
    }
}

function doExaminationEdit(opValue){
    var checkboxes = document.getElementsByName("examCheckbox");
    var isValidEdit = false;
    var errorMessage = "Please select an examination to edit.";
    var checkBox;
    if(checkboxes !== null && checkboxes !== undefined && checkboxes.length > 0){
        var index = 0;
        var selectCount = 0;
        for(index = 0; index < checkboxes.length; index++){
            if(checkboxes[index].checked){
                selectCount = selectCount + 1;
                if(selectCount > 1){
                    isValidEdit = false;
                    errorMessage = "Please select only one examination to edit.";
                    break;
                }
                else{
                    checkBox = checkboxes[index];
                    isValidEdit = true;
                }
            }
        } 
    }
    
    if(isValidEdit){
        var examinationId = checkBox.value;
        document.getElementById("examinationId").value = examinationId;
        document.getElementById("operation").value = opValue;
        doFormSubmit();
    }else{
        alert(errorMessage);
    }
}

function doQuestionEdit(opValue){
    var checkboxes = document.getElementsByName("questionCheckbox");
    var isValidEdit = false;
    var errorMessage = "Please select a question to edit.";
    var checkBox;
    if(checkboxes !== null && checkboxes !== undefined && checkboxes.length > 0){
        var index = 0;
        var selectCount = 0;
        for(index = 0; index < checkboxes.length; index++){
            if(checkboxes[index].checked){
                selectCount = selectCount + 1;
                if(selectCount > 1){
                    isValidEdit = false;
                    errorMessage = "Please select only one question to edit.";
                    break;
                }
                else{
                    checkBox = checkboxes[index];
                    isValidEdit = true;
                }
            }
        } 
    }
    
    if(isValidEdit){
        var examinationId = checkBox.value;
        document.getElementById("questionId").value = examinationId;
        document.getElementById("operation").value = opValue;
        doFormSubmit();
    }else{
        alert(errorMessage);
    }
}

function doExaminationCancel(){
    document.getElementById("operation").value = 6;
    doFormSubmit();
}

function doExaminationCancelWhileEditing(opValue){
    document.getElementById("operation").value = opValue;
    doFormSubmit();
}

function doExaminationSave(opValue){
    document.getElementById("operation").value = opValue;
    doFormSubmit();
}

function doExaminationDelete(opValue){
    var checkboxes = document.getElementsByName("examCheckbox");
    var isValidEdit = false;
    var examinationId = "";
    var errorMessage = "Please select an examination to delete.";
    if(checkboxes !== null && checkboxes !== undefined && checkboxes.length > 0){
        var index = 0;
        for(index = 0; index < checkboxes.length; index++){
            if(checkboxes[index].checked){
                isValidEdit = true;
                examinationId = examinationId + checkboxes[index].value;
                if(index < checkboxes.length - 1){
                    examinationId = examinationId + ";;;";
                }
            }
        } 
    }
    
    if(isValidEdit){
        if(confirm("Do you want to delete the examination(s)?")){
            document.getElementById("examinationId").value = examinationId;
            document.getElementById("operation").value = opValue;
            doFormSubmit();
        }
    }else{
        alert(errorMessage);
    }
}

function doQuestionDelete(opValue){
    var checkboxes = document.getElementsByName("questionCheckbox");
    var isValidEdit = false;
    var questionId = "";
    var errorMessage = "Please select a question to delete.";
    if(checkboxes !== null && checkboxes !== undefined && checkboxes.length > 0){
        var index = 0;
        for(index = 0; index < checkboxes.length; index++){
            if(checkboxes[index].checked){
                isValidEdit = true;
                questionId = questionId + checkboxes[index].value;
                if(index < checkboxes.length - 1){
                    questionId = questionId + ";;;";
                }
            }
        } 
    }
    
    if(isValidEdit){
        if(confirm("Do you want to delete the question(s)?")){
            document.getElementById("questionId").value = questionId;
            document.getElementById("operation").value = opValue;
            doFormSubmit();
        }
    }else{
        alert(errorMessage);
    }
}

function doFormSubmit(){
    document.getElementById("manageExaminationForm").submit();
}

function doExamSaveAndDisplayQuestion(opValue){
    if(doValidateExamSave()){
        document.getElementById("operation").value = opValue;
        document.getElementById("manageExaminationForm").submit();
    }
}

function doValidateExamSave(){
    var isValidSubmission = true;
    var inputElements = document.forms["manageExaminationForm"].getElementsByTagName("input");
    if(inputElements !== null && inputElements.length > 0){
        for(var index = 0; index < inputElements.length; index++){
            if(inputElements[index].name === "examinationName"){
                if(!validateRequired(inputElements[index])){
                    isValidSubmission = false;
                    break;
                }
            }
            else{
                if(inputElements[index].name !== "examinationId" && inputElements[index].name !== "operation" && inputElements[index].name !== "editScenario"){
                    if(!validateRequiredNumber(inputElements[index])){
                        isValidSubmission = false;
                        break;
                    }
                }
                
            }
        }
    }
    return isValidSubmission;
}

function doQuestionSaveAndDisplayQuestion(opValue){
    if(doValidateQuestionSave()){
        document.getElementById("operation").value = opValue;
        document.getElementById("manageExaminationForm").submit();
    }
}

function doValidateQuestionSave(){
    var isValidSubmission = true;
    var inputElements = document.forms["manageExaminationForm"].getElementsByTagName("input");
    if(inputElements !== null && inputElements.length > 0){
        for(var index = 0; index < inputElements.length; index++){
            if(inputElements[index].name !== "examinationId" && inputElements[index].name !== "questionId" && inputElements[index].name !== "editScenario" && inputElements[index].name !== "operation" && inputElements[index].id !== "addUpdateQuestionBtn"){
                if(!validateRequired(inputElements[index])){
                    isValidSubmission = false;
                    break;
                }
            }
        }
    }
    return isValidSubmission;
}

