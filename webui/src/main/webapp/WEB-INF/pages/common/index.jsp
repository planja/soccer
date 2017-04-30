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
<html>
<head>
</head>
<body>
<t:header>
    <title>Футбол, новости российского, европейского и мирового футбола</title>
</t:header>

<div id="index" ng-app="soccerApp" ng-controller="indexController">
    <t:news>
    </t:news>

    <div id="middle-news">
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
<script src="<c:url value="/resources/js/common/index.js" />"></script>
</html>
