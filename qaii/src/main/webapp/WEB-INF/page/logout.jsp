<!doctype html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
<title>科技管理系统</title>
<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="${basePath}/css/style.css" />
<script src="${basePath}/js/QRcode.js"></script>
<script src="${basePath}/router/login.js"></script>
</head>
<body>
<h5>该账号已经在其他地方登陆，您被强制下线！请重新登录</h5>
<a href="indexUI.do">确定</a>
</body>
</html>
