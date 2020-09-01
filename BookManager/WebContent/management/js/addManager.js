
$(function(){
	
	$("#username").blur(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var check = /^[\u4e00-\u9fa5]{2,4}$/;
		// alert(username)
		if (username == '') {
			$("#usernameAl").css("color", "red");
			$("#usernameAl").text("");
			$("#usernameAl").text("用户名不能为空");
			return false;
		} else if (!check.test(username)) {
			$("#usernameAl").css("color", "red");
			$("#usernameAl").text("");
			$("#usernameAl").text("用户名为长度为2-4的汉字组成");
			return false;
		} else {
			$("#usernameAl").text("");
			return true;
		}
	});
	
	$("#password").blur(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var check = /^[\u4e00-\u9fa5]{2,4}$/;
		//alert(password)
		if(password == ''){
			//alert(password)
			$("#passwordAl").css("color", "red");
			$("#passwordAl").text("");
			$("#passwordAl").text("密码不能为空");
		}else if(password.length < 4 || password.length > 12){
			//alert(password)
			$("#passwordAl").css("color", "red");
			$("#passwordAl").text("");
			$("#passwordAl").text("密码长度为4-12");
		}else{
			$("#passwordAl").text("");
		}
	});
	
	$("#formPost").submit(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var check = /^[\u4e00-\u9fa5]{2,4}$/;
		//alert(username)
		// alert(username)
		if (username == '') {
			return false;
		} else if (!check.test(username)) {
			return false;
		} else if(password == ''){
			return false;
		} else if(password.length < 4 || password.length > 12){
			return false;
		} else {
			return true;
		}
	});
	
});





