<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">
        <div class="col-12 mt-5">

            <h1 class="text-center">Проекты</h1>

            <div class="mt-3 text-center text-sm-left">
                <a href="<c:url value="/admin/projects/new"/>" class="btn btn-info">
                    Добавить проект
                </a>
            </div>

            <div id="project-list" class="mt-3">
                <table border="1" cellpadding="5" class="table">
                    <tr>
                        <th>ID</th>
                        <th>Имя</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${projects}" var="project">
                        <tr>
                            <td>${project.id}</td>
                            <td>${project.name}</td>
                            <td>
                                <div class="form-group">
                                    <a href="<c:url value="/admin/projects/${project.id}"/>"
                                       class="btn btn-secondary btn-block">
                                        Редактировать
                                    </a>
                                </div>

                                <form method="post"
                                      action="<c:url value="/admin/projects/${project.id}/delete"/>">
                                    <button type="submit" class="btn btn-danger btn-block">Удалить</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="mt-3 text-center text-sm-left">
                <a href="<c:url value="/admin"/>" class="btn btn-outline-secondary">
                    Вернуться
                </a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>

