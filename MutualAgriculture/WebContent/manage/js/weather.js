	var min=[];
	var max=[];
	var time=[];
	var hmin=[];
	var hmax=[];
	
	
	$.post("../jsonData/weather.json",function(data) {
		for(var i=0;i<data.length;i++){
			
			min[i]=data[i].min;
			max[i]=data[i].max;
			hmin[i]=data[i].hmin;
			hmax[i]=data[i].hmax;
			time[i]=data[i].date;
			//console.log(data[i].date);
			create(min,max,time);	
		}	
	}, "json");

	function create(min,max,time){

	 var myChart = echarts.init(document.getElementById('monthweather'));	
		option = {
	    title: {
		text: '未来一个月气温变化',
		subtext: '网上数据'
	    },
	    tooltip: {
		trigger: 'axis'
	    },
	    legend: {
		data:['预报高温','预报低温','历史均值高温','历史均值低温']
	    },
	    toolbox: {
		show: true,
		feature: {
		    dataZoom: {
		        yAxisIndex: 'none'
		    },
		    dataView: {readOnly: false},
		    magicType: {type: ['line', 'bar']},
		    restore: {},
		    saveAsImage: {}
		}
	    },
	    xAxis:  {
		type: 'category',
		boundaryGap: false,
		data: time
	    },
	    yAxis: {
		type: 'value',
		axisLabel: {
		    formatter: '{value} °C'
		}
	    },
	    series: [
		{
		    name:'预报高温',
		    type:'line',
		    smooth: true,
		    data:max
		    /*markPoint: {
		        data: [
		            {type: 'max', name: '最大值'},
		            {type: 'min', name: '最小值'}
		        ]
		    },
		    markLine: {
		        data: [
		            {type: 'average', name: '平均值'}
		        ]
		    }*/
		},
		{
		    name:'预报低温',
		    type:'line',
		    smooth: true,
		    data:min
		   /* markPoint: {
		        data: [
		            {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
		        ]
		    },
		    markLine: {
		        data: [
		            {type: 'average', name: '平均值'},
		            [{
		                symbol: 'none',
		                x: '90%',
		                yAxis: 'max'
		            }, {
		                symbol: 'circle',
		                label: {
		                    normal: {
		                        position: 'start',
		                        formatter: '最大值'
		                    }
		                },
		                type: 'max',
		                name: '最高点'
		            }]
		        ]
		    }*/
		},
		{
		    name:'历史均值高温',
		    type:'line',
		    smooth: true,
		    data:hmax
		},
		{
		    name:'历史均值低温',
		    type:'line',
		    smooth: true,
		    data:hmin
		}
	    ]
	};

      // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);   
	} 

