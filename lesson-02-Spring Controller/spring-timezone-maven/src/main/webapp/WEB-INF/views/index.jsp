<%@ taglib prefix="c" uri=""%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <h3>Current local Times Around the World</h3>
  <form id="locale" action="world-clock" method="get">
    <select name="city" onchange="document.getElementById('locale').submit()" >
      <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
      <option value="Singapore">Singapore</option>
      <option value="Asia/Hong_Kong">Hong Kong</option>
      <option value="Asia/Tokyo">Tokyo</option>
      <option value="Asia/Seoul">Seoul</option>
      <option value="Europe/London">London</option>
      <option value="Europe/LiverPool">LiverPool</option>
      <option value="Europe/Manchester">Manchester</option>
      <option value="Argentina/Buenos_Aires">Buenos Aires</option>
    </select>
  </form>
</body>
</html>