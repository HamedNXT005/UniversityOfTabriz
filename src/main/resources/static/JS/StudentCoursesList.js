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

function ShowCourses(Major , ID){
    if (Major === "computer"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/StudentPanel/StudentCoursesList/getCompCourses?id='+ID,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    $.ajax({
                        type: 'GET',
                        url: '/StudentPanel/StudentCoursesList/GetCourse?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/StudentPanel/StudentCoursesList/getDCompCourses?id=' + CID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result1.unitN + '</td>');
                                    tr.append('<td>' + result2.primaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfPrimaryDay + '</td>');
                                    tr.append('<td>' + result2.secondaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfSecondaryDay + '</td>');
                                    tr.append('<td>' + result2.classN + '</td>');
                                    tr.append('<td>' + result2.examDate + '</td>');
                                    tr.append('<td>' + result.grade + '</td>');
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Major === "civil"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/StudentPanel/StudentCoursesList/getCivilCourses?id='+ID,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    $.ajax({
                        type: 'GET',
                        url: '/StudentPanel/StudentCoursesList/GetCourse?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/StudentPanel/StudentCoursesList/getDCivilCourses?id=' + CID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result1.unitN + '</td>');
                                    tr.append('<td>' + result2.primaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfPrimaryDay + '</td>');
                                    tr.append('<td>' + result2.secondaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfSecondaryDay + '</td>');
                                    tr.append('<td>' + result2.classN + '</td>');
                                    tr.append('<td>' + result2.examDate + '</td>');
                                    tr.append('<td>' + result.grade + '</td>');
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Major === "chemistry"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/StudentPanel/StudentCoursesList/getChCourses?id='+ID,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    $.ajax({
                        type: 'GET',
                        url: '/StudentPanel/StudentCoursesList/GetCourse?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/StudentPanel/StudentCoursesList/getDChCourses?id=' + CID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result1.unitN + '</td>');
                                    tr.append('<td>' + result2.primaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfPrimaryDay + '</td>');
                                    tr.append('<td>' + result2.secondaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfSecondaryDay + '</td>');
                                    tr.append('<td>' + result2.classN + '</td>');
                                    tr.append('<td>' + result2.examDate + '</td>');
                                    tr.append('<td>' + result.grade + '</td>');
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Major === "electric"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/StudentPanel/StudentCoursesList/getECourses?id='+ID,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    $.ajax({
                        type: 'GET',
                        url: '/StudentPanel/StudentCoursesList/GetCourse?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/StudentPanel/StudentCoursesList/getDECourses?id=' + CID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result1.unitN + '</td>');
                                    tr.append('<td>' + result2.primaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfPrimaryDay + '</td>');
                                    tr.append('<td>' + result2.secondaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfSecondaryDay + '</td>');
                                    tr.append('<td>' + result2.classN + '</td>');
                                    tr.append('<td>' + result2.examDate + '</td>');
                                    tr.append('<td>' + result.grade + '</td>');
                                    $('#myTable').append(tr);
                                }
                            });
                        }
                    });
                });
            }
        });
    }else if (Major === "mechanic"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/StudentPanel/StudentCoursesList/getMCourses?id='+ID,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                result.forEach(function (item){
                    var CID = item.courseId;
                    $.ajax({
                        type: 'GET',
                        url: '/StudentPanel/StudentCoursesList/GetCourse?id='+CID,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success:function (result1){
                            console.log(result1);
                            $.ajax({
                                type: 'GET',
                                url: '/StudentPanel/StudentCoursesList/getDMCourses?id=' + CID,
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success:function (result2){
                                    radif += 1;
                                    var tr = $('<tr>');
                                    tr.append('<td>' + radif + '</td>');
                                    tr.append('<td>' + result1.name + '</td>');
                                    tr.append('<td>' + result1.unitN + '</td>');
                                    tr.append('<td>' + result2.primaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfPrimaryDay + '</td>');
                                    tr.append('<td>' + result2.secondaryDay + '</td>');
                                    tr.append('<td>' + result2.timeOfSecondaryDay + '</td>');
                                    tr.append('<td>' + result2.classN + '</td>');
                                    tr.append('<td>' + result2.examDate + '</td>');
                                    tr.append('<td>' + result.grade + '</td>');
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

$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/StudentPanel/StudentCoursesList/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#faculty1").text(result.faculty);
            $("#major1").text(result.major);
            var ID = result.id;
            var Major = result.major;
            ShowCourses(Major,ID);
        },error(){
            console.log("error");
        }
    });
})