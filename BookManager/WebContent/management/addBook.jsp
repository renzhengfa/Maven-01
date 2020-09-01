<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>添加图书</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/management/layui/css/layui.css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath }/management/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/management/js/addBook.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/management/css/addStyle.css" />
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div
			style="width: 100%; height: 500px; border: 0px solid red; padding-top: 60px;"
			class="layui-container">
			<div class="layui-row">
				<div class="layui-col-md5"
					style="text-align: right; line-height: 40px;">
					<!-- 左边部分 -->
					<ol>
						<li>上传图片</li>
						<li>上传图书</li>
						<li>图 书 名</li>
						<li>作 者</li>
						<li>价 格</li>
						<li>分 类</li>
						<li>简 介</li>
					</ol>
				</div>
				<div class="layui-col-md7"
					style="text-align: center; line-height: 50px;">
					
					<form action="${pageContext.request.contextPath }/uploadImg" 
					method="post" enctype="multipart/form-data" id="formPost">
						<!-- 上传图片 -->
						<span class="span1">
							<input type="file" name="myImg" class="layui-input" >
						</span>
						<!-- 上传图书 -->
						<span class="span2">
							<input type="file" name="myFile" class="layui-input" >
						</span>
						<!-- 图书名 -->
						<span class="span2"> 
							<input type="text" name="bookName" class="layui-input" id="bookName">
							<span id="bookNameAl"></span>
						</span>
						<!-- 作者 -->
						<span class="span2"> 
							<input type="text" name="author" class="layui-input" id="author">
							<span id="authorAl"></span>
						</span>
						<!-- 价格 -->
						<span class="span2"> 
							<input type="text" name="price" class="layui-input" id="price">
							<span id="priceAl"></span>
						</span>
						<!-- 分类 -->
						<select name="type" id="type">
							<option value="0">请选择一个分类</option>
							<option value="1">男生</option>
							<option value="2">女生</option>
							<option value="3">免费</option>
							<option value="4">付费</option>
							<option value="5">连载</option>
							<option value="6">完结</option>
						</select>
						<!-- 简介 -->
						<textarea style="width: 250px; height: 80px; margin-top: 20px; margin-left: 10px;"
							name="subscript" class="layui-textarea">
						</textarea>
						<!-- 按钮 -->
						<input id="btn1" class="layui-btn layui-btn-warm" type="submit" value="立即提交" /> 
						<input id="btn2" class="layui-btn layui-btn-warm" type="reset" value="重置" />
					</form>
				</div>
			</div>
			<c:if test="${not empty alertErrorInfo }">
				<span class="fail">${ alertErrorInfo } </span>
			</c:if>
			<c:if test="${not empty alertSuccessInfo }">
				<span class="success">${ alertSuccessInfo } </span>
			</c:if>
		</div>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		© 添加图书 - 底部固定区域
	</div>
	<script type="text/javascript">
		
	</script>
</body>

</html>