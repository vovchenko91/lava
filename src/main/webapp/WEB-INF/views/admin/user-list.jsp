<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lava Админка  | Список пользователей</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>Проекты</h1>
<a href="<c:url value="/admin/users/new"/>">
  <button type="button">Добавить пользователя</button>
</a>
<table border="1" cellpadding="5">
  <tr>
    <th>ID</th>
    <th>Имя</th>
    <th>Email</th>
    <th>Роль</th>
    <th>Позиция</th>
    <th></th>
  </tr>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.email}</td>
      <td>${user.role}</td>
      <td>${user.position}</td>
      <td>
        <a href="<c:url value="/admin/users/${user.id}"/>">
          <button type="submit">Редактировать</button>
        </a>
        <form method="post"
              action="<c:url value="/admin/users/${user.id}/delete"/>">
          <button type="submit">Удалить</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="<c:url value="/admin"/>"><button type="button">Вернуться</button></a>
</body>
</html>
