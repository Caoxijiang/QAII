$().ready(function(){
	$.post({
		url:"findDeptInfoList.do",
		success:function(data){
			console.log(data);
		}
	})
})