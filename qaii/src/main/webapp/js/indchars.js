//荣誉奖励点击事件tab切换
$(document).ready(function(){
  $(".tabbox ul li").click(function(){
    $(this).addClass("active").siblings().removeClass("active");
    var a= $(this).attr("name");
    $("#"+a).siblings().hide();
    $("#"+a).show();
  });
});
var totalData=gettotalData();
//四个综合信息赋值**kun**
new Vue({
  el: '#industria1',
  data: {
    message: totalData.QianFan//千帆计划入库企业
  }
})
new Vue({
  el: '#industria2',
  data: {
    message:totalData.GaoxinJishu//高新技术企业
  }
})
new Vue({
  el: '#industria3',
  data: {
    message: totalData.BaiQIan//入选青岛市科技型企业培育百万工程计划
  }
})
new Vue({
  el: '#industria4',
  data: {
    message: totalData.ZhongXiaoXing//科技型中小企业
  }
})
//服务企业
var myChart = echarts.init(document.getElementById('servcefirm'));

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

function gettServiceData(){
    var result=null;
    $.ajax({
        async:false,
        type:"POST",
        url:"servercm.do",
        success:function(data){
            result=data;
        }
    })
    return result;
}

function gettCompanyData(){
    var result=null;
    $.ajax({
        async:false,
        type:"POST",
        url:"hatchit.do",
        success:function(data){
            result=data;
        }
    })
    return result;
}

function gettAwardData(){
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
var Award = gettAwardData();
/*学院获奖情况*/
if (Award.awardcollege[0]==null||Award.awardcollege[0]=="") {
    Colleageawardid="";
    ColleageawardTime="";
    ColleageawardLevel="";
    ColleageawardUnit="";
    ColleageawardName="";
}else{
    var Colleageawardid=Award.awardcollege[0].id;
    var ColleageawardTime=new Date(Award.awardcollege[0].awardTime).toLocaleDateString();
    var ColleageawardLevel=Award.awardcollege[0].awardLevel;
    var ColleageawardUnit=Award.awardcollege[0].awardUnit;
    var ColleageawardName=Award.awardcollege[0].awardName;
}

if (Award.awardcollege[1]==null||Award.awardcollege[1]=="") {
    Colleageawardid1="";
    ColleageawardTime1="";
    ColleageawardLevel1="";
    ColleageawardUnit1="";
    ColleageawardName1="";
}else{
    var Colleageawardid1=Award.awardcollege[1].id;
    var ColleageawardTime1=new Date(Award.awardcollege[1].awardTime).toLocaleDateString();
    var ColleageawardLevel1=Award.awardcollege[1].awardLevel;
    var ColleageawardUnit1=Award.awardcollege[1].awardUnit;
    var ColleageawardName1=Award.awardcollege[1].awardName;
}

if (Award.awardcollege[2]==null||Award.awardcollege[2]=="") {
    Colleageawardid2="";
    ColleageawardTime2="";
    ColleageawardLevel2="";
    ColleageawardUnit2="";
    ColleageawardName2="";
}else{
    var Colleageawardid2=Award.awardcollege[2].id;
    var ColleageawardTime2=new Date(Award.awardcollege[2].awardTime).toLocaleDateString();
    var ColleageawardLevel2=Award.awardcollege[2].awardLevel;
    var ColleageawardUnit2=Award.awardcollege[2].awardUnit;
    var ColleageawardName2=Award.awardcollege[2].awardName;
}
/*孵化企业获奖情况*/
if(Award.awardincubate[0]==null||Award.awardincubate[0]==""){
    incubateawardid="";
    incubateawardTime="";
    incubateawardLevel="";
    incubateawardUnit="";
    incubateawardName="";
}else{
    var incubateawardid=Award.awardincubate[0].id;
    var incubateawardTime=new Date(Award.awardincubate[0].awardTime).toLocaleDateString();
    var incubateawardLevel=Award.awardincubate[0].awardLevel;
    var incubateawardUnit=Award.awardincubate[0].awardUnit;
    var incubateawardName=Award.awardincubate[0].awardName;
}

if(Award.awardincubate[1]==null||Award.awardincubate[1]==""){
    incubateawardid1="";
    incubateawardTime1="";
    incubateawardLevel1="";
    incubateawardUnit1="";
    incubateawardName1="";
}else{
    var incubateawardid1=Award.awardincubate[1].id;
    var incubateawardTime1=new Date(Award.awardincubate[1].awardTime).toLocaleDateString();
    var incubateawardLevel1=Award.awardincubate[1].awardLevel;
    var incubateawardUnit1=Award.awardincubate[1].awardUnit;
    var incubateawardName1=Award.awardincubate[1].awardName;
}

if(Award.awardincubate[2]==null||Award.awardincubate[2]==""){
    incubateawardid2="";
    incubateawardTime2="";
    incubateawardLevel2="";
    incubateawardUnit2="";
    incubateawardName2="";
}else{
    var incubateawardid2=Award.awardincubate[2].id;
    var incubateawardTime2=new Date(Award.awardincubate[2].awardTime).toLocaleDateString();
    var incubateawardLevel2=Award.awardincubate[2].awardLevel;
    var incubateawardUnit2=Award.awardincubate[2].awardUnit;
    var incubateawardName2=Award.awardincubate[2].awardName;
}
/*个人获奖情况*/
if (Award.awardpersonal[0]==null||Award.awardpersonal[0]=="") {
    Personalawardid="";
    PersonalawardTime="";
    PersonalawardLevel="";
    PersonalpersonName="";
    PersonalawardName="";
}else {
    var Personalawardid=Award.awardpersonal[0].id;
    var PersonalawardTime=new Date(Award.awardpersonal[0].awardTime).toLocaleDateString();
    var PersonalawardLevel=Award.awardpersonal[0].awardLevel;
    var PersonalpersonName=Award.awardpersonal[0].personName;
    var PersonalawardName=Award.awardpersonal[0].awardName;
}

if (Award.awardpersonal[1]==null||Award.awardpersonal[1]=="") {
    Personalawardid1="";
    PersonalawardTime1="";
    PersonalawardLevel1="";
    PersonalpersonName1="";
    PersonalawardName1="";
}else {
    var Personalawardid1=Award.awardpersonal[1].id;
    var PersonalawardTime1=new Date(Award.awardpersonal[1].awardTime).toLocaleDateString();
    var PersonalawardLevel1=Award.awardpersonal[1].awardLevel;
    var PersonalpersonName1=Award.awardpersonal[1].personName;
    var PersonalawardName1=Award.awardpersonal[1].awardName;
}

if (Award.awardpersonal[2]==null||Award.awardpersonal[2]=="") {
    Personalawardid2="";
    PersonalawardTime2="";
    PersonalawardLevel2="";
    PersonalpersonName2="";
    PersonalawardName2="";
}else {
    var Personalawardid2=Award.awardpersonal[2].id;
    var PersonalawardTime2=new Date(Award.awardpersonal[2].awardTime).toLocaleDateString();
    var PersonalawardLevel2=Award.awardpersonal[2].awardLevel;
    var PersonalpersonName2=Award.awardpersonal[2].personName;
    var PersonalawardName2=Award.awardpersonal[2].awardName;
}
console.log(111);
var ServiceNum =gettServiceData();
var option = {
	 xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: [new Date(ServiceNum.ServiceYear[6]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[5]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[4]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[3]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[2]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[1]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[0]).getFullYear()+"年"],//服务企业总数x轴日期**kun**
	        axisLabel: {
                show: true,
                textStyle: {
                    color: '#3db4e3',
                    fontSize:12
                },
                lineStyle:{ 
                	color:'#3db4e3' 
                	/*width:8*/
                }
            },
            splitLine: {/*修改图标辅助线样式*/
                show: false,/*不显示X轴辅助线*/
                lineStyle: { /*设置图标样式*/
                    color: ['#000']
                }
            }
	    },
	    yAxis: {
	        type: 'value',
	        axisLabel: {
                show: true,
                textStyle: {
                    color: '#3db4e3',
                    fontSize:12
                },
                lineStyle:{ 
                	color:'#3db4e3' 
                }
            },
            splitLine: {/*修改图标辅助线样式*/
               /* show: false,不显示X轴辅助线*/
                lineStyle: { /*设置图标样式*/
                    color: ['rgba(61,180,227,0.3)']
                }
            }
	    },
	    series: [{
	        data: [ServiceNum.ServiceYearNums[6], ServiceNum.ServiceYearNums[5], ServiceNum.ServiceYearNums[4], ServiceNum.ServiceYearNums[3], ServiceNum.ServiceYearNums[2], ServiceNum.ServiceYearNums[1], ServiceNum.ServiceYearNums[0]],//服务企业总数 各项对应的数值**kun**
	        type: 'line',
	        areaStyle: {},
	        color:["rgba(3,110,184,0.4)"],
	        smooth: true
	    }]
};
myChart.setOption(option);
//孵化企业总数
var CompanyNums=gettCompanyData();
var myChart2 = echarts.init(document.getElementById('incubating'));
var option2 = {
	    toolbox: {
	        feature: {
	            saveAsImage: {show: true}
	        }
	    },
	    
	    xAxis:{
	            type: 'category',
	            data: [new Date(CompanyNums.CompanyYear[6]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[5]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[4]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[3]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[2]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[1]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[0]).getFullYear()+"年"],//孵化企业总数x轴日期**kun**
	            axisPointer: {
	                type: 'shadow'
	            },
	            axisLabel: {
	                show: true,
	                textStyle: {
	                    color: '#3db4e3',
	                    fontSize:12
	                },
	                lineStyle:{ 
	                	color:'#3db4e3' 
	                }
	            },
	    },
	    yAxis: {
	    	axisLabel: {
                show: true,
                textStyle: {
                    color: '#3db4e3',
                    fontSize:12
                },
                lineStyle:{ 
                	color:'#3db4e3' 
                }
            }
	    },
	    series: [
	        {
	            name:'孵化企业总数',
	            type:'bar',
	            itemStyle: {
	                normal: {
	                    // 定制显示（按顺序）
	                    color: function(params) { 
	                        var colorList = ['#036eb8','#31a4b1','#3c99b6','#2079a8','#165489', '#164f6f','#036eb8','#31a4b1']; 
	                        return colorList[params.dataIndex] 
	                    }
	                },
	            },
	            data:[CompanyNums.CompanyNums[6],CompanyNums.CompanyNums[5],CompanyNums.CompanyNums[4],CompanyNums.CompanyNums[3],CompanyNums.CompanyNums[2],CompanyNums.CompanyNums[1],CompanyNums.CompanyNums[0]]//孵化企业总数 各项对应的数值**kun** 与下面注释数值一致
	        },
	        {
	            name:'孵化企业总数（折）',
	            type:'line',
	            data:[CompanyNums.CompanyNums[6],CompanyNums.CompanyNums[5],CompanyNums.CompanyNums[4],CompanyNums.CompanyNums[3],CompanyNums.CompanyNums[2],CompanyNums.CompanyNums[1],CompanyNums.CompanyNums[0]],//孵化企业总数 各项对应的数值**kun** 与上面注释数值一致
	            color:["rgba(3,110,184,0.4)"],
	        }
	        
	        
	    ]
	};
myChart2.setOption(option2);
//荣誉奖励tab切换表格生成**kun**
/*院获奖情况*/
var html1="<tr><td>"+Colleageawardid+"</td><td>"+ColleageawardTime+"</td><td>"+ColleageawardLevel+"</td><td>"+ColleageawardUnit+"</td><td>"+ColleageawardName+"</td></tr>"+//院获奖第一行 逐行替换里面的文字内容
"<tr><td>"+Colleageawardid1+"</td><td>"+ColleageawardTime1+"</td><td>"+ColleageawardLevel1+"</td><td>"+ColleageawardUnit1+"</td><td>"+ColleageawardName1+"</td></tr>"+//院获奖第二行
"<tr><td>"+Colleageawardid2+"</td><td>"+ColleageawardTime2+"</td><td>"+ColleageawardLevel2+"</td><td>"+ColleageawardUnit2+"</td><td>"+ColleageawardName2+"</td></tr>";//院获奖第三行
$("#govTable1").append(html1);
/*孵化企业获奖情况*/
var html2="<tr><td>"+incubateawardid+"</td><td>"+incubateawardTime+"</td><td>"+incubateawardLevel+"</td><td>"+incubateawardUnit+"</td><td>"+incubateawardName+"</td></tr>"+//院获奖第一行 逐行替换里面的文字内容
"<tr><td>"+incubateawardid1+"</td><td>"+incubateawardTime1+"</td><td>"+incubateawardLevel1+"</td><td>"+incubateawardUnit1+"</td><td>"+incubateawardName1+"</td></tr>"+//院获奖第二行
"<tr><td>"+incubateawardid2+"</td><td>"+incubateawardTime2+"</td><td>"+incubateawardLevel2+"</td><td>"+incubateawardUnit2+"</td><td>"+incubateawardName2+"</td></tr>";//院获奖第三行
$("#govTable2").append(html2);
/*个人获奖情况*/
var html3="<tr><td>"+Personalawardid+"</td><td>"+PersonalawardTime+"</td><td>"+PersonalawardLevel+"</td><td>"+PersonalpersonName+"</td><td>"+PersonalawardName+"</td></tr>"+//院获奖第一行 逐行替换里面的文字内容
"<tr><td>"+Personalawardid1+"</td><td>"+PersonalawardTime1+"</td><td>"+PersonalawardLevel1+"</td><td>"+PersonalpersonName1+"</td><td>"+PersonalawardName1+"</td></tr>"+//院获奖第二行
"<tr><td>"+Personalawardid2+"</td><td>"+PersonalawardTime2+"</td><td>"+PersonalawardLevel2+"</td><td>"+PersonalpersonName2+"</td><td>"+PersonalawardName2+"</td></tr>";//院获奖第三行
$("#govTable3").append(html3);
