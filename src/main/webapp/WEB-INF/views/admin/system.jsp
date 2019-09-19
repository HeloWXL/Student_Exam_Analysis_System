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
                <tbody>
                <tr>
                    <td>当前用户</td>
                    <td>${admin.adminName}</td>
                </tr>
                <tr>
                    <td>修改密码</td>
                    <td>
                        <div class="layui-input-inline">
                        <input type="password" name="password" autocomplete="off" class="layui-input" style="width: 100px">
                        </div>
                        <button type="button" class="layui-btn layui-btn-primary" id="changePassWord" >修改</button>

                    </td>


                </tr>

                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="${ctx}/resources/plugins/layui/layui.js" type="application/javascript"></script>

<script>


    $("#changePassWord").click(function (){
        var password=$("input[name='password']").val();
        $.ajax({
            url:'/admin/changePassWord',
            data:{passWord:password},
            dataType:'json',
            type:'post',
            success: function(data) {
                parent.location.href="/admin/toLogin";
            }

        })
    })


</script>
</html>
