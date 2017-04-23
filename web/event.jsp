
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
                           out.write("userInf.jsp");
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
                %>            
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

        <form action="BuyTicketServlet" method="post">
            <div class="wrapper">
                <select name="selection">

                    <%
                        List<String> numbers = (List<String>) request.getAttribute("availableSeats");
                        for (String number : numbers) {
                            out.write("<option value=\"" + number + "\">" + number + "</option>");
                        }
                    %>
                </select>
                <input type="submit" class="buttonForm" value="Buy Ticket">   
            </div>
        </form>


        <%
            EventDAO eventDAO = new EventDAOImpl();
            int eventID = Integer.parseInt(CookieUtil.getCookieContent("eventIDCookie", request));
            int userID = Integer.parseInt(CookieUtil.getCookieContent("userIDCookie", request));
            int eventOwnerID = eventDAO.getEventOwner(eventID).getId();
             if (userID == eventOwnerID ) {
                out.write("<form action=\"EventEditServlet\" method=\"post\">");
                out.write("<div class=\"wrapper\">");
                out.write("<input type=\"hidden\" name=\"actionType\" value=\"edit\">");
                out.write("<input type=\"submit\" name=\"button\" class=\"buttonForm\" value=\"Edit\">");
                out.write("</div>");
                out.write("</form>");
            }
        %>
        


    </div>
</body>
</html>
