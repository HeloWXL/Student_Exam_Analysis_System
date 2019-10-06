<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/12
  Time: 1:12 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生注册</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" href="${ctx}/resources/css/common.css" />
    <link rel="stylesheet" href="${ctx}/resources/css/login.css" />
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>

    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>
<div id="login"></div>
<div class="login_bg">
    <div id="logo">
        <img src="${ctx}/resources/images/logo.png" alt="" />
    </div>
    <form>
        <div class="userName">
            <lable>姓名：</lable>
            <input type="text" name="name" placeholder="请输入真实姓名" required />
        </div>
        <div class="passWord">
            <lable>手机号码：</lable>
            <input type="text" name="phone" placeholder="请输入手机号码" required />
        </div>
        <div class="passWord">
            <lable>密&nbsp;&nbsp;&nbsp;码：</lable>
            <input type="password" name="password" placeholder="请输入密码" required />
        </div>
        <div class="passWord">
            <lable>确认密码：</lable>
            <input type="password" name="passwordConfirm" placeholder="请输入密码" required />
        </div>
        <div class="choose_box">
            <a href="/demo/student/toLogin">已有账号？登录</a>
        </div>
        <button class="login_btn" type="button" style="margin-top: 10px;" id="register">注&nbsp;&nbsp;册</button>
    </form>

</div>
</body>
<script src="${ctx}/resources/js/mui.min.js"></script>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
    mui.init()
    $(function () {
        $("#register").click(function () {
            var name = $.trim($("input[name='name']").val());
            var phone = $.trim($("input[name='phone']").val());
            var password = $.trim($("input[name='password']").val());
            var passwordConfirm = $.trim($("input[name='passwordConfirm']").val());

            if(password!=passwordConfirm){
                mui.alert("密码不一致")
            }else{
                var student={
                    studentName:name,
                    studentPhone:phone,
                    studentPassword:password
                }
                register(student);
            }
        })
    })
    //登录函数
    function register(student) {
        $.ajax({
            url:'/student/insertStudent',
            data:JSON.stringify(student),
            dataType:'json',
            type:'post',
            contentType:'application/json;charset=UTF-8',
            success:function (data) {
                console.log(data)
                if(data==1){
                    mui.alert("注册成功",function () {
                        location.href=ctx+'/student/toLogin';
                    })
                }else{
                    mui.alert("注册失败",function () {
                        $("input[name='name']").val('');
                        $("input[name='phone']").val('');
                        $("input[name='password']").val('');
                        $("input[name='passwordConfirm']").val('');
                    })
                }
            },error:function (e) {
                mui.alert("服务起内部错误")
            }
        })
    }
</script>
</html>
