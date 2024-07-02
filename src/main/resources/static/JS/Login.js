function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    const mainContant = document.getElementById("personIMG");
    if (sidebar.style.left === "-290px") {
        sidebar.style.left = "0";
    } else {
        sidebar.style.left = "-290px";
    }
}

$(document).ready(function () {
    document.getElementById('personIMG').src = "../static/Img/images.jpg";
});
