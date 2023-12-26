<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/25/2023
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        fieldset {
            border: 1px solid #007bff;
            padding: 10px;
            margin-bottom: 20px;
        }

        legend {
            font-size: 1.2em;
            font-weight: bold;
            color: #007bff;
        }

        p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
<fieldset>
    <legend>Customer Details</legend>
    <p>Name: ${customer.name}</p>
    <p>Email: ${customer.email}</p>
    <p>Address: ${customer.address}</p>
</fieldset>
</body>
</html>
