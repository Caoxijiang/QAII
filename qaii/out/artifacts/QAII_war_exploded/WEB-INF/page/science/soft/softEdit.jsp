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
	    height:auto;
	}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="techadd">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">软著&nbsp;—&nbsp;修改界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('soft.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<!-- 采用表格内直接行结构  -->
 <form class="layui-form" action="updatesofts.do" method="post" lay-filter="example" enctype="multipart/form-data">
<!--  第一块内容-->
	  <div class="layui-row">
		<h1>软著基本信息</h1>
	  	<div class="layui-row">
			<div class="layui-col-md4">
				<div class="layui-form-item">
				<input id="id" value='${param.id}' name="id" type="hidden" />
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
						<input type="text" name="softfile" class="layui-input input" style="width:50%;display:inline-block;" disabled="">
						<input id="fid" name='fid' type="hidden" />
						<a class="layui-btn layui-btn-tired layui-btn-xs" id="softOnline">在线预览</a>
 						<a class="layui-btn layui-btn-xs" id="softDownload">下载</a>
 						<a class="layui-btn layui-btn-edit layui-btn-xs" id="upload">重新上传</a>
					</div>
				</div>
			</div>
		</div>
	    <div class="layui-col-md12">
			<div class="layui-form-item">
				<label class="layui-form-label">其他文件</label>
				<div class="layui-input-block">
					<table id="demo" lay-filter="test"></table>
					<script type="text/html" id="barDemo">
  						<a class="layui-btn layui-btn-tired layui-btn-xs" lay-event="online">在线预览</a>
  						<a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
  						<a class="layui-btn layui-btn-edit layui-btn-xs" lay-event="upload">重新上传</a>
						<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
					</script>
				</div>
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
					  <!-- <button type="button" class="layui-btn" id="testListAction">开始上传</button> -->
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
var id=${param.userId};
$.post({
	url:"showSoftDetails.do",
	data:{
        id:id
    },
	success:function(data){
		var deptInfo=data.data;
		if(deptInfo!=null){

		
			//JavaScript代码区域
			layui.use(['form', 'layedit', 'laydate','table','element','upload'], function(){
			  var form = layui.form,
				element = layui.element,
				table=layui.table,
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
				
			//文件表格展示
            let trademark=data.data;
            //预定义必传文件路径
            if(trademark.softFile== false){
         	   trademark.softFile=[];
         	   trademark.softFile[0]=new Object();
         	   trademark.softFile[0].path='';
         	   trademark.softFile[0].id='';
            }
              form.val('example', {
            	  "id":trademark.id,
                  "softDept":trademark.softDept,
                  "softCode":trademark.softCode,
                  "softName":trademark.softName,
                  "softWriter":trademark.softWriter,
                  "softAuthor":trademark.softAuthor,
                  "softAgency":trademark.softAgency,
                  "softDevelopendtime":trademark.softDevelopendtime,
                  "softFirstpublishtime":trademark.softFirstpublishtime,
                  "softNum":trademark.softNum,
                  "softCertificatetime":trademark.softCertificatetime,
                  "softCost":trademark.softCost,
                  "softInvoiceper":trademark.softInvoiceper,
                  "softUpdatetime":trademark.softUpdatetime,
                  "softRemark":trademark.softRemark,
                  "softfile":trademark.softFile[0].path,
                  "fid":trademark.softFile[0].id
                // 修改此输入框的value值，此value为测试值 softfile为测试自定义值，证明文件值
              });
              var otherfile=trademark.softFile;
              otherfile.splice(0,1);
			  //文件表格展示
			   table.render({
			    elem: '#demo'
			    /* ,url: 'findProessimg.do?'//数据接口 */ 
			    ,page: false//开启分页
			    ,cols: [[ //表头
			      {field: 'id', type:'numbers',title: '序号', width:80}
			      ,{field: 'filename', title: '文件名'}
			      ,{field: 'path', title: '文件名'}
			      ,{field: 'operator', title: '操作',toolbar: '#barDemo'}
			    ]],
			    limit: 999999,
			    /* data:obj */
			    data:otherfile
			  });
			   //监听行工具事件
				  table.on('tool(test)', function(obj){
				    var data = obj.data;
				    //console.log(obj)
				    if(obj.event === 'del'){
				    	var address=data.path;
						var id=data.id;
						var softName=trademark.softName;
				      layer.confirm('真的删除行么', function(index){
				    	  let arr=[data.id];
				          $.post({
				          	url:"removeOthersoftfile.do",
				          	data:{
				          		"id" : id,
				          		"address" : address
				          	},
				          	success:function(data){
				          		console.log(data);
				          		if(data.data){
				          		    //删除对应行（tr）的DOM结构
				          		    alert("删除成功!");
				          			obj.del();
				          			layer.close(index);
				          		}else{
				          			layer.alert("删除失败")
				          		}
				          		
				          	}
				          }) 
				      });
				    } else if(obj.event === 'online'){//在线预览，暂支持图片和pdf形式
				    	var address=data.path;
				    	var reg1=new RegExp("jpg","i");
				    	var reg2=new RegExp("pdf","i");
				    	var reg3=new RegExp("png","i");
				    	if(reg1.test(address)||reg2.test(address)||reg3.test(address)){
				    		window.open(address);
				    	}else{
				    		alert("系统目前暂不支持非图片和pdf文件的预览!其他文件请下载到本地预览。");
				    	};
				    }else if(obj.event === 'download'){//文件下载
				    	var address=data.path;
				    		download(address);
					}else if(obj.event === 'upload'){//文件重新上传
						var address=data.path;
						var id=data.id;
						var softName=trademark.softName;
					    layer.open({
					    	type:2,
					    	title:"重新上传文件",
					    	content:'softfilereloadadd.do?id='+id+'&address='+address+'&softName='+softName,
					    	anim:0
						});
					}//事件监听
				  })
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
$.post({
    url:"findDeptInfoList.do",
    success:function(data) {
        var deptInfo = data.data;
        if (deptInfo != null) {
            $(deptInfo).each(function (index, element) {
                index += 1;
                let heml = '<option value=' + element.deptName + '>' + element.deptName + '</option>';
                $("#deptt").append(heml);
            })
        }
    }
})
</script>
<script type="text/javascript">
//证明文件点击事件-在线预览
$("#softOnline").click(function(){
	/* var ops="http://"+window.location.host+"/"; */ //调整时开放此数据
	var address=$('input[name="softfile"]').val();
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
$("#softDownload").click(function(){
	var address=$('input[name="softfile"]').val();
	/* download(ops+address); */
	download(address);
})
//证明文件点击事件-重新上传
$("#upload").click(function(){
	var address=$('input[name="softfile"]').val();
	var id=$('input[name="fid"]').val();
	var softName=$('input[name="softName"]').val();
	var sid=$('input[name="id"]').val();
	layer.open({
		type:2,
		title:"重新上传文件",
		content:'softfilereload.do?id='+id+'&softName='+softName+'&address='+address+'&sid='+sid,
		anim:0  
	});
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
        