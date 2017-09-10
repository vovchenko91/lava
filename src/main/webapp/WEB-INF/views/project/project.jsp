<%@ page import="edu.bionic.dto.TaskSort" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Lava | ${project.name}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h2>Поект: ${project.name}</h2>
<h1>Список задач: </h1>
<form id="myForm" name="myForm">
    <p>
        <label for="name">Имя задачи</label>
        <input type="text" id="name" name="name" value="${param.name}"/>
    </p>
    <p>
        <label for="assignee">Назначен на</label>
        <input type="text" id="assignee" name="assignee" value="${param.assignee}"/>
    </p>
    <p>
        <label for="sort">Сортировка</label>
        <select id="sort" name="sort">
            <option value="<%= TaskSort.NAME_ASC.name() %>"
                    <%= TaskSort.NAME_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                алфавиту А-Я
            </option>
            <option value="<%= TaskSort.NAME_DESC.name() %>"
                    <%= TaskSort.NAME_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                алфавиту Я-А
            </option>
        </select>
    </p>
    <button type="submit">Поиск</button>
    <Script>
        function clearFields(){
            var elmLength = document.myForm.elements.length;
            for (var i=0; i<elmLength; i++)
            {
                var typ = myForm.elements[i].type;
                if(typ=="text"){
                    document.myForm.elements[i].value="";
                }
            }
            return false;
        }
    </Script>
    <input type=reset value="Очистить" onClick="return a=clearFields()">
</form>

<a href="<c:url value="${project.id}/tasks/new"/> "><button>Создать новую задачу</button></a>
<a href="<c:url value="${project.id}/tasks/mytasks"/> "><button>Открыть мои задачи</button></a>
<%--ul>
    <c:if test="${tasks.size() == 0}">
      <div class="alert alert-dark">
        В данном проекте нет задач
      </div>
    </c:if>
    <c:forEach items="${tasks}" var="task">
      <jsp:useBean id="task" type="edu.bionic.domain.Task"/>
      <li><a href="<c:url value="${project.id}/tasks/${task.id}"/>">${project.name}-${task.id}: ${task.printInfo()}Status: ${task.status}</a></li>
    </c:forEach>
</ul>--%>

<c:choose>
    <c:when test="${tasks.size() == 0}">
    <div class="alert alert-dark">
        В данном проекте нет задач
    </div>
    </c:when>
    <c:otherwise>
    <table border="1" cellpadding="10">
        <tr>
            <%--<th>ID</th>--%>
            <th>Имя задачи</th>
            <th>Статус</th>
            <th>Назначен на</th>
            <th></th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <%--<td>${project.name}-${task.id}</td>--%>
                <td>${task.printInfo()}</td>
                <td>${task.status}</td>
                <td>${task.assignee.name}</td>
                <td>
                    <a href="<c:url value="${project.id}/tasks/${task.id}"/>">
                        <button type="submit">Открыть</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
<%-- Paginator --%>
<p>
  <c:set var="page" value="${param.page != null ? param.page : 1}"/>
  <c:set var="query" value="${pageContext.request.queryString != null ?
            pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
  <c:forEach begin="1" end="${taskCount % pageSize == 0 ?
        taskCount / pageSize :
        taskCount / pageSize + 1 }" varStatus="loop">
    <c:choose>
      <c:when test="${page == loop.index}">
        <button type="button" disabled>${loop.index}</button>
      </c:when>
      <c:otherwise>
        <a href="<c:url value="?${query}&page=${loop.index}"/>">
          <button type="button">${loop.index}</button>
        </a>
      </c:otherwise>
    </c:choose>
  </c:forEach>
</p>
    </c:otherwise>
</c:choose>
<a href="<c:url value="/projects"/> "><button>Назад</button></a>
<a href="<c:url value="/"/> "><button>На главную</button></a>
</body>
</html>
