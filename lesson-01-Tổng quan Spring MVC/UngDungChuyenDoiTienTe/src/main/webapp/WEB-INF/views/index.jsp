<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chuyển đổi USD sang VND</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            height: 100vh;
        }

        form {
            width: 40%;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<h2>Nhập thông tin chuyển đổi</h2>
<form action="/convert" method="post">
    <label for="exchangeRate">Tỷ giá:</label>
    <input type="text" id="exchangeRate" name="exchangeRate" required>
    <br>
    <label for="usdAmount">Số tiền USD:</label>
    <input type="text" id="usdAmount" name="usdAmount" required>
    <br>
    <button type="submit">Chuyển đổi</button>
</form>
</body>
</html>
