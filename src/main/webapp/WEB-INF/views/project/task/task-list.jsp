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
<jsp:include page="../../components/head.jsp"/>
<body>
<jsp:include page="../../components/header.jsp"/>
<h2>Поект: ${project.name}</h2>

<h1>Список задач для пользователя ${user.name}: </h1>

<div class="row">
    <div class="col-12 mt-5">
        <div id="tasks-list" class="mt-3">
            <table border="1" cellpadding="10" class="table bg-info text-light">
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
                                <a href="<c:url value="${task.id}"/>"
                                   class="btn btn-secondary btn-light">
                                    Открыть
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<a href="<c:url value="/projects"/>" class="btn btn-outline-secondary">
    Назад
</a>
<a href="<c:url value="/"/>" class="btn btn-outline-secondary">
    На главную
</a>

<jsp:include page="../../components/footer.jsp"/>
</body>
</html>
