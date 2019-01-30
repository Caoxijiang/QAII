<!DOCTYPE html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>权限管理</title>
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
<table class="layui-table" id="test" lay-filter="demo" style="width: 100% !important;"></table>
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

 
layui.use(['laydate', 'laypage', 'layer', 'table'], function(obj){
  var table = layui.table,//表格
	layer = layui.layer; 
	
	 //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
  });
  
  //执行一个 table 实例
  table.render({
    elem: '#test',
    height: 332,
    method:'post',
    url: 'findUserRoleList.do', //数据接口
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    page: true, //开启分页
    cols: [[ //标题栏
	  {type:'checkbox'},
      {field: 'id', title: '序号'},
      {field: 'userName', title: '用户名'},
      {field: 'pwd', title: '密码'},
      {field: 'roleName', title: '角色'},
      {field: 'sex', title: '操作',toolbar: '#barDemo'}
    ]],
	  //表格数据
    data:obj.data,
  });
  //监听工具条
  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'detail'){
      layer.msg('用户名：'+JSON.stringify(data.userName)+'<br>密码：'+JSON.stringify(data.pwd)+'<br>角色：'+JSON.stringify(data.roleName));
    } else if(layEvent === 'del'){
      layer.confirm('确定删除信息', function(index){   
        let arr=[data.uid];
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
    				layer.alert( '<div class="layui-form-item">'+
    						'<label class="layui-form-label">角色</label>'+
    						'<div class="layui-input-block">'+
    							'<select name="interest" lay-filter="aihao">'+
    							heml+
    							'</select>'+
    						'</div>'+
    					'</div>');
    				
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
    ,getCheckLength: function(){ //选中批量删除
     var checkStatus = table.checkStatus('test');
     var arr=[];
     for(var obj of checkStatus.data){
    	var data=obj.uid;
    	arr.push(data)    	
    }     
		if(arr.length==0){
			layer.msg("未选中数据！");
		}else{
			layer.confirm('确定删除'+ arr.length + ' 条数据'+JSON.stringify(arr), function(index){
				obj.del(); //删除对应行（tr）的DOM结构
				layer.close(index);
				//向服务端发送删除指令
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
</body>
</html>        
        