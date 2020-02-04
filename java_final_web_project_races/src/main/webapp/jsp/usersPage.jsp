<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/usersPage.css">
    <title>Document</title>
</head>
<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>
    <main>
         <section class="users">
            <h4>Users Table</h4> 
            <table>
                <tr>
                    <th>User id</th>
                    <th>User login</th>
                    <th>User password</th>
                    <th>User status</th>
                    <th>User type</th>
                    <th>User money balance</th>
                </tr>
                <c:forEach var="user" items="${users}" varStatus="loop">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.userLogin}</td>
                        <td>${user.userPassword}</td>
                        <td>${user.userStatus}</td>
                        <td>${user.userType}</td>
                        <td>${user.moneyBalance}</td>
                        <td><form name="status" method="post" action="controller" id="status${user.userId}">
                                <input type="hidden" name="userId" value="${user.userId}">
                                <input type="hidden" name="command" value="changeUserStatus"/>
                                <input type="submit" value="change status">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table> 
        </section>
    </main>
    <footer>
            <jsp:include page="footer.jsp" />
    </footer>