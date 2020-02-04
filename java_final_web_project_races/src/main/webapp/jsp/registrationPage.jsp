<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/registration.css"/>
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
		<title>Registration Page</title>
	</head>
	<body>
	    <header>
            <jsp:include page="header.jsp" />
        </header>

        <main>
            <section class="registration_form">
                <h4>REGISTRATION FORM</h4>
                <form name="registration-form" method="post" action="controller">
                    
                    <input type="hidden" name="command" value="registration" />

                    <label for="login">Enter your username</label>
                    <input id="login" type="text" name="login"/>

                    <label for="password">Enter your password</label>
                    <input id="password" type="text" name="password"/>

                    <label for="type">Enter your type</label>
                    <input id="type" type="text" name="type"/>

                    <label for="money_balance">Enter your money balance</label>
                    <input id="money_balance" type="text" name="money_balance"/>

                    <input type="submit" value="Register">
                </form>
            </section>
        </main>

        <footer>
            <jsp:include page="footer.jsp" />
        </footer>

    </body>
</html>