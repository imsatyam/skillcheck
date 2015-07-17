/* 
 * This javascript file has the script for questions categories etc.
 */


/* First Define categories */
var categories = {
    1: {
        "name": "Physics",
        "description": "This section has questions on Physics"        
       },
    2: {
        "name": "Chemistry",
        "description": "This section has questions on Chemistry"        
       },
    3: {
        "name": "Biology",
        "description": "This section has questions on Biology"        
       },
    4: {
        "name": "English",
        "description": "This section has questions on English"        
       },
    5: {
        "name": "General Awareness",
        "description": "This section has questions on General Awareness. This includes questions on History, Civics, Geography, Polity, Economics"        
       },
    6: {
        "name": "Web Programming",
        "description": "This section has questions on HTML and javascript"        
       },
    7: {
        "name": "Programming And OOP Concept",
        "description": "This section has questions on programming languages like C, C++ and Java"        
       },
    8: {
        "name": "Quantitative Aptitude",
        "description": "This section has questions on quantitative aptitude"        
       }
};

/* Define questions  */
var questions = {
    1 : {
            "question": "Which instrument is used to measure depth of ocean",
            "options":  {
                            a: "Galvanometer",
                            b: "Flux meter",        
                            c: "Endoscope",
                            d: "Fathometer"
                        },
             "category": 1,
             "correctAnswer":"d"
        },
     2 : {
            "question": "Nuclear sizes are expressed in a unit named",
            "options":  {
                            a: "Fermi",
                            b: "angstrom",        
                            c: "newton",
                            d: "tesla"
                        },
             "category": 1,
             "correctAnswer":"a"
        },
	3 :	 {
            "question": "Light year is a unit of",
            "options":  {
                            a: "time",
                            b: "distance",        
                            c: "light",
                            d: "intensity of light"
                        },
             "category": 1,
             "correctAnswer":"b"
		 },
    4 : {
            "question": "Light from the sun reaches us in nearly",
            "options":  {
                            a: "2 minutes",
                            b: "4 minutes",        
                            c: "8 minutes",
                            d: "16 minutes"
                        },
             "category": 1,
             "correctAnswer":"c"
		 },
    5 : {
            "question": "The nucleus of an atom consist of",
            "options":  {
                            a: "electrons and neutrons",
                            b: "electrons and protons",        
                            c: "protons and neutrons",
                            d: "All of the above"
                        },
             "category": 2,
             "correctAnswer":"c"
     	 },
    6 : {
            "question": "The number of moles of solute present in 1 kg of a solvent is called its",
            "options":  {
                            a: "molality",
                            b: "molarity",        
                            c: "normality",
                            d: "formality"
                        },
             "category": 2,
             "correctAnswer":"a"	
         },
    7 : {
            "question": "The most electronegative element among the following is",
            "options":  {
                            a: "sodium",
                            b: "bromine",        
                            c: "fluorine",
                            d: "oxygen"
                        },
             "category": 2,
             "correctAnswer":"c"	
         },
    8 : {
            "question": "Plants receive the nutrients mainly from",
            "options":  {
                            a: "chlorophyll",
                            b: "atmosphere",        
                            c: "light",
                            d: "soil"
                        },
             "category": 3,
             "correctAnswer":"d"	
         },
    9 : {
            "question": "Movement of cell against concentration gradient is called",
            "options":  {
                            a: "osmosis",
                            b: "active transport",        
                            c: "diffusion",
                            d: "passive transport"
                        },
             "category": 3,
             "correctAnswer":"b"	
         },
    10 : {
            "question": "Plants synthesis protein from",
            "options":  {
                            a: "starch",
                            b: "sugar",        
                            c: "amino acid",
                            d: "fatty acids"
                        },
             "category": 3,
             "correctAnswer":"c"	
         },
    11 : {
            "question": "Identify the writter who first used blank verse in english poetry",
            "options":  {
                            a: "Sir Thomas Wyatt",
                            b: "William Shakespeare",        
                            c: "Earl of Surrey",
                            d: "Milton"
                        },
             "category": 4,
             "correctAnswer":"c"
         },
    12 : {
            "question": "The term 'the Palliser Novels' is used to describe the political novel of",
            "options":  {
                            a: "Charles Dickens",
                            b: "Anthony Trollope",        
                            c: "W.H. White",
                            d: "B. Disraeli"
                        },
             "category": 4,
             "correctAnswer":"b"	
         },
    13 : {
            "question": "The Battle of Plassey was fought in ",
            "options":  {
                            a: "1757",
                            b: "1782",        
                            c: "1748",
                            d: "1764"
                        },
             "category": 5,
             "correctAnswer":"a"		
         },
    14 : {
            "question": "The system of competitive examination for civil service was accepted in principle in the year",
            "options":  {
                            a: "1833",
                            b: "1853",        
                            c: "1858",
                            d: "1882"
                        },
             "category": 5,
             "correctAnswer":"b"
         },
    15 : {
            "question": "The trident-shaped symbol of Buddhism does  not represent",
            "options":  {
                            a: "Nirvana",
                            b: "Sangha",        
                            c: "Buddha",
                            d: "Dhamma"
                        },
             "category": 5,
             "correctAnswer":"a"	
         },
    16 : {
            "question": "What is the return type of script tag",
            "options":  {
                            a: "File I/O",
                            b: "Minify JavaScript",        
                            c: "HTTP Request",
                            d: "Gzip encoded"
                        },
             "category": 6,
             "correctAnswer":"c"	
         },
    17 : {
            "question": "The Closure Compiler was introduced by",
            "options":  {
                            a: "Microsoft",
                            b: "Apple",        
                            c: "Google",
                            d: "None of these"
                        },
             "category": 6,
             "correctAnswer":"c"		
         },
    18 : {
            "question": "Which of the following type of class allows only one object of it to be created",
            "options":  {
                            a: "virtual class",
                            b: "Abstract class",        
                            c: "Singleton class",
                            d: "Friend class"
                        },
             "category": 7,
             "correctAnswer":"c"
         },
    19 : {
            "question": "Which of the following is not the member of class",
            "options":  {
                            a: "Static function",
                            b: "Const function",        
                            c: "Friend function",
                            d: "Virtual function"
                        },
             "category": 7,
             "correctAnswer":"c"	
         },
    20 : {
            "question": "Which of the following is not a type of constructor",
            "options":  {
                            a: "Copy constructor",
                            b: "Friend constructor",        
                            c: "Default constructor",
                            d: "Parameterized constructor"
                        },
             "category": 7,
             "correctAnswer":"b"
		 },
     21 : {
            "question": "A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour ?",
            "options":  {
                            a: "3.6",
                            b: "7.2",        
                            c: "8.4",
                            d: "10"
                        },
             "category": 8,
             "correctAnswer":"b"
         },
     22 : {
            "question": "The percentage increase in the area of a rectangle , if each of its sides is increased by 20% is :",
            "options":  {
                            a: "40%",
                            b: "42%",        
                            c: "44%",
                            d: "46%"
                        },
             "category": 8,
             "correctAnswer":"c"	
         }			 
};

/* define available examinations */

var examinations = {
        1 : {
            "name" : "ABC - Recruitment Examination",
            "description" : "This examination is for placement in ABC",
            "categories" :[8, 4, 7, 5, 6],
            "numberOfQuestions":10,
            "maximumMarks" : 40,
            "negativeMarking":{
                                "isNegative" : "Y",
                                "minus" : "1"
                              },
            "eachQuestionMark" : 4,
            "timeLimitInMinutes" : "30",
            "questionsPerCategory": "2"
        }		
};

var menu = {
    "Admin" : [
            {
                "label" : "Manage Profile",
                "url"   : "manageProfile.html"
            },
            {
                "label" : "Administration",
                "url"   : "administration.html"
            },
            {
                "label" : "Manage Examinations",
                "url"   : "manageExaminations.html"
            },
            {
                "label" : "Report",
                "url"   : "reports.html"
            }
    ],
    
    "Examiner" : [
            {
                "label" : "Manage Profile",
                "url"   : "manageProfile.html"
            },
            {
                "label" : "Manage Examinations",
                "url"   : "manageExaminations.html"
            },
            {
                "label" : "Report",
                "url"   : "reports.html"
            }
    ],
         
    "Examinee" : [
            {
                "label" : "Manage Profile",
                "url"   : "manageProfile.html"
            },
            {
                "label" : "Examinations",
                "url"   : "examinations.html"
            },
            {
                "label" : "Report",
                "url"   : "reports.html"
            }
    ]
     
};

function setMenuForLoggedInUser(details, selectedPage){
    //Generate menu List
    var menuList = generateDivElement("menuList");
    
    //Home
    var divEl = generateDivElement("home", "menuItem");
    var linkEl = generateAnchor("menuLink", "Home", "javascript:doAction('home')");
    divEl.appendChild(linkEl);
    menuList.appendChild(divEl);
    
    //Manage Profile
    divEl = generateDivElement("profile", "menuItem");
    linkEl = generateAnchor("menuLink", "Profile", "javascript:doAction('editProfile')");
    divEl.appendChild(linkEl);
    menuList.appendChild(divEl);
    
    if(details.role === "Examinee"){
        
        //Examination
        divEl = generateDivElement("examination", "menuItem");
        linkEl = generateAnchor("menuLink", "Examinations", "javascript:doAction('examination')");
        divEl.appendChild(linkEl);
        menuList.appendChild(divEl);
        
        //Report
    /*    divEl = generateDivElement("report", "menuItem");
        linkEl = generateAnchor("menuLink", "Report", "javascript:doReport('Examinee')");
        divEl.appendChild(linkEl);
        menuList.appendChild(divEl);
    */    
    }
    else if(details.role === "Examiner"){
        
        //Manage Examination
        divEl = generateDivElement("manageExamination", "menuItem");
        linkEl = generateAnchor("menuLink", "Manage Examinations", "javascript:doAction('manageExamination')");
        divEl.appendChild(linkEl);
        menuList.appendChild(divEl);
        
        //Report
     /*   divEl = generateDivElement("report", "menuItem");
        linkEl = generateAnchor("menuLink", "Report", "javascript:doReport('Examiner')");
        divEl.appendChild(linkEl);
        menuList.appendChild(divEl);
     */   
    }else if(details.role === "Admin"){
        
        //Administration
        divEl = generateDivElement("administration", "menuItem");
        linkEl = generateAnchor("menuLink", "Administration", "javascript:doAction('administration')");
        divEl.appendChild(linkEl);
        menuList.appendChild(divEl);
        
        //Report
    /*    divEl = generateDivElement("report", "menuItem");
        linkEl = generateAnchor("menuLink", "Report", "javascript:doReport('Admin')");
        divEl.appendChild(linkEl);
        menuList.appendChild(divEl);
    */    
    }
    getElementById("menu").appendChild(menuList);
    
    var labelText = "";
    if(selectedPage === "home"){
        labelText = "Home";
    }
    else if(selectedPage === "profile"){
        labelText = "Profile";
    }
    else if(selectedPage === "administration"){
        labelText = "Administration";
    }
    else if(selectedPage === "examination"){
        labelText = "Examinations";
    }
    else if(selectedPage === "report"){
        labelText = "Report";
    }
    else if(selectedPage === "manageExamination"){
        labelText = "Manage Examination";
    }
    var spanEl = generateSpanElement("selected", labelText);
    getElementById(selectedPage).innerHTML = "";
    getElementById(selectedPage).appendChild(spanEl);
}

function generateDivElement(id, className){
    var el = document.createElement("div");
    el.setAttribute("id", id);
    if(className !== ""){
        el.setAttribute("class", className);
    }
    return el;
}

function generateSpanElement(className, text){
    var el = document.createElement("span");
    el.setAttribute("class", className);
    el.innerHTML = text;
    return el;
}

function generateAnchor(className, label, url){
    var el = document.createElement("a");
    el.setAttribute("class", className);
    el.href = url;
    el.innerHTML = label;
    return el;
}

function doAction(value){
    if(value === "home"){
        openPage("userHome.html");
    }
    else if(value === "editProfile"){
        openPage("profile.html");
    }
    else if(value === "administration"){
        openPage("administration.html");
    }
    else if(value === "manageExamination"){
        openPage("manageExamination.html");
    }
    else if(value === "examination"){
        openPage("examination.html");
    }
}


