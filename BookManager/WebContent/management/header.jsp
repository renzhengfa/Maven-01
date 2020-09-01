<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/management/layui/css/layui.css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/management/css/addStyle.css" />
</head>
<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo">
			<a href="javascript:void(0);" style="color: #009688;">XXX图书管理系统</a>
		</div>
		<!-- 头部区域（可配合layui已有的水平导航） -->
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item"><a href="javascript:;"> <img
					src="${pageContext.request.contextPath }/management/img/Logo.jpg"
					class="layui-nav-img"> 
					<c:if test="${not empty managerisLogined }">
						欢迎您, <span class="name">${managerisLogined.username }</span>		
					</c:if>
			</a></li>
			<li class="layui-nav-item"><a
				href="${pageContext.request.contextPath }/loginOut">退了</a></li>
		</ul>
	</div>

	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree" lay-filter="test">
				<li class="layui-nav-item"><a class=""
					href="javascript:void(0);">图书管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a
								href="${pageContext.request.contextPath }/showBooks">管理图书</a>
						</dd>
						<dd>
							<a
								href="${pageContext.request.contextPath }/management/addBook.jsp">添加图书</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><!--  layui-nav-itemed -->
					<a href="javascript:void(0);">管理员管理</a>
					<dl class="layui-nav-child">
						<dd><!--  style="background-color: #009688;" -->
							<a
								href="${pageContext.request.contextPath }/management/manageManager.jsp">管理管理员</a>
						</dd>
						
						<dd>
							<a
								href="${pageContext.request.contextPath }/management/addManager.jsp">添加管理员</a>
						</dd>
						
					</dl>
				</li>
				<li class="layui-nav-item"><a href="javascript:void(0);">财务管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a
								href="${pageContext.request.contextPath }/financialManagement">财务管理</a>
						</dd>
					</dl></li>
			</ul>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>