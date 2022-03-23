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

function sendAjax() {
    var username = $("#username").val();
    var password = $("#password").val();
    // var vcode = $("#vcode").val();
    var rememberMe = $('#rememberMe').is(':checked');
    // var url = location.href;
    // console.log(url);
    $.ajax({
        url: "/ajaxLogin",
        data: {username, password, rememberMe},
        type: "post",
        dataType: "json",
        success: function (data) {
            if (data.status == 200) {
                messge("登陆成功");
                location.href = "/index";
                //     location.href = data.repurl;
            } else if (data.status == 100) {
                messge("密码错误，您还有：" + data.message + " 次机会");
            } else if (data.status == 600) {
                messge("账号不存在,您还有：" + data.message + " 次机会");
            } else if (data.status == 300) {
                messge("账号不存在,您还有：" + data.message + " 次机会");
            } else {
                messge(data.message, "error");
                // $("#erro1").html(data.message);
            }
        },
        error: function () {
            messge("登录失败", "error");
        }
    });
}