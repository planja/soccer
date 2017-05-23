<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новая статья</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/news/createblog.css" />">

    <link rel="stylesheet" href="<c:url value="/resources/css/froala/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/codemirror.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/froala_editor.pkgd.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/froala_style.min.css" />">
</head>
<body ng-app="soccerApp" ng-controller="articleController">

<t:header>
</t:header>

<t:news>
</t:news>

<div class="center-content">
    <h1>Новая статья</h1>


    <div class="content">
        <div id="file-input">
            <input id="avatar" type="file" multiple accept="image/jpeg,image/png"
                   onchange="onChangeImage(this.files)">
            <img id="avatar-image" title="Заглавная картинка" alt=""
                 src="${pageContext.request.contextPath}/resources/images/registration/default-avatar.gif"/>
        </div>
        <div class="selected-competition">
            <select ng-model="selectedCompetition" ng-options="item.text for item in competitions">
            </select>
        </div>
        <div class="news-name">
            <input placeholder="Название статьи" ng-model="newsData.name" id="name" name="name"
                   maxlength="240">
        </div>
        <div class="news-header">
            <textarea ng-model="newsData.startNewsText" placeholder="Начало статьи" maxlength="250"></textarea>

        </div>
        <h1>Содержание статьи</h1>
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

<script src="<c:url value="/resources/js/news/createblog.js" />"></script>
</html>
