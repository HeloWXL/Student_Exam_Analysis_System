$(function () {
    layui.use(['form','table','upload'], function(){
        var table = layui.table;
        var form =layui.form;
        var querySelectQuestionVo = {
            courseName:'',
            level:''
        };
        // 加载表格数据
        loadData(table,querySelectQuestionVo);
        // 查询
        $('#query').click(function() {
            var querySelectQuestionVo = {
                courseName:$("input[name='courseName']").val(),
                level:$("input[name='level']").val(),
                typeId:$("select[name='typeId']").val()
            };
            loadData(table,querySelectQuestionVo);
        });
        $("#reset").click(function () {
            $("select").val("");
            $("input").val("");
            table.reload('selectQuestionTable');
        })
        table.on('toolbar(selectQuestionfilter)', function(obj) {
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
                            '                <label class="layui-form-label" style="padding-left:-50px;">选择题题目:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" placeholder="请输入选择题名称" name="text" id="text" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">A选项:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" name="optionA" id="optionA" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">B选项:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text"  name="optionB" id="optionB" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">C选项:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text"  name="optionC" id="optionC" class="layui-input">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="layui-form-item">\n' +
                            '                <label class="layui-form-label" style="padding-left:-50px;">D选项:</label>\n' +
                            '                <div class="layui-input-block">\n' +
                            '                    <input type="text" name="optionD" id="optionD" class="layui-input">\n' +
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
                            '    <div class="layui-input-block" id="Course">\n' +
                            '    </div>\n' +
                            '  </div>'+
                            '<div class="layui-form-item">\n' +
                            '    <label class="layui-form-label">难度:</label>\n' +
                            '    <div class="layui-input-block">\n' +
                            '      <select id="level">\n' +
                            '        <option value="">请选择题目难度</option>\n' +
                            '        <option value="1">1</option>\n' +
                            '        <option value="2">2</option>\n' +
                            '        <option value="3">3</option>\n' +
                            '        <option value="4">4</option>\n' +
                            '        <option value="5">5</option>\n' +
                            '      </select>\n' +
                            '    </div>\n' +
                            '  </div>'+
                            '<div class="layui-form-item">\n' +
                            '    <label class="layui-form-label">请选择题目类型:</label>\n' +
                            '    <div class="layui-input-block" id="TypeName">\n' +
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
                            $("#Course").append(loadCourseList())
                            $("#TypeName").append(loadType())
                            forms.render();
                            layero.find('.layui-layer-btn').css('text-align', 'center');
                            forms.render('select');
                        },
                        btn1: function(index) {
                            // 提交
                            var selectQuestion={
                                text:$.trim($('#text').val()),
                                answer:$.trim($('#answer').val()),
                                optionA:$.trim($('#optionA').val()),
                                optionB:$.trim($('#optionB').val()),
                                optionC:$.trim($('#optionC').val()),
                                optionD:$.trim($('#optionD').val()),
                                courseId:$.trim($('select[name="courseId"]').val()),
                                typeId:$.trim($('select[name="typeId"]').val()),
                                level:$.trim($('#level').val()),
                                knowledge:$.trim($('#knowledge').val()),
                            };
                            $.ajax({
                                url: ctx+'/selectquestion/insertSelectQuestion',
                                data:JSON.stringify(selectQuestion),
                                dataType:'json',
                                type:'post',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data==1){
                                        layer.alert('添加成功',function () {
                                            //关闭弹窗
                                            layer.closeAll();
                                            // 重新刷新表格
                                            table.reload('selectQuestionTable');
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
                        var selectId = data[0].selectId;
                        layer.confirm('是否删除？',{title:'提示'},function(index) {
                            $.ajax({
                                url: ctx+'/selectquestion/deleteSelectQuestion',
                                data:{selectId:selectId},
                                dataType:'json',
                                type:'get',
                                contentType: 'application/json; charset=utf-8',
                                success: function(data) {
                                    if(data==1){
                                        layer.alert("删除成功",function () {
                                            //关闭弹窗
                                            layer.closeAll();
                                            // 重新刷新表格
                                            table.reload('selectQuestionTable');
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
                                '                <label class="layui-form-label" style="padding-left:-50px;">选择题题目:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" placeholder="请输入课程名" name="text" id="text" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">A选项:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" name="optionA" id="optionA" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">B选项:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"  name="optionB" id="optionB" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">C选项:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text"  name="optionC" id="optionC" class="layui-input">\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '            <div class="layui-form-item">\n' +
                                '                <label class="layui-form-label" style="padding-left:-50px;">D选项:</label>\n' +
                                '                <div class="layui-input-block">\n' +
                                '                    <input type="text" name="optionD" id="optionD" class="layui-input">\n' +
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
                                '    <div class="layui-input-block" id="Course">\n' +
                                '    </div>\n' +
                                '</div>'+
                                '<div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">难度:</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <select id="level">\n' +
                                '        <option value="">请选择题目难度</option>\n' +
                                '        <option value="1">1</option>\n' +
                                '        <option value="2">2</option>\n' +
                                '        <option value="3">3</option>\n' +
                                '        <option value="4">4</option>\n' +
                                '        <option value="5">5</option>\n' +
                                '      </select>\n' +
                                '    </div>\n' +
                                '  </div>'+
                                '<div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">请选择题目类型:</label>\n' +
                                '    <div class="layui-input-block" id="TypeName">\n' +

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
                                form.render();
                                $("#Course").append(loadCourseList())
                                $("#TypeName").append(loadType())
                                layero.find('.layui-layer-btn').css('text-align', 'center');
                                // 展示在弹出层里面
                                $('#text').val(data[0].text);
                                $('#optionA').val(data[0].optionA);
                                $('#optionB').val(data[0].optionB);
                                $('#optionC').val(data[0].optionC);
                                $('#optionD').val(data[0].optionD);
                                $('#answer').val(data[0].answer);
                                $('select[name="courseId"]').val(data[0].courseId);
                                $('select[name="typeId"]').val(data[0].typeId);
                                $('#level').val(data[0].level);
                                $('#knowledge').val(data[0].knowledge);
                                form.render('select')
                            },
                            btn1: function(index) {
                                // 提交
                                var selectQuestion={
                                    selectId:data[0].selectId,
                                    text:$.trim($('#text').val()),
                                    answer:$.trim($('#answer').val()),
                                    optionA:$.trim($('#optionA').val()),
                                    optionB:$.trim($('#optionB').val()),
                                    optionC:$.trim($('#optionC').val()),
                                    optionD:$.trim($('#optionD').val()),
                                    courseId:$.trim($('select[name="courseId"]').val()),
                                    typeId:$.trim($('select[name="typeId"]').val()),
                                    level:$.trim($('#level').val()),
                                    knowledge:$.trim($('#knowledge').val())
                                };
                                $.ajax({
                                    url: ctx+'/selectquestion/updateSelectQuestion',
                                    data:JSON.stringify(selectQuestion),
                                    dataType:'json',
                                    type:'post',
                                    contentType: 'application/json; charset=utf-8',
                                    success: function(data) {
                                        if(data==1){
                                            layer.alert('修改成功',function () {
                                                //关闭弹窗
                                                layer.closeAll();
                                                // 重新刷新表格
                                                table.reload('selectQuestionTable');
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
                    break;
                case 'addmore':
                    layer.open({
                        id: 'addmore',
                        type: 1,
                        title: ['选择题批量导入'],
                        skin: 'layui-layer-molv',
                        area: '350px',
                        offset: 'auto',
                        content: '<div class="layui-row"  style="margin-top:10px;">' +
                            '    <div class="layui-col-md12" style="text-align: center">' +
                            '<div class="layui-upload" style="margin-bottom: 10px;">\n' +
                            '  <button type="button" class="layui-btn layui-btn-normal" id="uploadSelect">选择文件</button>\n' +
                            '  <button type="button" class="layui-btn" id="upload">开始上传</button>\n' +
                            '</div>'+
                            '    </div>\n' +
                            '</div>\n'
                        , success: function(layero) {
                            var upload  = layui.upload;
                            //选完文件后不自动上传
                            upload.render({
                                elem: '#uploadSelect'
                                ,url: ctx+'/selectquestion/uploadSelect'
                                ,auto: false
                                ,bindAction: '#upload'
                                ,done: function(res){
                                    layer.msg(res.msg)
                                }
                                ,accept: 'file'
                            });
                        }
                    });
                    break;
            }
        });
    });

    /***
     * @Author wangxl
     * @Description //加载选择题列表
     * @Date 1:16 上午 2019/10/9
     * @Param
     * @return
     **/
    function loadData(table,querySelectQuestionVo) {
        table.render({
            id: 'selectQuestionTable',
            elem: '#demo'
            , toolbar: '#toolbars'
            // , defaultToolbar: []
            , url: ctx + '/selectquestion/getSelectQuestion' //数据接口
            , method:'post'
            ,contentType: 'application/json; charset=utf-8'
            , page: true //开启分页
            ,where:querySelectQuestionVo
            , cols: [[ //表头
                {field: 'checkbox', type: 'checkbox'}
                , {field: 'number', title: '序号', type: 'numbers'}
                , {field: 'text', title: '题目', width: 200, align: 'center'}
                , {field: 'optionA', title: 'A选项', width: 100, align: 'center'}
                , {field: 'optionB', title: 'B选项', width: 100, align: 'center'}
                , {field: 'optionC', title: 'C选项', width: 100, align: 'center'}
                , {field: 'optionD', title: 'D选项', width: 100, align: 'center'}
                , {field: 'answer', title: '答案', width: 100, align: 'center'}
                , {field: 'courseName', title: '课程名', width: 120, align: 'center'}
                , {field: 'level', title: '难度等级', width: 100, align: 'center'}
                , {field: 'typeName', title: '能力类型', width: 120, align: 'center'}
                , {field: 'knowledge', title: '知识点', width: 180, align: 'center'}
                , {field: 'createTime', title: '创建时间', width: 200, align: 'center'}
            ]]
            , skin: 'line,row' //表格风格
            , even: true
            , limits: [5, 10, 15]
            , limit: 10 //每页默认显示的数量
        });
    }

    /***
     * @Author wangxl
     * @Description //加载课程列表
     * @Date 1:15 上午 2019/10/9
     * @Param
     * @return
     **/
    function loadCourseList(){
        var selectStr = "<select name=\"courseId\" >";
        $.ajax({
            url:ctx+'/course/getCourseList',
            dataType:'json',
            type:'get',
            async:false,
            success:function (data) {
                for(var i = 0 ;i<data.length;i++){
                    var node = ('<option value="'+data[i].courseId+'">'+data[i].courseName+'</option>');
                    selectStr+=node;
                }
            }
        })
        return selectStr+"</select>";
    }
    /***
     * @Author wangxl
     * @Description //加载类型列表
     * @Date 1:16 上午 2019/10/9
     * @Param
     * @return
     **/
    function loadType() {
        var typeStr = "<select name=\"typeId\" >";
        $.ajax({
            url:ctx+'/type/getTypeList',
            dataType:'json',
            type:'get',
            async:false,
            success:function (data) {
                for(var i = 0 ;i<data.length;i++){
                    var node = ('<option value="'+data[i].typeId+'">'+data[i].typeName+'</option>');
                    typeStr+=node;
                }
            }
        })
        return typeStr+"</select>";
    }
})

