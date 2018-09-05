<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>消息管理</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${basePath}/css/layuiAdd.css">
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/jquery.table2excel.js"></script>
  <style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
	.noExl {
    display: none;
}
  </style>
</head>
<body id="bodyHei">
	<div class="tool">
		<div class="layui-btn-group demoTable">
		  <span class="limit">消息管理</span>

			<button class="layui-btn btn" id="pelupdate" style="margin-left:40px !important;margin-right:16px !important">
				<i class="layui-icon layui-icon-refresh-3"></i>更新
			</button>	
		</div>

	</div>
<!--	入职信息审核-->
	<div class="message">
		<div class="messagebox">
			<div class="messageTitle">
				入职信息审核
				<i class="layui-icon layui-icon-up" style="float: right;line-height: 32px;"></i>
			</div>
			<div class="messagecontern">
				<table class="layui-table" id="testTable" lay-filter="demo" style="margin-top:5px;width: 100% !important;"></table>
				<script type="text/html" id="barDemo">
				  <a class="layui-btn layui-btn-xs layui-btn-tired" lay-event="dimission">审核通过</a>
				  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">驳回申请</a>
				  <a class="layui-btn layui-btn-xs layui-btn-details" href="seeEmpInfo.do?userId='{{d.id}}'" target="_blank">查看详情</a>
				</script>
			</div>
		
		</div>
		
		<!--	身份证到期  -->
		<div class="messagebox" style="margin-top:50px;">
			<div class="messageTitle">
				身份证到期
				<i class="layui-icon layui-icon-up" style="float: right;line-height: 32px;"></i>
			</div>
			<div class="messagecontern">
				<table class="layui-table" id="testTable2" lay-filter="demo2" style="margin-top:5px;width: 100% !important;"></table>
				<script type="text/html" id="barDemo2">
				  <a class="layui-btn layui-btn-xs" href="seeEmpInfo.do?userId='{{d.id}}'" target="_blank">查看详情</a>
				</script>
			</div>
		
		</div>
		
		<!--	试用期到期  -->
		<div class="messagebox" style="margin-top:50px;">
			<div class="messageTitle">
				试用期到期
				<i class="layui-icon layui-icon-up" style="float: right;line-height: 32px;"></i>
			</div>
			<div class="messagecontern">
				<table class="layui-table" id="testTable3" lay-filter="demo3" style="margin-top:5px;width: 100% !important;"></table>
				<script type="text/html" id="barDemo3">
				  <a class="layui-btn layui-btn-xs" href="seeEmpInfo.do?userId='{{d.id}}'" target="_blank">查看详情</a>
				</script>
			</div>
		
		</div>
		
		<!--	合同期满日期   -->
		<div class="messagebox" style="margin-top:50px;">
			<div class="messageTitle">
				合同期满日期
				<i class="layui-icon layui-icon-up" style="float: right;line-height: 32px;"></i>
			</div>
			<div class="messagecontern">
				<table class="layui-table" id="testTable4" lay-filter="demo4" style="margin-top:5px;width: 100% !important;"></table>
				<script type="text/html" id="barDemo4">
				  <a class="layui-btn layui-btn-xs" lay-event="detail" href="seeEmpInfo.do?userId='{{d.id}}'" target="_blank">查看详情</a>
				</script>
			</div>
		
		</div>
		
	</div>

<script>
	$(document).ready(function(){
	  $("i").click(function(){
		  //内容隐藏设置
		  if($(this).hasClass("layui-icon-up")){
			   $(this).removeClass("layui-icon-up");
			   $(this).addClass("layui-icon-down");
			  $(this).parent().css("border","none");
			  console.log("向上");
		  }else{ //内容显示设置
			  $(this).removeClass("layui-icon-down");
			  $(this).addClass("layui-icon-up");
			  $(this).parent().css("borderBottom","1px solid #9fa0a0");
		  }
	  	$(this).parent().next($(".messagecontern")).toggle();
	  });
	});

</script>

<script src="${basePath}/commen/layui/layui.js"></script>
<script>
	
layui.config({
  version: '1531663423583' //为了更新 js 缓存，可忽略
});

 
layui.use('table', function(obj){
  var table = layui.table,form = layui.form;
  function getrevmsg(){
	  var result=new Array();
	  $.post({
		url:"getIDexpire.do",
		data:{"reviewstatus":"待审核"},
		async:false,
		success:function(data){
			//data.forEach(function(e){
			//	alert(e.eid);
			//	})
			result=data;
		}
	  })
	  return result;
  }
  var _revmsg=getrevmsg();
  //执行一个 table 实例
  table.render({
    elem: '#testTable',
	page: false,
	method:'post',
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload', 
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	url:"getstatusbyreview.do",
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'empNum', title: '工号'},
		{field: 'empName', title: '姓名'},
		{field: 'empDept', title: '部门',sort: true},
		{field: 'empPosition', title: '职务',sort: true},
		{field: 'empHireStarttime', title: '聘期',sort: true},
		{field: 'empPhone', title: '联系电话'},
		{field: 'empWorktype', title: '用工形式',sort: true},
		{field: 'empInductiontime', title: '入职时间',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo',width:320}
    ]],
	  //表格数据
    data:obj.data
  });
  console.log(obj.data);
  //监听工具条
  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'dimission'){
    	layer.confirm("确定要通过审核？",function(){
    		layer.msg('审核通过');
    		$.post({
    			url:"upReview.do",
    			data:{"msg":"通过","id":data.id},
    			success:function(count){
    				if(count!=1){
    					alert("操作失败，请检查员工审核信息是否准确");
    				}else{
    					obj.del();
    					layer.close(index);
    				}
    			}
    		})
    	})
      
    } else if(layEvent === 'del'){
      layer.confirm('确定驳回申请', function(index){
    	  let arr=[data.id];
          console.log(data) 
          $.post({
          	url:"DellempInfo.do",
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
    } 
  });
	
	
  //身份证到期
  table.render({
    elem: '#testTable2',
	page: false,
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload2', 
	method:'post',
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	url:'getiDexpire.do',
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'empNum', title: '工号'},
		{field: 'empName', title: '姓名'},
		{field: 'empGender', title: '性别',sort: true},
		{field: 'empDept', title: '部门',sort: true},
		{field: 'empPosition', title: '职务',sort: true},
		{field: 'empIdcard', title: '身份证号'},
		{field: 'empIdcardEndtime', title: '身份证到期时间',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo2'}
    ]],
	  //表格数据
    data:obj.data
  });

  console.log(obj);


//试用期到期
  table.render({
    elem: '#testTable3',
	page: false,
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload3', 
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	url:'getTryemp.do',
	method:'post',
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'empNum', title: '工号'},
		{field: 'empName', title: '姓名'},
		{field: 'empGender', title: '性别',sort: true},
		{field: 'empDept', title: '部门',sort: true},
		{field: 'empPosition', title: '职务',sort: true},
		{field: 'empWorktype', title: '用工形式',sort: true},
		{field: 'empInductiontime', title: '入职时间',sort: true},
		{field: 'empTryoutendtime', title: '试用期结束日期',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo3'}
    ]],
	  //表格数据
    data: obj.data
  });




//合同期满
  table.render({
    elem: '#testTable4',
	page: false,
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload4', 
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	url:'getConemp.do',
	method:'post',
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
   cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'empNum', title: '工号'},
		{field: 'empName', title: '姓名'},
		{field: 'empGender', title: '性别',sort: true},
		{field: 'empDept', title: '部门',sort: true},
		{field: 'empPosition', title: '职务',sort: true},
		{field: 'empHireStarttime', title: '聘期',sort: true},
		{field: 'empWorktype', title: '用工形式',sort: true},
		{field: 'empInductiontime', title: '入职时间',sort: true},
		{field: 'empContractendtime', title: '合同期满日期',sort: true},
		{field: 'empContractsignednum', title: '合同签订次数',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo4'}
    ]],
	  //表格数据
    data: obj.data
  });



});

//页面数据刷新
$('#pelupdate').on('click', function(){
	window.location.reload();
	alert("数据更新成功");
  });	
</script>
</body>
</html>        
        