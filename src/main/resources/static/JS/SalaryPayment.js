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
                window.location.href === "/Login";
            }
        },error(){
            console.log("error");
        }
    });
}

function fillTheTable(){
    var radif = 0;
    $.ajax({
        type: 'GET',
        url: '/Employee/Finance/SalaryPayment/ShowSalary',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success:function (result){
            result.forEach(function (item){
                radif += 1;
                console.log(item);
                var ID = item.userId;
                var tr = $('<tr>');
                tr.append('<td>' + radif + '</td>');
                $.ajax({
                    type: 'GET',
                    url: "/Employee/Finance/SalaryPayment/getTeacher?id=" + item.userId,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success:function (result){
                        console.log(result);
                        tr.append('<td>' + result.nameF +" "+ result.nameL + '</td>');
                        tr.append('<td>' + result.faculty + '</td>');
                        tr.append('<td>' + result.status + '</td>');
                        tr.append('<td>' + item.yearEd + '</td>');
                        tr.append('<td>' + item.semester + '</td>');
                        tr.append('<td>' + item.hoursTaught + '</td>');
                        tr.append('<td>' + item.salary + '</td>');
                        var button = $('<button>').text('Pay').click(function() {
                            PaySalary(ID);
                        }).addClass('button');
                        var tdWithButton = $('<td>').append(button);
                        tr.append(tdWithButton);
                    }
                });
                $('#myTable').append(tr);
            });
        }
    });
}

function PaySalary(ID){
    $.ajax({
        type: "Get",
        url: "/Employee/Finance/SalaryPayment/getTeacherSalary?id=" + ID ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            var teacherSalary = result;
            console.log(teacherSalary);
            if (result.salary === 0 && result.hoursTaught ===0){
                alert("Invalid salary");
            }else {
                $.ajax({
                    type: "Post",
                    url: "/Employee/Finance/SalaryPayment/UpdateSalary" ,
                    contentType: "application/json; charset=utf-8",
                    data : JSON.stringify(teacherSalary),
                    success: function (res){
                        console.log("Successful");
                    },error(){
                        console.log("error");
                    }
                });
            }
            },error(){
            console.log("error");
        }
    });
}

$(document).ready(function (){
    var dep = "";
    var role = "";
    $.ajax({
        type: "GET",
        url: "/Employee/Finance/SalaryPayment/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#department").text(result.department);
            $("#role").text(result.role);
            dep = $("#department").text();
            role = $("#role").text();
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

    fillTheTable();
})