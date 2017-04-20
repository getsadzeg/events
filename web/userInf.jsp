
<%@page import="ge.mziuri.model.Event"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
          
        
        <div  class="dform">
            <div class="newform1">
             <h2>User's info</h2>
             <form <!-- action="AccountUpdateServlet" method="post"-->
              სახელი: <input type="text" name="firstname" value="<%=request.getAttribute("name")%>"><br>
              გვარი: <input type="text" name="lastname" value="<%=request.getAttribute("surname")%>"><br>
              მომხმარებელი : <input type="text" name="username" value="<%=request.getAttribute("username")%>"> <br>
             <!--
           <input type="submit" value="განახლება"> 
           <a href="createE.jsp" class="btnform"><div> <h5> Create event </h5> </div> </a> -->
             </form>  </div>
           
            <div class="newform1">
              <h2>User's card info</h2>
              <form <!-- action="AccountUpdateServlet" method="post"-->
               ბარათის კოდი: <input type="text" name="card" value="<%=request.getAttribute("cardcode")%>"> <br>
               ბარათის პასკოდი: <input type="password" name="passcode" value="<%=request.getAttribute("passcode")%>"> <br>
               ბარათის ვადა: <input type="date" name="expdate" value="<%=request.getAttribute("expdate")%>" <br>  
            
              </form>  </div>
        </div>
             
          <div class="dform">   
           <div class="newform1"> 
               <h2>User's bought tickets</h2>
               <%
                         List<Event> events = (List<Event>)request.getAttribute("BoughtTickets");
                        for (Event event : events) {
                            out.write("<h4>" + event.getName() + "</h4>");
                            out.write("<h5>" + event.getDate() + "</h5>");
                           
                        } 
%>                  </div> 

          <div class="newform1"> 
              <h2>User's events</h2>
               <%
                         List<Event> myevents = (List<Event>)request.getAttribute("UserEvents");
                        for (Event event : myevents) {
                            out.write("<h4>" + event.getName() + "</h4>");
                            out.write("<h5>" + event.getDate() + "</h5>");
                           
                        } 
%>                  </div> 
          </div>
    </body>
</html>
