$(function() {
    $('#registerBtn').click(function () {
        var userName = $('#userName').val();
        var password = $('#password').val();
        var pwdCheck = $('#pwdCheck').val();
        if (userName === ""){
            alert("请输入用户名！");
            return;
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
    $.ajax({
        type: 'POST',
        url: sessionStorage.getItem("apiUrl") + '/user/register',
        dataType: "json",
        async: false,
        headers:{
            authorization:"token"+sessionStorage.getItem("token")
        },
        data: {
            loginName:u ,
            password: p
        },
        success: function (data) {
            console.log(data);
            if(data.code === 'ok'){
                alert("注册成功！");
                signIn(u, p);
            }else{
                console.log("注册失败！");
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
