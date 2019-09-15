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
    <title>首页</title>
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
        .test{
            width: 45%;
            height: 50%;
            margin: 1% 2%;
            float: left;
            background-color: #FFFFFF;
            border-radius: 15px;
        }

        .test img{
            margin: 6% 7%;
            width: 85%;
            height: 20%;
        }
        p{
            margin-left: 5px;
        }
        .test:hover{
            background-color: #DDDDDD;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">学生考试首页</h1>
</header>
<div class="mui-content">
    <div id="content">
        <div class="test">
            <a href="/student/toDeclaer">
                <img src="${ctx}/resources/images/logo.png" />
                <p>考试名称：<span style="color: #000000;">入学考试</span></p>
                <p>考试时间：<span>2019-09-10</span></p>
            </a>
        </div>
        <div class="test">
            <a href="/student/toDeclaer">
                <img src="${ctx}/resources/images/logo.png" />
                <p>考试名称：<span style="color: #000000;">入学考试</span></p>
                <p>考试时间：<span>2019-09-10</span></p>
            </a>
        </div>
        <div class="test">
            <a href="/student/toDeclaer">
                <img src="${ctx}/resources/images/logo.png" />
                <p>考试名称：<span style="color: #000000;">入学考试</span></p>
                <p>考试时间：<span>2019-09-10</span></p>
            </a>
        </div>
        <div class="test">
            <a href="/student/toDeclaer">
                <img src="${ctx}/resources/images/logo.png" />
                <p>考试名称：<span style="color: #000000;">入学考试</span></p>
                <p>考试时间：<span>2019-09-10</span></p>
            </a>
        </div>
    </div>
</div>
</body>
</html>
