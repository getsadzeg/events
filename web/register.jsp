
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
                Name:     <input type="text" name="firstName"/> <br>
                Surname:      <input type="text" name="lastName" /> <br>
                Username: <input type="text" name="username" /> <br>
                Password:   <input type="password" name="password" /> <br>
                Repeat password: <input type="password" name ="password2"/> <br>
                <input type="submit" value="Register" />
            </form>
        </div>
        <a href="index.jsp" class="btnform">
            <div class="diForm"> 
                <h5>Homepage</h5> 
            </div>
        </a>
    </body>
</html>

