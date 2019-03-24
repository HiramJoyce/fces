<%--
  Created by IntelliJ IDEA.
  User: chlia
  Date: 2019/3/22
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Class Manage</title>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="${ctx}/resource/twts_122_now-ui/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/resource/twts_122_now-ui/assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet"/>
</head>
<body>
<div class="page-container">
    <div class="wrapper ">
        <div class="sidebar" data-color="blue">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
            <div class="logo">
                <a href="#" class="simple-text">
                    翻转课堂学生系统
                </a>
            </div>
            <div class="sidebar-wrapper">
                <ul class="nav">
                    <li class="active">
                        <a href="${ctx}/student/class">
                            <i class="now-ui-icons design_app"></i>
                            <p>我的课堂</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-transparent  navbar-absolute bg-primary fixed-top">
                <div class="container-fluid">
                    <div class="navbar-wrapper">
                        <div class="navbar-toggle">
                            <button type="button" class="navbar-toggler">
                                <span class="navbar-toggler-bar bar1"></span>
                                <span class="navbar-toggler-bar bar2"></span>
                                <span class="navbar-toggler-bar bar3"></span>
                            </button>
                        </div>
                        <a class="navbar-brand" href="#pablo">我的课堂</a>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                            aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <form style="margin: 0;">
                            <div class="input-group no-border">
                                <input type="text" value="" class="form-control" placeholder="Search...">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons ui-1_zoom-bold"></i>
                                </span>
                            </div>
                        </form>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="${ctx}/logout">
                                    <i class="now-ui-icons users_single-02"></i>
                                    <p>
                                        <span class="d-lg-none d-md-block">Account</span>
                                    </p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="panel-header panel-header-sm">
            </div>

            <div class="content">
                <div class="row">
                    <div class="col-md-6">
                        <div class="card card-chart">
                            <form id="clazz" action="${ctx}/student/student/score" method="post" accept-charset="UTF-8">
                                <input type="hidden" name="studentId" value="${student.id}">
                                <input type="hidden" name="clazzId" value="${clazz.id}">
                                <div class="card-header">
                                    <h4 class="card-title"> 学生评分</h4>
                                    <div class="dropdown">
                                        <button type="submit"
                                                class="btn btn-round btn-success btn-simple btn-icon no-caret">
                                            <i class="now-ui-icons arrows-1_cloud-upload-94"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <input type="hidden" name="id" value="${clazz.id}">
                                    <div class="row">
                                        <div class="col-md-4 pr-1">
                                            <div class="form-group">
                                                <label>课程名</label>
                                                <input type="text" name="clazzName" class="form-control" disabled
                                                       placeholder="课程名"
                                                       value="${clazz.clazzName}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-5 pr-1">
                                            <div class="form-group">
                                                <label>开始时间</label>
                                                <input type="text" name="startTime" class="form-control" disabled
                                                       placeholder="开始时间"
                                                       value="<fmt:formatDate value="${clazz.startTime}" pattern="yyyy-MM-dd"/>">
                                            </div>
                                        </div>
                                        <div class="col-md-5 pr-1">
                                            <div class="form-group">
                                                <label>结束时间</label>
                                                <input type="text" name="endTime" class="form-control" disabled
                                                       placeholder="结束时间"
                                                       value="<fmt:formatDate value="${clazz.endTime}" pattern="yyyy-MM-dd"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-5 pr-1">
                                            <div class="form-group">
                                                <label>学生姓名</label>
                                                <input type="text" name="studentName" class="form-control" disabled
                                                       placeholder="学生姓名"
                                                       value="${student.realName}">
                                            </div>
                                        </div>
                                        <div class="col-md-5 pr-1">
                                            <div class="form-group">
                                                <label>学号</label>
                                                <input type="text" name="studentNum" class="form-control" disabled placeholder="学号"
                                                       value="${student.studentNum}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4 pr-1">
                                            <div class="form-group">
                                                <label>评分</label>
                                                <input type="text" name="score" class="form-control"
                                                       placeholder="分数">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Javascript -->
<script src="${ctx}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/core/popper.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/core/bootstrap.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/now-ui-dashboard.js?v=1.0.1"></script>
</body>
</html>
