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
    <title>Команды</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/teams/teams.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
</t:header>

<div ng-controller="topAndBottomController">
    <t:news>
    </t:news>
</div>

<div class="center-content" ng-controller="teamsController">
    <h1 id="selectedCompetition" style="display: none">Команды {{selectedCompetition.fullName}}
        {{selectedCompetition.region}}</h1>

    <div class="content">
        <div>
            <img ng-src="{{selectedCompetition.flagUrl}}">
        </div>
        <select ng-change="changeTeams(selectedCompetition)" ng-model="selectedCompetition" ng-options="item.fullName + item.region for item in competitions">
        </select>

        <div class="section">
            <div ng-repeat="item in currentTeams">
                <div class="team-details">
                    <div class="content">
                        <img src="{{item.shirtUrl}}">
                        <div class="item-text">
                            <a href="/teams/teaminfo/{{item.dbid}}" title="{{item.name}}">{{item.name}}</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>


</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/teams/teams.js" />"></script>
<script src="<c:url value="/resources/js/common/top-and-bottom-news.js" />"></script>

</html>
