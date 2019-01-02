// JavaScript Document
/*$(".tab").click(function(){
	$(this).siblings().removeClass("tabac");
	$(this).addClass("tabac");
	var ss=$(this).attr("name");
	switch(ss)
	{
	case "bodybox1":
	  bodyfun1();
	  break;
	case "bodybox2":
	   bodyfun2();
	  break;
	case "bodybox3":
	   bodyfun3();
	  break;
	case "bodybox4":
	   bodyfun4();
	  break;
	default:
	   bodyfun5();
	}
})*/

/*//主视图动态添加--千帆计划
var cirnum=6;
var circlehtml="<div class='pan'></div>";
for(var i=0;i<cirnum;i++){
circlehtml=circlehtml+
	'<div class="ball_base u_p3d"'+
	' style="-webkit-transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);">'+
	'<div class="ball" '+
	'style="transform: rotateY(10deg) rotateZ(5deg);-webkit-animation: cir'+(i+1)+' 30s linear 0s infinite;animation: cir'+(i+1)+' 30s linear 0s infinite;background-image: url(image/ball_around1.png);">青岛智铭智能科技有限公司</div>'+
			'</div>';
}*/
/*$(".base").html(circlehtml);

function bodyfun1(){//千帆计划入库企业
	var cirnum=6;
	var circlehtml="<div class='pan'></div>";
	for(var i=0;i<cirnum;i++){
	circlehtml=circlehtml+
		'<div class="ball_base u_p3d"'+
		' style="-webkit-transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);">'+
		'<div class="ball" '+
		'style="transform: rotateY(10deg) rotateZ(5deg);-webkit-animation: cir'+(i+1)+' 30s linear 0s infinite;animation: cir'+(i+1)+' 30s linear 0s infinite;background-image: url(image/ball_around1.png);">青岛智铭智能科技有限公司</div>'+
				'</div>';
	}
	$(".base").html(circlehtml);
}*/
/*function bodyfun2(){//高新技术企业
	var cirnum=6;
	var circlehtml="<div class='pan'></div>";
	for(var i=0;i<cirnum;i++){
	circlehtml=circlehtml+
		'<div class="ball_base u_p3d"'+
		' style="-webkit-transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);">'+
		'<div class="ball" '+
		'style="transform: rotateY(10deg) rotateZ(5deg);-webkit-animation: cir'+(i+1)+' 30s linear 0s infinite;animation: cir'+(i+1)+' 30s linear 0s infinite;background-image: url(image/ball_around2.png);">青岛智铭智能科技有限公司</div>'+
				'</div>';
	}
	$(".base").html(circlehtml);
}
function bodyfun3(){//培育百千万工程企业
	var cirnum=6;
	var circlehtml="<div class='pan'></div>";
	for(var i=0;i<cirnum;i++){
	circlehtml=circlehtml+
		'<div class="ball_base u_p3d"'+
		' style="-webkit-transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);">'+
		'<div class="ball" '+
		'style="transform: rotateY(10deg) rotateZ(5deg);-webkit-animation: cir'+(i+1)+' 30s linear 0s infinite;animation: cir'+(i+1)+' 30s linear 0s infinite;background-image: url(image/ball_around3.png);">青岛智铭智能科技有限公司</div>'+
				'</div>';
	}
	$(".base").html(circlehtml);
}
function bodyfun4(){//科技型中小企业
	var cirnum=6;
	var circlehtml="<div class='pan'></div>";
	for(var i=0;i<cirnum;i++){
	circlehtml=circlehtml+
		'<div class="ball_base u_p3d"'+
		' style="-webkit-transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);transform: rotateX(-90deg) rotateY('+(360/6)*i+'deg) translateY(-70px);">'+
		'<div class="ball" '+
		'style="transform: rotateY(10deg) rotateZ(5deg);-webkit-animation: cir'+(i+1)+' 30s linear 0s infinite;animation: cir'+(i+1)+' 30s linear 0s infinite;background-image: url(image/ball_around4.png);">青岛智铭智能科技有限公司</div>'+
				'</div>';
	}
	$(".base").html(circlehtml);
}*/
//表格动态事件
//荣誉奖励
tablefun("qiyehuojaing");//孵化企业获奖情况初始赋值

$(".nage").click(function(){
    $(this).siblings().removeClass("nageactive");
    $(this).addClass("nageactive");
    var ss=$(this).attr("name");
    tablefun(ss);
});
	function tablefun(ss){
		let htmls="";
		if(ss=="yuanhuojiang"){
            htmls="<tr><th>获奖时间</th><th>获奖级别</th><th>获奖单位名称</th><th>奖励荣誉名称</th></tr>";
		}else if(ss=="qiyehuojaing"){
            htmls="<tr><th>获奖时间</th><th>获奖级别</th><th>获奖企业名称</th><th>奖励荣誉名称</th></tr>";
		}else if (ss=="gerenhuojiang") {
            htmls="<tr><th>获奖时间</th><th>获奖级别</th><th>个人获奖</th><th>奖励荣誉名称</th></tr>";
		}
		htmls=htmls+"<tr><td>2018-12-13</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>"+
            "<tr style='background: rgba(115,199,206,0.1)'><td>2018-12-13</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>"+
            "<tr><td>2018-12-13</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>"+
            "<tr style='background: rgba(115,199,206,0.1)'><td>2018-12-13</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>"+
            "<tr><td>2018-12-13</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>"+
            "<tr style='background: rgba(115,199,206,0.1)'><td>2018-12-13</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>";
        $('#rewardtable').html(htmls);//初始赋六个值
	}



var _box =$('#rewardtable');
var _interval=1500, //刷新间隔时间3秒
i=2;
function gdb(){
    if(i%2==0){
        $('#rewardtable tr:first').after("<tr style='background: rgba(115,199,206,0.1)'><td>2018-12-"+Math.floor(Math.random()*10+1)+"</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>");
        i++;
    }else{
        $('#rewardtable tr:first').after("<tr><td>2018-12-"+Math.floor(Math.random()*10+1)+"</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>");
        i++;
    }
    var _first=$('#rewardtable tr:first').next();
    _first.animate({height: '+30px'}, "slow");
    var _last=$('#rewardtable tr:last');
    _last.remove();
    setTimeout(function(){
        gdb();
    },_interval);
};
gdb();

//点击关闭弹窗
$(".close").click(function(){
	$(".popup").hide(1000);
	$(".zhezhao").fadeOut(1000);
});
$(".bodybox1").on("click",".ball",function(){
	$(".zhezhao").show();
	$(".popup").show(2000);

})
$(".bodybox1").on("click",".balloutsed",function(){
    $(".zhezhao").show();
    $(".popup").show(2000);

})

//弹窗赋值
$("#mingcheng").html("青岛智能智能科技有限公司");
$("#shijian").html("2018-12-20");
$("#zhusuo").html("山东省青岛市高新技术开发区");
$("#ziben").html("2000万");
$("#leixing").html("高新技术产业开发");
$("#faren").html("战德成");
$("#xindaima").html("9137702223214545569");