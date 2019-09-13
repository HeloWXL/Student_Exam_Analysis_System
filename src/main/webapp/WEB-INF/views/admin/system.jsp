<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/13
  Time: 7:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>系统配置相关</title>
    <link href="${ctx}/resources/plugins/layui/css/layui.css" rel="stylesheet">
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>
<div class="layui-col-md12">
    <!-- 模块名 -->
    <blockquote class="layui-elem-quote">系统配置相关</blockquote>
    <div class="tpl-card">
        <div class="card-pannel">
            <table class="layui-table" style="margin:0">
                <colgroup>
                    <col width="100">
                    <col>
                </colgroup>
                <tbody>
                <tr>
                    <td>当前版本</td>
                    <td>s1.0 pro <a href="javascript:;" class="card-a">更新日志</a></td>
                </tr>
                <tr>
                    <td>PHP环境</td>
                    <td>php 7.0.12-nts + Apche</td>
                </tr>
                <tr>
                    <td>数据库</td>
                    <td>mySql</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
