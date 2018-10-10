<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>添加界面</title>
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
		<span class="blue">科技奖励&nbsp;—&nbsp;添加界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('award.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<!-- 采用表格内直接行结构  -->
  <form class="layui-form" action="addPatentInfo.do" method="post"> 
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="patDept" lay-verify="required" lay-search="" id="deptt" class="input">
						
					</select>
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">专利类型&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="patType" lay-verify="required" lay-search="" lay-verify="required" class="input">
						<option value="">   </option>
						<option value="发明专利">发明专利</option>
						<option value="实用新型专利">实用新型专利</option>
						<option value="外观设计专利">外观设计专利</option>
					</select>
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">专利名称&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">发明人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patAuthor" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请（专利权）人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patApplyper" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">交底日期&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patTelltime" class="layui-input input" id="test1">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">代理机构&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patAgency" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">是否提前公开实审&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="patPrepublishaudit" lay-verify="required" lay-search="" lay-verify="required" class="input">
						<option value="">   </option>
						<option value="是">是</option>
						<option value="否">否</option>
					</select>
					<!-- <input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input"> -->
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请号&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patApplynum" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">申请日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patApplytime" class="layui-input input" id="test2">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">公开日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patPublishtime" class="layui-input input" id="test3">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">授权公告日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patAuthorzationtime" class="layui-input input" id="test4">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">是否减免&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="patRemission" lay-verify="required" lay-search="" lay-verify="required" class="input">
						<option value="">   </option>
						<option value="是">是</option>
						<option value="否">否</option>
					</select>
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请费用（元）&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patCost" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">发票收据-汇款人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="patInvoiceper" autocomplete="off" lay-verify="required" class="layui-input input">
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
					<textarea name="patDigest" class="layui-textarea"></textarea>
				</div>
			</div>
 	  	</div>
 	  	<div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea name="patRemark" class="layui-textarea"></textarea>
				</div>
			</div>
 	  	</div>
 	  </div>
	  <!--   文本框-->
	  <div class="layui-row">
   	   <div class="layui-col-md12">
		   <div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
			  <button class="layui-btn" lay-submit="" lay-filter="demo1" onSubmit="imgjudge()">立即提交</button>
			  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		  </div>
  		</div>
  	</div>
  </form>
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
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
        