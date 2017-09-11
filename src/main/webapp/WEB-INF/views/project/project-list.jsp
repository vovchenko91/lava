<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>Список проектов</h1>
<ul>
    <%--<%--%>
    <%--List<Product> products = (List<Product>) request.getAttribute("products");--%>
    <%--for (Product product : products) {--%>
    <%--%>--%>
    <%--<li><%= product.printInfo() %></li>--%>
    <%--<%--%>
    <%--};--%>
    <%--%>--%>
    <c:forEach items="${projects}" var="project">
        <jsp:useBean id="project" type="edu.bionic.domain.Project"/>
        <%--<li><c:out value="${product.printInfo()}"/></li>--%>
        <li><a href="<c:url value="projects/${project.id}"/>">${project.printInfo()}</a></li>
    </c:forEach>
</ul>
<a href="<c:url value="/"/> ">
    <button class="btn btn-dark">На главную</button>
</a>
</body>
<jsp:include page="../components/footer.jsp"/>
</html>