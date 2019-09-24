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
    <link href="${ctx}/resources/plugins/layui/css/layui.css" rel="stylesheet"/>
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
        #info div{
            width: 30%;
            float: left;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div>
    <h2 style="margin: 0 auto">测评结果</h2>

    <div id="info">
        <div>平均得分<span style="color: green;font-weight: bold">88分</span></div>
        <div>您的得分<span style="color: green;font-weight: bold">${report.score}分</span></div>
        <div>推荐班型<span style="color: green;font-weight: bold">${report.className}</span></div>
    </div>

    <table width="100%" class="table" id="tablevalue">
        <tr>
            <th width=10%>题目</th>
            <th width=10%>你的答案</th>
            <th width=10%>正确答案</th>
            <th width=10%>能力</th>
            <th width=10%>难易程度</th>
            <th width=10%>知识点</th>

        </tr>
        <c:forEach var="re" items="${report.selectList}" varStatus="i">
            <tr>
                <td>第一题</td>
                <td style="color: green;font-weight: bold">${re}</td>
                <td>${report.selectQuestionList[i.index]}</td>
                <td>计算能力</td>
                <td><div id="test"></div></td>
                <td>分数计算</td>
            </tr>
        </c:forEach>
        </table>
        </div>
        <div id="container" style="height:600px"></div>

            <div id="container2" style="height:600px"></div>
            <script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/echarts.min.js" type="application/javascript"></script>
<script>
    layui.use(['rate'], function() {
        var rate = layui.rate;
        //只读
        rate.render({
            elem: '#test'
            ,value: 3
            ,readonly: true
        });
        rate.render({
            elem: '#test1'
            ,value: 2
            ,readonly: true
        });
        rate.render({
            elem: '#test2'
            ,value: 4
            ,readonly: true
        });
    })
</script>

<script type="text/javascript">
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom,'light');
    option1 = null;
    option1 = {
        title: {
            text: '能力分析'
        },
        tooltip: {},
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
                name: '客观分析能力',
                max: 10
            },
                {
                    name: '观察能力',
                    max: 10
                },
                {
                    name: '应用能力',
                    max: 10
                },
                {
                    name: '计算能力',
                    max: 10
                },
                {
                    name: '动手能力',
                    max: 10
                },
                {
                    name: '推理能力',
                    max: 10
                }
            ]
        },
        series: [{
            name: '能力分析',
            type: 'radar',
            // areaStyle: {normal: {}},
            data: [
                {
                    value: [3, 2, 4, 5, 6, 3],
                    name: '我的能力'
                }
            ]
        }]
    };
    if (option1 && typeof option1 === "object") {
        myChart.setOption(option1, true);
    }
</script>
<script type="text/javascript">
    var dom = document.getElementById("container2");
    var myChart2 = echarts.init(dom,'light');
    option2 = null;
    option2 = {
        title: {
            text: '成绩比较'
        },
        legend: {},
        tooltip: {},
        dataset: {
            source: [
                ['score', '平均成绩','我的考试成绩'],
                ['平均成绩', 88,0],
                ['我的考试成绩', 0,98],

            ]
        },
        xAxis: {type: 'category'},
        yAxis: {},
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [
            {type: 'bar'},
            {type: 'bar'}

        ]
    };
    if (option2 && typeof option2 === "object") {
        myChart2.setOption(option2,true);
    }
</script>
</body>
</html>
