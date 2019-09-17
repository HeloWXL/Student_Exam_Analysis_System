<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/15
  Time: 10:52 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    试卷界面
    <a href="/student/toReport">学生报告页面</a>
</body>
<script>
    if('${student}'==""){
        location.href="/student/toLogin";
    }
</script>
</html>
