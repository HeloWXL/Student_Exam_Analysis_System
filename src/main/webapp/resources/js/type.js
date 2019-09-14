layui.use('table', function(){
    var table = layui.table;

    //第一个实例
    table.render({
        id:'typeTable',
        elem: '#demo'
        , toolbar: '#toolbars'
        , defaultToolbar: []
        ,url: ctx+'/type/getType' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'checkbox', type: 'checkbox'}
            ,{field: 'typeId', title: '题目类型ID', width:150,   align: 'center'}
            ,{field: 'typeName', title: '题目类型名', width:150,  align: 'center'}
            ,{field: 'createTime', title: '创建时间', width:250,  align: 'center'}
        ]]
        ,skin: 'line,row' //表格风格
        ,even: true
        ,limits: [5, 10, 15]
        ,limit: 10 //每页默认显示的数量
    });

    table.on('toolbar(typefilter)', function(obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        var  data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                layer.open({
                    id: 1,
                    type: 1,
                    title: ['题目类型添加'],
                    skin: 'layui-layer-molv',
                    area: '500px',
                    offset: 'auto',
                    content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
                        '    <div class="layui-col-md10">' +
                        '        <form class="layui-form">' +
                        '            <div class="layui-form-item">\n' +
                        '                <label class="layui-form-label" style="padding-left:-50px;">题目类型名:</label>\n' +
                        '                <div class="layui-input-block">\n' +
                        '                    <input type="text" placeholder="请输入题目类型名" name="typeName" id="typeName" class="layui-input">\n' +
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
                        var type={
                            typeName:  $.trim($('#typeName').val())
                        };
                        $.ajax({
                            url: ctx+'/type/insertType',
                            data:JSON.stringify(type),
                            dataType:'json',
                            type:'post',
                            contentType: 'application/json; charset=utf-8',
                            success: function(data) {
                                if(data==1){
                                    layer.alert('添加成功',function () {
                                        //关闭弹窗
                                        layer.closeAll();
                                        // 重新刷新表格
                                        table.reload('typeTable');
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
                    var typeId = data[0].typeId;
                    layer.confirm('是否删除？',{title:'提示'},function(index) {
                        $.ajax({
                            url: ctx+'/type/deleteType',
                            data:{typeId:typeId},
                            dataType:'json',
                            type:'get',
                            contentType: 'application/json; charset=utf-8',
                            success: function(data) {
                                if(data=="1"){
                                    layer.alert("删除成功",function () {
                                        //关闭弹窗
                                        layer.closeAll();
                                        // 重新刷新表格
                                        table.reload('typeTable');
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
                            '                <label class="layui-form-label" style="padding-left:-50px;">题目类型ID:</label>' +
                            '                <div class="layui-input-block">' +
                            '                    <input type="text"  name="typeId" id="typeId" class="layui-input" disabled="disabled">\n' +
                            '                </div>' +
                            '            </div>' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">题目类型名称:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text"   name="typeName" id="typeName" class="layui-input">\n' +
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
                            $('#typeId').val(data[0].typeId);
                            $('#typeName').val(data[0].typeName);
                            $('#createTime').val(data[0].createTime);
                        },
                        btn1: function(index) {
                            // 提交
                            var type={
                                typeId:data[0].typeId,
                                typeName:  $.trim($('#typeName').val())
                            };
                            $.ajax({
                                url: ctx+'/type/updateBType',
                                data:JSON.stringify(type),
                                dataType:'json',
                                type:'post',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data==1){
                                        layer.alert('修改成功',function () {
                                            layer.closeAll();
                                            table.reload('typeTable');
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