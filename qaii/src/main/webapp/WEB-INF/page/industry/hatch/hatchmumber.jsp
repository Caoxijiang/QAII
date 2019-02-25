<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>科研成果管理系统</title>
 <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/science.css" media="all" />
  <link rel="stylesheet" href="${basePath}/css/industry.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
</head>
<body id="bodyHei">
<div class="layui-container" style="margin-top:15px;">
  <form class="layui-form" action="addShareholderInfo.do" method="post" lay-filter="example">
  <div class="layui-form-item">
    <label class="layui-form-label wid60">股东名称</label>
    <div class="layui-input-block wid80">
      <input type="text" name="shareholderName" lay-verify="title" autocomplete="off" placeholder="请输入股东名称" class="layui-input">
      <input type="hidden" name="id" value=${requestScope.Info[0]}>
    </div>
  </div>
	<div class="layui-form-item">
		<label class="layui-form-label wid60">出资比例</label>
		<div class="layui-input-block wid80">
			<input type="text" name="contributionProportion" lay-verify="title" autocomplete="off" placeholder="请输入出资比例" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label wid60">出资时间</label>
		<div class="layui-input-block wid80">
			<input type="text" name="contributionTime" lay-verify="title" autocomplete="off" placeholder="请输入出资时间" class="layui-input" id="test1">
		</div>
	</div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>

    var myDate=new Date();
    var year=myDate.getFullYear(),    //获取完整的年份(4位,1970-????)
        month=myDate.getMonth()-3,       //获取当前月份(0-11,0代表1月)
        day=myDate.getDate();        //获取当前日(1-31)
    var sqdata=year+"-"+month+"-"+day;
layui.use(['layer','form', 'laydate'], function(){
  var form = layui.form,
	layer = layui.layer,
	laydate = layui.laydate;
	//申请日期

 laydate.render({
   	elem: '#test1'
  });
    //表单初始赋值
    form.val('example', {
        "contributionTime": sqdata
    })
  
});
</script>
</body>
</html>