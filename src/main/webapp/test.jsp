<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<c:set var="ctx" value="${pageContext.request.contextPath}"/>
	<title>TITLE</title>
	<link rel="icon" href="${ctx}/static/custom/images/favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="${ctx}/static/custom/images/favicon.ico" type="image/x-icon">

	<script src="${ctx}/static/plugins/layuiadmin/lib/extend/echarts.js"></script>
</head>
<body>
${requestScope}
<br>
${pageContext.request.contextPath}

<a href="score/selectByPrimaryKey">1234</a>

<div id="LAY-index-normline" style="width: 800px;height:500px;"></div>

<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('LAY-index-normline'));

	//标准折线图
	var option = {
		tooltip : {
			trigger: 'axis'
		},
		legend: {
			data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
		},
		calculable : true,
		xAxis : [
			{
				type : 'category',
				boundaryGap : false,
				data : ['周一','周二','周三','周四','周五','周六','周日']
			}
		],
		yAxis : [
			{
				type : 'value'
			}
		],
		series : [
			{
				name:'邮件营销',
				type:'line',
				stack: '总量',
				itemStyle: {normal: {areaStyle: {type: 'default'}}},
				data:[120, 132, 101, 134, 90, 230, 210]
			},
			{
				name:'联盟广告',
				type:'line',
				stack: '总量',
				itemStyle: {normal: {areaStyle: {type: 'default'}}},
				data:[220, 182, 191, 234, 290, 330, 310]
			},
			{
				name:'视频广告',
				type:'line',
				stack: '总量',
				itemStyle: {normal: {areaStyle: {type: 'default'}}},
				data:[150, 232, 201, 154, 190, 330, 410]
			},
			{
				name:'直接访问',
				type:'line',
				stack: '总量',
				itemStyle: {normal: {areaStyle: {type: 'default'}}},
				data:[320, 332, 301, 334, 390, 330, 320]
			},
			{
				name:'搜索引擎',
				type:'line',
				stack: '总量',
				itemStyle: {normal: {areaStyle: {type: 'default'}}},
				data:[820, 932, 901, 934, 1290, 1330, 1320]
			}
		]
	};
		myChart.setOption(option);
</script>




<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 800px;height:500px;"></div>
<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	// 指定图表的配置项和数据
	var option = {
		title: {
			text: '实例'
		},
		tooltip: {},
		legend: {
			data: ['销量']
		},
		xAxis: {
			data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
		},
		yAxis: {},
		series: [{
			name: '销量',
			type: 'bar',
			data: [5, 20, 36, 10, 10, 20]
		}]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
</script>


</body>
</html>
