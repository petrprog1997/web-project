<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <title></title>
</head>
<body>
    <header>
        <section class="header">
            <h1>HORSE RACES</h1>
                <div>
                    <a href="${request.contextPath}controller?command=profilePage">${login}</a>
                    <c:if test="${role == NULL}">
                        <a href="${request.contextPath}controller?command=loginPage">LOG IN</a>
                    </c:if>
                    <c:if test="${role != NULL}">
                        <a href="${request.contextPath}controller?command=logout">LOG OUT</a>
                    </c:if>

                </div>
        </section>
        <section class="menu">
            <nav>
                <ul>
                    <li><a href="${request.contextPath}controller?command=mainPage">MAIN</a></li>
                    <li><a href="${request.contextPath}controller?command=newsPage">NEWS</a></li>
                    <li><a href="${request.contextPath}controller?command=runsPage">RUNS</a></li>
                    <li><a href="${request.contextPath}controller?command=aboutPage">ABOUT</a></li>
                    <c:if test="${role == 'ADMINISTRATOR'}">
                        <li><a href="${request.contextPath}controller?command=usersPage">USERS</a></li>
                    </c:if>
                </ul>
            </nav>
        </section>
    </header>
</body>
</html>