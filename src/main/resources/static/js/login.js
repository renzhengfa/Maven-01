$(function () {

    $(".i-text").focus(function () {
        $(this).addClass('h-light');
    });

    $(".i-text").focusout(function () {
        $(this).removeClass('h-light');
    });

    $("#username").focus(function () {
        var username = $(this).val();
        if (username == '输入账号') {
            $(this).val('');
            $(this).css({'color':'white'});
        }
    });

    $("#username").focusout(function () {
        var username = $(this).val();
        if (username == '') {
            $(this).val('输入账号');
        }
    });

    $("#password").focus(function () {
        var username = $(this).val();
        if (username == '输入密码') {
            $(this).val('');
        }
    });

    $("#yzm").focus(function () {
        var username = $(this).val();
        if (username == '输入验证码') {
            $(this).val('');
        }
    });

    $("#yzm").focusout(function () {
        var username = $(this).val();
        if (username == '') {
            $(this).val('输入验证码');
        }
    });

    $(".registerform").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = $(".error-box");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        ajaxPost: true
    });

});