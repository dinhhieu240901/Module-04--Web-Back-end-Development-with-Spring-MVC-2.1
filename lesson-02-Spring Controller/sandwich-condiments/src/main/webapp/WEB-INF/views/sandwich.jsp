<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sandwich" method="post">
    <input type="checkbox" name="condiment" value=" Lettuce" /> Lettuce
    <input type="checkbox" name="condiment" value=" Tomato" /> Tomato
    <input type="checkbox" name="condiment" value=" Mustard" /> Mustard
    <input type="checkbox" name="condiment" value=" Sprout" /> Sprout
    <input type="submit" value="Save" />
</form>

<h1>${showCondiment} ${selectCondiment}</h1>
</body>
</html>