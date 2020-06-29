<%--
  Created by IntelliJ IDEA.
  User: Kurumi Wang
  Date: 2020/6/29
  Time: 10:46:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    username:<input name = "username" type="text">
    username:<input name = "password" type="password">
    <input type="submit" value="login">
</form>
</body>
</html>
