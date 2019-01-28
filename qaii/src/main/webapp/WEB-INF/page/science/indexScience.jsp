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
  <link rel="stylesheet" href="${basePath}/css/sciencemain.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/js/echarts.min.js"></script>
  <script src="${basePath}/js/main.js"></script>
  <style>
	a{
		text-decoration: none;
	}
	#rewardtable{
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}

	.loading{
		width:1920px;
		height: 1080px;
		position: fixed;
		/*background: #fff;*/
		top: 0px;
		left: 0px;z-index:100;
	}
	.loading .pic{width:50px;height: 50px;position: absolute;top:0;left: 0;bottom: 0;margin:auto;right: 0;}
	.loading .pic i{display: block;float: left;width: 6px;height: 50px;background: #399;margin: 0px 2px;transform: scaleY(0.4);animation: load 1.2s infinite;}
	.loading .pic i:nth-child(2){animation-delay: 0.1s;}
	.loading .pic i:nth-child(3){animation-delay: 0.2s;}
	.loading .pic i:nth-child(4){animation-delay: 0.3s;}
	.loading .pic i:nth-child(5){animation-delay: 0.4s;}
	@keyframes load{
		0%,40%,100%{transform: scaleY(0.4);}
		20%{transform: scaleY(1);}
	}
</style>

<script>
	document.onreadystatechange=function(){
		if(document.readyState=="complete"){
			$(".loading").fadeOut();
		}
	}
</script>
</head>
<body class="mainbody">
<div class="loading">
	<div class="pic">
		<i></i>
		<i></i>
		<i></i>
		<i></i>
		<i></i>
	</div>
</div>
<div class="main">
	<div class="sciNav">
		<a href="science.do"><div class="pageTo">进入系统</div></a>
		<!-- <a href="dept.do"><div class="pageTo">返回导航</div></a> -->
		<a href="outLogin.do"><div class="pageTo">退出</div></a>
		<!-- <a id="replacep"><div class="pageTo">退出</div></a> -->
	</div>
	<div class="scititle">QAII智慧科技管理系统</div>
	<%--科技处主图--%>
	<div>
		<div class="kjboxbg">
			<div class="kjcenter">
				<div class="kjcenterItem">
					<a href="science.do">
					<div>
						<div class="kjtitle">
							<span class="kjtitleHead">专利总数</span><br />
							<span id="tPatent">受理：0个<br />授权：0个</span>
						</div>
						<div class="imgsp" ></div>
					</div>
					</a>
				</div>
			</div>
			<div class="kjsmall">
				<div class="kjcenterItem">
					<a href="science.do">
					<div class="kjsmbox">
						<div class="kjtitle">
							<span class="kjtitleHead">软著总数</span><br />
							<span id="tSoft">受理：0个<br />授权：0个</span>
						</div>
						<div class="imgs" ></div>
					</div>
					</a>
				</div>
			</div>
			<div class="kjsmallone">
				<div class="kjcenterItem">
					<a href="science.do">
					<div class="kjsmbox">
						<div class="kjtitle">
							<span class="kjtitleHead">著作总数</span><br />
							<span id="tWork">著作：0篇</span><br />

						</div>
						<div class="imgs" ></div>
					</div>
					</a>
				</div>
			</div>
			<div class="kjsmalltwo">
				<div class="kjcenterItem">
					<a href="science.do">
					<div class="kjsmbox">
						<div class="kjtitle">
							<span class="kjtitleHead">商标总数</span><br />
							<span id="tBrand">受理：0个<br />授权：0个</span>
						</div>
						<div class="imgs" ></div>
					</div>
					</a>
				</div>
			</div>
			<div class="kjsmalltir">
				<div class="kjcenterItem">
					<a href="science.do">
					<div class="kjsmbox">
						<div class="kjtitle">
							<span class="kjtitleHead">论文总数</span><br />
							<span id="tPaper">论文：0篇</span>
						</div>
						<div class="imgs" ></div>
					</div>
					</a>
				</div>
			</div>
		</div>
		<div class="kjcsilde">
			<img src="${basePath}/image/slidedown.png" class="kjcsilde1"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde2"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde3"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde4"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde5"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde6"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde7"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde8"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde9"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde10"/>
			<img src="${basePath}/image/slidedown.png" class="kjcsilde11"/>
		</div>
	</div>
	<div class="contern">
		<div class="item">
              <div class="itemtitle">
                  数据总量
              </div>
              <div class="itemcontent">
                  <div id="totalData" class="charsBox"></div>
              </div>
          </div>

		  <div class="item">
			  <div class="itemtitle">
				  科研成果信息
			  </div>
			  <div class="itemcontent">
				  <div id="information" class="charsBox"></div>
			  </div>
		  </div>

		  	<div class="item">
		  		<div class="itemtitle">
		  			政府资助
		  		</div>
		  		<div class="itemcontent">
		  			<div id="government" class="charsBox">
		  				<div class="tabbox">
		  					<ul class="fundingTabUl">
		  						<li class="fundingTab" name="research">科研项目</li>
		  						<li class="fundingTab active" name="create">创新平台</li>
		  						<li class="fundingTab" name="funding">基金</li>
		  						<li class="fundingTab" name="award">科技奖励</li>
		  					</ul>
		  					<a href="science.do"><div class="fundingMor">查看更多+</div></a>
		  				</div>
		  				<div>
			  				<!-- tab-科研项目界面 -->			
			  				<div id="research" style="display:none;">
			  					<table class="govTable" id="govTable1">
			  						<tr>
			  							<th>来源</th>
			  							<th>课题项目名称</th>
			  							<th>立项编号</th>
			  							<th>立项时间</th>
			  						</tr>
			  					</table>
			  				</div><!-- tab-科研项目界面  结束-->
			  				<!-- tab-创新平台界面 -->
			  				<div id="create">
			  					<table class="govTable" id="govTable2">
			  						<tr>
			  							<th>来源</th>
			  							<th>平台名称</th>
			  							<th>立项编号</th>
			  							<th>立项时间</th>
			  						</tr>
			  					</table>
			  				</div><!-- tab-创新平台界面  结束-->
			  				<!-- tab-基金界面 -->
			  				<div id="funding" style="display:none;">
			  					<table class="govTable" id="govTable3">
			  						<tr>
			  							<th>来源</th>
			  							<th>基金名称</th>
			  							<th>基金实施期</th>
			  							<th>批复时间</th>
			  						</tr>
			  					</table>
			  				</div><!-- tab-基金界面  结束-->
			  				<!-- tab-科技奖励界面 -->
			  				<div id="award" style="display:none;">
			  					<table class="govTable" id="govTable4">
			  						<tr>
			  							<th>来源</th>
			  							<th>获奖名称</th>
			  							<th>获奖时间</th>
			  						</tr>
			  					</table>
			  				</div><!-- tab-科技奖励界面  结束-->
			  			</div><!-- 政府资助表格内容集合 -->
		  			</div>
		  		</div>
		  	</div>
	</div>
</div>
<script src="${basePath}/js/scichars.js"></script>
<script type="text/javascript">
/* circle(boxid,id,color,total,num);//boxid为各个板块id值,id为canvas的id值,color为基本外圆颜色值,total为圆铺满总量,num为数据量 */
//科研成果总览
function getscientificPreview(){
	var result=null;
    $.ajax({
        async:false,
        type:"POST",
        url:"scientificPreview.do",
        success:function(data){
            result=data;
        }
    })
    return result;
}
var scientificPreviewData=getscientificPreview();
$("#tPatent").html("受理：" + scientificPreviewData.AgencyPatent + "个<br />授权：" +scientificPreviewData.AuthorizationPatent+ "个");
$("#tSoft").html("受理：" +scientificPreviewData.Applycopyright+ "个<br />授权：" +scientificPreviewData.Authorizationcopyright+ "个");
$("#tBrand").html("受理：" +scientificPreviewData.AgencyTradeMark+ "个<br />授权：" +scientificPreviewData.AuthorizationTradeMark+ "个");
$("#tPaper").html("论文：" +scientificPreviewData.CountThesis+ "篇");
$("#tWork").html("著作：" +scientificPreviewData.Countwork+ "篇");


//政府资助
function getGovernmentFunding(){
    var result=null;
    $.ajax({
        async:false,
        type:"POST",
        url:"GovernmentFunding.do",
        success:function(data){
            data.subject.forEach(function(e){
            	$("<tr><td>"+e.govsubSource+"</td>"+
            		    "<td>"+e.govsubName+"</td>"+
            		    "<td>"+e.govsubApprovalnum+"</td>"+
            		    "<td>"+e.govsubApprovaltime+"</td>"+
            		   /* "<td>"+e.govsubSubvention+"</td>"+*/
            		    "</tr>").insertAfter($("#govTable1 tr:eq(0)"));
            });
            data.platform.forEach(function(e){
                $("<tr><td>"+e.govplatSource+"</td>"+
                        "<td>"+e.govplatName+"</td>"+
                        "<td>"+e.govplatApprovalnum+"</td>"+
                        "<td>"+e.govplatApprovaltime+"</td>"+
                        /*"<td>"+e.govplatSubvention+"</td>"+*/
                        "</tr>").insertAfter($("#govTable2 tr:eq(0)"));
            });
            data.fund.forEach(function(e){
                $("<tr><td>"+e.govfundSource+"</td>"+
                        "<td>"+e.govfundName+"</td>"+
                        "<td>"+e.govfundImplementtime+"</td>"+
                        "<td>"+e.govfundWrittentime+"</td>"+
                       /* "<td>"+e.govfundFundlimit+"</td>"+*/
                        "</tr>").insertAfter($("#govTable3 tr:eq(0)"));
            });
            data.reward.forEach(function(e){
                $("<tr><td>"+e.rewardSource+"</td>"+
                        "<td>"+e.rewardName+"</td>"+
                        "<td>"+e.rewardAwardtime+"</td>"+
                       /* "<td>"+e.rewardAwardnum+"</td>"+*/
                        "</tr>").insertAfter($("#govTable4 tr:eq(0)"));
            });
        }
    })
    return result;
}
var GovernmentFunding=getGovernmentFunding();

</script>
</body>
</html>