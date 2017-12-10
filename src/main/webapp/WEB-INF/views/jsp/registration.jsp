
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Загадки!</title>
      <link href="resources/css/style.css" rel="stylesheet" />
  </head>
  <body>
  <form id="myForm" method="post" action="/web/registration">
        <h3>
          Введите вашe имя:
      </h3>
      <input type="text" name="name"/>
      <h3>
          Введите ваш логин:
      </h3>
      <input type="text" name="login"/>
    <h3>
      Введите ваш пароль:
    </h3>
    <input type="password" name="password"/>
      <a href="hello_authorization">
    <input type="submit" value="Зарегистрироваться"/>
      </a>
  </form>
  </body>
</html>





