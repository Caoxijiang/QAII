//荣誉奖励点击事件tab切换
$(document).ready(function(){
  $(".tabbox ul li").click(function(){
    $(this).addClass("active").siblings().removeClass("active");
    var a= $(this).attr("name");
    $("#"+a).siblings().hide();
    $("#"+a).show();
  });
});
//服务企业
var myChart = echarts.init(document.getElementById('servcefirm'));
var option = {
    tooltip: {},
    legend: {
        data:['服务企业总数']
    },
    xAxis: {
        data: ["2015年","2016年","2017年","2018年"]
    },
    yAxis: {},
    series: [{
        name: '服务企业总数',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
    }]
};
myChart.setOption(option);
//孵化企业
var myChart2 = echarts.init(document.getElementById('incubating'));
var option2 = {
	    toolbox: {
	        feature: {
	            saveAsImage: {show: true}
	        }
	    },
	    legend: {
	        data:['孵化企业总数','孵化企业总数（折）']
	    },
	    xAxis: [
	        {
	            type: 'category',
	            data: ['2018年','2018年','2018年','2018年','2018年','2018年','2018年','2018年'],
	            axisPointer: {
	                type: 'shadow'
	            }
	        }
	    ],
	    yAxis: {},
	    series: [
	        {
	            name:'孵化企业总数',
	            type:'bar',
	            data:[12,13,16,19,20,21,35,20]
	        },
	        {
	            name:'孵化企业总数（折）',
	            type:'line',
	            data:[12,13,16,19,20,21,35,20]
	        }
	        
	        
	    ]
	};
myChart2.setOption(option2);