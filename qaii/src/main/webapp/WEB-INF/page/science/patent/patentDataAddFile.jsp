<!doctype html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="utf-8">
<title>权限添加界面</title>
<link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
<link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all">
<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
<style>
	.layui-table th{padding-left:9px;height:40px;max-height:40px;line-height:40px;font-size:16px;}
	.layui-table tr td{padding-left:9px;height:40px;max-height:40px;line-height:40px;font-size:14px;}
</style>
</head>

<body>
<div class="layui-upload">
  <div class="layui-upload-list">
    <table class="layui-table">
      <thead>
        <tr>
	        <th>文件名</th>
	        <th>大小</th>
	        <th>状态</th>
	        <th>操作</th>
      	</tr></thead>
      <tbody id="demoList"></tbody>
    </table>
  </div>
  <button type="button" class="layui-btn layui-btn-normal" id="testList">选择文件</button> 
  <button type="button" class="layui-btn" id="testListAction">开始上传</button>
</div> 
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
/* 获取页面传递过来的值 */
var userID=${param.userId};
var step=${param.step};
var patName=${param.patName};


layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  //多文件列表示例
  var demoListView = $('#demoList')
  ,uploadListIns = upload.render({
    elem: '#testList'
    ,url: 'processupload.do'//文件上传接口
    ,accept: 'file'
    ,multiple: true
    ,auto: false
    ,data: {
	    	oid:userID,
	        step:step,
	        patName:patName,
	        type:"insert"
    		}
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
            ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
          ,'</td>'
        ,'</tr>'].join(''));    
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
</script>
	
</body>
</html>
