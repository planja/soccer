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
    <title>Новая статья</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/article/article.css" />">

    <link rel="stylesheet" href="<c:url value="/resources/css/froala/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/codemirror.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/froala_editor.pkgd.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/froala_style.min.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
</t:header>

<t:news>
</t:news>

<div class="center-content" ng-controller="articleController">
    <h1>Новая статья</h1>

    <div class="content">
        <br><br>
        <div id="edit"></div>
    </div>


</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/froala/codemirror.min.js" />"></script>
<script src="<c:url value="/resources/js/froala/xml.min.js" />"></script>
<script src="<c:url value="/resources/js/froala/froala_editor.pkgd.min.js" />"></script>
<script src="<c:url value="/resources/js/froala/ru.js" />"></script>

<script src="<c:url value="/resources/js/article/article.js" />"></script>
</html>
