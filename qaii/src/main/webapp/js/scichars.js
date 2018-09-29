//科研成果预览示例图
function circle(boxid,id,color,total,num){//id为canvas的id值,color为基本外圆颜色值,total为圆铺满总量,num为数据量
	var canvas=document.getElementById(id),
	context=canvas.getContext("2d");
	var canvasBox = document.getElementById(boxid).offsetWidth;
	canvas.width = canvasBox*0.8;
	var part=Math.PI*2*num/total-Math.PI/2;
	context.moveTo(canvas.width/2,canvas.height/2);
	context.beginPath();
	context.arc(canvas.width/2,canvas.height/2,canvas.width/2,0,Math.PI*2,false);
	context.strokeStyle="#fff";
	context.stroke();
	context.closePath();
	//外圈绘制
	context.moveTo(canvas.width/2,canvas.height/2);
	context.beginPath();
	context.lineWidth=canvas.width*58/540;
	context.arc(canvas.width/2,canvas.height/2,canvas.width*200/540,0,Math.PI*2,false);
	context.strokeStyle=color;
	context.stroke();
	context.closePath();
	//绘制内圈
	context.moveTo(canvas.width/2,canvas.height/2);
	context.beginPath();
	context.lineWidth=canvas.width*100/540;
	context.arc(canvas.width/2,canvas.height/2,canvas.width*220/540,-Math.PI/2,part,false);/*绘制图形所占比圆弧*/
	context.strokeStyle="#fff";
	context.stroke();
	context.closePath();
	//绘制比例圆
	context.font="bold 30px Arial";
	context.fillStyle = '#fff';
	context.textAlign="center";
	context.textBaseline="middle";
	context.fillText(num,canvas.width/2,canvas.height/2);
}

//政府资助点击事件tab切换
$(document).ready(function(){
  $(".tabbox ul li").click(function(){
    $(this).addClass("active").siblings().removeClass("active");
    var a= $(this).attr("name");
    $("#"+a).siblings().hide();
    $("#"+a).show();
  });
});
//科研成果信息
var myChart = echarts.init(document.getElementById('information'));
var option = {
	    tooltip: {
	        trigger: 'axis'
	    },
	    color: ['#3db4e3','#8fc31f', '#e4007f', '#601986', '#91c7ae','#fff100',  '#ea7542', '#48efef','#ef4566'],
	    legend: {
	        data:['受理专利','授权专利','申请软著','授权软著','受理商标','授权商标','论文总数','著作总数'],
	        textStyle:{    //图例文字的样式
	            color:'#fff',
	            fontSize:12
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    xAxis : [
            {
                type : 'category',
                boundaryGap: false,
    	        data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
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
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: ['#000']
                    }
                },
            }
        ],
	    yAxis : [
            {
            	type: 'value',
            	splitLine: {
                    show: true,
                    lineStyle: {
                        color: ['#3db4e3']
                    }
                },
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
                }
            }
        ],
	    series: [
	        {
	            name:'受理专利',
	            type:'line',
	            data:[120, 132, 96, 163, 69, 230, 210,256,260,109,160,90]
	        },
	        {
	            name:'授权专利',
	            type:'line',
	            data:[100, 82, 85, 134, 83, 230, 210,256,100,109,160,110]
	        },
	        {
	            name:'申请软著',
	            type:'line',
	            data:[89, 102, 75, 104, 93, 230, 210,256,200,109,160,120]
	        },
	        {
	            name:'授权软著',
	            type:'line',
	            data:[150, 100, 61, 124, 80, 230, 210,256,250,109,160,100]
	        },
	        {
	            name:'受理商标',
	            type:'line',
	            data:[160, 65, 101, 114, 90, 230, 210,256,220,109,160,150]
	        },
	        {
	            name:'授权商标',
	            type:'line',
	            data:[110, 93, 121, 84, 60, 85, 132,126,260,239,165,130]
	        },
	        {
	            name:'论文总数',
	            type:'line',
	            data:[190, 58, 131, 134, 61, 230, 210,256,300,109,160,115]
	        },
	        {
	            name:'著作总数',
	            type:'line',
	            data:[125, 96, 160, 134, 98, 230, 210,256,300,109,160,100]
	        }
	        
	    ]
	};


// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

//数据总量
var myChart2 = echarts.init(document.getElementById('totalData'));
var option2 = {
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    color: ['#ea8a27','#7fccd8', '#3db4e3'],
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    legend: {
	        data: ['外观设计专利', '实用新型专利','发明专利'],
	        textStyle:{    //图例文字的样式
	            color:'#fff',
	            fontSize:12
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis:  {
	        type: 'category',
	        data: ['申请','受理','授权','驳回'],
	        axisLabel: {
                textStyle: {
                    color: '#3db4e3',
                    fontSize:12
                },
                lineStyle:{ 
                	show: false,
                	color:'#3db4e3' 
                	/*width:8*/
                }
            },
            splitLine: {
                show: false,
                lineStyle: {
                    color: ['#000']
                }
            },
	    },
	    yAxis: {
	        type: 'value',
	        splitLine: {
                show: true,
                lineStyle: {
                    color: ['#3db4e3']
                }
            },
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
            }
	    },
	    series: [
	        {
	            name: '外观设计专利',
	            type: 'bar',
	            barWidth : 30,//柱图宽度
	            stack: '总量',
	            label: {
	                normal: {
	                    /*show: true,*/
	                    position: 'insideRight'
	                }
	            },
	            data: [320, 302, 301, 334]
	        },
	        {
	            name: '实用新型专利',
	            type: 'bar',
	            stack: '总量',
	            label: {
	                normal: {
	                   /* show: true,*/
	                    position: 'insideRight'
	                }
	            },
	            data: [120, 132, 101, 134]
	        },
	        {
	            name: '发明专利',
	            type: 'bar',
	            stack: '总量',
	            label: {
	                normal: {
	                    /*show: true,*/
	                    position: 'insideRight'
	                }
	            },
	            data: [220, 182, 191, 234]
	        }
	    ]
	};

// 使用刚指定的配置项和数据显示图表。
myChart2.setOption(option2);