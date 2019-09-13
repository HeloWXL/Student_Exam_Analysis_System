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
                <table id="demo" lay-filter="competionfilter"></table>
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
            id:'completionQuestionTable',
            elem: '#demo'
            , toolbar: '#toolbars'
            , defaultToolbar: []
            ,url: ctx+'/completionquestion/getCompletionQuestion' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'checkbox', type: 'checkbox'}
                ,{field: 'number', title: '序号', type: 'numbers'}
                ,{field: 'text', title: '题目', width:200,  align: 'center'}
                ,{field: 'answer', title: '答案', width:200,  align: 'center'}
                ,{field: 'courseName', title: '课程名', width:120,  align: 'center'}
                ,{field: 'level', title: '难度等级', width:100 ,align: 'center'}
                ,{field: 'typeName', title: '题目类型', width:120,align: 'center'}
                ,{field: 'knowledge', title: '知识点', width:180,align: 'center'}
                ,{field: 'createTime', title: '创建时间', width: 200,align: 'center'}
            ]]
            ,skin: 'line,row' //表格风格
            ,even: true
            ,limits: [5, 10, 15]
            ,limit: 10 //每页默认显示的数量
        });

        table.on('toolbar(competionfilter)', function(obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            var  data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        id: 1,
                        type: 1,
                        title: ['填空题添加'],
                        skin: 'layui-layer-molv',
                        area: '550px',
                        offset: 'auto',
                        content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
                            '    <div class="layui-col-md10">' +
                            '        <form class="layui-form">' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">填空题题目:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入课程名" name="text" id="text" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">答案:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text"  name="answer" id="answer" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '<div class="layui-form-item">\n' +
                            '    <label class="layui-form-label">课程名：</label>\n' +
                            '    <div class="layui-input-block">\n' +
                            '      <select name="courseId" >\n' +
                            '        <option value="">请选择课程名</option>\n' +
                            '        <option value="1">数学</option>\n' +
                            '        <option value="2">语文</option>\n' +
                            '        <option value="3">英语</option>\n' +
                            '        <option value="4">高等数学</option>\n' +
                            '      </select>\n' +
                            '    </div>\n' +
                            '  </div>'+
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">难度:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入题目难度" name="level" id="level" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '<div class="layui-form-item">\n' +
                            '    <label class="layui-form-label">请选择题目类型:</label>\n' +
                            '    <div class="layui-input-block">\n' +
                            '      <select name="typeId">\n' +
                            '        <option value="">请选择题目类型</option>\n' +
                            '        <option value="1">客观分析能力</option>\n' +
                            '        <option value="2">推理能力</option>\n' +
                            '        <option value="3">动手能力</option>\n' +
                            '        <option value="4">计算能力</option>\n' +
                            '        <option value="5">应用能力</option>\n' +
                            '      </select>\n' +
                            '    </div>\n' +
                            '  </div>'+
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">知识点:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入知识点" name="knowledge" id="knowledge" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '        </form>\n' +
                            '    </div>\n' +
                            '</div>\n',
                        btn: ['提交', '取消']
                        , success: function(layero) {
                            var forms = layui.form;
                            forms.render();
                            layero.find('.layui-layer-btn').css('text-align', 'center');
                        },
                        btn1: function(index) {
                            // 提交
                            var completionQuestion={
                                text:$.trim($('#text').val()),
                                answer:$.trim($('#answer').val()),
                                courseId:$.trim($('select[name="courseId"]').val()),
                                typeId:$.trim($('select[name="typeId"]').val()),
                                level:$.trim($('#level').val()),
                                knowledge:$.trim($('#knowledge').val()),
                            };
                            $.ajax({
                                url: ctx+'/completionquestion/insertCompletionQuestion',
                                data:JSON.stringify(completionQuestion),
                                dataType:'json',
                                type:'post',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data==1){
                                        layer.alert('添加成功',function () {
                                            //关闭弹窗
                                            layer.closeAll();
                                            // 重新刷新表格
                                            table.reload('completionQuestionTable');
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
                        var completionId = data[0].completionId;
                        layer.confirm('是否删除？',{title:'提示'},function(index) {
                            $.ajax({
                                url: ctx+'/completionquestion/deleteCompletionQuestion',
                                data:{completionId:completionId},
                                dataType:'json',
                                type:'get',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data=="1"){
                                        layer.alert("删除成功",function () {
                                            //关闭弹窗
                                            layer.closeAll();
                                            // 重新刷新表格
                                            table.reload('completionQuestionTable');
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
                                '                <label class="layui-form-label" style="padding-left:-50px;">填空题题目:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" placeholder="请输入课程名" name="text" id="text" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">答案:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"  name="answer" id="answer" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '<div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">课程名：</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <select name="courseId" >\n' +
                                '        <option value="">请选择课程名</option>\n' +
                                '        <option value="1">数学</option>\n' +
                                '        <option value="2">语文</option>\n' +
                                '        <option value="3">英语</option>\n' +
                                '        <option value="4">高等数学</option>\n' +
                                '      </select>\n' +
                                '    </div>\n' +
                                '  </div>'+
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">难度:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" placeholder="请输入题目难度" name="level" id="level" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '<div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">请选择题目类型:</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <select name="typeId">\n' +
                                '        <option value="">请选择题目类型</option>\n' +
                                '        <option value="1">客观分析能力</option>\n' +
                                '        <option value="2">推理能力</option>\n' +
                                '        <option value="3">动手能力</option>\n' +
                                '        <option value="4">计算能力</option>\n' +
                                '        <option value="5">应用能力</option>\n' +
                                '      </select>\n' +
                                '    </div>\n' +
                                '  </div>'+
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">知识点:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" placeholder="请输入知识点" name="knowledge" id="knowledge" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '        </form>\n' +
                                '    </div>\n' +
                                '</div>\n',
                            btn: ['提交', '取消']
                            , success: function(layero) {
                                var forms = layui.form;
                                forms.render();
                                layero.find('.layui-layer-btn').css('text-align', 'center');
                                // 展示在弹出层里面
                                $('#text').val(data[0].text);
                                $('#answer').val(data[0].answer);
                                $('select[name="courseId"]').val(data[0].courseId);
                                $('select[name="typeId"]').val(data[0].typeId);
                                $('#level').val(data[0].level);
                                $('#knowledge').val(data[0].knowledge);
                                forms.render('select')
                            },
                            btn1: function(index) {
                                // 提交
                                var completionQuestion={
                                    completionId:data[0].completionId,
                                    text:$.trim($('#text').val()),
                                    answer:$.trim($('#answer').val()),
                                    courseId:$.trim($('select[name="courseId"]').val()),
                                    typeId:$.trim($('select[name="typeId"]').val()),
                                    level:$.trim($('#level').val()),
                                    knowledge:$.trim($('#knowledge').val()),
                                };
                                $.ajax({
                                    url: ctx+'/completionquestion/updateCompletionQuestion',
                                    data:JSON.stringify(completionQuestion),
                                    dataType:'json',
                                    type:'post',
                                    contentType: 'application/json; charset=utf-8',
                                    success: function(data) {
                                        if(data==1){
                                            layer.alert('修改成功',function () {
                                                //关闭弹窗
                                                layer.closeAll();
                                                // 重新刷新表格
                                                table.reload('completionQuestionTable');
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
