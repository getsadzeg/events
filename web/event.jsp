
<%@page import="ge.mziuri.dao.EventDAOImpl"%>
<%@page import="ge.mziuri.dao.EventDAO"%>
<%@page import="ge.mziuri.util.CookieUtil"%>
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
                <a href="index.jsp" class="linkForm" >
                    Events
                </a> </div>

            <div class="DivTform"> 
                <a href="login.jsp" class="btnform"><div class="divBForm"> 
                        <h5> Login </h5>
                    </div> </a>

                <a href="register.jsp" class="btnform" ><div class="divBForm"> 
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
            if (userID == eventDAO.getEventOwner(eventID).getId()) {
                out.write("<form action=\"EventEditServlet\" method=\"post\">");
                out.write("<div class=\"wrapper\">");
                out.write("<input type=\"hidden\" name=\"actionType\" value=\"edit\">");
                out.write("<input type=\"hidden\" name=\"actionType\" value=\"edit\">");
                out.write("<input type=\"submit\" name=\"button\" class=\"buttonForm\" value=\"Edit\">");
                out.write("<input type=\"submit\" name=\"button\" class=\"buttonForm\" value=\"Edit\">");
                out.write("<input type=\"submit\" name=\"button\" class=\"buttonForm\" value=\"Edit\">");
                out.write("</div>");
                out.write("</form>");
            }
        %>
        


    </div>
</body>
</html>
