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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div class="container ml-4">
    <div>
        <h2>Поект: ${project.name}</h2>
    </div>
    <div>
        <h1>Список задач: </h1>
    </div>

    <form id="myForm" name="myForm">
        <p>
            <label for="name" class="text-info">Имя задачи</label>
            <input type="text" id="name" name="name" value="${param.name}"/>
        </p>

        <p>
            <label for="assignee" class="text-info">Назначен на</label>
            <input type="text" id="assignee" name="assignee" value="${param.assignee}"/>
        </p>


        <p>

            <label for="sort" class="text-info">Сортировка</label>
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
        <button type="submit" class="btn btn-outline-success">Поиск</button>
        <input type=reset class="btn btn-outline-danger" value="Очистить" onClick="return a=clearFields()">
        <Script>
            function clearFields() {
                var elmLength = document.myForm.elements.length;
                for (var i = 0; i < elmLength; i++) {
                    var typ = myForm.elements[i].type;
                    if (typ == "text") {
                        document.myForm.elements[i].value = "";
                    }
                }
                return false;
            }
        </Script>

    </form>

    <a href="<c:url value="${project.id}/tasks/new"/> " class="btn btn-outline-info">
        Создать новую задачу
    </a>
    <a href="<c:url value="${project.id}/tasks/mytasks"/> " class="btn btn-outline-info">
        Открыть мои задачи
    </a>

    <c:choose>
        <c:when test="${tasks.size() == 0}">
            <div class="alert alert-dark">
                В данном проекте нет задач
            </div>
        </c:when>

        <c:otherwise>
            <div class="row">
                <div class="col-12 mt-5">
                    <div id="tasks-list" class="mt-3">
                        <table border="1" cellpadding="10" class="table btn-info">
                            <tr>
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
                                        <div class="form-group">
                                            <a href="<c:url value="${project.id}/tasks/${task.id}"/>"
                                               class="btn btn-secondary btn-light">
                                                Открыть
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                            <%-- Paginator --%>
                        <div class="container">
                            <ul class="pagination">
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
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
    <div>
        <a href="<c:url value="/projects"/>" class="btn btn-outline-secondary">
            Назад
        </a>
        <a href="<c:url value="/"/>" class="btn btn-outline-secondary">
            На главную
        </a>
    </div>
    </br>
</div>
</br>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
