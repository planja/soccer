<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 17.02.2017
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/registration/registration.css" />">
</head>
<body ng-app="soccerApp">

<t:header>
    <title>Регистрация</title>
</t:header>

<t:news>
</t:news>

<div id="registration" ng-controller="registrationController">
    <h1>Регистрация</h1>
    <div class="center">
        <div class="row-element">
            <div class="row">
                <label for="login">Логин</label>
                <input ng-model="registrationData.login" type="text" id="login" name="login" maxlength="128">
            </div>
        </div>

        <div class="row-element">
            <div class="row">
                <label for="name">Имя</label>
                <input ng-model="registrationData.name" type="text" id="name" name="name" maxlength="128">
            </div>
        </div>

        <div class="row-element">
            <div class="row">
                <label for="mail">E-mail</label>
                <input ng-model="registrationData.mail" type="email" id="mail" name="mail" maxlength="128">
            </div>
        </div>

        <div class="row-element">
            <div class="row">
                <label for="password">Пароль</label>
                <input ng-model="registrationData.password" type="password" id="password" name="password"
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
            <input type="button" id="submit" value="Регистрация" class="form-submit" ng-click="save(registrationData)">
        </div>
    </div>
</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/registration/registration.js" />"></script>
</html>


