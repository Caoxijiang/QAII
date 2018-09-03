<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>所有部门</title>
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${basePath}/css/layuiAdd.css">
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
  </style>
</head>
<body id="bodyHei">
	<div class="tool">
		<div class="layui-btn-group demoTable">
		  <span class="limit">所有部门</span>
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
    url:'findDeptInfoList.do',
    cellMinWidth: 80,
    cols: [[
      {field:'id', title:'ID', width:220},
      {field:'deptName', title:'部门', templet: '#bar',width:680},
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
    	  console.log(JSON.stringify(data))
          let arr=data.id;
          console.log(data) 
          $.post({
          	url:"dellDeptInfo.do",
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
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
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
      
      layer.open({
        type: 1
        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'layerDemo'+type //防止重复弹出
        ,content: '<div style="padding: 20px 100px;">添加表单</div>'
        ,btn: '关闭全部'
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
          layer.closeAll();
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
        