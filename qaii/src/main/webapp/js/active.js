
//表格动态事件
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

//荣誉奖励

var awardDate=getawardAllData();//awardcollege代表院获奖情况如"awardcollege":[{"awardTime":"2018-11-21","awardLevel":"2","awardUnit":"当时说","awardName":"辅导费"}]；
//awardpersonal代表个人获奖情况如"awardpersonal":[{"awardTime":"2018-11-21","awardLevel":"4","personUnit":null,"awardName":"达到"}]
//awardincubate代表孵化企业获奖情况如："awardincubate":[{"awardTime":"2018-11-21","awardLevel":"2","awardUnit":"当时说","awardName":"辅导费"}]
//赋值时要注意判断当值不存在的时候返回值为null的情况
/*console.log(awardDate)
console.log("huang kun peng"+awardDate.awardincubate[0].awardTime);
console.log("huang kun peng"+awardDate.awardincubate.length);*/
console.log(awardDate);
var arr=awardDate.awardincubate;
var num=6;/*定时器循环*/
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
tablefun("qiyehuojaing");//孵化企业获奖情况初始赋值
$(".nage").click(function(){
    $(this).siblings().removeClass("nageactive");
    $(this).addClass("nageactive");
    var ss=$(this).attr("name");
    tablefun(ss);
});
function tablefun(ss){
    let htmls="";
    let htmltit=""
    if(ss=="yuanhuojiang"){
        arr=awardDate.awardcollege;
        htmltit="<tr><th>获奖时间</th><th>获奖级别</th><th>获奖单位名称</th><th>奖励荣誉名称</th></tr>";
        num=6;
    }else if(ss=="qiyehuojaing"){
        arr=awardDate.awardincubate;
        htmltit="<tr><th>获奖时间</th><th>获奖级别</th><th>获奖企业名称</th><th>奖励荣誉名称</th></tr>";
        num=6;
    }else if (ss=="gerenhuojiang") {
        arr=awardDate.awardpersonal;
        htmltit="<tr><th>获奖时间</th><th>获奖级别</th><th>获奖人员</th><th>奖励荣誉名称</th></tr>";
        num=6;
    }

    if(arr.length>5) {
        for (let i = 0; i < 6; i++) {
            if(i%2==0){
                htmls = "<tr><td>" + arr[i].awardTime + "</td><td>" + arr[i].awardLevel +
                    "</td><td><a title='"+arr[i].awardUnit+"'>" + arr[i].awardUnit + "</a></td><td><a title='"+arr[i].awardName+"'>" + arr[i].awardName + "</a></td></tr>"+htmls;
            }else{
                htmls = "<tr style='background: rgba(115,199,206,0.1)'><td>" + arr[i].awardTime + "</td><td>" + arr[i].awardLevel +
                    "</td><td><a title='"+arr[i].awardUnit+"'>" + arr[i].awardUnit + "</a></td><td><a title='"+arr[i].awardName+"'>" + arr[i].awardName + "</a></td></tr>"+htmls;
            }
        }
    }else{
        console.log("暂无数据！！");
    }
    $('#rewardtable').html(htmltit+htmls);//初始赋六个值
}



var _box =$('#rewardtable');
var _interval=1500; //刷新间隔时间1.5秒
function gdb(){
    if(num>=arr.length){
        num=0;
    }
    if(num%2==0){
        $('#rewardtable tr:first').after("<tr><td>" + arr[num].awardTime + "</td><td>" + arr[num].awardLevel +
            "</td><td><a title='"+ arr[num].awardUnit +"'>" + arr[num].awardUnit + "</a></td><td><a title='"+arr[num].awardName+"'>" + arr[num].awardName + "</a></td></tr>");
        num++;
    }else{
        $('#rewardtable tr:first').after("<tr style='background: rgba(115,199,206,0.1)'><td>" + arr[num].awardTime + "</td><td>" + arr[num].awardLevel +
            "</td><td><a title='"+arr[num].awardUnit+"'>" + arr[num].awardUnit + "</a></td><td><a title='"+arr[num].awardName+"'>" + arr[num].awardName + "</a></td></tr>");
        num++;
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
    $("#addressnull a").attr("href",Industry[0].address);

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
