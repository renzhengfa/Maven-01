<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>充值中心</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/layui/layui.js" ></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/layui/lay/modules/table.js" ></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/layui/css/layui.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/css/personInfo.css" />
		<style type="text/css">
			.alertInfo{
				color: red;
			}
		</style>
	</head>
	<body>
		<div class="header">
			<div class="logo">
				<a href="${pageContext.request.contextPath }/mainPageBean">
					<img src="${pageContext.request.contextPath }/jsp/img/indexImgs/Logo.jpg" width="280px" height="100px" />
				</a>
			</div>
			<div class="login-registor">
				<ul class="lg">
					<li class="login">
						<span> <strong>充值中心</strong></span>
					</li>
				</ul>
			</div>
		</div>
			
		<div class="layui-tab layui-tab-card">
		  	<ul class="layui-tab-title">
		    	<li class="layui-this"><a href="#">充值中心</a></li>
		  	</ul>
  			<div class="layui-tab-content" style="margin-left:35%;margin-top:2%;">
			    <div class="layui-tab-item layui-show">
					<form action="${pageContext.request.contextPath }/recharge?username=${sessionScope.isLogined.username }&uid=${sessionScope.isLogined.uid }&uuid=${uuid }" method="post">
						<ul class="userinfo-1">
							<li>
								充值金币:
								<input type="radio" name="money" value="10" checked="checked">10
								<input type="radio" name="money" value="20">20
								<input type="radio" name="money" value="50">50
								<input type="radio" name="money" value="100">100
							</li>
							<li>
								实付金额:
								<span id="fact"></span>
							</li>
							<li>
								支付方式:
								xxx
							</li>
							<li><button type="submit">确认支付</button></li>
							<c:if test="${not empty requestScope.alertinfo }">
								<span class="alertInfo">${sessionScope.isLogined.username }${requestScope.alertinfo }</span>
							</c:if>
						</ul>
					</form>
			    </div>
			    <div class="footer">
					<span style="margin-left: 200px;">帮助</span>
					<span style="margin-left: 60px;">举报</span>
					<span style="margin-left: 60px;">用户反馈</span>
				</div>
			</div>
		</div>
		<script>
			layui.use('element', function(){
			  	var element = layui.element;
			  
			  	//获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
			  	var layid = location.hash.replace(/^#test1=/, '');
			  	element.tabChange('test1', layid); //假设当前地址为：http://a.com#test1=222，那么选项卡会自动切换到“发送消息”这一项
			  
			  	//监听Tab切换，以改变地址hash值
			  	element.on('tab(test1)', function(){
			    	location.hash = 'test1='+ this.getAttribute('lay-id');
			  	});
			});
		</script>
		
		
	</body>
</html>