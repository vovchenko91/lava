<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-md navbar-dark bg-info mb-4">
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a href="<c:url value="/"/> " class="nav-link">Главная</a>
            </li>
            <li class="nav-item">
                <a href="<c:url value="/projects"/> " class="nav-link">Проекты</a>
            </li>
        </ul>
        <div>
            <sec:authorize access="isAuthenticated()">
                <div class="col-10 col-sm-auto">
                    <form:form servletRelativeAction="/logout" cssStyle="float: right">
                        <button class="btn btn-danger my-2 my-sm-2">Выйти</button>
                    </form:form>
                    <sec:authorize url="/admin">
                        <a href="<c:url value="/admin"/>" style="float: right">
                            <button class="btn btn-secondary my-2 my-sm-2">Админпанель</button>
                        </a>
                    </sec:authorize>
                   <%-- <h3 class="text-dark my-sm-2 text-sm-left " style="float: right">Добро пожаловать в Lava</h3>--%>
                </div>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <div class="col-10 col-sm-auto text-right">
                    <a href="<c:url value="/login"/>" style="float: right">
                        <button class="btn btn-success my-2 my-sm-0"> Войти</button>
                    </a>
                </div>
            </sec:authorize>
        </div>
    </div>
</nav>