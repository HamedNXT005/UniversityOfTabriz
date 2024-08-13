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
function ShowCourses(Faculty , ID){
    if (Faculty === "computer"){
        var radif = 0;
        $.ajax({
            type: 'GET',
            url: '/StudentPanel/StudentSelectCourse/getAvailableCoursesForComputer?id=' + ID,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (result){
                console.log(result);
                result.forEach(function (item){
                    radif += 1;
                    console.log(item);
                    var ID = item.id;
                    var tr = $('<tr>');
                    tr.append('<td>' + radif + '</td>');
                    tr.append('<td>' + item.courseId + '</td>');
                    tr.append('<td>' + item.primaryDay + '</td>');
                    tr.append('<td>' + item.timeOfPrimaryDay + '</td>');
                    tr.append('<td>' + item.secondaryDay + '</td>');
                    tr.append('<td>' + item.timeOfSecondaryDay + '</td>');
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
            url: '/StudentPanel/StudentSelectCourse/getAvailableCoursesForCivil?id=' + ID,
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
                    tr.append('<td>' + item.primaryDay + '</td>');
                    tr.append('<td>' + item.timeOfPrimaryDay + '</td>');
                    tr.append('<td>' + item.secondaryDay + '</td>');
                    tr.append('<td>' + item.timeOfSecondaryDay + '</td>');
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
            url: '/StudentPanel/StudentSelectCourse/getAvailableCoursesForChemistry?id=' + ID,
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
                    tr.append('<td>' + item.primaryDay + '</td>');
                    tr.append('<td>' + item.timeOfPrimaryDay + '</td>');
                    tr.append('<td>' + item.secondaryDay + '</td>');
                    tr.append('<td>' + item.timeOfSecondaryDay + '</td>');
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
            url: '/StudentPanel/StudentSelectCourse/getAvailableCoursesForElectric?id=' + ID,
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
                    tr.append('<td>' + item.primaryDay + '</td>');
                    tr.append('<td>' + item.timeOfPrimaryDay + '</td>');
                    tr.append('<td>' + item.secondaryDay + '</td>');
                    tr.append('<td>' + item.timeOfSecondaryDay + '</td>');
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
            url: '/StudentPanel/StudentSelectCourse/getAvailableCoursesForMechanic?id=' + ID,
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
                    tr.append('<td>' + item.primaryDay + '</td>');
                    tr.append('<td>' + item.timeOfPrimaryDay + '</td>');
                    tr.append('<td>' + item.secondaryDay + '</td>');
                    tr.append('<td>' + item.timeOfSecondaryDay + '</td>');
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

    }
}
$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "/StudentPanel/StudentSelectCourse/getInfo" ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result){
            $("#PersonInfo").text(result.nameF + " " + result.nameL);
            $("#faculty1").text(result.faculty);
            $("#major1").text(result.major);
            ShowCourses(result.faculty , result.id);
        },error(){
            console.log("error");
        }
    });
})