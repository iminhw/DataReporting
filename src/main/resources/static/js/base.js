//https://sweetalert2.github.io/#declarative-templates

function messge(title = "提示", icon = 'success') {
    Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    }).fire({
        icon: icon,
        title: title
    });
}

// function loginUrl() {
//     var url = location.href;
//     $.ajax({
//         url: "/login",
//         data: {username, password, rememberMe},
//         type: "GET",
//     })
//     $.get("/login"+ url,
//         function (data, status) {
//               alert("数据: " + data + "\n状态: " + status)
//         }
//     );
// }

function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    // var vcode = $("#vcode").val();
    var rememberMe = $('#rememberMe').is(':checked');
    if (username == "" || password == "") return;
    $.ajax({
        url: "/ajaxLogin",
        data: {username, password, rememberMe},
        type: "post",
        dataType: "json",
        success: function (data) {
            if (data.status == 200) {
                messge("登陆成功");
                setTimeout(function () {
                    location.href = data.other;
                }, 500);
            } else {
                messge(data.message, "error");
            }
        },
        error: function () {
            messge("登录失败", "error");
        }
    });
}