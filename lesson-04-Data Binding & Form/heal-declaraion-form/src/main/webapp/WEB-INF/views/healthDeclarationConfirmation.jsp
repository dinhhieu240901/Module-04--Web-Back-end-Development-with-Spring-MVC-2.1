<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/30/2023
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xác nhận Tờ Khai Y Tế</title>
</head>
<body>
<h2>Xác nhận Tờ Khai Y Tế</h2>

<p style="color: green">${success}</p>

<h3>Thông tin đã khai báo:</h3>
<p>Họ và tên: ${healDeclaration.name}</p>
<p>Năm sinh: ${healDeclaration.birthYear}</p>
<p>Giới tính: ${healDeclaration.genders}</p>
<p>Quốc gia: ${healDeclaration.national}</p>
<p>Số CMND: ${healDeclaration.idCard}</p>
<p>Phương tiện di chuyển: ${healDeclaration.vehicle}</p>
<p>Số đăng ký xe: ${healDeclaration.licensePlate}</p>
<p>Số chỗ ngồi: ${healDeclaration.numberOfSeat}</p>
<p>Ngày bắt đầu di chuyển: ${healDeclaration.dateStart}</p>
<p>Ngày kết thúc di chuyển: ${healDeclaration.dateEnd}</p>
<p>Thành phố đến: ${healDeclaration.cityArrived}</p>
<p>Thành phố hiện tại: ${healDeclaration.city}</p>
<p>Tỉnh/Thành phố: ${healDeclaration.province}</p>
<p>Địa chỉ: ${healDeclaration.address}</p>
<p>Số điện thoại: ${healDeclaration.phoneNumber}</p>
<p>Email: ${healDeclaration.email}</p>

<label>Triệu chứng:</label>
<div>
    <c:forEach items="${healDeclaration.symptoms}" var="symptom">
        <p>${symptom.key}: ${symptom.value ? 'Có' : 'Không'}</p>
    </c:forEach>
</div>

<label>Lịch sử tiếp xúc:</label>
<div>
    <c:forEach items="${healDeclaration.exposureHistory}" var="history">
        <p>${history.key}: ${history.value ? 'Có' : 'Không'}</p>
    </c:forEach>
</div>

<a href="/health-declaration/view">Xem Tờ Khai</a>
</body>
</html>