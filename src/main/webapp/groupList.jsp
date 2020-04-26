<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Group list</title>
</head>
<body>
<%@include file="header.jsp"%>
<div>User groups</div>
<table>
    <tr>
        <th>Group name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${requestScope.groupList}" var="group">
        <tr>
            <td>${group.name}</td>
            <td><a href="/editGroup?id=${group.id}">Action</a> </td>
        </tr>
    </c:forEach>
</table>
<a href="/addGroup">Add group</a>
<%@include file="footer.jsp"%>
</body>
</html>
