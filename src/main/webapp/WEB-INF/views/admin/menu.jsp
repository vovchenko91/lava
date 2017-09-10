<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 30.08.17
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lava Админка | Главная</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>Выберите, что вы хотите редактировать</h1>
<ul>
    <li><a href="<c:url value="/admin/projects"/>">Список проектов</a></li>
    <li><a href="<c:url value="/admin/users"/>">Список пользователей</a></li>
</ul>
</body>
</html>
