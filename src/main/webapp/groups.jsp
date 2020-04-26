<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Groups</title>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>
        Group name
        </th>
        <th>
            Actions
        </th>
    </tr>
    <c:forEach var="group" items="${requestScope.groups}">
        <tr>
            <td>
                ${group.name}
            </td>
            <td>
                <a href="/users?groupId=${group.id}">Action</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
