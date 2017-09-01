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
<head>
    <title>Lava | Главная</title>
</head>
<body>
<c:set var="title" value="Lava | Главная" scope="request"/>
<body>
<jsp:include page="components/header.jsp"/>
<div class="col-4">
    <h1>Добро пожаловать в Lava</h1>
</div>
<div id="main" class="container">
    <div class="row align-items-center">
        <div class="col-4">
            <ul>
                <li><a href="<c:url value="/projects"/>">Список проектов</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
