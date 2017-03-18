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
        
          <div class="divForm"> 
            <a href="index.jsp" class="linkForm" >
                    Events
                </a> 
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
                   List<Event> events = (List<Event>)request.getAttribute("events");
                   for (Event event : events) {
                       out.write("<form formAction=\"eventViewEditServlet\" method=\"post\">");
                       out.write("<a href=\"Event.jsp\" class=\"DivLinkForm\"><div class=\"eventDForm\">");
                       out.write("<h2>" + event.getName() + "</h2>");
                       out.write("<h3>" + event.getDesc() + "</h3>");
                       out.write("<input type=\"hidden\" value=\"view\">");
                       out.write("</div></a>");
                   }
                          
                 %>  
        
        
    </body>
</html>
