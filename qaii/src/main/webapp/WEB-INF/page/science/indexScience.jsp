<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>科技处数据可视化</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="${basePath}/css/sciencemain.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/js/echarts.min.js"></script>
  <script src="${basePath}/js/main.js"></script>
</head>
<body class="mainbody">
<div class="main">
	<div class="sciNav">
		<a href="science.do"><div class="pageTo">进入系统</div></a>
		<!-- <a href="dept.do"><div class="pageTo">返回导航</div></a> -->
		<a href="outLogin.do"><div class="pageTo">退出</div></a>
		<!-- <a id="replacep"><div class="pageTo">退出</div></a> -->
	</div>
	<div class="scititle">科技成果检测平台</div>
	<div class="contern">
		<div class="row">
		  <div class="col-md-6">
		  	<div class="item">
		  		<div class="itemtitle">
		  			科研成果总览
		  		</div>
		  		<div class="itemcontent">
		  			<div id="pandect" class="charsBox">
		  				<div class="itemBox" id="PatentBox">
		  					<canvas id="totalPatent" class="itemCanvas"></canvas>
		  					<div class="itmeTitle">专利总数</div>
		  					<div class="line">
		  						<div class="itmeline"></div>
		  						<div class="itmelineb"></div>
		  					</div>
		  					<div class="itmeText"><span id="tPatent">受理：XXX个<br />授权：XXX个</span></div>
		  				</div>
		  				<div class="itemBox" id="PatentBox">
		  					<canvas id="totalSoft" class="itemCanvas"></canvas>
		  					<div class="itmeTitle">软著总数</div>
		  					<div class="line">
		  						<div class="itmeline"></div>
		  						<div class="itmelineb"></div>
		  					</div>
		  					<div class="itmeText"><span id="tSoft">受理：XXX个<br />授权：XXX个</span></div>
		  				</div>
		  				<div class="itemBox" id="PatentBox">
		  					<canvas id="totalBrand" class="itemCanvas"></canvas>
		  					<div class="itmeTitle">商标总数</div>
		  					<div class="line">
		  						<div class="itmeline"></div>
		  						<div class="itmelineb"></div>
		  					</div>
		  					<div class="itmeText"><span id="tBrand">受理：XXX个<br />授权：XXX个</span></div>
		  				</div>
		  				<div class="itemBox" id="PatentBox">
		  					<canvas id="totalPaper" class="itemCanvas"></canvas>
		  					<div class="itmeTitle">论文总数</div>
		  					<div class="line">
		  						<div class="itmeline"></div>
		  						<div class="itmelineb"></div>
		  					</div>
		  					<div class="itmeText"><span id="tPaper">论文：XXX篇</span><br />&nbsp;</div>
		  				</div>
		  				<div class="itemBox" id="PatentBox">
		  					<canvas id="totalWork" class="itemCanvas"></canvas>
		  					<div class="itmeTitle">著作总数</div>
		  					<div class="line">
		  						<div class="itmeline"></div>
		  						<div class="itmelineb"></div>
		  					</div>
		  					<div class="itmeText"><span id="tWork">著作：XXX部</span><br />&nbsp;</div>
		  				</div>
		  			</div>
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
		  </div>
		  <div class="col-md-6">
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
			  					<table class="govTable">
			  						<tr>
			  							<th>来源</th>
			  							<th>课题项目名称</th>
			  							<th>立项编号</th>
			  							<th>立项时间</th>
			  							<th>资助金额（万元）</th>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  					</table>
			  				</div><!-- tab-科研项目界面  结束-->
			  				<!-- tab-创新平台界面 -->
			  				<div id="create">
			  					<table class="govTable">
			  						<tr>
			  							<th>来源</th>
			  							<th>平台名称</th>
			  							<th>立项编号</th>
			  							<th>立项时间</th>
			  							<th>资助金额（万元）</th>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>00120180820</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  					</table>
			  				</div><!-- tab-创新平台界面  结束-->
			  				<!-- tab-基金界面 -->
			  				<div id="funding" style="display:none;">
			  					<table class="govTable">
			  						<tr>
			  							<th>来源</th>
			  							<th>基金名称</th>
			  							<th>基金实施期</th>
			  							<th>批复时间</th>
			  							<th>基金资助额度</th>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018.9-2018.10</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018.9-2018.10</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018.9-2018.10</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018.9-2018.10</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018.9-2018.10</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018.9-2018.10</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  					</table>
			  				</div><!-- tab-基金界面  结束-->
			  				<!-- tab-科技奖励界面 -->
			  				<div id="award" style="display:none;">
			  					<table class="govTable">
			  						<tr>
			  							<th>来源</th>
			  							<th>获奖名称</th>
			  							<th>获奖时间</th>
			  							<th>奖励金额</th>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  						<tr>
			  							<td>平行工作室</td>
			  							<td>《智能车科技》</td>
			  							<td>2018-08-20</td>
			  							<td>3000</td>
			  						</tr>
			  					</table>
			  				</div><!-- tab-科技奖励界面  结束-->
			  			</div><!-- 政府资助表格内容集合 -->
		  			</div>
		  		</div>
		  	</div>
		  </div>
		</div>
	</div>
</div>
<script src="${basePath}/js/scichars.js"></script>
<script type="text/javascript">
/* circle(boxid,id,color,total,num);//boxid为各个板块id值,id为canvas的id值,color为基本外圆颜色值,total为圆铺满总量,num为数据量 */

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

circle("PatentBox","totalPatent","#ea8a27",100, scientificPreviewData.AgencyPatent);
circle("PatentBox","totalSoft","#ea8a27",100, scientificPreviewData.Applycopyright);
circle("PatentBox","totalBrand","#ea8a27",100, scientificPreviewData.AgencyTradeMark);
circle("PatentBox","totalPaper","#3db4e3",100, scientificPreviewData.CountThesis);
circle("PatentBox","totalWork","#3db4e3",100, scientificPreviewData.Countwork);
</script>
</body>
</html>