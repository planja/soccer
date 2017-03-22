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
    <title>${pageContext.request.userPrincipal.name}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/user/user.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
</t:header>

<t:news>
</t:news>

<div id="user-details" class="center-content" ng-controller="userController">
    <h1>${pageContext.request.userPrincipal.name}</h1>
    <div class="header">
        <div class="menu">
            <a ng-click="showProfile()">Профиль</a> |
            <a ng-click="showComments()">Комментарии</a>
        </div>
    </div>

    <div id="user-profile" ng-show="showProfileValue">
        <div class="center">
            <div class="row-element">
                <div class="row">
                    <label for="login">Логин</label>
                    <input ng-model="data.login" type="text" id="login" name="login" maxlength="128">
                </div>
            </div>

            <div class="row-element">
                <div class="row">
                    <label for="name">Имя</label>
                    <input ng-model="data.name" type="text" id="name" name="name" maxlength="128">
                </div>
            </div>

            <div class="row-element">
                <div class="row">
                    <label for="mail">E-mail</label>
                    <input ng-model="data.mail" type="email" id="mail" name="mail" maxlength="128">
                </div>
            </div>

            <div class="row-element">
                <div class="row">
                    <label for="password">Пароль</label>
                    <input ng-model="data.password" type="password" id="password" name="password"
                           maxlength="128">
                </div>
            </div>
            <div class="row-element">
                <div class="row">
                    <div id="file-input">
                        <span>Аватар</span>
                        <input id="avatar" type="file" multiple accept="image/jpeg,image/png"
                               onchange="onChangeImage(this.files)">
                        <img id="avatar-image" title="Ваш аватар" alt=""
                             src="${pageContext.request.contextPath}/resources/images/registration/default-avatar.gif"/>
                        <span id="help-text">Размер должен быть 100x90</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <input type="button" id="submit" value="Обновить" class="form-submit"
                       ng-click="updateProfile(data)">
            </div>
        </div>
    </div>

    <div id="comments" ng-show="showCommentsValue">
        <h1>comments</h1>
    </div>


</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/user/user.js" />"></script>
</html>
