<%@page import="org.lanqiao.bean.Book"%>
<%@page import="org.lanqiao.serviceImpl.BookServiceImpl"%>
<%@page import="org.lanqiao.service.BookService"%>
<%@page import="org.lanqiao.bean.User_consume"%>
<%@page import="java.util.List"%>
<%@page import="org.lanqiao.serviceImpl.User_consumeServiceImpl"%>
<%@page import="org.lanqiao.service.User_consumeService"%>
<%@page import="org.lanqiao.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title>个人信息页面</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/layui/layui.js" ></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/layui/lay/modules/table.js" ></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/layui/css/layui.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/css/personInfo.css" />
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
						<span> <strong>个人中心</strong></span>
					</li>
				</ul>
			</div>
		</div>
			
		<div class="layui-tab layui-tab-card">
		  	<ul class="layui-tab-title">
		    	<li class="layui-this"><a href="#">个人信息</a></li>
		    	<li><a href="#">消费记录</a></li>
		  	</ul>
  			<div class="layui-tab-content" style="margin-left:5%;margin-top:2%;">
		    <div class="layui-tab-item layui-show">
				<ul class="userinfo-1">
					<li>用户名:&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;${sessionScope.isLogined.username }</li><hr />
					<li>tel:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						${sessionScope.isLogined.telephone }
					</li><hr />
					<li>性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						${sessionScope.isLogined.sex }
					</li><hr />
					<li>邮件:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						${sessionScope.isLogined.email }
					</li><hr />
					<li>余额:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						${sessionScope.isLogined.money }
					</li><hr />
					<li>是否VIP:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${sessionScope.isLogined.vip eq '1' }">
						<%-- <c:if  test  =  "${list.name  eq  '门票 '} ">  </c:if> --%>
							是     &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
							<span style="color:red;font-size:18px">VIP</span>
						</c:if>
						<c:if test="${sessionScope.isLogined.vip eq '2' }">
							不是  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
							<a href="<%=request.getContextPath()%>/jsp/tovip.jsp">
								<span class="toVip">成为会员</span>
							</a>
						</c:if>
					</li><hr />
					<li>下载次数:&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.isLogined.counts }</li>
				</ul>
		    </div>
		    
		    <!-- 获取用户消费记录 -->
		    
		    <%
		    	User user = (User)request.getSession().getAttribute("isLogined");
		    	int uid = user.getUid();
		    	//根据uid查询消费记录
		    	User_consumeService user_consumeService = new User_consumeServiceImpl();
		    	//消费记录list
		    	List<User_consume> list = user_consumeService.queryUser_consumeByUid(uid);
		    	//存入request属性方便后面el表达式引用
		    	request.setAttribute("list", list);
		    %>
		    
		    <div class="layui-tab-item">
				<ul class="userinfo-1">
					<%
						for(int i = 0; i < list.size(); i++){
					%>
						<li>用户:
							<span class="xfjl">${sessionScope.isLogined.username }</span>
							
							<%
								if(list.get(i).getXc().equals("1")){//充值
							%>
									充值了:
									<span class="xfjl"><%=list.get(i).getMoney() %>金币</span>
							<%
								}else{//消费
							%>
							购买了:
							<span class="xfjl">
							<%
								//获取
								if(list.get(i).getBid() == 0 && list.get(i).getVip().equals("1")){//充值VIP
							 %>
								vip
							<% } %>
							<%
								//获取
								if(list.get(i).getBid() != 0){//下载购买图书
									//根据图书id查询图书信息
									BookService bookservice = new BookServiceImpl();
									Book book = bookservice.queryBookById(list.get(i).getBid());
							%>
								<%=book.getName() %>
							<%	
								}
							%>
							</span>
							<% } %>
							
							单价:
							<span class="xfjl"><%=list.get(i).getMoney() %></span>$
						</li>
						<hr />
					<%
						}
					%>
				</ul>
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