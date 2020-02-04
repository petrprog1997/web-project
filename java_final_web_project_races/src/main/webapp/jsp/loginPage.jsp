<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
		<title>Login Page</title>
	</head>
	<body>
	    <header>
            <jsp:include page="header.jsp" />
        </header>

        <main>
            <section class="login_form">
                <h4>LOGIN FORM</h4>
                <form name="login-form" method="post" action="controller">
                    <input type="hidden" name="command" value="login" />

                    <label for="login">Enter your username</label>
                    <input id="login" type="text" name="login"/>

                    <label for="password">Enter your password</label>
                    <input id="password" type="text" name="password"/>
                    <span>${errorMessage}</span>
                    <input type="submit" value="Log in">
                </form>
                <p>If you don't have an account</p>
                <form name="register-form" method="post" action="controller">
                    <input type="hidden" name="command" value="registrationPage" />
                    <input type="submit" value="Register">
                </form>
            </section>
        </main>

        <footer>
            <jsp:include page="footer.jsp" />
        </footer>

    </body>
</html>