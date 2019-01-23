<!doctype html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
    <title>科技管理系统</title>
    <link rel="stylesheet" href="${basePath}/css/style.css" />
    <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="${basePath}/css/style.css" />
    <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
    <link rel="stylesheet" href="${basePath}/commen/layui/css/science.css" media="all" />
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
    <style>
        .warmbox{
            background: rgba(242,147,74,0.1);
            border:1px solid rgba(242,147,74,0.3);;
            border-radius:3px 3px;
            padding:15px 30px;
            color:#f2934a;
        }
        .gray{
            color:#aaa;
            font-size:16px;
        }
        .labelpw{
            width:130px;
            text-align: right;
            float:left;
            padding-right:10px;
        }
        form.layui-form{
            margin-top:20px;
            /* margin: 15px 0px; */
            background: #f7f7f8;
            padding:20px;
            padding-right: 150px;
        }
    </style>
</head>
<body>
<div class="tool">
    <div class="techadd">
        <span class="limit">修改密码</span>
    </div>
    <!--		导出-->
</div>

<div class="layui-container addtop">
    <div class="warmbox">
        <span>注意啦！</span><span>修改密码后需要重新进行登录</span>
    </div>
    <form class="layui-form" name="changePwd" method="post" action="changePwd.do" onsubmit="return isValidate(changePwd)">
        <div>
            <div class="labelpw">当前密码</div>
            <div>
                <input class="admin" type="password" name="Password" />
                <div class="gray">当前密码强度符合要求</div>
            </div>
        </div>

        <div>
            <div class="labelpw">新密码</div>
            <div>
                <input class="admin" type="password" name="Confirm_Password" />
                <div class="gray">密码长度不超过16位；字符类型仅支持（a-z、A-Z、0-9）</div>
            </div>
        </div>


        <div>
            <div class="labelpw">确认新密码</div>
            <div>
                <input class="admin" type="password" id="Confirm_Password2" />
                <div class="gray">确认密码与新密码保持一致</div>
            </div>
        </div>

        <input type="reset" value="重置" class="btnlog" style="width:48%;float:left"/>
        <input type="submit" value="修改" class="btnlog" style="width:48%;float:right"/>
    </form>
</div>
<%--<form class="layui-form" name="changePwd" method="post" action="changePwd.do" onsubmit="return isValidate(changePwd)">
        &nbsp;用户名<input type="text" name="Username"><br/><br/>
        原密码<input type="password" name="Password"><br/><br/>
        新密码<input type="password" name="Confirm_Password"><br/><br/>
        <input type="submit" value="修改" />
        <input type="reset" value="重置" />
</form>--%>
</body>
</html>
