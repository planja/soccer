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
    <title>${pageContext.request.userPrincipal.name}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/user/user.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
</t:header>

<t:news>
</t:news>

<div id="user-details" class="center-content" ng-controller="userController">
    <h1>${pageContext.request.userPrincipal.name}</h1>
    <div class="header">
        <div class="menu">
            <a ng-click="loadProfile()">Профиль</a> |
            <a href="/user/399977/edit">Комментарии</a>
        </div>
    </div>

</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/user/user.js" />"></script>
</html>
