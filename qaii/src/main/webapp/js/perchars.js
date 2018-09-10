
// 基于准备好的dom，初始化echarts实例

		//获取包括本月的前12个月日期
		function get12Month(nowdate){
			var result;
			$.ajax({
				async:false,
				type:"POST",
				url:"get12Month.do",
				data:{date:nowdate},
				success:function(data){
					result=data;
				}
			})
			return result;
		}
		function get8Years(nowdate){
			var result;
			$.ajax({
				async:false,
				type:"POST",
				url:"get8Years.do",
				data:{date:nowdate},
				success:function(data){
					result=data;
				}
			})
			return result;
		}
		
		//获取每个月的相关数据
		function geteachMonthMsg(date){
			var result=new Array();
			$.ajax({
				async:false,
				type:"POST",
				url:"geteachMonthMsg.do",
				data:{date:date},
				success:function(data){
					result=data;
				}
			})
			return result;
		}
		
		//获取每年的相关数据
		function geteachYearMsg(date){
			var result=new Array();
			$.ajax({
				async:false,
				type:"POST",
				url:"gettalentsTeam.do",
				data:{date:date},
				success:function(data){
					result=data;
				}
			})
			return result;
		}
		
		//获取饼状图数据
		function gettalentsdept(data){
			var result=null;
			$.ajax({
				async:false,
				type:"POST",
				url:"gettalentsdept.do",
				data:{data:data},
				success:function(data){
					result=data;
				}
			})
			return result;
		}
		
		function getdeptName(){
			var result=null;
			$.ajax({
				async:false,
				type:"POST",
				url:"getdeptName.do",
				success:function(data){
					result=data;
				}
			})
			return result;
		}
		
		var dept=new Array("平行工作室","人事教育处","财务处","综合管理处","产业化处");
		var _dept=gettalentsdept(dept);
//		function test(){
//			$.ajax({
//				type:"POST",
//				url:"setdata.do",
//				data:{date:"2018/07/27"},
//				success:function(data){
//					alert(data);
//				}
//			})
//		}
		var now=new Date();
		var nowdate=now.getFullYear()+"-"+(now.getMonth() + 1)+"-"+now.getDate();
		//设置当前时间为参考时间参数
		var _12Mon=get12Month(nowdate);
		var eachMonDate=geteachMonthMsg(_12Mon);
		var _8Years=get8Years(nowdate);
		var eachYearDate=geteachYearMsg(_8Years);
		
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
						fontSize:'12'
					}
				},
				data: [new Date(_12Mon[11]).getMonth()+1,new Date(_12Mon[10]).getMonth()+1,
					new Date(_12Mon[9]).getMonth()+1,new Date(_12Mon[8]).getMonth()+1,
					new Date(_12Mon[7]).getMonth()+1,new Date(_12Mon[6]).getMonth()+1,
					new Date(_12Mon[5]).getMonth()+1,new Date(_12Mon[4]).getMonth()+1,
					new Date(_12Mon[3]).getMonth()+1,new Date(_12Mon[2]).getMonth()+1,
					new Date(_12Mon[1]).getMonth()+1,new Date(_12Mon[0]).getMonth()+1]
			},
			yAxis: {
				type: 'value',
				axisLabel: {        
					show: true,
					textStyle: {
						color: '#fff',
						fontSize:'12'
					}
				},
			},
			series: [
				{
					name:'新入职',
					type:'line',
					stack: '总量',
					data:[eachMonDate[11].Entry, eachMonDate[10].Entry, eachMonDate[9].Entry, eachMonDate[8].Entry,
						eachMonDate[7].Entry, eachMonDate[6].Entry, eachMonDate[5].Entry,eachMonDate[4].Entry,
						eachMonDate[3].Entry,eachMonDate[2].Entry,eachMonDate[1].Entry,eachMonDate[0].Entry]
				},
				{
					name:'离职',
					type:'line',
					stack: '总量',
					data:[eachMonDate[11].Departure, eachMonDate[10].Departure, eachMonDate[9].Departure, eachMonDate[8].Departure,
						eachMonDate[7].Departure, eachMonDate[6].Departure, eachMonDate[5].Departure,eachMonDate[4].Departure,
						eachMonDate[3].Departure,eachMonDate[2].Departure,eachMonDate[1].Departure,eachMonDate[0].Departure]
				},
				{
					name:'净增长',
					type:'line',
					stack: '总量',
					data:[eachMonDate[11].Growth, eachMonDate[10].Growth, eachMonDate[9].Growth, eachMonDate[8].Growth,
						eachMonDate[7].Growth, eachMonDate[6].Growth, eachMonDate[5].Growth,eachMonDate[4].Growth,
						eachMonDate[3].Growth,eachMonDate[2].Growth,eachMonDate[1].Growth,eachMonDate[0].Growth]
				},
				{
					name:'院总人数',
					type:'line',
					stack: '总量',
					data:[eachMonDate[11].Total, eachMonDate[10].Total, eachMonDate[9].Total, eachMonDate[8].Total,
						eachMonDate[7].Total, eachMonDate[6].Total, eachMonDate[5].Total,eachMonDate[4].Total,
						eachMonDate[3].Total,eachMonDate[2].Total,eachMonDate[1].Total,eachMonDate[0].Total]
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
					{product: new Date(_8Years[7]).getFullYear(), '孵化公司人数': eachYearDate[7].Incnum, '研究院人数': eachYearDate[7].collegenum, '人员总数': eachYearDate[7].total},
					{product: new Date(_8Years[6]).getFullYear(), '孵化公司人数': eachYearDate[6].Incnum, '研究院人数': eachYearDate[6].collegenum, '人员总数': eachYearDate[6].total},
					{product: new Date(_8Years[5]).getFullYear(), '孵化公司人数': eachYearDate[5].Incnum, '研究院人数': eachYearDate[5].collegenum, '人员总数': eachYearDate[5].total},
					{product: new Date(_8Years[4]).getFullYear(), '孵化公司人数': eachYearDate[4].Incnum, '研究院人数': eachYearDate[4].collegenum, '人员总数': eachYearDate[4].total},
					{product: new Date(_8Years[3]).getFullYear(), '孵化公司人数': eachYearDate[3].Incnum, '研究院人数': eachYearDate[3].collegenum, '人员总数': eachYearDate[3].total},
					{product: new Date(_8Years[2]).getFullYear(), '孵化公司人数': eachYearDate[2].Incnum, '研究院人数': eachYearDate[2].collegenum, '人员总数': eachYearDate[2].total},
					{product: new Date(_8Years[1]).getFullYear(), '孵化公司人数': eachYearDate[1].Incnum, '研究院人数': eachYearDate[1].collegenum, '人员总数': eachYearDate[1].total},
					{product: new Date(_8Years[0]).getFullYear(), '孵化公司人数': eachYearDate[0].Incnum, '研究院人数': eachYearDate[0].collegenum, '人员总数': eachYearDate[0].total}					
				]
			},
			xAxis: {
				type: 'category',
				axisLabel: {        
					show: true,
					textStyle: {
						color: '#fff',
						fontSize:'14'
					}
				},
			},
			yAxis: {
				axisLabel: {        
					show: true,
					textStyle: {
						color: '#fff',
						fontSize:'14'
					}
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
                {value:_dept[0], name:'平行工作室'},
                {value:_dept[1], name:'人事教育处'},
                {value:_dept[2], name:'财务处'},
                {value:_dept[3], name:'综合管理处'},
                {value:_dept[4], name:'产业化处'}
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



