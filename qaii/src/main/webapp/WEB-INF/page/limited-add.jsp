<!doctype html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="utf-8">
<title>权限添加界面</title>
<link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all">
<script src="${basePath}/js/jquery-3.3.1.min.js"></script>

<script src="${basePath}/router/limited-add.js"></script>
<style>
	select{
		border:1px solid #e6e6e6;
		height: 38px;
		width: 100%;
		border-radius:0 2px 2px 0px;
		display: block !important;
		position: relative;
	}
	
</style>
</head>

<body>
	<form class="layui-form layui-form-pane" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" name="title" autocomplete="off" placeholder="请输入标题" class="layui-input" id="userName">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="text" name="title" autocomplete="off" placeholder="请输入标题" class="layui-input" id="password">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-block">
				<select name="interest" lay-filter="aihao" id="jiaose">

				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="*" id="sub_btn">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
</html>
