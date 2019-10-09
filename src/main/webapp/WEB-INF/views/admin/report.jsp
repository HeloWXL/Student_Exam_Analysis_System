<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/23
  Time: 11:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生报告列表</title>
    <link href="${ctx}/resources/plugins/layui/css/layui.css" rel="stylesheet">
    <link rel="icon" href="${ctx}/resources/ico/admin_logo.ico"  type=”image/x-icon”>
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>
    <div class="layui-row">
    <div class="layui-col-xs12">
        <div class="grid-demo grid-demo-bg1">
            <!-- 模块名 -->
            <blockquote class="layui-elem-quote">报告管理</blockquote>
            <%--            操作--%>
            <div class="top">
                <form class="layui-form" action="">
                    <div class="layui-inline">
                        <label class="layui-form-label">报告名称：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="reportName" autocomplete="off" class="layui-input" style="width: 80px">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">学生姓名：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="studentName" autocomplete="off" class="layui-input" style="width: 80px">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">试卷名称：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="paperName" autocomplete="off" class="layui-input" style="width: 80px">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">推荐班级：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="className" autocomplete="off" class="layui-input" style="width: 80px">
                        </div>
                    </div>
                    <div class="layui-inline" id="btn">
                        <div class="layui-inline">
                            <button type="button" class="layui-btn layui-btn-primary" id="query">查询</button>
                        </div>
                        <div class="layui-inline">
                            <button type="button" class="layui-btn layui-btn-primary" id="reset">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <%--            表格--%>
            <div class="center">
                <table id="demo" lay-filter="reporftilter"></table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-normal" lay-event="detail">查看报告</a>
</script>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/admin/admin_report.js" type="application/javascript"></script>
</html>
