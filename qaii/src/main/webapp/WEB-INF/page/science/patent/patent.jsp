<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>专利</title>
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
	    height: -moz-calc( 100vh - 215px );
	    height: -webkit-calc( 100vh - 215px );
	    height: calc( 100vh - 215 px );
	}
	.noExl {
	    display: none;
	}
	@media screen and (max-width: 1600px) {
		.layui-table-body {
		    height: -moz-calc( 100vh - 170px );
		    height: -webkit-calc( 100vh - 170px );
		    height: calc( 100vh - 170 px );
		}
	}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="layui-btn-group demoTable">
  	  <span class="limit">专利 ( <span id="countnum"> </span> )</span>
		<a href="javascript:;" onclick="srchange('patentAdd.do')">
			<button class="layui-btn btn" style="margin-left:40px !important;margin-right:16px !important">
				<i class="layui-icon layui-icon-add-1"></i>添加
			</button>
		</a>
		<button class="layui-btn btn" data-type="getCheckLength" id="test3" style="margin-right:16px !important">
			<i class="layui-icon layui-icon-upload-drag"></i>导入
		</button>
		<button class="layui-btn btn" id="dellist" data-type="delmore" style="margin-right:16px !important">
			<i class="layui-icon layui-icon-delete"></i>删除
		</button>
		
		<button class="layui-btn btn" data-type="getCheckLength" id="pelupdate">
			<i class="layui-icon layui-icon-refresh-3"></i>更新
		</button>	
	</div>
	<!--		导出-->
	<button class="layui-btn btn export " data-type="getCheckLength" style="float: right;margin-right: 115px;margin-top: 12.5px;">
		导出
	</button>
	<!--		搜索-->
	<div class="demoTable" style="float: right;margin-right: 115px;">
		<select class="search" id="switch">
			<option value="all">全部</option>
			<option value="patDept">部门</option>
			<option value="patType">专利类型</option>
			<option value="patName">专利名称</option>
			<option value="patAuthor">发明人</option>
			<option value="patApplyper">申请（专利权）人</option>
			<option value="patAgency">代理机构</option>
			<option value="patApplynum">申请号</option>
			<option value="patApplytime">申请日</option>
			<option value="patAuthorzationtime">授权公告日</option>
		</select>
		<div class="layui-inline" style="margin-left:-5px;margin-right:-6px;margin-top:1px;">
			<input class="layui-input" name="id" id="demoReload" autocomplete="off">
		</div>
		<button class="layui-btn" id="search" data-type="reload" style="height: 36px;line-height: 36px;margin-top:1px;">搜索</button>
	</div>
		
	
</div>
<!-- 操作-->
<div class="action">
<div class="act">
	<div class="int-inline"><input id="checkall"  type="checkbox" checked="false"/><lable>全选</lable></div>
	<div class="int-inline"><input id="id"  type="checkbox" value="序号" checked="true"/><lable>序号</lable></div>
	<div class="int-inline"><input id="patDept"  type="checkbox" value="部门" checked="flase"/><lable>部门</lable></div>
	<div class="int-inline"><input id="patType"  type="checkbox" value="专利类型" checked/><lable>专利类型</lable></div>
	<div class="int-inline"><input id="patName"  type="checkbox" value="专利名称" checked/><lable>专利名称</lable></div>
	<div class="int-inline"><input id="patDigest"  type="checkbox" value="摘要" checked/><lable>摘要</lable></div>
	<div class="int-inline"><input id="patAuthor"  type="checkbox" value="发明人" checked/><lable>发明人</lable></div>
	<div class="int-inline"><input id="patApplyper"  type="checkbox" value="申请（专利权）人" checked/><lable>申请（专利权）人</lable></div>
	<div class="int-inline"><input id="patTelltime"  type="checkbox" value="交底日期" checked/><lable>交底日期</lable></div>
	<div class="int-inline"><input id="patAgency"  type="checkbox" value="代理机构" checked/><lable>代理机构</lable></div>
	<div class="int-inline"><input id="patPrepublishaudit"  type="checkbox" value="是否提前公开实审" checked/><lable>是否提前公开实审</lable></div>
	<div class="int-inline"><input id="patApplynum"  type="checkbox" value="申请号" checked/><lable>申请号</lable></div>
	<div class="int-inline"><input id="patApplytime"  type="checkbox" value="申请日" checked/><lable>申请日</lable></div>
	<div class="int-inline"><input id="patPublishtime"  type="checkbox" value="公开日" checked/><lable>公开日</lable></div>
	<div class="int-inline"><input id="patAuthorzationtime"  type="checkbox" value="授权公告日" checked/><lable>授权公告日</lable></div>
	<div class="int-inline"><input id="patRemission"  type="checkbox" value="是否减免" checked/><lable>是否减免</lable></div>
	<div class="int-inline"><input id="patCost"  type="checkbox" value="申请费用（元）" checked/><lable>申请费用（元）</lable></div>
	<div class="int-inline"><input id="patInvoiceper"  type="checkbox" value="发票收据-汇款人" checked/><lable>发票收据-汇款人</lable></div>
	<div class="int-inline"><input id="patRemark"  type="checkbox" value="备注" checked/><lable>备注</lable></div>
	<div class="int-inline"><input id="patPenner"  type="checkbox" value="执笔人信息" checked/><lable>执笔人信息</lable></div>
	<div class="int-inline"><input id="patAgent"  type="checkbox" value="代理人" checked/><lable>代理人</lable></div>
</div>
</div>
<!-- 数据展示主表格-->
<div class="table2excel">
	<table class="layui-table" id="testTable" lay-filter="demo" style="margin-top:5px;width: 100% !important;"></table>
</div>
 <!--  <a class="layui-btn layui-btn-xs" href="seeEmpInfo.do?userId='{{d.empNum}}'" target="_blank" method="post" id="chex">查看详情</a> -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="detail" lay-event="detail">查看详情</a>
  <a class="layui-btn layui-btn-xs layui-btn-edit" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-xs layui-btn-tired" lay-event="datac">资料审查</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!-- 数据展示主表格-->
 
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
	  
layui.config({
  version: '1531663423583' //为了更新 js 缓存，可忽略
});

 
layui.use('table', function(obj){
  var table = layui.table,form = layui.form;
	 //监听表格复选框选择
	console.log("sdfgsd"+JSON.stringify(obj.cache));
	  
  //执行一个 table 实例
  table.render({
    elem: '#testTable',
	page: false,
	method:'post',
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload',
    url: 'findPatentInfo.do',  //数据接口
	cellMinWidth: 80,
    cols: [[ //标题栏
		{type:'checkbox',fixed: 'left',width:50},
		{field: 'id', title: '序号',type:'numbers',width:100},
		{field: 'patDept', title: '部门',width:200},
		{field: 'patType', title: '专利类型',width:200},
		{field: 'patName', title: '专利名称',width:150},
		{field: 'patDigest', title: '摘要',width:250},
		{field: 'patAuthor', title: '发明人',sort: true,width:250},
		{field: 'patApplyper', title: '申请（专利权）人',width:220},
		{field: 'patTelltime', title: '交底日期',sort: true,width:150},
		{field: 'patAgency', title: '代理机构',width:180},
		{field: 'patPrepublishaudit', title: '是否提前公开实审',sort: true,width:200},
		{field: 'patApplynum', title: '申请号',width:150},
		{field: 'patApplytime', title: '申请日',sort: true,width:200},
		{field: 'patPublishtime', title: '公开日',sort: true,width:200},
		{field: 'patAuthorzationtime', title: '授权公告日',width:200},
		{field: 'patRemission', title: '是否减免',width:230},
		{field: 'patCost', title: '申请费用（元）',width:200},
		{field: 'patInvoiceper', title: '发票收据-汇款人',width:200},
		{field: 'patRemark', title: '备注',width:200},
		{field: 'patPenner', title: '执笔人信息',width:200},
		{field: 'patAgent', title: '代理人',width:200},
		{field: 'sex', title: '操作',toolbar: '#barDemo',fixed: 'right',width:380}
    ]],
	  //表格数据
    data:obj.data,
    done: function(res, curr, count){
      $("#countnum").html(count);
        console.log(count+"总数");
        }
  });
  //alert(JSON.stringify(obj.cache.testReload[0]))
 console.log(obj.cache)
	//添加筛选功能
  var $ = layui.$, active = {
      reload: function(){
        var demoReload = $('#demoReload');
        var key=demoReload.val();/*关键字*/
  	  var check=$('#switch').val();/*选择提示词*/
  	  var trlen=($(".layui-table tr").length)/3;/*行数*/
  	  var num=$(".layui-table tr:eq(0) th").length-1;/*显示的列元素个数*/
  	  /*判定显示的列元素名*/
  	 if(check=="all"){
  		  var val=$(".layui-table tr:eq(0) th:eq(2)").attr('data-field');/*获取制定data-field值*/
  		  var cellval=$(".layui-table tr:eq(1) td:eq(3)").text();/*获取指定行列元素包含的文本*/
  		//逐个单元格匹配内容
  		  var myA=new Array();
  		  for(var i=1;i<trlen;i++){
  			 $(".layui-table tr:eq("+i+") td").each(function(){
  				 if($(this).hasClass("noExl")){
  					 myA[i]=myA[i];
  				 }else{
  					  myA[i]=myA[i]+$(this).text();
  					 }
  			 })
  		  }
  		//全局搜索
  		  $(".layui-table tr").each(function(){
  			 $(this).removeClass("noExl");
  		  });
  		 for(var i=1;i<trlen;i++){
  			$(".layui-table tr[data-index="+(i-1)+"]").removeClass("noExl");
  		 }
  		 var numb=0;
  		 for(var i=1;i<trlen;i++){
  			// var trval=$(".layui-table tr:eq("+i+")").text();
  			 //判定字符串是否含有指定内容
  			 if(myA[i].indexOf(key) <= 0 ) {
  				$(".layui-table tr[data-index="+(i-1)+"]").addClass("noExl");
  				 
  			}else{
  				numb=numb+1;
  			} 
  		 }
  		 alert("搜索'全部'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
       }else {
  		 	var myA=new Array();
  		 	  if($(".layui-table tr th[data-field="+check+"]").hasClass("noExl")){
  				  alert("搜索列当前不显示!");
  			}else{
  			  for(var i=1;i<trlen;i++){
  				 $(".layui-table tr:eq("+i+") td[data-field="+check+"]").each(function(){
  					 if($(this).hasClass("noExl")){
  						 myA[i]=myA[i];
  					 }else{
  						  myA[i]=myA[i]+$(this).text();
  						 }
  				 })
  			
  			  }
  			//全局搜索
  			  $(".layui-table tr").each(function(){
  				 $(this).removeClass("noExl");
  			 });
  			 for(var i=1;i<trlen;i++){
  				$(".layui-table tr[data-index="+(i-1)+"]").removeClass("noExl");
  			 }
  			 var numb=0;
  			 for(var i=1;i<trlen;i++){
  				// var trval=$(".layui-table tr:eq("+i+")").text();
  				 //判定字符串是否含有指定内容
  				 if(myA[i].indexOf(key) <= 0 ) {
  					$(".layui-table tr[data-index="+(i-1)+"]").addClass("noExl");
  				}else{
  					numb=numb+1;
  				}  
  			 }
  			if(check=="patDept"){
  				alert("搜索'部门'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patType"){
  				alert("搜索'专利类型'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patName"){
  				alert("搜索'专利名称'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patAuthor"){
  				alert("搜索'发明人'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patApplyper"){
  				alert("搜索'申请（专利权）人'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patAgency"){
  				alert("搜索'代理机构'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patApplynum"){
  				alert("搜索'申请号'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patApplytime"){
  				alert("搜索'申请日'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="patAuthorzationtime"){
  				alert("搜索'授权公告日'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}	
  		  }
  	    }//搜索结束
  	
      }
    };
    
    
    
    $('#search').on('click', function(){
//  	window.location.reload();//刷新当前页面.
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
    //页面数据刷新
    $('#pelupdate').on('click', function(){
    	window.location.reload();
    	alert("数据更新成功");
      });
	
  //监听工具条
  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'detail'){
    	var iframesrc="patentCheck.do?userId='"+data.id+"'";
    	$("body", parent.document).find('iframe').attr('src',iframesrc);
    } else if(layEvent === 'del'){
      layer.confirm('确定删除信息', function(index){
          let arr=[data.id];
          console.log(arr) 
          $.post({
          	url:"dellPatentInfo.do",
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
    	  
        obj.del(); //删除对应行（tr）的DOM结构
        layer.close(index);
        //向服务端发送删除指令
      });
    } else if(layEvent === 'edit'){
    	var iframesrc="patentEdit.do?userId='"+data.id+"'";
    	$("body", parent.document).find('iframe').attr('src',iframesrc);
    }else if(layEvent==="datac"){
    	
    	//userid为当前记录id值，将会传到资料审查界面
    	var iframesrc="patentData.do?userId='"+data.id+"'&patName="+data.patName+"&patAuthor="+data.patAuthor+"&patPublishtime="+data.patPublishtime;
    	url=encodeURI(iframesrc);
    	url=encodeURI(url);
    	$("body", parent.document).find('iframe').attr('src',iframesrc);
    }
  });


    var $ = layui.$, active = {
        delmore: function () { //获取选中数据
            confirm("请慎重考虑，删除数据不可恢复");
            var checkStatus = table.checkStatus('testReload')
                , data = checkStatus.data;
            var arr=[];
            for (var id of data){
                var ids=id.id;
               arr.push(ids)
            }
            if(arr.length!=0){
                dell("dellPatentInfo.do",arr);
            }else {
                layer.alert("请选择要删除的内容");
            }
        }
    }


    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

	function dell(url,arr) {
        $.post({
            url:url,
            data:{
                "requestDate" : arr
            },
            success:function(data){

                if(data.status == 1){
                   // alert('删除成功，请刷新查看');
                    layer.alert("删除成功");
                    window.location.reload();
                } else {
                    layer.alert("删除失败");
                    //alert('删除成功，请刷新查看'); return false;
                    window.location.reload();
                }
            }
        })
    }


});
</script>
<script src="${basePath}/commen/layui.js" charset="utf-8"></script>
<script>
layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
//指定允许上传的文件类型
upload.render({
  elem: '#test3'
  ,url: 'insertPatentByExcel.do'
  ,accept: 'file' //普通文件
  ,done: function(res){
    console.log(res),
    alert("上传成功！");
  }
})

})

	
</script>
<!--导出功能设置-->
<script type="text/javascript">
	$(function() {
		$(".export").click(function(){
			$(".layui-table-fixed tr").addClass("noExl");
			$(".layui-table-fixed th").addClass("noExl");
			$(".table2excel").table2excel({
				// 不被导出的表格行的CSS class类
				exclude: ".noExl",
				// 导出的Excel文档的名称
				name: "Excel Document Name",
				// Excel文件的名称
				filename: "专利信息",
				//文件后缀名
				fileext: ".xls",
				//是否排除导出图片
				exclude_img: false,
				//是否排除导出超链接
				exclude_links: false,
				//是否排除导出输入框中的内容
				exclude_inputs: false
			});
			window.location.reload();
		}); 
		$(".layui-form .layui-form-item div span").click(function(){
			console.log($(this).attr('class')+"5555");
		});
		//显示设置
		$(":checkbox").click(function(){
			
			var val=$(this).attr("id");
			if(val=='checkall'){
				if($(this).prop('checked')){
					$(this).parent('.int-inline').siblings().children().prop('checked',true);
					$('table tr th').removeClass("noExl");
					$('table tr td').removeClass("noExl");
				}else{
					$(this).parent('.int-inline').siblings().children().prop('checked',false);
					$('table tr th').addClass("noExl");
					$('table tr td').addClass("noExl");
				}
			}else{
				if( $(this).prop('checked')){
					$("[data-field='"+val+"']").removeClass("noExl");
					if($("[data-field='0']")){
						$("[data-field='0']").removeClass("noExl");
					}
					if($("[data-field='sex']")){
						$("[data-field='sex']").removeClass("noExl");
					}
				}else{
					$("[data-field='"+val+"']").addClass("noExl");
				}
			}
		});//显示设置
	});
</script>
<!--自动设置主表格可视区域-->
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>        
        