<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>Проекты</h1>
<a href="<c:url value="/admin/projects/new"/>">
    <button type="button">Добавить проект</button>
</a>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th></th>
    </tr>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.id}</td>
            <td>${project.name}</td>
            <td>
                <a href="<c:url value="/admin/projects/${project.id}"/>">
                    <button type="submit">Редактировать</button>
                </a>

                <form method="post"
                      action="<c:url value="/admin/projects/${project.id}/delete"/>">
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/admin"/>">
    <button type="button">Вернуться</button>
</a>
</body>
</html>

