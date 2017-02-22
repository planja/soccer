<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 17.02.2017
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/common/body.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/common/header.css" />">
    <script src="<c:url value="/resources/js/common/jquery-1.9.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/common/common.js" />"></script>
    <!--<script src="<c:url value="/resources/js/common/angularjs.1.6.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/common/kendo.all.min.js" />"></script>
    <script src="<c:url value="/resources/js/common/moment.min.js" />"></script>-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
</head>
<body>
<div id="header">
    <jsp:doBody/>
    <a href="${pageContext.request.contextPath}/">
        <img src="${pageContext.request.contextPath}/resources/images/common/logo.png" alt=""
             title="Футбол, чемпионат России 2016/2017. Новости футбола России и Европы">
    </a>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/spartak12.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/barca2.png" alt=""
             title="Барселона(Барселона)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/bayern.png" alt=""
             title="Бавария(Мюнхен)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/chelsea.png" alt=""
             title="Челси(Лондон)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/cska.png" alt=""
             title="ЦСКА(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/juve.png" alt=""
             title="Ювентус(Турин)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/liverpool.png" alt=""
             title="Ливерпуль(Ливерпуль)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/loko.png" alt=""
             title="Локомотив(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/milan.png" alt=""
             title="Милан(Милан)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/mu.png" alt=""
             title="Манчестер Юнайтед(Манчестер)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/rm1.png" alt=""
             title="Реал Мадрид(Мадрид)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/rostov.png" alt=""
             title="Ростов(Ростов-на-Дону)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header_image/zenit.png" alt=""
             title="Зенит(Санкт-Петербург)">
    </div>
    <div id="menu">
        <ul>
            <li class="first">
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
        </ul>
        <div class="left-block">
            <div class="content">
                <span class="login-icon">&nbsp;</span>
                <a class="login" href="${pageContext.request.contextPath}/login" title="Вход">Вход</a>
            </div>
        </div>
    </div>
</div>


<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h1>Welcome ${pageContext.request.userPrincipal.name}</h1>
</c:if>
</body>
</html>
