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
<html ng-app="readNewsApp" ng-controller="allNewsController">
<head>
    <title>Новости</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/news/allnews.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/news/pagination.css" />">
</head>
<body>
<t:header>
</t:header>

<div id="index">
    <t:news>
    </t:news>

    <div class="center-content">
        <h1>Новости</h1>
        <div class="content">
            <br>
            <span class="select-category">Выберите категорию</span>
            <div class="selected-competition">
                <select ng-change="change(selectedCompetition)" ng-model="selectedCompetition"
                        ng-options="item.text for item in competitions">
                </select>
            </div>

            <br>
            <div class="article-all" ng-repeat="blog in filteredBlogs">
                <div class="coomon-time-all">
                    <div class="l">&nbsp;</div>
                    <div class="m ng-binding">{{blog.date}}</div>
                    <div class="r">&nbsp;</div>
                </div>
                <div class="title-all">
                    <a ng-if="blog.mainNews" class="bold" href="/news/readnews/{{blog.id}}">{{blog.name}}</a>
                    <a ng-if="!blog.mainNews"href="/news/readnews/{{blog.id}}">{{blog.name}}</a>
                </div>

            </div>
            <div data-pagination="" data-num-pages="numPages()"
                 data-current-page="currentPage" data-max-size="maxSize"
                 data-boundary-links="true"></div>
            </div>



        </div>
    </div>


    <t:tournaments>
    </t:tournaments>

    <t:footer>
    </t:footer>
</div>


</body>
<script src="<c:url value="/resources/js/common/ui-bootstrap-tpls-0.3.0.min.js" />"></script>
<script src="<c:url value="/resources/js/news/allnews.js" />"></script>
</html>

