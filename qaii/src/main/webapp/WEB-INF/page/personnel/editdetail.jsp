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
</head>
<body class="layui-layout-body" style="overflow:scroll">
<div class="layui-layout layui-layout-admin">
<!-- 头部区域（可配合layui已有的水平导航） -->
  <div class="layui-header">
	  <div class="layui-logo"><img src="${basePath}/image/qaii.png" style="margin-right: 20px;"></img>智慧人事管理系统&nbsp;--&nbsp;人员信息修改页面</div>
  </div>
  <!-- 头部区域（可配合layui已有的水平导航） -->
  <div class="addBanner"></div><!--banner展示图-->
<!--  表单元素-->
<div class="layui-container">
  <form class="layui-form" action="updateEmpInfos.do" method="post" lay-filter="example">
<!--  第一块内容-->
  	
	  <div class="layui-row">
		<div class="layui-col-md6">
			<h1>个人基本信息</h1>
		  	<div class="layui-row">
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label">姓名&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input   type="hidden"  name="userId"/>
							<input name="imageVal" type="hidden"></input>
							<input type="text" name="empName" autocomplete="off" lay-verify="required" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">婚姻状况&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empMaritalstatus"  lay-search="" lay-verify="required" class="input">
								<option value="">   </option>
								<option value="未婚">未婚</option>
								<option value="已婚">已婚</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">政治面貌&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empPoliticallandscape" lay-verify="required" lay-search="" class="input">
								<option value="">   </option>
								<option value="党员">党员</option>
								<option value="团员">团员</option>
								<option value="群众">群众</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">联系电话&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empPhone" lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
				</div>
			    <div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label">性别&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empGender" lay-verify="required" lay-search="" class="input">
								<option value="">   </option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">工号&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empNum"  lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">民族&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empEthnic"  lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">紧急联系人及联系方式&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empEmergencycontactandphone" lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
				</div>
	    		 <div class="layui-col-md12">
					<div class="layui-form-item">
						<label class="layui-form-label">户口所在地&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empAccountaddress"  lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">家庭住址&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empHomeaddress" lay-verify="required" autocomplete="off" class="layui-input input">
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
				<button type="button" class="layui-btn" id="imgload">上传图片</button>
			</div> 
			
			 <h1>信息备注</h1> 
			 <div class="layui-row">
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label">身份证号&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empIdcard" lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">身份证到期时间 &nbsp;<span class="star">*</span></label>
						  <div class="layui-input-block">
							<input type="text" name="empIdcardEndtime" class="layui-input input" id="test2-1">
						  </div>
					</div>
				</div>
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label">试用期结束日期</label>
						  <div class="layui-input-block">
							<input type="text" name="empTryoutendtime" class="layui-input input" id="test2-2">
						  </div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">合同期满时间</label>
						  <div class="layui-input-block">
							<input type="text" name="empContractendtime" class="layui-input input" id="test2-3">
						  </div>
					</div>
				</div>
			</div>
		</div>
	  </div> 
   <!--  第一块内容-->
   <!--  第二块内容-->
   <h1>教育背景</h1>
	  <div class="layui-row bgf7f8f8">
			
				<div class="layui-col-md3">
					<div class="layui-form-item">
						<label class="layui-form-label">本科学历&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empFirsteducation" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">硕士学历</label>
						<div class="layui-input-block">
							<input type="text" name="empSecondeducation" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">博士学历</label>
						<div class="layui-input-block">
							<input type="text" name="empThirdeducation" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">其他学历</label>
						<div class="layui-input-block">
							<input type="text" name="empOthereducation" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
				</div>
			    <div class="layui-col-md3">
					<div class="layui-form-item">
						<label class="layui-form-label">本科学历毕业学校&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empFirsteducationschool" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">硕士学历毕业学校</label>
						<div class="layui-input-block">
							<input type="text" name="empSecondeducationschool" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">博士学历毕业学校</label>
						<div class="layui-input-block">
							<input type="text" name="empThirdeducationschool" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">其他学历毕业学校</label>
						<div class="layui-input-block">
							<input type="text" name="empOthereducationschool" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
				</div>
   		 		<div class="layui-col-md3">
					<div class="layui-form-item">
						<label class="layui-form-label">本科学历专业&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empFirsteducationpro" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">硕士学历专业&nbsp;</label>
						<div class="layui-input-block">
							<input type="text" name="empSecondeducationpro" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">博士学历专业</label>
						<div class="layui-input-block">
							<input type="text" name="empThirdeducationpro" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">其他学历专业</label>
						<div class="layui-input-block">
							<input type="text" name="empOthereducationpro" lay-verify="title" autocomplete="off" class="layui-input input">
						</div>
					</div>
				</div>
   		 		<div class="layui-col-md3">
					<div class="layui-form-item">
						  <label class="layui-form-label">本科学历毕业时间&nbsp;<span class="star">*</span></label>
						  <div class="layui-input-block">
							<input type="text" name="empFirstgraduationtime" class="layui-input input" id="test1-1">
						  </div>
					</div>
					<div class="layui-form-item">
						  <label class="layui-form-label">硕士学历毕业时间</label>
						  <div class="layui-input-block">
							<input type="text" name="empSecondgraduationtime" class="layui-input input" id="test1-2">
						  </div>
					</div>
					<div class="layui-form-item">
						  <label class="layui-form-label">博士学历毕业时间</label>
						  <div class="layui-input-block">
							<input type="text" name="empThirdgraduationtime" class="layui-input input" id="test1-3">
						  </div>
					</div>
						<div class="layui-form-item">
						<label class="layui-form-label">其他学历毕业时间</label>
						<div class="layui-input-block">
						<input type="text" name="empOthergraduationtime" class="layui-input input" id="test1-4">
					</div>
				</div>
				</div>
    		 
	    		 
		    </div>
		  	
		 
   <!--  第二块内容-->
     <!--  第三块内容-->
     <h1>工作信息</h1>
	  <div class="layui-row">
				<div class="layui-col-md4">
					<div class="layui-form-item">
						<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empDept" lay-verify="required" lay-search="" id="deptt" class="input">
								
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">职务&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empPosition" lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						  <label class="layui-form-label">入职时间</label>
						  <div class="layui-input-block">
							<input type="text" name="empInductiontime" class="layui-input input" id="test2">
						  </div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">聘期</label>
						<div class="layui-input-block">
							<select name="empHireStarttime" lay-search="" class="input">
								<option value="">   </option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
					</div>
					
					
					<div class="layui-form-item">
						<label class="layui-form-label">编制</label>
						<div class="layui-input-block">
							<select name="empCompile" lay-search="" class="input" lay-verify="required">
								<option value="">   </option>
								<option value="所编">所编</option>
								<option value="聘用">聘用</option>
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">职工状态&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empStat" lay-search="" lay-verify="required" class="input">
								<option value="">   </option>
								<option value="1">在职</option>
								<option value="0">离职</option>
							</select>
						</div>
					</div>
				</div>
			    <div class="layui-col-md4">
			    	<div class="layui-form-item">
						<label class="layui-form-label">用工形式&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empWorktype" lay-verify="required" lay-search="" class="input">
								<option value="">   </option>
								<option value="1">全职</option>
								<option value="2">兼职</option>
							</select>
						</div>
					</div>
			    	<div class="layui-form-item">
						<label class="layui-form-label">职称名称</label>
						<div class="layui-input-block">
							<input type="text" name="empJobtitle" lay-verify="required" autocomplete="off"  class="layui-input input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">职称等级</label>
						<div class="layui-input-block">
							<input type="text" name="empJobtitlelevel" lay-verify="required" autocomplete="off" class="layui-input input">

						</div>
					</div>
					<div class="layui-form-item">
						  <label class="layui-form-label">职称取得时间</label>
						  <div class="layui-input-block">
							<input type="text" name="empJobtitleobtaintime" class="layui-input input" lay-verify="required" id="test1">
						  </div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">试用期状态&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name=empTryStatus lay-search="" lay-verify="required"  class="input">
								<option value="">  </option>
								<option value="0">试用期期满</option>
								<option value="1">试用期中</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">合同状态 &nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empContractStatus" lay-verify="required" lay-search="" class="input">
								<option value="">   </option>
								<option value="1">合同结束</option>
								<option value="0">合同中</option>
							</select>
						</div>
					</div>
					
				</div>
   		 		<div class="layui-col-md4">
   		 			<div class="layui-form-item">
						<label class="layui-form-label">合同签订次数&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="number" name="empContractsignednum"  autocomplete="off" class="layui-input input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">档案所在地&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="empFileaddress" lay-verify="required" autocomplete="off" class="layui-input input">
						</div>
					</div>
					
					
					<div class="layui-form-item">
						<label class="layui-form-label">是否留学归国人员</label>
						<div class="layui-input-block">
							<select name="empReturnee" lay-search="" class="input">
								<option value="">  </option>
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">是否外籍人员</label>
						<div class="layui-input-block">
							<select name="empForeign" lay-search="" class="input" lay-verify="required">
								<option value="">  </option>
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						  <label class="layui-form-label">离职时间</label>
						  <div class="layui-input-block">
							<input type="text" name="empDepartureTime" class="layui-input input" id="test10">
						  </div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">审核状态&nbsp;<span class="star">*</span></label>
						<div class="layui-input-block">
							<select name="empReviewstatus" lay-search="" lay-verify="required" class="input">
								<option value="">  </option>
								<option value="通过">通过</option>
								<option value="待审核">待审核</option>
							</select>
						</div>
					</div>
				</div>
			<!--   文本框-->
				<div class="layui-col-md12">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">备注</label>
						<div class="layui-input-block">
							<textarea name="empRemarks" class="layui-textarea"></textarea>
						</div>
					</div>
		  		</div>
			<!--   文本框-->

	    		 
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
			  <button class="layui-btn" lay-submit="" lay-filter="demo1"> 提交修改</button>
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
			//本科学历毕业时间日期选择
		  laydate.render({
		    elem: '#test1-1'
		  });
			//硕士学历毕业时间日期选择
		  laydate.render({
		    elem: '#test1-2'
		  });
			//博士学历毕业时间日期选择
		  laydate.render({
		    elem: '#test1-3'
		  });
		//本科学历毕业时间日期选择
		  laydate.render({
		    elem: '#test2-1'
		  });
			//硕士学历毕业时间日期选择
		  laydate.render({
		    elem: '#test2-2'
		  });
			//博士学历毕业时间日期选择
		  laydate.render({
		    elem: '#test2-3'
		  });
		//离职时间日期选择
		  laydate.render({
		    elem: '#test10'
		  });
		  
			
		  //普通图片上传
		  var uploadInst = upload.render({
		    elem: '#imgload'
		    ,url: 'EmpAupload.do'
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
			
		
		  var id=${param.userId};
		  var eid=$("imageVal").val();
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
							
							if(eid==undefined){
								$("input[name='imageVal']").attr("value",empinfo.eid);
							}else{
								$("input[name='imageVal']").attr("value",eid);
							}
							//var asd="https://www.iv2018.cn/public/images/ieeeImages/me/bg.jpg";
							
							  
							  form.val('example', {
								 "userId":empinfo.id,
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
								  "empSecondeducationsch ool":empinfo.empSecondeducationschool,
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
								  "empStat":empinfo.empStat,
								  "empDepartureTime":empinfo.empDepartureTime,
								  "empTryStatus":empinfo.empTryStatus,
								  "empContractStatus":empinfo.empContractStatus,
								  "empReviewstatus":empinfo.empReviewstatus,
								  "empOthereducation":empinfo.empOthereducation,
								  "empOthereducationschool":empinfo.empOthereducationschool,
								  "empOthereducationpro":empinfo.empOthereducationpro,
								  "empOthergraduationtime":empinfo.empOthergraduationtime
							  })
							  $("#demo1").attr("src",data.data.url);
							 
						}else{
							alert("查看详情失败")
						}
					}
				})
		  }else{
			   alert("请刷新成员管理页面");
		  }
		  
		  
		});
	
		}else{
			alert("部门信息显示失败");
		}
	}
})

	
	
	

</script>
</body>
</html>