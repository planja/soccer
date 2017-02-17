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
    <title>Login</title>
</head>
<body>
<form name='form' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
    <label>
        <span>User name</span>
        <input type="text"
               name="login" pattern=".{3,}"
               maxlength="100"
               required="required"/>
    </label>
    <label>
        <span>Password</span>
        <input type="password"
               name="password" pattern=".{3,}"
               maxlength="100"
               required="required"/>
    </label>
    <button type="submit">Login</button>
</form>
</body>
</html>
