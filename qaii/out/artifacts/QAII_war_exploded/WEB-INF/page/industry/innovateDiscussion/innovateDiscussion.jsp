<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>合作情况管理</title>
	<link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
	<link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
	<link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/jquery.table2excel.js"></script>
	<script src="${basePath}/js/jquery.globalfunction.js"></script>
	<style>
		body{margin: 10px;}
		.layui-table-body {
			height: -moz-calc( 100vh - 190px );
			height: -webkit-calc( 100vh - 190px );
			height: calc( 100vh - 190px );
		}
		@media screen and (max-width: 1600px) {
			.layui-table-body {
				height: -moz-calc( 100vh - 145px );
				height: -webkit-calc( 100vh - 145px );
				height: calc( 100vh - 145 px );
			}
		}
		.demo-carousel{height: 200px; line-height: 200px; text-align: center;}
		.noExl {
			display: none;
		}
	</style>
</head>
<body id="bodyHei">
<div class="tool">
	<div class="layui-btn-group demoTable">
		<span class="limit">交流座谈情况( <span id="countnum"> </span> )</span>
		<a href="javascript:;" onclick="srchange('innovateDiscussionAdd.do')">
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
			<option value="unitName">我院/公司名称</option>
			<option value="cooperationName">合作单位名称</option>
			<option value="protocolName">签订的协议名称</option>
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
		<div class="int-inline"><input id="checkall"  type="checkbox" value="全选" checked="true"/><lable>全选</lable></div>
		<div class="int-inline"><input id="id"  type="checkbox" value="序号" checked="true"/><lable>序号</lable></div>
		<div class="int-inline"><input id="participant"  type="checkbox" value="参加人"checked/><lable>参加人</lable></div>
		<div class="int-inline"><input id="targetAudience"  type="checkbox" value="会谈对象" checked/><lable>会谈对象</lable></div>
		<div class="int-inline"><input id="themeTalks"  type="checkbox" value="会谈主题" checked/><lable>会谈主题</lable></div>
		<div class="int-inline"><input id="talksAddress"  type="checkbox" value="会谈地点" checked/><lable>会谈地点</lable></div>
		<div class="int-inline"><input id="talksTime"  type="checkbox" value="会谈时间" checked/><lable>会谈时间</lable></div>
		<div class="int-inline"><input id="remark"  type="checkbox" value="备注" checked/><lable>备注</lable></div>
	</div>
</div>
<!-- 数据展示主表格-->
<div class="table2excel">
	<table class="layui-table" id="testTable" lay-filter="demo" style="margin-top:5px;width: 100% !important;"></table>
</div>
<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" lay-event="detail">查看详情</a>
	<a class="layui-btn layui-btn-xs layui-btn-edit" lay-event="edit">修改</a>
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
        console.log("The obj data is "+JSON.stringify(obj.cache));

        //执行一个 table 实例
        table.render({
            elem: '#testTable',
            page: false,
            method:'post',
            limit:9999999,//不设置分页，最大数据量为9999999
            id: 'testReload',
//    height: 332,
            url: 'listExchangeTalks.do', //数据接口
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            cols: [[ //标题栏
                {type:'checkbox',fixed: 'left'},
                {field: 'id', title: '序号',type:'numbers',fixed: 'left',width:100},
                {field: 'participant', title: '参加人',fixed: 'left'},
                {field: 'targetAudience', title: '会谈对象'},
                {field: 'themeTalks', title: '会谈主题',sort: true},
                {field: 'talksAddress', title: '会谈地点',sort: true},
                {field: 'talksTime', title: '会谈时间',sort: true},
                {field: 'remark', title: '备注'},
                {field: 'sex', title: '操作',toolbar: '#barDemo',fixed: 'right'}
            ]],
            //表格数据
            data:obj.data,
            done: function(res, curr, count){
                $("#countnum").html(count);
                console.log(count+"总数");
            }
        });
        console.log(obj.cache)
        //添加筛选功能

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
                    dell("deleteExchangeTalks.do",arr);
                }else {
                    layer.alert("请选择要删除的内容");
                }
            },
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
                        if(check=="unitName"){
                            alert("搜索'我院/公司名称'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
                        }else if(check=="cooperationName"){
                            alert("搜索'合作单位名称'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
                        }else if(check=="protocolName"){
                            alert("搜索'签订的协议名称'列，中含有关键字'"+key+"'数据，共计'"+numb+"'条！");
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
            console.log(data)
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                var iframesrc="innovateDiscussionCheck.do?userId='"+data.id+"'";
                $("body", parent.document).find('iframe').attr('src',iframesrc);
            } else if(layEvent === 'del'){
                layer.confirm('确定删除信息', function(index){
                    let arr=[data.id];
                    console.log(data)
                    $.post({
                        url:"deleteExchangeTalks.do",
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
                var iframesrc="innovateDiscussionEdit.do?userId='"+data.id+"'";
                $("body", parent.document).find('iframe').attr('src',iframesrc);
            }
        });


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
            ,url: 'insertExchangeTalksWithExcel.do'
            ,accept: 'file' //普通文件
            ,done: function(res){
                alert("上传成功！请更新数据！");
                console.log(res)
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
                filename: "孵化企业获奖情况",
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
<script>
    var hei=$(".action").height();
    var ji=$(document).height();
    var heigt=ji-hei-85;
    $(".layui-table-body").prop("height",heigt+"px");
    console.log(heigt);

</script>
</body>
</html>        
        