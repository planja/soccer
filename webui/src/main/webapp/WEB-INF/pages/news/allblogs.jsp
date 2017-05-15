<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 17.02.2017
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="soccerApp" ng-controller="allBlogsController">
<head>
    <title>Статьи</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/news/allblogs.css" />">
</head>
<body>
<t:header>
</t:header>

<div id="index">
    <t:news>
    </t:news>

    <div class="center-content">
        <h1>Статьи</h1>
        <div class="content">
            <br>
            <span class="select-category">Выберите категорию</span>
            <div class="selected-competition">
                <select ng-model="selectedCompetition" ng-options="item.text for item in competitions">
                </select>
            </div>

            <br>
            <div class="article-all" ng-repeat="blog in blogs">
                <div class="field_image-all">
                    <img class="home-img-all" src="{{blog.image}}">
                </div>
                <div class="title-all"><a href="/news/readblog/{{blog.id}}">{{blog.name}}</a></div>
                <div class="text-all">{{blog.startNewsText}}</div>
                <div class="created-all"><span class="time">{{blog.date}}</span>
                    <span class="commentaries-all">Комментариев:38</span>
                </div>
            </div>

        </div>
    </div>


    <t:tournaments>
    </t:tournaments>

    <t:footer>
    </t:footer>
</div>


</body>
<script src="<c:url value="/resources/js/news/allblogs.js" />"></script>
</html>

