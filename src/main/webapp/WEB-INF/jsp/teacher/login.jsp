<%--
  Created by IntelliJ IDEA.
  User: chlia
  Date: 2019/3/22
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Teacher Login</title>
    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="${ctx}/resource/azmind_3_xd/assets/css/reset.css">
    <link rel="stylesheet" href="${ctx}/resource/azmind_3_xd/assets/css/supersized.css">
    <link rel="stylesheet" href="${ctx}/resource/azmind_3_xd/assets/css/style.css">
    <link href="${ctx}/resource/twts_122_now-ui/assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet"/>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="page-container">
    <h1>Teacher Login</h1>
    <form action="${ctx}/teacher/login" method="post">
        <input type="text" name="teacherNum" class="teacherNum" placeholder="TeacherNum">
        <input type="password" name="password" class="password" placeholder="Password">
        <button type="submit">Sign me in</button>
        <div class="error"><span>+</span></div>
    </form>
</div>
<!-- Javascript -->
<script src="${ctx}/resource/azmind_3_xd/assets/js/jquery-1.8.2.min.js"></script>
<script src="${ctx}/resource/azmind_3_xd/assets/js/supersized.3.2.7.min.js"></script>
<script src="${ctx}/resource/azmind_3_xd/assets/js/supersized-init.js"></script>
<script src="${ctx}/resource/azmind_3_xd/assets/js/scripts.js"></script>
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
