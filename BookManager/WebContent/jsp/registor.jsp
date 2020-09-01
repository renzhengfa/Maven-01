<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>XXX注册页面</title>
		<script src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/js/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/js/messages_zh.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/js/registor.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/css/registor.css"/>
		<script type="text/javascript">
			$(function(){//页面加载完
				//为用户名输入框注册失去焦点事件
				$("#user").blur(function(){
					var check = /^[\u4e00-\u9fa50-9a-zA-Z_]{4,12}$/;
					var username = $("#user").val();
					//1.获取用户名输入框的值
					var username = $(this).val();
					//alert(username);
					//2.去服务器端校验用户名是否存在----ajax
					$.ajax({
						type: "POST",  
						url: "${pageContext.request.contextPath}/registorCheckUser",
						data: {"username":username},
						success: function(data){
							var countUser = data.haveUserName;
							if(!check.test(username)){
								$("#usernameInfo").html("");
								$("#usernameInfo").html("用户名必须为汉字、数字、字母、下划线组成");
								$("#usernameInfo").css("color","red");
							}else{
								if(countUser == 1){
									$("#usernameInfo").html("");
									$("#usernameInfo").html("该用户名被占用");
									$("#usernameInfo").css("color","red");
								}else if(countUser == 2){
									$("#usernameInfo").html("");
									$("#usernameInfo").html("用户名长度为(4~12)");
									$("#usernameInfo").css("color","red");
								}else{
									$("#usernameInfo").html("");
									$("#usernameInfo").html("该用户名可用");
									$("#usernameInfo").css("color","green");
								}
							}
						},
						dataType: "json",
						contentType: "application/x-www-form-urlencoded; charset=utf-8"
					});

					
					/* $.post(
						"${pageContext.request.contextPath}/registorCheckUser",
						{"username":username},
						function(data){
							var countUser = data.haveUserName;
							if(countUser == 1){
								$("#usernameInfo").html("");
								$("#usernameInfo").html("该用户已存在");
								$("#usernameInfo").css("color","red");
							}else{
								$("#usernameInfo").html("");
								$("#usernameInfo").html("该用户可用");
								$("#usernameInfo").css("color","green");
							}
						},
						"json",
						"utf-8"
					); */
				});
			});
		</script>
	</head>
	<body>
		<!--<div id="time">time</div>-->
		<div id="contanier">
			<div class="header">
				<div class="logo">
					<a href="${pageContext.request.contextPath }/mainPageBean">
						<img src="${pageContext.request.contextPath }/jsp/img/indexImgs/Logo.jpg" width="280px" height="100px" />
					</a>
				</div>
				<div class="login-registor">
					<ul class="lg">
						<li class="login">
							<span> <strong>注册页面</strong></span>
						</li>
					</ul>
				</div>
			</div>
			
			<div id="form">
				<form action="${pageContext.request.contextPath }/registor" method="post" id="registForm" onsubmit="return check()">
					<div id="father">
						<div id="form2">
							<table cellpadding="0px" cellspacing="0px" bgcolor="white">
								<tr>
									<td colspan="2" >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font size="5">用户注册</font>&nbsp;&nbsp;&nbsp;USER REGISTER 
									</td>
								</tr>
								<tr>
									<td width="180px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										<label for="user" >用户名</label>
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;
										<input type="text" name="username" size="35px" id="user"/>
										<span id="usernameInfo"></span>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										密码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;
										<input type="password"  name="password" size="35px" id="password" />
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										确认密码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;
										<input type="password" name="repassword" id="repassword" size="35px"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										tel
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;
										<input type="text" name="tel" id="tel" size="35px" onblur="bb()"/>
										<span class="error" id="tellabel" style="color:red" ></span>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										Email
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;
										<input type="text" name="email" size="35px" id="email"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										性别
									</td>
									<td>
										<span style="margin-right: 155px;">
											<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;
											<input type="radio" name="sex" value="男"/>男
											<input type="radio" name="sex" value="女"/>女<em></em>
										</span>
										<label for="sex" class="error" style="display: none;"></label>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										验证码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;
										<input type="text" name="yanzhengma" />
										<img src="${pageContext.request.contextPath }/authImage2" style="height: 28px;width: 85px;"/>
									</td>
								</tr>
								<c:if test="${errorInfo != null }">
									<span class="errorinfo"><%=request.getAttribute("errorInfo") %></span>
									<%request.setAttribute("errorInfo", null); %>
								</c:if>
								
								<tr>
									<td></td>
									<td>
										<input type="checkbox" name="readed" value="已读" />
										<a href="${pageContext.request.contextPath }/jsp/textfile/agreement/agreement.txt">我已阅读并同意《用户服务协议》</a>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="submit" value="注      册" height="50px"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</form>
			</div>
			
			<div id="bottom">
				<a href="javascript:void(0)">关于我们</a>
				<a href="javascript:void(0)">联系我们</a>
				<a href="javascript:void(0)">招贤纳士</a>
				<a href="javascript:void(0)">法律声明</a>
				<a href="javascript:void(0)">友情链接</a>
				<a href="javascript:void(0)">支付方式</a>
				<a href="javascript:void(0)">配送方式</a>
				<a href="javascript:void(0)">服务声明</a>
				<a href="javascript:void(0)">广告声明</a>
				<p>
					registor  © 2018-2019 ren 版权所有 
				</p>
			</div>
		</div>
	</body>
</html>