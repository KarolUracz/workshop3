<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add group</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1>Add group</h1>
<form action="/addGroup" method="post">
    Group name <input type="text" name="addGroup">
    <input type="submit" value="Save">
</form>
<%@include file="footer.jsp" %>
</body>
</html>
