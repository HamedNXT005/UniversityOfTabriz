var CourseIDs = [];

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
function switchSalaryPayment(){
    window.location.href = "/TeacherPanel/TeacherSalaryPayment";
}
function switchRegisterDailyReport(){
    window.location.href = "/TeacherPanel/TeacherRegisterDailyReport";
}
function switchListOfStudents(){
    window.location.href = "/TeacherPanel/TeacherListOfStudents";
}
function switchRegisterGrades(){
    window.location.href = "/TeacherPanel/TeacherRegisterGrades";
}
function switchChooseCourses(){
    window.location.href = "/TeacherPanel/TeacherChooseCourses";
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
function ShowCourses(Faculty , Teacher){
    if (Faculty === "computer"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/TeacherPanel/TeacherChooseCourses/getPreCoursesComputer?teacher=' + Teacher,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                console.log(result)
                result.forEach(function (item){
                    radif += 1;
                    console.log(item);
                    var ID = item.id;
                    var tr = $('<tr>');
                    tr.append('<td>' + radif + '</td>');
                    tr.append('<td>' + item.courseId + '</td>');
                    tr.append('<td>' + item.classN + '</td>');
                    tr.append('<td>' + item.examDate + '</td>');
                    var button = $('<button>').text('Select').click(function() {
                        selectCourse(ID);
                        button.css('background-color' , "#00ff00");
                        button.text("Selected");
                    }).addClass('button');
                    var tdWithButton = $('<td>').append(button);
                    tr.append(tdWithButton);

                    $('#myTable').append(tr);
                });
            }
        });
        var trl = $('<tr>');
        var button = $('<button>').text('Submit').click(function() {
            SubmitCourses();
        }).addClass('button');
        var tdWithButton = $('<td colspan="5" style="align-items: center">').append(button);
        trl.append(tdWithButton);
        $('#myTable').append(trl);
    }else if (Faculty === "civil"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/TeacherPanel/TeacherChooseCourses/getPreCoursesCivil?teacher=' + Teacher,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                console.log(result)
                result.forEach(function (item){
                    radif += 1;
                    console.log(item);
                    var ID = item.id;
                    var tr = $('<tr>');
                    tr.append('<td>' + radif + '</td>');
                    tr.append('<td>' + item.courseId + '</td>');
                    tr.append('<td>' + item.classN + '</td>');
                    tr.append('<td>' + item.examDate + '</td>');
                    var button = $('<button>').text('Select').click(function() {
                        selectCourse(ID);
                        button.css('background-color' , "#00ff00");
                        button.text("Selected");
                    }).addClass('button');
                    var tdWithButton = $('<td>').append(button);
                    tr.append(tdWithButton);

                    $('#myTable').append(tr);
                });
            }
        });
        var trl = $('<tr>');
        var button = $('<button>').text('Submit').click(function() {
            SubmitCourses();
        }).addClass('button');
        var tdWithButton = $('<td colspan="5" style="align-items: center">').append(button);
        trl.append(tdWithButton);
        $('#myTable').append(trl);
    }else if (Faculty === "chemistry"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/TeacherPanel/TeacherChooseCourses/getPreCoursesChemistry?teacher=' + Teacher,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                console.log(result)
                result.forEach(function (item){
                    radif += 1;
                    console.log(item);
                    var ID = item.id;
                    var tr = $('<tr>');
                    tr.append('<td>' + radif + '</td>');
                    tr.append('<td>' + item.courseId + '</td>');
                    tr.append('<td>' + item.classN + '</td>');
                    tr.append('<td>' + item.examDate + '</td>');
                    var button = $('<button>').text('Select').click(function() {
                        selectCourse(ID);
                        button.css('background-color' , "#00ff00");
                        button.text("Selected");
                    }).addClass('button');
                    var tdWithButton = $('<td>').append(button);
                    tr.append(tdWithButton);

                    $('#myTable').append(tr);
                });
            }
        });
        var trl = $('<tr>');
        var button = $('<button>').text('Submit').click(function() {
            SubmitCourses();
        }).addClass('button');
        var tdWithButton = $('<td colspan="5" style="align-items: center">').append(button);
        trl.append(tdWithButton);
        $('#myTable').append(trl);
    }else if (Faculty === "electric"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/TeacherPanel/TeacherChooseCourses/getPreCoursesElectric?teacher=' + Teacher,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                console.log(result)
                result.forEach(function (item){
                    radif += 1;
                    console.log(item);
                    var ID = item.id;
                    var tr = $('<tr>');
                    tr.append('<td>' + radif + '</td>');
                    tr.append('<td>' + item.courseId + '</td>');
                    tr.append('<td>' + item.classN + '</td>');
                    tr.append('<td>' + item.examDate + '</td>');
                    var button = $('<button>').text('Select').click(function() {
                        selectCourse(ID);
                        button.css('background-color' , "#00ff00");
                        button.text("Selected");
                    }).addClass('button');
                    var tdWithButton = $('<td>').append(button);
                    tr.append(tdWithButton);

                    $('#myTable').append(tr);
                });
            }
        });
        var trl = $('<tr>');
        var button = $('<button>').text('Submit').click(function() {
            SubmitCourses();
        }).addClass('button');
        var tdWithButton = $('<td colspan="5" style="align-items: center">').append(button);
        trl.append(tdWithButton);
        $('#myTable').append(trl);
    }else if (Faculty === "mechanic"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/TeacherPanel/TeacherChooseCourses/getPreCoursesMechanic?teacher=' + Teacher,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                console.log(result)
                result.forEach(function (item){
                    radif += 1;
                    console.log(item);
                    var ID = item.id;
                    var tr = $('<tr>');
                    tr.append('<td>' + radif + '</td>');
                    tr.append('<td>' + item.courseId + '</td>');
                    tr.append('<td>' + item.classN + '</td>');
                    tr.append('<td>' + item.examDate + '</td>');
                    var button = $('<button>').text('Select').click(function() {
                        selectCourse(ID);
                        button.css('background-color' , "#00ff00");
                        button.text("Selected");
                    }).addClass('button');
                    var tdWithButton = $('<td>').append(button);
                    tr.append(tdWithButton);

                    $('#myTable').append(tr);
                });
            }
        });
        var trl = $('<tr>');
        var button = $('<button>').text('Submit').click(function() {
            SubmitCourses(Teacher , Faculty);
        }).addClass('button');
        var tdWithButton = $('<td colspan="5" style="align-items: center">').append(button);
        trl.append(tdWithButton);
        $('#myTable').append(trl);
    }
}

function selectCourse(ID){
    CourseIDs.push(ID);
}

function SubmitCourses(Teacher , Faculty){
    if (Faculty === "computer"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherChooseCourses/getCompCourse" ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data:JSON.stringify(CourseIDs),
            success: function (result){
                $.ajax({
                    type: "POST",
                    url: "/TeacherPanel/TeacherChooseCourses/submitToDefinedComputer" ,
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(Teacher , result),
                    success: function (result){
                        console.log("successful");
                    },error(){
                        console.log("error");
                    }
                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "civil"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherChooseCourses/getCivilCourse" ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data:JSON.stringify(CourseIDs),
            success: function (result){
                $.ajax({
                    type: "POST",
                    url: "/TeacherPanel/TeacherChooseCourses/submitToDefinedCivil" ,
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(Teacher , result),
                    success: function (result){
                        console.log("successful");
                    },error(){
                        console.log("error");
                    }
                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "chemistry"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherChooseCourses/getCHCourse" ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data:JSON.stringify(CourseIDs),
            success: function (result){
                $.ajax({
                    type: "POST",
                    url: "/TeacherPanel/TeacherChooseCourses/submitToDefinedChemistry" ,
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(Teacher , result),
                    success: function (result){
                        console.log("successful");
                    },error(){
                        console.log("error");
                    }
                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "electric"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherChooseCourses/getELCourse" ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data:JSON.stringify(CourseIDs),
            success: function (result){
                $.ajax({
                    type: "POST",
                    url: "/TeacherPanel/TeacherChooseCourses/submitToDefinedElectric" ,
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(Teacher , result),
                    success: function (result){
                        console.log("successful");
                    },error(){
                        console.log("error");
                    }
                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "mechanic"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherChooseCourses/getMCourse" ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data:JSON.stringify(CourseIDs),
            success: function (result){
                $.ajax({
                    type: "POST",
                    url: "/TeacherPanel/TeacherChooseCourses/submitToDefinedMechanic" ,
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(Teacher , result),
                    success: function (result){
                        console.log("successful");
                    },error(){
                        console.log("error");
                    }
                });
            },error(){
                console.log("error");
            }
        });
    }
}

$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/TeacherPanel/TeacherChooseCourses/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#faculty1").text(result.faculty);
            $("#status1").text(result.status);
            var faculty = result.faculty;
            ShowCourses(faculty , result);
        },error(){
            console.log("error");
        }
    });
})