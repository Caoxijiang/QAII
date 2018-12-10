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
		<span class="blue">商标&nbsp;—&nbsp;查看详情界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('brand.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<input id="param" value='${param.userId}' type="hidden" />
<!-- 采用表格内直接行结构  -->
	<form class="layui-form" action="addEmpInfo.do" method="post" lay-filter="example">
	  <div class="layui-row">
		<div class="layui-col-xs4 layui-col-md4">
			<div class="layui-form-item">
				<label class="layui-form-label">编号&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmCode" lay-verify="required" autocomplete="off" class="layui-input input" disabled="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="tradmDept" lay-verify="required" lay-search="" id="deptt" class="input" disabled="">
						
					</select>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">申请人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmApplyper" lay-verify="required" autocomplete="off" class="layui-input input" disabled="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">代理机构&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmAgency" lay-verify="required" autocomplete="off" class="layui-input input" disabled="">
				</div>
			</div>
		</div>
	    <div class="layui-col-xs4 layui-col-md4">
			<div class="layui-form-item">
				<label class="layui-form-label">类别&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="tradmType" lay-verify="required" lay-search="" class="input" disabled="">
						<option value="">   </option>
						<option value="1">一级</option>
						<option value="2">二级</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品/服务项目&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmItem"  lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">申请号&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmApplynum"  lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">申请日期</label>
				  <div class="layui-input-block">
					<input type="text" name="tradmApplytime" class="layui-input input" id="test1" disabled="">
				  </div>
			</div>
		</div>	
		
		<div class="layui-col-xs4 layui-col-md4">
<!--	  图片上传-->
			<div class="layui-upload" style="text-align: center;padding-top:10px;">
				<div class="layui-upload-list" style="text-align: center;">
					<img class="layui-upload-img" id="demo1" style="width:180px;height:252px;background: #f1f7f7;" >
					<p id="demoText"></p>
				</div>
<!--				<button type="button" class="layui-btn" id="imgload">上传图片</button>-->
			</div> 
		</div>
	  </div>
   	  <div class="layui-row bgf7f8f8">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">注册日期</label>
				  <div class="layui-input-block">
					<input type="text" name="tradmRegistertime" class="layui-input input" id="test2" disabled="">
				  </div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	     	<div class="layui-form-item">
				<label class="layui-form-label">有效期</label>
				  <div class="layui-input-block">
					<input type="text" name="tradmValidtime" class="layui-input input" id="test3" disabled="">
				  </div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">费用&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmCost" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">发票收据-汇款人&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmInvoiceper" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">状态跟踪&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="tradmStatusfollow" autocomplete="off" lay-verify="required" class="layui-input input" disabled="">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
			<label class="layui-form-label">状态更新日</label>
			  <div class="layui-input-block">
				<input type="text" name="tradmUpdatetime" class="layui-input input" id="test4" disabled="">
			  </div>
			</div>
	    </div>
	    
	    <div class="layui-col-md12">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">商标说明</label>
						<div class="layui-input-block">
							<textarea name="tradmPngandexplain" class="layui-textarea" disabled=""></textarea>
						</div>
					</div>
				</div>
	  </div>  
 </form>
  </form>
  <div class="layui-row">
   	   <div class="layui-col-md12">
		   <div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
			  <button class="layui-btn" onclick="srchange('brand.do')">返回</button>
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
   var eid=$("imageVal").val();
   if(id!=null){
		$.post({
			url:"showTradeMarkDetails.do",
			data:{
				id:id
			},
			success:function(data){
				if(data.data!=null){
					let trademark=data.data;
					if(eid==undefined){
						$("input[name='imageVal']").attr("value",trademark.eid);
					}else{
						$("input[name='imageVal']").attr("value",eid);
					}
					/* console.log("afd"+JSON.stringify(trademark)); */
					//表单初始赋值 从表单中提取数据
					  form.val('example', {
						 "tradmDept":trademark.tradmDept,
						 "tradmCode":trademark.tradmCode,
						 "tradmPngandexplain":trademark.tradmPngandexplain,
						 "tradmApplyper":trademark.tradmApplyper,
						 "tradmAgency":trademark.tradmAgency,
						 "tradmType":trademark.tradmType,
						 "tradmItem":trademark.tradmItem,
						 "tradmApplynum":trademark.tradmApplynum,
						 "tradmApplytime":trademark.tradmApplytime,
						 "tradmRegistertime":trademark.tradmRegistertime,
						
						 "tradmValidtime":trademark.tradmValidtime,
						 "tradmCost":trademark.tradmCost,
						 "tradmInvoiceper":trademark.tradmInvoiceper,
						 "tradmStatusfollow":trademark.tradmStatusfollow,
						 "tradmUpdatetime":trademark.tradmUpdatetime,
					    
					  });
					  var domain = window.location.host;
					  var url =data.data.url;
					  var imgpath=domain+url;
					  $("#demo1").attr("src","https://"+imgpath);
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
        