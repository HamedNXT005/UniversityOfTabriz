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

function ShowStudents(Faculty , ID){
    if (Faculty === "computer"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherListOfStudents/GetTeacherCompClasses?id="+ ID ,
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
                    headerRow.append('<th>Name</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>Major</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherListOfStudents/showComputer?courseId="+ CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.nameF + " " + item1.nameL + '</td>');
                                dataRow.append('<td>' + item1.id + '</td>');
                                dataRow.append('<td>' + item1.major + '</td>');
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });

                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "civil"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherListOfStudents/GetTeacherCivilClasses?id="+ ID ,
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
                    headerRow.append('<th>Name</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>Major</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherListOfStudents/showCivil?courseId="+ CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.nameF + " " + item1.nameL + '</td>');
                                dataRow.append('<td>' + item1.id + '</td>');
                                dataRow.append('<td>' + item1.major + '</td>');
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });

                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "chemistry"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherListOfStudents/GetTeacherChClasses?id="+ ID ,
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
                    headerRow.append('<th>Name</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>Major</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherListOfStudents/showChemistry?courseId="+ CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.nameF + " " + item1.nameL + '</td>');
                                dataRow.append('<td>' + item1.id + '</td>');
                                dataRow.append('<td>' + item1.major + '</td>');
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });

                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "electric"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherListOfStudents/GetTeacherEClasses?id="+ ID ,
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
                    headerRow.append('<th>Name</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>Major</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherListOfStudents/showElectric?courseId="+ CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.nameF + " " + item1.nameL + '</td>');
                                dataRow.append('<td>' + item1.id + '</td>');
                                dataRow.append('<td>' + item1.major + '</td>');
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });

                });
            },error(){
                console.log("error");
            }
        });
    }else if (Faculty === "mechanic"){
        $.ajax({
            type: "GET",
            url: "/TeacherPanel/TeacherListOfStudents/GetTeacherMClasses?id="+ ID ,
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
                    headerRow.append('<th>Name</th>');
                    headerRow.append('<th>Student Code</th>');
                    headerRow.append('<th>Major</th>');
                    $.ajax({
                        type: "GET",
                        url: "/TeacherPanel/TeacherListOfStudents/showElectric?courseId="+ CID ,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (result1){
                            var radif = 0;
                            result1.forEach(function (item1){
                                radif += 1;
                                var dataRow = $('<tr>').appendTo(tbody);
                                dataRow.append('<td>' + radif + '</td>');
                                dataRow.append('<td>' + item1.nameF + " " + item1.nameL + '</td>');
                                dataRow.append('<td>' + item1.id + '</td>');
                                dataRow.append('<td>' + item1.major + '</td>');
                                tbody.append(dataRow);
                            });
                        },error(){
                            console.log("error");
                        }
                    });

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
        url: "/TeacherPanel/TeacherListOfStudents/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#faculty1").text(result.faculty);
            $("#status1").text(result.status);
            var fac = $("#faculty1").val();
            var ID = result.id;
            ShowStudents(fac , ID);
        },error(){
            console.log("error");
        }
    });
})