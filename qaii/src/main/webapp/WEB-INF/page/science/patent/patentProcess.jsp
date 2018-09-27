<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>资料审查-文件预览</title>
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
	.btnfile{width:100px;height:30px;font-size:14px;line-height:30px;background:#1576bd;color:#fff;}
	.btnfile:hover{background:#1576bd;color:#fff;}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="techadd" style="width:300px;">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span>专利&nbsp;—&nbsp;资料审查</span>
		<span>&nbsp;>&nbsp;</span>
		<span class="blue">文件预览</span>
	</div>
	<button class="layui-btn btn btnfile" data-type="getCheckLength" id="test3" style="margin-left:10px;margin-right:10px !important">
			图片文件
	</button>
	<button class="layui-btn btn btnfile" id="dellist" data-type="delmore" style="margin-right:10px !important">
		PDF文件
	</button>
	<button class="layui-btn btn btnfile" data-type="getCheckLength" id="pelupdate">
		其他文件
	</button>	
	<!--	导出             -->
	<button onclick="srchange('patentData.do?userId=20')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<!-- 采用表格内直接行结构  -->
  
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
/* 获取页面传递过来的值 */
var userID=${param.userId};
console.log(userID);
var step=${param.step}+"";
console.log("bushu "+step);
$.post({
	url:"findDeptInfoList.do",
	success:function(data){
		var deptInfo=data.data;
		if(deptInfo!=null){
			$(deptInfo).each(function(index,element){
				index+=1;
				//let heml='<dd lay-value="'+element.deptName+'">'+element.deptName+'</dd>';
				
				let heml='<option value='+element.deptName+'>'+element.deptName+'</option>';
				//$("#deptt").next(".layui-form-select").children("dl").append(heml);
				$("#deptt").append(heml);
			})						
		
			//JavaScript代码区域
			layui.use(['form', 'layedit', 'laydate','element','upload'], function(){
			  var form = layui.form,
				element = layui.element,
				layer = layui.layer,
				laydate = layui.laydate,
				upload = layui.upload;
				//交底日期选择
			  laydate.render({
			    elem: '#test1'
			  });
				//申请日选择
			  laydate.render({
			    elem: '#test2'
			  });
				//公开日选择
			  laydate.render({
			    elem: '#test3'
			  });
				//授权公告日日期选择
			  laydate.render({
			    elem: '#test4'
			  });
			  
			});
		}else{
			alert("部门信息显示失败");
		}
	}
})

</script>
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>        
        