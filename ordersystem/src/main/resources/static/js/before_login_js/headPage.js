function logajax() {
    $.ajax({
        url: "/userManager/login",
        data: {userName: $("#name").val(), userPwd: $("#pwd").val()},
        type: "POST",
        dataType: "json",
        success: function (data) {
            if (data != null) {
                alert("登录成功");
                window.location.replace("../after_login/index.html");
            }
            else {
                alert("用户名或密码错误");
            }
        },
        error: function () {
            alert("请求错误");
        }
    });
}

function register() {
    var user = {
        userName: $("#userName").val(),
        userPwd: $("#passWord").val()
    }
    $.ajax({
        url: "/userManager/register",
        type: "POST",
        contentType: "application/json;charset=UTF-8",
        dataType: 'json',
        data: JSON.stringify(user),
        success: function (data) {
            if (data > 0) {
                alert("注册成功");
                window.location.replace("../before_login/index.html");
            } else {
                alert("注册失败");
            }
        },
        error: function () {
            alert("注册失败")
        }
    });

}