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
    <%--<script>
        function isValidate(){
            //获取表单信息
           /* username=form.Username.value;
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
            }*/

        }
    </script>--%>
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
            padding-top:5px;
            padding-bottom:15px;
            padding-left:140px;
        }
        .labelpw{
            width:130px;
            text-align: right;
            float:left;
            padding-right:10px;
            color:#666;
            font-size:16px;
            line-height:36px;
        }
        .layui-form{
            margin-top:20px;
            /* margin: 15px 0px; */
            padding:20px;
            padding-right: 150px;
            background: #f7f7f7;
        }
        .admin{
            width: 500px;
            border:1px solid #ccc;
            height:36px;
            background: #fff;
            border-radius: 2px;
            line-height:36px;

        }
        .btnpws{
            margin-top: 50px;
            width: 130px;
            height: 40px;
            text-align: center;
            line-height: 40px;
            background: #003e8d;
            border-radius: 3px;
            font-size: 16px;
            color: #ffffff;
            border: none;
            margin-left:15px;
            float:right;
        }
        .newreset{
            background: #fff;
            color:#003e8d;
            border:1px solid #003e8d;
        }
        .red{
            color:red;
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
    <form  name="changePwd" method="post" action="changePwd.do" onsubmit="return isValidate()">
        <div class="layui-form">
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
                    <input class="admin" type="password" name="Confirm_Password" id="Confirm_Password1"/>
                    <div class="gray" id="newpwd">密码长度不超过16位；字符类型仅支持（a-z、A-Z、0-9）</div>
                </div>
            </div>


            <div>
                <div class="labelpw">确认新密码</div>
                <div>
                    <input class="admin" type="password" id="Confirm_Password2" />
                    <div class="gray" id="confpws"> 确认密码与新密码保持一致</div>
                </div>
            </div>
        </div>
        <input type="submit" value="修改" class="btnpws"/>
        <input type="reset" value="重置" class="btnpws newreset"/>
    </form>

</div>
<%--<form class="layui-form" name="changePwd" method="post" action="changePwd.do" onsubmit="return isValidate(changePwd)">
        &nbsp;用户名<input type="text" name="Username"><br/><br/>
        原密码<input type="password" name="Password"><br/><br/>
        新密码<input type="password" name="Confirm_Password"><br/><br/>
        <input type="submit" value="修改" />
        <input type="reset" value="重置" />
</form>--%>
<script>
    var i=0;
    $("#Confirm_Password1").blur(function(){
        let str=$("#Confirm_Password1").val();
        var reg = /^[A-Za-z0-9]+$/;
        if(str.length<17){
            if(!reg.test(str)){
                $("#newpwd").addClass("red");
                $("#newpwd").html("请输入数字或者字母!!!");
                i=0;
            }else{
                $("#newpwd").removeClass("red");
                $("#newpwd").html("新密码符合要求。");
                i=1;
            }
        }else{
            $("#newpwd").addClass("red");
            $("#newpwd").html("密码长度不能超过16位!!!");
            i=0;
        }

    });

    $("#Confirm_Password2").blur(function(){
        let str=$("#Confirm_Password2").val();
        let pws= $("#Confirm_Password1").val();
        if(str==pws){
            $("#confpws").removeClass("red");
            $("#confpws").html("与新密码输入一致。");
            i=1;
        }else{
            $("#confpws").addClass("red");
            $("#confpws").html("两次输入不一致!!!");
            i=0;
        }

    });
    function isValidate(){
        if(i==1){
            return true;
        }else{
            alert("输入格式错误！！");
            return false;
        }

    }
//此处用来获取当前用户的密码
    function getPasswordByUserName(){
        var result=null;
        $.ajax({
            async:false,
            type:"POST",
            url:"getPasswordByUserName.do",
            success:function(data){
                result=data;
            }
        })
        return result;
    }
    let User=getPasswordByUserName();
    //此处为获取的用户密码
    console.log(User.adminPwd);
</script>
</body>
</html>
