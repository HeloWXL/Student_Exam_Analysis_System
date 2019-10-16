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
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
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
        .mui-title{
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">${report.studentName}的成绩报告</h1>
</header>
<div class="mui-content">
    <div style="text-align: center">
        <h2 style="font-family: 楷体">测评结果</h2>
    </div>

    <div class="aui-chang-list">
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
<script src="${ctx}/resources/js/student/report.js" type="application/javascript"></script>
<script>
    // 考试平均分
    var avgScore = '${report.avgScore}';
    //我的分数
    var myScore ='${report.score}';
    //能力类型统计
    var abilitySeries =  "${report.abilitySeries}";
</script>
</body>
</html>
