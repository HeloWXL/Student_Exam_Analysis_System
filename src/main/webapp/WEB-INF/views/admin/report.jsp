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
                <table id="demo" lay-filter="reporftilter"></table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看报告</a>
</script>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        // 加载表格数据
        loadData(table);
        //监听工具条
        table.on('tool(reporftilter)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.studentId + ' 的查看操作');
            }
        });
    })

    //加载列表数据
    function loadData(table,queryStudentVo) {
        table.render({
            id: 'reportTable',
            elem: '#demo'
            , toolbar: '#toolbars'
            , method:'post'
            ,contentType: 'application/json; charset=utf-8'
            , defaultToolbar: []
            ,where:{

            }
            , url: ctx + '/student/getStudent' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                  {field: 'number', title: '序号', type: 'numbers'}
                , {field: 'reportName', title: '报告名称', width: 150}
                , {field: 'studentName', title: '学生姓名', width: 150}
                , {field: 'paperName', title: '试卷名称', width: 150}
                , {field: 'score', title: '考试分数', width: 150}
                , {field: 'createTime', title: '交卷时间', width: 200}
                , {field: 'className', title: '推荐班级', width: 150}
                , { fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
            ]]
            , skin: 'line,row' //表格风格
            , even: true
            , limits: [10, 15, 20]
            , limit: 10 //每页默认显示的数量
        });
    }
</script>

</html>
