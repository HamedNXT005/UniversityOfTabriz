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
function switchManageStudents(){
    window.location.href = "/AdminPanel/AdminManageStudents";
}
function switchManageTeachers(){
    window.location.href = "/AdminPanel/AdminManageTeachers";
}
function switchManageEmployees(){
    window.location.href = "/AdminPanel/AdminManageEmployees";
}

function ShowCourses() {
    var radif = 0;
    $.ajax({
        type: 'GET',
        url: '/AdminPanel/AdminSelectPhase/SeePhases',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success:function (result){
            console.log(result);
            result.forEach(function (item){
                radif += 1;
                var ID = item.id;
                var tr = $('<tr>');
                tr.append('<td>' + radif + '</td>');
                tr.append('<td>' + item.id + '</td>');
                tr.append('<td>' + item.phaseName+ '</td>');
                var button = $('<button>').text('Active').click(function() {
                    Activate(ID);
                }).addClass('button');
                if (item.status === true){
                    button.text("Activate");
                    button.css("background-color" , "#ff0000");
                }else {
                    button.text("UnActivate");
                    button.css("background-color" , "#074172");
                }
                var tdWithButton = $('<td>').append(button);
                tr.append(tdWithButton);
                $('#myTable').append(tr);
            });
        }
    });
}
function Activate(ID){
    $.ajax({
        type: "Post",
        url: "/AdminPanel/AdminSelectPhase/UpdatePhase?id=" + ID ,
        contentType: "application/json; charset=utf-8",
        success: function (res){
            console.log("Successful");
        },error(){
            console.log("error");
        }
    });
    location.reload();
}
function LogOut(){
    $.ajax({
        type: "GET",
        url: "/AdminPanel/AdminSelectPhase/LogOut" ,
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

