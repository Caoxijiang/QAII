<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>消息管理</title>
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

			<button class="layui-btn btn" data-type="getCheckLength" style="margin-left:40px !important;margin-right:16px !important">
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
				  <a class="layui-btn layui-btn-xs layui-btn-details" href="adddetail.html" target="_blank">查看详情</a>
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
				  <a class="layui-btn layui-btn-xs" href="adddetail.html" target="_blank">查看详情</a>
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
				  <a class="layui-btn layui-btn-xs" href="adddetail.html" target="_blank">查看详情</a>
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
				  <a class="layui-btn layui-btn-xs" href="adddetail.html" target="_blank">查看详情</a>
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

 
layui.use('table', function(){
  var table = layui.table,form = layui.form;
	
  
  //执行一个 table 实例
  table.render({
    elem: '#testTable',
	page: false,
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload', 
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'emp_num', title: '工号'},
		{field: 'emp_name', title: '姓名'},
		{field: 'emp_dept', title: '部门',sort: true},
		{field: 'emp_position', title: '职务',sort: true},
		{field: 'emp_hire_startTime', title: '聘期',sort: true},
		{field: 'emp_phone', title: '联系电话'},
		{field: 'emp_workType', title: '用工形式',sort: true},
		{field: 'emp_inductionTime', title: '入职时间',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo',width:320}
    ]],
	  //表格数据
    data: [{
		"id":'1',
		"emp_num":'1',
		"emp_name":'姓名',
		"emp_gender":'性别',
		"emp_dept":'部门',
		"emp_position":'职务',
		"emp_hire_startTime":'聘期',
		"emp_idcard":'身份证号',
		"emp_phone":'手机号',
		"emp_workType":'用工形式',
		"emp_inductionTime":'入职时间',
		 },{
		"id":'3',
		"emp_num":'3',
		"emp_name":'asd',
		"emp_gender":'女',
		"emp_dept":'婿',
		"emp_position":'水电费感受到',
		"emp_hire_startTime":'身份',
		"emp_idcard":'20145678952410254278',
		"emp_phone":'45621862356',
		"emp_workType":'合同',
		"emp_inductionTime":'2018-08-08',
		 }]
  });

  //监听工具条
  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'dimission'){
      layer.msg('审核通过');
    } else if(layEvent === 'del'){
      layer.confirm('确定驳回申请', function(index){
        layer.close(index);
        //向服务端发送删除指令
      });
    } 
  });
	
	
  //身份证到期
  table.render({
    elem: '#testTable2',
	page: false,
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload2', 
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'emp_num', title: '工号'},
		{field: 'emp_name', title: '姓名'},
		{field: 'emp_gender', title: '性别',sort: true},
		{field: 'emp_dept', title: '部门',sort: true},
		{field: 'emp_position', title: '职务',sort: true},
		{field: 'emp_idcard', title: '身份证号'},
		{field: 'emp_idcard_endTime', title: '身份证到期时间',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo2'}
    ]],
	  //表格数据
    data: [{
		"id":'1',
		"emp_num":'1',
		"emp_name":'姓名',
		"emp_gender":'性别',
		"emp_dept":'部门',
		"emp_position":'职务',
		"emp_idcard":'身份证号',
		"emp_idcard_endTime":'身份证到期时间'
		 },{
		"id":'2',
		"emp_num":'2',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16'
		 },{
		"id":'3',
		"emp_num":'3',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16'
		 },{
		"emp_num":'17',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16'
		 }]
  });



//试用期到期
  table.render({
    elem: '#testTable3',
	page: false,
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload3', 
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'emp_num', title: '工号'},
		{field: 'emp_name', title: '姓名'},
		{field: 'emp_gender', title: '性别',sort: true},
		{field: 'emp_dept', title: '部门',sort: true},
		{field: 'emp_position', title: '职务',sort: true},
		{field: 'emp_workType', title: '用工形式',sort: true},
		{field: 'emp_inductionTime', title: '入职时间',sort: true},
		{field: 'emp_tryOutEndTime', title: '试用期结束日期',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo3'}
    ]],
	  //表格数据
    data: [{
		"id":'1',
		"emp_num":'1',
		"emp_name":'姓名',
		"emp_gender":'性别',
		"emp_dept":'部门',
		"emp_position":'职务',
		"emp_hire_startTime":'聘期',
		"emp_idcard":'身份证号',
		"emp_idcard_endTime":'身份证到期时间',
		"emp_ethnic":'名族',
		"emp_politicalLandscape":'政治面貌',
		"emp_maritalStatus":'婚姻状态',
		"emp_workType":'用工形式',
		"emp_compile":'编制',
		"emp_inductionTime":'入职时间',
		"emp_tryOutEndTime":'试用期结束时间',
		"emp_contractEndTime":'合同期满日期',
		"emp_contractSignedNum":'合同签订次数',
		"emp_returnee":'是否归国人员',
		"emp_foreign":'是否外籍人员',
		"emp_remarks":'备注'
		 },{
		"id":'2',
		"emp_num":'2',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16',
		"emp_ethnic":'汉',
		"emp_politicalLandscape":'团员',
		"emp_maritalStatus":'未婚',
		"emp_firstEducation":'本科',
		"emp_secondEducation":'研究生',
		"emp_thirdEducation":'博士',
		"emp_workType":'合同工',
		"emp_compile":'是',
		"emp_inductionTime":'2018-09-16',
		"emp_tryOutEndTime":'2018-09-16',
		"emp_contractEndTime":'2018-09-16',
		"emp_contractSignedNum":'3',
		"emp_returnee":'否',
		"emp_foreign":'否',
		"emp_remarks":'备注备注备注'
		 },{
		"id":'3',
		"emp_num":'3',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16',
		"emp_ethnic":'汉',
		"emp_politicalLandscape":'团员',
		"emp_maritalStatus":'未婚',
		"emp_firstEducation":'本科',
		"emp_secondEducation":'研究生',
		"emp_thirdEducation":'博士',
		"emp_workType":'合同工',
		"emp_compile":'是',
		"emp_inductionTime":'2018-09-16',
		"emp_tryOutEndTime":'2018-09-16',
		"emp_contractEndTime":'2018-09-16',
		"emp_contractSignedNum":'3',
		"emp_returnee":'否',
		"emp_foreign":'否',
		"emp_remarks":'备注备注备注'
		 },{
		"emp_num":'17',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16',
		"emp_ethnic":'汉',
		"emp_politicalLandscape":'团员',
		"emp_maritalStatus":'未婚',
		"emp_firstEducation":'本科',
		"emp_secondEducation":'研究生',
		"emp_thirdEducation":'博士',
		"emp_workType":'合同工',
		"emp_compile":'是',
		"emp_inductionTime":'2018-09-16',
		"emp_tryOutEndTime":'2018-09-16',
		"emp_contractEndTime":'2018-09-16',
		"emp_contractSignedNum":'3',
		"emp_returnee":'否',
		"emp_foreign":'否',
		"emp_remarks":'备注备注备注'
		 }]
  });




//合同期满
  table.render({
    elem: '#testTable4',
	page: false,
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload4', 
//    height: 332,
//    ,url: '/demo/table/user/' //数据接口
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
   cols: [[ //标题栏
		{field: 'id', title: '序号'},
		{field: 'emp_num', title: '工号'},
		{field: 'emp_name', title: '姓名'},
		{field: 'emp_gender', title: '性别',sort: true},
		{field: 'emp_dept', title: '部门',sort: true},
		{field: 'emp_position', title: '职务',sort: true},
		{field: 'emp_hire_startTime', title: '聘期',sort: true},
		{field: 'emp_workType', title: '用工形式',sort: true},
		{field: 'emp_inductionTime', title: '入职时间',sort: true},
		{field: 'emp_contractEndTime', title: '合同期满日期',sort: true},
		{field: 'emp_contractSignedNum', title: '合同签订次数',sort: true},
		{field: 'sex', title: '操作',toolbar: '#barDemo4'}
    ]],
	  //表格数据
    data: [{
		"id":'1',
		"emp_num":'1',
		"emp_name":'姓名',
		"emp_gender":'性别',
		"emp_dept":'部门',
		"emp_position":'职务',
		"emp_hire_startTime":'聘期',
		"emp_idcard":'身份证号',
		"emp_idcard_endTime":'身份证到期时间',
		"emp_ethnic":'名族',
		"emp_politicalLandscape":'政治面貌',
		"emp_jobTitle":'职称名称',
		"emp_jobTitleLevel":'职称等级',
		"emp_jobTitleObtainTime":'获取职称时间',
		"emp_phone":'手机号',
		"emp_emergencyContactAndPhone":'紧急联系人姓名以及联系手机号',
		"emp_fileAddress":'档案所在地',
		"emp_accountAddress":'户口所在地',
		"emp_homeAddress":'家庭住址',
		"emp_workType":'用工形式',
		"emp_compile":'编制',
		"emp_inductionTime":'入职时间',
		"emp_tryOutEndTime":'试用期结束时间',
		"emp_contractEndTime":'合同期满日期',
		"emp_contractSignedNum":'合同签订次数',
		"emp_returnee":'是否归国人员',
		"emp_foreign":'是否外籍人员',
		"emp_remarks":'备注'
		 },{
		"id":'2',
		"emp_num":'2',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16',
		"emp_ethnic":'汉',
		"emp_politicalLandscape":'团员',
		"emp_maritalStatus":'未婚',
		"emp_firstEducation":'本科',
		"emp_secondEducation":'研究生',
		"emp_thirdEducation":'博士',
		"emp_workType":'合同工',
		"emp_compile":'是',
		"emp_inductionTime":'2018-09-16',
		"emp_tryOutEndTime":'2018-09-16',
		"emp_contractEndTime":'2018-09-16',
		"emp_contractSignedNum":'3',
		"emp_returnee":'否',
		"emp_foreign":'否',
		"emp_remarks":'备注备注备注'
		 },{
		"id":'3',
		"emp_num":'3',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16',
		"emp_ethnic":'汉',
		"emp_politicalLandscape":'团员',
		"emp_maritalStatus":'未婚',
		"emp_firstEducation":'本科',
		"emp_secondEducation":'研究生',
		"emp_workType":'合同工',
		"emp_compile":'是',
		"emp_inductionTime":'2018-09-16',
		"emp_tryOutEndTime":'2018-09-16',
		"emp_contractEndTime":'2018-09-16',
		"emp_contractSignedNum":'3',
		"emp_returnee":'否',
		"emp_foreign":'否',
		"emp_remarks":'备注备注备注'
		 },{
		"emp_num":'17',
		"emp_name":'李璐萍',
		"emp_gender":'女',
		"emp_dept":'平行工作室',
		"emp_position":'院长助理',
		"emp_hire_startTime":'3年',
		"emp_idcard":'370729699784561235',
		"emp_idcard_endTime":'2018-09-16',
		"emp_ethnic":'汉',
		"emp_politicalLandscape":'团员',
		"emp_maritalStatus":'未婚',
		"emp_firstEducation":'本科',
		"emp_secondEducation":'研究生',
		"emp_thirdEducation":'博士',
		"emp_workType":'合同工',
		"emp_compile":'是',
		"emp_inductionTime":'2018-09-16',
		"emp_tryOutEndTime":'2018-09-16',
		"emp_contractEndTime":'2018-09-16',
		"emp_contractSignedNum":'3',
		"emp_returnee":'否',
		"emp_foreign":'否',
		"emp_remarks":'备注备注备注'
		 }]
  });



});

	
</script>
</body>
</html>        
        