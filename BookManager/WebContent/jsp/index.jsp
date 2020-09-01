<%@page import="org.lanqiao.bean.User"%>
<%@page import="org.lanqiao.bean.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>XXX图书管理主页</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jsp/js/index.js"></script>
<link href="${pageContext.request.contextPath }/jsp/layui/css/layui.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/css/index.css" />
</head>
<body>
	<!-- 获取mainPageBean发送过来的数据 -->
	<%
		PageBean pagebean = (PageBean) request.getAttribute("pagebean");
	%>
	<div class="header">
		<div class="logo">
			<img
				src="${pageContext.request.contextPath }/jsp/img/indexImgs/Logo.jpg"
				width="300px" height="100px" />
		</div>
		<div class="login-registor">
			<ul class="lg">
				<!-- 获取登录的session用户信息 -->
				<c:if test="${empty sessionScope.isLogined }">
					<li class="login"><a href="javascript:void(0)"> </a></li>
					<li class="login"><a href="javascript:void(0)"> </a></li>
					<li class="login"><a
						href="${pageContext.request.contextPath }/jsp/login.jsp">登录</a></li>
					<li class="registor"><a
						href="${pageContext.request.contextPath }/jsp/registor.jsp">注册</a>
					</li>
				</c:if>
				<c:if test="${not empty sessionScope.isLogined }">
					<li class="login"><a href="javascript:void(0)">欢迎${sessionScope.isLogined.username }</a>
					</li>
					<li class="registor"><a
						href="${pageContext.request.contextPath }/rechargeBefore">充值</a>
					</li>
					<li class="login"><a
						href="${pageContext.request.contextPath }/jsp/personInfo.jsp">个人中心</a>
					</li>
					<li class="login"><a
						href="${pageContext.request.contextPath }/loginOut">退出</a></li>
				</c:if>
				<%-- <c:if test="${true }">
					</c:if>
					<c:if test="${true }">
						<!--<li class="login">
							<a href="#">欢迎XXX</a>
						</li>
						<li class="registor">
							<a href="#">充值</a>
						</li>
						<li class="login">
							<a href="#">个人中心</a>
						</li>-->
					</c:if> --%>
			</ul>
		</div>
	</div>

	<div class="section1">

		<ul class="ul1">
			<li class="li-1"></li>
			<li class="li-1"></li>
			<li class="li-1"><a
				href="${pageContext.request.contextPath }/mainPageBeanbycid?cid=1">
					男生 </a></li>
			<li class="li-2"><a
				href="${pageContext.request.contextPath }/mainPageBeanbycid?cid=2">
					女生 </a></li>
			<li class="li-3"><a
				href="${pageContext.request.contextPath }/mainPageBeanbycid?cid=3">
					免费 </a></li>
			<li class="li-4"><a
				href="${pageContext.request.contextPath }/mainPageBeanbycid?cid=4">
					付费 </a></li>
			<li class="li-5"><a
				href="${pageContext.request.contextPath }/mainPageBeanbycid?cid=5">
					连载 </a></li>
			<li class="li-6"><a
				href="${pageContext.request.contextPath }/mainPageBeanbycid?cid=6">
					完结 </a></li>
			<li class="li-1"></li>
			<li class="li-1"></li>
			<li class="li-1"></li>
			<li class="li-1"></li>
		</ul>
	</div>
	<div class="banner">
		<div class="ban-left">
			<div class="layui-carousel" id="test1">
				<div carousel-item>
					<div>
						<img
							src="${pageContext.request.contextPath }/jsp/img/indexImgs/b1.jpg"
							height="350px" />
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/jsp/img/indexImgs/b2.jpg"
							height="350px" />
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/jsp/img/indexImgs/b3.jpg"
							height="350px" />
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/jsp/img/indexImgs/b4.jpg"
							height="350px" />
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/jsp/img/indexImgs/b5.jpg"
							height="350px" />
					</div>
				</div>
			</div>
			<!-- 条目中可以是任意内容，如：<img src=""> -->

			<script type="text/javascript"
				src="${pageContext.request.contextPath }/jsp/layui/layui.js"></script>
			<script>
				layui.use('carousel', function() {
					var carousel = layui.carousel;
					//建造实例
					carousel.render({
						elem : '#test1',
						width : '100%' //设置容器宽度
						/*,float: 'left'*/
						,
						height : '100%',
						arrow : 'always' //始终显示箭头
					//,anim: 'updown' //切换动画方式
					});
				});
			</script>
		</div>
		<div class="ban-right">
			<div class="ban-right-top">下载排行榜</div>
			<!-- 排行榜(前8本书) -->
			<div class="ban-right-bot">
				<c:forEach begin="${0 }" end="${fn:length(rankingList) }" var="i">
					<c:if test="${i != fn:length(rankingList)}">
						<c:if test="${i != 0 && i != 1 && i != 2}">
							<p class="ranking">
								<a
									href="${pageContext.request.contextPath }/bookInfo?bid=${rankingList[i].bid }">
									${i + 1 }、 ${rankingList[i].name } </a>
							</p>
						</c:if>
						<c:if test="${i < 3}">
							<p class="ranking">
								<a
									href="${pageContext.request.contextPath }/bookInfo?bid=${rankingList[i].bid }">
									<span class="red">${i + 1 }、</span> ${rankingList[i].name }
								</a>
							</p>
						</c:if>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	<hr />
	<h5 style="margin-left: 200px;">图书</h5>
	<!-- 图书信息 -->
	<div class="center">
		<c:forEach items="${pagebean.list }" var="li">
			<a href="${pageContext.request.contextPath }/bookInfo?bid=${li.bid }">
				<div class="book">
					<div class="center-top">
						<!-- 拼写图片路径 -->
						<img alt="img异常" src="/Work1${li.image }" width="100%"
							height="100%">
					</div>
					<div class="center-bottom">
						<span>单价：${li.price }$</span> <span>作者：${li.author }</span><br />
						<span>书名：${li.name }</span>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>

	<div class="page">
		<ul>
			<c:if test="${pagebean.currentPageIndex != 1 }">
				<li><a
					href="${pageContext.request.contextPath }/mainPageBean?pageindex=1">首页</a></li>
				<li><a
					href="${pageContext.request.contextPath }/mainPageBean?pageindex=${pagebean.currentPageIndex-1}">&lt;</a></li>
			</c:if>

			<c:if test="${pagebean.currentPageIndex == 1 }">
				<li><a href="javascript:void(0)">首页</a></li>
				<!-- 第一页时首页和上一页不可以点击 -->
				<li><a href="javascript:void(0)">&lt;</a></li>
			</c:if>

			<!-- 当页码在3-8时 -->
			<c:if
				test="${pagebean.currentPageIndex >= 3 && pagebean.currentPageIndex <= pagebean.pages - 2 }">
				<c:forEach begin="${pagebean.currentPageIndex-2 }"
					end="${pagebean.currentPageIndex+2 }" var="currentIndex">
					<%
						//默认显示5个分页
					%>
					<c:if test="${currentIndex == pagebean.currentPageIndex }">
						<li class="active"><a
							href="${pageContext.request.contextPath }/mainPageBean?pageindex=${currentIndex}">
								${currentIndex}<%
									/* 页码数 */
								%>
						</a></li>
					</c:if>
					<c:if test="${currentIndex != pagebean.currentPageIndex }">
						<li><a
							href="${pageContext.request.contextPath }/mainPageBean?pageindex=${currentIndex}">
								${currentIndex}<%
									/* 页码数 */
								%>
						</a></li>
					</c:if>
				</c:forEach>
			</c:if>

			<!-- 当页码在1-2页时 -->
			<c:if
				test="${pagebean.currentPageIndex == 2 || pagebean.currentPageIndex == 1 }">
				<c:forEach begin="${1 }" end="${5 }" var="currentIndex">
					<%
						//默认显示5个分页
					%>
					<c:if test="${currentIndex == pagebean.currentPageIndex }">
						<li class="active"><a
							href="${pageContext.request.contextPath }/mainPageBean?pageindex=${currentIndex}">
								${currentIndex}<%
									/* 页码数 */
								%>
						</a></li>
					</c:if>
					<c:if test="${currentIndex != pagebean.currentPageIndex }">
						<li><a
							href="${pageContext.request.contextPath }/mainPageBean?pageindex=${currentIndex}">
								${currentIndex}<%
									/* 页码数 */
								%>
						</a></li>
					</c:if>
				</c:forEach>
			</c:if>

			<!-- 当页码在最后一页和倒数第二页的时候 -->
			<c:if
				test="${pagebean.currentPageIndex == pagebean.pages - 1 || pagebean.currentPageIndex == pagebean.pages }">
				<c:forEach begin="${pagebean.pages-4 }" end="${pagebean.pages }"
					var="currentIndex">
					<%
						//默认显示5个分页
					%>
					<c:if test="${currentIndex == pagebean.currentPageIndex }">
						<li class="active"><a
							href="${pageContext.request.contextPath }/mainPageBean?pageindex=${currentIndex}">
								${currentIndex}<%
									/* 页码数 */
								%>
						</a></li>
					</c:if>
					<c:if test="${currentIndex != pagebean.currentPageIndex }">
						<li><a
							href="${pageContext.request.contextPath }/mainPageBean?pageindex=${currentIndex}">
								${currentIndex}<%
									/* 页码数 */
								%>
						</a></li>
					</c:if>
				</c:forEach>
			</c:if>

			<c:if test="${pagebean.currentPageIndex != pagebean.pages }">
				<li><a
					href="${pageContext.request.contextPath }/mainPageBean?pageindex=${pagebean.currentPageIndex+1}">&gt;</a></li>
				<li><a
					href="${pageContext.request.contextPath }/mainPageBean?pageindex=${pagebean.pages }">尾页</a></li>
			</c:if>

			<c:if test="${pagebean.currentPageIndex == pagebean.pages }">
				<li><a href="javascript:void(0)">&gt;</a></li>
				<!-- 最后一页时尾页和下一页不可以点击 -->
				<li><a href="javascript:void(0)">尾页</a></li>
			</c:if>
		</ul>
	</div>

	<div class="footer">
		<span style="margin-left: 200px;">帮助</span> <span
			style="margin-left: 60px;">举报</span> <span style="margin-left: 60px;">用户反馈</span>
	</div>





	<!-- <script type="text/javascript">
			$(document).ready(function(){
				window.onload(function(){
					$.ajax({
						url:"${pageContext.request.contextPath }/mainPageBean?pageindex=1",
						async:true//异步
			  		});
				});
			});
		</script> -->





</body>
</html>
