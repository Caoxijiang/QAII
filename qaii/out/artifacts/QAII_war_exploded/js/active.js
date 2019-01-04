
//表格动态事件
//荣誉奖励
tablefun("qiyehuojaing");//孵化企业获奖情况初始赋值
let awardDate=getawardAllData();//awardcollege代表院获奖情况如"awardcollege":[{"awardTime":"2018-11-21","awardLevel":"2","awardUnit":"当时说","awardName":"辅导费"}]；
//awardpersonal代表个人获奖情况如"awardpersonal":[{"awardTime":"2018-11-21","awardLevel":"4","personUnit":null,"awardName":"达到"}]
//awardincubate代表孵化企业获奖情况如："awardincubate":[{"awardTime":"2018-11-21","awardLevel":"2","awardUnit":"当时说","awardName":"辅导费"}]
//赋值时要注意判断当值不存在的时候返回值为null的情况
console.log("huang kun peng");
function getawardAllData(){
    var result=null;
    $.ajax({
        async:false,
        type:"POST",
        url:"Award.do",
        success:function(data){
            result=data;
        }
    })
    return result;
}
let totalData=gettotalData();
new Vue({
    el: '#t1',
    data: {
        message: totalData.QianFan//千帆计划入库企业
    }
})
new Vue({
    el: '#t2',
    data: {
        message: totalData.GaoxinJishu//高新技术企业
    }
})
new Vue({
    el: '#t3',
    data: {
        message: totalData.BaiQIan//培育"百千万"工程企业
    }
})
new Vue({
    el: '#t4',
    data: {
        message: totalData.ZhongXiaoXing//科技型中小企业
    }
})
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
var _interval=1500, //刷新间隔时间1.5秒
i=2;
function gdb(){
    if(i%2==0){
        $('#rewardtable tr:first').after("<tr style='background: rgba(115,199,206,0.1)'><td>2018-12-"+Math.floor(Math.random()*10+1)+"</td><td>国家级</td><td>青岛智铭智能科技有限公司</td><td>高新技术企业</td></tr>");
        i++;
    }else{
        //Math.floor(Math.random()*10+1),所得到的的是1-10之间的随机数，每次刷新都不同
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
gdb();

//点击关闭弹窗
$(".close").click(function(){
	$(".popup").hide(1000);
	$(".zhezhao").fadeOut(1000);
});
$(".bodybox1").on("click",".ball",function(){
    //内圈
	$(".zhezhao").show();
	$(".popup").show(2000);
	let IndustryName=$(this).attr("id");
	//孵化企业内圈接口数据
    console.log(IndustryName)
    function getIndustryData(){
        var result=null;
        $.ajax({
            async:false,
            type:"POST",
            data: {"IndustryName": IndustryName},
            url:"IndustryInner.do",
            success:function(data){
                result=data;
            }
        })
        return result;
    }
    let Industry=getIndustryData();
    console.log(Industry)
    console.log(Industry[0].companyName);
    //弹窗赋值
    $("#mingcheng").html(Industry[0].companyName);
    $("#shijian").html(Industry[0].establishTime);
    $("#zhusuo").html(Industry[0].companyLocation);
    $("#ziben").html(Industry[0].registeredCapital);
    $("#leixing").html(Industry[0].companyType);
    $("#faren").html(Industry[0].legalRepresentative);
    $("#xindaima").html(Industry[0].creditCode);

})
$(".bodybox1").on("click",".balloutsed",function(){
    //外圈
    $(".zhezhao").show();
    $(".popup").show(2000);
    let IndustryName1=$(this).attr("id");
    function getIndustryDatas(){
        var result=null;
        $.ajax({
            async:false,
            type:"POST",
            data: {"IndustryName": IndustryName1},
            url:"IndustryInner.do",
            success:function(data){
                result=data;
            }
        })
        return result;
    }
//孵化企业外圈接口数据
    var Industry=getIndustryDatas();
    //弹窗赋值
    $("#mingcheng").html(Industry[0].companyName);
    $("#shijian").html(Industry[0].establishTime);
    $("#zhusuo").html(Industry[0].companyLocation);
    $("#ziben").html(Industry[0].registeredCapital);
    $("#leixing").html(Industry[0].companyType);
    $("#faren").html(Industry[0].legalRepresentative);
    $("#xindaima").html(Industry[0].creditCode);

})

