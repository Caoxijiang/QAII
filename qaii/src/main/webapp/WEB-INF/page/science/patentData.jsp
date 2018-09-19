<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>资料审查</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/science.css" media="all" />
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/jquery.table2excel.js"></script>
  <style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    .layui-table-body {
	    height: -moz-calc( 100vh - 215px );
	    height: -webkit-calc( 100vh - 215px );
	    height: calc( 100vh - 215 px );
	}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="techadd">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">专利&nbsp;—&nbsp;资料审查</span>
	</div>
	<button class="layui-btn btn" data-type="getCheckLength" id="test3" style="width:120px;margin-right:16px !important">
		<i class="layui-icon layui-icon-add-1"></i>添加流程
	</button>
	<!--		导出-->
	<button onclick="srchange('patent.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
	<div class="datacontent">
		<div class="datatitle">
			<span class="dataname">&nbsp;&nbsp;&nbsp;&nbsp;专利名称《树木胸径预测方法》&nbsp;</span>
			<span class="inventor">发明人：华净;康孟珍;王秀娟;王浩宇;范兴容;王飞跃</span>
			<span class="datadate">公开日期：2016-8-8&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</div>
		<div id="process">
			<ul class="layui-timeline" id="processul">
			</ul>  
		</div>
	</div>
  
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script src="${basePath}/js/data.js"></script><!-- 添加流程 -->
<script src="${basePath}/js/iframesrcon.js"></script>
</body>
</html>        
        