<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Загадки!</title>
    <link href="resources/css/style.css" rel="stylesheet" />
</head>
<body>
<form id="myForm" method="post" action="/web/authorization">
    <h3>
        Введите ваш логин:
    </h3>
    <input type="text" name="login"/>
    <h3>
        Введите ваш пароль:
    </h3>

    <input type="password" name="password"/>
    <a href="categories" target="black">
        <input type="submit" value="Войти"/>
    </a>
</form>
</body>
</html>
