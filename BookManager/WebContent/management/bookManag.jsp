<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<title>管理图书</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/layui/css/layui.css"
	media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/css/adminIndexStyle.css" />
</head>

<body class="layui-layout-body">
	<%@ include file="header.jsp"%>
	<div class="layui-body">
		<input type="hidden" value="${alertInfo }" id="alertInfo" />
		<script type="text/javascript">

			window.onload = function (){
				var alertInfo = document.getElementById("alertInfo").value;
				if(alertInfo != ""){//如果权限不足返回页面提示权限不足
					alert(alertInfo);
					//设置其值为空
					document.getElementById("alertInfo").value = "";
				}
			}
		</script>
		<!-- 内容主体区域 -->
		<div class="layui-container">
			<div class="layui-row">
				<div class="layui-col-md7"
					style="height: 80px; text-align: center; padding-top: 20px;">
					<form action="${pageContext.request.contextPath }/serchBook"
						method="post">
						<input style="margin-top: 20px;" class="search" type="text"
							placeholder="输入图书名称" name="bookName" width="300px" height="60px" />
						<input type="submit" class="layui-btn layui-btn-normal" value="搜索" />
					</form>
				</div>
				<div class="layui-col-md5" style="height: 80px;">
					<a
						href="${pageContext.request.contextPath }/management/addBook.jsp"><input
						style="margin-top: 20px; margin-left: 150px;"
						class="layui-btn layui-btn-normal" type="button" value="新增" /> </a>
				</div>
			</div>
		</div>

		<div style="padding-left: 10px; padding-right: 10px;">
			<table border="3" bordercolor="#ccc" width="100%" height="100%">
				<thead align="center" style="height: 40px;">
					<tr>
						<td>图书id(bid)</td>
						<td>图书名(name)</td>
						<td>作者(author)</td>

						<td>价格(price)</td>
						<td>图片(image)</td>
						<td>简介(content)</td>
						<td>状态(status)</td>
						<td>下载量(counts)</td>
						<td>更新时间(created)</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody style="text-align: center;">
					<c:if test="${not empty allBook }">
						<c:forEach items="${allBook }" var="book">
							<tr style="height: 40px;">
								<td>${book.bid }</td>
								<td>${book.name }</td>
								<td>${book.author }</td>
								<td>${book.price }</td>
								<td>${book.image }</td>
								<td>${book.content }</td>
								<td>${book.status }</td>
								<td>${book.counts }</td>
								<td>${book.created }</td>
								<td>
									<a href="javascript:void(0)"> 编辑 </a>&nbsp;|&nbsp; 
									<a href="${pageContext.request.contextPath }/deleteBook?bid=${book.bid}"> 
										下架 
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>

					<c:if test="${not empty book }">
						<tr style="height: 40px;">
							<td>${book.bid }</td>
							<td>${book.name }</td>
							<td>${book.author }</td>
							<td>${book.price }</td>
							<td>${book.image }</td>
							<td>${book.content }</td>
							<td>${book.status }</td>
							<td>${book.counts }</td>
							<td>${book.created }</td>
							<td>
								<a href="javascript:void(0)"> 编辑 </a>&nbsp;|&nbsp; 
								<a href="${pageContext.request.contextPath }/deleteBook?bid=${book.bid}"> 
									下架 
								</a>
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="10">
							<div id="fenye"></div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<c:if test="${not empty allBook }">
			<input type="hidden" id="counts" value="${fn:length(allBook) }" />
		</c:if>
		<c:if test="${not empty book }">
			<input type="hidden" id="counts" value="${1 }" />
		</c:if>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		© 管理图书 - 底部固定区域
	</div>

	<!-- <script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
		var counts = document.getElementById("counts").value;
		layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;
			laypage
					.render({
						elem : 'fenye',
						count : counts,
						limit : 10,
						layout : [ 'count', 'prev', 'page', 'next', 'skip' ],
						jump : function(obj) {
							console.log(obj)
						}
					});
		});
	</script> -->
</body>

</html>