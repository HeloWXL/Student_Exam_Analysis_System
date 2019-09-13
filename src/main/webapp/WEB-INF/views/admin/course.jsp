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
    <title>课程管理</title>
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
            <blockquote class="layui-elem-quote">课程管理</blockquote>
            <%--            操作--%>
            <div class="top">

            </div>

            <%--            表格--%>
            <div class="center">
                <table id="demo" lay-filter="coursefilter" ></table>
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
            id:'courseTable',
            elem: '#demo'
            , toolbar: '#toolbars'
            , defaultToolbar: []
            ,url: ctx+'/course/getCourse' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'checkbox', type: 'checkbox'}
                ,{field: 'courseId', title: 'ID', width:80}
                ,{field: 'courseName', title: '课程名称', width:150}
                ,{field: 'createTime', title: '创建时间', width:200}
            ]]
            ,skin: 'line,row' //表格风格
            ,even: true
            ,limits: [5, 10, 15]
            ,limit: 10 //每页默认显示的数量
        });

        table.on('toolbar(coursefilter)', function(obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            var  data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        id: 1,
                        type: 1,
                        title: ['课程添加'],
                        skin: 'layui-layer-molv',
                        area: '300px',
                        offset: 'auto',
                        content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
                            '    <div class="layui-col-md10">' +
                            '        <form class="layui-form">' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">课程名:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入课程名" name="courseName" id="courseName" class="layui-input">\n' +
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
                            var course={
                                courseName:  $.trim($('#courseName').val())
                            };
                            $.ajax({
                                url: ctx+'/course/insertCourse',
                                data:JSON.stringify(course),
                                dataType:'json',
                                type:'post',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data==1){
                                        layer.alert('添加成功',function () {
                                            //关闭弹窗
                                            layer.closeAll();
                                            // 重新刷新表格
                                            table.reload('courseTable');
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
                        layer.alert('请选择一行');
                    } else {
                        var shorCutCondId = data[0].courseId;
                        layer.confirm('是否删除？',{title:'提示'},function(index) {
                            $.ajax({
                                url: ctx+'/shortcutconf/deleteShortCutConfById.do',
                                data:{shortCutConfId:shorCutCondId},
                                dataType:'json',
                                type:'get',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data.returnMap.status=="success"){
                                        layer.msg('删除成功');
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
                        layer.alert('只能选择一行');
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
                                '                <label class="layui-form-label" style="padding-left:-50px;">课程ID:</label>' +
                                '                <div class="layui-input-block">' +
                                '                    <input type="text"  name="courseId" id="courseId" class="layui-input" disabled="disabled">\n' +
                                '                </div>' +
                                '            </div>' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">课程名称:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"   name="courseName" id="courseName" class="layui-input">\n' +
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
                                $('#courseId').val(data[0].courseId);
                                $('#courseName').val(data[0].courseName);
                                $('#createTime').val(data[0].createTime);
                            },
                            btn1: function(index) {
                                // 提交
                                var course={
                                    courseId:data[0].courseId,
                                    courseName:  $.trim($('#courseName').val())
                                };
                                $.ajax({
                                    url: ctx+'/course/updateCourseById',
                                    data:JSON.stringify(course),
                                    dataType:'json',
                                    type:'post',
                                    contentType: 'application/json; charset=utf-8',
                                    success: function(data) {
                                        if(data==1){
                                            layer.alert('修改成功',function () {
                                                layer.closeAll();
                                                table.reload('courseTable');
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
