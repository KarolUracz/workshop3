<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>
            Name
        </th>
        <th>
            Actions
        </th>
    </tr>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td>
                ${user.username}
            </td>
            <td>
                <a href="/user?id=${user.id}">Action</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
