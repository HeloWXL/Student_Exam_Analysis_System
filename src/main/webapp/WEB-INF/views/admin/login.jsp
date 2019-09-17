<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/12
  Time: 1:11 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>教师登录</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/plugins/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css">
    <script>
        var ctx = '${ctx}'
    </script>

<style> /*存储页面元素样式的 区域*/
*{/*选择页面所有标签*/
    margin:0;
}
html{
    height:100%; /*继承window高度*/
    font-size:16px;
}
body{ /*标签选择器	*/
    display:flex;
    /*主轴(默认横向)方向内部元素排列方式 : 居中*/
    justify-content:center;
    /*辅轴(默认纵向)方向内部元素排列方式 : 居中*/
    align-items:center;
    height:100%; /*继承html高度*/
    /*background-image:url('img/bg.png');*/
}
.login-wrap{/* 类选择器 .+类名{样式}*/
    width:300px; /*属性名称 : 属性值(单位) ;*/
    height:300px; /*高度*/
    /*背景 : 海牙蓝*/
    background-color:#ecf0f1;
    /*css3 圆角属性*/
    border-radius:10px;
}
.login-wrap:before{
    display:block; /*强制块元素显示*/
    content:''; /*激活*/
    width:100%;
    height:10px;
    background:-webkit-linear-gradient(left,#27ae60 0%,#27ae60 20%,#8E44AD 20%, #8E44AD 40%,#3498DB 40%,#3498DB 60%, #e74c3c 60%, #e74c3c 80%,#F1C40F 80%,#F1C40F 100%);
    /*css3 圆角 左上 右上 右下 左下*/
    border-radius:10px 10px 0 0;
}

.login-wrap h2{
    text-align:center;
    color:#368;
    line-height:80px;
    font-size:2em;
}

.login-wrap .login-container{
    display:flex;
    /*主轴方向设置为纵向(默认横向)*/
    flex-direction:column;
    justify-content:space-around;
    align-items:center;
    width:100%;
    height:200px;

}

.login-wrap .login-container input{
    width:80%;
    height:40px;
    border:1px solid #bbb;
    outline:0; /*聚焦框*/
    font-size:1em;
    text-indent:1em;
    border-radius:5px;
}
.login-wrap .login-container input[type='submit']{
    border:0;
    text-indent:0;
    background-color:#e74c3c;
    font-size:1.3em;
    color:#fff;
}
</style>
</head>
<body>

<div class='login-wrap'>
    <h2>管理员登录</h2>
    <form action="/admin/checkLogin" class='login-container' method="post">
        <input type='text' placeholder='请输入用户名' name='adminName' >
        <input type='password' placeholder='请输入密码' name='password'>
        <input type="hidden" value="${msg}" id="msg">
        <input type='submit' value='登录' id="submit">

    </form>
</div>

</body>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="${ctx}/resources/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.cookie.js"></script>


<script>

    if($('#msg').val()!=""){
        tankuan();
    }

    function tankuan(){
        layui.use(['layer','jquery','form','carousel','element','upload'],function() {
            var layer = layui.layer;//弹出层组件
            var form = layui.form;//表单组件
            var element = layui.element;
            var carousel = layui.carousel;//轮播组件
            var $ = layui.jquery;//jquery
            var upload = layui.upload;// 文件上传组件
            var error = "错误~";

            //提示密码错误
            if($('#msg').val()!=""){
                var str="${msg}";
                msg(str);
            }
            //设置弹框提示
            function msg(str, icon, offset) {
                str = str == null ? "没有内容" : str;
                offset = offset == null ? "20px" : offset;
                if (icon == null || icon == "") {
                    return layer.msg(str, {offset: offset});
                } else {
                    return layer.msg(str, {icon: icon}, {offset: offset});
                }
            }
        })
    }

</script>
</html>
