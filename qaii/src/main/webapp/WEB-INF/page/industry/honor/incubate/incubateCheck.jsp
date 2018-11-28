<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>科研成果管理系统</title>
 <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/science.css" media="all" />
  <link rel="stylesheet" href="${basePath}/css/industry.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <style>
    body{margin: 10px;}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="techadd" style="width:330px;">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">孵化企业获奖情况&nbsp;—&nbsp;查看详情界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('incubate.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop">
<form class="layui-form" action="insertMinistry.do" method="post" enctype="multipart/form-data" lay-filter="example">
  <!-- 基本信息 -->
	  <div class="layui-row contern">
	  	<h1>基本信息</h1>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">获奖企业名称</label>
			    <div class="layui-input-block">
			      <input type="text" name="awardUnit" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
	    <div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">获奖时间</label>
			    <div class="layui-input-block">
			      <input type="text" name="awardTime" lay-verify="title" autocomplete="off" class="layui-input" id="test1" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">奖励荣誉名称</label>
			    <div class="layui-input-block">
			      <input type="text" name="awardName" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">获奖级别</label>
			    <div class="layui-input-block">
			      <select name="awardLevel" lay-filter="aihao" disabled="">
			        <option value="国际级">国际级</option>
			        <option value="国家级" selected="">国家级</option>
			        <option value="省级">省级</option>
			        <option value="市级">市级</option>
			        <option value="区级">区级</option>
			      </select>
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">颁奖活动名称</label>
			    <div class="layui-input-block">
			      <input type="text" name="activityName" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">主办单位</label>
			    <div class="layui-input-block">
			      <input type="text" name="orgnizer" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
	</div>
	<div class="layui-row contern">
	  	<h1>其他信息</h1>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item itemadd">
				<label class="layui-form-label" style="width:190px;">上传附件（服务证明书）</label>
				<div class="layui-input-block" style="margin-left:210px;">
					<div class="layui-upload">
					   <input type="text" name="file0" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs12 layui-col-md12">
			 <div class="layui-form-item">
			    <label class="site-demo-button layui-form-label">备注</label>
			    <div class="layui-input-block">
			       <textarea class="layui-textarea" name="remark" lay-verify="content" id="LAY_demo_editor" disabled=""></textarea>
			    </div>
			  </div>
		</div>
	</div>
 </form>
 <div class="layui-row">
 	<div class="layui-col-md12">
   		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
	  			<button class="layui-btn" onclick="srchange('incubate.do')">返回</button>
			</div>
  		</div>
	</div>
</div>
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
layui.use(['layer','form', 'layedit', 'laydate','element','upload','table'], function(){
  var form = layui.form,
	element = layui.element,
	layer = layui.layer,
	laydate = layui.laydate,
	upload = layui.upload,
    table = layui.table;
//表单初始赋值
  var id=${param.userId};
  if(id!=null){
		$.post({
			url:"getAwardIncubate.do",
			data:{
				id:id
			},
			success:function(data){
				if(data.data!=null){
					let awardInfo=data.data;
					//表单初始赋值 从表单中提取数据
					  form.val('example', {
						"awardTime":awardInfo.awardTime,
						"awardLevel":awardInfo.awardLevel,
						"awardUnit":awardInfo.awardUnit,
						"awardName":awardInfo.awardName,
						"activityName":awardInfo.activityName,
						"orgnizer":awardInfo.orgnizer,
						"remark":awardInfo.remark,
						"file0":awardInfo.listFile[0].fileName
					  })
				}else{
					alert("查看详情失败")
				}
			}
		})
  }else{
	   alert("请刷新页面");
  }
});
</script>
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>