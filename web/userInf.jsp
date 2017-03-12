
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div  class="registerForm">
           <form action="/action_page.php">
           სახელი: <input type="text" name="fname" value="<%=request.getAttribute("name")%>"><br>
           გვარი: <input type="text" name="lname" value="<%=request.getAttribute("surname")%>"><br>
           ბარათის კოდი: <input type="text" name="card" value="<%=request.getAttribute("cardinf")%>"> <br>
           ბარათის ვადა: <input type="date" value="<%=request.getAttribute("date")%>">
           <input type="submit" value="შეცვლა">
</form>
        </div>
    </body>
</html>
