/* 
 * javascript file for user home page operations
 */

//Onload prepare home page of the user
window.onload = function(){
    prepareUserHome();
};

//Prepare Home function
function prepareUserHome(){
    var loggedInUser = JSON.parse(localStorage['loggedInUser']);
    if(loggedInUser !== null && loggedInUser !== undefined){
        
        //Set username and user details on the page
        setLoggedInUserOnHeader(loggedInUser.username);
        
        //Prepare Menu for logged in user
        setMenuForLoggedInUser(loggedInUser.detail, "administration");
        
        //Show categories
        showSubsection("categories");
        
    }else{
        openPage("index.html");
    }
}

function cancelCategoryAdd(){
    getElementById("categoriesForm").reset();
}

function doCategoryValidation(){
    var name = "" + getElementById("categoryName").value;
    if(name.trim() !== ""){
        return true;
    }else{
        return false;
    }
}

function addCategory(){
    if(!doCategoryValidation()){
        alert("Please enter mandatory fields.");
        return;
    }
    if(getElementById("catOperation").value === "edit"){
        var name = getElementById("categoryName").value;
        var row = getElementById(name);
        insertUpdateCategory(false, row.rowIndex);
        getElementById("categoriesForm").reset();
        writeCustomMessage("msgForCategory", "Category Updated Successfully!");
    }
    else{
        insertUpdateCategory(true, 0);
        getElementById("categoriesForm").reset();
        writeCustomMessage("msgForCategory", "Category Added Successfully!");
    }
    getElementById("catOperation").value = "add";
    getElementById("addUpdateCategory").innerHTML = "Add Category";
    getElementById("addUpdateCategoryBtn").value = "Add";
}

function doCategoryEdit(rowId){
    var cols = getElementById(rowId).cells;
    getElementById("categoryName").value = cols[0].innerHTML;
    getElementById("categoryName").readOnly = "readOnly";
    getElementById("categoryDescription").value = cols[1].innerHTML;
    getElementById("catOperation").value = "edit";
    getElementById("addUpdateCategory").innerHTML = "Edit Category";
    getElementById("addUpdateCategoryBtn").value = "Update";
}

function doCategoryDelete(rowId){
    if(confirm("Do you want to delete this category?")){
        getElementById(rowId).remove();
    }
}

function insertUpdateCategory(isAdd, index){
    var categoryTable = getElementById("categoryTable");
    if(isAdd){
        var categoryName = getElementById("categoryName").value;
        var length = categoryTable.rows.length;
        var row = categoryTable.insertRow(length - 1);
        row.id = categoryName;
        
        var cell  = row.insertCell(0);
        cell.innerHTML = getElementById("categoryName").value;
        
        var cell  = row.insertCell(1);
        cell.innerHTML = getElementById("categoryDescription").value;
        
        var cell  = row.insertCell(2);
        cell.innerHTML = '<a class="textLink" href="javascript:doCategoryEdit(\''+ categoryName + '\');">Edit</a>';
        
        var cell  = row.insertCell(3);
        cell.innerHTML = '<a class="textLink" href="javascript:doCategoryDelete(\''+ categoryName + '\');">Delete</a>';
    }
    else{
        var row = categoryTable.rows[index];
        row.cells[1].innerHTML = getElementById("categoryDescription").value;
    }
}

function createTableForCategory(){
    var tableString = '<table class="table-1-3 width-100pct"><tr class="tableHeader"><td class="tableHeaderDetail">Categories</td></tr></table>';
    tableString = tableString + '<table class="table-1-3  width-100pct" border="1" id="categoryTable">';
    tableString = tableString + '<tr><td class="columnHeader width-30pct">Name</td><td class="columnHeader width-50pct">Description</td><td class="columnHeader width-10pct">&nbsp;</td><td class="columnHeader width-10pct">&nbsp;</td></tr>';
    for (var key in categories) {
        var catDetails = categories[key];
        tableString = tableString + '<tr id="' + catDetails.name + '">';
        tableString = tableString + '<td>' + catDetails.name + '</td>';
        tableString = tableString + '<td>' + catDetails.description + '</td>';
        tableString = tableString + '<td><a class="textLink" href="javascript:doCategoryEdit(\''+ catDetails.name + '\');">Edit</a></td>';
        tableString = tableString + '<td><a class="textLink" href="javascript:doCategoryDelete(\''+ catDetails.name + '\');">Delete</a></td>';
        tableString = tableString + '</tr>';
    }
    tableString = tableString + '</table>';
    return tableString;
}

function showSubsection(sectionName){
    var sectionSelected = "" + sectionName + "Section";
    var menu = "" + sectionName + "Menu";
    var sections = new Array("categoriesSection", "usersSection");
    for(var index = 0; index < sections.length; index++){
        if(sections[index] === sectionSelected){
            getElementById(sectionSelected).className = "setVisible";
            getElementById(menu).className = "subMenuItem selectedMenu";
        }else{
            getElementById(sections[index]).className = "setHide";
            var xMenu = "" + sections[index].substring(0, sections[index].length - 7) + "Menu";
            getElementById(xMenu).className = "subMenuItem";
        }
    }
    
    if(sectionName === "categories"){
        var catTable = createTableForCategory();
        getElementById("categoriesDiv").innerHTML = catTable;
    }
    if(sectionName === "users"){
        var catTable = createTableForUsers();
        getElementById("usersDiv").innerHTML = catTable;
    }
}


function createTableForUsers(){
    var tableString = '<table class="table-1-3 width-100pct"><tr class="tableHeader"><td class="tableHeaderDetail">Users</td></tr></table>';
    tableString = tableString + '<table class="table-1-3  width-100pct" border="1" id="usersTable">';
    tableString = tableString + '<tr><td class="columnHeader width-10pct">Username</td><td class="columnHeader width-20pct">First Name</td><td class="columnHeader width-20pct">Last Name</td><td class="columnHeader width-10pct">Gender</td><td class="columnHeader width-20pct">Email</td><td class="columnHeader width-20pct">Contact</td></tr>';
    for (var key in userInfo) {
        var catDetails = userInfo[key];
        tableString = tableString + '<tr id="' + key + '">';
        tableString = tableString + '<td>' + key + '</td>';
        tableString = tableString + '<td>' + catDetails.firstName + '</td>';
        tableString = tableString + '<td>' + catDetails.lastName + '</td>';
        tableString = tableString + '<td>' + catDetails.gender + '</td>';
        tableString = tableString + '<td>' + catDetails.email + '</td>';
        tableString = tableString + '<td>' + catDetails.mobile + '</td>';
     //   tableString = tableString + '<td><a class="textLink" href="javascript:doCategoryEdit(\''+ catDetails.name + '\');">Edit</a></td>';
     //   tableString = tableString + '<td><a class="textLink" href="javascript:doCategoryDelete(\''+ catDetails.name + '\');">Delete</a></td>';
        tableString = tableString + '</tr>';
    }
    tableString = tableString + '</table>';
    return tableString;
}


