<!DOCTYPE html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>权限管理</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${basePath}/css/layuiAdd.css">
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/router/limited-iframe.js"></script>
  <style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
  </style>
</head>
<body>
<div class="tool">
	<div class="layui-btn-group demoTable">
  	  <span class="limit">权限管理（165）</span>
		<button class="layui-btn btn" data-method="offset" data-type="getCheckData" style="margin-left:40px !important;margin-right:16px !important">
			<i class="layui-icon layui-icon-add-1"></i>添加
		</button>
		  <button class="layui-btn btn" data-type="getCheckLength">
			<i class="layui-icon layui-icon-delete"></i>删除
		  </button>
	</div>
</div>

<!-- 数据展示主表格-->
<table class="layui-table" id="test" lay-filter="demo" style="width: 100% !important;margin-top:70px;"></table>
<script type="text/html" id="barDemo">
  
  <a class="layui-btn layui-btn-xs" lay-event="edit">角色修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!-- 数据展示主表格-->
 

<script src="${basePath}/commen/layui/layui.js"></script>
<script>
layui.config({
  version: '1531663423583' //为了更新 js 缓存，可忽略
});

 
layui.use(['laydate','layer', 'table'], function(obj){
  var table = layui.table,//表格
	layer = layui.layer; 
	
	 //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log("1211212"+JSON.stringify(obj))
  });
  
  //执行一个 table 实例
  table.render({
    elem: '#test',
    method:'post',
    url: 'findUserRoleList.do', //数据接口
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    page: false, //开启分页
    cols: [[ //标题栏
	  {type:'checkbox'},
      {field: 'id', title: '序号',type:'numbers'},
      {field: 'userName', title: '用户名'},
      {field: 'pwd', title: '密码'},
      {field: 'roleName', title: '角色'},
      {field: 'sex', title: '操作',toolbar: '#barDemo'}
    ]],
	  //表格数据
    data:obj.data,
  });
  console.log(obj)
  //监听工具条
  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'detail'){
      layer.msg('用户名：'+JSON.stringify(data.userName)+'<br>密码：'+JSON.stringify(data.pwd)+'<br>角色：'+JSON.stringify(data.roleName));
    } else if(layEvent === 'del'){
      layer.confirm('确定删除信息', function(index){   
        let arr=[data.uid];
        console.log(arr) 
        $.post({
        	url:"DellUserAccount.do",
        	data:{
        		"requestDate" : arr
        	},
        	success:function(data){
        		if(data.data){
        		    //删除对应行（tr）的DOM结构
        			obj.del();
        			layer.close(index);
        		}else{
        			layer.alert("删除失败")
        		}
        		
        	}
        }) 
        
      });
    } else if(layEvent === 'edit'){
    	var rid=JSON.stringify(data.roleName);
    	$.post({
    		url:"findRoleuser.do",
    		async:false,
    		success:function(data){
    			if(data.data!==null){
    				let result=data.data;
    				let heml='';
    				$(result).each(function(index,element){
    					index+=1;
    					if(rid.indexOf(element.roleName)>-1){
    						heml=heml+ '<option value='+element.id+' selected="">'+element.roleName+'</option>';
    						
    					}else{
    						heml=heml+'<option value='+element.id+'>'+element.roleName+'</option>';
    					}	
    						
    				})
    				/* layer.alert( '<div class="layui-form-item">'+
    						'<label class="layui-form-label">角色</label>'+
    						'<div class="layui-input-block">'+
    							'<select name="interest" lay-filter="aihao">'+
    							heml+
    							'</select>'+
    						'</div>'+
    					'</div>'); */
    				var edit='<div class="layui-form-item" style="padding:15px;padding-bottom:0px;">'+
								'<label style="padding:9px 5px;">角色</label>'+
								'<select id="limit-edit" name="interest" lay-filter="aihao" style="margin-left:10px;height:36px;width:120px;color:#888;border:1px solid #d7d7d7;border-radius:3px;">'+
								heml+
								'</select>'+
								'</div>';
    				layer.open({
    					  type: '角色修改', 
    					  content:edit //这里content是一个普通的String,
    					  ,btn: ['提交修改', '关闭']
	    				  ,yes: function(index, layero){
	    				    //提交修改按钮
	    				    var data = obj.data;
    						var uid=data.uid;
    						var role=$("#limit-edit option:selected").val();
    						$.post({
    							url:"updateUserRole.do",
    							async:false,
    							data:{
    								uid:uid,
    								rid:role
    							},
    							success:function(data){
    								console.log(data)
    								if (data.data){
    									alert("修改成功")	
    								}else{
    									alert("修改失败")
    								}
    							}
    						}) 
    						
	    						
	    				  }
	    				  ,'关闭': function(index, layero){
	    				    //关闭按钮
	    				  }
	    			});
    				
    			}else{
    				$("#jiaose").append("--没有可用权限--");
    			}			
    		}
    			
    	})
    	
    }
  });

	//监听顶部添加删除操作
	
	var $ = layui.$, active = {
    getCheckData: function(){ //添加数据按钮表单
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.open({
				type: 2, 
				content: 'RoleIframeadd.do' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			}); 
		});    
    }
    ,getCheckLength: function(obj){ //选中批量删除
     var checkStatus = table.checkStatus('test');
     var arr=[];
     for(var obj of checkStatus.data){
    	var data=obj.uid;
    	arr.push(data)    	
    }     
     console.log(arr)
		if(arr.length==0){
			layer.msg("未选中数据！");
		}else{
			layer.confirm('确定删除'+ arr.length + ' 条数据'+JSON.stringify(arr), function(index){
		        $.post({
		        	url:"DellUserAccount.do",
		        	data:{
		        		"requestDate" : arr
		        	},
		        	success:function(data){
		        		if(data.data){
		        		    //删除对应行（tr）的DOM结构
		        			 window.location.reload()
		        			layer.close(index);
		        		}else{
		        			layer.alert("删除失败")
		        		}
		        		
		        	}
		        }) 
			
			});
		}
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
	
	

  
});
</script>

<!--自动设置主表格可视区域-->
<script>
	var ji=$(document).height();
	var heigt=ji-85;
	$(".layui-table-box").prop("height",heigt+"px !important");
	console.log(heigt);

	
</script>
<!-- 角色修改 弹窗 提交修改效果 -->
<script>
$(document).on('click','#limitEdit',function(){
	var role=$("#limit-edit option:selected").val();
	console.log("fds"+role);
})

/*	var userName=$("#userName").val(); 
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
	})*/

</script>
</body>
</html>        
        