<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/13
  Time: 7:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>系统配置相关</title>
    <link href="${ctx}/resources/plugins/layui/css/layui.css" rel="stylesheet">
    <link rel="icon" href="${ctx}/resources/ico/logo.ico" type=”image/x-icon”>
    <script>
      var ctx = '${ctx}'
    </script>
</head>
<body>
<div class="layui-col-md12">
    <!-- 模块名 -->
    <blockquote class="layui-elem-quote">管理员信息相关</blockquote>
    <div class="tpl-card">
        <div class="card-pannel">
            <table class="layui-table" style="margin:0">
                <colgroup>
                    <col width="100">
                    <col>
                </colgroup>
                <tbody id="tbody">
                <tr>
                    <td>当前用户</td>
                    <td>${admin.adminName}</td>
                </tr>
                <tr>
                    <td>修改密码</td>
                    <td>
                        <div class="layui-input-inline">
                            输入新密码：
                        </div>
                        <div class="layui-input-inline">
                            <input type="password" name="password" autocomplete="off" class="layui-input"
                                   style="width: 100px">
                        </div>
                        &nbsp; &nbsp; &nbsp;
                        <div class="layui-input-inline">
                            确认新密码：
                        </div>
                        <div class="layui-input-inline">
                            <input type="password" name="checkPassword" autocomplete="off" class="layui-input"
                                   style="width: 100px">
                        </div>
                        &nbsp; &nbsp;
                        <button type="button" class="layui-btn layui-btn-normal" id="changePassWord">修改</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="center">
            <table id="adminDemo" lay-filter="adminTable"></table>
        </div>
        <div id="container" style="height:600px;margin-top: 50px;margin-left: 1%;margin-right: 1%"></div>
    </div>
</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>
<script>
  $(function() {
    if ('${admin.adminName}' == 'admin') {
      //先保存div中原来的html
      var html = document.getElementById("tbody").innerHTML;
      //再跟你想追加的代码加到一起插入div中
      document.getElementById("tbody").innerHTML = html + " <tr>\n" +
          "                    <td>添加用户</td>\n" +
          "                    <td>\n" +
          "\n" +
          "                        &nbsp; &nbsp; &nbsp; <div class=\"layui-input-inline\">\n" +
          "                            <label class=\"layui-form-label\" style='margin-left: -50px'>用户名：</label>\n" +
          "                            <input type=\"text\" name=\"addAdminName\" autocomplete=\"off\" class=\"layui-input\" style=\"width: 100px\">\n" +
          "                        </div>\n" +
          "\n" +
          "                        <div class=\"layui-input-inline\">\n" +
          "                            <label class=\"layui-form-label\">密码：</label>\n" +
          "                            <input type=\"password\" name=\"addPassword\" autocomplete=\"off\" class=\"layui-input\" style=\"width: 100px\">\n" +
          "                        </div>\n" +
          "                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
          "                        <button type=\"button\" class=\"layui-btn layui-btn-primary\" id=\"addAdmin\" >确定</button>\n" +
          "\n" +
          "                    </td>\n" +
          "                </tr>\n";
      $("#addAdmin").click(function() {
        var addAdmin = {
          adminName: $("input[name='addAdminName']").val(),
          adminPassword: $("input[name='addPassword']").val()
        };
        var admin = JSON.stringify(addAdmin);
        $.ajax({
          url: '/demo/admin/insertAdmin',
          data: admin,
          dataType: 'json',
          type: 'post',
          contentType: 'application/json; charset=utf-8',
          success: function(data) {
            parent.location.href = "/demo/admin/toIndex";
          }
        })
      })


      //管理员列表
      layui.use('table', function() {
        var table = layui.table;
        //第一个实例
        table.render({
          id: 'adminTable',
          elem: '#adminDemo'
          , defaultToolbar: []
          , url: ctx + '/admin/getAdmin' //数据接口
          , page: true //开启分页
          , cols: [[ //表头
            {field: 'number', title: '序号', type: 'numbers', align: 'center'}
            , {field: 'adminName', title: '管理员名称', width: 200}
            , {field: 'createTime', title: '创建时间', width: 200}
          ]]
          , skin: 'line,row' //表格风格
          , even: true
          , limits: [5, 10, 15]
          , limit: 10 //每页默认显示的数量
        });
      });


      //统计图
      $.ajax({
        url:ctx+'/student/getRigisteeStudentCount',
        dataType:'json',
        type:'get',
        success:function(data) {
          console.log(data);
        }
      })

    }
    $("#changePassWord").click(function() {

      var password = $("input[name='password']").val();
      var checkPassword = $("input[name='checkPassword']").val();
      if (password == checkPassword && password != "" && checkPassword != "") {
        $.ajax({
          url: '/demo/admin/changePassWord',
          data: {passWord: password},
          dataType: 'json',
          type: 'post',
          success: function(data) {
            parent.location.href = "/demo/admin/toLogin";
          }

        })
      } else {
        if (password == "" || checkPassword == "") {
          layui.use('layer', function() {
            layer.msg("密码不得为空！");
          });
        } else {
          layui.use('layer', function() {
            layer.msg("前后两次密码输入不一致！");
          });
        }
      }
    })

    //获取注册学生人数函数 ---统计图
    function getStudentRigisterCount(data) {
      var dom = document.getElementById("container");
      var myChart2 = echarts.init(dom, 'light');
      option = {
        title: {
          text: '注册人数统计'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          }
        },
        legend: {
          data: ['学生人数统计']
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '邮件营销',
            type: 'line',
            stack: '总量',
            areaStyle: {
              normal: {
                show: true,
                position: 'top'
              }
            },
            data: data
          }
        ]
      };
      if (option && typeof option === "object") {
        myChart.setOption(option, true);
      }
    }
  });
</script>
</html>
