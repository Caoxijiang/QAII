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
				股东出资时间提醒
				<i class="layui-icon layui-icon-up" style="float: right;line-height: 32px;"></i>
			</div>
			<div class="messagecontern">
				<table class="layui-table" id="testTable" lay-filter="demo" style="margin-top:5px;width: 100% !important;"></table>
				<script type="text/html" id="barDemo">
					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">已处理</a>
					<a class="layui-btn layui-btn-xs" lay-event="detail">查看详情</a>
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
	url:"Ihkp.do",//修改端口号 获取的股东出资时间的表格
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{field: 'id', title: '序号',type:'numbers'},
		{field: 'companyName', title: '企业名称'},
		{field: 'creditCode', title: '统一社会信用代码'},
		{field: 'establishTime', title: '成立时间'},
		{field: 'companyType', title: '公司类型'},
		{field: 'legalRepresentative', title: '法定代表人'},
		{field: 'shareholderName', title: '股东名称'},
		{field: 'contributionProportion', title: '出资比例'},
		{field: 'contributionTime', title: '出资时间'},
        {field: 'shareholderPosition', title: '股东职务'},
		{field: 'sex', title: '操作',toolbar: '#barDemo',width:320}
    ]],
	  //表格数据
    data:obj.data
  });
  //监听工具条
  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
      var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
      if(layEvent === 'detail'){
          var iframesrc="hatchCheck.do?id="+data.incubatorid;
          $("body", parent.document).find('iframe').attr('src',iframesrc);
      } else if(layEvent === 'del'){
          var iframesrc="Imby.do?id="+data.id;
          $("body", parent.document).find('iframe').attr('src',iframesrc);
    } 
  });

});

//页面数据刷新
$('#pelupdate').on('click', function(){
	window.location.reload();
	alert("数据更新成功");
  });
</script>
	<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>        
        