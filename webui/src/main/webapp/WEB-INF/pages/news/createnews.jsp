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
    <title>Новая новость</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/news/createnews.css" />">

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

<div class="center-content" ng-controller="newsController">
    <h1>Новая новость</h1>


    <div class="content">
        <div class="selected-competition">
            <select ng-model="selectedCompetition" ng-options="item.text for item in competitions">
            </select>
        </div>
        <div class="news-name">
            <input placeholder="Название новости" ng-model="newsData.name" id="name" name="name"
                   maxlength="240">
        </div>
        <div class="news-header">
            <textarea ng-model="newsData.startNewsText" placeholder="Начало новости" maxlength="250"></textarea>
        </div>
        <div class="is-main-news">
            <input ng-model="newsData.isMainNews" type="checkbox" class="radio" id="radio" />
            <label for="radio">Главная новость?</label>
        </div>
        <br>
        <h1>Содержание новости</h1>
        <br><br>
        <div id="edit"></div>
        <input type="button" id="submit" value="Сохранить" class="form-submit" ng-click="save(newsData)">
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

<script src="<c:url value="/resources/js/news/createnews.js" />"></script>
</html>
