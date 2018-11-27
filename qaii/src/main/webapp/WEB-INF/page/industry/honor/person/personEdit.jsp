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
	<div class="techadd">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">院获奖情况&nbsp;—&nbsp;修改界面</span>
	</div>
	<!--导出-->
	<button onclick="srchange('person.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop">
  <form class="layui-form" action="updateAwardPersonal.do" method="post" enctype="multipart/form-data" lay-filter="example">
  <!-- 基本信息 -->
	  <div class="layui-row contern">
	  	<h1>基本信息</h1>
		  <input id="id" name="id" type="hidden">
		  <input id="fid" name="fid" type="hidden">
		  <input id="fpath" name="fpath" type="hidden">
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">获奖人员</label>
			    <div class="layui-input-block">
			      <input type="text" name="personName" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
	    <div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">获奖时间</label>
			    <div class="layui-input-block">
			      <input type="text" name="awardTime" lay-verify="title" autocomplete="off" class="layui-input" id="test1">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">奖励荣誉名称</label>
			    <div class="layui-input-block">
			      <input type="text" name="awardName" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">获奖级别</label>
			    <div class="layui-input-block">
			      <select name="awardLevel" lay-filter="aihao">
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
			      <input type="text" name="activityName" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">主办单位</label>
			    <div class="layui-input-block">
			      <input type="text" name="orgnizer" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
	</div>
	<div class="layui-row contern">
	  	<h1>其他信息</h1>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item itemadd">
				<label class="layui-form-label" style="width:190px;">上传附件（服务证明书）</label>
				<div class="layui-input-block" style="margin-left:170px;">
					<div class="layui-upload">
					  <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs12 layui-col-md12">
			 <div class="layui-form-item">
			    <label class="site-demo-button layui-form-label">备注</label>
			    <div class="layui-input-block">
			       <textarea class="layui-textarea" name="remark" lay-verify="content" id="LAY_demo_editor"></textarea>
			    </div>
			  </div>
		</div>
	</div>
    <div class="layui-row">
   	   <div class="layui-col-md12">
		   <div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
			  <button class="layui-btn" lay-submit="" lay-filter="demo1" onSubmit="imgjudge()">立即提交</button>
			  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		  </div>
  		</div>
  	</div>
 </form>
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
	//日期
	 laydate.render({
	   	elem: '#test1'
	  });
//上传附件
 upload.render({
   elem: '#test8'
   ,url: '/upload/'
   ,auto: false
   ,accept: 'file' //普通文件
   ,bindAction: '#test9'
   ,done: function(res){
     console.log(res)
   }
 });
//表单初始赋值
 var id=${param.userId};
 if(id!=null){
		$.post({
			url:"getAwardPersonal.do",
			data:{
				id:id
			},
			success:function(data){
				if(data.data!=null){
					let awardInfo=data.data;
					//表单初始赋值 从表单中提取数据
					  form.val('example', {
                          "id":awardInfo.id,
                          "awardTime":awardInfo.awardTime,
                          "awardLevel":awardInfo.awardLevel,
                          "personName":awardInfo.personName,
                          "personUnit":awardInfo.personUnit,
                          "awardName":awardInfo.awardName,
                          "activityName":awardInfo.activityName,
                          "orgnizer":awardInfo.orgnizer,
                          "remark":awardInfo.remark,
                          "file0":awardInfo.listFile[0].fileName,
                          "fid":awardInfo.listFile[0].id,
                          "fpath":awardInfo.listFile[0].filePath
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