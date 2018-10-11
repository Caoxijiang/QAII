<!doctype html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="utf-8">
<title>权限添加界面</title>
<link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
<link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all">
<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
</head>

<body>
	<form class="layui-form layui-form-pane" action="addGovsubjectprocess.do" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">流程名称</label>
			<div class="layui-input-block">
				<input type="text" name="title" autocomplete="off" placeholder="请输入标题" class="layui-input" id="userName">
				<input  name="pid" value='${param.Id}' type="hidden" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">流程说明</label>
			<div class="layui-input-block">
				<input type="text" name="description" autocomplete="off" placeholder="请输入说明" class="layui-input" id="password">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">选择日期</label>
			<div class="layui-input-block">
				<input type="text" name="time" autocomplete="off" placeholder="请选择日期" class="layui-input" id="test1">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="*" id="sub_btn">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
<script src="${basePath}/commen/layui/layui.js"></script>	
<script type="text/javascript">
//patentData传递过来的值
/* 获取页面传递过来的值 */	
layui.use(['layer','element','layedit', 'laydate'], function(){
	//var id=document.getElementsByName('pid').value;
	  var form = layui.form,
		element = layui.element,
		layer = layui.layer,
		laydate = layui.laydate;
		//交底日期选择
	  laydate.render({
	    elem: '#test1'
	  });
});
</script>
<script type="text/javascript">
	var userID=${param.userId};
	console.log(userID+"id与步骤");
</script>
</body>
</html>
