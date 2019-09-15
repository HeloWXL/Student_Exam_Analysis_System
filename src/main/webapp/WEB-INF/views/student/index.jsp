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
            width: 96%;
            height: 43%;
            margin: 1% 2%;
            float: left;
            background-color: #FFFFFF;
            border-radius: 15px;
        }

        .test img{
            margin: 6% 27%;
            width: 47%;
            height: 62%;
        }

        .test:hover{
            background-color: #DDDDDD;
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
    <div id="content">
        <c:forEach var="test" items="${testList}">
            <div class="test">
                <a href="/student/toPaperList/${test.testId}">
                    <img src="${ctx}/resources/images/logo.png" />
                    <p>考试名称：<span style="color: #000000;">${test.testName}</span></p>
                    <p>发布人：<span>admin</span></p>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script>
    //时间转换函数
    Date.prototype.format = function(fmt) {
        var o = {
            "M+" : this.getMonth()+1,                 //月份
            "d+" : this.getDate(),                    //日
            "h+" : this.getHours(),                   //小时
            "m+" : this.getMinutes(),                 //分
            "s+" : this.getSeconds(),                 //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S"  : this.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt)) {
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        }
        for(var k in o) {
            if(new RegExp("("+ k +")").test(fmt)){
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            }
        }
        return fmt;
    }

    var time = $(".time").val();
</script>
</html>
