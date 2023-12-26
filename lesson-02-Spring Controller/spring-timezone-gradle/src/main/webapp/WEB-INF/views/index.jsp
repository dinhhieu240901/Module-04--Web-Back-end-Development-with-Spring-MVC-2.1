<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f8f8;
            margin: 20px;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        span {
            display: block;
            margin: 20px 0;
            font-size: 18px;
        }

        select {
            padding: 10px;
            font-size: 16px;
        }
    </style>
</head>
<body>
  <h2>Current local time around the world</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
  <form id="locale" method="get" action="world-clock">
      <select name="city" onchange="document.getElementById('locale').submit()" >
    <c:choose>
        <c:when test="${city == 'Asia/Ho_Chi_Minh'}">
            <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
        </c:when>
        <c:otherwise>
            <option value="${city}" selected>${city}</option>
        </c:otherwise>
    </c:choose>
        <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
        <option value="Singapore">Singapore</option>
        <option value="Asia/Hong_Kong">Hong Kong</option>
        <option value="Asia/Tokyo">Tokyo</option>
        <option value="Asia/Seoul">Seoul</option>
        <option value="Europe/London">Lodon</option>
        <option value="Europe/LiverPool">LiverPool</option>
        <option value="Europe/Manchester">Manchester</option>
         <option value="Argentina/Buenos_Aires">Buenos Aires</option>
      </select>
  </form>
</body>
</html>