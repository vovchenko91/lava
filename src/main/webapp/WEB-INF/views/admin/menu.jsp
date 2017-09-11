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
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div>
    <h1>Выберите, что вы хотите редактировать</h1>
</div>
<div>
    <ul>
        <p><input type="button" class="btn btn-info" value="Список проектов"
                  onclick="location.href = '/admin/projects';"></p>

        <p><input type="button" class="btn btn-info" value="Список пользователей"
                  onclick="location.href = '/admin/users';"></p>
    </ul>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
