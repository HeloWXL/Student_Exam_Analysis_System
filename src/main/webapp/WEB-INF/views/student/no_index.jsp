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
    <title>学生首页</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" href="${ctx}/resources/css/common.css" />
    <link rel="stylesheet" href="${ctx}/resources/css/login.css" />
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>
    <style>
        .login_bg{
            background: #ffffff;
        }
        .login_btn{
            width: 80%;
            margin: 10%;
        }
    </style>
</head>
<body>
    <div class="mui-content">
        <div id="login"></div>
        <div class="login_bg">
            <div id="logo">
                <img src="${ctx}/resources/images/logo.png" alt="logo" />
            </div>
            <a class="login_btn" href="/demo/student/toLogin">登&nbsp;&nbsp;录</a>
            <a class="login_btn" href="/demo/student/toRegister">注&nbsp;&nbsp;册</a>
        </div>
    </div>
    <div>
        <h6>学而不思则罔，思而不学则怠</h6>
    </div>
</body>
<script src="${ctx}/resources/js/mui.min.js"></script>
<script type="text/javascript">
    mui.init()
</script>
</html>
