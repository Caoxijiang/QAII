$().ready(function(){
	
	// JavaScript Document
	//设置一个全局的变量，便于保存验证码
	

//	$("").click(function(){
//		
//	})
	   // var code;
	    function createCode(){
	        //首先默认code为空字符串
	        code = '';
	        //设置长度，这里看需求，我这里设置了4
	        let codeLength = 4;
	        let codeV = document.getElementById('code');
	        //设置随机字符
	        let random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
	        //循环codeLength 我设置的4就是循环4次
	        for(let i = 0; i < codeLength; i++){
	            //设置随机数范围,这设置为0 ~ 36
	             let index = Math.floor(Math.random()*36);
	             //字符串拼接 将每次随机的字符 进行拼接
	             code += random[index]; 
	        }
	        //将拼接好的字符串赋值给展示的Value
	        
	        return code;
	      
	    }
//    		    
	    
//	    
//	    function validate(){
//        var oValue = document.getElementById('input').value.toUpperCase();
//        if(oValue ==0){
//            alert('请输入验证码');
//        }else if(oValue != code){
//            alert('验证码不正确，请重新输入');
//            oValue = ' ';
//            createCode();
//        }else{
//        	document.location.href='indexUI.do';
//        }
//    }
//	    
	    
	
	$("#login_btn").click(function(){
	    //下面就是判断是否== 的代码，无需解释
		var userName=$("#userName").val(); 
		var pwd=$("#password").val();
		var requestDate = {};
		requestDate["name"] = userName;
		requestDate["password"] = pwd;
		var str = JSON.stringify(requestDate);
		var oValue = document.getElementById('input').value.toUpperCase();
		alert(oValue)
        if(oValue ==null){
            alert('请输入验证码');
            return;
        }else if(oValue != code){
            alert('验证码不正确，请重新输入');
            oValue = ' ';
            createCode();
            return;
        }
		$.post({
			url:"checkLogin.do",
			data:{
				"requestDate" : str
			},
			success:function(data){
				console.log(JSON.stringify(data))
			var result=data.data;
			if(result.USERROLEURL!=null){
				document.location.href=result.USERROLEURL;
			}else if(result.USERROLEURL==null && result.message=="OK"){
				alert("无权限账号");
				document.location.href='indexUI.do';
			}else if(result==null){
				alert("账号或密码错误");
				document.location.href='indexUI.do';
			}
			}
		})

	})
})