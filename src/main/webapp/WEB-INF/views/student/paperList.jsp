<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/13
  Time: 3:44 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>试卷列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <script>
        var ctx = '${ctx}'
    </script>
    <style>
        #content{
            width: 100%;
            height: 100%;
        }
        .paper{
            width: 96%;
            height: 42%;
            margin: 1% 2%;
            float: left;
            background-color: #FFFFFF;
            border-radius: 15px;
        }

        .paper img{
            margin: 6% 28%;
            width: 45%;
            height: 56%;
        }
        .paper:hover{
            background-color: #DDDDDD;
        }
        p{
            margin-left: 5px;
            margin-bottom: -2px;
            font-size: 13px;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">学生考试列表</h1>
</header>
<div class="mui-content">
    <div id="content">
        <c:forEach var="paper" items="${paperList}">
            <div class="paper">
                <a href="/student/toDeclaer/${paper.paperId}">
                    <img src="${ctx}/resources/images/logo.png" />
                    <p>试卷名称：<span style="color: #000000;">${paper.paperName}</span></p>
                    <p>考试名称：<span>${paper.testName}</span></p>
                    <p>发布人：<span>${paper.adminName}</span></p>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script>
    if('${student}'==""){
        location.href="/student/toLogin";
    }
</script>
</html>
