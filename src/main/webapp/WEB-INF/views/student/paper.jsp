<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/15
  Time: 10:52 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>

<div class="mui-content">
    <div id="content">
        试卷界面
        <a href="/student/toReport">学生报告页面</a>
    </div>
</div>


</body>
<script>
    if('${student}'==""){
        location.href="/student/toLogin";
    }
</script>
</html>
