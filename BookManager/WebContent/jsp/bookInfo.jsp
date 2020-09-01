<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书详情页</title>
<!-- 引入Bootstrap核心样式文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/css/bootstrap.min.css" />
<!-- 引入jQuery核心js文件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jsp/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath }/jsp/css/bookinfo.css"
	rel="stylesheet" type="text/css" />

</head>
<style>
</style>
<body>

	<div class="header">
		<div class="logo">
			<a href="${pageContext.request.contextPath }/mainPageBean"> <img
				src="${pageContext.request.contextPath }/jsp/img/indexImgs/Logo.jpg"
				width="300px" height="100px" />
			</a>
		</div>
		<div class="login-registor">
			<ul class="lg">
				<li class="login"><span> <strong>图书详情页</strong></span></li>
			</ul>
		</div>
	</div>

	<div class="da">
		<div class="tu">
			<img width="230px" height="250px"
				src="<%=request.getContextPath() %>${book.image }" alt="没找到该图片" />
		</div>
		<div class="shuming">${book.name }</div>
		<div class="xiao"></div>
		<div class="xiao1"></div>
		<div class="xiao2"></div>
		<div class="xiao2"></div>

		<div class="zhiti">作者：${book.author }</div>
		<div class="jiage">价格：$${book.price }</div>
		<div class="lianzai">下载量：${book.counts }</div>
		<div class="xiangxi">
			详细介绍
			<textarea class="form-control" rows="3" readonly="readonly" class="textarea" >
					${book.content }
				</textarea>
		</div>

		<div class="mian1">
			<a href="${pageContext.request.contextPath }/download?bid=${book.bid }&uuid=${bookinfouuid}">立即下载</a>
		</div>
	</div>
		<p class="errorinfo"><span class="errorinfo">${errorinfo }</span><p>
	<div id="bottom">
		<a href="javascript:void(0)">关于我们</a> <a href="javascript:void(0)">联系我们</a>
		<a href="javascript:void(0)">招贤纳士</a> <a href="javascript:void(0)">法律声明</a>
		<a href="javascript:void(0)">友情链接</a> <a href="javascript:void(0)">支付方式</a>
		<a href="javascript:void(0)">配送方式</a> <a href="javascript:void(0)">服务声明</a>
		<a href="javascript:void(0)">广告声明</a>
		<p>BookInfo © 2018-2019 ren 版权所有</p>
	</div>
</body>

</html>