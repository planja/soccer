<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 17.02.2017
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/common/body.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/common/header.css" />">
    <title>Футбол, новости российского, европейского и мирового футбола</title>
</head>
<body>
<div id="header">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <a href="${pageContext.request.contextPath}/">
        <img src="${pageContext.request.contextPath}/resources/images/common/logo.png" alt=""
             title="Футбол, чемпионат России 2016/2017. Новости футбола России и Европы">
    </a>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/spartak12.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/barca2.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/bayern.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/chelsea.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/cska.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/juve.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/liverpool.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/loko.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/milan.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/mu.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/rm1.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/rostov.png" alt=""
             title="Спартак(Москва)">
    </div>
    <div class="header-image">
        <img src="${pageContext.request.contextPath}/resources/images/header%20image/zenit.png" alt=""
             title="Спартак(Москва)">
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
