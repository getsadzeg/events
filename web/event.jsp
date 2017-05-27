
<%@page import="ge.mziuri.model.Event"%>
<%@page import="ge.mziuri.dao.EventDAOImpl"%>
<%@page import="ge.mziuri.dao.EventDAO"%>
<%@page import="ge.mziuri.util.CookieUtil"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Event: <%=request.getAttribute("name")%></title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <div> 
            <div class="divForm"> 
                <a href="index.jsp" class="linkForm" >
                    Events
                </a> </div>
                <%
                    boolean existUser = false;
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("userIDCookie")) {
                                existUser = true;
                            }
                        }
                    }
                %>
            <div class="DivTform"> 
                <a href="
                   <%
                       boolean link = false;
                       if (existUser) {
                           out.write("MyAccountServlet");
                       } else {
                           out.write("login.jsp");
                           link = true;
                       }
                   %>   
                   " class="btnform"><div class="divBForm"> 
                        <h5> 
                            <%
                                boolean text = false;
                                if (existUser) {
                                    out.write("My Account");
                                } else {
                                    out.write("Login");
                                    text = true;
                                }
                            %> 
                        </h5>
                    </div> </a>


                <%
                    if (link && text) {
                        out.write("<a href=\"register.jsp\" class=\"btnform\"><div class=\"divBForm\">");
                        out.write("<h5>");
                        out.write("Register");
                        out.write("</h5>");
                        out.write("</div> </a>");
                    }
                    if(existUser) {
                        out.write("<a href=\"LogoutServlet\" class=\"btnform\"><div class=\"divBForm\">");
                        out.write("<h5>Log out</h5>");
                        out.write("</div> </a>");
                    }
                %>            
            </div>
        </div> 

        <form action = "EventViewServlet" method = "get">
            <h1 class="hForm"> <%=request.getAttribute("name")%> </h1>
            <div class="eventForm">
                <span> Description: </span>
                <span> <%=request.getAttribute("description")%> </span>
                <br>
                <span> Date: </span>
                <span> <%=request.getAttribute("date")%> </span> 
                <br>
                <span> Price: </span>
                <span>  <%=request.getAttribute("price")%> </span>
                <br>
                <span> Category: </span>
                <span>  <%=request.getAttribute("category")%> </span> 
                <br>
                <span> Type: </span>
                <span>  <%=request.getAttribute("type")%> </span>
                <br>
                <span> Places: </span>
                <span>  <%=request.getAttribute("places")%> </span> 
                <br>
                <span> Author: </span>
                <span>  <%=request.getAttribute("author")%> </span> 
                <br>
                <span> Views: </span>
                <span>  <%=request.getAttribute("views")%> </span> 

            </div>
        </form>

        <%
            if (!(boolean) request.getAttribute("selling_ended") && existUser) {
                out.write("<form action=\"BuyTicketServlet\" method=\"post\">");
                out.write("<div class=\"wrapper\">");
                out.write("<select name=\"selection\">");
                List<String> numbers = (List<String>) request.getAttribute("availableSeats");
                for (String number : numbers) {
                    out.write("<option value=\"" + number + "\">" + number + "</option>");
                }
                out.write("</select>");
                out.write("<input type=\"submit\" class=\"buttonForm\" value=\"Buy Ticket\">");
                out.write("</div>");
                out.write("</form>");
            }
        %>


        <%
            EventDAO eventDAO = new EventDAOImpl();
            int eventID = 0;
            if (CookieUtil.getDataFromRequest("eventID", request, true) != null
                    && !CookieUtil.getDataFromRequest("eventID", request, true).isEmpty()) {
                eventID = Integer.parseInt(CookieUtil.getDataFromRequest("eventID", request, true));
            }

            int userID = 0;
            if (CookieUtil.getDataFromRequest("userIDCookie", request) != null
                    && !CookieUtil.getDataFromRequest("userIDCookie", request).isEmpty()) {
                userID = Integer.parseInt(CookieUtil.getDataFromRequest("userIDCookie", request));
            }

            int eventOwnerID = eventDAO.getEventOwner(eventID).getId();
            boolean isLegitToDelete = false;
            Event event = eventDAO.getEvent(eventID);
            int availableSeatsSize = event.getAvailablePlaces().size();
            int seats = event.getPlaces();
            if (availableSeatsSize == seats) {
                isLegitToDelete = true;
            }
            if (userID == eventOwnerID) {
                out.write("<form action=\"EventEditServlet\" method=\"post\">");
                out.write("<div class=\"wrapper\">");
                out.write("<input type=\"hidden\" name=\"actionType\" value=\"edit\">");
                out.write("<input type=\"submit\" name=\"button\" class=\"buttonForm\" value=\"Edit\">");
                out.write("</div>");
                out.write("</form>");
                if (isLegitToDelete) {
                    out.write("<form action=\"EventDeleteServlet\" method=\"post\">");
                    out.write("<div class=\"wrapper\">");
                    out.write("<input type=\"submit\" name=\"deletebutton\" class=\"btnform\" value=\"Delete\">");
                    out.write("</div>");
                    out.write("</form>");
                }

            }
        %>



    </div>
</body>
</html>
