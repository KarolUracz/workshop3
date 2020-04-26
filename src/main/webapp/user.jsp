<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%@include file="header.jsp"%>
<div>Name: ${requestScope.user.username}</div>
<div>Email: ${requestScope.user.email}</div>
<dic>Added task solutions:</dic>
<table>
    <tr>
        <th>Exercise name</th>
        <th>Date</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${requestScope.solutions}" var="solution">

        <tr>
            <td>${solution.exerciseTitle}</td>
            <td>${solution.created}</td>
            <td><a href="/solution.jsp?id=${solution.id}">Action</a></td>
        </tr>
    </c:forEach>
</table>

<%@include file="footer.jsp"%>
</body>
</html>
