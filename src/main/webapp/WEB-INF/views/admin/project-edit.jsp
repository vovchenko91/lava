<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lava Админка | Редактирование проекта</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>${isNew ? "Новый проект" : "Редактирование проекта ".concat(project.name)}</h1>
<form:form modelAttribute="project">
  <form:hidden path="id"/>
  <p>
    <label for="name">Наименование</label>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>
  </p>
  <a href="<c:url value="/admin/projects"/>"><button type="button">Вернуться</button></a>
  <button type="submit">Сохранить</button>
</form:form>
<c:if test="${updateIsSuccessful}">
  <span style="color: green;">Изменения сохранены</span>
</c:if>
</body>
</html>

