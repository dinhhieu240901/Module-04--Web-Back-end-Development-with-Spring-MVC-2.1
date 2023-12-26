<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>
<form action="/search" method="get">
    <input type="text" name="txtSearch" placeholder="Nhập từ tiếng Anh...">
    <input type="submit" value="Tìm kiếm">
</form>
</body>
</html>
