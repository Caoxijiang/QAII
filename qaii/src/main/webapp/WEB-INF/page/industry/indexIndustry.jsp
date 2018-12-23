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
	<link href="${basePath}/css/css.css" rel="stylesheet"/>
	<link href="${basePath}/css/cir.css" rel="stylesheet" />
	<script src="${basePath}/js/echarts.min.js"></script>
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/main.js"></script>

  <%--<link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="${basePath}/css/industrymain.css" media="all" />
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/echarts.min.js"></script>

	<script src="${basePath}/js/vue.min.js"></script>--%>
</head>
<body class="mainbody">
	<div class="titleh1">
		<div><span id="cycyear"></span>年<span id="month"></span>月<span id="cycday"></span>日&nbsp;&nbsp;&nbsp;&nbsp;<span id="cychour"></span>时<span id="cycmin"></span>分<span id="cycsecond"></span>秒</div>
		<%--<div class="scititle">
			QAII智慧产业化管理系统
		</div>--%>
		<div class="sciNav">
			<a href="industry.do"><div class="pageTo">进入系统</div></a>
			<a href="outLogin.do"><div class="pageTo">退出</div></a>
		</div>
	</div>
	<div>
		<ul>
			<li class="tab tabac" style="margin-left:190px;" name="bodybox1">
				<div class="title">"千帆计划"入库企业</div>
				<span class="num" id="t1">36</span>
			</li>
			<li class="tab" name="bodybox2">
				<div class="title">高新技术企业</div>
				<span class="num" id="t2">36</span>
			</li>
			<li class="tab" name="bodybox3">
				<div class="title">培育"百千万"工程企业</div>
				<span class="num" id="t3">36</span>
			</li>
			<li class="tab" name="bodybox4">
				<div class="title">科技型中小企业</div>
				<span class="num" id="t4">36</span>
			</li>
		</ul>
	</div>
	<div class="boxright">
		<div>
			<div class="boxrighthead">服务企业</div>
			<div class="char1">
				<div id="main" style="width: 460px;height:200px;"></div>
			</div>
		</div>
		<div>
			<div class="boxrighthead">孵化企业总数</div>
			<div class="char2">
				<div id="company" style="width: 460px;height:200px;"></div>
			</div>
		</div>
		<div>
			<div class="boxrighthead">奖励荣誉奖励</div>
			<div class="char3">
				<div>
					<ul class="tabnavreward">
						<li class="nage">院获奖情况</li>
						<li class="nage nageactive">孵化企业获奖情况</li>
						<li class="nage">个人获奖情况</li>
					</ul>
				</div>
				<div>
					<table id="rewardtable">
						<tr>
							<th>获奖时间</th>
							<th>获奖级别</th>
							<th>获奖单位名称</th>
							<th>奖励荣誉名称</th>
						</tr>
						<tr>
							<td>2018-12-13</td>
							<td>国家级</td>
							<td>青岛智铭智能科技有限公司</td>
							<td>高新技术企业</td>
						</tr>
						<tr style="background: rgba(115,199,206,0.1)">
							<td>2018-12-12</td>
							<td>国家级</td>
							<td>青岛智铭智能科技有限公司</td>
							<td>高新技术企业</td>
						</tr>
						<tr>
							<td>2018-12-11</td>
							<td>国家级</td>
							<td>青岛智铭智能科技有限公司</td>
							<td>高新技术企业</td>
						</tr>
						<tr style="background: rgba(115,199,206,0.1)">
							<td>2018-12-10</td>
							<td>国家级</td>
							<td>青岛智铭智能科技有限公司</td>
							<td>高新技术企业</td>
						</tr>
						<tr>
							<td>2018-12-09</td>
							<td>国家级</td>
							<td>青岛智铭智能科技有限公司</td>
							<td>高新技术企业</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

	</div>
	<div class="bodybox bodybox1">
		<div class="ui_base u_p3d">
			<div class="base u_p3d">

			</div>
		</div>
	</div>
	<!--弹窗	-->
	<div class="zhezhao" style="display: none;">
	</div>
	<div class="popup" style="display: none;">
		<div class="close"><span>+</span></div>
		<ul>
			<li><div class="square"></div><label>公司名称：</label><span>青岛智能智能科技有限公司</span></li>
			<li><div class="square"></div><label>成立时间：</label><span>2018-12-20</span></li>
			<li><div class="square"></div><label>公司住所：</label><span>山东省青岛市高新技术开发区</span></li>
			<li><div class="square"></div><label>注册资本：</label><span>2000万</span></li>
			<li><div class="square"></div><label>公司类型：</label><span>高新技术产业开发</span></li>
			<li><div class="square"></div><label>法定代表人：</label><span>战德成</span></li>
			<li><div class="square"></div><label>统一社会信用代码：</label><span>9137702223214545569</span></li>
		</ul>
		<div class="detail">查看详情</div>
	</div>
	<script src="${basePath}/js/comm.js"></script>
	<script src="${basePath}/js/active.js"></script>
</body>
</html>