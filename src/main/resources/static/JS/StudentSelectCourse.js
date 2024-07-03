function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    if (sidebar.style.left === "-290px") {
        sidebar.style.left = "0";
    } else {

        sidebar.style.left = "-290px";
    }

}

function switchHome (){
    window.location.href= "/StudentPanel";
}
function switchCoursesList(){
    window.location.href="/StudentPanel/StudentCoursesList";
}
function  switchSeeGPA(){
    window.location.href="/StudentPanel/StudentSeeGPA";

}
function switchSelectCourse(){
    window.location.href="/StudentPanel/StudentSelectCourse";
}
function LogOut(){
    $.ajax({
        type: "GET",
        url: "/StudentPanel/LogOut" ,
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

$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/StudentPanel/StudentSelectCourse/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#faculty1").text(result.faculty);
            $("#major1").text(result.major);
        },error(){
            console.log("error");
        }
    });
})