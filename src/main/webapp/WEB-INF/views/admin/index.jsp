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
    <meta charset="utf-8">
    <title>教师首页</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/plugins/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/global_style.css">
    <script>
        var ctx = '${ctx}'
    </script>
</head>
<body>
<div class="tm-tpl tpl-white-hn" style-name="tpl-white-hn">
    <!--导航栏-->
    <div class="tpl-left-sidebar">
        <ul>
            <li class="logo">
                <img class="user-upload" src="${ctx}/resources/images/4a251abe82900c79733daa753664f701.jpg" alt="admin" title="admin">
                <span>王咸林</span>
            </li>
            <!--<li class="nav-item active">
        <a href="index.html" class="a-item"><i class="fa fa-home nav-icon" aria-hidden="true"></i><span>首页</span></a>
        </li>
         -->
            <li class="nav-item">
                <a href="" class="a-item"><i class="fa fa-home nav-icon"></i><span>首页</span></a>
            </li>

            <li class="nav-item">
                <a class="a-item" id="student"><i class="fa fa-fire nav-icon" ></i><span>学生管理</span></a>
            </li>
            <li class="nav-item">
                <a class="a-item" name="select"><i class="fa fa-users nav-icon"></i><span>题库管理</span></a>
                <ul class="nav-child-item has-child">
                    <div class="nav-child-list">
                        <li><a  name="select"><i class="fa fa-user-secret" aria-hidden="true"></i>选择题题库</a></li>
                        <li><a  id="completion"><i class="fa fa-users" aria-hidden="true"></i>填空题题库</a></li>
                    </div>
                </ul>
            </li>
            <li class="nav-item">
                <a class="a-item" id="test"><i class="fa fa-users nav-icon"></i><span>考试管理</span></a>
            </li>
            <li class="nav-item">
                <a class="a-item" id="course"><i class="fa fa-users nav-icon"></i><span>课程管理</span></a>
            </li>
            <li class="nav-item">
                <a class="a-item" id="paper"><i class="fa fa-users nav-icon"></i><span>试卷管理</span></a>
            </li>
            <li class="nav-item">
                <a class="a-item" id="type"><i class="fa fa-users nav-icon"></i><span>题目类型管理</span></a>
            </li>
            <li class="nav-item">
                <a  class="a-item"><i class="fa fa-users nav-icon"></i><span>学生报告管理</span></a>
            </li>
            <div class="sidebar-footer">
                <ul class="clearfix">
                    <!-- 		<a href="javascript:;" data-title="消息"><i class="fa fa-bell-o"></i><span class="badge">99+</span></a> -->
                    <a href="javascript:;" class="dashboard" tag="style-bar" data-title="配色方案"> <i class="fa fa-dashboard "></i></a>
                    <a href="javascript:;" class="user" tag="user-bar" data-title="个人中心"><i class="fa fa-user"></i></a>
                </ul>
            </div>
        </ul>
    </div>
    <!--右侧内容-->
    <div class="tpl-right-item">
        <div class="tpl-body">
            <!--头部-->
            <div class="tpl-header">
                <div class="tpl-header-fluid">
                    <div class="tpl-button switch-list">
                        <i class="fa fa-hand-o-left"></i>
                    </div>
                    <div class="tpl-button text">
                        <a href=""><i class="fa fa-home"></i> 首页</a>
                    </div>
                    <div class="tpl-userbar">
                        <ul>
                            <li><a href="javascript:;" class="dashboard" tag="style-bar"><i class="fa fa-dashboard"></i></a></li>
                            <li><a href="">欢迎你，admin</a></li>
                            <li><a href="javascript:;" class="logout"><i class="fa fa-power-off"></i>退出登录</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--内容-->
            <div class="tpl-content">

                <div class="content-pannel clearfix">
                    <iframe align="center" width="100%" height="100%" src="/admin/toSystem" frameborder="no" border="0" marginwidth="0"
                            marginheight="20px" scrolling="no" style="background-color: #FFFFFF;"></iframe>
                </div>

                <!--配色方案-->
                <div class="right-bar style-bar">
                    <div class="right-bar-fluid">
                        <div class="tpl-header-text">
                            配色方案
                        </div>
                        <ul class="style-item clearfix" id="style-list">
                            <li data-style="tpl-black-n">
                                <div class="header-style"></div>
                                <div class="left-style black">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-black-hn">
                                <div class="header-style black-child"></div>
                                <div class="left-style black">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-red-hn">
                                <div class="header-style red-child"></div>
                                <div class="left-style red">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-red-n">
                                <div class="header-style"></div>
                                <div class="left-style red">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-blackred-hn">
                                <div class="header-style red"></div>
                                <div class="left-style black">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-blackgreen-hn">
                                <div class="header-style green"></div>
                                <div class="left-style black">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-green-hn">
                                <div class="header-style green-child"></div>
                                <div class="left-style green">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-green-n">
                                <div class="header-style"></div>
                                <div class="left-style green">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                            <li data-style="tpl-white-hn">
                                <div class="header-style"></div>
                                <div class="left-style white">
                                    <div class="logo-style"></div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--用户信息-->
                <div class="right-bar user-bar">
                    <div class="right-bar-fluid">
                        <div class="tpl-card">
                            <div class="card-pannel">
                                <div class="user-item">
                                    <img class="user-upload" src="${ctx}/resources/images/4a251abe82900c79733daa753664f701.jpg">
                                    <h4 class="user-name">admin</h4>
                                    <p>时间模糊了很多东西，我依然爱你</p>
                                    <div class="user-tips">
                                        <a href="javascript:;" data-tips="15606981928"><i class="fa fa-phone"></i></a>
                                        <a href="javascript:;" data-tips="you can goin!"><i class="fa fa-star"></i></a>
                                        <a href="javascript:;" data-tips="756316064"><i class="fa fa-qq"></i></a>
                                        <a href="javascript:;" data-tips="wangxianlin756316064"><i class="fa fa-wechat"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--尾部-->
                <div class="tpl-footer">
                    <div class="tpl-footer-fluid">
                        <a class="f-item-text">学生考试成绩分析系统</a>
                        <a class="f-item-text">Author By wangxianlin@.icloud.com</a>
                        <a class="fitem-texy">2019 version:1.0 ©</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript" src="${ctx}/resources/plugins/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/admin.js"></script>

<script>
    if('${admin}'==""){
        location.href="/admin/toLogin";
    }

</script>
</body>
</html>
