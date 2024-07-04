function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    if (sidebar.style.left === "-290px") {
        sidebar.style.left = "0";
    } else {
        sidebar.style.left = "-290px";
    }

}
function switchHome(){
    window.location.href = "/AdminPanel";
}
function switchSelectPhase(){
    window.location.href = "/AdminPanel/AdminSelectPhase";
}
function switchManageStudents(){
    window.location.href = "/AdminPanel/AdminManageStudents";
}
function switchManageTeachers(){
    window.location.href = "/AdminPanel/AdminManageTeachers";
}
function switchManageEmployees(){
    window.location.href = "/AdminPanel/AdminManageEmployees";
}
function LogOut(){
    $.ajax({
        type: "GET",
        url: "/AdminPanel/LogOut" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            if (result === true){
                window.location.href = "/Login";
            }
        },error(){
            console.log("error");
        }
    });
}

