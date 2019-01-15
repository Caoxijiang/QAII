$().ready(function(){
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
})