<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả tra từ</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>
<h1>Từ: ${word}</h1>
<p>Nghĩa: ${mean}</p>
<a href="/home">Quay lại trang chủ</a>
</body>
</html>
