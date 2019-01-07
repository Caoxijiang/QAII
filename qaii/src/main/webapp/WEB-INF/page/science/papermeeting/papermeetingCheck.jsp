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
		<span class="blue">会议论文&nbsp;—&nbsp;查看详情界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('papermeeting.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<input id="param" value='${param.userId}' type="hidden" />
<!-- 采用表格内直接行结构  -->
 <form class="layui-form" action="addEmpInfo.do" method="post" lay-filter="example">
<!--  第一块内容-->
	 <div class="layui-row">
		<h1>会议论文基本信息</h1>
	  	<div class="layui-row">
			<div class="layui-col-md12">
				<div class="layui-form-item">
					<label class="layui-form-label">题目&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="topic" lay-verify="required" autocomplete="off" class="layui-input input" disabled="">
					</div>
				</div>
			</div>
		    <div class="layui-col-md8">
				<div class="layui-form-item">
					<label class="layui-form-label">作者&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="author" lay-verify="required" autocomplete="off" class="layui-input input" disabled="">
					</div>
				</div>
			</div>
		    <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">作者单位&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="authorUnit" class="layui-input input" id="test1" disabled="">
					  </div>
				</div>
			</div>
		    <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">出版时间&nbsp;<span class="star">*</span></label>
					  <div class="layui-input-block">
						<input type="text" name="publishtime" class="layui-input input" id="test2" disabled="">
					  </div>
				</div>
			</div>
		    <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">会议名称&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="meetingName" lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
					</div>
				</div>
			</div>
			<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">会议地点&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="meetingLocation" lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
					</div>
				</div>
		   </div>
		   <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">关键词&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="keyword" lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
					</div>
				</div>
		   </div>
		   <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">通讯作者&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="communicateAuthor" lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
					</div>
				</div>
		   </div>
		   <div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">会议录&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="meetingRecord" lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
					</div>
				</div>
		   </div>
    		<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">部门&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<select name="unit" lay-verify="required" lay-search="" id="deptt" class="input" disabled="">
							
						</select>
					</div>
				</div>
			</div>
    		<div class="layui-col-md4">
				<div class="layui-form-item">
					<label class="layui-form-label">内容类型&nbsp;<span class="star">*</span></label>
					<div class="layui-input-block">
						<input type="text" name="contentType" lay-verify="required" autocomplete="off"  class="layui-input input" disabled="">
					</div>
				</div>
		   </div>
	    </div>		 
	  </div>
   <!--  第一块内容-->
	 <!--  第一块内容-->
	 <h1>论文作者信息</h1>
	 <div class="layui-row">
		 <div class="layui-input-block">
			 <table class="layui-hide" id="testpaper" lay-filter="demopaper"></table>
		 </div>
	 </div>
   <!--  第二块内容-->
   <h1>会议论文相关文件</h1>
	  <div class="layui-row bgf7f8f8">	
		<div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">发表电子版&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<div class="layui-upload">
						<input type="text" name="paperfile" class="layui-input input" style="width:50%;display:inline-block;" disabled="">
						<a class="layui-btn layui-btn-edit layui-btn-xs" id="paperOnline">在线预览</a>
				  		<a class="layui-btn layui-btn-xs layui-btn-tired" id="paperDownload" >下载</a>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">检索证明&nbsp;<span class="star">*</span></label>
				<div class="layui-input-block">
					<div class="layui-upload">
						<input type="text" name="paperfile2" class="layui-input input" style="width:50%;display:inline-block;" disabled="">
						<a class="layui-btn layui-btn-edit layui-btn-xs" id="paperOnline2">在线预览</a>
				  		<a class="layui-btn layui-btn-xs layui-btn-tired" id="paperDownload2" >下载</a>
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
     <!--  第三块内容-->
     <h1>英文摘要</h1>
	  <div class="layui-row">
		<div class="layui-col-md12">
			<div class="layui-form-item layui-form-text">
				<!-- <label class="layui-form-label">备注</label> -->
				<div class="layui-input-block">
					<textarea name="paperRemark" class="layui-textarea" disabled=""></textarea>
				</div>
			</div>
  		</div>		 
	</div>	 
 </form>
  <div class="layui-row">
   	   <div class="layui-col-md12">
		   <div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
			  <button class="layui-btn" onclick="srchange('paper.do')">返回</button>
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
    //添加论文作者表格 wangxin
    var id=${param.userId};
    table.render({
        elem: '#testpaper'
        ,method:'post'
        ,url:'listMeetingAuthor.do?id='+id/*修改接口函数*/
        ,cellMinWidth: 100
        ,cols: [[
            {field:'id', title: '序号',type:'numbers',sort: true, minWidth: 100}
            ,{field:'authorName', title: '姓名'}
            ,{field:'authorLevel',title: '排名', sort: true}
            ,{field:'authorUnit',title: '单位', sort: true}
        ]]
        /*data:obj.data*/

    });
	   var id=${param.userId};
	   var eid=$("imageVal").val();
	 //文件表格展示
       if(id!=null){
            $.post({
                url:"getMeeting.do",
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
                        
                      //预定义必传文件路径
                        if(trademark.listFile== false){
                     	   trademark.listFile=[];
                     	   trademark.listFile[0]=new Object();
                     	   trademark.listFile[0].path='';
                     	   trademark.listFile[1]=new Object();
                    	   trademark.listFile[1].path='';
                        }
                        
                        /* console.log("afd"+JSON.stringify(trademark)); */
                        //表单初始赋值 从表单中提取数据
                          form.val('example', {
                            "topic":trademark.topic,
                            "author":trademark.author,
                            "authorUnit":trademark.authorUnit,
                            "publishtime":trademark.publishtime,
                            "meetingName":trademark.meetingName,
                            "meetingLocation":trademark.meetingLocation,
                            "keyword":trademark.keyword,
                            "communicateAuthor":trademark.communicateAuthor,
                            "englishSummary":trademark.englishSummary,
                            "meetingRecord":trademark.meetingRecord,
                            "contentType":trademark.contentType,
                            "unit":trademark.unit,
                            "englishSummary":trademark.englishSummary,
                            "paperfile":trademark.listFile[0].path,
                            "paperfile2":trademark.listFile[1].path
                            // 修改此输入框的value值，此value为测试值 paperfile为测试自定义值，证明文件值
                          });
                          var domain = window.location.host;
                          var url =data.data.url;
                          var imgpath=domain+url;
                          var otherfile=trademark.listFile;
                          otherfile.splice(0,2);
                          $("#demo1").attr("src","https://"+imgpath);
                        //文件表格展示
                          table.render({
                           elem: '#demo'
                           //,url: 'showpaperfileDetails.do'
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
	

//发表电子版文件点击事件-在线预览
$("#paperOnline").click(function(){
	/* var ops="http://"+window.location.host+"/"; */ //调整时开放此数据
	var address=$('input[name="paperfile"]').val();
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
//发表电子版文件点击事件-下载
$("#paperDownload").click(function(){
	var address=$('input[name="paperfile"]').val();
	/* download(ops+address); */
	download(address);
})
//证明文件文件点击事件-在线预览
$("#paperOnline2").click(function(){
	/* var ops="http://"+window.location.host+"/"; */ //调整时开放此数据
	var address=$('input[name="paperfile2"]').val();
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
$("#paperDownload2").click(function(){
	var address=$('input[name="paperfile2"]').val();
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
        