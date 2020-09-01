<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>成为会员</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/css/toVip.css" />
	</head>
	<body>
		<div class="header">
			<div class="logo">
				<a href="${pageContext.request.contextPath }/mainPageBean">
					<img src="${pageContext.request.contextPath }/jsp/img/indexImgs/Logo.jpg" width="300px" height="100px" />
				</a>
			</div>
			<div class="login-registor">
				<ul class="lg">
					<li class="login">
						<a href="#">个人中心</a>
					</li>
				</ul>
			</div>
		</div>
		<hr />
		
		<div class="center">
			<h3>会员权益</h3>
			<p>1.海量图书任您选择</p>
			<p>2.付费图书下载次数不限,下载速度更快</p>
			<p>3.付费图书享受9折折扣,其他图书8折下载</p>
			<p>4.一次购买,终生享受会员优惠</p>
			
			<p>
				<a href="${pageContext.request.contextPath }/toVip?money=300&uid=${sessionScope.isLogined.uid }">
					<div class="bot"> 立即购买300$ </div>
				</a>
			</p>
			<c:if test="${not empty alertInfo }">
				<p class="errorinfo">${alertInfo }</p>
			</c:if>
		</div>
		
		<div class="footer">
			<span style="margin-left: 200px;">帮助</span>
			<span style="margin-left: 60px;">举报</span>
			<span style="margin-left: 60px;">用户反馈</span>
		</div>
	</body>
</html>
