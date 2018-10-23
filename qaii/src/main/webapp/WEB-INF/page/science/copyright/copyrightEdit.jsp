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
		<span class="blue">版权&nbsp;—&nbsp;修改界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('copyright.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<!-- 采用表格内直接行结构  -->
 <form class="layui-form" action="copyrightChanged.do" method="post" lay-filter="example">
<div class="layui-row">
		<div class="layui-col-md6">
		<input id="id" value='${param.userId}' name="id" type="hidden" />
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
                url:"copyrightDetail.do",
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
                        	  "id":trademark.id,
                        	  "copyName":trademark.copyName,
                              "copyCode":trademark.copyCode,
                              "copyAuthor":trademark.copyAuthor,
                              "copyCopyrightperson":trademark.copyCopyrightperson,
                              "copyAgency":trademark.copyAgency,
                              "copyEndtime":trademark.copyEndtime,
                              "copyPublishtime":trademark.copyPublishtime,
                              "copyRegisttime":trademark.copyRegisttime,
                              "copyCost":trademark.copyCost,
                              "copyInvoiceper":trademark.copyInvoiceper,
                              "copyStatus":trademark.copyStatus
                            // 修改此输入框的value值，此value为测试值 softfile为测试自定义值，证明文件值
                          });
                          var domain = window.location.host;
                          var url =data.data.url;
                          var imgpath=domain+url;
                          var otherfile=trademark.softFile;
                          otherfile.splice(0,1);
                          $("#demo1").attr("src","https://"+imgpath);
                        //文件表格展示
                          table.render({
                           elem: '#demo'
                           //,url: 'showSoftfileDetails.do'
                               /*  //数据接口 */ 
                           ,page: false//开启分页
                           ,cols: [[ //表头
                             {field: 'id', type:'numbers',title: '序号', width:80}
                             ,{field: 'filename', title: '文件名'}
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
	

//证明文件点击事件-在线预览
$("#copyrightOnline").click(function(){
	/* var ops="http://"+window.location.host+"/"; */ //调整时开放此数据
	var address=$('input[name="copyrightfile"]').val();
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
//证明文件点击事件-下载
$("#copyrightDownload").click(function(){
	var address=$('input[name="copyrightfile"]').val();
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
        