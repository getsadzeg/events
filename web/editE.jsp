

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
          <div class="div2Form"> 
            <a href="index.jsp" class="linkForm" >
                    Events
            </a> </div>
        
          <div class="eventForm">
              <form action = "EventUpdateServlet" method = "post">
                  სახელი: <input type="text" name="name" value="<%=request.getAttribute("name")%>"> <br>   
                  აღწერა: <input type="text" name="desc" value="<%=request.getAttribute("desc")%>"> <br>   
                  თარიღი:  <input type="date" name="date" value="<%=request.getAttribute("date")%>"> <br>  
                  კატეგორია: <input type="text" name="category" value="<%=request.getAttribute("category")%>"> <br>   
                  <input type="submit" value="განახლება">
                 </form>
          </div>
        
    </body>
</html>
