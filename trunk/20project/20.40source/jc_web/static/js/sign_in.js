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
        signIn(userName, password);
    });
});

function signIn(u,p) {
    var data = {
        "username": u,
        "password": p
    };
    $.ajax({
        type: 'POST',
        url: sessionStorage.getItem("apiUrl") + '/login',
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(data),
        success: function (data) {
            console.log(data.msg);
            if(data.code==='ok'){
                sessionStorage.setItem("loginName",data.data.user.loginName);
                sessionStorage.setItem("token",data.data.token);
                window.location = "../index.html";
            }
        },
        error:  function(XMLHttpRequest, textStatus, errorThrown){
            //通常情况下textStatus和errorThrown只有其中一个包含信息
            console.log(XMLHttpRequest);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}