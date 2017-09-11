<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${title != null ? "Lava | ".concat(title) : "Lava"}</title>

    <%-- http://www.favicon-generator.org --%>

    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/img/lava-icon.png"/>"/>


    <link rel="stylesheet" href="<c:url value="/resources/lib/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/lib/font-awesome/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <script href="<c:url value="/resources/lib/js/jquery.3.2.1.js/"/>"></script>
    <script href="<c:url value="/resources/lib/js/popper.js/"/>"></script>
    <script href="<c:url value="/resources/lib/js/bootstrap.min.js"/>"></script>
    <script href="<c:url value="/resources/js/scripts.js"/>"></script>
</head>

