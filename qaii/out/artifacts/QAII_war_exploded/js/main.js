// JavaScript Document
$(function(){		   
	var widthbi=window.innerWidth/1920;
	var heightbi=window.innerHeight/1080;
	$(".mainbody").css("transform","scale("+widthbi+","+heightbi+")");
	
$(window).resize(function(){
	var widthbi2=window.innerWidth/1920;
	var heightbi2=window.innerHeight/1080;
	$(".mainbody").css("transform","scale("+widthbi2+","+heightbi2+")");
		
});

})	
