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
<html ng-app="soccerApp" ng-controller="teamInfoController">
<head>
    <title>{{teamData.name}}</title>
</head>
<body>

<t:header>
</t:header>

<div ng-controller="topAndBottomController">
    <t:news>
    </t:news>
</div>
<link rel="stylesheet" href="<c:url value="/resources/css/teams/team-info.css" />">

<div class="center-content">
    <h1 class="h1-class">{{teamData.name}}({{teamData.shortCode}})</h1>
    <b>Стадион:</b> <span class="span-color">{{teamData.defaultHomeVenue.name}}</span>
    <img class="image-size" ng-src="{{teamData.shirtUrl}}">

    <div class="section">
        <h1 class="margin-h1">Состав команды</h1>
        <table>
            <tr class="header">
                <th>Номер</th>
                <th>Игрок</th>
                <th>Краткое имя</th>
                <th>Позиция</th>
            </tr>
            <tr class="border" ng-repeat="player in players">
                <td height="40" ng-if="player.index%2==0">{{player.number}}</td>
                <td ng-if="player.index%2==0" class="player">{{player.name}}</td>
                <td ng-if="player.index%2==0">{{player.shortName}}</td>
                <td ng-if="player.index%2==0">{{player.position}}</td>


                <td height="40" ng-if="player.index%2==1" class="color">{{player.number}}</td>
                <td ng-if="player.index%2==1" class="color player">{{player.name}}</td>
                <td ng-if="player.index%2==1" class="color">{{player.shortName}}</td>
                <td ng-if="player.index%2==1" class="color">{{player.position}}</td>
            </tr>
        </table>
    </div>
</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/teams/team-info.js" />">

</script>
<script src="<c:url value="/resources/js/common/top-and-bottom-news.js" />"></script>
<script>
    var teamId = "${teamId}";
</script>
</html>
