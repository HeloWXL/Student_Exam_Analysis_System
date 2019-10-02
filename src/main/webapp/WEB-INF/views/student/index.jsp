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
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>

    <script>
        var ctx = '${ctx}'
    </script>
    <style>
        #content{
            width: 100%;
            height: 100%;
        }
        img{
            margin: 6% 27%;
            width: 47%;
            height: 30%;
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

    </div>
</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script>
    $(function () {
        if('${student}'!=""){
            $.ajax({
                url:ctx+'/test/getTestAdmin',
                dataType:'json',
                type:'get',
                success:function (data) {
                    for(var i = 0 ;i<data.length;i++){
                        <%--$node = $('<div class="test">\n' +--%>
                        <%--    '                <a href="/student/getPaperByList/'+data[i].testId+'">\n' +--%>
                        <%--    '                    <img src="${ctx}/resources/images/logo.png" />\n' +--%>
                        <%--    '                    <p>考试名称：<span style="color: #000000;">'+data[i].testName+'</span></p>\n' +--%>
                        <%--    '                    <p>发布时间：<span>'+data[i].createTime+'</span></p>\n' +--%>
                        <%--    '                </a>\n' +--%>
                        <%--    '            </div>');--%>
                        $node = $('<a href="/demo/student/getPaperByList/'+data[i].testId+'">\n' +
                            '<div class="mui-card">\n' +
                            '\t<!--页眉，放置标题-->\n' +
                            '\t<div class="mui-card-header"><p>考试名称：<span style="color: #000000;">'+data[i].testName+'</span></p></div>\n' +
                            '\t<!--内容区-->\n' +
                            '\t<div class="mui-card-content"><img src="${ctx}/resources/images/logo.png" /></div>\n' +
                            '\t<!--页脚，放置补充信息或支持的操作-->\n' +
                            '\t<div class="mui-card-footer"><p>发布时间：<span>'+data[i].createTime+'</span></p></div>\n' +
                            '</a>\n' +
                            '</div>')
                        $("#content").append($node);
                    }
                }
            })
        }else{
            location.href=ctx+"/student/toLogin";
        }
    })
</script>
</html>
