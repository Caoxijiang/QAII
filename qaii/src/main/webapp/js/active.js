// JavaScript Document
$(".tab").click(function(){
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
})
//荣誉奖励
$(".nage").click(function(){
	$(this).siblings().removeClass("nageactive");
	$(this).addClass("nageactive");
})
//主视图动态添加--千帆计划
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

//千帆计划、高新技术、百千万工程、中小型企业赋值
var totalData=gettotalData();
console.log(totalData)
new Vue({
    el: '#t1',
    data: {
        message: totalData.QianFan//千帆计划入库企业
    }
})

new Vue({
    el: '#t2',
    data: {
        message: totalData.GaoxinJishu//千帆计划入库企业
    }
})

new Vue({
    el: '#t3',
    data: {
        message: totalData.BaiQIan//千帆计划入库企业
    }
})

new Vue({
    el: '#t4',
    data: {
        message: totalData.ZhongXiaoXing//千帆计划入库企业
    }
})


function gettotalData(){
    var result=null;
    $.ajax({
        async:false,
        type:"POST",
        url:"HighLevel.do",
        success:function(data){
            result=data;
        }
    })
    return result;
}

//
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
}
function bodyfun2(){//高新技术企业
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
}
//表格动态事件
var _box =$('#rewardtable');
var _interval=1500; //刷新间隔时间3秒
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
	$(".popup").hide(3000);
	$(".zhezhao").fadeOut(3000);
});
$(".base").on("click",".ball",function(){
	$(".zhezhao").show();
	$(".popup").show(2000);
	
})