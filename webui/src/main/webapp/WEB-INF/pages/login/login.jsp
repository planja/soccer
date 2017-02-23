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
</head>
<body ng-app="soccerApp">

<link rel="stylesheet" href="<c:url value="/resources/css/login/login.css" />">
<t:header>
    <title>Вход</title>
</t:header>


<t:news>
</t:news>

<div id="login-page" ng-controller="loginController">
    <div class="center">
        <h1>Вы можете зайти на сайт используя логин и пароль</h1>
        <div class="row-element">
            <div class="row">
                <label for="login">Логин</label>
                <input ng-model="loginData.login" type="text" id="login" name="login" maxlength="128">
            </div>

        </div>
        <div class="row-element">
            <div class="row">
                <label for="password">Пароль</label>
                <input ng-model="loginData.password" type="password" id="password" name="password" maxlength="128">
            </div>
        </div>
        <div class="row">
            <input type="button" id="submit" value="Войти" class="form-submit" ng-click="login(loginData)">
        </div>
    </div>
</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>
<script src="<c:url value="/resources/js/login/login.js" />"></script>
<script src="<c:url value="/resources/js/common/jquery.noty.packaged.js" />"></script>
</html>


