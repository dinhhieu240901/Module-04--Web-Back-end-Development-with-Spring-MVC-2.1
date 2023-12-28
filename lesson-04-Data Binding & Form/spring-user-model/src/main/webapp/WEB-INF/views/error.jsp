<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/28/2023
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Error Page</title>
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
<h2>Error Page</h2>
<p>Invalid username or password. Please try again.</p>
<a href="/home'/>">Back to Home</a>
</body>
</html>
