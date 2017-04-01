
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Events - Registration</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div class="registerForm">
            <form action="RegisterServlet" name="registerForm" method="post">
                სახელი:     <input type="text" name="firstName"/> <br>
                გვარი:      <input type="text" name="lastName" /> <br>
                მომ. სახ. : <input type="text" name="username" /> <br>
                პაროლი:   <input type="password" name="password" /> <br>
                გაიმეორეთ: <input type="password" name ="password2"/> <br>
                <input type="submit" value="რეგისტრაცია" />
            </form>
        </div>
    </body>
</html>

