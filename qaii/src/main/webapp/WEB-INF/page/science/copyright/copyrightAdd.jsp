<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>QAII智慧管理平台</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css">
  <link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css" />
  <link rel="stylesheet" href="${basePath}/css/layuiAdd.css">
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/commen/bootstrap/bootstrap.min.js"></script>
  <script src="${basePath}/router/adddetail.js"></script>
</head>
<body class="layui-layout-body" style="overflow:scroll">
<div class="layui-layout layui-layout-admin">
<!-- 头部区域（可配合layui已有的水平导航） -->
  <div class="layui-header">
	  <div class="layui-logo"><img src="${basePath}/image/qaii.png" style="margin-right: 20px;"></img>智慧人事管理系统&nbsp;--&nbsp;版权信息添加页面</div>
  </div>
  <!-- 头部区域（可配合layui已有的水平导航） -->
  <div class="addBanner"></div><!--banner展示图-->
<!--  表单元素-->
<div class="layui-container">
  <form class="layui-form" action="insertCopyright.do" method="post">
<!--  第一块内容-->
	  <div class="layui-row">
		<div class="layui-col-md6">
			<h1>版权基本信息</h1>
		  	<div class="layui-row">
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label">作品名称&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="copyName" autocomplete="off" lay-verify="required" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">登记号&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block"> 
							<input type="text" name="copyCode" autocomplete="off" lay-verify="required" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">作者&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="copyAuthor" autocomplete="off" lay-verify="required" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">著作权人&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="copyCopyrightperson" lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
				</div>
			    <div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label">代理机构&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="copyAgency" autocomplete="off" lay-verify="required" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">创作完成日期&nbsp;<span class="star">*</span></label>
						  <div class="layui-input-block">
							<input type="text" name="copyEndtime" class="layui-input input" id="test2-1">
						  </div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">首次发布日期&nbsp;<span class="star">*</span></label>
						  <div class="layui-input-block">
							<input type="text" name="copyPublishtime" class="layui-input input" id="test2-2">
						  </div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">登记日期&nbsp;<span class="star">*</span></label>
						  <div class="layui-input-block">
							<input type="text" name="copyRegisttime" class="layui-input input" id="test2-3">
						  </div>
					</div>
				</div>
		    </div>
		</div>
		<div class="layui-col-md6">
<!--	  图片上传-->
			<div class="layui-upload" style="text-align: center;padding-top:10px;">
				<div class="layui-upload-list" style="text-align: center;">
					<img class="layui-upload-img" id="demo1" style="width:180px;height:252px;background: #f1f7f7;">
					<p id="demoText"></p>
				</div>
				<input name="imageVal" type="hidden"></input>
				<button type="button" class="layui-btn" id="imgload">上传图片</button>
			</div> 
		</div>
	  </div>
   <!--  第一块内容-->
   <!--  第二块内容-->
   <h1>版权费用信息</h1>
	  <div class="layui-row bgf7f8f8">
			<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">费用（元）&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="copyCost"  lay-verify="title" autocomplete="off" class="layui-input input">
					</div>
				</div>
			</div>
			<div class="layui-col-md4">	
				<div class="layui-form-item">
					<label class="layui-form-label">发票收据-汇款人</label>
					<div class="layui-input-block">
						<input type="text" name="copyInvoiceper" lay-verify="title" autocomplete="off" class="layui-input input">
					</div>
				</div>
			</div>
			<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-block">
						<input type="text" name="copyStatus" lay-verify="title" autocomplete="off" class="layui-input input">
					</div>
				</div>
			</div> 
	</div>
	 
   <!--  第三块内容-->

   <div class="layui-row">
		<div class="layui-col-md6">
		   <div class="layui-form-item" pane="">
			<div class="layui-input-block">
			  <input type="checkbox" name="like1[write]" lay-skin="primary" title="保证以上填写的信息真实有效" checked="">
			</div>
		  </div>
	   </div>
   	   <div class="layui-col-md6">
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
<!--  表单元素-->

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
				//职称取得时间日期选择
			  laydate.render({
			    elem: '#test1'
			  });
				//入职时间日期选择
			  laydate.render({
			    elem: '#test2'
			  });
				//第一学历毕业时间日期选择
			  laydate.render({
			    elem: '#test1-1'
			  });
				//第二学历毕业时间日期选择
			  laydate.render({
			    elem: '#test1-2'
			  });
				//第三学历毕业时间日期选择
			  laydate.render({
			    elem: '#test1-3'
			  });
			//第一学历毕业时间日期选择
			  laydate.render({
			    elem: '#test2-1'
			  });
				//第二学历毕业时间日期选择
			  laydate.render({
			    elem: '#test2-2'
			  });
				//第三学历毕业时间日期选择
			  laydate.render({
			    elem: '#test2-3'
			  });
			  
				
			  //普通图片上传
			  var uploadInst = upload.render({
			    elem: '#imgload'
			    ,url: 'uploadCopyrightimg.do'
			    ,before: function(obj){
			      //预读本地文件示例，不支持ie8
			      obj.preview(function(index, file, result){
			        $('#demo1').attr('src', result); //图片链接（base64）
			      });
			    }
			    ,done: function(res){
			      //如果上传失败
			      if(res.code > 0){
			        return layer.msg('上传失败');
			      }else{
			    	 $("demoText").attr("imageVal",res.eid)
			    	 var eid=res.eid
			    	/*  console.log( $("demoText").attr("imageVal",JSON.stringify(eid))); */
			    	$("input[name='imageVal']").attr("value",eid);
			    	  return layer.msg(res.msg);
			      }
			      //上传成功
			    }
			    ,error: function(){
			      //演示失败状态，并实现重传
			      var demoText = $('#demoText');
			      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			      demoText.find('.demo-reload').on('click', function(){
			        uploadInst.upload();
			      });
			    }
			  });
			  
			  
			});
		}else{
			alert("部门信息显示失败");
		}
	}
})

	
function imgjudge(){
	var img=$("[name=imageVal]").val();
	alret(img);
}	
</script>
<script src="${basePath}/router/adddetail.js"></script>
</body>
</html>