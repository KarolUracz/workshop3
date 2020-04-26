<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-04-26
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise edition</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Exercise edition:</h1>
<form action="/editExercise" method="post">
    <label>
        Title:
        <textarea name="title">${requestScope.exercise.title}</textarea>
    </label>
    <label>
        Description:
        <textarea name="description">${requestScope.exercise.description}</textarea>
    </label>
    <input type="submit" name="Confirm">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
