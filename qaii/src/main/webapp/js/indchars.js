//荣誉奖励点击事件tab切换
$(document).ready(function(){
  $(".tabbox ul li").click(function(){
    $(this).addClass("active").siblings().removeClass("active");
    var a= $(this).attr("name");
    $("#"+a).siblings().hide();
    $("#"+a).show();
  });
});
//四个综合信息赋值**kun**
new Vue({
  el: '#industria1',
  data: {
    message: '100'//千帆计划入库企业
  }
})
new Vue({
  el: '#industria2',
  data: {
    message: '102'//高新技术企业
  }
})
new Vue({
  el: '#industria3',
  data: {
    message: '103'//入选青岛市科技型企业培育百万工程计划
  }
})
new Vue({
  el: '#industria4',
  data: {
    message: '104'//科技型中小企业
  }
})
//服务企业
var myChart = echarts.init(document.getElementById('servcefirm'));
var option = {
	 xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['2018年', '2018年', '2018年', '2018年', '2018年', '2018年', '2018年'],//服务企业总数x轴日期**kun**
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
	        data: [820, 932, 901, 934, 1290, 1330, 1320],//服务企业总数 各项对应的数值**kun**
	        type: 'line',
	        areaStyle: {},
	        color:["rgba(3,110,184,0.4)"],
	        smooth: true
	    }]
};
myChart.setOption(option);
//孵化企业总数
var myChart2 = echarts.init(document.getElementById('incubating'));
var option2 = {
	    toolbox: {
	        feature: {
	            saveAsImage: {show: true}
	        }
	    },
	    
	    xAxis:{
	            type: 'category',
	            data: ['2018年','2018年','2018年','2018年','2018年','2018年','2018年','2018年'],//孵化企业总数x轴日期**kun**
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
	            data:[12,13,16,19,20,21,35,20]//孵化企业总数 各项对应的数值**kun** 与下面注释数值一致
	        },
	        {
	            name:'孵化企业总数（折）',
	            type:'line',
	            data:[12,13,16,19,20,21,35,20],//孵化企业总数 各项对应的数值**kun** 与上面注释数值一致
	            color:["rgba(3,110,184,0.4)"],
	        }
	        
	        
	    ]
	};
myChart2.setOption(option2);
//荣誉奖励tab切换表格生成**kun**
/*院获奖情况*/
var html1="<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖单位名称</td><td>奖励荣誉名称</td></tr>"+//院获奖第一行 逐行替换里面的文字内容
"<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖单位名称</td><td>奖励荣誉名称</td></tr>"+//院获奖第二行
"<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖单位名称</td><td>奖励荣誉名称</td></tr>";//院获奖第三行
$("#govTable1").append(html1);
/*孵化企业获奖情况*/
var html2="<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖企业名称</td><td>奖励荣誉名称</td></tr>"+//院获奖第一行 逐行替换里面的文字内容
"<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖企业名称</td><td>奖励荣誉名称</td></tr>"+//院获奖第二行
"<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖企业名称</td><td>奖励荣誉名称</td></tr>";//院获奖第三行
$("#govTable2").append(html2);
/*个人获奖情况*/
var html3="<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖人员名称</td><td>奖励荣誉名称</td></tr>"+//院获奖第一行 逐行替换里面的文字内容
"<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖人员名称</td><td>奖励荣誉名称</td></tr>"+//院获奖第二行
"<tr><td>序号</td><td>获奖时间</td><td>获奖级别</td><td>获奖人员名称</td><td>奖励荣誉名称</td></tr>";//院获奖第三行
$("#govTable3").append(html3);