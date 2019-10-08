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
    <title>学生在线考试</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
    <link type="text/css" href="${ctx}/resources/css/test.css" media="all" rel="stylesheet"  />
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>

    <script>
        var ctx = '${ctx}'
    </script>

    <style>
        .mui-navigate-right{
            text-decoration: none!important;
        }
        .mui-table-view-cell>a:not(.mui-btn){
            margin: 3px 18px;
        }
        label{
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="mui-content">
    <div class="mui-card">
        <!--页眉，放置标题-->
        <div class="mui-card-header">${paper.paperName}</div>
        <!--页脚，放置补充信息或支持的操作-->
        <div class="mui-card-footer">
            <p>考试时间：<span>60分钟</span></p>
            <p>总分：<span>100分</span></p>
        </div>
    </div>
    <div class="main">
        <input value="${paper.paperId}" type="hidden" id="paperId">
      <div class="warp">
        <div class="issue" id="issue">
            <div>
                <label>选择题</label>
            </div>
            <c:forEach var="select" items="${paper.selectQuestionList}" varStatus="status">
                <div class="cnt" id="id${status.count}">
                    <h3 class="selectTitle">${status.count}、${select.text}</h3>
                    <ul class="mui-table-view mui-table-view-radio">
                        <li class="mui-table-view-cell" value="a">
                            <a class="mui-navigate-right">A、${select.optionA}</a>
                        </li>
                        <li class="mui-table-view-cell" value="b">
                           <a class="mui-navigate-right" > B、${select.optionB}</a>
                        </li>
                        <li class="mui-table-view-cell" value="c">
                            <a class="mui-navigate-right">C、${select.optionC}</a>
                        </li>
                        <li class="mui-table-view-cell" value="d">
                           <a class="mui-navigate-right"> D、${select.optionD}</a>
                        </li>
                    </ul>
                </div>
            </c:forEach>
            <div style="margin-top: 10px;">
                <label>填空题 </label>
            </div>

            <c:forEach var="completion" items="${paper.completionQuestionList}" varStatus="status">
                <div class="cnt">
                    <h3 class="completionTitle">${status.count}、${completion.text}</h3>
                    <label ><input type="text" class="mui-input-clear" name="c${completion.completionId}"></label>
                </div>
            </c:forEach>
            <div style="position: relative;top: 10px">
                <button type="button" class="mui-btn mui-btn-primary"  id="submit" style="width: 100%;margin-bottom: 10px">交卷</button>
            </div>
        </div>
    </div>
    </div>
</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/mui.min.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/student_test.js" type="application/javascript"></script>
<script>
    if('${student}'!=''){
        var studentId  ='${student.studentId}';
    }else{
        location.href=ctx+'/student/toLogin';
    }
</script>
</html>
