// JavaScript Document
// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
//			title: {
//				text: '折线图堆叠'
//			},
			tooltip: {
				trigger: 'axis'
			},
			legend: {
				data:['新入职','离职','净增长','院总人数'],
				textStyle:{//图例文字的样式
					color:'#fff',
					fontSize:16
				}
			},
			color:['#64ad30','#1576bd','#f2934a','#c6345a'],
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
			xAxis: {
				type: 'category',
				boundaryGap: false,
				axisLabel: {        
					show: true,
					textStyle: {
						color: '#fff',
						fontSize:'14'
					}
				},
				data: ['1','2','3','4','5','6','7','8','9','10','11','12']
			},
			yAxis: {
				type: 'value',
				axisLabel: {        
					show: true,
					textStyle: {
						color: '#fff',
						fontSize:'14'
					}
				},
			},
			series: [
				{
					name:'新入职',
					type:'line',
					stack: '总量',
					data:[12, 13, 18, 14, 9, 23, 21,16,19,20,29,18]
				},
				{
					name:'离职',
					type:'line',
					stack: '总量',
					data:[22, 18, 19, 24, 29, 3, 10,8,10,2,1,3]
				},
				{
					name:'净增长',
					type:'line',
					stack: '总量',
					data:[15, 22, 20, 14, 19, 33, 11,16,23,16,12,19]
				},
				{
					name:'院总人数',
					type:'line',
					stack: '总量',
					data:[32, 32, 31, 34, 30, 35, 32,21,29,28,25,39]
				}
			]
		};



        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

//人才队伍柱形图
 // 基于准备好的dom，初始化echarts实例
        var myChartbar = echarts.init(document.getElementById('mainbar'));

        // 指定图表的配置项和数据
        var optionbar = {
			tooltip: {
				trigger: 'axis'
			},
			toolbox: {
				feature: {
					saveAsImage: {}
				}
			},
			
			legend: {
				data:['孵化公司人数','研究院人数','人员总数'],
				textStyle:{//图例文字的样式
					color:'#fff',
					fontSize:16
				}
			},
			color:['#c6345a','#64ad30','#f2934a'],
			tooltip: {},
			dataset: {
				dimensions: ['product', '孵化公司人数', '研究院人数','人员总数'],
				source: [
					{product: '2011', '孵化公司人数': 50, '研究院人数': 105, '人员总数': 135},
					{product: '2012', '孵化公司人数': 63, '研究院人数': 100, '人员总数': 125},
					{product: '2013', '孵化公司人数': 53, '研究院人数': 156, '人员总数': 152},
					{product: '2014', '孵化公司人数': 61, '研究院人数': 150, '人员总数': 149},
					{product: '2015', '孵化公司人数': 76, '研究院人数': 125, '人员总数': 163},
					{product: '2016', '孵化公司人数': 65, '研究院人数': 120, '人员总数': 156},
					{product: '2017', '孵化公司人数': 67, '研究院人数': 110, '人员总数': 164},
					{product: '2018', '孵化公司人数': 56, '研究院人数': 135, '人员总数': 157}				
				]
			},
			xAxis: {
				type: 'category',
				textStyle: {
					color: '#fff',
					fontSize:'14'
				}
			},
			yAxis: {
				textStyle: {
					color: '#fff',
					fontSize:'14'
				}
			},
			series: [
				{type: 'bar'},
				{type: 'bar'},
				{type: 'bar'}
			]
		};


        // 使用刚指定的配置项和数据显示图表。
        myChartbar.setOption(optionbar);
/*各部门人数所占比 饼形图*/
	var myChartcircle = echarts.init(document.getElementById('maincircle'));
	var optioncircle = {
	toolbox: {
		feature: {
			saveAsImage: {}
		}
	},
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
//	legend: {
//		data:['平行工作室','人事教育处','财务处','综合管理处','产业化处'],
//		textStyle:{//图例文字的样式
//			color:'#fff',
//			fontSize:14
//		}
//	},
	color:['#1576bd','#c6345a','#d64954','#f18d32','#f6c55c'],
    
    series : [
        {
            name: '部门人员',
            type: 'pie',
            radius : '55%',
            data:[
                {value:335, name:'平行工作室'},
                {value:310, name:'人事教育处'},
                {value:234, name:'财务处'},
                {value:135, name:'综合管理处'},
                {value:148, name:'产业化处'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};


myChartcircle.setOption(optioncircle);



