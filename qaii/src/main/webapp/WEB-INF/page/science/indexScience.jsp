<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>科技处数据可视化</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="${basePath}/css/sciencemain.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/js/echarts.min.js"></script>
</head>
<body class="sciencebody">
<div class="main">
	<div class="sciNav">
		<a href="science.do"><div class="pageTo">进入系统</div></a>
		<a href="dept.do"><div class="pageTo">返回导航</div></a>
		<a href="outLogin.do"><div class="pageTo">退出</div></a>
		<!-- <a id="replacep"><div class="pageTo">退出</div></a> -->
	</div>
	<div class="scititle">科技成果检测平台</div>
	<div class="contern">
		<div class="row">
		  <div class="col-md-6">
		  	<div class="item">
		  		<div class="itemtitle">
		  			科研成果总览
		  		</div>
		  		<div class="itemcontent">
		  			<div id="pandect" class="pandect" style="margin:0px auto;margin-top:10px;width:95%;height:250px;"></div>
		  		</div>
		  	</div>
		  	<div class="item">
		  		<div class="itemtitle">
		  			科研成果信息
		  		</div>
		  		<div class="itemcontent">
		  			<div id="information" class="information" style="margin:0px auto;margin-top:10px;width:95%;height:250px;"></div>
		  		</div>
		  	</div>
		  </div>
		  <div class="col-md-6">
		  	<div class="item">
		  		<div class="itemtitle">
		  			数据总量
		  		</div>
		  		<div class="itemcontent">
		  			<div id="totalData" class="total" style="margin:0px auto;margin-top:10px;width:95%;height:250px;"></div>
		  		</div>
		  	</div>
		  	<div class="item">
		  		<div class="itemtitle">
		  			政府资助
		  		</div>
		  		<div class="itemcontent">
		  			<div id="government" class="government" style="margin:0px auto;margin-top:10px;width:95%;height:250px;"></div>
		  		</div>
		  	</div>
		  </div>
		</div>
	</div>
</div>
<script src="${basePath}/js/scichars.js"></script>
</body>
</html>