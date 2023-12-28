<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/28/2023
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            margin-bottom: 10px;
        }

        a {
            text-decoration: none;
            padding: 5px 10px;
            margin-right: 5px;
            background-color: #4caf50;
            color: white;
            border-radius: 3px;
        }

        a:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
<h2>Welcome to Home Page</h2>
<form:form action="login" method="post" modelAttribute="login">
    <label>Username: </label>
    <form:input path="account" />
    <br/>
    <label>Password: </label>
    <form:password path="password" />
    <br/>
    <input type="submit" value="Login" />
</form:form>
</body>
</html>

