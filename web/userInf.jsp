
<%@page import="ge.mziuri.model.User"%>
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
                  <% 
                   User user = (User)request.getAttribute("User");
                   out.write("სახელი: <input type=\"text\" name=\"firstname\" value=\"" + user.getName() + "\"><br>");
                   out.write("გვარი: <input type=\"text\" name=\"lastname\" value=\"" + user.getSurname() + "\"><br>");
                   out.write("მომხმარებელი: <input type=\"text\" name=\"username\" value=\"" + user.getUsername() + "\"><br>");
       
                            %>
             <!--
           <input type="submit" value="განახლება"> 
           <a href="createE.jsp" class="btnform"><div> <h5> Create event </h5> </div> </a> -->
             </form>  </div>
           
            <div class="newform1">
              <h2>User's card info</h2>
              <form <!-- action="AccountUpdateServlet" method="post"-->
                    <% 
             
                   out.write("ბარათის კოდი: <input type=\"text\" name=\"card\" value=\"" + user.getCard().getCode() + "\"><br>");
                   out.write("ბარათის პასკოდი: <input type=\"password\" name=\"passcode\" value=\"" + user.getCard().getPasscode() + "\"><br>");
                   out.write("ბარათის ვადა: <input type=\"date\" name=\"expDate\" value=\"" + user.getCard().getExpDate() + "\"><br>");
       
                            %>
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
                         List<Event> myevents = (List<Event>)request.getAttribute("MyEvents");
                        for (Event event : myevents) {
                            out.write("<h4>" + event.getName() + "</h4>");
                            out.write("<h5>" + event.getDate() + "</h5>");
                           
                        } 
%>                  </div> 
          </div>
    </body>
</html>
