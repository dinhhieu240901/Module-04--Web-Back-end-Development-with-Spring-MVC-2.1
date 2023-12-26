<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: navy;
        }
        h3 {
            color: red;
        }
        form {
            margin-top: 20px;
        }
        input[type="submit"]{
            margin-top:20px;
        }
    </style>
</head>
<body>
<h1>Email validate</h1>
<h3 style="color:red">${message}</h3>
<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="validate">
</form>

</body>

</html>