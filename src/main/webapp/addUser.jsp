<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User add</title>
</head>
<body>
<%@include file="header.jsp" %>
<form action="/addUser" method="post">
    <div>
        Enter your username
        <input type="text" name="username">
    </div>
    <div>
        Email
        <input type="email" name="email">
    </div>
    <div>
        Password
        <input type="hidden" name="password">
    </div>
    <div>
        Group ID
        <input type="number" name="groupId">
    </div>
    <input type="submit" name="Confirm">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
