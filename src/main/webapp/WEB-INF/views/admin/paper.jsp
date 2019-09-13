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
    <title>试卷管理</title>
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
            <blockquote class="layui-elem-quote">试卷管理</blockquote>
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
                <table id="demo" lay-filter="paperfilter"></table>
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

        table.on('toolbar(paperfilter)', function(obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            var  data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        id: 1,
                        type: 1,
                        title: ['快捷操作添加'],
                        skin: 'layui-layer-molv',
                        area: '500px',
                        offset: 'auto',
                        content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
                            '    <div class="layui-col-md10">' +
                            '        <form class="layui-form">' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">操作名称:</label>' +
                            '                <div class="layui-input-block">' +
                            '                    <input type="text" placeholder="请输入操作名称" lay-verify="questionnaireName" name="optName" id="optName" class="layui-input">\n' +
                            '                </div>' +
                            '            </div>' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">支持产品编码:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入支持产品编码" lay-verify="questionnaireName" name="supPdtCode" id="supPdtCode" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">参数使用情况:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text"  lay-verify="questionnaireName" placeholder="0：无参数操作 1：有参数操作 2：复杂操作" name="paraUse" id="paraUse" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">HTML片段:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text"  lay-verify="questionnaireName" placeholder="请输入HTML片段" name="paraHtml" id="paraHtml" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">显示顺序:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入显示顺序" lay-verify="questionnaireName" name="disOrder" id="disOrder" class="layui-input">\n' +
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
                            var shortCutConfDto={
                                optName:  $.trim($('#optName').val()),
                                supPdtCode : $.trim($('#supPdtCode').val()),
                                paraUse : $.trim($('#paraUse').val()),
                                paraHtml : $.trim($('#paraHtml').val()),
                                disOrder : $.trim($('#disOrder').val())
                            };
                            console.log(shortCutConfDto);

                            $.ajax({
                                url: ctx+'/shortcutconf/insertShortCutConf.do',
                                data:JSON.stringify(shortCutConfDto),
                                dataType:'json',
                                type:'post',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    layer.msg('添加成功');
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
                        var shorCutCondId = data[0].shortCutId;
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
                            id: 1,
                            type: 1,
                            title: ['快捷操作配置修改'],
                            skin: 'layui-layer-molv',
                            area: '500px',
                            offset: 'auto',
                            content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
                                '    <div class="layui-col-md10">' +
                                '        <form class="layui-form">' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">操作名称:</label>' +
                                '                <div class="layui-input-block">' +
                                '                    <input type="text" placeholder="请输入操作名称" lay-verify="questionnaireName" name="optName" id="optName" class="layui-input">\n' +
                                '                </div>' +
                                '            </div>' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">支持产品编码:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" placeholder="请输入支持产品编码" lay-verify="questionnaireName" name="supPdtCode" id="supPdtCode" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">参数使用情况:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"  lay-verify="questionnaireName" placeholder="0：无参数操作 1：有参数操作 2：复杂操作" name="paraUse" id="paraUse" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">HTML片段:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"  lay-verify="questionnaireName" placeholder="请输入HTML片段" name="paraHtml" id="paraHtml" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">显示顺序:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" placeholder="请输入显示顺序" lay-verify="questionnaireName" name="disOrder" id="disOrder" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '        </form>\n' +
                                '    </div>\n' +
                                '</div>\n',
                            btn: ['提交', '取消']
                            , success: function(layero) {
                                layero.find('.layui-layer-btn').css('text-align', 'center');
                                // 展示在弹出层里面
                                $('#optName').val(data[0].optName);
                                $('#supPdtCode').val(data[0].supPdtCode);
                                $('#paraUse').val(data[0].paraUse);
                                $('#paraHtml').val(data[0].paraHtml);
                                $('#disOrder').val(data[0].disOrder);
                            },
                            btn1: function(index) {
                                // 提交
                                var shortCutConfDto={
                                    shortCutId:data[0].shortCutId,
                                    optName:  $.trim($('#optName').val()),
                                    supPdtCode : $.trim($('#supPdtCode').val()),
                                    paraUse : $.trim($('#paraUse').val()),
                                    paraHtml : $.trim($('#paraHtml').val()),
                                    disOrder : $.trim($('#disOrder').val())
                                };
                                $.ajax({
                                    url: ctx+'/shortcutconf/updateShortCutConfById.do',
                                    data:JSON.stringify(shortCutConfDto),
                                    dataType:'json',
                                    type:'post',
                                    contentType: 'application/json; charset=utf-8',
                                    success: function(data) {
                                        console.log(data);
                                        layer.alert('添加成功',function() {
                                            layer.close(index);
                                        });

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
