<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Solution details:</h1>
<div>Created: ${requestScope.solution.created}</div>
<div>Updated: ${requestScope.solution.updated}</div>
<pre>${requestScope.solution.description}</pre>

<%@include file="footer.jsp"%>
</body>
</html>
