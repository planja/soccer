<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 16.03.2017
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление данными</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/admin/admin.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/admin/admin-data.css" />">
</head>
<body id="body" ng-app="soccerApp">

<div id="spin"></div>


<t:header>
</t:header>

<div id="left-news">
    <t:left-top-news>
    </t:left-top-news>
</div>

<div class="center-content" ng-controller="adminDataController">
    <div class="header" style="margin: 20px auto 0 auto">
        <div class="menu">
            <a href="${pageContext.request.contextPath}/admin/adminusers">Пользователи</a> |
            <a id="admin-data" href="${pageContext.request.contextPath}/admin/admindata">Данные</a> |
        </div>
    </div>


    <div id="admin-data-content">
        <input type="button" value="Обновить соревнования" class="submit" ng-click="updateCompetitions()">
    </div>
</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/admin/admin-data.js" />"></script>
<script src="<c:url value="/resources/js/spinner/jquery.babypaunch.spinner.min.js" />"></script>
</html>
