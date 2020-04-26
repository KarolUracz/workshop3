<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Edition</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>User edition</h1>
<form action="/editUser" method="post">
    <label>
        Name:
        <textarea name="username">${requestScope.user.username}</textarea>
    </label>
    <label>
        Email:
        <textarea name="email">${requestScope.user.email}</textarea>
    </label>
    <label>
        Password:
        <textarea name="password"></textarea>
    </label>
    <label>
        Group ID:
        <textarea name="groupId">${requestScope.user.group_id}</textarea>
    </label>
    <input type="submit" value="Confirm changes">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
