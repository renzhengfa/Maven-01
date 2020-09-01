


//加载事件
$(document).ready(function(){
	//根据表单的id获取要验证的表单
	$("#registForm").validate({
		//规则
		rules:{
			//根据input输入框的那么属性值获得输入框
			/*username:{
				//设定规则
				//required:true,//必须填写内容
				minlength:4,//最小长度为4
				maxlength:12
			},*/
			tel:{
				//设定规则
				required:true,//必须填写内容
				minlength:11,//最小长度为1
				maxlength:11,
			 	digits:true
			},
			password:{
				required:true,
				minlength:4,
				maxlength:16,
				digits:true//必须为整数字
			},
			repassword:{
				required:true,
				minlength:4,
				maxlength:16,
				digits:true,//必须为整数字
				equalTo:"[name='password']"//输入的值必须和name='password'的一致
			},
			email:{
				required:true,
				email:true//必须输入正确格式的电子邮件。
			},
			birthday:{
//				date:true//必须输入正确格式的日期。日期校验 ie6 出错，慎用。
				dateISO:true//必须输入正确格式的日期（ISO），例如：2009-06-23，1998/01/22。只验证格式，不验证有效性。
			}
		},
		messages:{
			/*username:{
				required:"用户名不能为空",
				minlength:"用户名长度不能小于4",
				maxlength:"用户名长度不能小于12"
			},*/
			password:{
				required:"密码不能为空",
				minlength:"密码长度不能小于4",
				maxlength:"密码长度不能大于16",
				digits:"密码必须为整数字"//必须为整数字
			},
			repassword:{
				required:"重复密码不能为空",
				minlength:"重复密码长度不能小于4",
				maxlength:"密码长度不能大于16",
				digits:"重复密码必须为整数字",//必须为整数字
				equalTo:"重复密码与密码不一致"//输入的值必须和name='password'的一致
			},
			tel:{
				//设定规则
				required:"电话号码不能为空",//必须填写内容
				minlength:"长度为11",//最小长度为1
				maxlength:"长度为11",
			 	digits:"必须为数字"
			},
			email:{
				required:"邮箱不能为空",
				email:"请输入正确的邮箱格式"//必须输入正确格式的电子邮件。
			},
			birthday:{
//				date:"fffff"//必须输入正确格式的日期。日期校验 ie6 出错，慎用。
				dateISO:"请输入正确的生日格式YYYY-MM-DD"//必须输入正确格式的日期（ISO），例如：2009-06-23，1998/01/22。只验证格式，不验证有效性。
			}
		},
		errorElement: "label", //用来创建错误提示信息标签
		success: function(label) { //验证成功后的执行的回调函数
			//label指向上面那个错误提示信息标签label
			label.text(" ") //清空错误提示消息
			.addClass("success"); //加上自定义的success类
		}
	});
	
});

function check(){
	var username = $("#user").val();
	var userpwd = $("#password").val();
	var userrepwd = $("#repassword").val();
	
	var agree = $("input[type='checkbox']").is(':checked');
	/*alert(username);
	alert(userpwd);
	alert(userrepwd);*/
//	alert()?
	if(username.length == 0 || agree == false){
		return false;
	}
	
	/*
	 * 判断电话号码首字节是否为1
	 */
	var tel = $("#tel").val();
	if(tel.substring(0,1) != "1"){
//		$("#tellabel").val('');
//		$("#tellabel").show();
//		$("#tellabel").val("电话号码必须以1开头");
		return false;
	}
	return true;
}

/*
 * 检测用户名是否符合规定
 */
/*function checkUsername(){
	var check = /^[\u4e00-\u9fa50-9a-zA-Z_]{4,12}$/;
	var username = $("#user").val();
	if(!check.test(username)){
		$("#usernameInfo").css("color:","red");
		$("#usernameInfo").text("用户名由汉字、数字、字母、下划线组成");
	}else{
		$("#usernameInfo").text("");
	}
}*/

function bb(){
	
	 /*
	  * 判断电话号码首字节是否为1
	  */ 
	var tel = $("#tel").val();
	if(tel.substring(0,1) != '1'){
		$("#tellabel").text("电话号码开头必须为1");
	}else{
		$("#tellabel").text("");
	}
	
}

//5秒跳转页面
/*function locatio(){
	var i = 5;
	var prompt = document.getElementById("promptInfo");
	
	var timeout = setInterval(function(){
		prompt.innerHTML = i;
		i--;
		if(i == 0){
			clearInterval(timeout);
			location.href = "../citySelect.html";
		}
	},1000);
}*/







