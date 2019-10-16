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
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>
    <script>
        var ctx = '${ctx}'
    </script>
    <style>
        #content{
            width: 100%;
            height: 100%;
        }
        img{
            margin: 6% 27%;
            width: 47%;
            height: 30%;
        }
        p{
            margin-left: 5px;
            font-size: 13px;
            margin-bottom: -2px;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">学生考试首页</h1>
</header>
<div class="mui-content">
    <div id="content"></div>
    <nav class="mui-bar mui-bar-tab">
        <a class="mui-tab-item mui-active">
            <span class="mui-icon mui-icon-home"></span>
            <span class="mui-tab-label">首页</span>
        </a>
        <a class="mui-tab-item">
            <span class="mui-icon mui-icon-gear"></span>
            <span class="mui-tab-label">我的报告</span>
        </a>
    </nav>
</div>
</body>
<%--引入js文件--%>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<%--自定义js文件--%>
<script src="${ctx}/resources/js/student/index.js" type="application/javascript"></script>
</html>
