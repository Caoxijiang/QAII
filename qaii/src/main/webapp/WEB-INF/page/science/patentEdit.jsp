<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>修改界面</title>
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
		<span class="blue">专利&nbsp;—&nbsp;修改界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('patent.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<!-- 采用表格内直接行结构  -->
<input id="param" value='${param.userId}' type="hidden" />
  <form class="layui-form" action=" " method="post" lay-filter="example"> 
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">专利类型&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">专利名称&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">发明人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请（专利权）人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">交底日期&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">代理机构&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">是否提前公开实审&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请号&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">申请日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">公开日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">授权公告日&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">是否减免&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请费用（元）&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">发票收据-汇款人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
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
					<textarea name="empRemarks" class="layui-textarea"></textarea>
				</div>
			</div>
 	  	</div>
 	  	<div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea name="empRemarks" class="layui-textarea"></textarea>
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
			url:"seeEmpInfos.do",
			data:{
				userId:id
			},
			success:function(data){
				if(data.data!=null){
					let empinfo=data.data;
					//表单初始赋值 从表单中提取数据
					  form.val('example', {
					    "empName": empinfo.empName,
						  "empNum":empinfo.empNum,
						  "empGender":empinfo.empGender,
						  "empDept":empinfo.empDept,
						  "empPosition":empinfo.empPosition,
						  "empHireStarttime":empinfo.empHireStarttime,
						  "empIdcard":empinfo.empIdcard,
						  "empIdcardEndtime":empinfo.empIdcardEndtime,
						  "empEthnic":empinfo.empEthnic,
						  "empPoliticallandscape":empinfo.empPoliticallandscape,
						  "empMaritalstatus":empinfo.empMaritalstatus,
						  "empFirsteducation":empinfo.empFirsteducation,
						  "empFirsteducationschool":empinfo.empFirsteducationschool,
						  "empFirsteducationpro":empinfo.empFirsteducationpro,
						  "empFirstgraduationtime":empinfo.empFirstgraduationtime,
						  "empSecondeducation":empinfo.empSecondeducation,
						  "empSecondeducationschool":empinfo.empSecondeducationschool,
						  "empSecondeducationpro":empinfo.empSecondeducationpro,
						  "empSecondgraduationtime":empinfo.empSecondgraduationtime,
						  "empThirdeducation":empinfo.empThirdeducation,
						  "empThirdeducationschool":empinfo.empThirdeducationschool,
						  "empThirdeducationpro":empinfo.empThirdeducationpro,
						  "empThirdgraduationtime":empinfo.empThirdgraduationtime,
						  "empJobtitle":empinfo.empJobtitle,
						  "empJobtitlelevel":empinfo.empJobtitlelevel,
						  "empJobtitleobtaintime":empinfo.empJobtitleobtaintime,
						  "empPhone":empinfo.empPhone,
						  "empEmergencycontactandphone":empinfo.empEmergencycontactandphone,
						  "empFileaddress":empinfo.empFileaddress,
						  "empAccountaddress":empinfo.empAccountaddress,
						  "empHomeaddress":empinfo.empHomeaddress,
						  "empWorktype":empinfo.empWorktype,
						  "empCompile":empinfo.empCompile,
						  "empInductiontime":empinfo.empInductiontime,
						  "empTryoutendtime":empinfo.empTryoutendtime,
						  "empContractendtime":empinfo.empContractendtime,
						  "empContractsignednum":empinfo.empContractsignednum,
						  "empReturnee":empinfo.empReturnee,
					  	  "empForeign":empinfo.empForeign,
						  "empRemarks":empinfo.empRemarks,
						  "empDepartureTime":empinfo.empDepartureTime
					    
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
        