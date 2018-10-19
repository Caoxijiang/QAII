<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>科研成果管理系统</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css">
  <link rel="stylesheet" href="${basePath}/commen/bootstrap/bootstrap.min.css" />
  <link rel="stylesheet" href="${basePath}/css/layuiAdd.css">
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <script src="${basePath}/commen/bootstrap/bootstrap.min.js"></script>
  <script src="${basePath}/router/adddetail.js"></script>
  <style>
  	.layui-table th{
  	height:30px;
  	min-height: 30px;
    line-height: 30px;}
  </style>
</head>
<body class="layui-layout-body" style="overflow:scroll">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
	  <div class="layui-logo"><img src="${basePath}/image/qaii.png" style="margin-right: 20px;"></img>智慧科技管理系统&nbsp;--&nbsp;软著信息添加页面</div>
  </div>
  <div class="addBanner"></div><!--banner展示图-->
<!--  表单元素-->
<div class="layui-container">
  <form class="layui-form" action="addSoft.do" method="post" enctype="multipart/form-data">
<!--  第一块内容-->
	  <div class="layui-row">
		<h1>软著基本信息</h1>
	  	<div class="layui-row">
			<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<select name="softDept" lay-verify="required" lay-search="" id="deptt" class="input">
							
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">编号&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softCode" lay-verify="required" autocomplete="off" class="layui-input input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">名称&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softName" lay-verify="required" autocomplete="off" class="layui-input input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">软件开发者&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softWriter" lay-verify="required" autocomplete="off" class="layui-input input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">著作权人&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softAuthor" lay-verify="required" autocomplete="off" class="layui-input input">
					</div>
				</div>
			</div>
		    <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">代理机构&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softAgency" lay-verify="required" autocomplete="off" class="layui-input input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">开发完成日期&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="softDevelopendtime" class="layui-input input" id="test1">
					  </div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">首次发表日期&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="softFirstpublishtime" class="layui-input input" id="test2">
					  </div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">登记号&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softNum" lay-verify="required" autocomplete="off"  class="layui-input input">
					</div>
				</div>
			</div>
    		<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">发证日期&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="softCertificatetime" class="layui-input input" id="test3">
					  </div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">费用&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softCost" lay-verify="required" autocomplete="off"  class="layui-input input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">发票收据-汇款人&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="softInvoiceper" lay-verify="required" autocomplete="off"  class="layui-input input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">状态更新日期&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="softUpdatetime" class="layui-input input" id="test4">
					  </div>
				</div>
		   </div>
	    </div>		 
	  </div>
   <!--  第一块内容-->
   <!--  第二块内容-->
   <h1>软著相关文件</h1>
	  <div class="layui-row bgf7f8f8">	
		<div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">证明文件&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<div class="layui-upload">
					  <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
					  <button type="button" class="layui-btn" id="test9">开始上传</button>
					</div>
				</div>
			</div>
		</div>
	    <div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">其他文件</label>
				<div class="layui-input-block">
					<div class="layui-upload">
					  <div class="layui-upload-list">
					    <table class="layui-table">
					      <thead>
					        <tr><th>文件名</th>
					        <th>大小</th>
					        <th>状态</th>
					        <th>操作</th>
					      </tr></thead>
					      <tbody id="demoList"></tbody>
					    </table>
					  </div>
					  <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button> 
					  <button type="button" class="layui-btn" id="testListAction">开始上传</button>
					</div> 
				</div>
			</div>
		</div>
    </div>	 
     <!--  第三块内容-->
     <h1>备注信息</h1>
	  <div class="layui-row">
		<div class="layui-col-md12">
			<div class="layui-form-item layui-form-text">
				<!-- <label class="layui-form-label">备注</label> -->
				<div class="layui-input-block">
					<textarea name="softRemark" class="layui-textarea"></textarea>
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
				let heml='<option value='+element.deptName+'>'+element.deptName+'</option>';
				$("#deptt").append(heml);
			})						
		
			//JavaScript代码区域
			layui.use(['form', 'layedit', 'laydate','element','upload'], function(){
			  var form = layui.form,
				element = layui.element,
				layer = layui.layer,
				laydate = layui.laydate,
				upload = layui.upload;
				//开发完成日期
			  laydate.render({
			    elem: '#test1'
			  });
				//首次发表日期
			  laydate.render({
			    elem: '#test2'
			  });
				//发证日期
			  laydate.render({
			    elem: '#test3'
			  });
				//状态更新日期
			  laydate.render({
			    elem: '#test4'
			  });
			//文件上传
			  upload.render({
			    elem: '#test8'
			    ,url: '/upload/'
			    ,auto: false
			    ,accept: 'file' //普通文件
			    ,bindAction: '#test9'
			    ,done: function(res){
			      console.log(res)
			    }
			  });
			  //多文件列表示例
			  var demoListView = $('#demoList')
			  ,uploadListIns = upload.render({
			    elem: '#testList'
			    ,url: '/upload/'
			    ,accept: 'file'
			    ,multiple: true
			    ,auto: false
			    ,bindAction: '#testListAction'
			    ,choose: function(obj){   
			      var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
			      //读取本地文件
			      obj.preview(function(index, file, result){
			        var tr = $(['<tr id="upload-'+ index +'">'
			          ,'<td>'+ file.name +'</td>'
			          ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
			          ,'<td>等待上传</td>'
			          ,'<td>'
			            ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
			            ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
			          ,'</td>'
			        ,'</tr>'].join(''));
			        
			        //单个重传
			        tr.find('.demo-reload').on('click', function(){
			          obj.upload(index, file);
			        });
			        
			        //删除
			        tr.find('.demo-delete').on('click', function(){
			          delete files[index]; //删除对应的文件
			          tr.remove();
			          uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
			        });
			        
			        demoListView.append(tr);
			      });
			    }
			    ,done: function(res, index, upload){
			      if(res.code == 0){ //上传成功
			        var tr = demoListView.find('tr#upload-'+ index)
			        ,tds = tr.children();
			        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
			        tds.eq(3).html(''); //清空操作
			        return delete this.files[index]; //删除文件队列已经上传成功的文件
			      }
			      this.error(index, upload);
			    }
			    ,error: function(index, upload){
			      var tr = demoListView.find('tr#upload-'+ index)
			      ,tds = tr.children();
			      tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
			      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
			    }
			  });
			  
			});
		}else{
			alert("部门信息显示失败");
		}
	}
})

</script>
</body>
</html>