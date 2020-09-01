<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>XXX图书管理登录页面</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/css/demo.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/css/login.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/css/index.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery1.42.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery.SuperSlide.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/Validform_v5.3.2_min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/login.js" ></script>
	</head>

	<body>
	<%
		//设置编码
		/* request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); */
	%>
		<div class="header">
			<div class="logo">
				<a href="${pageContext.request.contextPath }/mainPageBean">
					<img src="${pageContext.request.contextPath }/jsp/img/indexImgs/Logo.jpg" width="300px" height="100px" />
				</a>
			</div>
			<div class="login-registor">
				<ul class="lg">
					<li class="login">
						<span> <strong>登录</strong></span>
					</li>
				</ul>
			</div>
		</div>
		<div class="banner">

			<div class="login-aside">
				<div id="o-box-up"></div>
				<div id="o-box-down" style="table-layout:fixed;">
					<div class="error-box"></div>

					<form class="loginForm" action="${pageContext.request.contextPath }/user?methodname=login" method="post">
						<div class="fm-item">
							<label for="logonId" class="form-label">XXX系统登陆：</label>
							<c:if test="${empty sessionScope.remenberusername }">
								<input type="text" value="输入账号" maxlength="100" id="username" name="username" 
								 class="i-text" >
							</c:if>
							<c:if test="${not empty sessionScope.remenberusername }">
								<input type="text" value="${sessionScope.remenberusername }" maxlength="100" id="username" name="username" 
								 class="i-text">
							</c:if>
							<div class="ui-form-explain"></div>
						</div>

						<div class="fm-item">
							<label for="logonId" class="form-label">登陆密码：</label>
							<c:if test="${empty sessionScope.remenberpassword }">
								<input type="password" placeholder="请输入密码" value="" name="password" 
								maxlength="100" id="password" class="i-text">
							</c:if>
							<c:if test="${not empty sessionScope.remenberpassword }">
								<input type="password" value="${sessionScope.remenberpassword }" name="password" 
								maxlength="100" id="password" class="i-text">
							</c:if>
							<div class="ui-form-explain"></div>
						</div>

						<div class="fm-item pos-r">
							<label for="logonId" class="form-label">验证码</label>
							<input type="text" name="identifyingcode" value="输入验证码" maxlength="100" id="yzm" class="i-text yzm" nullmsg="请输入验证码！">
							<div class="ui-form-explain"><img src="${pageContext.request.contextPath }/authImage" class="yzm-img" /></div>
							<span><input type="checkbox" name="remenberPassword" value="remenberPassword" />记住密码</span>
						</div>

						<div class="fm-item">
							
							<div class="ui-form-explain">
								<input id="sub" type="submit" value="立即登录" />
							</div>
						</div>
						<div class="fm-item">
							
							<div class="ui-form-explain">
								<c:if test="${errorinfo != null }">
									<span class="errorinfo"><%=request.getAttribute("errorinfo") %></span>
									<%request.setAttribute("errorinfo", null); %>
								</c:if>
							</div>
						</div>
					</form>

				</div>

			</div>

			<div class="bd">
				<ul>
					<li>
						<img src="${pageContext.request.contextPath }/jsp/img/registor_bj2.jpg" width="100%" height="100%" />
						<a target="_blank" href="#"></a>
					</li>
					<li>
						<img src="${pageContext.request.contextPath }/jsp/img/registor_bj.jpg" width="100%" height="100%" />
						<a target="_blank" href="#"></a>
					</li>
				</ul>
			</div>

			<div class="hd">
				<ul></ul>
			</div>
		</div>
		<script type="text/javascript">
			jQuery(".banner").slide({
				titCell: ".hd ul",
				mainCell: ".bd ul",
				effect: "fold",
				autoPlay: true,
				autoPage: true,
				trigger: "click"
			});
		</script>

		<div class="banner-shadow"></div>

		<div class="footer">
			<p>
				vsvd &csdy; 2018.Companystill have a lang way to go...
				<a href="#" target="_blank" title="XXX图书管理">XXX图书管理</a> - Collect from
				<a href="#" title="vfev" target="_blank">@Hjshahhuafhueii</a>
			</p>
		</div>

	</body>

</html>