
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div  class="registerForm">
           <form action="/action_page.php"> <!what is it?!>
           სახელი: <input type="text" name="firstname" value="<%=request.getAttribute("name")%>"><br>
           გვარი: <input type="text" name="lastname" value="<%=request.getAttribute("surname")%>"><br>
           ბარათის კოდი: <input type="text" name="card" value="<%=request.getAttribute("cardcode")%>"> <br>
           ბარათის პასკოდი: <input type="password" name="passcode" value="<%=request.getAttribute("passcode")%>"> <br>
           ბარათის ვადა: <input type="date" name="expdate" value="<%=request.getAttribute("expdate")%>">
           <input type="submit" value="განახლება">
</form>
        </div>
    </body>
</html>
