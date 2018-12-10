<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>QAII智慧管理平台</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <link rel="stylesheet" href="${basePath}/css/science.css">
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
<!--  iframe样式设置-->
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<!-- 头部区域（可配合layui已有的水平导航） -->
  <div class="layui-header">
	  <div class="layui-logo"><img src="${basePath}/image/qaii.png" style="margin-right: 20px;"></img>智慧产业化管理系统</div>
		<ul class="layui-nav layui-layout-right">
		  <li class="layui-nav-item">
			  <a href="outLogin.do" "event.returnValue=false">
			  <!-- <a id="replacep"> -->
			  
				  <img src="${basePath}/image/close.png" class="layui-nav-img">
				  退出系统
			  </a>
		  </li>
		   <li class="layui-nav-item">
			<a href="javascript:;">
			  <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
			  贤心
			</a>
			<dl class="layui-nav-child">
			  <dd><a href="">基本资料</a></dd>
			  <dd><a href="">安全设置</a></dd>
			</dl>
		  </li>

		</ul>
  </div>
  <!-- 头部区域（可配合layui已有的水平导航） -->
  
   <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
			<a class="" href="indexIndustry.do"><i class="layui-icon layui-icon-website" style="font-size: 22px;"></i>&nbsp;全局总览</a>
        </li>
        <li class="layui-nav-item layui-this">
          <a href="javascript:;" onclick="iframechange('hatch.do')"><i class="layui-icon layui-icon-star" style="font-size: 22px;"></i>&nbsp;孵化企业管理</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;" onclick="iframechange('serviceFirm.do')"><i class="layui-icon layui-icon-website" style="font-size: 22px;"></i>&nbsp;服务企业管理</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;"><i class="layui-icon layui-icon-diamond" style="font-size: 22px;"></i>&nbsp;奖励荣誉管理</a>
          <dl class="layui-nav-child">
	          <dd class="navdd"><a onclick="iframechange('institute.do')">院获奖情况</a></dd>
	          <dd class="navdd"><a onclick="iframechange('incubate.do')">孵化企业获奖情况</a></dd>
	          <dd class="navdd"><a onclick="iframechange('person.do')">个人获奖情况</a></dd>
	      </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;" onclick="iframechange('innovate.do')"><i class="layui-icon layui-icon-read" style="font-size: 22px;"></i>&nbsp;合作情况管理</a>
        </li>
      </ul>
    </div>
  </div>
   <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
   
   
  <!--  主要数据表格-->
  <div class="layui-body" id="layuiBody">
	  <iframe src="hatch.do" id="iframe"></iframe>
  </div>
  <!--  主要数据表格-->
  
   <!-- 底部固定区域 -->
  <div class="layui-footer">
   
    © 青岛智能产业研究院&nbsp;版权所有
  </div>
   <!-- 底部固定区域 -->
</div>
<script type="text/javascript">
	$("#replacep").click(function(){
		window.location.replace('outLogin.do');
		window.history.back(-1);
	})
</script>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element; 
});
function iframechange(obj){
	$('iframe').attr('src',obj);
}

</script>
</body>
</html>