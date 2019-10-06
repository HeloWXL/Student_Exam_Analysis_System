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
    <title>考试管理</title>
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
            <blockquote class="layui-elem-quote">考试管理</blockquote>
            <%--            操作--%>
            <div class="top">
                <form class="layui-form" action="">
                    <div class="layui-inline">
                        <label class="layui-form-label">考试名称：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="testName" autocomplete="off" class="layui-input">
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
                <table id="demo" lay-filter="testfilter"></table>
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
        </div>
    </div>
</script>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        var testAdminVo = {
            testName:''
        };

        // 加载表格数据
        loadData(table,testAdminVo);
        // 查询
        $('#query').click(function() {

            var testAdminVo = {
                testName:$("input[name='testName']").val()
            };
            loadData(table,testAdminVo);
        });

        function loadData(table,testAdminVo) {
            table.render({
                id: 'testTable',
                elem: '#demo'
                , toolbar: '#toolbars'
                , defaultToolbar: []
                , url: ctx + '/test/getTest' //数据接口
                , page: true //开启分页
                ,method:'post'
                ,contentType: 'application/json; charset=utf-8'
                ,where:testAdminVo
                , cols: [[ //表头
                    {field: 'checkbox', type: 'checkbox'}
                    , {field: 'number', title: '序号', type: 'numbers'}
                    , {field: 'testName', title: '考试名称', width: 200}
                    , {field: 'time', title: '考试时间', width: 150}
                    , {field: 'adminName', title: '发布人', width: 150}
                    , {field: 'createTime', title: '创建时间', width: 200}
                ]]
                , skin: 'line,row' //表格风格
                , even: true
                , limits: [10, 20, 30]
                , limit: 10 //每页默认显示的数量
            });
        }

        table.on('toolbar(testfilter)', function(obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            var  data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        id: 1,
                        type: 1,
                        title: ['发布考试'],
                        skin: 'layui-layer-molv',
                        area: '500px',
                        offset: 'auto',
                        content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
                            '    <div class="layui-col-md10">' +
                            '        <form class="layui-form">' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">考试名称:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入考试名称" name="testName" id="testName" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">考试时间:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入考试时间" name="time" id="time" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '        </form>\n' +
                            '    </div>\n' +
                            '</div>\n',
                        btn: ['提交', '取消']
                        , success: function(layero) {
                            layero.find('.layui-layer-btn').css('text-align', 'center');
                        },
                        btn1: function(index) {
                            // 提交
                            var test={
                                testName: $.trim($('#testName').val()),
                                time: $.trim($('#time').val()),
                            };
                            $.ajax({
                                url: ctx+'/test/insertTest',
                                data:JSON.stringify(test),
                                dataType:'json',
                                type:'post',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data==1){
                                        layer.alert('添加成功',function () {
                                            //关闭弹窗
                                            layer.closeAll();
                                            // 重新刷新表格
                                            table.reload('testTable');
                                        });
                                    }else{
                                        layer.alert("添加失败")
                                    }
                                },error:function (e) {
                                    layer.msg("服务器内部错误")
                                }
                            });
                        },
                        // 取消
                        btn2: function(index, layero) {
                            layer.close(index);
                        }
                    });
                    break;
                case 'delete':
                    if (data.length == 0) {
                        layer.msg('请选择一行');
                    } else {
                        var testId = data[0].testId;
                        layer.confirm('是否删除？',{title:'提示'},function(index) {
                            $.ajax({
                                url: ctx+'/test/deleteByTest',
                                data:{testId:testId},
                                dataType:'json',
                                type:'get',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data==1){
                                        layer.alert("删除成功",function () {
                                            //关闭弹窗
                                            layer.closeAll();
                                            // 重新刷新表格
                                            table.reload('testTable');
                                        })
                                    }else{
                                        layer.alert("删除失败")
                                    }
                                }
                            });
                        });
                    }
                    break;
                case 'update':
                    if (data.length == 0) {
                        layer.msg('请选择一行');
                    } else if(data.length > 1) {
                        layer.msg('只能选择一行');
                    }else{
                        layer.open({
                            id: 2,
                            type: 1,
                            title: ['课程修改'],
                            skin: 'layui-layer-molv',
                            area: '500px',
                            offset: 'auto',
                            content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
                                '    <div class="layui-col-md10">' +
                                '        <form class="layui-form">' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">考试名称:</label>' +
                                '                <div class="layui-input-block">' +
                                '                    <input type="text"  name="testName" id="testName" class="layui-input">\n' +
                                '                </div>' +
                                '            </div>' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">考试限时:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"   name="time" id="time" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">发布人:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"   name="adminName" id="adminName" class="layui-input" disabled="disabled">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">创建时间:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"    name="createTime" id="createTime" class="layui-input" disabled="disabled">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '        </form>\n' +
                                '    </div>\n' +
                                '</div>\n',
                            btn: ['提交', '取消']
                            , success: function(layero) {
                                layero.find('.layui-layer-btn').css('text-align', 'center');
                                // 展示在弹出层里面
                                $('#testName').val(data[0].testName);
                                $('#time').val(data[0].time);
                                $('#adminName').val(data[0].adminName);
                                $('#createTime').val(data[0].createTime);
                            },
                            btn1: function(index) {
                                // 提交
                                var test={
                                    testId:data[0].testId,
                                    testName:$('#testName').val(),
                                    time:$('#time').val()
                                };
                                $.ajax({
                                    url: ctx+'/test/updateByTest',
                                    data:JSON.stringify(test),
                                    dataType:'json',
                                    type:'post',
                                    contentType: 'application/json; charset=utf-8',
                                    success: function(data) {
                                        if(data==1){
                                            layer.alert('修改成功',function () {
                                                layer.closeAll();
                                                table.reload('testTable');
                                            });
                                        }else{
                                            layer.alert("修改失败")
                                        }

                                    }
                                });
                            },
                            btn2: function(index, layero) {
                                layer.close(index);
                            }
                        });
                    }
            }
        });
    });



</script>
</html>
