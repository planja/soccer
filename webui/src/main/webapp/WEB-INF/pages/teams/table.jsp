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
    <title>Турнирная таблица</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/teams/table.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
</t:header>

<div ng-controller="topAndBottomController">
    <t:news>
    </t:news>
</div>


<div class="center-content" ng-controller="tableController">
    <h1 id="selectedCompetition" style="display: none">Турнирная таблица {{selectedCompetition.fullName}}
        {{selectedCompetition.region}}</h1>

    <div class="content">
        <div>
            <img ng-src="{{selectedCompetition.flagUrl}}">
        </div>
        <select ng-change="changeTeams(selectedCompetition)" ng-model="selectedCompetition" ng-options="item.fullName + item.region for item in competitions">
        </select>

        <table class="table" ng-repeat="tournament in tournamentsData">
            <tr class="green">
                <th class="header"></th>
                <th class="name header">{{tournament.round.name}}</th>
                <th class="header">И</th>
                <th class="header">В</th>
                <th class="header">Н</th>
                <th class="header">П</th>
                <th class="header">Мячи</th>
                <th class="header">О</th>
            </tr>
            <tr class="border" ng-repeat="team in tournament.leagueTable">
                <td ng-if="team.index%2==0">{{team.index+1}}</td>
                <td ng-if="team.index%2==0" class="team-name"><a href="/teams/teaminfo/{{team.dbid}}" title="{{team.name}}">{{team.name}}</a></td>
                <td ng-if="team.index%2==0">{{team.gamesPlayed}}</td>
                <td ng-if="team.index%2==0">{{team.wins}}</td>
                <td ng-if="team.index%2==0">{{team.draws}}</td>
                <td ng-if="team.index%2==0">{{team.losses}}</td>
                <td ng-if="team.index%2==0">{{team.goalsFor}}:{{team.goalsAgainst}}</td>
                <td ng-if="team.index%2==0" class="points">{{team.points}}</td>



                <td ng-if="team.index%2==1" class="color">{{team.index+1}}</td>
                <td ng-if="team.index%2==1" class="color team-name"><a href="/teams/teaminfo/{{team.dbid}}" title="{{team.name}}">{{team.name}}</a></td>
                <td ng-if="team.index%2==1" class="color">{{team.gamesPlayed}}</td>
                <td ng-if="team.index%2==1" class="color">{{team.wins}}</td>
                <td ng-if="team.index%2==1" class="color">{{team.draws}}</td>
                <td ng-if="team.index%2==1" class="color">{{team.losses}}</td>
                <td ng-if="team.index%2==1" class="color">{{team.goalsFor}}:{{team.goalsAgainst}}</td>
                <td ng-if="team.index%2==1" class="color points">{{team.points}}</td>
            </tr>
        </table>

    </div>


</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/teams/table.js" />"></script>
<script src="<c:url value="/resources/js/common/top-and-bottom-news.js" />"></script>
</html>
