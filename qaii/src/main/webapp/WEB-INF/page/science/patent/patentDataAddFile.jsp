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
	<form class="layui-form layui-form-pane" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">选择上传文件</label>
			<div class="layui-input-block">
				<input type="text" name="title" autocomplete="off" placeholder="请输入标题" class="layui-input" id="userName">
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
/* 获取页面传递过来的值 */
	var userID=${param.userId};
	var step=${param.step};
	console.log(userID+"id与步骤"+step);
</script>	
</body>
</html>
