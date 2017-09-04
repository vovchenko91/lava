<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lava | ${project.name}</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h2>Поект: ${project.name}</h2>
<h1>Список задач: </h1>
<a href="<c:url value="${project.id}/tasks/new"/> "><button>Создать новую задачу</button></a>
<ul>
  <%--<%--%>
  <%--List<Product> products = (List<Product>) request.getAttribute("products");--%>
  <%--for (Product product : products) {--%>
  <%--%>--%>
  <%--<li><%= product.printInfo() %></li>--%>
  <%--<%--%>
  <%--};--%>
  <%--%>--%>
    <c:if test="${tasks.size() == 0}">
      <div class="alert alert-dark">
        В данном проекте нет задач
      </div>
    </c:if>
    <c:forEach items="${tasks}" var="task">
      <jsp:useBean id="task" type="edu.bionic.domain.Task"/>
      <%--<li><c:out value="${product.printInfo()}"/></li>--%>
      <li><a href="<c:url value="${project.id}/tasks/${task.id}"/>">${task.printInfo()}</a></li>
    </c:forEach>
</ul>
<a href="<c:url value="/projects"/> "><button>Назад</button></a>
<a href="<c:url value="/"/> "><button>На главную</button></a>
</body>
</html>
