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
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div class="container ml-4">
    <div>
        <h1>${isNew ? "Новый пользователь" : "Редактирование пользователя ".concat(user.name)}</h1>
    </div>

    <form:form modelAttribute="user">
        <form:hidden path="id"/>
        <p>
            <label class="text-info">Имя</label>
            <form:input path="name"/>
            <form:errors path="name" cssStyle="color: red"/>
        </p>

        <p>
            <label class="text-info">Email</label>
            <form:input path="email"/>
            <form:errors path="email" cssStyle="color: red"/>
        </p>

        <p>
            <label class="text-info">Пароль</label>
            <form:password showPassword="false" path="password"/>
            <input type="checkbox"
                   onchange="document.getElementById('password').type = this.checked ? 'text' : 'password'">
            Показать пароль
            <form:errors path="password" cssStyle="color: red"/>
        </p>

        <%--<div id="tab" class="btn-group" data-toggle="buttons-radio">
            <a href="#prices2" class="btn btn-large btn-info active" data-toggle="tab">Prices</a>
            <a href="#features2" class="btn btn-large btn-info" data-toggle="tab">Features</a>
            <a href="#requests2" class="btn btn-large btn-info" data-toggle="tab">Requests</a>
            <a href="#contact2" class="btn btn-large btn-info" data-toggle="tab">Contact</a>
        </div>--%>
        <div class="form-check ml-3">
            <p>

            <h4><label class="text-info" for="role">Роль</label></h4>
            <form:radiobuttons cssClass="form-check-input" path="role" items="<%= Role.values()%>"/>
            <form:errors path="role" cssStyle="color: red"/>
            </p>
        </div>
        <div class="form-check ml-3">
            <p>
            <h4><label class="text-info" for="position">Позиция</label></h4>
            <form:radiobuttons cssClass="form-check-input" path="position" items="<%= Position.values()%>"/>
            <form:errors path="position" cssStyle="color: red"/>
            </p>
        </div>

        <a href="<c:url value="/admin/users"/>" class="btn btn-outline-secondary">
            Вернуться
        </a>

        <button type="submit" class="btn btn-outline-success">Сохранить</button>
    </form:form>
    <c:if test="${updateIsSuccessful}">
        <span style="color: green;">Изменения сохранены</span>
    </c:if>
</div></br>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
