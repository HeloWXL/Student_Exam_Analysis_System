<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/12
  Time: 1:17 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生成绩报告</title>
    <meta charset="utf-8">
    <style>
        .table {
            border: 1px solid #cad9ea;
            color: #666;
        }

        .table th {
            background-repeat: repeat-x;
            height: 30px;
        }

        .table td,
        .table th {
            border: 1px solid #cad9ea;
            padding: 0 1em 0;
        }

        .table tr.alter {
            background-color: #f5fafe;
        }
    </style>
</head>
<body>
<div>
    <table width="100%" class="table" id="tablevalue">
        <tr>
            <th width=10%>时间</th>
            <th width=10%>温度</th>
            <th width=10%>时间</th>
            <th width=10%>温度</th>
            <th width=10%>时间</th>
            <th width=10%>温度</th>
        </tr>
        <tr>
            <td>1</td>
            <td>3</td>
            <td>1</td>
            <td>3</td>
            <td>1</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>3</td>
            <td>1</td>
            <td>3</td>
            <td>1</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>3</td>
            <td>1</td>
            <td>3</td>
            <td>1</td>
            <td>3</td>
        </tr>
    </table>
</div>
<div id="container" style="height:45%"></div>
<div id="container2" style="height:45%"></div>
<script src="https://cdn.bootcss.com/echarts/3.6.2/echarts.min.js"></script>
<script type="text/javascript">
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: '基础雷达图'
        },
        tooltip: {},
        legend: {
            data: ['预算分配（Allocated Budget）', '实际开销（Actual Spending）']
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [{
                name: '销售（sales）',
                max: 6500
            },
                {
                    name: '管理（Administration）',
                    max: 16000
                },
                {
                    name: '信息技术（Information Techology）',
                    max: 30000
                },
                {
                    name: '客服（Customer Support）',
                    max: 38000
                },
                {
                    name: '研发（Development）',
                    max: 52000
                },
                {
                    name: '市场（Marketing）',
                    max: 25000
                }
            ]
        },
        series: [{
            name: '预算 vs 开销（Budget vs spending）',
            type: 'radar',
            // areaStyle: {normal: {}},
            data: [{
                value: [4300, 10000, 28000, 35000, 50000, 19000],
                name: '预算分配（Allocated Budget）'
            },
                {
                    value: [5000, 14000, 28000, 31000, 42000, 21000],
                    name: '实际开销（Actual Spending）'
                }
            ]
        }]
    };;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>

<script type="text/javascript">
    var dom = document.getElementById("container2");
    var myChart2 = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
        },
        series: [{
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [{
                value: 335,
                name: '直接访问'
            },
                {
                    value: 310,
                    name: '邮件营销'
                },
                {
                    value: 234,
                    name: '联盟广告'
                },
                {
                    value: 135,
                    name: '视频广告'
                },
                {
                    value: 1548,
                    name: '搜索引擎'
                }
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };;
    if (option && typeof option === "object") {
        myChart2.setOption(option, true);
    }
</script>
</body>
</html>
