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
    <script>
        function isValidate(form){
            //获取表单信息
            username=form.Username.value;
            password=form.Password.value;
            confirm_password=form.Confirm_Password.value;
            //判断用户是否输入的完整的信息
            if(username==""||password==""||confirm_password==""){
                alert("所有信息必须填写完整");
                return false;
            }else if(password==confirm_password){
                //判断用户是否输入了相同的密码
                alert("新密码不可以与原密码一致！");
                return false;
            }else{
                return true;
            }

        }
    </script>
</head>
<body>
<form class="layui-form" name="changePwd" method="post" action="changePwd.do" onsubmit="return isValidate(changePwd)">
        &nbsp;用户名<input type="text" name="Username"><br/><br/>
        原密码<input type="password" name="Password"><br/><br/>
        新密码<input type="password" name="Confirm_Password"><br/><br/>
        <input type="submit" value="修改" />
        <input type="reset" value="重置" />
</form>
</body>
</html>
