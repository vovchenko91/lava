<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 01.09.17
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>Задача ${task.name}</title>
</head>
<jsp:include page="../../components/header.jsp"/>
<body>
<c:if test="${user.id == task.assignee.id}">
  <div class="alert alert-dark">
    <a href=""/> <button>Open</button></a>
    <a href=""/> <button>In progress</button></a>
    <a href=""/>  <button>QA</button></a>
    <a href=""/>  <button>Reopen</button></a>
    <a href=""/>  <button>Close</button></a>
  </div>
</c:if>
  <p>
    <strong>Имя:</strong> ${task.name} <br/>
    <strong>Тип:</strong> ${task.type} <br/>
    <strong>Статус:</strong> ${task.status} <br/>
    <strong>Приоритет:</strong> ${task.priority} <br/>
    <strong>Описание:</strong> ${task.description} <br/>
    <strong>Назначен на:</strong> ${task.assignee.name} <br/>
    <strong>Репортер:</strong> ${task.reporter.name}
  </p>
<h3>Комментарии:</h3>
<c:forEach items="${comments}" var="comment">
  <div class="comment">
    <div class="date">${comment.dateTime.format(dateTimeFormatter)}</div>
    <div class="head">
      <strong>${comment.author.name}</strong>
    </div>
    <div class="body">
        ${comment.text}
    </div>
  </div><br/>
</c:forEach>
<h3>Добавить комментарий</h3>
<form:form modelAttribute="newComment" method="post" servletRelativeAction="/comments/">

    <label for="text">Комментарий:</label>
    <form:textarea id="text" path="text" rows="10" cols="30" class="form-control"/>
    <form:errors path="text" cssStyle="color: red"/>

  <form:hidden path="task.id" value="${task.id}"/>
  <form:hidden path="author.id" value="${user.id}"/>
  <form:hidden path="task.project.id" value="${project.id}"/>
  <div>
    <button type="submit" class="btn btn-dark">Отправить</button>
  </div>

</form:form>
  <a href="<c:url value="/projects/${task.project.id}"/> "><button>Назад</button></a>
  <a href="<c:url value="/"/> "><button>На главную</button></a>
</body>
