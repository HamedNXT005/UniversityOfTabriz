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

function switchTList(){
    window.location.href = "/EmployeePanel/TeachersList";
}
function switchATeacher(){
    window.location.href = "/EmployeePanel/AddTeacher";
}
function switchSList(){
    window.location.href = "/EmployeePanel/StudentsList";
}
function switchAStudent(){
    window.location.href = "/EmployeePanel/AddStudent";
}
function switchAcademicalME(){
    window.location.href = "/EmployeePanel/AcademicalManageE";
}
function switchAcademicalSTList(){
    window.location.href = "/EmployeePanel/FacultyStudentsList";
}
function switchDeterminationCourses(){
    window.location.href = "/EmployeePanel/DeterminationTheCourses";
}
function switchManageTheDefinedCourses(){
    window.location.href = "/EmployeePanel/ManageDefinedCourses";
}
function LogOut(){
    $.ajax({
        type: "GET",
        url: "/EmployeePanel/LogOut" ,
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

function ShowDeterminationCourses(Role){
    if (Role === "computer"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/EmployeePanel/DeterminationTheCourses/getComputerCourses',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var ID = item.id;
                    var CID = item.courseId;
                    var TID = item.teacherId;
                    $.ajax({
                        type: 'GET',
                        url: '/EmployeePanel/DeterminationTheCourses/getCourseInfo?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/EmployeePanel/DeterminationTheCourses/getTInfo?id=' + TID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    console.log(result2);
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + item.id + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result2.nameF + " " + result2.nameL + '</td>');
                                    tr.append('<td>' + item.classN + '</td>');
                                    tr.append('<td>' + item.examDate + '</td>');
                                    var button = $('<button>').text('').click(function() {
                                        ManageCourses(CID , ID);
                                    }).addClass('button');
                                    if (item.status === true){
                                        button.text("Selected");
                                        button.css("background-color" , "#074172");
                                    }else {
                                        button.text("Not selected");
                                        button.css("background-color" , "#ff0000");
                                    }
                                    var tdWithButton = $('<td>').append(button);
                                    tr.append(tdWithButton);
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Role === "civil"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/EmployeePanel/DeterminationTheCourses/getCivilCourses',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var ID = item.id;
                    var CID = item.courseId;
                    var TID = item.teacherId;
                    $.ajax({
                        type: 'GET',
                        url: '/EmployeePanel/DeterminationTheCourses/getCourseInfo?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/EmployeePanel/DeterminationTheCourses/getTInfo?id=' + TID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    console.log(result2);
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + item.id + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result2.nameF + " " + result2.nameL + '</td>');
                                    tr.append('<td>' + item.classN + '</td>');
                                    tr.append('<td>' + item.examDate + '</td>');
                                    var button = $('<button>').text('').click(function() {
                                        ManageCourses(CID , ID);
                                    }).addClass('button');
                                    if (item.status === true){
                                        button.text("Selected");
                                        button.css("background-color" , "#074172");
                                    }else {
                                        button.text("Not selected");
                                        button.css("background-color" , "#ff0000");
                                    }
                                    var tdWithButton = $('<td>').append(button);
                                    tr.append(tdWithButton);
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Role === "chemistry"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/EmployeePanel/DeterminationTheCourses/getCHCourses',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var ID = item.id;
                    var CID = item.courseId;
                    var TID = item.teacherId;
                    $.ajax({
                        type: 'GET',
                        url: '/EmployeePanel/DeterminationTheCourses/getCourseInfo?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/EmployeePanel/DeterminationTheCourses/getTInfo?id=' + TID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    console.log(result2);
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + item.id + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result2.nameF + " " + result2.nameL + '</td>');
                                    tr.append('<td>' + item.classN + '</td>');
                                    tr.append('<td>' + item.examDate + '</td>');
                                    var button = $('<button>').text('').click(function() {
                                        ManageCourses(CID , ID);
                                    }).addClass('button');
                                    if (item.status === true){
                                        button.text("Selected");
                                        button.css("background-color" , "#074172");
                                    }else {
                                        button.text("Not selected");
                                        button.css("background-color" , "#ff0000");
                                    }
                                    var tdWithButton = $('<td>').append(button);
                                    tr.append(tdWithButton);
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Role === "electric"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/EmployeePanel/DeterminationTheCourses/getECourses',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var ID = item.id;
                    var CID = item.courseId;
                    var TID = item.teacherId;
                    $.ajax({
                        type: 'GET',
                        url: '/EmployeePanel/DeterminationTheCourses/getCourseInfo?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/EmployeePanel/DeterminationTheCourses/getTInfo?id=' + TID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    console.log(result2);
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + item.id + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result2.nameF + " " + result2.nameL + '</td>');
                                    tr.append('<td>' + item.classN + '</td>');
                                    tr.append('<td>' + item.examDate + '</td>');
                                    var button = $('<button>').text('').click(function() {
                                        ManageCourses(CID , ID);
                                    }).addClass('button');
                                    if (item.status === true){
                                        button.text("Selected");
                                        button.css("background-color" , "#074172");
                                    }else {
                                        button.text("Not selected");
                                        button.css("background-color" , "#ff0000");
                                    }
                                    var tdWithButton = $('<td>').append(button);
                                    tr.append(tdWithButton);
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Role === "mechanic"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/EmployeePanel/DeterminationTheCourses/getMCourses',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var ID = item.id;
                    var CID = item.courseId;
                    var TID = item.teacherId;
                    $.ajax({
                        type: 'GET',
                        url: '/EmployeePanel/DeterminationTheCourses/getCourseInfo?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/EmployeePanel/DeterminationTheCourses/getTInfo?id=' + TID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    console.log(result2);
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + item.id + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result2.nameF + " " + result2.nameL + '</td>');
                                    tr.append('<td>' + item.classN + '</td>');
                                    tr.append('<td>' + item.examDate + '</td>');
                                    var button = $('<button>').text('').click(function() {
                                        ManageCourses(CID , ID);
                                    }).addClass('button');
                                    if (item.status === true){
                                        button.text("Selected");
                                        button.css("background-color" , "#074172");
                                    }else {
                                        button.text("Not selected");
                                        button.css("background-color" , "#ff0000");
                                    }
                                    var tdWithButton = $('<td>').append(button);
                                    tr.append(tdWithButton);
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }
}

function ManageCourses(CID , ID) {
    $.ajax({
        type: "Post",
        url: "/EmployeePanel/DeterminationTheCourses/UpdateStatus?Cid=" + CID + "&id=" + ID ,
        contentType: "application/json; charset=utf-8",
        success: function (res){
            console.log("Successful");
        },error(){
            console.log("error");
        }
    });
    location.reload();
}


$(document).ready(function (){
    var dep = "";
    var role = "";
    $.ajax({
        type: "GET",
        url: "/EmployeePanel/DeterminationTheCourses/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#department").text(result.department);
            $("#role").text(result.role);
            dep = $("#department").text();
            role = $("#role").text();
            ShowDeterminationCourses(role);
        },error(){
            console.log("error");
        }
    });

    $.ajax({
        type: "GET",
        url: "/EmployeePanel/getPhase" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            if (result === 1){
                if (dep === "Finance"){
                    $("#salaryBtn").css("display", "block");
                    if (role === "Boss"){
                        $("#budgetBtn").css("display", "block");
                        $("#meBtn").css("display", "block");
                    }
                }
                else if(dep === "AcademicalAffairs"){
                    $("#seeTList").css("display", "block");
                    $("#ATeacher").css("display", "block");
                    $("#seeSList").css("display", "block");
                    $("#AStudent").css("display", "block");
                    if(role === "Boss"){
                        $("#academicMEBtn").css("display", "block");
                    }
                }
                else if (dep === "FacultyAcademical"){
                    $("#seeSListF").css("display", "block");
                    $("#DeterminationTheCourses").css("display", "block");
                    $("#ManageTheDefinedCourses").css("display", "block");
                }
            }
            else if(result === 2){
                if (dep === "Finance"){
                    $("#PsalaryPBtn").css("display", "block");
                    if (role === "Boss"){
                        $("#meBtn").css("display", "block");
                    }
                }else if(dep === "AcademicalAffairs"){
                    $("#seeTList").css("display", "block");
                    $("#seeSList").css("display", "block");
                    if(role === "Boss"){
                        $("#academicMEBtn").css("display", "block");
                    }
                }else if (dep === "FacultyAcademical"){
                    $("#seeSListF").css("display", "block");
                    $("#ManageTheDefinedCourses").css("display", "block");
                }
            }
            else if (result === 3){
                if (dep === "Finance"){
                    $("#PsalaryPBtn").css("display", "block");
                    if (role === "Boss"){
                        $("#meBtn").css("display", "block");
                    }
                }else if(dep === "AcademicalAffairs"){
                    $("#seeTList").css("display", "block");
                    $("#seeSList").css("display", "block");
                    if(role === "Boss"){
                        $("#academicMEBtn").css("display", "block");
                    }
                }else if (dep === "FacultyAcademical"){
                    $("#seeSListF").css("display", "block");
                }
            }
            else if(result === 4){
                if (dep === "Finance"){
                    $("#PsalaryPBtn").css("display", "block");
                    if (role === "Boss"){
                        $("#meBtn").css("display", "block");
                    }
                }else if(dep === "AcademicalAffairs"){
                    $("#seeTList").css("display", "block");
                    $("#seeSList").css("display", "block");
                    if(role === "Boss"){
                        $("#academicMEBtn").css("display", "block");
                    }
                }else if (dep === "FacultyAcademical"){
                    $("#seeSListF").css("display", "block");
                }
            }
        },error:function (){
            console.log("error");
        }
    });
})