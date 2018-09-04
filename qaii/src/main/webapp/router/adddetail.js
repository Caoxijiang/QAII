$().ready(function(){
	$.post({
		url:"findDeptInfoList.do",
		success:function(data){
			var deptInfo=data.data;
			console.log(deptInfo);
			if(deptInfo!=null){
				$(deptInfo).each(function(index,element){
					index+=1;
					let heml='<dd lay-value="'+element.deptName+'">'+element.deptName+'</dd>';
					console.log(heml);
					//let heml='<option value='+element.deptName+'>'+element.deptName+'</option>';
					$("#deptt").next(".layui-form-select").children("dl").append(heml);
				})						
				
			}else{
				alert("部门信息显示失败");
			}
		}
	})
})