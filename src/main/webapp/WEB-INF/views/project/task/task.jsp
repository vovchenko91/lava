<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
  <p>
    <strong>Имя:</strong> ${task.name} <br/>
    <strong>Тип:</strong> ${task.type} <br/>
    <strong>Статус:</strong> ${task.status} <br/>
    <strong>Приоритет:</strong> ${task.priority} <br/>
    <strong>Описание:</strong> ${task.description} <br/>
    <strong>Назначен на:</strong> ${task.assignee.name}
  </p>
  <a href="<c:url value="/projects/${task.project.id}"/> "><button>Назад</button></a>
  <a href="<c:url value="/"/> "><button>На главную</button></a>
</body>
