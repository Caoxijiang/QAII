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
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/science.css" media="all" />
  <link rel="stylesheet" href="${basePath}/css/industry.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <style>
    body{margin: 10px;}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="techadd" style="width:300px;">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">孵化企业管理&nbsp;—&nbsp;查看详情界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('hatch.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop">
  <form class="layui-form" method="post" lay-filter="example">
  <!-- 基本信息 -->
	  <div class="layui-row contern">
	  	<h1>基本信息</h1>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">企业名称</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
	    <div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">统一社会信用代码</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">成立时间</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" id="test1" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">公司类型</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">公司住所</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">法定代表人</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">注册资本</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs12 layui-col-md12">
			 <div class="layui-form-item">
			    <label class="site-demo-button layui-form-label">经营范围</label>
			    <div class="layui-input-block">
			       <textarea class="layui-textarea" name="content" lay-verify="content" id="LAY_demo_editor" disabled=""></textarea>
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs12 layui-col-md12">
			 <div class="layui-form-item">
			    <div class="mumberBox" id="layerDemo">
			    	<label class="layui-form-label mumber">股东出资及成员任职</label>
			    </div>
			    <div class="layui-input-block">
			       <table class="layui-hide" id="test" lay-filter="demo"></table>
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">所属孵化器</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">入孵时间</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" id="test2" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">有限期</label>
			    <div class="layui-input-block">
			      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" id="test3" disabled="">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item itemadd">
				<label class="layui-form-label">上传营业执照</label>
				<div class="layui-input-block">
					<div class="layui-upload">
					  <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" id="test3" disabled="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 创新能力 -->
	<div class="layui-row contern">
	  	<h1>创新能力 </h1>
	  	<div class="layui-col-xs6 layui-col-md6">
	  		<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel" id="isThousandSailEnterprise">是否“千帆计划”入库企业</label>
				    <div class="layui-input-block createblock">
				      <input type="radio" name="isThousandSailEnterprise" value="0" title="否" checked="" disabled="">
				      <input type="radio" name="isThousandSailEnterprise" value="1" title="是" disabled="">
				    </div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel" id="isBillionEnterprise">是否入选青岛市科技型企业培育“百千万”工程</label>
				    <div class="layui-input-block createblock">
				      <input type="radio" name="isBillionEnterprise" value="0" title="否" checked="" disabled="">
				      <input type="radio" name="isBillionEnterprise" value="1" title="是" disabled="">
				    </div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel">是否高新技术企业</label>
				    <div class="layui-input-block createblock" id="isHighTechnologyEnterprise">
				      <input type="radio" name="isHighTechnologyEnterprise" value="0" title="否" checked="" disabled="">
				      <input type="radio" name="isHighTechnologyEnterprise" value="1" title="是" disabled="">
				    </div>
				</div>
				<div class="additionBox" id="isHighTech" style="display:none;">
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">发证时间</label>
					    <div class="layui-input-block">
					      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" id="test4" disabled="">
					    </div>
					</div>
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">证书编号</label>
					    <div class="layui-input-block">
					      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
					    </div>
					</div>
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">发表电子版</label>
						<div class="layui-input-block">
							<div class="layui-upload">
							  <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel">是否科技型中小企业</label>
				    <div class="layui-input-block createblock" id="isTechnologyEnterprise">
				      <input type="radio" name="isTechnologyEnterprise" value="0" title="否" checked="" disabled="">
				      <input type="radio" name="isTechnologyEnterprise" value="1" title="是" disabled="">
				    </div>
				</div>
				<div class="additionBox" id="isTech" style="display:none;">
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">入库登记编号</label>
					    <div class="layui-input-block">
					      <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input" disabled="">
					    </div>
					</div>
				</div>
			</div>
		</div>
	</div>
 </form>
 <!-- 变更记录 -->
 <div class="layui-row contern">
	  	<h1>变更记录</h1>
		<div class="layuichange">
	       <table class="layui-hide" id="table2" lay-filter="demo2"></table>
	    </div>
	</div>
<div class="layui-row">
 	<div class="layui-col-md12">
   		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
	  			<button class="layui-btn" onclick="srchange('hatch.do')">返回</button>
			</div>
  		</div>
	</div>
</div>
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
layui.use(['layer','form', 'layedit', 'laydate','element','upload','table'], function(){
  var form = layui.form,
	element = layui.element,
	layer = layui.layer,
	laydate = layui.laydate,
	upload = layui.upload,
    table = layui.table;
	//日期
	 laydate.render({
	   	elem: '#test1'
	  });
	//日期
	 laydate.render({
	   	elem: '#test2'
	  });
	//日期
	 laydate.render({
	   	elem: '#test3'
	  });
	//日期
	 laydate.render({
	   	elem: '#test4'
	  });
  table.render({
	    elem: '#test'
	    /* ,url:'/demo/table/user/' */ /*back 股东出资及成员任职数据接口*/
	    ,cellMinWidth: 100
	    ,cols: [[
	      {field:'id', title: '序号',type:'numbers',sort: true, minWidth: 100}
	      ,{field:'username', title: '股东名称'}
	      ,{field:'sex',title: '出资比例', sort: true}
	      ,{field:'city',title: '出资时间', sort: true}
	      ,{field:'sign', title: '股东职务', width: '30%', minWidth: 100}
	    ]],
	    data: [{
	        "id": "10001"
	        ,"username": "杜甫"
	        ,"email": "xianxin@layui.com"
	        ,"sex": "男"
	        ,"city": "浙江杭州"
	        ,"sign": "人生恰似一场修行"
	        ,"experience": "116"
	        ,"ip": "192.168.0.8"
	        ,"logins": "108"
	        ,"joinTime": "2016-10-14"
	      }, {
          	"id": "10008"
              ,"username": "贤心"
              ,"email": "xianxin@layui.com"
              ,"sex": "男"
              ,"city": "浙江杭州"
              ,"sign": "人生恰似一场修行"
              ,"experience": "106"
              ,"ip": "192.168.0.8"
              ,"logins": "106"
              ,"joinTime": "2016-10-14"
            }]
	  });
  //变更信息显示
  table.render({
	    elem: '#table2'
	    /* ,url:'/demo/table/user/' */ /*back 变更信息数据接口 删除data*/
	    ,cellMinWidth: 100
	    ,cols: [[
	      {field:'id', title: '序号',type:'numbers',sort: true, minWidth: 100}
	      ,{field:'username', title: '变更记录'}
	    ]],
	    data: [{
	        "id": "10001"
	        ,"username": "杜甫"
	      }, {
        	"id": "10008"
            ,"username": "贤心"
          }]
	  });
  //表单初始赋值
  /*back 表单初始赋值，根据接口修改相应的name值*/
  form.val('example', {
    "title": "致铭科技有限公司" //
    ,"content": "123456"
    ,"isThousandSailEnterprise": "1" //“千帆计划”入库企业
    ,"isBillionEnterprise": "1" //是否入选青岛市科技型企业培育“百千万”工程
    ,"isHighTechnologyEnterprise": "1" //是否高新技术企业
    ,"isTechnologyEnterprise": "1" //是否科技型中小企业
    ,"desc": "sfgsdfg"
  })
  //科技型中小企业
  var isTech="1";
  if(isTech==1){
		$("#isTech").show();
	}else{
		$("#isTech").hide();
	}
  /* 高新技术企业 */
  var isHighTech="1";
  if(isHighTech==1){
		$("#isHighTech").show();
	}else{
		$("#isHighTech").hide();
	}
});
</script>
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>