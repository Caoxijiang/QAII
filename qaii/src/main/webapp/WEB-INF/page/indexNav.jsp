<!doctype html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="utf-8">
<title>科技管理系统</title>
<link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
<link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="${basePath}/css/style.css" />

<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
<script src="${basePath}/commen/bootstrap/bootstrap.min.js"> </script>
<script>
	var date=new Date,
		year=date.getFullYear(),
		month=date.getMonth()+1,
		day=date.getDate();
	$(document).ready(function(){
		$("#time").html(year+"/"+month+"/"+day);
	});

</script>
</head>

<body>
	<div id="time"></div>
	<div class="container-fluid navbody">
		<div class="row" style="padding-top:170px;">
			<div class="col-12">
				<a href="#">
					<div class="navbox">
						<div class="navtitle">科研成果管理系统—青岛智能院</div>
						<div class="navcom">点击进入</div>
					</div>
				</a>
			</div>
		</div>
		<div class="row" style="margin-top:105px;">
			<div class="col-6">
				<a href="personal.do">
					<div class="navbox" style="margin-right: 80px;">
						<div class="navtitle">科研成果管理系统—人教处</div>
						<div class="navcom">点击进入</div>
					</div>
				</a>
			</div>
			<div class="col-6">
				<a href="#">
					<div class="navbox" style="margin-left: 80px;">
						<div class="navtitle">科研成果管理系统—科技处</div>
						<div class="navcom">点击进入</div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<div class="back">
		<a href="login.html">
			<img src="${basePath}/image/back.png" />
			<div style="color: #fff; ">返回登录</div>
		</a>
	</div>
</body>
</html>
