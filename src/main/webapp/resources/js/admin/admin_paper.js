layui.use(['table','form'], function(){
  var table = layui.table;
  var form = layui.form;
  form.render();
  var paperTestAdminVo = {
    paperName:''
  };
  // 加载表格数据
  loadData(table,paperTestAdminVo);
  // 查询
  $('#query').click(function() {
    var paperTestAdminVo = {
      paperName:$("input[name='paperName']").val()
    };
    loadData(table,paperTestAdminVo,form);
  });
  //监听试卷状态操作
  form.on('switch(sexDemo)', function(obj){
    var paperId = this.value;
    var paperName = this.name;
    if(obj.elem.checked == false){
      setPaperStateClose(paperId,paperName,table);
      table.reload('paperTable');
    }else{
      setPaperStateOpen(paperId,paperName,table)
      table.reload('paperTable');
    }
  });
  table.on('toolbar(paperfilter)', function(obj) {
    var checkStatus = table.checkStatus(obj.config.id);5
    var  data = checkStatus.data; //获取选中的数据
    switch (obj.event) {
      case 'add':
        layer.open({
          id: 1,
          type: 1,
          title: ['添加试卷'],
          skin: 'layui-layer-molv',
          area: '500px',
          offset: 'auto',
          content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
          '    <div class="layui-col-md10">' +
          '        <form class="layui-form">' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">试卷名称:</label>' +
          '                <div class="layui-input-block">' +
          '                    <input type="text" placeholder="请输入考试名称"  name="paperName" id="paperName" class="layui-input">\n' +
          '                </div>' +
          '            </div>' +
          '<div class="layui-form-item">\n' +
          '    <label class="layui-form-label">考试名称：</label>\n' +
          '    <div class="layui-input-block" id="testName">\n' +
          '    </div>\n' +
          '  </div>'+
              '<div class="layui-form-item">\n' +
              '    <label class="layui-form-label">课程名称：</label>\n' +
              '    <div class="layui-input-block" id="courseName">\n' +
              '    </div>\n' +
              '  </div>'+
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">选择题数量:</label>' +
          '                <div class="layui-input-block">' +
          '                    <input type="text" placeholder="请输入选择题数量" lay-verify="required|number"  name="selectNum" id="selectNum" class="layui-input">\n' +
          '                </div>' +
          '            </div>' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">选择题分数:</label>' +
          '                <div class="layui-input-block">' +
          '                    <input type="text" placeholder="请输入选择题分数" lay-verify="required|number" name="selectScore" id="selectScore" class="layui-input">\n' +
          '                </div>' +
          '            </div>' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">填空题数量:</label>' +
          '                <div class="layui-input-block">' +
          '                    <input type="text" placeholder="请输入填空题数量" lay-verify="required|number"  name="completionNum" id="completionNum" class="layui-input">\n' +
          '                </div>' +
          '            </div>' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">填空题分数:</label>' +
          '                <div class="layui-input-block">' +
          '                    <input type="text" placeholder="请输入填空题分数" lay-verify="required|number" name="completionScore" id="completionScore" class="layui-input">\n' +
          '                </div>' +
          '            </div>' +
          '            <div class="layui-form-item">\n' +
          '                <label class="layui-form-label" style="padding-left:-50px;">总分:</label>' +
          '                <div class="layui-input-block">' +
          '                    <input type="text" name="scoreSum" id="scoreSum" class="layui-input">\n' +
          '                </div>' +
          '            </div>' +
          '        </form>\n' +
          '    </div>\n' +
          '</div>\n',
          btn: ['随机组卷', '取消']
          , success: function(layero) {
            var forms = layui.form;
            //加载考试列表
            $("#testName").append(loadSTest())
            $("#courseName").append(loadCourseList())
            layero.find('.layui-layer-btn').css('text-align', 'center');
            forms.render('select');
          },
          btn1: function(index) {

            //选择题数量
            var selectNum =parseInt($("#selectNum").val());
            //选择题分数
            var selectScore = parseInt($("#selectScore").val());
            //填空题数量
            var completionNum =parseInt($("#completionNum").val());
            //填空题分数
            var completionScore = parseInt($("#completionScore").val());
            $("#scoreSum").val(selectNum*selectScore + completionNum*completionScore);
            var scoreSum = $("#scoreSum").val();


            if(scoreSum!='100'){
              layer.msg("试卷总分数错误")
              return ;
            }else{
              // 提交
              $.ajax({
                url: ctx+'/paper/getPaperByAuto',
                data:{
                  testId:  $.trim($("select[name='testId']").val()),
                  paperName : $.trim($("#paperName").val()),
                  completionNum : completionNum,
                  selectNum : selectNum,
                  selectScore:selectScore,
                  completionScore:completionScore,
                  courseId:$.trim($("select[name='courseId']").val())
                },
                dataType:'json',
                type:'get',
                contentType: 'application/json; charset=utf-8',
                success: function(data) {
                  if(data==1){
                    layer.alert('添加成功',function () {
                      //关闭弹窗
                      layer.closeAll();
                      // 重新刷新表格
                      table.reload('paperTable');
                    });
                  }else{
                    layer.alert("添加失败，题库数量不足")
                  }
                }
              });
            }
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
          var paperId = data[0].paperId;
          layer.confirm('是否删除？',{title:'提示'},function(index) {
            $.ajax({
              url: ctx+'/paper/deletePaper',
              data:{paperId:paperId},
              dataType:'json',
              type:'get',
              contentType: 'application/json; charset=utf-8',
              success: function(data) {
                if(data==1){
                  layer.alert('删除成功',function () {
                    //关闭弹窗
                    layer.closeAll();
                    // 重新刷新表格
                    table.reload('paperTable');
                  });
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
            title: ['修改试卷'],
            skin: 'layui-layer-molv',
            area: '500px',
            offset: 'auto',
            content: '<div class="layui-row" id="test" style="margin-top:10px;">' +
            '    <div class="layui-col-md10">' +
            '        <form class="layui-form">' +
            '            <div class="layui-form-item">\n' +
            '                <label class="layui-form-label" style="padding-left:-50px;">试卷名称:</label>' +
            '                <div class="layui-input-block">' +
            '                    <input type="text" placeholder="请输入考试名称" lay-verify="questionnaireName" name="paperName" id="paperName" class="layui-input">\n' +
            '                </div>' +
            '            </div>' +
            '<div class="layui-form-item">\n' +
            '    <label class="layui-form-label">考试名称：</label>\n' +
            '    <div class="layui-input-block">\n' +
            '      <select name="testId" >\n' +
            '        <option value=""></option>\n' +
            '        <option value="1">数学考试</option>\n' +
            '        <option value="2">语文考试</option>\n' +
            '        <option value="3">英语考试</option>\n' +
            '      </select>\n' +
            '    </div>\n'+
            '            <div class="layui-form-item">\n' +
            '                <label class="layui-form-label" style="padding-left:-50px;">选择题数量:</label>\n' +
            '                <div class="layui-input-block">\n' +
            '                    <input type="text"  lay-verify="questionnaireName" name="selectNum" id="selectNum" class="layui-input">\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="layui-form-item">\n' +
            '                <label class="layui-form-label" style="padding-left:-50px;">填空题数量:</label>\n' +
            '                <div class="layui-input-block">\n' +
            '                    <input type="text"  lay-verify="questionnaireName" placeholder="请输入HTML片段" name="completionNum" id="completionNum" class="layui-input">\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </form>\n' +
            '    </div>\n' +
            '</div>\n',
            btn: ['提交', '取消']
            , success: function(layero) {
              var form  = layui.form;
              layero.find('.layui-layer-btn').css('text-align', 'center');
              // 展示在弹出层里面
              $('#paperName').val(data[0].paperName);
              $('select[name="testId"]').val(data[0].testId);
              form.render('select');
            },
            btn1: function(index) {
              // 提交
              var paper={
                paperId:data[0].paperId,
                paperName:  $.trim($('#paperName').val()),
                testId : $.trim($('select[name="testId"]').val())
              };
              $.ajax({
                url: ctx+'/paper/updatePaper',
                data:JSON.stringify(paper),
                dataType:'json',
                type:'post',
                contentType: 'application/json; charset=utf-8',
                success: function(data) {
                  if(data==1){
                    layer.alert('修改成功',function () {
                      //关闭弹窗
                      layer.closeAll();
                      // 重新刷新表格
                      table.reload('paperTable');
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
  //加载试卷
  function loadData(table,paperTestAdminVo,form) {
    table.render({
      id: 'paperTable',
      elem: '#demo'
      , toolbar: '#toolbars'
      , defaultToolbar: []
      , url: ctx + '/paper/getPaper' //数据接口
      , page: true //开启分页
      , method:'post'
      ,contentType: 'application/json; charset=utf-8'
      ,where:paperTestAdminVo
      , cols: [[ //表头
        {field: 'checkbox', type: 'checkbox'}
        , {field: 'number', title: '序号', type: 'numbers', align: 'center'}
        , {field: 'paperName', title: '试卷名称', width: 200, align: 'center'}
        , {field: 'testName', title: '考试名称', width: 200, align: 'center'}
        , {field: 'time', title: '考试时间', width: 120, align: 'center'}
        , {field: 'adminName', title: '发布人', width: 150, align: 'center'}
        , {field: 'createTime', title: '创建时间', width: 200, align: 'center'}
        , {
          field: 'state', title: '试卷状态', width: 120, templet: function (d) {
            if (d.state == 1) {
              return '<span style="color: green;">已启用</span>'
            } else {
              return '<span style="color: red;">未启用</span>'
            }
          }
        }
        , {title: '是否启用', width: 120, align: 'center', toolbar: '#barDemo'}
      ]]
      , skin: 'line,row' //表格风格
      , even: true
      , limits: [10, 15, 20]
      , limit: 10 //每页默认显示的数量
    });
    //监听锁定操作
    // form.on('switch(sexDemo)', function(data){
    //     layer.tips(this.value + ' ' + this.name + '：'+ data.elem.checked, data.othis);
    // });
  }
  //动态加载考试名称
  function loadSTest(){
    var selectStr = "<select name=\"testId\" >";
    $.ajax({
      url:ctx+'/test/getTestAdmin',
      dataType:'json',
      type:'get',
      async:false,
      success:function (data) {
        for(var i = 0 ;i<data.length;i++){
          var node = ('<option value="'+data[i].testId+'">'+data[i].testName+'</option>');
          selectStr+=node;
        }
      }
    })
    return selectStr+"</select>";
  }
  // 动态加载课程
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
  //启用试卷
  function setPaperStateOpen(paperId,paperName) {
    $.ajax({
      url:ctx+'/paper/setPaperStateOpen',
      dataType:'json',
      data:{paperId:paperId},
      type:'get',
      success:function (data) {
        if(data==1){
          layer.msg(paperName+"已启用")
        }else{
          layer.msg("参数错误")
        }
      }
    })
  }
  //关闭试卷
  function setPaperStateClose(paperId,paperName) {
    $.ajax({
      url:ctx+'/paper/setPaperStateClose',
      dataType:'json',
      data:{paperId:paperId},
      type:'get',
      success:function (data) {
        if(data==1){
          layer.msg(paperName+"已关闭")
        }else{
          layer.msg("参数错误")
        }
      }
    })
  }
});