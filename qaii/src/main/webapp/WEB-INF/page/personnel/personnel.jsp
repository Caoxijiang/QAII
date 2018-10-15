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
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
<!--  iframe样式设置-->
  <style>
	  iframe{
		  width: auto;
		  width: 100%;
		border:none;
		height:-moz-calc( 100vh - 120px );
		height:-webkit-calc( 100vh - 120px );
		height:calc( 100vh - 120px );
	}
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<!-- 头部区域（可配合layui已有的水平导航） -->
  <div class="layui-header">
	  <div class="layui-logo"><img src="${basePath}/image/qaii.png" style="margin-right: 20px;"></img>智慧人事管理系统 </div>
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
			<a class="" href="personal.do"><i class="layui-icon layui-icon-website" style="font-size: 22px;"></i>&nbsp;全局总览</a>
        </li>
        <li class="layui-nav-item layui-this">
          <a href="javascript:;" onclick="iframechange('intoPerSysadd.do')"><i class="layui-icon layui-icon-group" style="font-size: 22px;"></i>&nbsp;成员管理</a>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;" onclick="iframechange('delldellEmpInfo.do')"><i class="layui-icon layui-icon-username" style="font-size: 22px;"></i>&nbsp;离职人员</a>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;" onclick="iframechange('sysadmin.do')"><i class="layui-icon layui-icon-set-fill" style="font-size: 22px;"></i>&nbsp;系统管理</a>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;" onclick="iframechange('newsUI.do')"><i class="layui-icon layui-icon-reply-fill" style="font-size: 22px;"></i>&nbsp;消息管理</a>
        </li>
       
      </ul>
    </div>
  </div>
   <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
   
   
  <!--  主要数据表格-->
  <div class="layui-body" id="layuiBody">
	  <iframe src="intoPerSysadd.do" id="iframe"></iframe>
  </div>
  <!--  主要数据表格-->
  
   <!-- 底部固定区域 -->
  <div class="layui-footer">
   
    © 青岛智铭智能科技有限公司&nbsp;版权所有
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