<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
<head>
    <title>Lava | Главная</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>
<h1>Добро пожаловать в Lava</h1>
<ul>
    <li><a href="<c:url value="/projects"/>">Список проектов</a></li>
</ul>
</body>
</html>--%>

<html>
<jsp:include page="components/head.jsp"/>
<body>
<jsp:include page="components/header.jsp"/>
<div>
    <h1>Добро пожаловать в Lava</h1>
</div>
<div>
    <div>
        <div>
            <ul>
                <input type="button" class="btn btn-info" value="Список проектов" onclick="location.href = '/projects';">
            </ul>
        </div>
    </div>
</div>
</body>
</html>
