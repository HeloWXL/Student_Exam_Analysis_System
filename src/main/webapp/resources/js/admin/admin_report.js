layui.use('table', function() {
  var table = layui.table;

  var queryReportVo = {
    reportName: '',
    studentName: '',
    paperName: '',
    className: ''
  };

  // 加载表格数据
  loadData(table, queryReportVo);
  // 查询
  $('#query').click(function() {

    var queryReportVo = {
      reportName: $('input[name=\'reportName\']').val(),
      studentName: $('input[name=\'studentName\']').val(),
      paperName: $('input[name=\'paperName\']').val(),
      className: $('input[name=\'className\']').val()
    };
    loadData(table, queryReportVo);
  });


  //加载列表数据
  function loadData(table, queryReportVo) {
    table.render({
      id: 'reportTable',
      elem: '#demo'
      , toolbar: '#toolbars'
      , method: 'post'
      , contentType: 'application/json; charset=utf-8'
      , defaultToolbar: []
      , where: queryReportVo
      , url: ctx + '/report/getReport' //数据接口
      , page: true //开启分页
      , cols: [[ //表头
        {field: 'number', title: '序号', align: 'center',type: 'numbers'}
        , {field: 'reportName', title: '报告名称',align: 'center', width: 150}
        , {field: 'studentName', title: '学生姓名',align: 'center', width: 150}
        , {field: 'paperName', title: '试卷名称', align: 'center',width: 303}
        , {field: 'score', title: '考试分数',align: 'center', width: 150}
        , {field: 'className', title: '推荐班级',align: 'center', width: 150}
        , {field: 'createTime', title: '交卷时间',align: 'center', width: 200}
        , {width: 178, align: 'center', toolbar: '#barDemo'}
      ]]
      , skin: 'line,row' //表格风格
      , even: true
      , limits: [10, 15, 20]
      , limit: 10 //每页默认显示的数量
    });
  }

  //监听工具条
  table.on('tool(reporftilter)', function(obj) {
    var data = obj.data;
    if (obj.event === 'detail') {
      layer.open({
        id: 'report',
        title: [data.reportName],
        type: 2,
        anim: 1,
        skin: 'layui-layer-molv',
        area: ['800px','600px'],
        offset: 'auto',
        content: ctx + '/student/toReport/' + data.paperId + '/' + data.studentId//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      });
    }
  });
});
