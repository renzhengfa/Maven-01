
//页面加载事件
window.onload = function(){
	//实现banner区的图片轮播
	var banner = document.getElementById("banner-img");
	
	var i = 1;
	
	setInterval(function(){ 
		++i;
		if(i == 5){//到最后一张跳转回第一张
			i = 1;
		}
		banner.src = "img/indexImgs/banner" + i + ".jpg";
	}, 3000);

}
