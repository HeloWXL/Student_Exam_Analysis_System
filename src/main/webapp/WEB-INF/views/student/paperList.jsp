<%--
  Created by IntelliJ IDEA.
  User: wangxianlin
  Date: 2019/9/13
  Time: 3:44 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>试卷列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="${ctx}/resources/css/mui.min.css" rel="stylesheet" />
    <link rel="icon" href="${ctx}/resources/ico/logo.ico"  type=”image/x-icon”>
    <script>
        var ctx = '${ctx}'
    </script>
    <style>
        .mui-card{
            border-radius: 5px;
        }
        #content{
            width: 100%;
            height: 100%;
        }
        img{
            margin: 6% 27%;
            width: 47%;
            height: 30%;
        }
        p{
            margin-left: 5px;
            margin-bottom: -2px;
            font-size: 13px;
        }
        .mui-bar{
              background-color: #1B8BF5;
          }
        .mui-title{
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">学生考试列表</h1>
</header>
<div class="mui-content">
    <div id="content">
        <c:forEach var="paper" items="${paperList}">
            <a class="paper">
                <div class="mui-card">
                    <!--页眉，放置标题-->
                    <input class="paperId" value="${paper.paperId}" type="hidden">
                    <div class="mui-card-header"><p>试卷名称：<span style="color: #000000;">${paper.paperName}</span></p></div>
                    <!--内容区-->
                    <div class="mui-card-content"><img src="${ctx}/resources/images/logo.png" /></div>
                    <!--页脚，放置补充信息或支持的操作-->
                    <div class="mui-card-footer">
                        <p>考试名称：<span>${paper.testName}</span></p>
                        <p>发布人：<span>${paper.adminName}</span></p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</body>
<%--引入js文件--%>
<script src="${ctx}/resources/js/jquery-2.1.4.js"></script>
<script src="${ctx}/resources/js/mui.min.js"></script>

<script>
    /***
     * @Author wangxl
     * @Description  判断学生是否登录
     * @Date 2019/10/14 10:27
     **/
    $(function () {
        if('${student}'==''){
            location.href=ctx+"/student/toLogin";
            return;
        }
        var studentId = '${student.studentId}'
        $(".mui-card").click(function () {
           var paperId = $(this).children('input').val();
            HasAttence(studentId,paperId);
        })
    })
    /***
     * @Author wangxl
     * @Description //判断学生是否已经参加过该场考试
     * @Date 12:34 上午 2019/10/17
     * @Param
     * @return
     **/
    function HasAttence(studentId,paperid) {
        $.ajax({
            url:ctx+'/answer/getAnswerByStudentIdAndPaperId',
            type:'get',
            dataType:'json',
            data:{studentId:studentId,paperId:paperid},
            success:function (data) {
                if(data==0){
                    location.href=ctx+"/student/toDeclaer/"+paperid;
                }else{
                    mui.alert("你已参加过本门考试，请勿重复参加考试！！！")
                    return;
                }
            }
        })
    }

</script>
</html>
