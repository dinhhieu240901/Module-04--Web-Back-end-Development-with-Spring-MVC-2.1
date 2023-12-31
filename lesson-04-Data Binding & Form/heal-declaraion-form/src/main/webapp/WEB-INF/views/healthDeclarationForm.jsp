
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="healDeclaration" action="/form/submit" method="POST">

    <div>
        <label for="name">Họ và tên:</label>
        <form:input path="name" id="name" required="true" />
    </div>
    <div>
        <label for="birthYear">Năm sinh:</label>
        <form:input path="birthYear" id="birthYear" required="true" />
    </div>
    <div>
        <label for="genders">Giới tính:</label>
        <form:input path="genders" id="genders" required="true" />
    </div>
    <div>
        <label for="national">Quốc tịch:</label>
        <form:input path="national" id="national" required="true" />
    </div>
    <div>
        <label for="idCard">Số CMND:</label>
        <form:input path="idCard" id="idCard" required="true" />
    </div>
    <div>
        <label for="vehicle">Phương tiện: </label>
        <form:input path="vehicle" id="vehicle" required="true"/>
    </div>
    <div>
        <label for="licensePlate">Số hiệu phương tiện</label>
        <form:input path="licensePlate" id="licensePlate" required="true"/>
    </div>
    <div>
        <label for="numberOfSeat">Số chỗ ngồi:</label>
        <form:input path="numberOfSeat" id="numberOfSeat" required="true" />
    </div>
    <div>
        <label for="dateStart">Ngày bắt đầu:</label>
        <form:input type="date" path="dateStart" id="dateStart" required="true" />
    </div>
    <div>
        <label for="dateEnd">Ngày kết thúc:</label>
        <form:input type="date" path="dateEnd" id="dateEnd" required="true" />
    </div>
    <div>
        <label for="cityArrived">Thành phố đã đến:</label>
        <form:input path="cityArrived" id="cityArrived" required="true" />
    </div>
    <div>
        <label for="city">Thành phố:</label>
        <form:input path="city" id="city" required="true" />
    </div>
    <div>
        <label for="Province">Tỉnh/Thành phố:</label>
        <form:input path="province" id="Province" required="true" />
    </div>
    <div>
        <label for="address">Địa chỉ:</label>
        <form:input path="address" id="address" required="true" />
    </div>
    <div>
        <label for="phoneNumber">Số điện thoại:</label>
        <form:input path="phoneNumber" id="phoneNumber" required="true" />
    </div>
    <div>
        <label for="email">Email:</label>
        <form:input path="email" id="email" required="true" />
    </div>
    <c:forEach items="${healDeclaration.symptoms}" var="symptom" varStatus="status">
        <input type="checkbox" id="${symptom.key}" name="symptoms[${status.index}]" value="${symptom.key}" checked="${symptom.value}" />
        <label for="${symptom.key}">${symptom.key}</label><br>
    </c:forEach>

    <label>Exposure History:</label>
    <c:forEach items="${healDeclaration.exposureHistory}" var="history" varStatus="status">
        <input type="checkbox" id="${history.key}" name="exposureHistory[${status.index}]" value="${history.key}" checked="${history.value}" />
        <label for="${history.key}">${history.key}</label><br>
    </c:forEach>
    <button type="submit">Gửi Tờ Khai</button>

</form:form>
</body>
</html>
