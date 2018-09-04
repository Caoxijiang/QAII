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
<img class="loginbg" src="${basePath}/image/loginbg.jpg" />
	<div class="loginBox">
		<div class="label"><img src="${basePath}/image/account.png" class="labelimg" /></div>
		<input id="userName" placeholder="请输入您的账号" class="admin" type="text" />
		<div class="label"><img src="${basePath}/image/password.png" class="labelimg" /></div>
		<input id="password" placeholder="密码6-18位" class="admin" type="password" />
		<div class="label2"><img src="${basePath}/image/code.png" class="labelimg" /></div>
		<input name="authcode" placeholder="请输入验证码" class="admincode" type="text" id = "input" value="" />
        <input type = "button" id="code" onclick="createCode()" value="点击显示"/> <span class="change" onclick="createCode()">换一张</span>
		<input type="button" value="登录" class="btnlog" id="login_btn" />		
	</div>
</body>
</html>
