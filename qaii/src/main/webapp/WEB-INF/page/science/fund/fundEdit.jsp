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
		<span class="blue">基金管理&nbsp;—&nbsp;修改界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('fund.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<!-- 采用表格内直接行结构  -->
<input id="param" value='${param.userId}' type="hidden"  name="param"/>
  <form class="layui-form" action="uptatePatentInfo.do" method="post" lay-filter="example"> 
  
  	<input   type="hidden"  name="id"/>
	    <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	    	<div class="layui-form-item">
				<label class="layui-form-label">申报时间&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="govfundApplytime" class="layui-input input" id="test1">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">来源&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="govfundSource" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      	<div class="layui-form-item">
				<label class="layui-form-label">级别&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="govfundLevel" lay-verify="required" lay-search="" lay-verify="required" class="input">
						<option value="">   </option>
						<option value="国家级">国家级</option>
						<option value="省级">省级</option>
						<option value="市级">市级</option>
						<option value="区级">区级</option>
						<option value="地方">地方</option>
						<option value="其他">其他</option>
					</select>
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">基金名称&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="govfundName" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">基金实施期&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="govfundImplementtime" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">基金构成单位&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="govfundConstructunit" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">主管部门&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="govfundManagedepart" lay-verify="required" lay-search="" id="deptt" class="input">
						
					</select>
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">申请报送部门&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<select name="govfundApplydepart" lay-verify="required" lay-search="" id="deptt1" class="input">
						
					</select>
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
		    <div class="layui-form-item">
					<label class="layui-form-label">是否通过&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<select name="govfundPass" lay-verify="required" lay-search="" lay-verify="required" class="input">
							<option value="">   </option>
							<option value="是">是</option>
							<option value="否">否</option>
						</select>
					</div>			
			 </div>
		</div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">批复时间</label>
				<div class="layui-input-block">
					<input type="text" name="govfundWrittentime" class="layui-input input" id="test2">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">基金扶助额度</label>
				<div class="layui-input-block">
					<input type="text" name="govfundFundlimit" autocomplete="off" class="layui-input input">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">基金&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<input type="text" name="govfundFund" autocomplete="off" lay-verify="required" class="layui-input input">
				</div>
			</div>
	    </div>
	  </div>
	  <div class="layui-row">
	    <div class="layui-col-xs4 layui-col-md4">
	       <div class="layui-form-item">
				<label class="layui-form-label">资金到位时间</label>
				<div class="layui-input-block">
					<input type="text" name="govfundFundtime" class="layui-input input" id="test3">
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">中期检查考核结果</label>
				<div class="layui-input-block">
					<div class="layui-row">
						 <div class="layui-col-xs6 layui-col-md6">
							<input type="text" name="govfundMiddleresult" class="layui-input input" id="test4">
						 </div>
						 <div class="layui-col-xs6 layui-col-md6">
							<select name="govfundMiddleresult" lay-search="" class="input">
								<option value="">   </option>
								<option value="通过">通过</option>
								<option value="不通过">不通过</option>
							</select>
						</div>
					</div>
				</div>
			</div>
	    </div>
	    <div class="layui-col-xs4 layui-col-md4">
	      <div class="layui-form-item">
				<label class="layui-form-label">项目结题验收结果</label>
				<div class="layui-input-block">
					<div class="layui-row">
						 <div class="layui-col-xs6 layui-col-md6">
							<input type="text" name="govfundEndresult" class="layui-input input" id="test5">
						 </div>
						 <div class="layui-col-xs6 layui-col-md6">
							<select name="govfundEndresult" lay-search="" class="input">
								<option value="">   </option>
								<option value="通过">通过</option>
								<option value="不通过">不通过</option>
							</select>
						</div>
					</div>
				</div>
			</div>
	    </div>
	  </div>
	  <!--   文本框-->
 	  <div class="layui-row">
 	  	<div class="layui-col-xs12 layui-col-md12">
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea name="govfundRemark" class="layui-textarea"></textarea>
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
$.post({
	url:"findDeptInfoList.do",
	success:function(data){
		var deptInfo=data.data;
		if(deptInfo!=null){
			$(deptInfo).each(function(index,element){
				index+=1;
				let heml='<option value='+element.deptName+'>'+element.deptName+'</option>';
				$("#deptt").append(heml);
			})
		}
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
								  	"id":patentInfo.id,
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
	}
})

</script>
</body>
</html>        
        