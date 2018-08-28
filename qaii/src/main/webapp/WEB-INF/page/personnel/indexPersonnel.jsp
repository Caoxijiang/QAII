<!doctype html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
<link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="${basePath}/css/style.css" />

<script src="${basePath}/js/jquery-3.3.1.min.js"></script> 
<script src="${basePath}/commen/bootstrap/bootstrap.min.js"> </script>
<script src="${basePath}/js/echarts.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		var now=new Date();
		var nowdate=now.getFullYear()+"/"+(now.getMonth() + 1)+"/"+now.getDate();
		getContractMsg();
		getTryMsg();
		
		//合同到期人员提醒
		function getContractMsg(){
			$.ajax({
				type:"POST",
				url:"getContractMsg.do",
				data:{date:nowdate},
				success:function(data){
					data.forEach(function(e){
						$("#contractremind").append('<li class="permain"><div class="row"><div class="col-3">'+
								e.empDept+'</div><div class="col-3">'+
								e.empName+'</div><div class="col-6">'+
								e.empContractendtime+'</div></div></li>');
					})
				}
			})
		}
		
		//试用期到期提醒
		function getTryMsg(){
			$.ajax({
				type:"POST",
				url:"getTryMsg.do",
				data:{date:nowdate},
				success:function(data){
					data.forEach(function(e){
						$("#tryremind").append('<li class="permain"><div class="row"><div class="col-3">'+
								e.empDept+'</div><div class="col-3">'+
								e.empName+'</div><div class="col-6">'+
								e.empTryoutendtime+'</div></div></li>');
					})
				}
			})
		}
		

	})
</script>
<title>科技管理系统</title>
</head>

<body>
	<div class="container-fluid personalbody">
		<div class="content">
			<div class="perhead">
				<div class="pertitle">
					<span class="pertitlespan">人事教育处监测平台</span>
					<div class="right perNav">
						<a href="intoPerSys.do"><div class="pageTo">进入系统</div></a>
						<a href="../indexNav.jsp"><div class="pageTo">返回导航</div></a>
						<a href="../login.jsp"><div class="pageTo">退出</div></a>
					</div>
				</div>	
				
			</div>
			<div class="row">
			<div class="perbox col-3">
				<div class="inform">
					<div class="perctitle"><span>合同到期提醒</span><span class="right more">查看更多+</span></div>
					<div class="perinform">
						<ul id="contractremind">
							

						</ul>
					</div>
				</div>
				<div class="inform">
					<div class="perctitle"><span>试用期到期提醒</span><span class="right more">查看更多+</span></div>
					<div class="perinform">
						<ul id="tryremind">
							
						</ul>
					</div>
				</div>
			</div>
			<div class="perbox2 col-6">
				<div class="inform">
					<div class="perctitle"><span>本月人数增减情况</span></div>
					<div id="main" style="width: 100%;height:400px;"></div>
				</div>
				<div class="inform">
					<div class="perctitle"><span>人才队伍</span></div>
					<div id="mainbar" style="width: 100%;height:278px;"></div>
				</div>
				
			</div>
			<div class="perbox col-3">
				<div class="inform gradient">
					<div class="perctitle"><span>各部门人数所占比例</span></div>
					<div id="maincircle" style="width: 100%;height:367px;"></div>
				</div>
				<div class="inform">
					<div class="perctitle"><span>高端人才</span></div>
					<div style="height: 312px;" id="canvasBox">
						<canvas id="talents"  width="445px" height="230px"></canvas>
						<script src="${basePath}/js/talent.js"></script>
					</div>
					
				</div>
			</div>
			</div>
		</div>
	</div>
<script src="${basePath}/js/perchars.js"></script>
<script>

	function getTitleMsg(data){
		var result=new Array();
		$.ajax({
			async:false,
			type:"POST",
			url:"getTitleMsg.do",
			data:{data:data},
			success:function(data){
				result=data;
			}
		})
		return result;
	}
	
	var title=new Array("千人计划","百人计划","研究院人员","国家期刊主编","国家优青","国家杰青","科学带头人","博士学历");
	var _title=getTitleMsg(title);
//JavaScript Document
//绘制高端人才界面
//获取到canvas元素
    var canvas = document.getElementById('talents');
	var canvasBox = document.getElementById('canvasBox').offsetWidth;
	canvas.width = canvasBox;

 
    //获取canvas中的画图环境
    var context = canvas.getContext('2d');
	var wid=canvas.width;

    //创建Image对象
    var img = new Image();
	var imgbox = new Image();
    //alert(img);
    //引入图片URL
    img.src = "${basePath}/image/talent.png";
//	imgbox.src ="bac.png";
	img.onload = function (){
		context.drawImage(img,0,0,wid,0.5*wid);
		//绘制高端人才矩形框
		context.fillStyle="#2574b7";
		context.fillRect(197*wid/500,98*wid/500,23*wid/500,28*wid/500);
		context.fillRect(223*wid/500,98*wid/500,23*wid/500,28*wid/500);
		context.fillRect(249*wid/500,98*wid/500,23*wid/500,28*wid/500);
		context.fillRect(275*wid/500,98*wid/500,23*wid/500,28*wid/500);

		context.fillStyle="#fff";
		context.font="bold 20px Arial";
		context.textAlign="left";
		context.fillText("1",204*wid/500,120*wid/500);
		context.fillText("3",230*wid/500,120*wid/500);
		context.fillText("5",256*wid/500,120*wid/500);
		context.fillText("0",282*wid/500,120*wid/500);
		
		context.font="bold 8px Arial";
		context.textAlign="center";
		context.shadowColor="rgba(0,0,0,0.4)";
		context.shadowOffsetX = 1;
		context.shadowOffsetY = 1;
		//千人计划
		context.fillStyle="#8fc31f";
		context.fillText(_title[0]+"人",128*wid/500,49*wid/500);
		//百人计划
		context.fillStyle="#8e1c76";
		context.fillText(_title[1]+"人",64*wid/500,102*wid/500);
		//研究院人员
		context.fillStyle="#1576bd";
		context.fillText(_title[2]+"人",131*wid/500,155*wid/500);
		//国家期刊主编
		context.fillStyle="#f39800";
		context.fillText(_title[3]+"人",140*wid/500,231*wid/500);
		//国家优青
		context.fillStyle="#2ea7e0";
		context.fillText(_title[4]+"人",286*wid/500,231*wid/500);
		//国家杰青
		context.fillStyle="#e4007f";
		context.fillText(_title[5]+"人",358*wid/500,183*wid/500);
		//学科带头人
		context.fillStyle="#f8b62d";
		context.fillText(_title[6]+"人",438*wid/500,142*wid/500);
		//博士学历
		context.fillStyle="#6a2b85";
		context.fillText(_title[7]+"人",383*wid/500,78*wid/500);
		
	}

//2123111111111111111111111111465555555555555555


</script>
</body>
</html>
