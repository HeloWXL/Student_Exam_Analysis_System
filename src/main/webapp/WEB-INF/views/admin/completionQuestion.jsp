<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/13
  Time: 6:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>填空题管理</title>
    <link href="${ctx}/resources/plugins/layui/css/layui.css" rel="stylesheet">
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>
<div class="layui-row">
    <div class="layui-col-xs12">
        <div class="grid-demo grid-demo-bg1">
            <!-- 模块名 -->
            <blockquote class="layui-elem-quote">填空题管理</blockquote>
            <%--            操作--%>
            <div class="top">
                <form class="layui-form" action="">
                    <div class="layui-inline">
                        <label class="layui-form-label">姓名：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="userName" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">手机号码：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="phone" autocomplete="off" class="layui-input">
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
                <table id="demo" lay-filter="test"></table>
            </div>
        </div>
    </div>
</div>

<!-- 表格标签工具栏 -->
<script type="text/html" id="toolbars">
    <div class="layui-btn-container">
        <div class="layui-btn-group">
            <button type="button" lay-event="add" class="layui-btn layui-btn-primary layui-btn-sm">
                <i class="layui-icon">&#xe654;</i>增加
            </button>
            <button type="button" lay-event="update" class="layui-btn layui-btn-normal layui-btn-sm"><i
                    class="layui-icon">&#xe60a;</i>修改
            </button>
            <button type="button" lay-event="delete" class="layui-btn layui-btn-danger layui-btn-sm"><i
                    class="layui-icon">&#xe640;</i>删除
            </button>
        </div>
    </div>
</script>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            , toolbar: '#toolbars'
            , defaultToolbar: []
            ,height: 312
            ,url: 'https://www.layui.com/demo/table/user/' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80,  fixed: 'left'}
                ,{field: 'username', title: '用户名', width:80}
                ,{field: 'sex', title: '性别', width:80}
                ,{field: 'city', title: '城市', width:80}
                ,{field: 'sign', title: '签名', width: 177}
                ,{field: 'experience', title: '积分', width: 80}
                ,{field: 'score', title: '评分', width: 80}
                ,{field: 'classify', title: '职业', width: 80}
                ,{field: 'wealth', title: '财富', width: 135}
            ]]
        });

    });



</script>
</html>
