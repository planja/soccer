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
    <title>Результаты матчей</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/teams/result.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
</t:header>

<t:news>
</t:news>

<div class="center-content" ng-controller="resultController">
    <h1 id="selectedCompetition" style="display: none">Результаты матчей {{selectedCompetition.fullName}}
        {{selectedCompetition.region}}</h1>

    <div class="content">
        <div>
            <img ng-src="{{selectedCompetition.flagUrl}}">
        </div>
        <select ng-change="changeTeams(selectedCompetition)" ng-model="selectedCompetition"
                ng-options="item.fullName + item.region for item in competitions">
        </select>

        <div class="table-data" ng-repeat="m in map">
            <table>

                <tr>
                    <td class="date" colspan="4" class="th">{{m.date}}</td>
                </tr>
                <tr ng-repeat="match in m.matches">
                    <td class="time">
                        {{match.time}}
                    </td>
                    <td class="left">
                        <a href="${pageContext.request.contextPath}/teams/teaminfo/{{match.homeTeam.dbid}}">{{match.homeTeam.name}}</a>
                    </td>
                    <td class="result">
                        <span ng-if="match.isResult">{{match.homeGoals}}:{{match.awayGoals}}</span>
                        <img class="future-match" ng-if="!match.isResult"
                             src="${pageContext.request.contextPath}/resources/images/common/ball.png">
                    </td>
                    <td class="right">
                        <a href="${pageContext.request.contextPath}/teams/teaminfo/{{match.awayTeam.dbid}}">{{match.awayTeam.name}}</a>
                    </td>
                </tr>

            </table>
        </div>


    </div>


</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/teams/result.js" />"></script>
</html>
