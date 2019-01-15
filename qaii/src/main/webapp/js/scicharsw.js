
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
function getscientific(){
	var result=null;
	$.ajax({
		async:false,
		type:"POST",
		url:"scientific.do",
		success:function(data){
			result=data;
		}
	})
	return result;
}
var scientific=getscientific();
var option = {
	    tooltip: {
	        trigger: 'axis'
	    },
	    color: ['#3db4e3','#8fc31f', '#e4007f', '#601986', '#91c7ae','#fff100',  '#ea7542', '#48efef','#ef4566'],
	    /*legend: {
	        data:['受理专利','授权专利','申请软著','授权软著','受理商标','授权商标','论文总数','著作总数'],
	        textStyle:{    //图例文字的样式
	            color:'#fff',
	            fontSize:12
	        }
	    },*/
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
                data: ['2013年','2014年','2015年','2016年','2017年','2018年','2019年'],
    	        /*data: [new Date(scientific.EachMonth[11]).getMonth()+1+'月',new Date(scientific.EachMonth[10]).getMonth()+1+'月',new Date(scientific.EachMonth[9]).getMonth()+1+'月',
    	        	new Date(scientific.EachMonth[8]).getMonth()+1+'月',new Date(scientific.EachMonth[7]).getMonth()+1+'月',new Date(scientific.EachMonth[6]).getMonth()+1+'月',
    	        	new Date(scientific.EachMonth[5]).getMonth()+1+'月',new Date(scientific.EachMonth[4]).getMonth()+1+'月',new Date(scientific.EachMonth[3]).getMonth()+1+'月',
    	        	new Date(scientific.EachMonth[2]).getMonth()+1+'月',new Date(scientific.EachMonth[1]).getMonth()+1+'月',new Date(scientific.EachMonth[0]).getMonth()+1+'月'],*/
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
                smooth:true,
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#3db4e3'},
                                {offset: 1, color: 'rgba(61,180,227,0)'}
                            ]
                        )
                    }
                },
                data:[5,9,12,16,19,20,26]
	          /*  data:[scientific.AgencyPatent[11], scientific.AgencyPatent[10], scientific.AgencyPatent[9],
	            	scientific.AgencyPatent[8], scientific.AgencyPatent[7], scientific.AgencyPatent[6], 
	            	scientific.AgencyPatent[5], scientific.AgencyPatent[4], scientific.AgencyPatent[3],
	            	scientific.AgencyPatent[2], scientific.AgencyPatent[1], scientific.AgencyPatent[0]]*/
	        },
	        {
	            name:'授权专利',
	            type:'line',
                smooth:true,
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: 'rgba(143,195,31,1)'},
                                {offset: 1, color: 'rgba(143,195,31,0)'}
                            ]
                        )
                    }
                },
                data:[1,3,9,12,16,19,20]
	           /* data:[scientific.AuthorizationPatent[11], scientific.AuthorizationPatent[10], scientific.AuthorizationPatent[9],
	            	scientific.AuthorizationPatent[8], scientific.AuthorizationPatent[7], scientific.AuthorizationPatent[6], 
	            	scientific.AuthorizationPatent[5], scientific.AuthorizationPatent[4], scientific.AuthorizationPatent[3],
	            	scientific.AuthorizationPatent[2], scientific.AuthorizationPatent[11], scientific.AuthorizationPatent[0]]*/
	        },
	        {
	            name:'申请软著',
	            type:'line',
                smooth:true,
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: 'rgba(228,0,127,1)'},
                                {offset: 1, color: 'rgba(228,0,127,0)'}
                            ]
                        )
                    }
                },
                data:[12,16,19,20,25,26,35]
	            /*data:[scientific.Applycopyright[11], scientific.Applycopyright[10], scientific.Applycopyright[9],
	            	scientific.Applycopyright[8], scientific.Applycopyright[7], scientific.Applycopyright[6], 
	            	scientific.Applycopyright[5], scientific.Applycopyright[4], scientific.Applycopyright[3],
	            	scientific.Applycopyright[2], scientific.Applycopyright[1], scientific.Applycopyright[0]]*/
	        },
	        {
	            name:'授权软著',
	            type:'line',
                smooth:true,
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: 'rgba(96,25,134,1)'},
                                {offset: 1, color: 'rgba(96,25,134,0)'}
                            ]
                        )
                    }
                },
                data:[16,19,20,26,30,32,38]
	            /*data:[scientific.Authorizationcopyright[11], scientific.Authorizationcopyright[10], scientific.Authorizationcopyright[9],
	            	scientific.Authorizationcopyright[8], scientific.Authorizationcopyright[7], scientific.Authorizationcopyright[6], 
	            	scientific.Authorizationcopyright[5], scientific.Authorizationcopyright[4], scientific.Authorizationcopyright[3],
	            	scientific.Authorizationcopyright[2], scientific.Authorizationcopyright[1], scientific.Authorizationcopyright[0]]*/
	        },
	        {
	            name:'受理商标',
	            type:'line',
                smooth:true,
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: 'rgba(145,199,174,1)'},
                                {offset: 1, color: 'rgba(145,199,174,0)'}
                            ]
                        )
                    }
                },
                data:[8,6,9,15,16,19,20]
	            /*data:[scientific.AgencyTradeMark[11], scientific.AgencyTradeMark[10], scientific.AgencyTradeMark[9],
	            	scientific.AgencyTradeMark[8], scientific.AgencyTradeMark[7], scientific.AgencyTradeMark[6], 
	            	scientific.AgencyTradeMark[5], scientific.AgencyTradeMark[4], scientific.AgencyTradeMark[3],
	            	scientific.AgencyTradeMark[2], scientific.AgencyTradeMark[1], scientific.AgencyTradeMark[0]]*/
	        },
	        {
	            name:'授权商标',
	            type:'line',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: 'rgba(255,241,0,1)'},
                                {offset: 1, color: 'rgba(255,241,0,0)'}
                            ]
                        )
                    }
                },
                smooth:true,
                data:[2,5,6,7,9,10,12]
	            /*data:[scientific.AuthorizationTradeMark[11], scientific.AuthorizationTradeMark[10], scientific.AuthorizationTradeMark[9],
	            	scientific.AuthorizationTradeMark[8], scientific.AuthorizationTradeMark[7], scientific.AuthorizationTradeMark[6], 
	            	scientific.AuthorizationTradeMark[5], scientific.AuthorizationTradeMark[4], scientific.AuthorizationTradeMark[3],
	            	scientific.AuthorizationTradeMark[2], scientific.AuthorizationTradeMark[1], scientific.AuthorizationTradeMark[0]]*/
	        },
	        {
	            name:'论文总数',
	            type:'line',
                smooth:true,
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: 'rgba(234,117,66,1)'},
                                {offset: 1, color: 'rgba(234,117,66,0)'}
                            ]
                        )
                    }
                },
                data:[0,1,3,4,5,6,8]
	            /*data:[scientific.EachMonththesis[11], scientific.EachMonththesis[10], scientific.EachMonththesis[9],
	            	scientific.EachMonththesis[8], scientific.EachMonththesis[7], scientific.EachMonththesis[6], 
	            	scientific.EachMonththesis[5], scientific.EachMonththesis[4], scientific.EachMonththesis[3],
	            	scientific.EachMonththesis[2], scientific.EachMonththesis[1], scientific.EachMonththesis[0]]*/
	        },
	        {
	            name:'著作总数',
	            type:'line',
                smooth:true,
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: 'rgba(72,239,239,1)'},
                                {offset: 1, color: 'rgba(72,239,239,0)'}
                            ]
                        )
                    }
                },
                data:[4,6,7,8,9,10,13]
	            /*data:[scientific.EachMonthwork[11], scientific.EachMonthwork[10], scientific.EachMonthwork[9],
	            	scientific.EachMonthwork[8], scientific.EachMonthwork[7], scientific.EachMonthwork[6], 
	            	scientific.EachMonthwork[5], scientific.EachMonthwork[4], scientific.EachMonthwork[3],
	            	scientific.EachMonthwork[2], scientific.EachMonthwork[1], scientific.EachMonthwork[0]]*/
	        }
	        
	    ]
	};


// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

//数据总量
var myChart2 = echarts.init(document.getElementById('totalData'));
function gettotalData(){
	var result=null;
	$.ajax({
		async:false,
		type:"POST",
		url:"DataTotal.do",
		success:function(data){
			result=data;
		}
	})
	return result;
}
var totalData=gettotalData();
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
	    /*legend: {
	        data: ['外观设计专利', '实用新型专利','发明专利'],
	        textStyle:{    //图例文字的样式
	            color:'#fff',
	            fontSize:12
	        }
	    },*/
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis:  {
	        type: 'category',
	        data: ['申请','受理','授权'],
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
                barGap: 0,
	            label: {
	                normal: {
	                    /*show: true,*/
	                    position: 'insideRight'
	                }
	            },
	           /* data: [totalData.apply[0], totalData.agency[0], totalData.authorization[0], totalData.reject[0]]*/
                data: [5,15,20]
	        },
	        {
	            name: '实用新型专利',
	            type: 'bar',
                barGap: 0,
	            label: {
	                normal: {
	                   /* show: true,*/
	                    position: 'insideRight'
	                }
	            },
	            /*data: [totalData.apply[1], totalData.agency[1], totalData.authorization[1], totalData.reject[1]]*/
                data: [8,13,19]
	        },
	        {
	            name: '发明专利',
	            type: 'bar',
                barGap: 0,
	            label: {
	                normal: {
	                    /*show: true,*/
	                    position: 'insideRight'
	                }
	            },
	           /* data: [totalData.apply[2], totalData.agency[2], totalData.authorization[2], totalData.reject[2]]*/
                data: [10,15,23]
	        }
	    ]
	};

// 使用刚指定的配置项和数据显示图表。
myChart2.setOption(option2);