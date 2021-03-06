<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/12
  Time: 1:12 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生登录</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" href="${ctx}/resources/css/common.css" />
    <link rel="stylesheet" href="${ctx}/resources/css/login.css" />
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <link href="${ctx}/resources/plugins/layui/css/layui.css" rel="stylesheet">
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>

<div class="mui-content">
    <div id="login"></div>
    <div class="login_bg">
        <div id="logo">
            <img src="${ctx}/resources/images/logo.png" alt="logo" />
        </div>
        <form class="layui-form">
            <div class="userName">
                <lable>手机号码：</lable>
                <input  type="tel" name="phone" lay-verify="required|phone" placeholder="请输入手机号码" required />
            </div>
            <div class="passWord">
                <lable>密&nbsp;&nbsp;&nbsp;码：</lable>
                <input type="password" name="password" placeholder="请输入密码"  required />
            </div>
            <div class="choose_box">
                <a href="/demo/student/toRegister">没有账号？注册</a>
            </div>
            <button class="login_btn" data-loading-icon="mui-spinner mui-spinner-custom" type="submit" id="submit">登&nbsp;&nbsp;录</button>
        </form>
    </div>
</div>
</body>
<script src="${ctx}/resources/js/mui.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/resources/js/student/login.js"></script>
</html>
