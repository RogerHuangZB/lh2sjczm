$(function() {
    $('#toRegisterBtn').click(function () {
        window.location = "../../views/register.html";
    });

    $('#signInBtn').click(function () {
        var userName = $('#userName').val();
        var password = $('#password').val();
        if (userName === ""){
            alert("请输入用户名！");
            return;
        }
        if (password === ""){
            alert("请输入密码！");
            return;
        } else if(password.length < 6){
            alert("密码长度不对！");
            return;
        }
        login(userName, password);
    });
});

function login(u,p) {
    var data = {
        "username": u,
        "password": p
    };
    $.ajax({
        type: 'POST',
        url: 'http://192.168.0.102:9090/login',
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(data),
        success: function (data) {
            console.log(data);
            window.location = "../index.html";
        },
        error:  function(XMLHttpRequest, textStatus, errorThrown){
            //通常情况下textStatus和errorThrown只有其中一个包含信息
            console.log(XMLHttpRequest);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}