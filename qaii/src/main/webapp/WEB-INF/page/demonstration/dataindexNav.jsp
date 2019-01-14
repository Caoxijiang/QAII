<!doctype html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="utf-8">
<title>科技管理系统</title>
<link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
<link rel="stylesheet" href="${basePath}/css/style.css" />
<link rel="stylesheet" href="${basePath}/css/sciencemain.css" media="all" />
<link rel="stylesheet" href="${basePath}/css/navcss.css" media="all" />

<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
<script src="${basePath}/js/main.js"></script>
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

<body class="mainbody">
<img src="${basePath}/image/circienav.png" class="circienav">

<div class="container-fluid navbody">
	<div class="navhead">QAII科研智慧科研成果管理系统</div>

	<a href="dataindexPersonnel.do">
	<div class="bg2box" style="bottom: 50px;left: 80px;">
		<img src="${basePath}/image/bg2/c1.png"  class="box2img" />
		<img src="${basePath}/image/bg2/c5.png" class="box2img" />
		<img src="${basePath}/image/bg2/c3.png" class="box2img bg2circle" />
		<div class="box2span">
			<span class="box2chian">QAII智慧人事管理系统</span><br />
			<!--<span class="box2uc">Qingdao Zhiming Intelligent Technology Co., Ltd</span>-->
		</div>
		<img src="${basePath}/image/bg2/c4.png" class="box2img box2active" />
	</div>
	</a>

	<a href="dataindexScience.do">
	<div class="bg2box" style="bottom: 200px;left: 23%;">
		<img src="${basePath}/image/bg2/c1.png"  class="box2img" />
		<img src="${basePath}/image/bg2/c6.png" class="box2img" />
		<div class="box2span">
			<span class="box2chian">QAII智慧科技管理系统</span><br />
			<!--<span class="box2uc">Qingdao Zhiming Intelligent Technology Co., Ltd</span>-->
		</div>
		<img src="${basePath}/image/bg2/c3.png" class="box2img bg2circle" />
		<img src="${basePath}/image/bg2/c4.png" class="box2img box2active" />
	</div>
	</a>

	<div class="bg2box" style="bottom: 350px;left: 42%;">
		<img src="${basePath}/image/bg2/c1.png"  class="box2img" />
		<img src="${basePath}/image/bg2/c2.png" class="box2img" />
		<div class="box2span">
			<span class="box2chian">QAII智慧管理系统</span><br />
			<!--<span class="box2uc">Qingdao Zhiming Intelligent Technology Co., Ltd</span>-->
		</div>
		<img src="${basePath}/image/bg2/c3.png" class="box2img circleout3" />
		<img src="${basePath}/image/bg2/c4.png" class="box2img box2active" />
	</div>

	<a href="dataindexIndustry.do">
	<div class="bg2box" style="bottom: 200px;right: 23%;">
		<img src="${basePath}/image/bg2/c1.png"  class="box2img" />
		<img src="${basePath}/image/bg2/c8.png" class="box2img" />
		<div class="box2span">
			<span class="box2chian">QAII智慧产业化管理系统</span><br />
			<!--<span class="box2uc">Qingdao Zhiming Intelligent Technology Co., Ltd</span>-->
		</div>
		<img src="${basePath}/image/bg2/c3.png" class="box2img bg2circle" />
		<img src="${basePath}/image/bg2/c4.png" class="box2img box2active" />
	</div>
	</a>


	<div class="bg2box" style="bottom: 50px;right: 80px;">
		<img src="${basePath}/image/bg2/c1.png"  class="box2img" />
		<img src="${basePath}/image/bg2/c7.png" class="box2img" />
		<div class="box2span">
			<span class="box2chian">QAII智慧综合管理系统</span><br />
			<!--<span class="box2uc">Qingdao Zhiming Intelligent Technology Co., Ltd</span>-->
		</div>
		<img src="${basePath}/image/bg2/c3.png" class="box2img bg2circle" />
		<img src="${basePath}/image/bg2/c4.png" class="box2img box2active" />
	</div>
</div>

	<div id="time"></div>

	<div class="back">
		<a href="login.do">
			<img src="${basePath}/image/back.png" />
			<div style="color: #fff; ">返回登录</div>
		</a>
	</div>
</body>
</html>
