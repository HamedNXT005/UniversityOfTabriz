function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    if (sidebar.style.left === "-290px") {
        sidebar.style.left = "0";
    } else {
        sidebar.style.left = "-290px";
    }

}

$(document).ready(function (){
    alert("Wellcome");
    $.ajax({
        type: "GET",
        url: "/TeacherPanel/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
        },error(){
            console.log("error");
        }
    });
})