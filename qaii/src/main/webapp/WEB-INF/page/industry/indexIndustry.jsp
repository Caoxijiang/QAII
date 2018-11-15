<!DOCTYPE html>
<html style="background-color:#15265e;">
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>QAII智慧管理平台</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="${basePath}/css/industrymain.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/js/echarts.min.js"></script>
  <script src="${basePath}/js/main.js"></script>
</head>
<body class="mainbody">
<div class="main">
	<div class="sciNav">
		<a href="science.do"><div class="pageTo">进入系统</div></a>
		<a href="outLogin.do"><div class="pageTo">退出</div></a>
	</div>
	<div class="scititle">QAII智慧产业化管理系统</div>
	<div class="contern">
	</div>
</div>
<script src="${basePath}/js/indchars.js"></script>
</body>
</html>