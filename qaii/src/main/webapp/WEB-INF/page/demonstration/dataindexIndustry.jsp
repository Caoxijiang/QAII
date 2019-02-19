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
	<script src="${basePath}/js/vue.min.js"></script>

  <%--<link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="${basePath}/css/industrymain.css" media="all" />
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/echarts.min.js"></script>

	<script src="${basePath}/js/vue.min.js"></script>--%>
	<style>
		a{
			text-decoration: none;
		}
		#rewardtable,#rewardtable tr td{
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
		}

		.loading{
			width:100%;
			height: 100%;
			position: fixed;
			background: #003e8d;
			top: 0px;
			left: 0px;z-index:100;
		}
		.pic{
			position: absolute;
			top: 0;
			left: 0;
			bottom: 0;
			margin: auto;
			right: 0;
			width:99px;
			height:99px;
			background: url("${basePath}/image/000.png") no-repeat;
			animation: cir00 infinite linear 5s;

		}

		@keyframes cir00 {
			from{
				transform:rotate(360deg);
				-ms-transform:rotate(360deg); /* Internet Explorer */
				-moz-transform:rotate(360deg); /* Firefox */
				-webkit-transform:rotate(360deg); /* Safari 和 Chrome */
				-o-transform:rotate(360deg); /* Opera */
			}
			to{
				transform:rotate(0deg);
				-ms-transform:rotate(0deg); /* Internet Explorer */
				-moz-transform:rotate(0deg); /* Firefox */
				-webkit-transform:rotate(0deg); /* Safari 和 Chrome */
				-o-transform:rotate(0deg); /* Opera */
			}
		}
	</style>

	<script>
        document.onreadystatechange=function(){
            if(document.readyState=="complete"){
                $(".loading").fadeOut();
            }
            //console.log(document.readyState);
        }
	</script>
</head>
<body class="mainbody">
<div class="loading">
	<div class="pic">
	</div>
</div>

	<div class="titleh1">
		<div><span id="cycyear"></span>年<span id="month"></span>月<span id="cycday"></span>日&nbsp;&nbsp;&nbsp;&nbsp;<span id="cychour"></span>时<span id="cycmin"></span>分<span id="cycsecond"></span>秒</div>
		<%--<div class="scititle">
			QAII智慧产业化管理系统
		</div>--%>
		<div class="sciNav">
			<a href="dataindexNav.do"><div class="pageTo">返回导航</div></a>
			<a href="outLogin.do"><div class="pageTo">退出</div></a>
		</div>
	</div>
	<div>
		<ul>
			<li class="tab tabac" style="margin-left:190px;" name="bodybox1">
				<div class="title">"千帆计划"入库企业</div>
				<span class="num" id="t1">{{message}}家</span>
			</li>
			<li class="tab" name="bodybox2">
				<div class="title">高新技术企业</div>
				<span class="num" id="t2">{{message}}家</span>
			</li>
			<li class="tab" name="bodybox3">
				<div class="title">培育"百千万"工程企业</div>
				<span class="num" id="t3">{{message}}家</span>
			</li>
			<li class="tab" name="bodybox4">
				<div class="title">科技型中小企业</div>
				<span class="num" id="t4">{{message}}家</span>
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
						<li class="nage" name="yuanhuojiang">院获奖情况</li>
						<li class="nage nageactive" name="qiyehuojaing">孵化企业获奖情况</li>
						<li class="nage" name="gerenhuojiang">个人获奖情况</li>
					</ul>
				</div>
				<div>
					<table id="rewardtable" style="table-layout: fixed;">
					</table>
				</div>
			</div>
		</div>

	</div>
	<div class="bodybox bodybox1">

		<div class="ui_baseoutsed u_p3d">
			<div class="baseoutsed u_p3d">
				<div class="panoutsed"></div>
				<div class="ball_baseoutsed u_p3d ball_1outsed">
					<div class="balloutsed" id="青岛万龙智控科技有限公司">青岛万龙智控科技有限公司</div>
				</div>
				<div class="ball_baseoutsed u_p3d ball_2outsed">
					<div class="balloutsed" id="青岛慧宜智能科技有限公司">青岛慧宜智能科技有限公司</div>
				</div>
				<div class="ball_baseoutsed u_p3d ball_3outsed">
					<div class="balloutsed" id="青岛平行智能产业管理有限公司">青岛平行智能产业管理有限公司</div>
				</div>
				<div class="ball_baseoutsed u_p3d ball_4outsed">
					<div class="balloutsed" id="青岛慧天平行智能厨具有限公司">青岛慧天平行智能厨具有限公司</div>
				</div>
				<div class="ball_baseoutsed u_p3d ball_5outsed">
					<div class="balloutsed" id="青岛传视智能科技有限公司">青岛传视智能科技有限公司</div>
				</div>
				<div class="ball_baseoutsed u_p3d ball_6outsed">
					<div class="balloutsed" id="青岛云亭智能科技有限公司">青岛云亭智能科技有限公司</div>
				</div>
			</div>
		</div>
		<div class="ui_base u_p3d">
			<div class="base u_p3d">
				<div class="pan"></div>
				<div class="ball_base u_p3d ball_1">
					<div class="ball" id="青岛慧拓智能机器有限公司">青岛慧拓智能机器有限公司</div>
				</div>
				<div class="ball_base u_p3d ball_2">
					<div class="ball" id="青岛智铭智能科技有限公司">青岛智铭智能科技有限公司</div>
				</div>
				<div class="ball_base u_p3d ball_3">
					<div class="ball" id="青岛中科慧康科技有限公司">青岛中科慧康科技有限公司</div>
				</div>
				<div class="ball_base u_p3d ball_4">
					<div class="ball" id="青岛中科慧农科技有限公司">青岛中科慧农科技有限公司</div>
				</div>
				<div class="ball_base u_p3d ball_5">
					<div class="ball" id="青岛慧城智能科技有限公司">青岛慧城智能科技有限公司</div>
				</div>
				<div class="ball_base u_p3d ball_6">
					<div class="ball" id="青岛中科慧畅信息科技有限公司">青岛中科慧畅信息科技有限公司</div>
				</div>
			</div>
		</div>
	</div>
	<!--弹窗	-->
	<div class="zhezhao" style="display: none;">
	</div>
	<div class="popup" style="display: none;">
		<div class="close"><span>+</span></div>
		<ul>
			<li><div class="square"></div><label>公司名称：</label><span id="mingcheng">青岛智能智能科技有限公司</span></li>
			<li><div class="square"></div><label>成立时间：</label><span id="shijian">2018-12-20</span></li>
			<li><div class="square"></div><label>公司住所：</label><span id="zhusuo">山东省青岛市高新技术开发区</span></li>
			<li><div class="square"></div><label>注册资本：</label><span id="ziben">2000万</span></li>
			<li><div class="square"></div><label>公司类型：</label><span id="leixing">高新技术产业开发</span></li>
			<li><div class="square"></div><label>法定代表人：</label><span id="faren">战德成</span></li>
			<li><div class="square"></div><label>统一社会信用代码：</label><span id="xindaima">9137702223214545569</span></li>
		</ul>
		<div class="detail" id="addressnull"><a href="http://www.vipioneers.com/" target="_blank" style="color:#fff;">查看详情</a></div>
	</div>
	<script src="${basePath}/js/commw.js"></script>
	<script src="${basePath}/js/active.js"></script>

</body>
</html>