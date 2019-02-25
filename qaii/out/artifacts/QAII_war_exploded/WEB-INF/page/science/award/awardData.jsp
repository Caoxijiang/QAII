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
		<input id="ids" hidden="" value="${param.userId}"></input>
		<span class="blue">政府奖励&nbsp;—&nbsp;资料审查</span>
	</div>
	<button class="layui-btn btn" data-type="getCheckLength" id="test3" style="width:120px;margin-right:16px !important">
		<i class="layui-icon layui-icon-add-1"></i>添加流程
	</button>
	<!--		导出-->
	<button onclick="srchange('award.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>

<div class="layui-container addtop"> 
	<div class="datacontent">
		<div class="datatitle">
			<span class="dataname"} >&nbsp;&nbsp;&nbsp;&nbsp;平台名称&nbsp;-&nbsp;${requestScope.utflist[0]}&nbsp;</span>
			<span class="inventor">来源：${requestScope.utflist[1]}</span>
			<span class="datadate">立项编号：${requestScope.utflist[2]}&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</div>
		<div id="process">
			<ul class="layui-timeline" id="processul">
			</ul>  
		</div>
	</div>
  
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script src="${basePath}/js/awarddata.js"></script><!-- 添加流程 -->
<script src="${basePath}/js/iframesrc.js"></script>

<script>
//获取专利主界面传递过来的数据id
var userID="";
userID=${param.userId};
var rewardName="${requestScope.utflist[0]}";
$(function(){
	$(document).on('click','#test3',function(){
		layui.use('layer', function(){
			  var layer = layui.layer; 
			  layer.open({
				type: 2, 
				area: ['350px', '400px'],
				content: "awardDataAdd.do?Id"+'='+${param.userId}
			});
		}); 
	});
	$(document).on('click','.awardFile',function(){
		//获取当前页面对步骤数的标识，标识放于name中，命名方式为id+_+步骤数，如20_1
		var stepnum="";
		stepnum=$(this).attr("name");
		layui.use('layer', function(){
			  var layer = layui.layer; 
			  layer.open({
				type: 2, 
				area: ['600px', '450px'],
				content: 'awardDataAddFile.do?userId='+userID+"&step='"+stepnum+"'&rewardName='"+rewardName+"'"
			});
		}); 
	});
	
	
	
});
</script>
<script>
	$(function(){
		$(document).on('click','.awardProcess',function(){
			var stepnum="";
			stepnum=$(this).attr("name");
			$("body", parent.document).find('iframe').attr('src','awardProcess.do?userId='+userID+'&step='+stepnum+'&rewardAwardtime=${requestScope.utflist[2]}&rewardName=${requestScope.utflist[0]}&rewardSource=${requestScope.utflist[1]}');
		});
	});

    //删除步骤wangxin
    $(function(){
        $(document).on('click','.patentdelete',function(){
            var patName = $(this).attr("name");
            layui.use('layer', function(){
                var layer = layui.layer;

                $.post({
                    url:"deleteRewardProcess.do",
                    data:{
                        "id" : patName
                    },
                    success:function(data){
                        layer.msg('步骤删除成功');
                    }
                })
            });
            /*parent.location.reload()*/
        });
    });
</script>
</body>
</html>        
        