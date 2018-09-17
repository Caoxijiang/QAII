<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>错误</title>
</head>
<style>
	#main{
		text-align:center;
		margin:0px auto;
		padding: 0px;
		width: 650px;
	}
	img{
		width:100%;
	}
	.message{
		font-size:22px;
		line-height: 60px;
	}
</style>
<body>
	<div id="main">
		<img src="${basePath}/image/Customerror.jpg"></img>
		<span class="message">${requestScope.errmsg} </span>
	</div>
</body>
</html>