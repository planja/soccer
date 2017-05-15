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
<html ng-app="soccerApp" ng-controller="blogController">
<head>
    <title>{{blog.name}}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/news/readblog.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/froala_style.min.css" />">
</head>
<body>
<t:header>
</t:header>

<div id="index">
    <t:news>
    </t:news>

    <div class="center-content">
        <div class="content">
            <h1>{{blog.name}}</h1>
            <br>

            <div class="info-gray">
                <div class="node-info">
                    <span>{{blog.date}}</span>
                    | Источник: <a class="ref" href="${pageContext.request.contextPath}/">Soccer</a>
                    | Автор: <span class="author">{{blog.authorName}}</span>
                </div>
            </div>


            <div data-ng-bind-html="html"></div>
            <div class="div-on-main">
                <a class="on-main" href="/">На главную</a>
            </div>
            <div class="read-more" style="">Читать далее</div>


        </div>
        <div>
            <div ng-repeat="blog in blogs">
                <div class="img-with-text">
                    <img src="{{blog.image}}"/>
                    <a href="/news/readblog/{{blog.id}}">
                        <span class="read-more-header">{{blog.name}}</span>
                    </a>
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
<script src="<c:url value="/resources/js/news/readblog.js" />"></script>
<script>
    var blogId = "${blogId}";
</script>
</html>

