// JavaScript Document
/*var num=new Array(32,45,102,62);
numadd(num[0],"t1");
numadd(num[1],"t2");
numadd(num[2],"t3");
numadd(num[3],"t4");
setInterval(function(){/!*系统动态效果*!/
	numadd(num[0],"t1");
	numadd(num[1],"t2");
	numadd(num[2],"t3");
	numadd(num[3],"t4");
},10000);
function numadd(numb,ids){
	let i=0;
	setInterval(function(){
		if(i<numb){
			i=i+1;
			document.getElementById(ids).innerHTML = i;
		}
	},50); 
}*/
let CompanyNums=gettCompanyData();
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
let ServiceNum =gettServiceData();
function gettServiceData(){
    let result=null;
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
//系统显示时间
function getDate(){
	var myDate = new Date();
	var cycyear=myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	var cycmonth=myDate.getMonth();       //获取当前月份(0-11,0代表1月)
	var cycday=myDate.getDate();        //获取当前日(1-31)
	var cychour=myDate.getHours();       //获取当前小时数(0-23)
	var cycmin=myDate.getMinutes();     //获取当前分钟数(0-59)
	var cycsecond=myDate.getSeconds();     //获取当前秒数(0-59)
	document.getElementById("cycyear").innerHTML = cycyear;
	document.getElementById("month").innerHTML = cycmonth+1;
	document.getElementById("cycday").innerHTML = cycday;
	document.getElementById("cychour").innerHTML = cychour;
	document.getElementById("cycmin").innerHTML = cycmin;
	document.getElementById("cycsecond").innerHTML = cycsecond;
}
setInterval("getDate()",1000);
// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
        
            tooltip: {},
            xAxis: {
               data: [new Date(ServiceNum.ServiceYear[6]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[5]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[4]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[3]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[2]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[1]).getFullYear()+"年", new Date(ServiceNum.ServiceYear[0]).getFullYear()+"年"],
			   axisLine: {
				   show: false,
				   textStyle: {
					color: 'rgba(93,113,165,0.3)'
				   }
			   },
			   axisLabel: {
					show: true,
					textStyle: {
						color: '#6c84c1'
					}
				}
            },
            yAxis: {
			   axisLine: {show:false},
			   axisLabel: {
					show: true,
					textStyle: {
						color: '#6c84c1'
					}
				}
			},
            series: [{
                name: '服务企业数量',
                type: 'bar',
               
                data: [ServiceNum.ServiceYearNums[6], ServiceNum.ServiceYearNums[5], ServiceNum.ServiceYearNums[4], ServiceNum.ServiceYearNums[3], ServiceNum.ServiceYearNums[2], ServiceNum.ServiceYearNums[1], ServiceNum.ServiceYearNums[0]],
				itemStyle: {
					normal:{
					  color: function (params){　
						var colorList = [
									['#2078be','#384198'],
									['#f3cc20','#f29216'],
									['#71c5cf','#1e7bc0'],
									['#f29525','#e94925']

								   ];

							  var index=params.dataIndex;
							  if(params.dataIndex >= colorList.length){
									  index=params.dataIndex-colorList.length;
							   }

							  return new echarts.graphic.LinearGradient(0, 0, 0, 1,
							  [
								 {offset: 0, color: colorList[index][0]},
								 {offset: 1, color: colorList[index][1]},
							  ]);
					  }
					},
					emphasis: {
						color: new echarts.graphic.LinearGradient(
							0, 0, 0, 1,
							[
								{offset: 0, color: '#e94a25'},
								{offset: 0.7, color: '#f29325'},
							   /* {offset: 1, color: '#83bff6'}*/
							]
						)
					}
            }
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
// 孵化企业总数
var myChart2 = echarts.init(document.getElementById('company'));

// 指定图表的配置项和数据
var option2 = {
  
    tooltip : {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        }
    },

    /*toolbox: {
        feature: {
            saveAsImage: {}
        }
    },*/
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : [new Date(CompanyNums.CompanyYear[6]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[5]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[4]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[3]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[2]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[1]).getFullYear()+"年",new Date(CompanyNums.CompanyYear[0]).getFullYear()+"年"],
			axisLine: {
				   show: false,
				   textStyle: {
					color: 'rgba(75,107,113,0.9)'
				   }
			   },
		   axisLabel: {
				show: true,
				textStyle: {
					color: '#6c84c1'
				}
			}
        }
    ],
    yAxis : [
        {
            type : 'value',
			axisLine: {show:false},
			   axisLabel: {
					show: true,
					textStyle: {
						color: '#6c84c1'
					}
				}
        }
		
    ],
    series : [
        {
            name:'孵化企业总数',
            type:'line',
			smooth:true,
            stack: '总量',
            areaStyle: {
				normal: {
					color: new echarts.graphic.LinearGradient(
							0, 0, 0, 1,
							[
								{offset: 0, color: '#4b6b71'},
								/*{offset: 0.5, color: '#5d99a3'},*/
								{offset: 1, color: '#070d1a'}
							]
					)
				}
			},
			itemStyle : {  
				normal : {  
					color:'#4b6b71',  
					lineStyle:{  
						color:'#4b6b71'  
					}  
				}  
			},
			data:[CompanyNums.CompanyNums[6],CompanyNums.CompanyNums[5],CompanyNums.CompanyNums[4],CompanyNums.CompanyNums[3],CompanyNums.CompanyNums[2],CompanyNums.CompanyNums[1],CompanyNums.CompanyNums[0]]
        }
        
    ]
};
 myChart2.setOption(option2);
