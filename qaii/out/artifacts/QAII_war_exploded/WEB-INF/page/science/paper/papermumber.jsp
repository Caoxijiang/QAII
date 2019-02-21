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
  <form class="layui-form" action="addPeriodicalAuthor.do" method="post" lay-filter="example">
      <div class="layui-form-item">
        <label class="layui-form-label wid60">姓名</label>
        <div class="layui-input-block wid80">
          <input type="text" name="shareholderName" lay-verify="title" autocomplete="off" placeholder="请输入作者名称" class="layui-input">
          <input type="hidden" name="id" value=${param.id}>
        </div>
      </div>
	<div class="layui-form-item">
		<label class="layui-form-label wid60">排名</label>
		<div class="layui-input-block wid80">
            <select name="patRemission" lay-search="" class="input">
                <option value="第一作者">第一作者</option>
                <option value="通讯作者">通讯作者</option>
                <option value="第一作者和通讯作者">第一作者和通讯作者</option>
                <option value="第二作者">第二作者</option>
                <option value="第三作者">第三作者</option>
                <option value="第四作者">第四作者</option>
                <option value="第五作者">第五作者</option>
                <option value="第六作者">第六作者</option>
                <option value="其他作者">其他作者</option>
            </select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label wid60">单位</label>
		<div class="layui-input-block wid80">
			<input type="text" name="contributionTime" lay-verify="title" autocomplete="off" placeholder="请输入作者单位" class="layui-input">
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

layui.use(['layer','form', 'laydate'], function(){
  var form = layui.form,
	layer = layui.layer,
	laydate = layui.laydate;
  
});
</script>
</body>
</html>