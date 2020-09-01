<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>管理员编辑个人信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/layui/css/layui.css"
	media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/css/addAdminStyle.css" />
</head>

<body class="layui-layout-body">

	<%@ include file="header.jsp"%>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div class="addDiv">
			<p>跟新管理员信息</p>
			<hr align="center" />
			<div class="inputDiv">
				<!-- 表单 -->
				<form class="layui-form"
					action="${pageContext.request.contextPath }/updateManager?currentUid=${updatemanagerBycurrentUid}"
					method="post">
					<div class="layui-form-item">
						<div class="layui-input-block">
							<label class="layui-form-label">电    话</label> 
							<input type="text"
								name="tel" class="layui-input">
						</div>
						<div class="layui-input-block">
							<label class="layui-form-label">性    别</label> 
							<input type="text"
								name="gendar" class="layui-input" />
						</div>
						<div class="layui-input-block">
							<label class="layui-form-label">邮    箱</label> 
							<input type="text"
								name="email" class="layui-input">
						</div>
						<div class="layui-input-block">
							<button style="margin-left: 50px;" type="submit"
								class="layui-btn layui-btn-normal">确定修改</button>
						</div>
					</div>
					<c:if test="${not empty successinfo }">
						<span class="success">${successinfo }</span>
					</c:if>
					<c:if test="${not empty errorinfo }">
						<span class="fail">${errorinfo }</span>
					</c:if>
				</form>

			</div>
		</div>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		© 管理员编辑个人信息 - 底部固定区域
	</div>
</body>

</html>