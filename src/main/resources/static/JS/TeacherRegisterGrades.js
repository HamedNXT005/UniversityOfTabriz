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

function ShowListGPA(Faculty , ID){
    if (Faculty === "computer"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherRegisterGrades/GetCompCourses?id=" + ID ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    var table = $('<table>').appendTo($('#main-content')).addClass("myTable");
                    var thead = $('<thead>').appendTo(table);
                    var tbody = $('<tbody>').appendTo(table);

                    var titleHeader = $('<tr>').append(thead);
                    titleHeader.append('<th colspan="4" class="head"><cite>'+CID+'</cite></th>');

                    var headerRow = $('<tr>').appendTo(thead);
                    headerRow.append('<th>#</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>GPA</th>');
                    headerRow.append('<th>Submit</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherRegisterGrades/GetCompPlan?id=" + CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var STID = item1.studentId;
                                var CUID = item1.courseId;
                                var INID = item1.studentId + item1.courseId;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.studentId + '</td>');
                                dataRow.append('<td><input value="'+ item1.grade +'" id="'+item1.studentId + item1.courseId+'"></td>');
                                var button = $('<button>').text('Sumbit').click(function() {
                                    if (item1.grade === 0){
                                        UpdateGpa(STID , CUID , INID , Faculty);
                                    }
                                }).addClass('button');
                                var tdWithButton = $('<td>').append(button);
                                dataRow.append(tdWithButton);
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });
                })
            },error(){
                console.log("error");
            }
        });
    }else if(Faculty === "civil"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherRegisterGrades/GetCivilCourses?id=" + ID ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    var table = $('<table>').appendTo($('#main-content')).addClass("myTable");
                    var thead = $('<thead>').appendTo(table);
                    var tbody = $('<tbody>').appendTo(table);

                    var titleHeader = $('<tr>').append(thead);
                    titleHeader.append('<th colspan="4" class="head"><cite>'+CID+'</cite></th>');

                    var headerRow = $('<tr>').appendTo(thead);
                    headerRow.append('<th>#</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>GPA</th>');
                    headerRow.append('<th>Submit</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherRegisterGrades/GetCivilPlan?id=" + CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var STID = item1.studentId;
                                var CUID = item1.courseId;
                                var INID = item1.studentId + item1.courseId;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.studentId + '</td>');
                                dataRow.append('<td><input value="'+ item1.grade +'" id="'+item1.studentId + item1.courseId+'"></td>');
                                var button = $('<button>').text('Sumbit').click(function() {
                                    if (item1.grade === 0){
                                        UpdateGpa(STID , CUID , INID , Faculty);
                                    }
                                }).addClass('button');
                                var tdWithButton = $('<td>').append(button);
                                dataRow.append(tdWithButton);
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });
                })
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "chemistry"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherRegisterGrades/GetCHCourses?id=" + ID ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    var table = $('<table>').appendTo($('#main-content')).addClass("myTable");
                    var thead = $('<thead>').appendTo(table);
                    var tbody = $('<tbody>').appendTo(table);

                    var titleHeader = $('<tr>').append(thead);
                    titleHeader.append('<th colspan="4" class="head"><cite>'+CID+'</cite></th>');

                    var headerRow = $('<tr>').appendTo(thead);
                    headerRow.append('<th>#</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>GPA</th>');
                    headerRow.append('<th>Submit</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherRegisterGrades/GetCHPlan?id=" + CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var STID = item1.studentId;
                                var CUID = item1.courseId;
                                var INID = item1.studentId + item1.courseId;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.studentId + '</td>');
                                dataRow.append('<td><input value="'+ item1.grade +'" id="'+item1.studentId + item1.courseId+'"></td>');
                                var button = $('<button>').text('Sumbit').click(function() {
                                    if (item1.grade === 0){
                                        UpdateGpa(STID , CUID , INID , Faculty);
                                    }
                                }).addClass('button');
                                var tdWithButton = $('<td>').append(button);
                                dataRow.append(tdWithButton);
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });
                })
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "electric"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherRegisterGrades/GetECourses?id=" + ID ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    var table = $('<table>').appendTo($('#main-content')).addClass("myTable");
                    var thead = $('<thead>').appendTo(table);
                    var tbody = $('<tbody>').appendTo(table);

                    var titleHeader = $('<tr>').append(thead);
                    titleHeader.append('<th colspan="4" class="head"><cite>'+CID+'</cite></th>');

                    var headerRow = $('<tr>').appendTo(thead);
                    headerRow.append('<th>#</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>GPA</th>');
                    headerRow.append('<th>Submit</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherRegisterGrades/GetEPlan?id=" + CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var STID = item1.studentId;
                                var CUID = item1.courseId;
                                var INID = item1.studentId + item1.courseId;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.studentId + '</td>');
                                dataRow.append('<td><input value="'+ item1.grade +'" id="'+item1.studentId + item1.courseId+'"></td>');
                                var button = $('<button>').text('Sumbit').click(function() {
                                    if (item1.grade === 0){
                                        UpdateGpa(STID , CUID , INID , Faculty);
                                    }
                                }).addClass('button');
                                var tdWithButton = $('<td>').append(button);
                                dataRow.append(tdWithButton);
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });
                })
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "mechanic"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherRegisterGrades/GetMCourses?id=" + ID ,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    var table = $('<table>').appendTo($('#main-content')).addClass("myTable");
                    var thead = $('<thead>').appendTo(table);
                    var tbody = $('<tbody>').appendTo(table);

                    var titleHeader = $('<tr>').append(thead);
                    titleHeader.append('<th colspan="4" class="head"><cite>'+CID+'</cite></th>');

                    var headerRow = $('<tr>').appendTo(thead);
                    headerRow.append('<th>#</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>GPA</th>');
                    headerRow.append('<th>Submit</th>');
                    $.ajax({
                        type: "GET",
                        url: "\"/TeacherPanel/TeacherRegisterGrades/GetMPlan?id=" + CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var STID = item1.studentId;
                                var CUID = item1.courseId;
                                var INID = item1.studentId + item1.courseId;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.studentId + '</td>');
                                dataRow.append('<td><input value="'+ item1.grade +'" id="'+item1.studentId + item1.courseId+'"></td>');
                                var button = $('<button>').text('Sumbit').click(function() {
                                    if (item1.grade === 0){
                                        UpdateGpa(STID , CUID , INID , Faculty);
                                    }
                                }).addClass('button');
                                var tdWithButton = $('<td>').append(button);
                                dataRow.append(tdWithButton);
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });
                })
            },error(){
                console.log("error");
            }
        });
    }
}

function UpdateGpa(STID , CUID , INID , Faculty){
    if (Faculty === "computer"){
        $.ajax({
            type: "Post",
            url: "/TeacherPanel/TeacherRegisterGrades/submitGradeComputer?studentId=" + STID + "&courseId=" + CUID + "&grade=" + INID ,
            contentType: "application/json; charset=utf-8",
            success: function (res){
                console.log("Successful");
            },error(){
                console.log("error");
            }
        });
        location.reload();
    }else if(Faculty === "civil"){
        $.ajax({
            type: "Post",
            url: "/TeacherPanel/TeacherRegisterGrades/submitGradeCivil?studentId=" + STID + "&courseId=" + CUID + "&grade=" + INID ,
            contentType: "application/json; charset=utf-8",
            success: function (res){
                console.log("Successful");
            },error(){
                console.log("error");
            }
        });
        location.reload();
    }else if (Faculty === "chemistry"){
        $.ajax({
            type: "Post",
            url: "/TeacherPanel/TeacherRegisterGrades/submitGradeChemistry?studentId=" + STID + "&courseId=" + CUID + "&grade=" + INID ,
            contentType: "application/json; charset=utf-8",
            success: function (res){
                console.log("Successful");
            },error(){
                console.log("error");
            }
        });
        location.reload();
    }else if (Faculty === "electric"){
        $.ajax({
            type: "Post",
            url: "/TeacherPanel/TeacherRegisterGrades/submitGradeElectric?studentId=" + STID + "&courseId=" + CUID + "&grade=" + INID ,
            contentType: "application/json; charset=utf-8",
            success: function (res){
                console.log("Successful");
            },error(){
                console.log("error");
            }
        });
        location.reload();
    }else if (Faculty === "mechanic"){
        $.ajax({
            type: "Post",
            url: "/TeacherPanel/TeacherRegisterGrades/submitGradeMechanic?studentId=" + STID + "&courseId=" + CUID + "&grade=" + INID ,
            contentType: "application/json; charset=utf-8",
            success: function (res){
                console.log("Successful");
            },error(){
                console.log("error");
            }
        });
        location.reload();
    }
}

$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/TeacherPanel/TeacherRegisterGrades/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#faculty1").text(result.faculty);
            $("#status1").text(result.status);
            ShowListGPA(result.faculty , result.id);
        },error(){
            console.log("error");
        }
    });
})