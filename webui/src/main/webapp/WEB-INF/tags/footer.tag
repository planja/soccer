<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 21.02.2017
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/common/footer.css" />">
</head>
<body>
<div id="footer">
    <div class="left-block">
        <b>Футбол</b> на <a href="${pageContext.request.contextPath}/">Soccer</a><br>
        При использовании материалов гиперссылка на <br>
        <a href="${pageContext.request.contextPath}/">Soccer</a> обязательна
    </div>
    <div class="header-menu">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
            <li class="last">
                <a href="${pageContext.request.contextPath}/" title="Главная">Главная</a>
            </li>
        </ul>
    </div>
    <div class="right-block">
        <img src="${pageContext.request.contextPath}/resources/images/footer_image/badge_blue.png">
        <img src="${pageContext.request.contextPath}/resources/images/footer_image/042.png">
        <img src="${pageContext.request.contextPath}/resources/images/footer_image/logo.gif">
    </div>
</div>
</body>
</html>
