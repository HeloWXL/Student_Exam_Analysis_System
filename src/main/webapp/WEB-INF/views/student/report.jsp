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
    <link href="${ctx}/resources/css/report.css" rel="stylesheet"/>
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>
    <style>
        .table {
            margin-left: 1%;
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
        .mui-bar{
            background-color: #1B8BF5;
        }
    </style>
</head>
<body>
<div class="mui-content">
    <div style="text-align: center">
        <h2 style="font-family: 楷体">测评结果</h2>
    </div>

    <div class="aui-chang-list">
        <%--<div class="aui-user-img">--%>
            <%--<img src="${ctx}/resources/images/user.png" alt="">--%>
        <%--</div>--%>
        <div class="aui-user-text">
            <h1>学生姓名：${report.studentName}</h1>
            <span>推荐班级：${report.className}</span>
        </div>
    </div>
    <div id="info" style="margin-bottom: 10px">
        <div>平均得分<span style="color: green;font-weight: bold">${report.avgScore}分</span></div>
        <div>您的得分<span style="color: green;font-weight: bold">${report.score}分</span></div>
        <div>推荐班型<span style="color: green;font-weight: bold">${report.className}</span></div>
    </div>
    <table width="100%" class="table" id="tablevalue">
        <tr>
            <th width=10%>题目</th>
            <th width=10%>你的答案</th>
            <th width=10%>正确答案</th>
            <th width=10%>能力</th>
            <th width=10%>知识点</th>
        </tr>
        <c:forEach var="re" items="${report.selectList}" varStatus="i">
            <tr>
                <td>第${i.index+1}题</td>
                <td style="color: green;font-weight: bold">${re}</td>
                <td>${report.selectQuestionList[i.index]}</td>
                <td>${report.abilityList[i.index]}</td>
                <td>${report.knowledgeList[i.index]}</td>
            </tr>
        </c:forEach>
    </table>

<%--    //饼图  --能力分析--%>
    <div id="container" style="height:600px;margin-top: 50px;margin-left: 1%;margin-right: 1%"></div>
<%--    //统计直方图 --学生成绩分析--%>
    <div id="container2" style="height:600px;margin-top: 50px;margin-left: 1%;margin-right: 1%"></div>
</div>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/mui.min.js"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/echarts.min.js" type="application/javascript"></script>
<script>
    $(function () {
        // 考试平均分
        var avgScore = '${report.avgScore}';
        //我的分数
        var myScore ='${report.score}';
        //能力类型统计
        var abilitySeries =  "${report.abilitySeries}";
        var ablilityList = abilitySeries.substring(1,abilitySeries.length-1).split(',');
        var name = new Array();
        var value =new Array();
        var data = [];
        for(var i = 0 ;i<ablilityList.length;i++){
            if(i%2==0){
                name.push(ablilityList[i])
            }else{
                value.push(ablilityList[i])
            }
        }
        for(var j = 0 ; j<name.length;j++){
            var items={
                name:name[j],
                value:value[j]
            };
            data.push(items)
        }
        //饼图
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom,'light');
        option1 = null;
        option1 = {
            title : {
                text: '能力类型分析',
                subtext: '我的能力分析',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                bottom: 10,
                left: 'center',
                data: name
            },
            series : [
                {
                    name: '能力分析',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:data,
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
        if (option1 && typeof option1 === "object") {
            myChart.setOption(option1,true);
        }

        //统计直方图
        var dom = document.getElementById("container2");
        var myChart2 = echarts.init(dom,'light');
        option2 = null;
        option2 = {
            title : {
                text: '成绩分析',
                x:'center'
            },
            color: ['#3398DB'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'       // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : ['平均成绩', '我的成绩'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:['分数'],
                    type:'bar',
                    barWidth: '40%',
                    data:[avgScore, myScore]
                }
            ]
        };

        if (option2 && typeof option2 === "object") {
            myChart2.setOption(option2,true);
        }
    })


</script>
</body>
</html>
