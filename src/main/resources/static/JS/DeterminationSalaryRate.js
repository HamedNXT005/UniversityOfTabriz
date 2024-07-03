function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    if (sidebar.style.left === "-290px") {
        sidebar.style.left = "0";
    } else {
        sidebar.style.left = "-290px";
    }

}
function switchHome(){
    window.location.href = "/EmployeePanel";
}
function switchDeterminationSalary(){
    window.location.href = "/Employee/Finance/DeterminationSalary";
}
function switchSalaryPeyment(){
    window.location.href = "/Employee/Finance/SalaryPayment";
}
function switchDeterminationTheBudget(){
    window.location.href = "/Employee/Finance/DeterminationBudget";
}
function switchManageEmployee(){
    window.location.href = "/Employee/Finance/ManageEmployee";
}
function LogOut(){
    $.ajax({
        type: "GET",
        url: "/EmployeePanel/LogOut" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            if (result === true){
                window.location.href === "/Login";
            }
        },error(){
            console.log("error");
        }
    });
}

$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/EmployeePanel/Finance/DeterminationSalary/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
        },error(){
            console.log("error");
        }
    });
})