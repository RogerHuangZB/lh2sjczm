$(function() {
    $('#userName').blur(function () {
        var userName = $('#userName').val();
        if(isUserNameExist(userName)){
            console.log("用户名已存在!");
        }else{
            console.log("用户名可以使用！");
        }
    });
    
    $('#registerBtn').click(function () {
        var userName = $('#userName').val();
        var password = $('#password').val();
        var pwdCheck = $('#pwdCheck').val();
        if (userName === ""){
            console.log("请输入用户名！");
            return;
        }
        if(isUserNameExist(userName)){
            console.log("用户名已存在!");
        }else{
            console.log("用户名可以使用！");
        }
        if (password === ""){
            console.log("请输入密码！");
            return;
        } else if(password.length < 6){
            console.log("密码长度不足！");
            return;
        }
        if (pwdCheck === ""){
            console.log("请再次输入密码！");
            return;
        } else if(pwdCheck !== password){
            console.log("两次密码输入不一致！");
            return;
        }//验证是否有除大小写字母数字以外的特殊字符
        //验证是否有字母
        //验证是否有数字
        register(userName, password);
    });
});

function register(u, p) {
    console.log("注册成功！");
    window.location = "../index.html";
}

function isUserNameExist(u) {
    console.log(u);
    return false;
}