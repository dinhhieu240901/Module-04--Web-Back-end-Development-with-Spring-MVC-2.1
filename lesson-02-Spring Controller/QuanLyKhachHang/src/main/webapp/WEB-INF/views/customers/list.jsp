<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách khách hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
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
            background-color: #ffffff;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 15px;
            text-align: center;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        td a {
            display: block;
            width: 90%;
            padding: 10px;
            text-align: center;
            text-decoration: none;
            color: #007bff;
            cursor: pointer;
        }
        td a:hover {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach items="${listCustomer}" var="customer">
        <tr>
            <td><c:out value="${customer.id}"></c:out></td>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.email}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td>
                <a href="<c:url value='/view/${customer.id}'/>">Xem</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
