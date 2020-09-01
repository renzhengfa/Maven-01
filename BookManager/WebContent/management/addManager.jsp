<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>添加管理员</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/layui/css/layui.css"
	media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/management/js/addManager.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/css/addAdminStyle.css" />
</head>

<body class="layui-layout-body">

	<%@ include file="header.jsp"%>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div class="addDiv">
			<p>新建管理员</p>
			<hr align="center" />
			<div class="inputDiv">

				<!-- 表单 -->
				<form class="layui-form"
					action="${pageContext.request.contextPath }/addManager"
					method="post" id="formPost">
					<div class="layui-form-item">
						<div class="layui-input-block">
							<label class="layui-form-label">用户名</label> 
							<input type="text" name="username" class="layui-input" id="username" >
							<span id="usernameAl"></span>
						</div>
						<div class="layui-input-block">
							<label class="layui-form-label">密码</label> 
							<input type="password" name="password" class="layui-input" id="password">
							<span id="passwordAl"></span>
						</div>
						<div class="layui-input-block">
							<button style="margin-left: 50px;" type="submit"
								class="layui-btn layui-btn-normal">立即创建</button>
						</div>
					</div>
					<c:if test="${not empty successInfo }">
						<span class="success">${successInfo }</span>
					</c:if>
					<c:if test="${not empty failInfo }">
						<span class="fail">${failInfo }</span>
					</c:if>
				</form>

			</div>
		</div>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		© 添加管理员 - 底部固定区域
	</div>
	
</body>

</html>