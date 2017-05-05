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
    <title>Турнирная таблица</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/teams/table.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
</t:header>

<t:news>
</t:news>

<div class="center-content" ng-controller="tableController">
    <h1>Турнирная таблица</h1>

    <div class="content">
    </div>


</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/teams/table.js" />"></script>
</html>
