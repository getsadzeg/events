
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Events - Login</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div class="loginForm">
            <form action="LoginServlet" method="post">
                <input type="text" name="username" /> <br>
                <input type="password" name="password" /> <br>
                <a href="register.jsp"> რეგისტრაცია </a>
                <input type="submit" value="შესვლა" />
            </form>
        </div>
    </body>
</html>

