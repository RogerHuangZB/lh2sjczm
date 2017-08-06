$(function() {
    $('#registerBtn').click(function () {
        var userName = $('#userName').val();
        var password = $('#password').val();
        var pwdCheck = $('#pwdCheck').val();
        if (userName === ""){
            console.log("请输入用户名！");
            return;
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
        }
        register(userName, password);
    });
});

function register(u, p) {
    window.location = "../index.html";
}