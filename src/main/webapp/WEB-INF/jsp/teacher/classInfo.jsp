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
    <div class="sidebar" data-color="orange">
        <!--
    Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
-->
        <div class="logo">
            <a href="#" class="simple-text">
                翻转课堂教师系统
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="active">
                    <a href="${ctx}/teacher/class">
                        <i class="now-ui-icons design_app"></i>
                        <p>我的课堂</p>
                    </a>
                </li>
                <li>
                    <a href="${ctx}/teacher/student">
                        <i class="now-ui-icons education_atom"></i>
                        <p>学生管理</p>
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
                        <form id="student" action="${ctx}/teacher/student/delete" method="post" accept-charset="UTF-8">
                            <input type="hidden" name="clazzId" value="${clazz.id}">
                            <div class="card-header">
                                <h4 class="card-title"> 课堂信息</h4>
                                <div class="dropdown">
                                    <button type="submit"
                                            class="btn btn-round btn-danger btn-simple btn-icon no-caret">
                                        <i class="now-ui-icons ui-1_simple-remove"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class=" text-primary">
                                        <th>

                                        </th>
                                        <th>
                                            学号
                                        </th>
                                        <th>
                                            姓名
                                        </th>
                                        <th>
                                            教师评分
                                        </th>
                                        <th class="text-right">

                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${students}" var="student">
                                            <tr style="height: 63px;">
                                                <td>
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" id="${student.studentId}"
                                                                   value="${student.studentId}"
                                                                   type="checkbox" name="studentId">
                                                            <span class="form-check-sign"
                                                                  style="margin-top: 10px;"></span>
                                                        </label>
                                                    </div>
                                                </td>
                                                    <%--<td>--%>
                                                    <%--<span>${student.id}</span>--%>
                                                    <%--</td>--%>
                                                <td>
                                                    <span>${student.studentNum}</span>
                                                </td>
                                                <td>
                                                    <span>${student.studentName}</span>
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
                                                                    onclick="window.location.href='${ctx}/teacher/student/score?studentId=${student.studentId}&clazzId=${clazz.id}'">
                                                                <i class="now-ui-icons media-1_button-play"></i>
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td class="text-right">
                                                    <button type="button" rel="tooltip" title=""
                                                            class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral"
                                                            data-original-title="Edit Task"
                                                            onclick="window.location.href='${ctx}/teacher/student/update?id=${student.studentId}'">
                                                        <i class="now-ui-icons ui-2_settings-90"></i>
                                                    </button>
                                                    <button type="button" rel="tooltip" title=""
                                                            class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral"
                                                            data-original-title="Remove"
                                                            onclick="deleteStudent(${student.studentId})">
                                                        <i class="now-ui-icons ui-1_simple-remove"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card card-chart">
                        <form>
                        <div class="card-header">
                            <h4 class="card-title" data-toggle="tooltip" data-placement="top" title="教评*0.6 + 学评平均*0.4"> 当前平均分数排名</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class=" text-primary">
                                    <th >
                                        姓名
                                    </th>
                                    <th >
                                        分数
                                    </th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${scores}" var="score">
                                        <tr style="height: 63px;">
                                            <td>
                                                <span>${score.studentName}</span>
                                            </td>
                                            <td>
                                                <span>${score.score}</span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card card-plain card-chart">
                        <form id="addStudent" action="${ctx}/teacher/class/addStudent" method="post"
                              accept-charset="UTF-8">
                            <input type="hidden" name="clazzId" value="${clazz.id}">
                            <div class="card-header">
                                <h4 class="card-title"> 全部学生名单</h4>
                                <div class="dropdown">
                                    <button type="submit"
                                            class="btn btn-round btn-success btn-simple btn-icon no-caret">
                                        <i class="now-ui-icons ui-1_simple-add"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class=" text-primary">
                                        <th>

                                        </th>
                                        <th>
                                            学号
                                        </th>
                                        <th>
                                            姓名
                                        </th>
                                        <th class="text-right">

                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${allStudents}" var="student">
                                            <tr>
                                                <td>
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" id="add${student.id}"
                                                                   value="${student.id}"
                                                                   type="checkbox" name="studentId">
                                                            <span class="form-check-sign"
                                                                  style="margin-top: 10px;"></span>
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <span>${student.studentNum}</span>
                                                </td>
                                                <td>
                                                    <span>${student.realName}</span>
                                                </td>
                                                <td class="text-right">
                                                    <button type="button" rel="tooltip" title=""
                                                            class="btn btn-success btn-round btn-icon btn-icon-mini btn-neutral"
                                                            data-original-title="Remove"
                                                            onclick="addStudent(${student.id})">
                                                        <i class="now-ui-icons ui-1_simple-add"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </form>
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
        $("[data-toggle='tooltip']").tooltip();
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

    function addStudent(studentId) {
        $("#add" + studentId).attr("checked", "checked");
        $("#addStudent").submit();
    }

    function deleteStudent(studentId) {
        $("#" + studentId).attr("checked", "checked");
        $("#student").submit();
    }
</script>
</body>
</html>
