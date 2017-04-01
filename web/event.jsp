
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
        <div> 
          <div class="divForm"> 
            <a href="index.html" class="linkForm" >
                    Events
            </a> </div>
   
         <div class="DivTform"> 
             <a href="Login.html" class="btnform"><div class="divBForm"> 
                         <h5> Login </h5>
          </div> </a>
                 
        <a href="Register.html" class="btnform" ><div class="divBForm"> 
                         <h4> Register </h4>
          </div> </a>
              </div>
                   </div> 
        
        <form action = "EventViewServlet" method = "get">
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
             <form action="EventEditServlet" method="post">
             <div class="wrapper">
                 <input type="hidden" name="actionType" value="edit">
                 <input type="submit" name="button" class="buttonForm" value="Edit">
             </div>
             
        </form>
       
           
             <div class="wrapper">
                 <select>
                    <%
                       /* List<Integer> numbers = (List<Integer>)request.getAttribute("freePlaces");
                        for (int number : numbers) {
                            out.write("<option value=\" " + number + "\">" + number + "</option>");
                        } */
                    %>
                 </select>
             </div>
                 
          
             
        <div class="wrapper">
    
            <form action="EventViewEditServlet" method="post">
                <input type="button" class="buttonForm" value="Buy ticket">   
          </form>

        
          <!--<form formAction="EventViewEditServlet" method="post">
            <input type="submit" name="actionType" class="buttonForm" value="Edit">   
          </form> --->
        
          </div>
        </body>
</html>
