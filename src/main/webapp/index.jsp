<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-24
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>Exercise id</th>
        <th>Solution author</th>
        <th>Date</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${requestScope.recentSolutions}" var="solution">
        <tr>
            <td>${solution.exerciseTitle}</td>
            <td>${solution.username}</td>
            <td>${solution.created}</td>
            <td><a href="/solution?id=${solution.id}">Details</a> </td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
