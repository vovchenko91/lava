<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="components/head.jsp"/>
<body>
<jsp:include page="components/header.jsp"/>
<div class="container  col-md-4">
    <div class="jumbotron">
        <h1 class="form-signin-heading">Войдите в Lava</h1>
        <c:if test="${param.error != null}">
            <p style="color: red;">
                Неправильное имя или пароль
            </p>
        </c:if>
        <c:if test="${param.logout != null}">
            <p style="color: green;">
                Вы успешно вышли
            </p>
        </c:if>
        <form:form>
            <p>
                <label for="username" class="sr-only">Email</label>
                <input id="username" name="username" class="form-control" placeholder="Email address" autofocus/>
            </p>

            <p>
                <label for="password" class="sr-only">Пароль</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
            </p>
            <button class="btn btn-lg btn-primary btn-block">Войти</button>
        </form:form>
    </div>
</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>

