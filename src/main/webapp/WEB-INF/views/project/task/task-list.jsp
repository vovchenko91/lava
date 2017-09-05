<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 05.09.17
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lava</title>
</head>
<body>
<jsp:include page="../../components/header.jsp"/>
<h2>Поект: ${project.name}</h2>
<h1>Список задач: </h1>
<ul>
  <c:forEach items="${tasks}" var="task">
    <jsp:useBean id="task" type="edu.bionic.domain.Task"/>
    <li><a href="<c:url value="${task.id}"/>">${task.printInfo()} Status: ${task.status}</a></li>
  </c:forEach>
</ul>
<a href="<c:url value="/projects"/> "><button>Назад</button></a>
<a href="<c:url value="/"/> "><button>На главную</button></a>
</body>
</html>
