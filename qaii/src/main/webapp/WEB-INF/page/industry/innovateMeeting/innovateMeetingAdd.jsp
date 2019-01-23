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
	<div class="techadd" style="width:300px;">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">参加会议情况&nbsp;—&nbsp;添加界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('innovateMeeting.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>
</div>
<div class="layui-container addtop">
	<form class="layui-form" action="insertCooperation.do" method="post" enctype="multipart/form-data">
		<!-- 基本信息 -->
		<div class="layui-row contern">
			<h1>基本信息</h1>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">会议类型</label>
					<div class="layui-input-block">
						<input type="text" name="unitName" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">参加人</label>
					<div class="layui-input-block">
						<input type="text" name="cooperationName" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">会议名称</label>
					<div class="layui-input-block">
						<input type="text" name="protocolName" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">报告题目</label>
					<div class="layui-input-block">
						<input type="text" name="signTime" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">会议地址</label>
					<div class="layui-input-block">
						<input type="text" name="cooperationContent" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">会议时间</label>
					<div class="layui-input-block">
						<input type="text" name="cooperationContent2" lay-verify="title" autocomplete="off" class="layui-input" id="test1">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-row contern">
			<h1>其他信息</h1>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item itemadd">
					<label class="layui-form-label" style="width:190px;">上传附件</label>
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
    });
</script>
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>