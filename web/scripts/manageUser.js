/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function doDelete(userId){
    if(confirm("Do you want to deactivate this user?")){
        document.getElementById("userId").value = userId;
        document.getElementById("operation").value = 1;
        document.getElementById("manageUserForm").submit();
    }
}


