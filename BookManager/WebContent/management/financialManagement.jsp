<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>财务管理</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/layui/css/layui.css"
	media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/management/css/moneyManagerStyle.css	" />
</head>

<body class="layui-layout-body">
	<%@ include file="header.jsp"%>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<!-- 日期 -->
		<div class="div1">
			<span>日期:</span> <span> <input type="text" placeholder="请点击选择日期在点击确定"
				id="date" name="date" />
			</span>
			<span>
				<input type="button" id="submit" value="确定" />
			</span>
		</div>
		<!-- 详情 -->

		<div class="div2">
			<c:if test="${not empty consumption }">
				<div class="div2_small">
					<span class="left">2018年11月所有用户一共充值了</span> 
					<span class="right">${consumption.sumMonthRecharge }$</span>
				</div>
				<div class="div2_small">
					<span class="left">2018年11月所有用户一共消费了</span> 
					<span class="right">${consumption.sumMonthConsumption }$</span>
				</div>
				<div class="div2_small">
					<span class="left">到目前为止所有用户一共充值了</span> 
					<span class="right">${consumption.sumRecharge }$</span>
				</div>
				<div class="div2_small">
					<span class="left">到目前为止所有用户一共消费了</span> 
					<span class="right">${consumption.sumConsumption }$</span>
				</div>
			</c:if>
		</div>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		© 财务管理 - 底部固定区域
	</div>
	<script type="text/javascript">
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});

		layui.use('laydate', function() {
			var laydate = layui.laydate;

			laydate.render({
				elem : '#date'
			});

		});

		$("#submit").click(function() {
			var date = $("#date").val();
			var sumMonthRecharge = '';
			var sumMonthConsumption = '';
			var sumRecharge = '';
			var sumConsumption = '';
			//异步请求
			$.ajax({
				
				type : "post",
				url : "${pageContext.request.contextPath }/financialManagement?date=" + date,
				dataType : "json",
				success : function(data) {
					sumMonthRecharge = data.sumMonthRecharge;
					sumMonthConsumption = data.sumMonthConsumption;
					sumRecharge = data.sumRecharge;
					sumConsumption = data.sumConsumption;
					$("div.div2").children().remove();
					$("div.div2").append('<div class="div2_small">' +
											'<span class="left">本月所有用户一共充值了</span>' +
											'<span class="right" id="sumMonthRecharge">'+ sumMonthRecharge +'$</span>' +
										'</div>' +
										'<div class="div2_small">' +
											'<span class="left">本月所有用户一共消费了</span>' +
											'<span class="right" id="sumMonthConsumption">'+sumMonthConsumption+'$</span>' +
										'</div>' +
										'<div class="div2_small">' +
											'<span class="left">到目前为止所有用户一共充值了</span>' +
											'<span class="right" id="sumRecharge">'+sumRecharge+'$</span>' +
										'</div>' +
										'<div class="div2_small">' +
											'<span class="left">到目前为止所有用户一共消费了</span>' +
											'<span class="right" id="sumConsumption">'+sumConsumption+'$</span>' +
										'</div>'
										);
				},
				error : function(data) {
					alert("请选择正确的日期");
				}
			});
			//赋值(防止查询为空的月份,返回错误数据类型)
			//$('#sumMonthRecharge').text(sumMonthRecharge);
			//alert("aaa")
			//document.getElementById('sumMonthRecharge').innerText = sumMonthRecharge + '$';
			//document.getElementById('sumMonthConsumption').innerText = sumMonthConsumption + '$';
			//document.getElementById('sumRecharge').innerText = sumRecharge + '$';
			//document.getElementById('sumConsumption').innerText = sumConsumption + '$';
			
			/* document.getElementById('sumMonthRecharge').innerText = sumMonthRecharge;
			
			<div class="div2_small">
				<span class="left">本月所有用户一共充值了</span> 
				<span class="right" id="sumMonthRecharge">$</span>
			</div>
			<div class="div2_small">
				<span class="left">本月所有用户一共消费了</span> 
				<span class="right" id="sumMonthConsumption">$</span>
			</div>
			<div class="div2_small">
				<span class="left">到目前为止所有用户一共充值了</span> 
				<span class="right" id="sumRecharge">$</span>
			</div>
			<div class="div2_small">
				<span class="left">到目前为止所有用户一共消费了</span> 
				<span class="right" id="sumConsumption">$</span>
			</div> */

		});
	</script>
</body>

</html>