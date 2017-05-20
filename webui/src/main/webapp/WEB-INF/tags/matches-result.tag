<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 22.02.2017
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<div id="matches-result">
    <div class="title">
        <span><span class="block-title-icon"></span>Футбольные матчи</span>
    </div>
    <select id="change-matches-and-table" ng-change="changeTeams(selectedCompetition)" ng-model="selectedCompetition" ng-options="item.fullName + item.region for item in competitions">
    </select>
    <div id="match-detail">
        <div class="hover" ng-repeat="future in futureMatches">
            <div class="date">
                <div class="l">&nbsp;</div>
                <div class="m">{{future.date}}</div>
                <div class="r">&nbsp;</div>
            </div>
            <div class="match-info">
                <div class="time">{{future.hours}}:{{future.minutes}}</div>
                <img class="home-img" src="{{future.homeTeam.shirtUrl}}">
                <img class="away-img" src="{{future.awayTeam.shirtUrl}}">
                <div class="home-team"><a href="/teams/teaminfo/{{future.homeTeam.dbid}}">{{future.homeTeam.name}}</a></div>
                <div class="away-team"><a href="/teams/teaminfo/{{future.awayTeam.dbid}}">{{future.awayTeam.name}}</a></div>
                <img src="<c:url value="/resources/images/common/ball.png" />">
            </div>
        </div>
        <div class="hover" ng-repeat="past in pastMatches">
            <div class="date">
                <div class="l">&nbsp;</div>
                <div class="m">{{past.date}}</div>
                <div class="r">&nbsp;</div>
            </div>
            <div class="match-info">
                <div class="time">{{past.hours}}:{{past.minutes}}</div>
                <img class="home-img" src="{{past.homeTeam.shirtUrl}}">
                <img class="away-img" src="{{past.awayTeam.shirtUrl}}">
                <div class="home-team"><a href="/teams/teaminfo/{{past.homeTeam.dbid}}">{{past.homeTeam.name}}</a></div>
                <div class="away-team"><a href="/teams/teaminfo/{{past.awayTeam.dbid}}">{{past.awayTeam.name}}</a></div>
                <div class="home-score">{{past.homeGoals}}</div>
                <div class="away-score">{{past.awayGoals}}</div>
            </div>
        </div>
    </div>
</div>