/* 
 * javascript for profile page
 */
function doLaunch(examinationId){
    if(confirm("Do you want to launch this examination?")){
        document.getElementById("operation").value = 1;
        document.getElementById("examinationId").value = examinationId;
        document.getElementById("examinationForm").submit();
    }
}

function doOperation(operationId){
    document.getElementById("operation").value = operationId;
    if(operationId === 2){  //Begin Exam
        document.getElementById("examinationForm").submit();
    }
    if(operationId === 3){  //Cancel Exam
        document.getElementById("examinationForm").submit();
    }
    if(operationId === 4){  //Final Submit
        doExamSubmit(operationId);
    }
    if(operationId === 5){  //Return to exam page
        document.getElementById("operation").value = 3;
        document.getElementById("examinationForm").submit();
    }
}

function doExamSubmit(operationId){
    if(confirm("Do you want to submit the exam?")){
        document.getElementById("examinationForm").submit();
    }
}

function doCancel(){
    getElementById("tableDiv").className = "setVisible";
    getElementById("introductionDiv").className = "setHide";
}

function doBegin(rowId, examName){
    //Make the form div visible
    getElementById("introductionDiv").className = "setHide";
    getElementById("formDiv").className = "setVisible";
    
    getElementById("formExamName").innerHTML = examName;
    
    var row = "" + rowId;
    getElementById("examId").value = row.substring(1);
    
    var exam = examinations[parseInt(row.substring(1))];
    
    //Sanity
    marksObtained = 0;
    questionsAttempted = 0;
    incorrect = 0;
    correct = 0;
	isSkipped = false;
    skippedQuestions = new Array();
    positiveMarks = exam.eachQuestionMark;
    if(exam.negativeMarking.isNegative === "Y"){
        negativeMarks = exam.negativeMarking.minus;
    }else{
        negativeMarks = 0;
    }
    currentQuestion = null;
    doNext();
}

function processAnswer(){
    if(currentQuestion === null){
        return;
    }
    
    var answer = "";
    var options = document.getElementsByName("answer");
    for(var idx = 0; idx < options.length; idx++){
        if(options[idx].checked){
            answer = options[idx].value;
            break;
        }
    }
    answer = "" + answer;
    var correctAnswer = "" + currentQuestion.correctAnswer;
    if(answer === null || answer === undefined || answer === ""){
        //Question is considered as skipped
		if(!isSkipped){
			skippedQuestions.push(currentQuestion);
		}
        
    }else if(answer === correctAnswer){
        marksObtained = marksObtained + positiveMarks;
        correct = correct + 1;
    }else{
        marksObtained = marksObtained - negativeMarks;
        incorrect = incorrect + 1;
    }
}

function doNext(){
    var examId = getElementById("examId").value;
    var section = getElementById("section").value;
    var count = getElementById("count").value;
    var sectionCount = getElementById("sectionCount").value;
    
    //Get exam basics
    var exam = examinations[parseInt(examId)];
    
    //Get Concerned Variables
    var cats = exam.categories;
    var countPerCat = exam.questionsPerCategory;
    var totalCount = exam.numberOfQuestions;
    
    //Process current question
    processAnswer();
    
    if(section === "" || section === undefined){
        section = 0;
        getElementById("section").value = section;
    }
    if(count === "" || count === undefined){
        count = 0;
        getElementById("count").value = count;
    }
    if(sectionCount === "" || sectionCount === undefined){
        sectionCount = 0;
        getElementById("sectionCount").value = sectionCount;
    }
    
    if(parseInt(count) < totalCount){
        if(sectionCount < countPerCat){
            var questions = getQuestionsOfSection(cats[parseInt(getElementById("section").value)], countPerCat);
        }
        else{
            section = parseInt(section) + 1;
            sectionCount = 0;
            var questions = getQuestionsOfSection(cats[section], countPerCat);
        }
        displayQuestion(questions, sectionCount, count, section, cats);
    }else{
        if(skippedQuestions !== null && skippedQuestions.length > 0){
            var qstion = skippedQuestions.pop();
            displaySkippedQuestions(qstion);            
        }else{
            currentQuestion = null;
            alert("All questions done. Examination will be marked completed");
            performSubmissionTask();
        }
    }
}

function doFinish(){
    openPage("userHome.html");
}

function displayQuestion(questions, sectionCount, count, section, cats){
    getElementById("section").value = section;
    getElementById("sectionCount").value = parseInt(sectionCount) + 1;
    getElementById("count").value = parseInt(count) + 1;
    
    getElementById("questionNumber").innerHTML = parseInt(count) + 1;
    var question = questions[sectionCount];
    var cat = categories[cats[parseInt(section)]];
    
    getElementById("sectionName").innerHTML = cat.name;
    
    getElementById("question").innerHTML = question.question;
    getElementById("optionA").innerHTML = question.options.a;
    getElementById("optionB").innerHTML = question.options.b;
    getElementById("optionC").innerHTML = question.options.c;
    getElementById("optionD").innerHTML = question.options.d;
    
    var options = document.getElementsByName("answer");
    for(var idx = 0; idx < options.length; idx++){
        options[idx].checked = false;
    }
	isSkipped = false;
    currentQuestion = question;
}

function displaySkippedQuestions(qstion){
    getElementById("questionNumber").innerHTML = '<span style="color:#800517; font-weight: bold">Skipped</span>';
    getElementById("sectionName").innerHTML = '<span style="color:#800517; font-weight: bold">Skipped Questions</span>';
    getElementById("question").innerHTML = qstion.question;
    getElementById("optionA").innerHTML = qstion.options.a;
    getElementById("optionB").innerHTML = qstion.options.b;
    getElementById("optionC").innerHTML = qstion.options.c;
    getElementById("optionD").innerHTML = qstion.options.d;
    
    var options = document.getElementsByName("answer");
    for(var idx = 0; idx < options.length; idx++){
        options[idx].checked = false;
    }
	isSkipped = true;
    currentQuestion = question;
}

function doSubmit(){
    if(confirm("Do you really want to submit?")){
        performSubmissionTask();
    }
}

function performSubmissionTask(){
    processAnswer();
    getElementById("formDiv").className = "setHide";
    getElementById("resultDiv").className = "setVisible";
    var exam = examinations[parseInt(getElementById("examId").value)];
    getElementById("resultExamName").innerHTML = exam.name;
    
    questionsAttempted = incorrect + correct;
    getElementById("totalQuestions").innerHTML = exam.numberOfQuestions;
    getElementById("questionsAttempted").innerHTML = questionsAttempted;
    getElementById("correctCount").innerHTML = correct;
    getElementById("incorrectCount").innerHTML = incorrect;
    getElementById("maximumMarksPossible").innerHTML = exam.maximumMarks;
    getElementById("marksObtained").innerHTML = marksObtained;

    //Sanity
    marksObtained = 0;
    questionsAttempted = 0;
    incorrect = 0;
    correct = 0;
	isSkipped = false;
    skippedQuestions = new Array();
}

function getQuestionsOfSection(sectionId, count){
    var categoryQuestions = new Array();
    var index = 0;
    for(var key in questions){
        var qstn = questions[key];
        if(qstn.category === sectionId){
            if(index < count){
                categoryQuestions.push(qstn);
                index++;
            }else{
                break;
            }
        }
    }
    return categoryQuestions;
} 