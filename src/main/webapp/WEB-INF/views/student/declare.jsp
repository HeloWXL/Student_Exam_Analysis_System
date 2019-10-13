<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/15
  Time: 10:53 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>考试声明</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>
    <script>
        var ctx = '${ctx}'
    </script>
    <style type="text/css">
        body,
        .mui-content {
            margin-right: 5px;
            margin-top: 10px;
            background-color: #FFFFFF;
            color: #000000;
        }
        .content div{
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
    <h1 class="mui-title">考试声明</h1>
</header>
<div class="mui-content">
    <div class="content">
        <div>
            <p>本次考试是在线考试，学生请自觉遵守考试纪律，不许抄袭,如有违反，将取消本次考试资格。</p>
            <p>试卷：<span>${paper.paperName}</span></p>
            <p>考试时间：<span>60分钟</span></p>
            <p>总分：<span>100分</span></p>
            <input value="${paper.paperId}" type="hidden" id="paperId">
        </div>
        </span></span>
        <p style="margin: 10px 15px;">
            <button id="comfirm" type="button" class="mui-btn mui-btn-danger mui-btn-block" style="padding: 5px 20px;">开始考试</button>
        </p>
    </div>
</div>
</body>
<script src="${ctx}/resources/js/mui.min.js"></script>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init({
        swipeBack: false,
        keyEventBind: {
            backbutton: false //关闭back按键监听
        }
    });
    $(function () {
        if('${student}'==""){
             location.href=ctx+"/student/toLogin";
             return;
        }
        $("#comfirm").click(function(){
            var paperId = $("#paperId").val();
            mui.alert("我已阅读考试声明，如有违反，后果自负",function(){
                location.href=ctx+"/paper/selectPaperInfo/"+paperId;
            })
        })
    })
</script>
</html>
