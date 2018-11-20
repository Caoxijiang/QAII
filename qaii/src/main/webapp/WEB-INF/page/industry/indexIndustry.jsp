<!DOCTYPE html>
<html style="background-color:#15265e;">
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>QAII智慧管理平台</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="${basePath}/css/industrymain.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/js/echarts.min.js"></script>
  <script src="${basePath}/js/main.js"></script>
  <script src="${basePath}/js/vue.min.js"></script>
</head>
<body class="mainbody">
<div class="main">
	<div class="sciNav">
		<a href="industry.do"><div class="pageTo">进入系统</div></a>
		<a href="outLogin.do"><div class="pageTo">退出</div></a>
	</div>
	<div class="scititle">QAII智慧产业化管理系统</div>
	<div class="contern">
	<!-- //汇总信息 -->
		<div class="inditem">
			<div class="row">
				<div class="col-md-3 pad10">
					<div class="titlebox"  style="background:#036eb8;">
						<div class="font36" id="industria1">{{ message }}家</div>
						<div class="font16">“千帆计划”入库企业</div>
					</div>
				</div>
				<div class="col-md-3 pad10">
					<div class="titlebox"  style="background:#329d3f;">
						<div class="font36" id="industria2">{{ message }}家</div>
						<div class="font16">高新技术企业</div>
					</div>
				</div>
				<div class="col-md-3 pad10">
					<div class="titlebox"  style="background:#f08c29;">
						<div class="font36" id="industria3">{{ message }}家</div>
						<div class="font16">入选青岛市科技型企业培育“百千万”工程</div>
					</div>
				</div>
				<div class="col-md-3 pad10">
					<div class="titlebox"  style="background:#e4007f;">
						<div class="font36" id="industria4">{{ message }}家</div>
						<div class="font16">科技型中小企业</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 服务企业 孵化企业 -->
		<div class="row">
			<div class="col-md-6 pad10" style="padding-left:15px;">
				<div class="inditem">
					<!-- 服务企业 -->
					<div class="inditembg">服务企业总数</div>
					 <div id="servcefirm" style="width: 800px;height:400px;"></div>
				</div>
			</div>
			<div class="col-md-6 pad10" style="padding-right:15px;">
				<div class="inditem">
					<!-- 孵化企业总数 -->
					<div class="inditembg">孵化企业总数</div>
					 <div id="incubating" style="width: 800px;height:400px;"></div>
				</div>
			</div>
		</div>
		<!-- 奖励荣誉 -->
		<div class="inditem">
		<div class="inditembg">服务企业</div>
			<div class="row">
				<div class="col-md-12 pad10">
					<div id="government" class="charsBox">
		  				<div class="tabbox">
		  					<ul class="fundingTabUl">
		  						<li class="fundingTab" name="research">院获奖情况</li>
		  						<li class="fundingTab active" name="create">孵化企业获奖情况</li>
		  						<li class="fundingTab" name="funding">个人获奖情况</li>
		  					</ul>
		  				</div>
		  				<div>
			  				<!-- tab-科研项目界面 -->			
			  				<div id="research" style="display:none;">
			  					<table class="govTable" id="govTable1">
			  						<tr>
			  							<th>序号</th>
			  							<th>获奖时间</th>
			  							<th>获奖级别</th>
			  							<th>获奖单位名称</th>
			  							<th>奖励荣誉名称</th>
			  						</tr>
			  					</table>
			  				</div><!-- tab-科研项目界面  结束-->
			  				<!-- tab-创新平台界面 -->
			  				<div id="create">
			  					<table class="govTable" id="govTable2">
			  						<tr>
			  							<th>序号</th>
			  							<th>获奖时间</th>
			  							<th>获奖级别</th>
			  							<th>获奖企业名称</th>
			  							<th>奖励荣誉名称</th>
			  						</tr>
			  						
			  					</table>
			  				</div><!-- tab-创新平台界面  结束-->
			  				<!-- tab-基金界面 -->
			  				<div id="funding" style="display:none;">
			  					<table class="govTable" id="govTable3">
			  						<tr>
			  							<th>序号</th>
			  							<th>获奖时间</th>
			  							<th>获奖级别</th>
			  							<th>获奖人员</th>
			  							<th>奖励荣誉名称</th>
			  						</tr>
			  					</table>
			  				</div><!-- tab-基金界面  结束-->
			  			</div><!-- 政府资助表格内容集合 -->
		  			</div>
				</div>
			</div>
		</div>
	</div>
</div><!-- main -->
<script src="${basePath}/js/indchars.js"></script>
</body>
</html>