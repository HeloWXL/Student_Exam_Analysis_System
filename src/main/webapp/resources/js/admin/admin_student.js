layui.use('table', function() {
  var table = layui.table;

  var queryStudentVo = {
    studentName: '',
    studentPhone: ''
  };

  // 加载表格数据
  loadData(table, queryStudentVo);
  // 查询
  $('#query').click(function() {

    var queryStudentVo = {
      studentName: $('input[name=\'userName\']').val(),
      studentPhone: $('input[name=\'phone\']').val()
    };
    loadData(table, queryStudentVo);
  });

  //加载列表数据
  function loadData(table, queryStudentVo) {
    table.render({
      id: 'studentTable',
      elem: '#demo'
      , toolbar: '#toolbars'
      , method: 'post'
      , contentType: 'application/json; charset=utf-8'
      , defaultToolbar: []
      , where: queryStudentVo
      , url: ctx + '/student/getStudent' //数据接口
      , page: true //开启分页
      , cols: [[ //表头
        {field: 'checkbox', type: 'checkbox'}
        , {field: 'number', title: '序号', type: 'numbers'}
        , {field: 'studentName', title: '学生姓名', width: 200}
        , {field: 'studentPhone', title: '手机号码', width: 200}
        , {field: 'createTime', title: '创建时间', width: 200}
      ]]
      , skin: 'line,row' //表格风格
      , even: true
      , limits: [5, 10, 15]
      , limit: 10 //每页默认显示的数量
    });
  }

  table.on('toolbar(studentfilter)', function(obj) {
    var checkStatus = table.checkStatus(obj.config.id);
    var data = checkStatus.data; //获取选中的数据
    switch (obj.event) {
      case 'add':
        layer.open({
          id: 1,
          type: 1,
          title: ['添加学生'],
          skin: 'layui-layer-molv',
          area: '500px',
          offset: 'auto',
          content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
          '    <div class="layui-col-md10">' +
          '        <form class="layui-form">' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">学生姓名:</label>\n' +
          '                <div class="layui-input-block">\n' +
          '                    <input type="text" placeholder="请输入学生姓名" name="studentName" id="studentName" class="layui-input">\n' +
          '                </div>\n' +
          '            </div>\n' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">手机号码:</label>\n' +
          '                <div class="layui-input-block">\n' +
          '                    <input type="text" placeholder="请输入手机号码" name="studentPhone" id="studentPhone" class="layui-input">\n' +
          '                </div>\n' +
          '            </div>\n' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">学生密码:</label>\n' +
          '                <div class="layui-input-block">\n' +
          '                    <input type="text" placeholder="请输入学生密码" name="studentPassword" id="studentPassword" class="layui-input">\n' +
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
            //数据校验
            var studentPhone = $.trim($('#studentPhone').val());
            if(studentPhone==null&&studentPhone==''){
              layer.msg("手机号码不能为空",{icon:5,time:1500});
              return;
            }
            var studentName = $.trim($('#studentName').val());
            if(studentName==null&&studentName==''){
              layer.msg("姓名不能为空",{icon:5,time:1500});
              return;
            }
            var studentPassword = $.trim($('#studentPassword').val());
            if(studentPassword==null&&studentPassword==''){
              layer.msg("密码不能为空",{icon:5,time:1500});
              return;
            }
            // 提交
            var student = {
              studentPhone: studentPhone,
              studentName: studentName,
              studentPassword: studentPassword
            };
            $.ajax({
              url: ctx + '/student/insertStudent',
              data: JSON.stringify(student),
              dataType: 'json',
              type: 'post',
              contentType: 'application/json; charset=utf-8',
              success: function(data) {
                if (data == 1) {
                  layer.alert('添加成功',{icon:1,time:1500}, function() {
                    //关闭弹窗
                    layer.closeAll();
                    // 重新刷新表格
                    table.reload('studentTable');
                  });
                } else {
                  layer.msg('添加失败',{icon:5,time:1500});
                }
              }, error: function(e) {
                layer.msg('服务器内部错误');
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
          var studentId = data[0].studentId;
          layer.confirm('是否删除？', {title: '提示'}, function(index) {
            $.ajax({
              url: ctx + '/student/deleteStudent',
              data: {studentId: studentId},
              dataType: 'json',
              type: 'get',
              contentType: 'application/json; charset=utf-8',
              success: function(data) {
                if (data == 1) {
                  layer.msg('删除成功',{icon:1,time:1500}, function() {
                    //关闭弹窗
                    layer.closeAll();
                    // 重新刷新表格
                    table.reload('studentTable');
                  });
                } else {
                  layer.msg('删除失败',{icon:5,time:1500});
                }
              }
            });
          });
        }
        break;
      case 'update':
        if (data.length == 0) {
          layer.msg('请选择一行');
        } else if (data.length > 1) {
          layer.msg('只能选择一行');
        } else {
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
            '                <label class="layui-form-label" style="padding-left:-50px;">学生姓名:</label>\n' +
            '                <div class="layui-input-block">\n' +
            '                    <input type="text"   name="studentName" id="studentName" class="layui-input" disabled="disabled">\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="layui-form-item">\n' +
            '                <label class="layui-form-label" style="padding-left:-50px;">手机号码:</label>\n' +
            '                <div class="layui-input-block">\n' +
            '                    <input type="text"   name="studentPhone" id="studentPhone" class="layui-input" disabled="disabled">\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="layui-form-item">\n' +
            '                <label class="layui-form-label" style="padding-left:-50px;">学生密码:</label>\n' +
            '                <div class="layui-input-block">\n' +
            '                    <input type="text"   name="studentPassword" id="studentPassword" class="layui-input">\n' +
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
              $('#studentName').val(data[0].studentName);
              $('#studentPhone').val(data[0].studentPhone);
              $('#studentPassword').val();
              $('#createTime').val(data[0].createTime);
            },
            btn1: function(index) {
              //数据校验
              var studentPassword = $.trim($('#studentPassword').val());
              if(studentPassword==null&&studentPassword==''){
                layer.msg("密码不能为空",{icon:5,time:1500});
                return;
              }
              // 提交
              var student = {
                studentId: data[0].studentId,
                studentPassword: studentPassword
              };
              $.ajax({
                url: ctx + '/student/updateStudentPasswordByAdmin',
                data: JSON.stringify(student),
                dataType: 'json',
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                success: function(data) {
                  if (data == 1) {
                    layer.alert('修改成功', function() {
                      layer.closeAll();
                      table.reload('studentTable');
                    });
                  } else {
                    layer.msg('修改失败',{icon:5,time:1500});
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
