<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 22.02.2017
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<div id="left-top-news">
    <div class="title">
        <span><span class="block-title-icon">&nbsp;</span>Главные новости</span>
    </div>

    <div class="news" ng-repeat="news in mainNews">
        <div ng-if="news.index!=mainNews.length-1" class="news-border">
            <div class="coomon-time">
                <div class="l">&nbsp;</div>
                <div class="m ng-binding">{{news.date}}</div>
                <div class="r">&nbsp;</div>
            </div>
            <a href="${pageContext.request.contextPath}/news/readnews/{{news.id}}">{{news.name}}</a>
        </div>
        <div ng-if="news.index==mainNews.length-1">
            <div class="coomon-time">
                <div class="l">&nbsp;</div>
                <div class="m ng-binding">{{news.date}}</div>
                <div class="r">&nbsp;</div>
            </div>
            <a href="${pageContext.request.contextPath}/news/readnews/{{news.id}}">{{news.name}}</a>
        </div>
    </div>

    <jsp:doBody/>
</div>