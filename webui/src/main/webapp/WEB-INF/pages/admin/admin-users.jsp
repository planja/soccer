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
    <link rel="stylesheet" href="<c:url value="/resources/css/admin/admin.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/admin/admin-users.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/kendo.common.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/kendo.min.css" />">
</head>
<body>

<t:header>
</t:header>

<div id="left-news">
    <t:left-top-news>
    </t:left-top-news>
</div>

<div id="user-details" class="center-content">
    <div class="header" style="margin: 20px auto 0 auto">
        <div class="menu">
            <a id="admin-users" href="${pageContext.request.contextPath}/admin/adminusers">Пользователи</a> |
            <a ng-click="showComments()">Комментарии</a>
        </div>
    </div>

    <div id="grid-content" class="col-md-12 col-sm-12 col-lg-12">
        <div id="grid-users"></div>

    </div>
</div>

<t:tournaments>
</t:tournaments>

<t:footer>
</t:footer>

</body>

<script id="popup_editor" type="text/x-kendo-template">
    <div id="popup_editor_content" class="popup-editor-container">
        <div id="form">
            <label for="roles">Роли</label>
            <select id="roles"
                    name="roles"
                    data-bind="value:roles"
                    data-value-field="id"
                    data-text-field="text"
                    data-source="rolesDataSource"
                    data-role="multiselect"
                    data-value-primitive="true"
                    data-autobind="true"
                    data-placeholder="Выберите роли ..."></select>
        </div>
    </div>
</script>

<script src="<c:url value="/resources/js/common/kendo.all.min.js" />"></script>
<script src="<c:url value="/resources/js/datasource/datasource.roles.js" />"></script>
<script src="<c:url value="/resources/js/admin/admin-users.js" />"></script>
</html>
