<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách học sinh</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            animation: fadeIn 2s;
        }
        h2 {
            color: #7d3cff;
            text-align: center;
            margin-top: 50px;
        }
        table {
            width: 80%;
            margin: 50px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 15px;
            text-align: center;
            background-color: #ffffff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        th {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
<h2>Danh sách học sinh</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td><c:out value="${student.id}" /></td>
            <td><c:out value="${student.name}" /></td>
            <td><c:out value="${student.dateOfBirth}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
