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
	<div class="techadd" style="width:330px;">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">签订协议情况&nbsp;—&nbsp;修改界面</span>
	</div>
	<!--导出-->
	<button onclick="srchange('innovate.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>
</div>
<div class="layui-container addtop">
	<form class="layui-form" action="updateSigningAgreement.do" method="post" enctype="multipart/form-data" lay-filter="example">
		<!-- 基本信息 -->
		<div class="layui-row contern">
			<h1>基本信息</h1>
            <input id="id" name="id" type="hidden">
            <input id="fid" name="fid" type="hidden">
            <input id="fpath" name="fpath" type="hidden">
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">合作方向</label>
					<div class="layui-input-block">
						<input type="text" name="directionCooperation" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">协议签订时间</label>
					<div class="layui-input-block">
						<input type="text" name="signingTime" lay-verify="title" autocomplete="off" class="layui-input" id="test1">
					</div>
				</div>
			</div>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label" style="padding:0px 15px;">青岛智能院<br />及孵化公司</label>
					<div class="layui-input-block">
						<input type="text" name="colleageIncubator" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-col-xs6 layui-col-md6">
				<div class="layui-form-item">
					<label class="layui-form-label">合作单位</label>
					<div class="layui-input-block">
						<input type="text" name="cooperationUnit" lay-verify="title" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-row contern">
			<h1>其他信息</h1>
			<div class="layui-col-xs10 layui-col-md10">
				<div class="layui-form-item itemadd">
					<label class="layui-form-label" style="width:190px;">上传附件（协议扫描件）</label>
					<div class="layui-input-block" style="margin-left:170px;">
						<div class="layui-upload">
							<input type="text" name="file0" class="layui-input input" style="width:48%;display:inline-block;" disabled="">
							<a class="layui-btn layui-btn-tired layui-btn-xs" id="paperOnline">在线预览</a>
							<a class="layui-btn layui-btn-xs" id="paperDownload">下载</a>
							<a class="layui-btn layui-btn-edit layui-btn-xs" id="upload">重新上传</a>
						</div>
					</div>
				</div>
			</div>
			<div class="layui-col-xs12 layui-col-md12">
				<div class="layui-form-item">
					<label class="site-demo-button layui-form-label">备注</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea" name="remake" lay-verify="content" id="LAY_demo_editor"></textarea>
					</div>
				</div>
			</div>
		</div>
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
<script src="${basePath}/commen/layui/layui.js"></script>
<script>;
    var address1=null;
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
//上传附件
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
//表单初始赋值
        var id=${param.userId};
        if(id!=null){
            $.post({
                url:"getSigningAgreement.do",
                data:{
                    id:id
                },
                success:function(data){
                    if(data!=null){
                        let awardInfo=data;
                        address1=awardInfo.listFile[0].filePath;
                        //表单初始赋值 从表单中提取数据
                        form.val('example', {
                            "id":awardInfo.id,
                            "directionCooperation":awardInfo.directionCooperation,
                            "signingTime":awardInfo.signingTime,
                            "colleageIncubator":awardInfo.colleageIncubator,
                            "cooperationUnit":awardInfo.cooperationUnit,
                            "remake":awardInfo.remake,
                            "file0":awardInfo.listFile[0].fileName,
                            "fid":awardInfo.listFile[0].id,
                            "fpath":awardInfo.listFile[0].filePath
                        })
                    }else{
                        alert("查看详情失败")
                    }
                }
            })
        }else{
            alert("请刷新页面");
        }
    });
</script>
<script src="${basePath}/js/iframesrc.js"></script>
<script type="text/javascript">
    //在线预览
    $("#paperOnline").click(function(){
         var ops="http://"+window.location.host+"/"; //调整时开放此数据
        var address=address1;
        var reg1=new RegExp("jpg","i");
        var reg2=new RegExp("pdf","i");
        var reg3=new RegExp("png","i");
        if(reg1.test(address)||reg2.test(address)||reg3.test(address)){
            /* window.open(ops+address); */
            window.open(ops+address);
        }else{
            alert("系统目前暂不支持非图片和pdf文件的预览!其他文件请下载到本地预览。");
        };
    })
    //下载
    $("#paperDownload").click(function(){
        var ops="http://"+window.location.host+"/"; //调整时开放此数据
        var address=address1;
         download(ops+address);
        /*download(address);*/
    })
    //重新上传
    $("#upload").click(function(){
        var id=$('input[name="id"]').val();
        var fid=$('input[name="fid"]').val();
        var fpath=$('input[name="fpath"]').val();
        layer.open({
            type:2,
            title:"重新上传文件",
            content:'innovatefilereload.do?id='+id+'&fid='+fid+'&fpath='+fpath,
            anim:0
        });
    })

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
</script>
</body>
</html>