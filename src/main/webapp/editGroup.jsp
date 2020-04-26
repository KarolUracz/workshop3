<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group edition</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Edit group id: ${requestScope.group.id}</h1>
<form>
    <label>
        Description:
        <textarea name="name">${requestScope.group.name}</textarea>
    </label>
    <input type="submit" value="Confirm changes">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
