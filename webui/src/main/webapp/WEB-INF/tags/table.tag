<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 22.02.2017
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<div id="table">
    <div class="title">
        <span><span class="block-title-icon"></span>Турнирная таблица</span>
    </div>
    <table class="table-content" ng-repeat="tournament in tournamentsData">
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