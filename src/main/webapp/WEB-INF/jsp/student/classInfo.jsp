<%--
  Created by IntelliJ IDEA.
  User: chlia
  Date: 2019/3/22
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Class Manage</title>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="${ctx}/resource/twts_122_now-ui/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/resource/twts_122_now-ui/assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet"/>
</head>
<body>
<%--<div class="page-container">--%>
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
                <div class="col-md-8">
                    <div class="card card-chart">
                        <input type="hidden" name="clazzId" value="${clazz.id}">
                        <div class="card-header">
                            <h4 class="card-title"> 课堂信息</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class=" text-primary">
                                    <th>
                                        学号
                                    </th>
                                    <th>
                                        姓名
                                    </th>
                                    <th>
                                        我给ta的评分
                                    </th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${students}" var="student">
                                        <tr>
                                            <td>
                                                <span>${student.toStudentNum}</span>
                                            </td>
                                            <td>
                                                <span>${student.toStudentName}</span>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${student.score != null && student.score != 0.0}">
                                                        <span>${student.score}</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <button type="button" rel="tooltip" title=""
                                                                class="btn btn-success btn-round btn-icon btn-icon-mini btn-neutral"
                                                                data-original-title="Remove"
                                                                onclick="window.location.href='${ctx}/student/student/score?studentId=${student.toStudentId}&clazzId=${clazz.id}'">
                                                            <i class="now-ui-icons media-1_button-play"></i>
                                                        </button>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--</div>--%>
</div>
<!-- Javascript -->
<script src="${ctx}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/core/popper.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/core/bootstrap.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/now-ui-dashboard.js?v=1.0.1"></script>
<script src="${ctx}/resource/twts_122_now-ui/assets/js/plugins/bootstrap-notify.js"></script>
<script>
    $(function () {
        if ('${requestScope.message}' != null && '${requestScope.message}' !== '') {
            showNotification('${requestScope.message}', 'success');
        }
        if ('${requestScope.error}' != null && '${requestScope.error}' !== '') {
            showNotification('${requestScope.error}', 'danger');
        }
    });

    function showNotification(msg, type) {
        color = type;
        $.notify({
            icon: "now-ui-icons ui-1_bell-53",
            message: msg
        }, {
            type: color,
            timer: 8000,
            placement: {
                from: 'top',
                align: 'right'
            }
        });
    }
</script>
</body>
</html>
