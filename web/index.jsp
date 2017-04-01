<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.model.Event"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cinema</title>
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


        <div class="menuDiv">
            <div class="menuItem">
                <a href="sports.jsp" class="categForm" >
                    Sports
                </a> 
            </div> 

            <div class="menuItem">
                <a href="theater.jsp" class="categForm">
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
            if (request.getAttribute("events") != null) {
                ArrayList<Event> events = (ArrayList<Event>) request.getAttribute("events");
                int i = 0;
                for (Event event : events) {
                        i++;
                        out.write("<form formAction=\"eventViewEditServlet\" method=\"post\" class=\"FormDivLinkForm\">");
                        out.write("<a href=\"Event.jsp\" class=\"DivLinkForm\"><div class=\"eventDForm\">");
                        out.write("<h2>" + event.getName() + "</h2>");
                        out.write("<h3>" + event.getDesc() + "</h3>");
                        out.write("<input type=\"hidden\" value=\"view\">");
                        out.write("</div></a>");
                        if (i % 5 == 0) {
                            out.write("</div>");
                        }
                    }
                }

        %> 

    </body>
</html>
