function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    if (sidebar.style.left === "-290px") {
        sidebar.style.left = "0";
    } else {
        sidebar.style.left = "-290px";
    }

}
function switchHome(){
    window.location.href = "/TeacherPanel";
}
function switchRegisterGrades(){
    window.location.href = "/TeacherPanel/TeacherRegisterGrades";
}
function switchRegisterDailyReport(){
    window.location.href = "/TeacherPanel/TeacherRegisterDailyReport";
}
function switchListofStudents(){
    window.location.href = "/TeacherPanel/TeacherListOfStudents";
}
function switchChooseCourses(){
    window.location.href = "/TeacherPanel/TeacherListOfStudents";
}
function LogOut(){
    $.ajax({
        type: "GET",
        url: "/TeacherPanel/LogOut" ,
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

function ShowCourses(ID) {
    var radif = 0;
    $.ajax({
        type: 'GET',
        url: '/TeacherPanel/TeacherSalaryPayment/GetPDF?id=' + ID,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success:function (result){
            console.log(result);
            result.forEach(function (item){
                var CID = item.id;
                radif += 1;
                console.log(item);
                var tr = $('<tr>');
                tr.append('<td>' + radif + '</td>');
                tr.append('<td>' + item.id + '</td>');
                tr.append('<td>' + item.salary + '</td>');
                tr.append('<td>' + item.payment_date + '</td>');
                var button = $('<button>').text('Get PDF').click(function() {
                    getPDF(ID , CID);
                }).addClass('button');
                var tdWithButton = $('<td>').append(button);
                tr.append(tdWithButton);
                $('#myTable').append(tr);
            });
        }
    });
}
function getPDF(ID , HID){
    console.log(ID + " " + HID);
    $.ajax({
        type: "GET",
        url: "/TeacherPanel/TeacherSalaryPayment/exportPdf?tId=" + ID +"&hId=" + HID ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){

        },error(){
            console.log("error");
        }
    });
}
$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/TeacherPanel/TeacherSalaryPayment/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#faculty1").text(result.faculty);
            $("#status1").text(result.status);
            var ID = result.id;
            console.log(ID)
            ShowCourses(ID);
        },error(){
            console.log("error");
        }
    });
})