layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    table.render({
        id:'LogTable',
        elem: '#demo'
        , toolbar: '#toolbars'
        , defaultToolbar: []
        ,url: ctx+'/loginLogApi/getLoginLog' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'number', title: '序号', type: 'numbers', align: 'center'}
            ,{field: 'ip', title: 'IP地址', width:200}
            ,{field: 'studentName', title: '用户', width:200}
            ,{field: 'lastTime', title: '上次登录时间', width:200}
        ]]
        ,skin: 'line,row' //表格风格
        ,even: true
        ,limits: [5, 10, 15]
        ,limit: 10 //每页默认显示的数量
    });
});