
<%@page import="ge.mziuri.model.Event"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
          <div class="div2Form"> 
            <a href="index.jsp" class="linkForm" >
                    Events
            </a> </div>
        
        <div  class="registerForm">
            <form <!-- action="AccountUpdateServlet" method="post"-->>
           სახელი: <input type="text" name="firstname" value="<%=request.getAttribute("name")%>"><br>
           გვარი: <input type="text" name="lastname" value="<%=request.getAttribute("surname")%>"><br>
           ბარათის კოდი: <input type="text" name="card" value="<%=request.getAttribute("cardcode")%>"> <br>
           ბარათის პასკოდი: <input type="password" name="passcode" value="<%=request.getAttribute("passcode")%>"> <br>
           ბარათის ვადა: <input type="date" name="expdate" value="<%=request.getAttribute("expdate")%>" <br>
           <input type="submit" value="განახლება"> 
           <a href="createE.jsp" class="btnform"><div> <h5> Create event </h5> </div> </a> 
 </form> 
<%
                        List<Event> events = (List<Event>)request.getAttribute("BoughtTicket");
                        for (Event event : events) {
                            out.write("<h4>" + event.getName() + "</h4>");
                            out.write("<h5>" + event.getDate() + "</h5>");
                           
                        } 
                    %>   
           
        </div>
    </body>
</html>
