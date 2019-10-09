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
    <title>学生注册</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" href="${ctx}/resources/css/common.css"/>
    <link rel="stylesheet" href="${ctx}/resources/css/login.css"/>
    <link href="${ctx}/resources/plugins/layui/css/layui.css" rel="stylesheet">
    <link rel="icon" href="${ctx}/resources/ico/logo.ico" type=”image/x-icon”>
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet"/>
    <script>
      var ctx = '${ctx}'
    </script>
</head>
<body>
<div id="login"></div>
<div class="login_bg">
    <div id="logo">
        <img src="${ctx}/resources/images/logo.png" alt=""/>
    </div>
    <form class="layui-form">
        <div class="userName">
            <lable>姓名：</lable>
            <input type="text" name="name" lay-verify="required" lay-reqtext="姓名是必填项，岂能为空？" placeholder="请输入真实姓名" required/>
        </div>
        <div class="passWord">
            <lable>手机号码：</lable>
            <input type="text" name="phone" placeholder="请输入手机号码" required/>
        </div>
        <div class="passWord">
            <lable>密&nbsp;&nbsp;&nbsp;码：</lable>
            <input type="password" name="password" placeholder="请输入密码" required/>
        </div>
        <div class="passWord">
            <lable>确认密码：</lable>
            <input type="password" name="passwordConfirm" placeholder="请输入密码" required/>
        </div>
        <div class="choose_box">
            <a href="/demo/student/toLogin">已有账号？登录</a>
        </div>
        <button class="login_btn" type="button" style="margin-top: 10px;" id="register">注&nbsp;&nbsp;册</button>
    </form>

</div>
</body>
<script src="${ctx}/resources/js/mui.min.js"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/student/register.js"></script>
</html>
