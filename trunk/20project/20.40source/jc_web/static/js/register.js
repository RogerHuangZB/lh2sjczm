$(function() {
    $('#userName').blur(function () {
        var userName = $('#userName').val();
        if (userName !== ""){
            isUserNameExist(userName);
        }
    });
    
    $('#registerBtn').click(function () {
        var userName = $('#userName').val();
        var password = $('#password').val();
        var pwdCheck = $('#pwdCheck').val();
        if (userName === ""){
            alert("请输入用户名！");
            return;
        }
        if(isUserNameExist(userName)){
            alert("用户名已存在!");
        }else{
            console.log("用户名可以使用！");
        }
        if (password === ""){
            alert("请输入密码！");
            return;
        } else if(password.length < 6){
            alert("密码长度不足！");
            return;
        }
        if (pwdCheck === ""){
            alert("请再次输入密码！");
            return;
        } else if(pwdCheck !== password){
            alert("两次密码输入不一致！");
            return;
        }//验证是否有除大小写字母数字以外的特殊字符
        //验证是否有字母
        //验证是否有数字
        register(userName, password);
    });
});

function register(u, p) {
    alert("注册成功！");
    window.location = "../index.html";
}

function isUserNameExist(u) {
    $.ajax({
        type: 'POST',
        url: 'http://192.168.0.102:9090/user/isUserExist',
        dataType: "json",
        async: false,
        headers:{
            authorization:"tokend652c36290024c0f8ee99568c8c1daf0"
        },
        data: {loginName:u},
        success: function (data) {
            console.log(data);
            if(data.code !== 'ok'){
                alert("用户名已存在!");
            }else{
                console.log("用户名可以使用！");
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