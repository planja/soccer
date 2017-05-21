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
<html ng-app="soccerApp" ng-controller="countryController">
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/common/index.css" />">
</head>
<body>
<t:header>
    <title>{{title}}</title>
</t:header>

<div id="index">
    <t:news>
    </t:news>

    <div id="middle-news">
        <div class="article" ng-repeat="blog in blogs">
            <div class="field_image">
                <img class="home-img" src="{{blog.image}}">
            </div>
            <div class="title"><a href="/news/readblog/{{blog.id}}">{{blog.name}}</a></div>
            <div class="text">{{blog.startNewsText}}</div>
            <div class="created"><span class="time">{{blog.date}}</span>
            </div>
        </div>
    </div>

    <t:matches-result>
    </t:matches-result>

    <t:tournaments>
    </t:tournaments>

    <t:table>
    </t:table>


    <t:footer>
    </t:footer>
</div>


</body>
<script src="<c:url value="/resources/js/common/country.js" />"></script>
<script>
    var countryId = ${countryId};
</script>
</html>

