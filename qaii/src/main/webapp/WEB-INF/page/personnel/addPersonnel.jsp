<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>成员管理</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/jquery.table2excel.js"></script>
  <style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
	.noExl {
    display: none;
}
  </style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="layui-btn-group demoTable">
  	  <span class="limit">成员管理（165）</span>
		<a href="adddetail.do" target="_blank">
			<button class="layui-btn btn" style="margin-left:40px !important;margin-right:16px !important">
				<i class="layui-icon layui-icon-add-1"></i>添加
			</button>
		</a>
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
			<option value="empDept">部门</option>
			<option value="empJobtitlelevel">职称等级</option>
			<option value="empGender">性别</option>
		</select>
		<div class="layui-inline" style="margin-left:-5px;margin-right:-6px;margin-top:1px;">
			<input class="layui-input" name="id" id="demoReload" autocomplete="off">
		</div>
		<button class="layui-btn" id="search" data-type="reload" style="height: 36px;line-height: 36px;margin-top:1px;">搜索</button>
	</div>
		
	
</div>
<!-- 操作-->
<div class="action"> 
	<div class="int-inline"><input id="id"  type="checkbox" value="序号" checked="true"/><lable>序号</lable></div>
	<div class="int-inline"><input id=empNum  type="checkbox" value="工号" checked="flase"/><lable>工号</lable></div>
	<div class="int-inline"><input id="empName"  type="checkbox" value="姓名" checked/><lable>姓名</lable></div>
	<div class="int-inline"><input id="empGender"  type="checkbox" value="性别" checked/><lable>性别</lable></div>
	<div class="int-inline"><input id="empDept"  type="checkbox" value="部门" checked/><lable>部门</lable></div>
	<div class="int-inline"><input id="empPosition"  type="checkbox" value="职务" checked/><lable>职务</lable></div>
	<div class="int-inline"><input id="empHireStarttime"  type="checkbox" value="聘期" checked/><lable>聘期</lable></div>
	<div class="int-inline"><input id="empIdcard"  type="checkbox" value="身份证号" checked/><lable>身份证号</lable></div>
	<div class="int-inline"><input id="empIdcardEndtime"  type="checkbox" value="身份证到期时间" checked/><lable>身份证到期时间</lable></div>
	<div class="int-inline"><input id="empEthnic"  type="checkbox" value="民族" checked/><lable>民族</lable></div>
	<div class="int-inline"><input id="empPoliticallandscape"  type="checkbox" value="政治面貌" checked/><lable>政治面貌</lable></div>
	<div class="int-inline"><input id="empMaritalstatus"  type="checkbox" value="婚姻状况" checked/><lable>婚姻状况</lable></div>
	<div class="int-inline"><input id="empFirsteducation"  type="checkbox" value="第一学历" checked/><lable>第一学历</lable></div>
	<div class="int-inline"><input id="empFirsteducationschool"  type="checkbox" value="第一学历学校" checked/><lable>第一学历学校</lable></div>
	<div class="int-inline"><input id="empFirsteducationpro"  type="checkbox" value="第一学历专业" checked/><lable>第一学历专业</lable></div>
	<div class="int-inline"><input id="empFirstgraduationtime"  type="checkbox" value="第一学历毕业时间" checked/><lable>第一学历毕业时间</lable></div>
	<div class="int-inline"><input id="empSecondeducation"  type="checkbox" value="第二学历" checked/><lable>第二学历</lable></div>
	<div class="int-inline"><input id="empSecondeducationschool"  type="checkbox" value="第二学历学校" checked/><lable>第二学历学校</lable></div>
	<div class="int-inline"><input id="empSecondeducationpro"  type="checkbox" value="第二学历专业" checked/><lable>第二学历专业</lable></div>
	<div class="int-inline"><input id="empSecondgraduationtime"  type="checkbox" value="第二学历毕业时间" checked/><lable>第二学历毕业时间</lable></div>
	<div class="int-inline"><input id="empThirdeducation"  type="checkbox" value="第三学历" checked/><lable>第三学历</lable></div>
	<div class="int-inline"><input id="empThirdeducationschool"  type="checkbox" value="第三学历学校" checked/><lable>第三学历学校</lable></div>
	<div class="int-inline"><input id="empThirdeducationpro"  type="checkbox" value="第三学历专业" checked/><lable>第三学历专业</lable></div>
	<div class="int-inline"><input id="empThirdgraduationtime"  type="checkbox" value="第三学历毕业时间" checked/><lable>第三学历毕业时间</lable></div>
	<div class="int-inline"><input id="empJobtitle"  type="checkbox" value="职称名称" checked/><lable>职称名称</lable></div>
	<div class="int-inline"><input id="empJobtitlelevel"  type="checkbox" value="职称等级" checked/><lable>职称等级</lable></div>
	<div class="int-inline"><input id="empJobtitleobtaintime"  type="checkbox" value="职称取得时间" checked/><lable>职称取得时间</lable></div>
	<div class="int-inline"><input id="empPhone"  type="checkbox" value="联系电话" checked/><lable>联系电话</lable></div>
	<div class="int-inline"><input id="empEmergencycontactandphone"  type="checkbox" value="紧急联系人及联系方式" checked/><lable>紧急联系人及联系方式</lable></div>
	<div class="int-inline"><input id="empFileaddress"  type="checkbox" value="档案所在地" checked/><lable>档案所在地</lable></div>
	<div class="int-inline"><input id="empAccountaddress"  type="checkbox" value="户口所在地" checked/><lable>户口所在地</lable></div>
	<div class="int-inline"><input id="empHomeaddress"  type="checkbox" value="家庭住址" checked/><lable>家庭住址</lable></div>
	<div class="int-inline"><input id="empWorktype"  type="checkbox" value="用工形式" checked/><lable>用工形式</lable></div>
	<div class="int-inline"><input id="empCompile"  type="checkbox" value="编制" checked/><lable>编制</lable></div>
	<div class="int-inline"><input id="empInductiontime"  type="checkbox" value="入职时间" checked/><lable>入职时间</lable></div>
	<div class="int-inline"><input id="empTryoutendtime"  type="checkbox" value="试用期结束日期" checked/><lable>试用期结束日期</lable></div>
	<div class="int-inline"><input id="empContractendtime"  type="checkbox" value="合同期满日期" checked/><lable>合同期满日期</lable></div>
	<div class="int-inline"><input id="empContractsignednum"  type="checkbox" value="合同期签订次数" checked/><lable>合同期签订次数</lable></div>
	<div class="int-inline"><input id="empReturnee"  type="checkbox" value="是否留学归国人员" checked/><lable>是否留学归国人员</lable></div>
	<div class="int-inline"><input id="empForeign"  type="checkbox" value="是否外籍人员" checked/><lable>是否外籍人员</lable></div>
	<div class="int-inline"><input id="empRemarks"  type="checkbox" value="备注" checked/><lable>备注</lable></div>
</div>  
<!-- 数据展示主表格-->
<div class="table2excel">
	<table class="layui-table" id="testTable" lay-filter="demo" style="margin-top:5px;width: 100% !important;"></table>
</div>
 <!--  <a class="layui-btn layui-btn-xs" href="seeEmpInfo.do?userId='{{d.empNum}}'" target="_blank" method="post" id="chex">查看详情</a> -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="detail"  href="seeEmpInfo.do?userId='{{d.id}}'" target="_blank">查看详情</a>
  <a class="layui-btn layui-btn-xs layui-btn-edit" href="updateEmpInfo.do?userId='{{d.id}}'" target="_blank" >修改</a>
  <a class="layui-btn layui-btn-xs layui-btn-tired" lay-event="dimission">离职</a>
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
	console.log(obj.data);
	  
  //执行一个 table 实例
  table.render({
    elem: '#testTable',
	page: false,
	method:'post',
	limit:9999999,//不设置分页，最大数据量为9999999
	id: 'testReload',  
//    height: 332,
    url: 'findAllEmpInfo.do', //数据接口
	cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    cols: [[ //标题栏
		{type:'checkbox',fixed: 'left'},
		{field: 'id', title: '序号',fixed: 'left',width:100},
		{field: 'empNum', title: '工号',fixed: 'left',width:100},
		{field: 'empName', title: '姓名',fixed: 'left',width:150},
		{field: 'empGender', title: '性别',sort: true},
		{field: 'empDept', title: '部门',sort: true,width:200},
		{field: 'empPosition', title: '职务',sort: true,width:150},
		{field: 'empHireStarttime', title: '聘期',sort: true},
		{field: 'empIdcard', title: '身份证号',width:220},
		{field: 'empIdcardEndtime', title: '身份证到期时间',sort: true,width:200},
		{field: 'empEthnic', title: '民族',sort: true},
		{field: 'empPoliticallandscape', title: '政治面貌',sort: true,width:150},
		{field: 'empMaritalstatus', title: '婚姻状况',sort: true,width:150},
		
		{field: 'empFirsteducation', title: '第一学历',sort: true,width:200},
		{field: 'empFirsteducationschool', title: '第一学历学校',sort: true,width:200},
		{field: 'empFirsteducationpro', title: '第一学历专业',sort: true,width:200},
		{field: 'empFirstgraduationtime', title: '第一学历毕业时间',sort: true,width:230},
		{field: 'empSecondeducation', title: '第二学历',sort: true,width:200},
		{field: 'empSecondeducationschool', title: '第二学历学校',sort: true,width:200},
		{field: 'empSecondeducationpro', title: '第二学历专业',sort: true,width:200},
		{field: 'empSecondgraduationtime', title: '第二学历毕业时间',sort: true,width:230},
		{field: 'empThirdeducation', title: '第三学历',sort: true,width:200},
		{field: 'empThirdeducationschool', title: '第三学历学校',sort: true,width:200},
		{field: 'empThirdeducationpro', title: '第三学历专业',sort: true,width:200},
		{field: 'empThirdgraduationtime', title: '第三学历毕业时间',sort: true,width:230},

		{field: 'empJobtitle', title: '职称名称',sort: true,width:200},
		{field: 'empJobtitlelevel', title: '职称等级',sort: true,width:200},
		{field: 'empJobtitleobtaintime', title: '职称取得时间',sort: true,width:200},
		
		{field: 'empPhone', title: '联系电话',width:200},
		{field: 'empEmergencycontactandphone', title: '紧急联系人及联系方式',width:250},
		{field: 'empFileaddress', title: '档案所在地',sort: true,width:200},
		{field: 'empAccountaddress', title: '户口所在地',sort: true,width:200},
		{field: 'empHomeaddress', title: '家庭住址',sort: true,width:250},
		{field: 'empWorktype', title: '用工形式',sort: true,width:200},
		{field: 'empCompile', title: '编制',sort: true,width:100},
		{field: 'empInductiontime', title: '入职时间',sort: true,width:200},
		{field: 'empTryoutendtime', title: '试用期结束日期',sort: true,width:200},
		{field: 'empContractendtime', title: '合同期满日期',sort: true,width:200},
		{field: 'empContractsignednum', title: '合同签订次数',sort: true,width:200},
		{field: 'empReturnee', title: '是否留学归国人员',sort: true,width:230},
		{field: 'empForeign', title: '是否外籍人员',sort: true,width:200},
		{field: 'empRemarks', title: '备注',sort: true,width:200},
		{field: 'sex', title: '操作',toolbar: '#barDemo',fixed: 'right',width:340}
    ]],
	  //表格数据
    data:obj.data
  });
  //alert(JSON.stringify(obj.cache.testReload[0]))
  console.log(obj);
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
  		  console.log(num);
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
  				 console.log(myA[i]+"000000000000000");
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
  			if(check=="empDept"){
  				alert("搜索'部门'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="empJobtitlelevel"){
  				alert("搜索'职称等级'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
  			}else if(check=="empGender"){
  				alert("搜索'性别'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
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
		//$("#up").html("<a href="+"adddetail.do"+ "target="+"_blank>");
     // layer.msg('用户名：'+JSON.stringify(data.id)+'<br>密码：'+JSON.stringify(data.empPhone)+'<br>角色：'+JSON.stringify(data.rid));
    } else if(layEvent === 'del'){
      layer.confirm('确定删除信息', function(index){
          let arr=[data.id];
          console.log(data) 
          $.post({
          	url:"DellempInfo.do",
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
      layer.alert(
		  '<div class="layui-form-item">'+

			'<label class="layui-form-label">角色</label>'+
			'<div class="layui-input-block">'+
				'<select name="interest" lay-filter="aihao">'+
					'<option value=""></option>'+
					'<option value="0">超级管理员</option>'+
					'<option value="1" selected="">院级权限</option>'+
					'<option value="2">人事部门权限</option>'+
					'<option value="3">产业化处权限</option>'+
					'<option value="4">科技管理处</option>'+
				'</select>'+
			'</div>'+
		'</div>')
    }else if(layEvent==="dimission"){
    	 layer.confirm('确定离职信息', function(index){
             let arr=data.id;
             console.log(data) 
             $.post({
             	url:"dellempInfo.do",
             	data:{
             		"requestDate" : arr
             	},
             	success:function(data){
             		if(data.data){
             		    //删除对应行（tr）的DOM结构
             			layer.alert("离职操作成功");
             		}else{
             			layer.alert("离职操作失败");
             		}
             		
             	}
             }) 
       	  
          // obj.del(); //删除对应行（tr）的DOM结构
          // layer.close(index);
           //向服务端发送删除指  
         });
    }
  });

	//监听顶部添加删除操作
	var arr=[];
	//var arr=[];
	table.on('checkbox(demo)', function(obj){
		 var data = obj.data //获得当前行数据
		 arr.push(data.id);		 
		 
	  });
	
	$("#dellist").on('click', function(){
		$.post({
		  	url:"DellempInfo.do",
		  	data:{
		  		"requestDate" : arr
		  	},
		  	success:function(data){

		        if(data.status == 1){
		            alert('删除成功，请刷新查看');
		            window.location.reload();
		        } else {
		            alert('删除成功，请刷新查看'); return false;
		            window.location.reload();
		        }
		    }
		  }) 
	});

});






	
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
				filename: "成员管理",
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
		$(":checkbox").click(function(){
			var val=$(this).attr("id");
			if( $(this).prop('checked')){
				$("[data-field='"+val+"']").removeClass("noExl");
			}else{
				$("[data-field='"+val+"']").addClass("noExl");
			}
		});
	});
</script>
<!--自动设置主表格可视区域-->
<script>
	var hei=$(".action").height();
	var ji=$(document).height();
	var heigt=ji-hei-85;
	$(".layui-table-body").prop("height",heigt+"px");
	
	console.log(heigt);

	
</script>
</body>
</html>        
        