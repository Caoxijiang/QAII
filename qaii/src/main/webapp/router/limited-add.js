$().ready(function() {
	$.post({
		url:"findRoleuser.do",
		async:false,
		success:function(data){
			if(data.data!==null){
				let result=data.data;
				$(result).each(function(index,element){
					index+=1;
					let heml='<option value='+element.id+'>'+element.roleName+'</option>';
						$("#jiaose").append(heml)
				})
				
			}else{
				$("#jiaose").append("--没有可用权限--");
			}			
		}
			
	})
	
	$("#sub_btn").click(function(){
		var userName=$("#userName").val(); 
		var pwd=$("#password").val();
		var role=$("#jiaose option:selected").val();
		var requestDate = {};
		requestDate["name"] = userName;
		requestDate["password"] = pwd;
		requestDate["role"]=role;
		var str = JSON.stringify(requestDate);
		$.post({
			url:"addRoleuser.do",
			async:false,
			data:{
				"requestDate" : str
			},
			success:function(data){
				console.log(data)
				if (data.data){
					alert("添加成功")	
				}else{
					alert("添加失败")
				}
			}
		})
	})
	
	
})