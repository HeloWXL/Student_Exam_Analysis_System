<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/12
  Time: 1:11 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>教师登录</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/plugins/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin_login.css">
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>

<div class='login-wrap'>
    <h2>管理员登录</h2>
    <form action="/admin/checkLogin" class='login-container' method="post">
        <input type='text' placeholder='请输入用户名' name='adminName' >
        <input type='password' placeholder='请输入密码' name='password'>
        <input type="hidden" value="${msg}" id="msg">
        <input type='submit' value='登录' id="submit">

    </form>
</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="${ctx}/resources/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/admin_login.js"></script>
</html>
