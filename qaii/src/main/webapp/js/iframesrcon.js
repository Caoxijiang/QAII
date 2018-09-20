$(function(){
	$(document).on('click','.patentProcess',function(){
		var stepnum="";
		stepnum=$(this).attr("name");
		$("body", parent.document).find('iframe').attr('src','patentProcess.do?userId='+userID+'&step='+stepnum);
	});
});