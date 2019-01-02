<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>资料审查-文件预览</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/science.css" media="all" />
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/jquery.table2excel.js"></script>
  <style>
    body{margin: 10px;}
	.btnfile{width:100px;height:30px;font-size:14px;line-height:30px;border-radius:2px !important;background: #fff;color: #1b2032;}
	.btnfile:hover{background: #1576bd;color: #fff;}
	.layui-btn .layui-icon {margin-right: 3px;font-size: 16px;}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="techadd" style="width:300px;">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span>专利&nbsp;—&nbsp;资料审查</span>
		<span>&nbsp;>&nbsp;</span>
		<span class="blue">文件预览</span>
	</div>
	<div class="layui-btn-group demoTable">
	  <button class="layui-btn btnfile" data-type="getCheckData" style="margin-left:20px;margin-right:10px !important">
	  	<i class="layui-icon layui-icon-refresh-3"></i>更新
	  </button>
	  <button class="layui-btn btnfile" data-type="getCheckLength" style="margin-right:10px !important">
	  	<i class="layui-icon layui-icon-delete"></i>删除
	  </button>
	  <button class="layui-btn btnfile" data-type="isAll">
	  	<i class="layui-icon layui-icon-download-circle"></i>下载
	  </button>
	</div>
	<button onclick="srchange('patentData.do?userId=${param.userId}&step=${param.step}&patAuthor=${param.patAuthor}&patName=${requestScope.utflist[2]}&patPublishtime=${param.patPublishtime}')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
	<table id="demo" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-tired layui-btn-xs" lay-event="online">在线预览</a>
		<a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
  		<a class="layui-btn layui-btn-edit layui-btn-xs" lay-event="upload">重新上传</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
/* 获取页面传递过来的值 */
var userID=${param.userId};
var step=${param.step};
 var pat="${requestScope.utflist[0]}";
let opss=[];
console.log(pat);
layui.use('table', function(obj){
	  var table = layui.table;
	  table.render({
	    elem: '#demo'
	    ,url: 'findProessimg.do?sid'+"="+step //数据接口 */
	    ,page: false//开启分页
	    ,cols: [[ //表头
	    	{type: 'checkbox'}
	      ,{field: 'id', type:'numbers',title: '序号', width:80}
	      ,{field: 'name', title: '文件名'}
	      ,{field: 'operator', title: '操作',toolbar: '#barDemo'}
	    ]],
	    limit: 999999,
	    data:obj
	  });
	//监听表格复选框选择
	  table.on('checkbox(test)', function(obj){
	    console.log(obj)
	  }); 
	//监听头部操作选项
	  var $ = layui.$, active = {
	    getCheckData: function(){ //更新数据
	    	 table.reload('demo',{
	    	 /* ,url: '/demo/table/user/' //数据接口 */
	    	 });
	    }
	    ,getCheckLength: function(){ //批量删除
	      var checkStatus = table.checkStatus('demo')
	      ,data = checkStatus.data;
	      for(var i=0;i<data.length;i++){
	    	  /*console.log(data[i].path);*/
	      }
	    }
	    ,isAll: function(){ //批量下载
	         let ops="http://"+window.location.host+"/";
	    	 var checkStatus = table.checkStatus('demo')
		       ,data = checkStatus.data;
	    	    console.log("23323232");
		        for(let i=0;i<data.length;i++){
		        opss.push(ops+data[i].path);
                downloadAll(opss);
		        console.log(data[i].path)
				console.log(ops+opss)
                  //把所有的path放到数组中也是一种思路
		      }
               //   downloadAll(opss);
		          opss=[];
	    }
	  };
	  
	  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	  
	  //监听行工具事件
	  table.on('tool(test)', function(obj){
	    var data = obj.data;
	    var ops="http://"+window.location.host+"/";
	    //console.log(obj)
	    if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	          let arr=[data.id];
	          alert(arr)
	          $.post({
	          	url:"dellProessimg.do",
	          	data:{
	          		"requestDate" : arr
	          	},
	          	success:function(data){
	          		if(data.data){
	          		    //删除对应行（tr）的DOM结构
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
	    		window.open(ops+address);
	    		console.log(address)
	    	}else{
	    		alert("系统目前暂不支持非图片和pdf文件的预览!其他文件请下载到本地预览。");
	    	};
	    }else if(obj.event === 'download'){//文件下载
	        var addressid=data.id;
	    	var address=data.path;
            download(ops+address);
		}else if(obj.event === 'upload'){//文件重新上传
			var address=data.path;
			var id=data.id;
		    layer.open({
	    	  type:2,
			  title:"重新上传文件",
			  content:'patentfilereload.do?userID='+userID+'&step='+step+'&pat='+pat+'&id='+id,
			});     
		    
		}//事件监听
	  })
	});
</script>
<script>
function download(src) {
    var form = $("<form>");
    form.attr("style","display:none");
    form.attr("target","");
    form.attr("method","post");
    form.attr("action",  "Fileupload.do");
    var input1 = $("<input>");
    input1.attr("type","hidden");
    input1.attr("dataType","json");
    input1.attr("name","strZipPath");
    input1.attr("value", src);
    $("body").append(form);
    form.append(input1);
    form.submit();
    form.remove();
};


function downloadAll(sus) {
	window.location.href = ("http://"+window.location.host+"/"+"/QAII/FileupLoadAlls.do?code="+sus)
}

</script>
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>        
        