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
	    height:auto;
	}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="techadd">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">著作&nbsp;—&nbsp;查看详情界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('work.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<input id="param" value='${param.userId}' type="hidden" />
<!-- 采用表格内直接行结构  -->
 <form class="layui-form" action="addEmpInfo.do" method="post" lay-filter="example">
<!--  第一块内容-->
	 <div class="layui-row">
		<h1>著作基本信息</h1>
	  	<div class="layui-row">
			<div class="layui-col-md12">
				<div class="layui-form-item">
					<label class="layui-form-label">题目&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="workTopic" lay-verify="required" autocomplete="off" class="layui-input input" disabled="">
					</div>
				</div>
			</div>
		    <div class="layui-col-md8">
				<div class="layui-form-item">
					<label class="layui-form-label">作者&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="workAuthor" lay-verify="required" autocomplete="off" class="layui-input input" disabled="">
					</div>
				</div>
			</div>
		    <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">类型&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="workType" class="layui-input input" id="test1" disabled="">
					  </div>
				</div>
			</div>
		    <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">出版社&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="workPublishhouse" class="layui-input input" id="test2" disabled="">
					  </div>
				</div>
			</div>
		    <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">ISBN&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="workIsbn" lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
					</div>
				</div>
			</div>
    		<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<select name="workDept" lay-verify="required" lay-search="" id="deptt" class="input" disabled="">
							
						</select>
					</div>
				</div>
			</div>
	    </div>		 
	  </div>
   <!--  第一块内容-->
   <!--  第二块内容-->
   <h1>著作相关文件</h1>
	  <div class="layui-row bgf7f8f8">	
		<div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">封面&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<div class="layui-upload">
						<input type="text" name="workfile" class="layui-input input" style="width:50%;display:inline-block;" disabled="">
						<a class="layui-btn layui-btn-edit layui-btn-xs" id="workOnline">在线预览</a>
				  		<a class="layui-btn layui-btn-xs layui-btn-tired" id="workDownload" >下载</a>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">目录&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<div class="layui-upload">
						<input type="text" name="workfile2" class="layui-input input" style="width:50%;display:inline-block;" disabled="">
						<a class="layui-btn layui-btn-edit layui-btn-xs" id="workOnline2">在线预览</a>
				  		<a class="layui-btn layui-btn-xs layui-btn-tired" id="workDownload2" >下载</a>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">首页&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<div class="layui-upload">
						<input type="text" name="workfile3" class="layui-input input" style="width:50%;display:inline-block;" disabled="">
						<a class="layui-btn layui-btn-edit layui-btn-xs" id="workOnline3">在线预览</a>
				  		<a class="layui-btn layui-btn-xs layui-btn-tired" id="workDownload3" >下载</a>
					</div>
				</div>
			</div>
		</div>
	    <div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">其他文件</label>
				<div class="layui-input-block">
				  <div class="layui-upload-list">
				    <table id="demo" lay-filter="test"></table>
					<script type="text/html" id="barDemo">
  						<a class="layui-btn layui-btn-edit layui-btn-xs" lay-event="online">在线预览</a>
  						<a class="layui-btn layui-btn-xs layui-btn-tired" lay-event="download">下载</a>
					</script>
				  </div>
				</div>
			</div>
		</div>
    </div>	 	 
 </form>
  <div class="layui-row">
   	   <div class="layui-col-md12">
		   <div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
			  <button class="layui-btn" onclick="srchange('work.do')">返回</button>
			</div>
		  </div>
  		</div>
  	</div>
</div>
<script src="${basePath}/js/iframesrc.js"></script>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
layui.use(['form', 'layedit', 'laydate','element','table','upload'], function(obj){
	  var form = layui.form,
	    table = layui.table,
		element = layui.element,
		layer = layui.layer,
		laydate = layui.laydate,
		upload = layui.upload;
	   var id=${param.userId};
	   var eid=$("imageVal").val();
	 //文件表格展示
       if(id!=null){
            $.post({
                url:"showWorkDetails.do",
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
                            "workType":trademark.workType,
                            "workTopic":trademark.workType,
                            "workAuthor":trademark.workAuthor,
                            "workPublishhouse":trademark.workPublishhouse,
                            "workPublishtime":trademark.workPublishtime,
                            "workDept":trademark.workDept,
                            "workIsbn":trademark.workIsbn,
                            "workfile":trademark.listFile[0].path,
                            "workfile2":trademark.listFile[1].path,
                            "workfile3":trademark.listFile[2].path
                            // 修改此输入框的value值，此value为测试值 workfile为测试自定义值，证明文件值
                          });
                          var domain = window.location.host;
                          var url =data.data.url;
                          var imgpath=domain+url;
                          var otherfile=trademark.listFile;
                          otherfile.splice(0,3);
                          $("#demo1").attr("src","https://"+imgpath);
                        //文件表格展示
                          table.render({
                           elem: '#demo'
                           //,url: 'showworkfileDetails.do'
                               /*  //数据接口 */ 
                           ,page: false//开启分页
                           ,cols: [[ //表头
                             {field: 'id', type:'numbers',title: '序号', width:80}
                             ,{field: 'name', title: '文件名'}
                             ,{field: 'path', title: '文件路径'}
                             ,{field: 'operator', title: '操作',toolbar: '#barDemo'}
                           ]],
                           limit: 999999,
                           /* data:obj */
                           data:otherfile
                         });
                    }else{
                        alert("查看详情失败")
                    }
                }
                
            })
       }else{
           alert("请刷新页面");
       }
	   
	 //监听行工具事件
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    /* var ops="http://"+window.location.host+"/"; */
		    if(obj.event === 'online'){//在线预览，暂支持图片和pdf形式
		    	var address=data.path;
		    	var reg1=new RegExp("jpg","i");
		    	var reg2=new RegExp("pdf","i");
		    	var reg3=new RegExp("png","i");
		    	if(reg1.test(address)||reg2.test(address)||reg3.test(address)){
		    /* 		window.open(ops+address); */
		    		window.open(address);
		    	}else{
		    		alert("系统目前暂不支持非图片和pdf文件的预览!其他文件请下载到本地预览。");
		    	};
		    }else if(obj.event === 'download'){//文件下载
		    	var address=data.path;
		    	/* download(ops+address); */
		    		download(address);
			}//事件监听
		  })
		  
		  
	   
	});
	

//封面文件点击事件-在线预览
$("#workOnline").click(function(){
	/* var ops="http://"+window.location.host+"/"; */ //调整时开放此数据
	var address=$('input[name="workfile"]').val();
	var reg1=new RegExp("jpg","i");
	var reg2=new RegExp("pdf","i");
	var reg3=new RegExp("png","i");
	if(reg1.test(address)||reg2.test(address)||reg3.test(address)){
		/* window.open(ops+address); */
		window.open(address);
	}else{
		alert("系统目前暂不支持非图片和pdf文件的预览!其他文件请下载到本地预览。");
	};
})
//封面文件点击事件-下载
$("#workDownload").click(function(){
	var address=$('input[name="workfile"]').val();
	/* download(ops+address); */
	download(address);
})
//目录文件点击事件-在线预览
$("#workOnline2").click(function(){
	/* var ops="http://"+window.location.host+"/"; */ //调整时开放此数据
	var address=$('input[name="workfile2"]').val();
	var reg1=new RegExp("jpg","i");
	var reg2=new RegExp("pdf","i");
	var reg3=new RegExp("png","i");
	if(reg1.test(address)||reg2.test(address)||reg3.test(address)){
		/* window.open(ops+address); */
		window.open(address);
	}else{
		alert("系统目前暂不支持非图片和pdf文件的预览!其他文件请下载到本地预览。");
	};
})
//目录文件点击事件-下载
$("#workDownload2").click(function(){
	var address=$('input[name="workfile2"]').val();
	/* download(ops+address); */
	download(address);
})
//首页文件点击事件-在线预览
$("#workOnline3").click(function(){
	/* var ops="http://"+window.location.host+"/"; */ //调整时开放此数据
	var address=$('input[name="workfile3"]').val();
	var reg1=new RegExp("jpg","i");
	var reg2=new RegExp("pdf","i");
	var reg3=new RegExp("png","i");
	if(reg1.test(address)||reg2.test(address)||reg3.test(address)){
		/* window.open(ops+address); */
		window.open(address);
	}else{
		alert("系统目前暂不支持非图片和pdf文件的预览!其他文件请下载到本地预览。");
	};
})
//首页文件点击事件-下载
$("#workDownload3").click(function(){
	var address=$('input[name="workfile3"]').val();
	/* download(ops+address); */
	download(address);
})
function download(src) {
    var $a = document.createElement('a');
    $a.setAttribute("href", src);
    $a.setAttribute("download", "");
    var evObj = document.createEvent('MouseEvents');
    evObj.initMouseEvent( 'click', true, true, window, 0, 0, 0, 0, 0, false, false, true, false, 0, null);
    $a.dispatchEvent(evObj);
};
</script>
</body>
</html>        
        