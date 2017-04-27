
<%@page import="ge.mziuri.model.Ticket"%>
<%@page import="ge.mziuri.model.Card"%>
<%@page import="ge.mziuri.model.User"%>
<%@page import="ge.mziuri.model.Event"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>My Account</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>


        <div  class="dform">
            <div class="newform1">
                <h2>User's info</h2>
                <form action="MyAccountServlet" method="post">
                    <%
                        User user = (User) request.getAttribute("User");
                        out.write("სახელი: <input type=\"text\" name=\"firstname\" value=\"" + user.getName() + "\"><br>");
                        out.write("გვარი: <input type=\"text\" name=\"lastname\" value=\"" + user.getSurname() + "\"><br>");
                        out.write("ახალი პაროლი: <input type=\"password\" name=\"password\"><br>");

                    %>
                    <input type="submit" value="განახლება">
                    <input type="hidden" name = "updateValue" value = "userUpdate">
                    </form>
                  </div>

            <div class="newform1">
                <h2>User's card info</h2>
                <form action="MyAccountServlet" method="post">
                    <%                        
                        Card card = (Card) request.getAttribute("Card");
                        out.write("ბარათის კოდი: <input type=\"text\" name=\"cardcode\" value=\"" + card.getCode() + "\"><br>");
                        out.write("ბარათის პასკოდი: <input type=\"password\" name=\"passcode\" value=\"" + card.getPasscode() + "\"><br>");
                        out.write("ბარათის ვადა: <input type=\"date\" name=\"expDate\" value=\"" + card.getExpDate() + "\"><br>");

                    %>
                    <input type="submit" value="განახლება">
                    <input type="hidden" name = "updateValue" value = "cardUpdate">
                    </form>
                  </div>
        </div>

        <div class="dform">   
            <div class="newform1"> 
                <h2>User's bought tickets</h2>
                
                    <%                       
                        List<Ticket> tickets = (List<Ticket>) request.getAttribute("BoughtTickets");
                        for (Ticket ticket : tickets) {
                            out.write("<h4>" + ticket.getEvent().getName() + "</h4>");
                            out.write("<h5>" + ticket.getEvent().getDate().toString() + "</h5>");

                        }
                    %>                
            </div>
            <div class="newform1"> 
                <h2>User's events</h2>
                
                    <%
                        List<Event> myevents = (List<Event>) request.getAttribute("myEvents");
                        for (Event event : myevents) {
                            out.write("<h4>" + event.getName() + "</h4>");
                            out.write("<h5>" + event.getDate() + "</h5>");

                        }
                    %> 
                    
                    <a href="createE.jsp" class="btnform">
                        <div class="diForm"> 
                            <h5>Create event</h5> 
                        </div> 
                    </a>
            </div> 
        </div>

    </body>
</html>
