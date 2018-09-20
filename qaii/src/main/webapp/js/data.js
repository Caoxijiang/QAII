<<<<<<< HEAD
// JavaScript Document
$(function(){
	var theme=new Array;
	theme=[["1","提交申请1","华净老师反馈修改文件","2018-09-12"],["2","提交申请2","华净老师反馈修改文件","2018-09-12"],["3","提交申请3","华净老师反馈修改文件","2018-09-12"],["4","提交申请4","华净老师反馈修改文件","2018-09-12"],["5","提交申请5","华净老师反馈修改文件","2018-09-12"]];
	var flowtheme=document.getElementById("processul");
	var htmls="";
	for(var i=0;i<theme.length;i++){
		if(theme[i][0]%2=="1"){/*左侧数据*/
			htmls=htmls+"<li class='datali datalileft'>"+
		    "<div class='layui-timeline-contentl layui-text'>"+
		      "<h3 class='layui-timeline-title'>"+theme[i][1]+"</h3>"+
		      "<div class='databor'>"+
		      	"<div>"+
		      		theme[i][2]+
		      	"</div>"+
		      	"<div class='btncoll'>"+
		      		"<span class='datalidate'>"+theme[i][3]+"</span>"+
			      	"<button class='layui-btn btn databtn patentFile' name="+userID+"."+theme[i][0]+">"+
						"文件上传"+
					"</button>"+
					"<button class='layui-btn btn databtn patentProcess' name="+userID+"."+theme[i][0]+">"+
						"文件预览"+
					"</button>"+
				"</div>"+
		      "</div>"+
		    "</div>"+
		    "<i class='layui-icon layui-timeline-axisl'></i>"+
		  "</li>";
		
		}else if(theme[i][0]%2=="0"){/*右侧数据*/
			htmls=htmls+"<li class='layui-timeline-item datali'>"+
		    "<i class='layui-icon layui-timeline-axis'></i>"+
		    "<div class='layui-timeline-content layui-text'>"+
		      "<h3 class='layui-timeline-title'>"+theme[i][1]+"</h3>"+
		      "<div class='databor'>"+
			  	"<div>"+
			  	theme[i][2]+
		      	"</div>"+
		      	"<div class='btncollr'>"+
			      	"<button class='layui-btn btn databtn patentFile' name="+userID+"."+theme[i][0]+">"+
						"文件上传"+
					"</button>"+
					"<button class='layui-btn btn databtn patentProcess' name="+userID+"."+theme[i][0]+">"+
						"文件预览"+
					"</button>"+
					"<span class='datalidatel'>"+theme[i][3]+"</span>"+
				"</div>"+
			  "</div>"+
		    "</div>"+
		  "</li>";
		}
=======
$().ready(function(){
	var id=$("#ids").val().replace(/\'/g, '');
	console.log(id.replace(/\'/g, ''));
	if(id==null){
		alert("页面错误请刷新")
		return;
>>>>>>> e0c5b30681a81a1719df4181c80cdc3cb1940bb6
	}
	$.post({
		url:"findAllProcessInfo.do",
		data:{
			id:id,
		},
		success:function(data){
			console.log(data.data);
			var theme=new Array;
			//theme=[["1","提交申请1","华净老师反馈修改文件","2018-09-12"],["2","提交申请2","华净老师反馈修改文件","2018-09-12"],["3","提交申请3","华净老师反馈修改文件","2018-09-12"],["4","提交申请4","华净老师反馈修改文件","2018-09-12"],["5","提交申请5","华净老师反馈修改文件","2018-09-12"]];
			theme=data.data;
			var flowtheme=document.getElementById("processul");
			var htmls="";
			for(var i=0;i<theme.length;i++){
				if(theme[i].id%2=="1"){/*左侧数据*/
					htmls=htmls+"<li class='datali datalileft'>"+
				    "<div class='layui-timeline-contentl layui-text'>"+
				      "<h3 class='layui-timeline-title'>"+theme[i].title+"</h3>"+
				      "<div class='databor'>"+
				      	"<div>"+
				      		theme[i].description+
				      	"</div>"+
				      	"<div class='btncoll'>"+
				      		"<span class='datalidate'>"+theme[i].time+"</span>"+
					      	"<button class='layui-btn btn databtn patentFile'>"+
								"文件上传"+
							"</button>"+
							"<button class='layui-btn btn databtn patentProcess'>"+
								"文件预览"+
							"</button>"+
						"</div>"+
				      "</div>"+
				    "</div>"+
				    "<i class='layui-icon layui-timeline-axisl'></i>"+
				  "</li>";
				
				}else if(theme[i].id%2=="0"){/*右侧数据*/
					htmls=htmls+"<li class='layui-timeline-item datali'>"+
				    "<i class='layui-icon layui-timeline-axis'></i>"+
				    "<div class='layui-timeline-content layui-text'>"+
				      "<h3 class='layui-timeline-title'>"+theme[i].title+"</h3>"+
				      "<div class='databor'>"+
					  	"<div>"+
					  	theme[i].description+
				      	"</div>"+
				      	"<div class='btncollr'>"+
					      	"<button class='layui-btn btn databtn patentFile'>"+
								"文件上传"+
							"</button>"+
							"<button class='layui-btn btn databtn patentProcess'>"+
								"文件预览"+
							"</button>"+
							"<span class='datalidatel'>"+theme[i].time+"</span>"+
						"</div>"+
					  "</div>"+
				    "</div>"+
				  "</li>";
				}
			}
			flowtheme.innerHTML=htmls;
		}
	})
	
})