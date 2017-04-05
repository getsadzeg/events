<%@page import="ge.mziuri.enums.Category"%>
<%@page import="ge.mziuri.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ge.mziuri.dao.EventDAOImpl"%>
<%@page import="ge.mziuri.dao.EventDAO"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.model.Event"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Parties</title>
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

        <div class="menuDiv">
            <div class="menuItem">
                <a href="sports.jsp" class="categForm" >
                    Sports
                </a> 
            </div> 

            <div class="menuItem">
                <a href="theatre.jsp" class="categForm">
                    Theater
                </a>
            </div>

            <div class="menuItem">
                <a href="cinema.jsp" class="categForm">
                    Cinema
                </a>
            </div>
            <div class="menuItem">
                <a href="party.jsp" class="categForm">
                    Party
                </a>
            </div>

            <div class="menuItem">
                <a href="concert.jsp" class="categForm">
                    Concert
                </a>
            </div>
        </div>

        <%
            EventDAO eventDAO = new EventDAOImpl();
            if (request.getAttribute("user") != null) {
                User user = (User) request.getAttribute("user");
                out.write("logined user is: " + user.toString());
            }
            
            ArrayList<Event> events = (ArrayList<Event>) eventDAO.getAllEvents(Category.PARTY);
            int i = 0;
            for (Event event : events) {
                i++;
                out.write("<form formAction=\"eventViewEditServlet\" method=\"post\" class=\"FormDivLinkForm\">");
                out.write("<a href=\"event.jsp\" class=\"DivLinkForm\"><div class=\"eventDForm\">");
                out.write("<h2>" + event.getName() + "</h2>");
                out.write("<h3>" + event.getDesc() + "</h3>");
                out.write("<input type=\"hidden\" value=\"view\">");
                out.write("</div></a>");
                if (i % 5 == 0) {
                    out.write("</div>");
                }
            }

        %>  


    </body>
</html>
