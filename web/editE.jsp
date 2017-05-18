

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editing <%=request.getAttribute("name")%></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
          
        
          <div class="eventForm">
              <form action = "EventUpdateServlet" method = "post">
                  Name: <input type="text" name="name" value="<%=request.getAttribute("name")%>"> <br>   
                  Description: <input type="text" name="desc" value="<%=request.getAttribute("desc")%>"> <br>   
                  Date:  <input type="date" name="date" value="<%=request.getAttribute("date")%>"> <br>  
                  Category: <input type="text" name="category" value="<%=request.getAttribute("category")%>"> <br>   
                  <input type="submit" value="Edit">
                 </form>
          </div>
        
    </body>
</html>
