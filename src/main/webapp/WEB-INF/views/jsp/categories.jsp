
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Загадки!</title>
    <link href="resources/css/categories.css" rel="stylesheet" />
</head>
<body>
<div class="container">
    <form method="get" action="/web/categories">
    <h1>Загадки</h1>
    <h2>Выбери категорию:</h2>
    <c:forEach items="${categoryList}" var="category">
            <a href="test">
            <div>
                <button type="button">
                    <c:out value="${category.name}"></c:out>
                </button>
            </div>
            </a>
    </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
