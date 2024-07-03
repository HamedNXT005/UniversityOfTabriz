function login(){
    var userName = $("#username").val();
    var password = $("#password").val();

    console.log(typeof userName + " " + typeof password);

    if (userName.length !== 0 && password.length !== 0){
        if (userName.charAt(0) === "s" && userName.charAt(1) === "t"){
            $.ajax({
                type: "GET",
                url: "/Login/StudentLogin?userName="+ userName + "&password=" + password ,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (result){
                    if (result === true){
                        window.location.href = "/StudentPanel";
                    }else{
                        alert("The username or password is incorrect");
                    }
                },error: function (xhr){
                    console.log("StudentError");
                }
            });
        }else if (userName.charAt(0) === "t"){
            $.ajax({
                type: "GET",
                url: "/Login/TeacherLogin?userName="+ userName + "&password=" + password ,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (result){
                    if (result === true){
                        window.location.href = "/TeacherPanel";
                    }else{
                        alert("The username or password is incorrect");
                    }
                }
            });
        }else if (userName.charAt(0) === "e"){
            $.ajax({
                type: "GET",
                url: "/Login/EmployeeLogin?userName="+ userName + "&password=" + password ,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (result){
                    if (result === true){
                        window.location.href = "/EmployeePanel";
                    }else{
                        alert("The username or password is incorrect");
                    }
                }
            });
        }
    }else if (userName.length == 0){
        alert("Please enter your Username");
    }else if (password.length == 0){
        alert("Please enter your Password");
    }


    // window.location.href = "/Employeepanel";
}



