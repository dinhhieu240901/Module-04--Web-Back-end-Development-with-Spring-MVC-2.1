<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/26/2023
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            width: 300px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-top: 20px;
        }

        input[type="text"], input[type="email"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
        }

        button {
            display: block;
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<form accept-charset="UTF-8" action="/add" method="post">
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required>

    <label for="name">Tên khách hàng:</label>
    <input type="text" id="name" name="name" required>

    <label for="email">Email:</label>3

    <input type="email" id="email" name="email" required>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" required>

    <button type="submit">Thêm khách hàng</button>
</form>
</body>
</html>
