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
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
	.btnfile{width:100px;height:30px;font-size:14px;line-height:30px;background:#1576bd;color:#fff;}
	.btnfile:hover{background:#1576bd;color:#fff;}
	#test1{width:100% !important;text-align:center;height: -moz-calc( 100vh - 150px ) !important;height: -webkit-calc( 100vh - 150px ) !important;height: calc( 100vh - 150 px ) !important;}
  	.layui-carousel>[carousel-item] {position: relative;width: 100%;height: 100%;overflow:scroll;}
  	img{max-width:100%;}
  	.download{background:none;border:none;position:absolute;top:10px;right:10px;}
  	.download:hover{top:5px;right:5px;}
  	.download i{font-size:30px;color:#aaa;}
  	.download:hover i{font-size:40px;color:#1576bd;font-weight:bold;}
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
	<button class="layui-btn btn btnfile" style="margin-left:10px;margin-right:10px !important">
			图片文件
	</button>
	<button class="layui-btn btn btnfile" style="margin-right:10px !important">
		PDF文件
	</button>
	<button class="layui-btn btn btnfile">
		其他文件
	</button>
	<a target='_black' href='http://localhost:8083/img/222.pdf'>
	666</a>	
	<!--	导出             -->
	<button onclick="srchange('patentData.do?userId=20')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop"> 
<!-- 图片文件预览  -->
	<div>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		  <legend>图片文件</legend>
		</fieldset>  
		<div class="layui-carousel" id="test1" lay-filter="test1">
		  <div carousel-item="">
		    <div>
		    	<img src="http://localhost:8083/img/1111.png">
		    	<button class="download" onclick=" download('http://localhost:8083/img/222.docx')">
		    		<i class="layui-icon layui-icon-download-circle"></i>
		    	</button>
		    </div>
		    <div>
		    	<img src="http://localhost:8083/img/999.jpg">
		    	<button class="download" onclick=" download('http://localhost:8083/img/999.jpg')">
		    		<i class="layui-icon layui-icon-download-circle"></i>
		    	</button>
		    </div>
		    <div>
		    	<img src="http://localhost:8083/img/timg (1).jpg">
		    	<button class="download" onclick=" download('http://localhost:8083/img/timg (1).jpg')">
		    		<i class="layui-icon layui-icon-download-circle"></i>
		    	</button>
		    </div>
		    <div>
		    	<img src="http://localhost:8083/img/timg.jpg">
		    	<button class="download" onclick=" download('http://localhost:8083/img/timg.jpg')">
		    		<i class="layui-icon layui-icon-download-circle"></i>
		    	</button>
		    </div>
		    <div>
		    	<img src="http://localhost:8083/img/555.jpg">
		    	<button class="download" onclick=" download('http://localhost:8083/img/555.jpg')">
		    		<i class="layui-icon layui-icon-download-circle"></i>
		    	</button>
		    </div>
		  </div>
		</div> 
	</div>
 <!-- 图片文件预览  --> 
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
/* 获取页面传递过来的值 */
var userID=${param.userId};
console.log(userID);
var step=${param.step}+"";

layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form; 
  //常规轮播
  carousel.render({
    elem: '#test1'
    ,arrow: 'always'
    ,autoplay:false
  });
});
</script>
<script>
function download(src) {
    var $a = document.createElement('a');
    $a.setAttribute("href", src);
    $a.setAttribute("download", "");
    var evObj = document.createEvent('MouseEvents');
    evObj.initMouseEvent( 'click', true, true, window, 0, 0, 0, 0, 0, false, false, true, false, 0, null);
    $a.dispatchEvent(evObj);
};

</script>
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>        
        