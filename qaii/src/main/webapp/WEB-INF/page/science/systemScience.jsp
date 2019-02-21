<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>QAII智慧管理平台</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${basePath}/css/layuiAdd.css">
   <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/jquery.table2excel.js"></script>
  <style>
    body{margin: 10px;}
	.layui-form{border:none;}
	table th{display:none;}
	.systemTest{height:auto;}
	table{ border:none !important;}
	table tr,table td{border:none !important;}
	table tr:hover{background:rgba(0,0,0,0) !important;}
	.layui-table-header{border:none;}
	@media screen and (max-width: 1300px){
		.layui-table-cell {
		    line-height: 32px;
		    padding: 0 15px;
		    position: relative;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    white-space: nowrap;
		    box-sizing: border-box;
		}
	}
  </style>
</head>
<body id="bodyHei">
	<div class="tool">
		<div class="layui-btn-group demoTable">
		  <span class="limit">所有单位</span>
		</div>

	</div>
	<div class="systemBox">
		<table class="layui-hide" id="systemTest" lay-filter="demo"></table>

		<script type="text/html" id="bar">
		  <input type="text" class="department" name="deptName" value="{{d.deptName}}">
		</script>
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs button" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
			<a class="layui-btn layui-btn-xs button" lay-event="del"><i class="layui-icon layui-icon-delete"></i>移除</a>
		</script>
		<div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
			<button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal systemAdd">
				<img src="${basePath}/image/add.png" />
			</button>
		</div>
	</div>
	

<script src="${basePath}/commen/layui/layui.js"></script>
<script>
layui.use('table', function(obj){
  var table = layui.table
  ,form = layui.form;
  
  table.render({
    elem: '#systemTest',
    method:'post',
    url:'listScienceUnit.do',
    cellMinWidth: 80,
    cols: [[
      {field:'id', title:'ID', type:'numbers',width:220},
      {field:'deptName', title:'单位', templet: '#bar'},
      {field:'sex', title:'operation', templet: '#barDemo',width:220}
    ]],
	  data:obj//数据填充id为部门个数，department为部门名称
  });
 //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.id + ' 的查看操作');
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
          let arr=data.id;
          $.post({
          	url:"deleteScienceUnit.do",
          	data:{
          		"requestDate" : arr
          	},
          	success:function(data){
          		if(data.data){
          		    //删除对应行（tr）的DOM结构
          			obj.del();
          			layer.close(index);
          		}else{
          			layer.alert("移除失败")
          		}
          		
          	}
          }) 
      });
    } else if(obj.event === 'edit'){
      //layer.alert('编辑行：<br>'+ JSON.stringify(data.deptName))
    	var edit='<div class="layui-form-item" style="padding:15px;padding-bottom:0px;">'+
		'<label style="padding:9px 5px;">单位修改</label>'+
		'<input id="sys-edit" name="interest" lay-filter="aihao" value="'+
		data.deptName+
		'" style="margin-left:10px;height:36px;width:120px;color:#888;border:1px solid #d7d7d7;border-radius:3px;">'+
		'</input>'+
		'</div>';
		layer.open({
		  type: '单位修改',
		  content:edit //这里content是一个普通的String,
		  ,btn: ['提交修改', '关闭']
		  ,yes: function(index, layero){
		    //提交修改按钮
		    var data = obj.data;
			var role=$("#sys-edit").val();
		    var id=data.id;
		    
			$.post({
				url:"updateScienceUnit.do",
				data:{
					deptName:role,
					id:id
				},
				success:function(data){
					if(data.data){
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
    }
  });
  

  
});
	
	
//添加信息框	
	
layui.use('layer', function(){ //独立版的layer无需执行这一句
  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
 
  //触发事件
  var active = {
    setTop: function(){
      var that = this; 
    }  
    ,offset: function(othis){
      var type = othis.data('type')
      ,text = othis.text();
      var addedit='<div class="layui-form-item" style="padding:15px;padding-bottom:0px;">'+
		'<label style="padding:9px 5px;">单位添加</label>'+
		'<input id="sys-add" name="interest" lay-filter="aihao" style="margin-left:10px;height:36px;width:120px;color:#888;border:1px solid #d7d7d7;border-radius:3px;">'+
		'</input>'+
		'</div>';
      layer.open({
        type: 1
        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'layerDemo'+type //防止重复弹出
        ,content: addedit
        ,btn: ['提交', '关闭']
	  	,yes: function(index, layero){
	    //提交修改按钮
		var role=$("#sys-add").val();
	    if(role==null){
	    	alert("请输入内容")
	    }else{
			$.post({
				url:"insertScienceUnit.do",
				data:{
					deptName:role
				},
				success:function(data){
					if(data.data){
						alert("添加成功")
					}else{
						alert("添加失败")
					}
				}
			})
	    }
						
	    }
	    ,'关闭': function(index, layero){
	     //关闭按钮
	    }
      });
    }
  };
  
  $('#layerDemo .layui-btn').on('click', function(){
    var othis = $(this), method = othis.data('method');
    active[method] ? active[method].call(this, othis) : '';
  });
  
});
</script>
</body>
</html>        
        