<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>管理管理员</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/layui/css/layui.css"
	media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/css/manageManager.css" />
</head>

<body>
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
					<form action="${pageContext.request.contextPath }/serchManager" method="post">
						<input name="username" class="username" type="text" placeholder="请输入用户名" /> 
						<input type="submit" class="layui-btn layui-btn-normal" value="搜索" />
					</form>
				</div>
				<div class="layui-col-md5" style="height: 80px;">
					<a
						href="${pageContext.request.contextPath }/management/addManager.jsp">
						<input style="margin-top: 20px; margin-left: 150px;"
						class="layui-btn layui-btn-normal" type="button" value="新增" />
					</a>
				</div>
			</div>
		</div>

		<div style="padding-left: 10px; padding-right: 10px;">
			<table border="3" bordercolor="#ccc"
				style="text-align: center; width: 100%">
				<thead>
					<tr height="40px">
						<td>id(uid)</td>
						<td>用户名(username)</td>
						<td>密码(password)</td>
						<td>电话(telephone)</td>
						<td>性别(sex)</td>
						<td>邮箱(email)</td>
						<td>状态(status)</td>
						<td>余额(money)</td>
						<td>vip(vip)</td>
						<td>角色id(rid)</td>
						<td>下载次数(counts)</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty allManager }">
						<c:forEach items="${allManager }" var="li">
							<tr height="40px">
								<td>${li.uid }</td>
								<td>${li.username }</td>
								<td>${li.password }</td>
								<td>${li.telephone }</td>
								<td>${li.sex }</td>
								<td>${li.email }</td>
								<td>${li.status }</td>
								<td>${li.money }</td>
								<td>${li.vip }</td>
								<td>${li.rid }</td>
								<td>${li.counts }</td>
								<td>
									<a href="${pageContext.request.contextPath }/updateManagerBefore?currentUid=${ li.uid }">
										编辑 
									</a>&nbsp;|&nbsp; 
									<a href="${pageContext.request.contextPath }/deleteManager?uid=${li.uid }">
										删除
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${not empty manager }">
						<tr height="40px">
							<td>${manager.uid }</td>
							<td>${manager.username }</td>
							<td>${manager.password }</td>
							<td>${manager.telephone }</td>
							<td>${manager.sex }</td>
							<td>${manager.email }</td>
							<td>${manager.status }</td>
							<td>${manager.money }</td>
							<td>${manager.vip }</td>
							<td>${manager.rid }</td>
							<td>${manager.counts }</td>
							<td>
								<a href="${pageContext.request.contextPath }/updateManagerBefore?currentUid=${ manager.uid }">
									编辑 
								</a>&nbsp;|&nbsp; 
								<a href="${pageContext.request.contextPath }/deleteManager?uid=${manager.uid }">
									删除 
								</a>
							</td>
					</c:if>
					<tr>
						<td colspan="12">
							<div id="fenye"></div>
						</td>
					</tr>
				</tbody>
			</table>
			<c:if test="${not empty manager }">
				<input type="hidden" id="counts" value="${1 }" />
			</c:if>
			<c:if test="${not empty allManager }">
				<input type="hidden" id="counts" value="${fn:length(allManager) }" />
			</c:if>
		</div>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		© 管理管理员 - 底部固定区域
	</div>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
		var i = document.getElementById("counts").value; //数据总数
		layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;
			laypage.render({
				//curr : 1,			起始页
				elem : 'fenye', //这是元素的id，不能写成#pageTest
				count : i, //数据总数
				limit : 10, //每页显示条数
				groups : 5, //连续页码个数
				layout : [ 'count', 'prev', 'page', 'next', 'skip' ],//跳转页码时调用
				jump : function(obj, first) { //获取到当前的页数 
					page1 = obj.curr;
					if (!first) {
						if (page1 !== pagePre) {
							selectSubject(page1, '', false);
						}
					}
				}
			})
		});
	</script>
</body>

</html>