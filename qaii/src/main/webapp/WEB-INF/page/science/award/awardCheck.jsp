<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>查看详情界面</title>
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
		<span class="blue">专利&nbsp;—&nbsp;查看详情界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('award.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<input id="param" value='${param.userId}' type="hidden" />
<!-- 采用表格内直接行结构  -->
  <form class="layui-form" action="uptatePatentInfo.do" lay-filter="example"> 
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patDept" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">专利类型&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patType" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">专利名称&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patName" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">发明人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patAuthor" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请（专利权）人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patApplyper" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">交底日期&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patTelltime" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">代理机构&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patAgency" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">是否提前公开实审&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patPrepublishaudit" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请号&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patApplynum" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">申请日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patApplytime" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">公开日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patPublishtime" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">授权公告日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patAuthorzationtime" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">是否减免&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patRemission" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请费用（元）&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patCost" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">发票收据-汇款人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patInvoiceper" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	  </div>
	  <!--   文本框-->
	  <div class="layui-row">
	    <div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">摘要</label>
				<div class="layui-input-block">
					<textarea name="patDigest" class="layui-textarea" disabled=""></textarea>
				</div>
			</div>
 	  	</div>
 	  	<div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea name="patRemark" class="layui-textarea" disabled=""></textarea>
				</div>
			</div>
 	  	</div>
 	  </div>
	  <!--   文本框-->
  </form>
  <div class="layui-row">
   	   <div class="layui-col-md12">
		   <div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
			  <button class="layui-btn" onclick="srchange('award.do')">返回</button>
			</div>
		  </div>
  		</div>
  	</div>
</div>
<script src="${basePath}/js/iframesrc.js"></script>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
//JavaScript代码区域

layui.use(['form', 'layedit', 'laydate','element','upload'], function(){
  var form = layui.form,
	element = layui.element,
	layer = layui.layer,
	laydate = layui.laydate,
	upload = layui.upload;
   var id=${param.userId};
   if(id!=null){
		$.post({
			url:"findPatentInfoById.do",
			data:{
				id:id
			},
			success:function(data){
				if(data.data!=null){
					let patentInfo=data.data;
					//表单初始赋值 从表单中提取数据
					  form.val('example', {
						"patDept":patentInfo.patDept,
						"patType":patentInfo.patType,
						"patName":patentInfo.patName,
						"patDigest":patentInfo.patDigest,
						"patAuthor":patentInfo.patAuthor,
						"patApplyper":patentInfo.patApplyper,
						"patTelltime":patentInfo.patTelltime,
						"patAgency":patentInfo.patAgency,
						"patPrepublishaudit":patentInfo.patPrepublishaudit,
						"patApplynum":patentInfo.patApplynum,
						"patApplytime":patentInfo.patApplytime,
						"patPublishtime":patentInfo.patPublishtime,
						"patAuthorzationtime":patentInfo.patAuthorzationtime,
						"patRemission":patentInfo.patRemission,
						"patCost":patentInfo.patCost,
						"patInvoiceper":patentInfo.patInvoiceper,
						"patRemark":patentInfo.patRemark
					    
					  })
				}else{
					alert("查看详情失败")
				}
			}
		})
   }else{
	   alert("请刷新页面");
   }

});
	
</script>
</body>
</html>        
        