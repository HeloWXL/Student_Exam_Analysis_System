<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/18
  Time: 8:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>x学生在线考试</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
    <link type="text/css" href="${ctx}/resources/css/test.css" media="all" rel="stylesheet"  />
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>

<div class="mui-content">
<%--<div class="banner"><img src="images/banner.png"/></div>--%>
<div class="main">
    <div class="warp">
        <div class="issue" id="issue">

<c:forEach var="t" items="${test}">
    <%--                选择题列表--%>
<%--    <p>${t.key}</p>--%>
    <c:out value="${t[\"value\"][0]}"></c:out>
    <c:out value="${t[\"value\"][1]}"></c:out>
<%--    <c:forEach var="select" items="${t[\"value\"][0]}">--%>
<%--            <div class="cnt">--%>
<%--                <h3>${select.text}</h3>--%>
<%--                <ul>--%>
<%--                    <li><span>&nbsp;</span><label><input type="radio" name="select'+i+'" value="0" />${select.optionA}</label></li>--%>
<%--                    <li><span>&nbsp;</span><label><input type="radio" name="select'+i+'" value="0" />${select.optionB}</label></li>--%>
<%--                    <li><span>&nbsp;</span><label><input type="radio" name="select'+i+'" value="0" />${select.optionC}</label></li>--%>
<%--                    <li><span>&nbsp;</span><label><input type="radio" name="select'+i+'" value="0" />${select.optionD}</label></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--    </c:forEach>--%>
    <%--                填空题列表--%>
<%--    <c:forEach var="complete" items='${t[\"value\"][1]}'>--%>
<%--            <div class="cnt">--%>
<%--               <h3>${complete.text}</h3>--%>
<%--                   <label><input type="text" class="mui-input-clear"></label>--%>
<%--           </div>--%>
<%--    </c:forEach>--%>
</c:forEach>
                <a href="/student/toReport">学生报告页面</a>
        </div>
    </div>
</div>
</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<%--<script src="${ctx}/resources/js/test.js" type="application/javascript"></script>--%>
</html>
