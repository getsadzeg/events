<%@page import="java.lang.Integer"%>
<%@page import="ge.mziuri.dao.EventDAOImpl"%>
<%@page import="ge.mziuri.dao.EventDAO"%>
<%@page import="ge.mziuri.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.model.Event"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Events</title>
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
<!--
 <a href=\"Index.jsp\" class=\"btnform\"><div class=\"divBForm\">
 <h5>Log out</h5> 
 </div> </a>
-->

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


        <%            EventDAO eventDAO = new EventDAOImpl();
            /* if (request.getAttribute("user") != null) {
             User user = (User) request.getAttribute("user");
             out.write("logined user is: " + user.toString());
             }
             else out.write("user is null");
            
             if(request.getAttribute("id")!= null) {
             out.write("" + Integer.parseInt((String)request.getAttribute("id")));
             } */

            ArrayList<Event> events = (ArrayList<Event>) eventDAO.getAllEvents();
            int i = 0;
            for (Event event : events) {
                i++;
                if (i % 5 == 1) {
                    out.write("<div>");  }
                out.write("<a href=\"EventViewServlet?id=" + event.getId() + " \" class=\"DivLinkForm\"><div class=\"eventDForm\">");
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
