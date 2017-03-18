
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Event Page</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    
    <body>
        <div class="divForm"> 
            <a href="index.html" class="linkForm" >
                    Events
                </a> 
        </div>
        
        <form action = "EventViewServlet" method = "post">
        <h1 class="hForm"> <%=request.getAttribute("name")%> </h1>
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
        </form>
       
           
             <div class="wrapper">
                 <select>
                    <%
                        List<Integer> numbers = (List<Integer>)request.getAttribute("freePlaces");
                        for (int number : numbers) {
                            out.write("<option value=\" " + number + "\">" + number + "</option>");
                        }
                    %>
                 </select>
             </div>
                 
          
             
        <div class="wrapper">
    
            <form formAction="BuyTicketServlet" method="post">
                <input type="button"  class="buttonForm" value="Buy ticket">   
          </form>

        
          <form formAction="EventViewEditServlet" method="post">
            <input type="hidden" name="actionType" value="edit">  
            <input type="button" class="buttonForm" value="Edit">   
          </form>
        
          </div>
        </body>
</html>
