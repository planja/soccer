<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 17.02.2017
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/common/notfound.css" />">
</head>
<body>

<t:header>
    <title>Ошибка</title>
</t:header>

<t:news>
</t:news>

<div class="center-content">
    <h1>Ошибка</h1>
    <span class="not-found-text">Такой страницы не существует</span>
    <div><a class="to-main-page" href="${pageContext.request.contextPath}/">На главную</a></div>
</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
</html>


