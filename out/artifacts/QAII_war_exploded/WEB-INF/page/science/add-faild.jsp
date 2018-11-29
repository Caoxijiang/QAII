<!doctype html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="utf-8">
<title>提交成功</title>
<style>
	.box{
		margin: 0px auto;
		margin-top: 20px;
		padding: 10px;
		text-align:center;
	}
	.contern{
		margin:auto;
		padding: 20px 0px 25px 0px; 
		background:#f7f7f7;
		max-width: 550px;
		border: 1px solid #f0f0f0;
		border-radius: 3px;
	}
	.sucss{
		font-size:32px;
		color: #000;
	}
	.appendix{
		font-size:16px;
		color:#888;
	}
	a{
		text-decoration:none;
	}
	.close{
		margin: 0px auto;
		margin-top: 15px;
		background: #6ea9dc;
		color:#fff;
		width:150px;
		height: 40px;
		line-height: 40px;
		font-size: 20px;
		text-align: center;
		
	}
</style>
</head>

<body>
	<div class="box">
	<div class="contern">
		<div>
			<img src="${basePath}/image/fail.png">
		</div>
		<div style="margin-top: 15px;">
			<span class="sucss"> 提交未成功</span>
		</div>
		<div style="margin-top: 15px;line-height: 30px">
			<span class="appendix">
				人员信息添加未成功<br />
				请重新填写员工信息
			</span>
		</div>
		<a href="javascript:window.history.go(-1);">
			<div class="close">
				返回
			</div>
		</a>
		</div>
	</div>
</body>
</html>
