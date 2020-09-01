
$(function(){
	
	
	
	$("#bookName").blur(function(){
		var bookname = $("#bookName").val();
		var check = /^[\u4e00-\u9fa50-9]{1,15}$/;
		// alert(username)
		if (bookname == '') {
			$("#bookNameAl").css("color", "red");
			$("#bookNameAl").text("");
			$("#bookNameAl").text("图书名不能为空");
			return false;
		} else if (!check.test(bookname)) {
			$("#bookNameAl").css("color", "red");
			$("#bookNameAl").text("");
			$("#bookNameAl").text("图书名为长度为1-15的汉字或数字组成");
			return false;
		} else {
			$("#bookNameAl").text("");
			return true;
		}
	});
	
	$("#author").blur(function(){
		var author = $("#author").val();
		var check = /^[\u4e00-\u9fa50-9]{1,8}$/;
		// alert(username)
		if (author == '') {
			$("#authorAl").css("color", "red");
			$("#authorAl").text("");
			$("#authorAl").text("作者不能为空");
			return false;
		} else if (!check.test(author)) {
			$("#authorAl").css("color", "red");
			$("#authorAl").text("");
			$("#authorAl").text("作者为长度为1-8的汉字或数字组成");
			return false;
		} else {
			$("#authorAl").text("");
			return true;
		}
	});
	
	$("#price").blur(function(){
		var price = $("#price").val(); 
		//如果变量val是字符类型的数则转换为int类型 如果不是则ival为NaN alert(typeof(ival)); 
		var ival = parseInt(price);
		$("#price").val(ival);
		/*if(!isNaN(ival)){ 
			alert(val +"是数字"); 
		} else{ 
			alert(val +"不是数字"); 
		}*/
		// alert(username)
		if (price == '') {
			$("#priceAl").css("color", "red");
			$("#priceAl").text("");
			$("#priceAl").text("价格不能为空");
			return false;
		} else if (isNaN(ival)) {
			$("#priceAl").css("color", "red");
			$("#priceAl").text("");
			$("#priceAl").text("价格为数字");
			return false;
		} else {
			$("#priceAl").text("");
			return true;
		}
	});
	
	
	$("#formPost").submit(function(){
		//如果变量val是字符类型的数则转换为int类型 如果不是则ival为NaN alert(typeof(ival)); 
		var author = $("#author").val();
		var checkAuthor = /^[\u4e00-\u9fa50-9]{1,8}$/;
		
		var bookname = $("#bookName").val();
		var checkBookname = /^[\u4e00-\u9fa50-9]{1,15}$/;
		
		var type = $('#type option:selected').val();
		
		if (bookname == '') {
			return false;
		} else if (!checkAuthor.test(author)) {
			return false;
		} else if(author == ''){
			return false;
		} else if (!checkBookname.test(bookname)) {
			return false;
		} else if (type == 0) {
			return false;
		} else {
			return true;
		}
	});
	
});





