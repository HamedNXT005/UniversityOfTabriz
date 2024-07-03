function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    if (sidebar.style.left === "-290px") {
        sidebar.style.left = "0";
    } else {
        sidebar.style.left = "-290px";
    }

}

$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/StudentPanel/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#nameF").text(result.nameF);
            $("#nameL").text(result.nameL);
            $("#faculty").text(result.faculty);
            $("#major").text(result.major);
            $("#nCode").text(result.nationalCode);
            $("#PNumber").text(result.phoneN);
            $("#semesterPassed").text(result.semestersPassed);
            $("#unitPassed").text(result.unitsPassed);
            $("#gpaTotal").text(result.gpaTotal);
            $("#gpaSemester").text(result.gpaSemester);
        },error(){
            console.log("error");
        }
    });
})