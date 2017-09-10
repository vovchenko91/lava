<%@ page import="edu.bionic.domain.Role" %>
<%@ page import="edu.bionic.domain.Position" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lava Админка | Редактирование пользователя</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>${isNew ? "Новый пользователь" : "Редактирование пользователя ".concat(user.name)}</h1>
<form:form modelAttribute="user">
    <form:hidden path="id"/>
    <p>
        <label>Имя</label>
        <form:input path="name"/>
        <form:errors path="name" cssStyle="color: red"/>
    </p>

    <p>
        <label>Email</label>
        <form:input path="email"/>
        <form:errors path="email" cssStyle="color: red"/>
    </p>

    <p>
        <label>Пароль</label>
        <form:password showPassword="true" path="password"/>
        <input type="checkbox" onchange="document.getElementById('password').type = this.checked ? 'text' : 'password'">
        Показать пароль
        <form:errors path="password" cssStyle="color: red"/>
    </p>

    <p>
        <label for="role">Роль</label><br>
        <form:radiobuttons path="role" items="<%= Role.values()%>"/>
        <form:errors path="role" cssStyle="color: red"/>
    </p>

    <p>
        <label for="position">Позиция</label><br>
        <form:radiobuttons path="position" items="<%= Position.values()%>"/>
        <form:errors path="position" cssStyle="color: red"/>

    </p>
    <a href="<c:url value="/admin/users"/>">
        <button type="button">Вернуться</button>
    </a>
    <button type="submit">Сохранить</button>
</form:form>
<c:if test="${updateIsSuccessful}">
    <span style="color: green;">Изменения сохранены</span>
</c:if>
</body>
</html>
