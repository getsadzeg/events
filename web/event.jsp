
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    
    <body>
        <div class="divForm"> 
            <a href="index.html" class="linkForm" >
                    Events.ge
                </a> 
        </div>
        
        <h1 class="hForm"> სახელი </h1>
         <div class="eventForm">
             <span> აღწერა: </span>
             <span> <%=request.getAttribute("description")%> </span>
             <br>
             <span> თარიღი: </span>
             <span> <%=request.getAttribute("date")%> </span> 
             <br>
             <span> ფასი: </span>
             <span>  <%=request.getAttribute("price")%> </span>
             <br>
             <span> კატეგორია: </span>
             <span>  <%=request.getAttribute("category")%> </span> 
             <br>
             <span> ტიპი: </span>
             <span>  <%=request.getAttribute("type")%> </span>
             <br>
             <span> ადგილები: </span>
             <span>  <%=request.getAttribute("places")%> </span> 
             <br>
             <span> ავტორი: </span>
             <span>  <%=request.getAttribute("author")%> </span> 
        </div>
       
        <div class="wrapper">
        <button class="buttonForm"> Buy </button> 
        </div>
        </body>
</html>
