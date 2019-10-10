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
            <blockquote class="layui-elem-quote">填空题管理</blockquote>
            <%--            操作--%>
            <div class="top">
                <form class="layui-form" action="">
                    <div class="layui-inline">
                        <label class="layui-form-label">课程名：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="courseName" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">难度等级：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="level" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">能力类型:</label>
                        <div class="layui-input-inline">
                              <select name="typeId">
                                  <option value="">请选择能力类型</option>
                                    <option value="1">客观分析能力</option>
                                    <option value="2">推理能力</option>
                                    <option value="3">动手能力</option>
                                    <option value="4">计算能力</option>
                                    <option value="5">应用能力</option>
                              </select>
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
            <%--表格--%>
            <div class="center">
                <table id="demo" lay-filter="competionfilter"></table>
            </div>
        </div>
    </div>
</div>
<!-- 表格标签工具栏 -->
<script type="text/html" id="toolbars">
    <div class="layui-btn-container">
        <div class="layui-btn-group">
            <button type="button" lay-event="add" class="layui-btn layui-btn-primary">
                <i class="layui-icon">&#xe654;</i>增加
            </button>
            <button type="button" lay-event="update" class="layui-btn layui-btn-normal"><i
                    class="layui-icon">&#xe60a;</i>修改
            </button>
            <button type="button" lay-event="delete" class="layui-btn layui-btn-danger"><i
                    class="layui-icon">&#xe640;</i>删除
            </button>
           <button type="button" lay-event="addmore" class="layui-btn" style="float: right"><i
                    class="layui-icon">&#xe654;</i>批量导入
            </button>
            <a style="color: blue;float: right" target="_blank" id="impLink" href="${ctx}/resources/model/CompletionQuestionTemplete.xlsx">

            <button type="button" lay-event="downloadTemplate" class="layui-btn layui-btn-warm" style="float: right"><i
                    class="layui-icon">&#xe640;</i>批量导入模板下载
            </button>
            </a>
        </div>

    </div>
</script>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/admin/admin_completionQuestion.js" type="application/javascript"></script>
</html>
