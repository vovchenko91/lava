<%@ page import="edu.bionic.domain.Type" %>
<%@ page import="edu.bionic.domain.Priority" %>
<%@ page import="edu.bionic.domain.Status" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 04.09.17
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lava | Создание новой задачи</title>
</head>
<body>
<jsp:include page="../../components/header.jsp"/>
<h4>${isNew ? "Новая задача" : "Редактирование задачи ".concat(task.name)}</h4>
<form:form modelAttribute="task">
    <p>
        <label for="name">Краткое описание: </label>
        <form:textarea path="name" rows="1" cols="50" class="form-control"/>
        <form:errors path="name" cssStyle="color: red"/>
    </p>

    <p>
        <label for="type">Тип: </label>
        <form:radiobuttons path="type" items="<%= Type.values()%>"/>
        <form:errors path="type" class="text-danger"/>
    </p>

    <p>
        <label for="status">Статус: </label>
        <form:radiobuttons path="status" items="<%= Status.values()%>"/>
        <form:errors path="status" class="text-danger"/>
    </p>

    <p>
        <label for="priority">Приоритет: </label>
        <form:radiobuttons path="priority" items="<%= Priority.values()%>"/>
        <form:errors path="priority" class="text-danger"/>
    </p>

    <p>
        <label for="description">Описание: </label>
        <form:textarea path="description" rows="6" cols="50" class="form-control"/>
        <form:errors path="description" cssStyle="color: red"/>
    </p>

    <p>
        <label for="assignee.id">Назначить на: </label>
        <form:select path="assignee.id">
            <form:options items="${users}" itemLabel="name" itemValue="id"/>
        </form:select>
    </p>

    <p>
        <label>Репортер: </label>
        <c:out value="${user.name}"/>
    </p>
    <form:hidden path="project.id" value="${project.id}"/>
    <form:hidden path="reporter.id" value="${user.id}"/>
    <button type="submit">Сохранить</button>
</form:form>
<a href="<c:url value="/projects/${task.project.id}"/> ">
    <button>Вернуться</button>
</a>
<c:if test="${updateIsSuccessful}">
    <span style="color: green;">Изменения сохранены</span>
</c:if>
</body>
</html>
