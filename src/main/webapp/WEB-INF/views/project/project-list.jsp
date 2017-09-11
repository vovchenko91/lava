<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div class="ml-4">
    <div>
        <h1>Список проектов:</h1>
    </div>
    <div>
        <ul>
            <c:forEach items="${projects}" var="project">
                <jsp:useBean id="project" type="edu.bionic.domain.Project"/>
                <%--<li><c:out value="${product.printInfo()}"/></li>--%>
                <p><input type="button" class="btn btn-info" value="${project.printInfo()}"
                          onclick="location.href = 'projects/${project.id}';"></p>
            </c:forEach>
        </ul>
    </div>
    <a href="<c:url value="/"/> ">
        <button class="btn btn-outline-secondary">На главную</button>
    </a>
</div>
</body>
<jsp:include page="../components/footer.jsp"/>
</html>