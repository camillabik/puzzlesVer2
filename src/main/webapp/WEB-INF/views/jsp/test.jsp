
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Вопросы</title>
    <link href="resources/css/style.css" rel="stylesheet" />
</head>

<body>
<%--<form method="post" action="/web/test">--%>
    <table>
        <tr>
            <td align="center"></td>
        </tr>
    <c:forEach items="${questionList}" var="quest">
            <c:out value="${quest.name}"></c:out>
        <%--<c:forEach items="${answersByQuestion}" var="answer">--%>
            <%--<c:out value="${answer.name}"></c:out>--%>
        <%--</c:forEach>--%>
    </c:forEach>
<%--</form>--%>
    </table>
</body>
</html>


<%--<table border="1" cellspacing="0">--%>
    <%--<tr>--%>
        <%--<td align="center">name</td>--%>
        <%--<td align="center">description</td>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${categoryList}" var="category">--%>
        <%--<tr>--%>
            <%--<td><c:out value="${category.name}"></c:out></td>--%>
            <%--<td><c:out value="${category.description}"></c:out></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
