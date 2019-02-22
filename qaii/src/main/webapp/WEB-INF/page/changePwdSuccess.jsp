<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/17
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .box{
            margin:0px auto;
            top:200px;
            width:600px;
            height:500px;
            text-align: center;
            padding-top:50px;
        }
        .box h5{
            color:#aaa;
            font-size:16px;
        }
        .btn{
            display: inline-block;
            height: 38px;
            line-height: 38px;
            padding: 0 15px;
            background-color: #036eb8;
            color: #fff;
            width:100px;
            white-space: nowrap;
            text-align: center;
            font-size: 16px;
            border: none;
            border-radius: 2px;
            cursor: pointer;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="box">
        <h5>修改密码成功，请重新登录！</h5>
        <a href="login.do" target="_top" class="btn">确定</a>
    </div>
</body>
</html>
