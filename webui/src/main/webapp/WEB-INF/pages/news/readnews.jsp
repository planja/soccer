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
<html ng-app="soccerApp" ng-controller="newsController">
<head>
    <title>{{news.name}}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/news/readnews.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/froala/froala_style.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/news/pagination.css" />">
</head>
<body>
<t:header>
</t:header>

<div id="index">
    <t:news>
    </t:news>

    <div class="center-content">
        <div class="content">
            <h1>{{news.name}}</h1>
            <br>

            <div class="info-gray">
                <div class="node-info">
                    <span>{{news.date}}</span>
                    | Источник: <a class="ref" href="${pageContext.request.contextPath}/">Soccer</a>
                    | Автор: <span class="author">{{news.authorName}}</span>
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

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="content">
                <div class="comment-area">
                    <label class="comment-label" for="comment">Комментарий</label>
                    <textarea ng-model="commentText" id="comment" class="text-area"></textarea>
                    <input value="Добавить" class="add-comment" ng-click="saveComment(commentText)">
                </div>
            </div>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <div class="content">
                <span><a href="${pageContext.request.contextPath}/login">Войдите</a>
                    или <a href="${pageContext.request.contextPath}/registration">зарегистрируйтесь,</a> чтобы оставлять комментарии</span>
            </div>
        </c:if>
        <div class="content">
            <div class="comments">
                <div ng-repeat="com in comments" class="comment">
                    <img class="user-comment-image" src="{{com.userImage}}">
                    <span class="user-name">{{com.userName}}</span>
                    <span class="comment-date">{{com.date}}</span>
                    <span class="comment-text">{{com.text}}</span>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <c:if test="${pageContext.request.isUserInRole('ADMIN')
                        ||pageContext.request.isUserInRole('MODERATOR')}">
                            <a class="delete-comment" ng-click="deleteComment(com.id)"><img class="delete-image" src="/resources/images/common/274c.png"></a>
                        </c:if>
                    </c:if>
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
<script src="<c:url value="/resources/js/news/readnews.js" />"></script>
<script src="<c:url value="/resources/js/common/ui-bootstrap-tpls-0.3.0.min.js" />"></script>
<script>
    var newsId = "${newsId}";
</script>
</html>

